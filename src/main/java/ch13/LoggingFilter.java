package ch13;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Alex on 19/08/2017.
 */
public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //do nothing
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.print("Request received at ");
        System.out.print(new Date().toString());
        System.out.print(" from ");
        System.out.print(servletRequest.getProtocol());
        System.out.print("://");
        System.out.print(servletRequest.getRemoteHost());
        System.out.print(":");
        System.out.print(servletRequest.getLocalPort());
        System.out.print("/");
        System.out.print(servletRequest.getServletContext());
        System.out.println("");
        //go to next filter
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        //do nothing
    }
}
