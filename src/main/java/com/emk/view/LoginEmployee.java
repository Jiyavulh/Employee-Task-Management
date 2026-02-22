package com.emk.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etm.dao.EmployeeDao;
import com.etm.entity.Employee;

@WebServlet("/login")
public class LoginEmployee extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String employeeEmail = req.getParameter("employee-email");
        String employeePassword = req.getParameter("employee-password");

        EmployeeDao employeeDao = new EmployeeDao();
        Employee dbEmployee =
            employeeDao.findEmployeeByEmailAndPassword(employeeEmail, employeePassword);

        PrintWriter pw = resp.getWriter();

        if (dbEmployee != null) {

            String role = dbEmployee.getRole();

            if (role.equals("manager")) {

                pw.print("<h1>Manager Login Success</h1>");
                RequestDispatcher rd =
                    req.getRequestDispatcher("manager.html");
                rd.include(req, resp);

            } else if (role.equals("developer")) {

                
                HttpSession session = req.getSession();
                session.setAttribute("developerId",
                        dbEmployee.getEmployeeId());

                pw.print("<h1>Developer Login Success</h1>");
                RequestDispatcher rd =
                    req.getRequestDispatcher("developer.html");
                rd.include(req, resp);
            }

        } else {
            pw.print("<h1>Login Failure</h1>");
        }
    }
}
