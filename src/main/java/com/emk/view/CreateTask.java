package com.emk.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etm.dao.TaskDao;
import com.etm.entity.Status;
import com.etm.entity.Task;
@WebServlet("/createTask")
public class CreateTask extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String taskName=req.getParameter("task-name");
		int duration=Integer.parseInt(req.getParameter("duration"));
		
		Task task=new Task();
		task.setDuration(duration);
		task.setTaskName(taskName);
		task.setStatus(Status.CREATED);
		
		TaskDao taskDao=new TaskDao();
		taskDao.saveTask(task);
		
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("<h1>Task Created!...</h1>");
	}
}
