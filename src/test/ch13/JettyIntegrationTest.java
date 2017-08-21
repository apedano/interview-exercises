package ch13;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.h2.util.IOUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


import javax.servlet.DispatcherType;
import java.io.*;
import java.util.EnumSet;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alex on 19/08/2017.
 */
public class JettyIntegrationTest {

    private static final int SERVER_PORT = 8081;

    private static Server jettyServer;

    @BeforeClass
    public static void setupServer() throws Exception {
        jettyServer = new Server(SERVER_PORT);
        ServletHandler servletHandler = new ServletHandler();
        jettyServer.setHandler(servletHandler);
        //add servlet to handler and mapping like web.xml
        servletHandler.addServletWithMapping(TimeServlet.class, "/time/*");
        //add filter to servlet with mapping
        servletHandler.addFilterWithMapping(LoggingFilter.class, "/*",
                EnumSet.of(DispatcherType.REQUEST));
        //TODO: try to add another filter and verify filter chain
        jettyServer.start();
    }

    @Test
    public void testGetRequest() throws UnsupportedEncodingException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost postReq = new HttpPost(String.format("http://localhost:%d/time/", SERVER_PORT));
        String reqBody = "Hello World!";
        postReq.setEntity(new StringEntity(reqBody));

        //send request to jettyServer
        try {
            HttpResponse response = httpClient.execute(postReq);
            int responseStatus = response.getStatusLine().getStatusCode();
            InputStream responseStream = response.getEntity().getContent();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            IOUtils.copy(responseStream, byteArrayOutputStream);
            String receivedBody = byteArrayOutputStream.toString();
            assertEquals(200, responseStatus);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @AfterClass
    public static void shutdownServer() throws Exception {
        jettyServer.stop();
    }


}
