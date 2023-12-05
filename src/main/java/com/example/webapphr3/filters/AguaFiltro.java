package com.example.webapphr3.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebFilter(filterName = "MiFiltro",servletNames = {"LocationServlet", "DepartmentServlet", "CountryServlet",
        "JobServlet"})
public class AguaFiltro implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("AguaFiltro");
        chain.doFilter(request, response);
    }
}