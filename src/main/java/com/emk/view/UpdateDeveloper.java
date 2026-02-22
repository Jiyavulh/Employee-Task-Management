package com.emk.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etm.dao.EmployeeDao;
import com.etm.entity.Employee;

@WebServlet("/updateDeveloper")
public class UpdateDeveloper extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        int developerId = (int) session.getAttribute("developerId");
        String option = (String) session.getAttribute("option");

        EmployeeDao dao = new EmployeeDao();
        Employee employee = dao.findEmployeeById(developerId);

        if (option.equals("Name")) {
            String newName = req.getParameter("newName");
            employee.setEmployeeName(newName);
        }
        else if (option.equals("Email")) {
            String newEmail = req.getParameter("newEmail");
            employee.setEmail(newEmail);
        }
        else if (option.equals("PhoneNumber")) {
            long newPhone =
                Long.parseLong(req.getParameter("newPhoneNumber"));
            employee.setPhoneNumber(newPhone);
        }

        dao.updateEmployee(employee);

        PrintWriter pw = resp.getWriter();
        pw.print("<h1>Developer Updated Successfully</h1>");
    }
}
