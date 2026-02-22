package com.emk.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etm.dao.EmployeeDao;
import com.etm.entity.Employee;

@WebServlet("/addDeveloper")
public class AddDeveloper extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("employee-name");
        String email = req.getParameter("employee-email");
        String password = req.getParameter("employee-password");
        String employeePhoneNumber = req.getParameter("employee-phonenumber");
        String employeeSalary = req.getParameter("employee-salary");

        long employeePhoneNumberLong = Long.parseLong(employeePhoneNumber);
        double employeeSalaryDouble = Double.parseDouble(employeeSalary);

        Employee employee = new Employee();
        employee.setEmployeeName(name);
        employee.setEmail(email);
        employee.setPassword(password);
        employee.setPhoneNumber(employeePhoneNumberLong);
        employee.setSalary(employeeSalaryDouble);
        employee.setRole("developer");

        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.saveEmployee(employee);

        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<h1>Developer Added Successfully</h1>");

        RequestDispatcher rd =
                req.getRequestDispatcher("manager.html");
        rd.include(req, resp);
    }
}
