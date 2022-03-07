<%-- 
    Document   : detail
    Created on : Mar 7, 2022, 10:31:28 AM
    Author     : Vu Duc Tien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Users List</title>
        <jsp:include page="../header_footer/linkcss.jsp"></jsp:include>
        </head>
        <body class="skin-black">
        <jsp:include page="../header_footer/header.jsp"></jsp:include>

            <div class="wrapper row-offcanvas row-offcanvas-left">
            <jsp:include page="../header_footer/leftmenu.jsp"></jsp:include>
                <aside class="right-side">
                    <section class="panel">
                        <header class="panel-heading">
                            Class Details
                        </header>
                        <div class="panel-body col-lg-8">
                            <form class="form-horizontal tasi-form add-form" action="classdetail" method="POST">
                                <input type="hidden" name="classID" value="${requestScope.class.classID}">
                            <div class="form-group">
                                <label class="col-sm-2 col-sm-2 control-label">Class Name *:</label>
                                <div class="col-sm-6">
                                    <input type="text" name="className" class="form-control" value="${requestScope.class.className}" required placeholder="Class Name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 col-sm-2 control-label">Author *: </label>
                                <div class="col-sm-6">
                                    <select name="author" class="form-control">
                                        <c:forEach items="${requestScope.teachers}" var="t">
                                            <option ${t.id eq requestScope.class.author.id ? "selected=\"selected\"" : ""}
                                                value="${t.id}">${t.fullname}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 col-sm-2 control-label">Note:</label>
                                <div class="col-sm-6">
                                    <textarea name="note" cols="50" rows="10" placeholder="Class note"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 col-sm-2 control-label">Status *:</label>
                                <div class="col-sm-6" style="display: flex;">
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="status" value="ACTIVE" 
                                                   <c:if test="${requestScope.class.status eq 'ACTIVE'}">checked="checked"</c:if>> ACTIVE
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="status" value="DEACTIVE"
                                                <c:if test="${requestScope.class.status eq 'DEACTIVE'}">checked="checked"</c:if> value="DEACTIVE"> DEACTIVE
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6" style="color: red; margin-left: 10%;">
                                    Note: (*) is required.
                                </div>
                            <c:if test="${tag eq 'done'}">
                                <div class="col-sm-6" style="color: green; margin: 1% 38% 2% 38%;">
                                    Update successful.
                                </div>
                            </c:if>
                            <div class="col-sm-12">
                                <div class="col-sm-4">
                                </div>
                                <div class="col-sm-2">
                                    <button type="button" class="btn btn-danger center-block col-sm-10"
                                            onclick="location.href = 'classeslist'">
                                        Discard
                                    </button>
                                </div>
                                <div class="col-sm-2">
                                    <button type="submit" class="btn btn-info center-block col-sm-10">Save</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </section>
            </aside>
        </div>
        <jsp:include page="../header_footer/linkjavascript.jsp"></jsp:include>
    </body>
</html>
