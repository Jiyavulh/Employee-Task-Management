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

@WebServlet("/updatePassword")
public class PasswordUpdation extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String newPassword = req.getParameter("employee-password");

        HttpSession session = req.getSession(false);
        int employeeId = (int) session.getAttribute("employeeId");

        EmployeeDao dao = new EmployeeDao();
        Employee employee = dao.findEmployeeById(employeeId);

        employee.setPassword(newPassword);
        dao.updateEmployee(employee);

        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<h1>Password Updated</h1>");

        RequestDispatcher rd =req.getRequestDispatcher("login.html");
        rd.include(req, resp);
    }
}
