<%-- 
    Document   : contact
    Created on : Feb 7, 2022, 12:41:45 AM
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
                                        <a href="${pageContext.request.contextPath}/home" class="nav-item nav-link active">Home</a>
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

                <!-- Page Header Start -->
                <div class="container-fluid page-header mb-5 p-0" style="background-image: url(img/carousel-1.jpg);">
                    <div class="container-fluid page-header-inner py-5">
                        <div class="container text-center pb-5">
                            <h1 class="display-3 text-white mb-3 animated slideInDown">Contact</h1>
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb justify-content-center text-uppercase">
                                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                                    <li class="breadcrumb-item"><a href="#">Pages</a></li>
                                    <li class="breadcrumb-item text-white active" aria-current="page">Contact</li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
                <!-- Page Header End -->


                <!-- Booking Start -->
                <div class="container-fluid booking pb-5 wow fadeIn" data-wow-delay="0.1s">
                    <div class="container">
                        <div class="bg-white shadow" style="padding: 35px;">
                            <div class="row g-2">
                                <div class="col-md-10">
                                    <div class="row g-2">
                                        <div class="col-md-3">
                                            <div class="date" id="date1" data-target-input="nearest">
                                                <input type="text" class="form-control datetimepicker-input"
                                                       placeholder="Check in" data-target="#date1" data-toggle="datetimepicker" />
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="date" id="date2" data-target-input="nearest">
                                                <input type="text" class="form-control datetimepicker-input" placeholder="Check out" data-target="#date2" data-toggle="datetimepicker"/>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <select class="form-select">
                                                <option selected>Adult</option>
                                                <option value="1">Adult 1</option>
                                                <option value="2">Adult 2</option>
                                                <option value="3">Adult 3</option>
                                            </select>
                                        </div>
                                        <div class="col-md-3">
                                            <select class="form-select">
                                                <option selected>Child</option>
                                                <option value="1">Child 1</option>
                                                <option value="2">Child 2</option>
                                                <option value="3">Child 3</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-2">
                                    <button class="btn btn-primary w-100">Submit</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Booking End -->

                <!-- Contact Start -->
                <div class="container-xxl py-5">
                    <div class="container">
                        <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
                            <h6 class="section-title text-center text-primary text-uppercase">Contact Us</h6>
                            <h1 class="mb-5"><span class="text-primary text-uppercase">Contact</span> For Any Query</h1>
                        </div>
                        <div class="row g-4">
                            <div class="col-12">
                                <div class="row gy-4">
                                    <div class="col-md-4">
                                        <h6 class="section-title text-start text-primary text-uppercase">Booking</h6>
                                        <p><i class="fa fa-envelope-open text-primary me-2"></i>book@example.com</p>
                                    </div>
                                    <div class="col-md-4">
                                        <h6 class="section-title text-start text-primary text-uppercase">General</h6>
                                        <p><i class="fa fa-envelope-open text-primary me-2"></i>info@example.com</p>
                                    </div>
                                    <div class="col-md-4">
                                        <h6 class="section-title text-start text-primary text-uppercase">Technical</h6>
                                        <p><i class="fa fa-envelope-open text-primary me-2"></i>tech@example.com</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 wow fadeIn" data-wow-delay="0.1s">
                                <iframe class="position-relative rounded w-100 h-100"
                                        src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3001156.4288297426!2d-78.01371936852176!3d42.72876761954724!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4ccc4bf0f123a5a9%3A0xddcfc6c1de189567!2sNew%20York%2C%20USA!5e0!3m2!1sen!2sbd!4v1603794290143!5m2!1sen!2sbd"
                                        frameborder="0" style="min-height: 350px; border:0;" allowfullscreen="" aria-hidden="false"
                                        tabindex="0"></iframe>
                            </div>
                            <div class="col-md-6">
                                <div class="wow fadeInUp" data-wow-delay="0.2s">
                                    <form>
                                        <div class="row g-3">
                                            <div class="col-md-6">
                                                <div class="form-floating">
                                                    <input type="text" class="form-control" id="name" placeholder="Your Name">
                                                    <label for="name">Your Name</label>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-floating">
                                                    <input type="email" class="form-control" id="email" placeholder="Your Email">
                                                    <label for="email">Your Email</label>
                                                </div>
                                            </div>
                                            <div class="col-12">
                                                <div class="form-floating">
                                                    <input type="text" class="form-control" id="subject" placeholder="Subject">
                                                    <label for="subject">Subject</label>
                                                </div>
                                            </div>
                                            <div class="col-12">
                                                <div class="form-floating">
                                                    <textarea class="form-control" placeholder="Leave a message here" id="message" style="height: 150px"></textarea>
                                                    <label for="message">Message</label>
                                                </div>
                                            </div>
                                            <div class="col-12">
                                                <button class="btn btn-primary w-100 py-3" type="submit">Send Message</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Contact End -->
            <jsp:include page="../header_footer/footer.jsp"></jsp:include>
    </body>
</html>

