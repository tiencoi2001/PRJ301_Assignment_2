<%-- 
    Document   : detail
    Created on : Mar 10, 2022, 12:15:54 PM
    Author     : Vu Duc Tien
--%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <jsp:include page="../header_footer/header.jsp"></jsp:include>
        <body>
            <div class="container-xxl bg-white p-0">
                <!-- Spinner Start -->
                <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
                    <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                        <span class="sr-only">Loading...</span>
                    </div>
                </div>
                <!-- Spinner End -->

                <!-- Header Start -->
                <div class="container-fluid bg-dark px-0">
                    <div class="row gx-0">
                        <div class="col-lg-3 bg-dark d-none d-lg-block">
                            <a href="${pageContext.request.contextPath}/home" class="navbar-brand w-100 h-100 m-0 p-0 d-flex align-items-center justify-content-center">
                            <h1 class="m-0 text-primary text-uppercase">Hotelier</h1>
                        </a>
                    </div>
                    <div class="col-lg-9">
                        <div class="row gx-0 bg-white d-none d-lg-flex">
                            <div class="col-lg-7 px-5 text-start">
                                <div class="h-100 d-inline-flex align-items-center py-2 me-4">
                                    <i class="fa fa-envelope text-primary me-2"></i>
                                    <p class="mb-0">queenhotel@gmail.com</p>
                                </div>
                                <div class="h-100 d-inline-flex align-items-center py-2">
                                    <i class="fa fa-phone-alt text-primary me-2"></i>
                                    <p class="mb-0">0208 6288 388</p>
                                </div>
                            </div>
                            <div class="col-lg-1 px-2"></div>
                            <c:if test="${sessionScope.user != null}">
                                <div class="col-lg-4 px-5 text-start">
                                    <div class="h-100 d-inline-flex align-items-center py-2">
                                        <i class="fa fa-users text-primary me-2"></i>
                                        <a href="${pageContext.request.contextPath}/profile"><p class="mb-0">${sessionScope.user.name}</p></a>
                                    </div>
                                </div>
                            </c:if>
                        </div>
                        <nav class="navbar navbar-expand-lg bg-dark navbar-dark p-3 p-lg-0">
                            <a href="${pageContext.request.contextPath}/home" class="navbar-brand d-block d-lg-none">
                                <h1 class="m-0 text-primary text-uppercase">Queen Hotel</h1>
                            </a>
                            <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                            <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                                <div class="navbar-nav mr-auto py-0">
                                    <a href="${pageContext.request.contextPath}/home" class="nav-item nav-link">Home</a>
                                    <a href="#" class="nav-item nav-link">About</a>
                                    <a href="#" class="nav-item nav-link">Services</a>
                                    <a href="#" class="nav-item nav-link">Rooms</a>
                                    <a href="${pageContext.request.contextPath}/booking" class="nav-item nav-link">Booking</a>
                                    <a href="#" class="nav-item nav-link">Contact</a>
                                </div>
                                <c:if test="${sessionScope.user == null}">
                                    <a href="${pageContext.request.contextPath}/login" class="btn btn-primary rounded-0 py-4 px-md-5 d-none d-lg-block">Log in<i class="fa fa-arrow-right ms-3"></i></a>
                                    </c:if>
                                    <c:if test="${sessionScope.user != null}">
                                    <a href="${pageContext.request.contextPath}/logout" class="btn btn-primary rounded-0 py-4 px-md-5 d-none d-lg-block">Log out<i class="fa fa-arrow-right ms-3"></i></a>
                                    </c:if>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
            <!-- Header End -->

            <div class="container-login bg-registration py-5">
                <div class="container py-5">
                    <div class="row align-items-center">
                        <div class="col-lg-12">
                            <div class="card border-0">
                                <div class="card-header bg-light text-center p-4" style="display: flex">
                                    <div class="form-header form-active col-lg-6" style="margin: auto 0"><a href="${pageContext.request.contextPath}/profile"><h1 class="m-0">Profile</h1></a></div>
                                    <div class="form-header col-lg-6"><a href="${pageContext.request.contextPath}/transactionhistory"><h1 class="m-0">Transaction history</h1></a></div>
                                </div>
                                <div class="card-body rounded-bottom bg-primary p-5">
                                    <table>
                                        <tr>
                                            <td>ID</td>
                                            <td>Type</td>
                                            <td>Number of rooms</td>
                                            <td>Rooms</td>
                                            <td>CheckIN</td>
                                            <td>CheckOUT</td>
                                            <td>Price</td>
                                            <td>Paid</td>
                                        </tr>
                                        <tr>
                                            <td>${requestScope.invoice.order.orderID}</td>
                                            <td>${requestScope.invoice.order.roomType.name}</td>
                                            <td>${requestScope.invoice.order.numberOfRooms}</td>
                                            <td>
                                                <c:forEach items="${requestScope.invoice.order.rooms}" var="r">
                                                    ${r.name}
                                                </c:forEach>
                                            </td>
                                            <td>${requestScope.invoice.order.checkIN}</td>
                                            <td>${requestScope.invoice.order.checkOUT}</td>
                                            <td>${requestScope.invoice.price}</td>
                                            <td>${requestScope.invoice.paid}</td>
                                        </tr>
                                    </table>
                                    <style>
                                        table, tr, td{
                                            border: solid 3px;
                                            text-align: center;
                                            border-color: black;
                                            background-color: white;
                                        }
                                        td{
                                            width: 20%; 
                                        }
                                    </style>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page="../header_footer/footer.jsp"></jsp:include>
    </body>
</html>