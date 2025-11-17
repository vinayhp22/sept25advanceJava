<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students Dashboard</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f6f9;
        margin: 0;
        padding: 0;
    }

    /* Header */
    .header {
        background: #004aad;
        color: white;
        padding: 15px 20px;
        font-size: 24px;
        font-weight: bold;
    }

    /* Footer */
    .footer {
        background: #222;
        color: #ddd;
        padding: 10px;
        text-align: center;
        margin-top: 40px;
        font-size: 14px;
    }

    /* Content box */
    .container {
        width: 90%;
        margin: 30px auto;
        background: white;
        padding: 20px 30px;
        border-radius: 8px;
        box-shadow: 0px 2px 10px #ccc;
    }

    /* Add Button */
    .btn-add {
        background: #28a745;
        color: white;
        padding: 10px 15px;
        text-decoration: none;
        border-radius: 5px;
        font-weight: bold;
    }
    .btn-add:hover {
        background: #218838;
    }

    /* Table */
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }
    th {
        background: #004aad;
        color: white;
        padding: 10px;
        text-align: left;
    }
    td {
        padding: 10px;
        border-bottom: 1px solid #ddd;
    }

    tr:hover {
        background: #f1f1f1;
    }

    /* Action buttons */
    .btn-edit {
        background: #ffc107;
        color: black;
        padding: 6px 10px;
        text-decoration: none;
        border-radius: 4px;
        margin-right: 10px;
    }
    .btn-edit:hover {
        background: #e0a800;
    }

    .btn-delete {
        background: #dc3545;
        color: white;
        padding: 6px 10px;
        text-decoration: none;
        border-radius: 4px;
    }
    .btn-delete:hover {
        background: #c82333;
    }
</style>

</head>
<body>

    <!-- Header -->
    <div class="header">
        Student Management System
    </div>

    <!-- Content -->
    <div class="container">

        <h2>Students List</h2>

        <a class="btn-add" href="showForm">+ Add New Student</a>

        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Mobile</th>
                <th>Course</th>
                <th>Actions</th>
            </tr>

            <c:forEach var="s" items="${students}">
            <tr>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.mobile}</td>
                <td>${s.course}</td>
                <td>
                    <a class="btn-edit" href="update?id=${s.id}">Edit</a>
                    <a class="btn-delete" href="delete?id=${s.id}">Delete</a>
                </td>
            </tr>
            </c:forEach>

        </table>
    </div>

    <!-- Footer -->
    <div class="footer">
        © 2025 Student Management Portal | All Rights Reserved
    </div>

</body>
</html>
