<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:if test="${!ajaxRequest}">
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>用户登录</title>
        <link href="<c:url value="/resources/form.css" />" rel="stylesheet"  type="text/css" />
        <script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
    </head>
    <body>
</c:if>

<div id="formsContent">
<form:form id="form" method="post" modelAttribute="userInfo" cssClass="cleanform">
    <div class="header">
        <h2>登录表单</h2>
        <c:if test="${not empty message}">
            <div id="message" class="success">${message}</div>
        </c:if>
        <s:bind path="*">
            <c:if test="${status.error}">
                <div id="message" class="error">Form has errors</div>
            </c:if>
        </s:bind>
    </div>
    <fieldset>
        <legend>账号信息</legend>
        <form:label path="userName">
            账号:<form:errors path="userName" cssClass="error" />
        </form:label>
        <form:input path="userName" />

        <form:label path="userPassword">
            密码:<form:errors path="userPassword" cssClass="error" />
        </form:label>
        <form:password path="userPassword" cssClass="normal" cssErrorClass="error"/>

    </fieldset>

    <p><button type="submit">登录</button></p>
</form:form>
<script type="text/javascript">
    $(document).ready(function() {
        $("#form").submit(function() {
            $.post($(this).attr("action"), $(this).serialize(), function(html) {
                $("#formsContent").replaceWith(html);
                $('html, body').animate({ scrollTop: $("#message").offset().top }, 500);
            });
            return false;
        });
    });
</script>
</div>

<c:if test="${!ajaxRequest}">
    </body>
    </html>
</c:if>