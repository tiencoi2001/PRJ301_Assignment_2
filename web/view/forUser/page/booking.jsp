<%-- 
    Document   : booking
    Created on : Feb 14, 2022, 10:15:42 PM
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
                            <h1 class="m-0 text-primary text-uppercase">Queen Hotel</h1>
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
                                <h1 class="m-0 text-primary text-uppercase">Hotelier</h1>
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
                                    <a href="${pageContext.request.contextPath}/booking" class="nav-item nav-link active">Booking</a>
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
                        <div class="col-lg-7 mb-5 mb-lg-0">
                            <div class="mb-4">
                                <h5 class="text-primary text-uppercase mb-3" style="letter-spacing: 5px;">Queen Hotel</h5>
                                <h1 class="text-white">Your satisfaction is our motivation</h1>
                            </div>
                            <ul class="list-inline text-white m-0">
                                <li class="py-2"><i class="fa fa-check text-primary mr-3"></i>Good price</li>
                                <li class="py-2"><i class="fa fa-check text-primary mr-3"></i>Safe booking</li>
                                <li class="py-2"><i class="fa fa-check text-primary mr-3"></i>Online booking management</li>
                            </ul>
                        </div>
                        <div class="col-lg-5">
                            <div class="card border-0">
                                <div class="card-header bg-light text-center p-4">
                                    <div class="form-header"><h1 class="m-0">Booking</h1></div>
                                </div>
                                <div class="card-body rounded-bottom bg-primary p-5">
                                    <form action="booking" method="post" id="bookingform">
                                        <input type="hidden" name="accountID" value="${sessionScope.user.id}">
                                        <div class="form-group">
                                            <input name="name" type="text" class="form-control border-0 p-4" placeholder="Fullname" value="${sessionScope.user.name}" required/>
                                        </div>
                                        <div class="form-group">
                                            <input name="email" type="email" class="form-control border-0 p-4" placeholder="Email" value="${sessionScope.user.email}" required />
                                        </div>
                                        <div class="form-group">
                                            <input name="phone" type="tel" class="form-control border-0 p-4" placeholder="Phone" value="${sessionScope.user.phone}" required />
                                        </div>
                                        <div class="form-group">
                                            <input name="checkIN" type="date" class="form-control border-0 p-4" placeholder="Check In" value="${sessionScope.order.checkIN}" required />
                                        </div>
                                        <div class="form-group">
                                            <input name="checkOUT" type="date" class="form-control border-0 p-4" placeholder="Check Out" value="${sessionScope.order.checkOUT}" required />
                                        </div>
                                        <div class="form-group">
                                            <input id="numberOfRooms" name="numberOfRooms" type="number" class="form-control border-0 p-4" placeholder="Number Of Room" value="${sessionScope.order.numberOfRooms}" required />
                                        </div>
                                        <div id="number_alert"></div>
                                        <div class="form-group">
                                            <select id="type" class="form-control" name="type">
                                                <option value="0">----------Type Room----------</option>
                                                <c:forEach items="${requestScope.typeList}" var="type">
                                                    <option ${sessionScope.order.roomType.id eq type.id ? "selected=\"selected\"" : ""} value="${type.id}">${type.name} (${type.price}/night)</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div id="type_alert"></div>
                                        <div>
                                            <button class="btn btn-dark btn-block border-0 py-3" onclick="checkNum()" type="button">Booking</button>
                                        </div>
                                        <div>
                                            <c:if test="${requestScope.success == true}">
                                                <p>Booking successful!</p>
                                                <p>We will email you soon,</p>
                                                <p>Thank you and have a good day!</p>
                                            </c:if>
                                            <c:if test="${requestScope.fail == true}">
                                                <p>Booking fail</p>
                                            </c:if>
                                        </div>
                                    </form>
                                    <script>
                                        function checkNum() {
                                            var type = document.getElementById("type").value;
                                            var numberOfRooms = document.getElementById("numberOfRooms").value;
                                            if (type <= 0) {
                                                document.getElementById("type_alert").innerHTML = "<p>Please choose type</p>";
                                            }
                                            if (numberOfRooms <= 0) {
                                                document.getElementById("number_alert").innerHTML = "<p>Number of room must bigger than 0</p>";
                                            }

                                            if (type > 0 && numberOfRooms > 0) {
                                                document.getElementById("type_alert").innerHTML = "";
                                                document.getElementById("number_alert").innerHTML = "";
                                                document.getElementById("bookingform").submit();
                                            }
                                        }
                                    </script>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page="../header_footer/footer.jsp"></jsp:include>
    </body>
</html>