package com.example.webapphr3.filters;

import com.example.webapphr3.Beans.Employee;
import com.example.webapphr3.Daos.DepartmentDao;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;


public class CountryFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        DepartmentDao departmentDao = new DepartmentDao();

        HttpSession session = httpRequest.getSession(false);

        if (session != null && session.getAttribute("employee") != null) {
            Employee employee = (Employee) session.getAttribute("employee");

            String region = String.valueOf(employee.getDepartment().getLocation().getCountry().getRegionId());
            if ("Europe".equals(region) || "Americas".equals(region)) {
                BigDecimal userSalary = employee.getSalary();
                BigDecimal maxDepartmentSalary = departmentDao.obtenerSalarioMaximoPorDepartamento(employee.getDepartment().getDepartmentName());

                if (userSalary.equals(maxDepartmentSalary)) {
                    chain.doFilter(request, response);
                } else {
                    httpResponse.sendRedirect("/errorPage.html");
                }
            } else {
                httpResponse.sendRedirect("/errorPage.html");
            }
        } else {
            httpResponse.sendRedirect("/login.html");
        }
    }

}
