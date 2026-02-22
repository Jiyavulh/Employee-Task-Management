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

@WebServlet("/verifyEmail")
public class EmailVerification extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String employeeEmail = req.getParameter("employee-email");

        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee =employeeDao.findEmployeeByEmail(employeeEmail);

        PrintWriter pw = resp.getWriter();

        if (employee != null) {
            pw.print("<h1>EMAIL VERIFIED SUCCESSFULLY</h1>");

            HttpSession session = req.getSession();
            session.setAttribute("employeeId", employee.getEmployeeId());

            RequestDispatcher rd =
                    req.getRequestDispatcher("takeNewPassword.html");
            rd.include(req, resp);
        } else {
            pw.print("<h1>INVALID EMAIL ID</h1>");
        }
    }
}
