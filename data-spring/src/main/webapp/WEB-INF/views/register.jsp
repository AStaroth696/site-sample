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

    <title>Регистрация нового пользователя</title>
</head>
<body>
<div class="container">
    <div class="float-form form-wide panel panel-default">
        <div class="panel-heading"><h3>Регистрация</h3></div>
        <div class="panel-body">
            <c:if test="${!empty errors}">
                <div class="row">
                    <ul class="col-sm-offset-3">
                        <c:forEach var="error" items="${errors}">
                            <li class="text-danger">${errors}</li>
                        </c:forEach>
                    </ul>
                </div>
            </c:if>
            <form class="form-horizontal" action="/register" method="post">
                <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                <div class="form-group">
                    <label for="name" class="col-sm-3 control-label">Имя пользователя</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="name" name="name" placeholder="Имя пользователя" value="${value}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">Электронная почта</label>
                    <div class="col-sm-9">
                        <input type="email" class="form-control" id="email" name="email" placeholder="Электронная почта" value="${value}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">Пароль</label>
                    <div class="col-sm-9">
                        <input type="password" class="form-control" id="password" name="password" placeholder="Пароль">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password-confirm" class="col-sm-3 control-label">Повторите пароль</label>
                    <div class="col-sm-9">
                        <input type="password" class="form-control" id="password-confirm" name="passwordConfirm"
                               placeholder="Повторите пароль">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <button type="submit" class="btn btn-primary">Зарегистрироваться</button>
                        <a class="register" href="/login">Вход</a>
                    </div>
                </div>
            </form>
        </div>
    </div>

</body>
</html>