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

@WebServlet("/viewDeveloper")
public class DisplayAllDevelopers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        EmployeeDao employeeDao = new EmployeeDao();

        List<Employee> allDeveloper =
                employeeDao.findAllDeveloper();

        req.setAttribute("allData", allDeveloper);

        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("displayDeveloper.jsp");
        requestDispatcher.forward(req, resp);
    }
}


