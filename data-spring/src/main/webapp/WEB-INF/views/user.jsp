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

    <title>Личный кабинет</title>
</head>
<body>
<div  class = "container">
    <h1 class="page-header">
        Личный кабинет: ${user.name}
        <span class="pull-right">
                    <a href="/logout"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></a>
                </span>
    </h1>
    <div class="container-fluid controls-bar">
        <div class="row">
            <p>Адрес электронной почты: ${user.email}</p>
        </div>
        <div class="row">
            <a href="/offers">Объявления</a>
            <a href="/createoffer">Новое объявление</a>
        </div>
    </div>
</div>
</body>
</html>