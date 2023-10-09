<!DOCTYPE html>
<html>
<head>
    <title>Preview Page</title>
</head>
<body>
<h2>Student Information:</h2>
<c:if test="${not empty student}">
    <p>Full Name: ${student.fullName}</p>
    <p>Email: ${student.email}</p>
    <p>Phone: ${student.phone}</p>
    <p>Parent: ${student.parent}</p>
    <p>Date of Birth: ${student.dob}</p>
    <p>Parent's Phone: ${student.parPhone}</p>
    <p>Major: ${student.major}</p>
    <p>How you know AUCA: ${student.invite}</p>

    <c:if test="${not empty student.like}">
        <p>How you like AUCA:
            <c:forEach items="${student.like}" var="like">
                ${like},
            </c:forEach>
        </p>
    </c:if>

    <p>Additional comments: ${student.message}</p>
</c:if>
</body>
</html>
