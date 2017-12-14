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

    <title>Создание нового объявления</title>
</head>
<body>

<div class="container">
    <h1>
        Новое объявление
    <span class="pull-right">
                <a href="/user" title="Личный каибbнет"><span class="user">${user.name}</span></a>
                    <a href="/logout"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></a>
                </span></h1>
    <div class="float-form form-wide panel panel-default">
        <div class="panel-body">
            <c:if test="${!empty errors}">
                <div class="row">
                    <ul class="col-sm-offset-3">

                            <li class="text-danger">${errors}</li>

                    </ul>
                </div>
            </c:if>
            <form class="form-horizontal" action="/createoffer" method="post">
                <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                <div class="form-group">
                    <label for="header" class="col-sm-3 control-label">Заголовок</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="header" name="header" placeholder="Заголовок" value="${value}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="description" class="col-sm-3 control-label">Описание</label>
                    <div class="col-sm-9">
                        <textarea class="form-control" rows="10" cols="45" id="description" name="description" placeholder="Описание" value="${value}"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="price" class="col-sm-3 control-label">Цена</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="price" name="price" placeholder="Цена(в гривнах)">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <button type="submit" class="btn btn-primary">Добавить объявление</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

</body>
</html>