<!DOCTYPE html>

<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <html lang="en">

    <head>
       <%@include file="common/header.jspf" %>
        <title>My Todo List</title>
    </head>

    <body>
        <%@include file="common/navbar.jspf" %>
        <div class="container">
            <h1>Welcome ${name}</h1>
            <h2>Your Todos are</h2>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Description</th>
                        <th scope="col">Target Date</th>
                        <th>Is Done?</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${ empty todos}">
                        <tr>
                            <td colspan="4">No Todos Found</td>
                        </tr>
                    </c:if>
                    <c:forEach items="${todos}" var="todo">
                        <tr>
                            <th scope="row">${todo.id}</th>
                            <td>${todo.description}</td>
                            <td>${todo.targetDate}</td>
                            <td>
                                ${todo.done}
                            </td>
                            <td>
                                <div style="display: flex; gap: 20px;">

                                    <c:if test="${todo.done eq 'No'}">
                                        <form action="/mark-done" method="POST">
                                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                            <input type="number" name="id" id="id" value="${todo.id}" hidden>
                                            <button type="submit" class="btn btn-success">Mark as Done</button>
                                        </form>
                                      </c:if>
                                    <form action="/delete" method="POST">
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                        <input type="number" name="id" id="id" value="${todo.id}" hidden>
                                        <button type="submit" class="btn btn-danger">Delete</button>
                                    </form>
                                </div>
                                
                            </td>
                           
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <a href="/add-todo" class="btn btn-primary">Add Todo</a>

        </div>


        <%@include file="common/footer.jspf" %>