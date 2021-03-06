<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/styles.css" />

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootbox.js/4.4.0/bootbox.min.js"></script>

    <script src="/js/script.js"></script>

    <title>Главная страница</title>
</head>
<body>
    <div  class = "container">
        <h1 class="page-header">
            Users
            <span class="pull-right">
                <a href="/user" title="Личный каибbнет"><span class="user">${user.name}</span></a>
                    <a href="/logout"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></a>
                </span>
        </h1>
        <div class="container-fluid controls-bar">
            <div class="row">
                <table class="table table-bordered">
                    <tr>
                        <td>ID</td>
                        <td>Username</td>
                        <td>Email</td>
                        <td>Password</td>
                    </tr>
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.email}</td>
                            <td>${user.password}</td>

                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
    <div class="modal fade modal-md" role="dialog" id="employeeEditModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Edit User</h4>
                </div>
                <div class="modal-body">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary">Save changes</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
