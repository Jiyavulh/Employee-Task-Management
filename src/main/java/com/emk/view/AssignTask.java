package com.emk.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etm.dao.EmployeeDao;
import com.etm.dao.TaskDao;
import com.etm.entity.Employee;
import com.etm.entity.Status;
import com.etm.entity.Task;
@WebServlet("/assignTask")
public class AssignTask extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int developerId=Integer.parseInt(req.getParameter("developer-id"));
		int taskId=Integer.parseInt(req.getParameter("task-id"));
		
		//fetch both object
		EmployeeDao employeeDao=new EmployeeDao();
		Employee dbEmployee=employeeDao.findEmployeeById(developerId);
		
		TaskDao taskDao=new TaskDao();
		Task dbTask =taskDao.findTaskById(taskId);
		dbTask.setStatus(Status.ASSIGNED);
		
		//set the task to the empliyee
		//fetch old list of task for the employee
		
		List<Task> taskList =dbEmployee.getTasks();
		if(taskList==null)
		{
			taskList=new ArrayList<Task>();
			
		}
		//add current task to list 
		taskList.add(dbTask);
		
		//set the list to employee
		dbEmployee.setTasks(taskList);
		
		//update employee
		employeeDao.updateEmployee(dbEmployee);
		
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("<h1>Task Assigned!..</h1>");
	}
}
