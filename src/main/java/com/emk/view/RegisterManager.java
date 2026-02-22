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
@WebServlet("/register")
public class RegisterManager extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//read data from form
		String employeeName=req.getParameter("employee-name");
		String employeeEmail=req.getParameter("employee-email");
		String employeePassword=req.getParameter("employee-password");
		String employeePhoneNumber=req.getParameter("employee-phonenumber");
		String employeeSalary=req.getParameter("employee-salary");
		
		//conversion-Parsing
		
		long employeePhoneNumberLong=Long.parseLong(employeePhoneNumber);
		double employeeSalaryDouble=Double.parseDouble(employeeSalary);
		
		
		//set it to employee object
		
		Employee employee =new Employee();
	    employee.setEmail(employeeEmail);
	    employee.setEmployeeName(employeeName);
	    employee.setPassword(employeePassword);
	    employee.setPhoneNumber(employeePhoneNumberLong);
	    employee.setSalary(employeeSalaryDouble);
	    employee.setRole("manager");
	    
	    EmployeeDao employeeDao=new EmployeeDao();
	    employeeDao.saveEmployee(employee);
	    
	    PrintWriter printWriter=resp.getWriter();
	    printWriter.print("<h1>Manager Data Stored!...</h1>");
	}

}
