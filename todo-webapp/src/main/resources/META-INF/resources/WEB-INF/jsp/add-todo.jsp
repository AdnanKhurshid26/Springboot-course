<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


    <html lang="en">

    <head>
       <%@include file="common/header.jspf" %>
        <title>Add Todo</title>
    </head>

    <body>

      <%@include file="common/navbar.jspf" %>

        <div class="container">
            <h1>Add Todo Details</h1>
            
            <form action="/add-todo"  method="POST" style="width: 50%;">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="mb-3">
                    <label for="description" class="form-label">Todo Description</label>
                    <input type="text" class="form-control" id="description" name="description" required>
                    <label for="date" class="form-label">Target Date</label>
                    <input type="date" class="form-control" name="date" id="date" >
                </div>
                
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>

            

        </div>


        <%@include file="common/footer.jspf" %>