<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/bootstrap.min.css">
    <title>Todo List</title>
</head>
<body>

    <div class="container">
        <h1> Welcome ${name}</h1>
        <div>Your Todos are</div>
        <button class="btn-primary">Hello</button>
         <c:forEach items="${todos}" var="todo">
              <div>${todo}</div>
         </c:forEach>
    </div>

   

    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>