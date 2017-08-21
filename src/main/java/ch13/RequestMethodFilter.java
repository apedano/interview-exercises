package ch13;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alex on 20/08/2017.
 */
public class RequestMethodFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //do nothing
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Applying Request method filter...");
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        if(!httpRequest.getMethod().equalsIgnoreCase("GET")){
            System.out.println("Wrong Request method. Sending error 400 [BAD REQUEST] to client...");
            ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            System.out.println("Request method accepted. Continuing filter chain...");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        //do nothing
    }
}
