package com.emk.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etm.dao.EmployeeDao;
import com.etm.entity.Employee;
import com.etm.entity.Task;

@WebServlet("/viewTask")
public class ViewTask extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int employeeId =
            Integer.parseInt(req.getParameter("employee-id"));

        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee =
            employeeDao.findEmployeeById(employeeId);

        if (employee != null) {

            // instruction: employee → tasks
            List<Task> taskList = employee.getTasks();

            // instruction: setAttribute
            req.setAttribute("taskData", taskList);

            // instruction: forward
            RequestDispatcher rd =
                req.getRequestDispatcher("displayTask.jsp");
            rd.forward(req, resp);

        } else {
            resp.getWriter().print("<h1>Invalid Employee ID</h1>");
        }
    }
}
