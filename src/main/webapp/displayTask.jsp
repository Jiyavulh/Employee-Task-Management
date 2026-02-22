<%@ page import="java.util.List" %>
<%@ page import="com.etm.entity.Task" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task Details</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(to right, #141e30, #243b55);
        margin: 0;
        padding: 30px;
    }

    h2 {
        text-align: center;
        color: white;
        margin-bottom: 30px;
    }

    .container {
        background: white;
        padding: 20px;
        width: 80%;
        margin: auto;
        border-radius: 10px;
        box-shadow: 0 8px 20px rgba(0,0,0,0.2);
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    table, th, td {
        border: 1px solid #ccc;
    }

    th {
        background: #243b55;
        color: white;
        padding: 10px;
    }

    td {
        padding: 10px;
        text-align: center;
    }
</style>

</head>
<body>

<h2>Task Details</h2>

<div class="container">
<table>
    <tr>
        <th>Task ID</th>
        <th>Task Name</th>
        <th>Duration</th>
        <th>Status</th>
    </tr>

<%
    List<Task> list =
        (List<Task>) request.getAttribute("taskData");

    if (list != null) {
        for (Task task : list) {
%>
    <tr>
        <td><%= task.getTaskId() %></td>
        <td><%= task.getTaskName() %></td>
        <td><%= task.getDuration() %></td>
        <td><%= task.getStatus() %></td>
    </tr>
<%
        }
    }
%>

</table>
</div>

</body>
</html>