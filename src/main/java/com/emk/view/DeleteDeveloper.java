package com.emk.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etm.dao.EmployeeDao;
import com.etm.entity.Employee;

@WebServlet("/deleteDeveloper")
public class DeleteDeveloper extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int employeeId =Integer.parseInt(req.getParameter("employee-id"));

        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee =employeeDao.findEmployeeById(employeeId);

        PrintWriter printWriter = resp.getWriter();

        if (employee != null &&employee.getRole().equals("developer")) {

            employeeDao.deleteEmployee(employee);
            printWriter.print("<h1>Developer Deleted Successfully</h1>");

        } else {
        	printWriter.print("<h1>Invalid Developer ID</h1>");
        }
    }
}
