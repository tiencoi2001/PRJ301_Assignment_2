<%-- 
    Document   : register
    Created on : Feb 9, 2022, 1:37:47 AM
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
                            <a href="home" class="navbar-brand w-100 h-100 m-0 p-0 d-flex align-items-center justify-content-center">
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
                            </div>
                            <nav class="navbar navbar-expand-lg bg-dark navbar-dark p-3 p-lg-0">
                                <a href="index.html" class="navbar-brand d-block d-lg-none">
                                    <h1 class="m-0 text-primary text-uppercase">Hotelier</h1>
                                </a>
                                <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                                    <span class="navbar-toggler-icon"></span>
                                </button>
                                <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                                    <div class="navbar-nav mr-auto py-0">
                                        <a href="home" class="nav-item nav-link">Home</a>
                                        <a href="about.html" class="nav-item nav-link">About</a>
                                        <a href="service.html" class="nav-item nav-link">Services</a>
                                        <a href="room.html" class="nav-item nav-link">Rooms</a>
                                        <div class="nav-item dropdown">
                                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Pages</a>
                                            <div class="dropdown-menu rounded-0 m-0">
                                                <a href="booking.html" class="dropdown-item">Booking</a>
                                                <a href="team.html" class="dropdown-item">Our Team</a>
                                                <a href="testimonial.html" class="dropdown-item">Testimonial</a>
                                            </div>
                                        </div>
                                        <a href="contact.html" class="nav-item nav-link">Contact</a>
                                    </div>
                                    <a href="login" class="btn btn-primary rounded-0 py-4 px-md-5 d-none d-lg-block">Login<i class="fa fa-arrow-right ms-3"></i></a>
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
                                    <h5 class="text-primary text-uppercase mb-3" style="letter-spacing: 5px;">Need Any Courses</h5>
                                    <h1 class="text-white">30% Off For New Students</h1>
                                </div>
                                <p class="text-white">Invidunt lorem justo sanctus clita. Erat lorem labore ea, justo dolor lorem ipsum ut sed eos,
                                    ipsum et dolor kasd sit ea justo. Erat justo sed sed diam. Ea et erat ut sed diam sea ipsum est
                                    dolor</p>
                                <ul class="list-inline text-white m-0">
                                    <li class="py-2"><i class="fa fa-check text-primary mr-3"></i>Good price</li>
                                    <li class="py-2"><i class="fa fa-check text-primary mr-3"></i>Safe booking</li>
                                    <li class="py-2"><i class="fa fa-check text-primary mr-3"></i>Online booking management</li>
                                </ul>
                            </div>
                            <div class="col-lg-5">
                                <div class="card border-0">
                                    <div class="card-header bg-light text-center p-4" style="display: flex">
                                        <div class="form-header"><a href="login"><h1 class="m-0">Sign In</h1></a></div>
                                        <div class="form-header form-active"><a href="register"><h1 class="m-0">Sign Up</h1></a></div>
                                    </div>
                                    <div class="card-body rounded-bottom bg-primary p-5">
                                        <form action="register" method="post">
                                            <div class="form-group">
                                                <input name="username" type="text" class="form-control border-0 p-4" placeholder="Username" required="required" />
                                            </div>
                                            <div class="form-group">
                                                <input name="password" type="password" class="form-control border-0 p-4" placeholder="Password" required="required" />
                                            </div>
                                            <div class="form-group">
                                                <input name="name" type="text" class="form-control border-0 p-4" placeholder="Display name" required="required" />
                                            </div>
                                            <div class="form-group">
                                                <input name="birthday" type="date" class="form-control border-0 p-4" placeholder="Date of birth" required="required" />
                                            </div>
                                            <div class="form-group">
                                                <input name="email" type="email" class="form-control border-0 p-4" placeholder="Email" required="required" />
                                            </div>
                                            <div class="form-group">
                                                <input name="phone" type="tel" class="form-control border-0 p-4" placeholder="Phone number" required="required" />
                                            </div>
                                            <div class="form-group">
                                                <input name="address" type="text" class="form-control border-0 p-4" placeholder="Address" required="required" />
                                            </div>
                                            <div>
                                                <button class="btn btn-dark btn-block border-0 py-3" type="submit">Register</button>
                                            </div>
                                        <c:if test="${requestScope.fail == true}">
                                            <div>Username, email or phone has been used</div>
                                        </c:if>
                                        <c:if test="${requestScope.done == true}">
                                            <div>Register successful</div>
                                        </c:if>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page="../header_footer/footer.jsp"></jsp:include>
    </body>
</html>

