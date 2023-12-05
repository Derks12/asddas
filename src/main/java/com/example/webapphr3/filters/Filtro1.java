package com.example.webapphr3.filters;

import com.example.webapphr3.Beans.Employee;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(servletNames = {"LocationServlet", "DepartmentServlet", "CountryServlet",
        "JobServlet", "EmployeeServlet"})
public class Filtro1 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Filtro1");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        Employee em = (Employee) session.getAttribute("employee");

        if (em == null) {
            response.sendRedirect(request.getContextPath());
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
