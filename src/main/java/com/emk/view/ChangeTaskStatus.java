package com.emk.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etm.dao.TaskDao;
import com.etm.entity.Status;
import com.etm.entity.Task;

@WebServlet("/changeTaskStatus")
public class ChangeTaskStatus extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

       
        int taskId = Integer.parseInt(req.getParameter("taskId"));

        
        TaskDao taskDao = new TaskDao();
        Task task = taskDao.findTaskById(taskId);

        if (task != null) {

            
            task.setStatus(Status.COMPLETED);

           
            taskDao.updateTask(task);

            resp.getWriter().print("<h1>Task Status Updated</h1>");
        } else {
            resp.getWriter().print("<h1>Invalid Task ID</h1>");
        }
    }
}
