<%-- 
    Document   : chooseroom
    Created on : Mar 8, 2022, 12:05:31 AM
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
        <title>Choose Room</title>
        <jsp:include page="../header_footer/linkcss.jsp"></jsp:include>
        </head>
        <body class="skin-black">
        <jsp:include page="../header_footer/header.jsp"></jsp:include>

            <div class="wrapper row-offcanvas row-offcanvas-left">
            <jsp:include page="../header_footer/leftmenu.jsp"></jsp:include>
                <aside class="right-side">
                    <section class="panel">
                        <header class="panel-heading">
                            CHOOSE ROOM
                        </header>
                        <div class="panel-body col-lg-8">
                            <form class="form-horizontal tasi-form add-form" id="chooseroom" action="${pageContext.request.contextPath}/admin/chooseroom" method="POST">
                            <input type="hidden" name="orderID" value="${requestScope.order.orderID}">
                            <div class="form-group">
                                <label class="col-sm-2 col-sm-2 control-label">Name:</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" value="${requestScope.order.name}" disabled required placeholder="Name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 col-sm-2 control-label">Email:</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" value="${requestScope.order.email}" disabled required placeholder="Email">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 col-sm-2 control-label">Phone:</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" value="${requestScope.order.phone}" disabled required placeholder="Phone">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 col-sm-2 control-label">Room type:</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" value="${requestScope.order.roomType.name}" disabled required placeholder="Room type">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 col-sm-2 control-label">Number of rooms:</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="numberOfRooms" value="${requestScope.order.numberOfRooms}" disabled required placeholder="Number of rooms">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 col-sm-2 control-label">CheckIN:</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" value="${requestScope.order.checkIN}" disabled required placeholder="Check in">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 col-sm-2 control-label">CheckOUT:</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" value="${requestScope.order.checkOUT}" disabled required placeholder="Check out">
                                </div>
                            </div>
                            <c:if test="${requestScope.rooms.size() > 0}">
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">Choose rooms:</label>
                                    <div class="col-sm-10" style="margin-top: 1%;">
                                        <div style="display: flex;">
                                            <c:forEach items="${requestScope.rooms}" var="r">
                                                <div style="margin-right: 3%;">
                                                    <input name="roomID" type="checkbox" value="${r.id}"> ${r.name}
                                                </div>
                                            </c:forEach>
                                        </div>
                                        <div id="alert" style="color: red;"></div>
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${tag eq 'done'}">
                                <div class="col-sm-6" style="color: green; margin: 1% 38% 2% 38%;">
                                    Successful.
                                </div>
                            </c:if>
                            <div class="col-sm-12">
                                <div class="col-sm-4">
                                </div>
                                <c:if test="${!requestScope.noroom}">
                                    <div class="col-sm-2">
                                        <button type="button" class="btn btn-danger center-block col-sm-10"
                                                onclick="location.href = '${pageContext.request.contextPath}/admin/vieworder'">
                                            Discard
                                        </button>
                                    </div>
                                    <div class="col-sm-2">
                                        <button type="button" onclick="checkNumberOfRooms()" class="btn btn-info center-block col-sm-10">Save</button>
                                    </div>
                                </c:if>
                                <c:if test="${requestScope.noroom}">
                                    <div class="col-sm-3">
                                        <p style="color: red;">Not enough room</p>
                                        <button type="button" onclick="location.href = '${pageContext.request.contextPath}/admin/reject?orderID=${requestScope.order.orderID}'" class="btn btn-danger center-block col-sm-10">Reject</button>
                                    </div>
                                </c:if>
                            </div>
                        </form>
                        <script>
                            function checkNumberOfRooms() {
                                var numberOfRooms = document.getElementById("numberOfRooms").value;
                                var checkboxes = document.querySelectorAll('input[type="checkbox"]:checked');
                                console.log(numberOfRooms);
                                console.log(checkboxes.length);
                                if (Number.parseInt(checkboxes.length) !== Number.parseInt(numberOfRooms)) {
                                    document.getElementById('alert').innerHTML = '<p>Please check the number of rooms.</p>\n\<p>The number of rooms is different from the number of rooms the customer wants!</p>';
                                } else {
                                    document.getElementById('alert').innerHTML = '';
                                    document.getElementById('chooseroom').submit();
                                }
                            }
                            ;
                        </script>
                    </div>
                </section>
            </aside>
        </div>
        <jsp:include page="../header_footer/linkjavascript.jsp"></jsp:include>
    </body>
</html>
