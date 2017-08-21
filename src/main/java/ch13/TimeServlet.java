package ch13;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Date;
import java.util.Map;

/**
 * Created by Alex on 19/08/2017.
 */
public class TimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        StringBuilder responseStringBuilder = new StringBuilder();
        responseStringBuilder.append("<html>");
        responseStringBuilder.append("<head>");
        responseStringBuilder.append("<title>Time server response</title>");
        responseStringBuilder.append("<body>");
        responseStringBuilder.append("<p>Server time:").append(new Date().toString()).append("</p>");
        responseStringBuilder.append("/<body>");
        responseStringBuilder.append("/<head>");
        responseStringBuilder.append("/<html>");

        //get response output stream
        PrintWriter writer = resp.getWriter();
        writer.print(responseStringBuilder.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
