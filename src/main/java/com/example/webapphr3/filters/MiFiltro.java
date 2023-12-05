package com.example.webapphr3.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebFilter(filterName = "MiFiltro",servletNames = {"LocationServlet", "DepartmentServlet", "CountryServlet",
        "JobServlet", "EmployeeServlet"})
public class MiFiltro implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("MiFiltro");
        chain.doFilter(request, response);
    }
}

//public interface PruebaListener{
//    String metodoA();
//}

//public class Estudiante{
//    public void ejemplo(PruebaListener p){
//        System.out.println(p.metodoA());
//    }
//}


//public class Main{
//    public static void main(String[] args){

//        PruebaListener p = new PruebaListener() {
//            @Override
//            public String metodoA() {
//                return "Metodo A";
//            }
//        };
//        Estudiante e = new Estudiante();
//        e.ejemplo(p);
//    }
//}
