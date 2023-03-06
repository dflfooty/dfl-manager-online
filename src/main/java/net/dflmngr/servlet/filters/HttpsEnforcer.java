package net.dflmngr.servlet.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import net.dflmngr.ProductionConditional;

@Component
@Conditional(ProductionConditional.class)
public class HttpsEnforcer implements Filter {

    public static final String X_FORWARDED_PROTO = "x-forwarded-proto";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getHeader(X_FORWARDED_PROTO) != null) {
            if (request.getHeader(X_FORWARDED_PROTO).indexOf("https") != 0) {
                response.sendRedirect("https://" + request.getServerName() + (request.getPathInfo() == null ? "" : request.getPathInfo()));
                return;
            }
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}

