<%@ page import="java.util.List" %>
<%@ page import="com.etm.entity.Employee" %>
<%@ page import="com.etm.entity.Task" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Developers</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(to right, #2c3e50, #4ca1af);
        margin: 0;
        padding: 30px;
    }

    h2 {
        text-align: center;
        color: white;
        margin-bottom: 30px;
    }

    .card {
        background: white;
        padding: 20px;
        margin: 20px auto;
        width: 80%;
        border-radius: 10px;
        box-shadow: 0 8px 20px rgba(0,0,0,0.2);
    }

    .emp-details {
        font-size: 16px;
        font-weight: bold;
        margin-bottom: 10px;
        color: #333;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 10px;
    }

    table, th, td {
        border: 1px solid #ccc;
    }

    th {
        background: #2c3e50;
        color: white;
        padding: 8px;
    }

    td {
        padding: 8px;
        text-align: center;
    }
</style>

</head>
<body>

<h2>View All Developers</h2>

<%
    List<Employee> list =
        (List<Employee>) request.getAttribute("allData");

    for (Employee employee : list) {
%>

<div class="card">
    <div class="emp-details">
        ID: <%= employee.getEmployeeId() %> |
        Name: <%= employee.getEmployeeName() %> |
        Email: <%= employee.getEmail() %> |
        Phone: <%= employee.getPhoneNumber() %> |
        Salary: <%= employee.getSalary() %>
    </div>

    <table>
        <tr>
            <th>Task ID</th>
            <th>Task Name</th>
            <th>Duration</th>
        </tr>

<%
        List<Task> taskList = employee.getTasks();
        if (taskList != null) {
            for (Task task : taskList) {
%>
        <tr>
            <td><%= task.getTaskId() %></td>
            <td><%= task.getTaskName() %></td>
            <td><%= task.getDuration() %></td>
        </tr>
<%
            }
        }
%>
    </table>
</div>

<%
    }
%>

</body>
</html>