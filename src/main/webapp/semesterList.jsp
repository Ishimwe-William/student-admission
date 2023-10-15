<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Semester List</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1>Semester List</h1>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="semester" items="${semesters}">
        <tr>
            <td>${semester.name}</td>
            <td>${semester.start_date}</td>
            <td>${semester.end_date}</td>
            <td>
                <a href="/semesterServlet?action=edit&semester_id=${semester.semester_id}">Edit</a>
                <a href="/semesterServlet?action=delete&semester_id=${semester.semester_id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/semesterServlet?action=create">Create New Semester</a></a><br/><br/>
<jsp:include page="footer.html"/>
</body>
</html>
