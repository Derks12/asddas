package com.example.webapphr3.filters;
import com.example.webapphr3.Beans.Employee;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/EmployeeServlet")
public class JobFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        HttpSession session = httpRequest.getSession(false);

        if (session != null && session.getAttribute("employee") != null) {
            Employee employee = (Employee) session.getAttribute("employee");

            String job_id = employee.getJob().getJobId();
            if ("AD_PRES".equals(job_id) || "AD_VP".equals(job_id) || "FI_MGR".equals(job_id)) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                httpResponse.sendRedirect("/errorPage.html");
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
