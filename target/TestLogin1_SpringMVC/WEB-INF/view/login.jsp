<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>


<div class="login-container d-flex align-items-center justify-content-center" style="margin-top: 5%;">

<form:form  class="login-form border border-primary text-center rounded-pill shadow-lg p-3 mb-5 bg-white rounded"
            action="loginSuccess" method="post" modelAttribute="userCredential" style="max-width: 100%; width: 370px; padding: 15px;">
    <form:errors path="*" cssClass="alert alert-danger" element="div" />
    <h2>Login</h2>
    <div class="form-group">
        <form:input path="email"  type="email" name="email" class="form-control rounded-pill form-control-lg" placeholder="Email..."/>
        <form:errors path="email" cssClass="text-danger"/>
    </div>
    <div class="form-group">
        <form:input path="password" type="password"  name="password" id="password" data-toggle="password" class="form-control rounded-pill form-control-lg" placeholder="Password..."/>
        <form:errors path="password" cssClass="text-danger"/>
    </div>
    <div class="forgot-link">
        <div class="form-check">
            <input type="checkbox" class="form-check-input" id="remember">
            <label for="remember">Ricorda la password</label>
        </div>
        <a href="#">Password dimenticata?</a>
    </div>
    <button type="submit" class="btn btn-dark btn-block rounded-pill btn-lg" style="margin-top: 5px;">Accedi</button>
    <p class="mt-3 font-weight-normal">Sei un nuovo utente?  <a href="#">Registrati</a></p>


</form:form>

</div>
