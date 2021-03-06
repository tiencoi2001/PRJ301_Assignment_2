<%-- 
    Document   : home
    Created on : Jan 25, 2022, 11:47:38 PM
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
                                    <a href="${pageContext.request.contextPath}/home" class="nav-item nav-link active">Home</a>
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

            <!-- Carousel Start -->
            <div class="container-fluid p-0 mb-5">
                <div id="header-carousel" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img class="w-100" src="img/carousel-1.jpg" alt="Image">
                            <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                                <div class="p-3" style="max-width: 700px;">
                                    <h6 class="section-title text-white text-uppercase mb-3 animated slideInDown">Luxury Living</h6>
                                    <h1 class="display-3 text-white mb-4 animated slideInDown">Queen Hotel</h1>
                                    <a href="" class="btn btn-primary py-md-3 px-md-5 me-3 animated slideInLeft">Our Rooms</a>
                                    <a href="${pageContext.request.contextPath}/booking" class="btn btn-light py-md-3 px-md-5 animated slideInRight">Book A Room</a>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img class="w-100" src="img/carousel-2.jpg" alt="Image">
                            <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                                <div class="p-3" style="max-width: 700px;">
                                    <h6 class="section-title text-white text-uppercase mb-3 animated slideInDown">Luxury Living</h6>
                                    <h1 class="display-3 text-white mb-4 animated slideInDown">Discover A Brand Luxurious Hotel</h1>
                                    <a href="" class="btn btn-primary py-md-3 px-md-5 me-3 animated slideInLeft">Our Rooms</a>
                                    <a href="" class="btn btn-light py-md-3 px-md-5 animated slideInRight">Book A Room</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#header-carousel"
                            data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#header-carousel"
                            data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </div>
            <!-- Carousel End -->


            <!-- Booking Start -->
            <div class="container-fluid booking pb-5 wow fadeIn" data-wow-delay="0.1s">
                <div class="container">
                    <form action="${pageContext.request.contextPath}/home" method="post">
                        <div class="bg-white shadow" style="padding: 35px;">
                            <div class="row g-2">
                                <div class="col-md-10">
                                    <div class="row g-2">
                                        <div class="col-md-3">
                                            <div class="date" id="date1" data-target-input="nearest">
                                                <input type="date" name="checkIN" class="form-control datetimepicker-input"
                                                       placeholder="Check in" value="${sessionScope.order.checkIN}" data-target="#date1" data-toggle="datetimepicker" />
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="date" id="date2" data-target-input="nearest">
                                                <input type="date" name="checkOUT" class="form-control datetimepicker-input"
                                                       placeholder="Check out" value="${sessionScope.order.checkOUT}" data-target="#date2" data-toggle="datetimepicker"/>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <input id="numberOfRoom" name="numberOfRooms" type="number" class="form-control" placeholder="Number Of Room" value="${sessionScope.order.numberOfRooms}" required="required" />
                                        </div>
                                        <div class="col-md-3">
                                            <select id="type" name="type" class="form-select">
                                                <option value="0">----------Type Room----------</option>
                                                <c:forEach items="${requestScope.typeList}" var="type">
                                                    <option ${sessionScope.order.typeID eq type.id ? "selected=\"selected\"" : ""} value="${type.id}">${type.name} (${type.price}/day)</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-2">
                                    <button class="btn btn-primary w-100" type="submit">Book</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
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
                        document.getElementById("bookingform").onsubmit = function () {
                            return true;
                        }
                    }
                }
            </script>
            <!-- Booking End -->


            <!-- About Start -->
            <div class="container-xxl py-5">
                <div class="container">
                    <div class="row g-5 align-items-center">
                        <div class="col-lg-6">
                            <h6 class="section-title text-start text-primary text-uppercase">About Us</h6>
                            <h1 class="mb-4">Welcome to <span class="text-primary text-uppercase">Queen Hotel</span></h1>
                            <p class="mb-4">Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit. Aliqu diam amet diam et eos. Clita erat ipsum et lorem et sit, sed stet lorem sit clita duo justo magna dolore erat amet</p>
                            <div class="row g-3 pb-4">
                                <div class="col-sm-4 wow fadeIn" data-wow-delay="0.1s">
                                    <div class="border rounded p-1">
                                        <div class="border rounded text-center p-4">
                                            <i class="fa fa-hotel fa-2x text-primary mb-2"></i>
                                            <h2 class="mb-1" data-toggle="counter-up">90</h2>
                                            <p class="mb-0">Rooms</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-4 wow fadeIn" data-wow-delay="0.3s">
                                    <div class="border rounded p-1">
                                        <div class="border rounded text-center p-4">
                                            <i class="fa fa-users-cog fa-2x text-primary mb-2"></i>
                                            <h2 class="mb-1" data-toggle="counter-up">200</h2>
                                            <p class="mb-0">Staffs</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-4 wow fadeIn" data-wow-delay="0.5s">
                                    <div class="border rounded p-1">
                                        <div class="border rounded text-center p-4">
                                            <i class="fa fa-users fa-2x text-primary mb-2"></i>
                                            <h2 class="mb-1" data-toggle="counter-up">1200</h2>
                                            <p class="mb-0">Clients</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <a class="btn btn-primary py-3 px-5 mt-2" href="">Explore More</a>
                        </div>
                        <div class="col-lg-6">
                            <div class="row g-3">
                                <div class="col-6 text-end">
                                    <img class="img-fluid rounded w-75 wow zoomIn" data-wow-delay="0.1s" src="img/about-1.jpg" style="margin-top: 25%;">
                                </div>
                                <div class="col-6 text-start">
                                    <img class="img-fluid rounded w-100 wow zoomIn" data-wow-delay="0.3s" src="img/about-2.jpg">
                                </div>
                                <div class="col-6 text-end">
                                    <img class="img-fluid rounded w-50 wow zoomIn" data-wow-delay="0.5s" src="img/about-3.jpg">
                                </div>
                                <div class="col-6 text-start">
                                    <img class="img-fluid rounded w-75 wow zoomIn" data-wow-delay="0.7s" src="img/about-4.jpg">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- About End -->


            <!-- Room Start -->
            <div class="container-xxl py-5">
                <div class="container">
                    <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
                        <h6 class="section-title text-center text-primary text-uppercase">Our Rooms</h6>
                        <h1 class="mb-5">Explore Our <span class="text-primary text-uppercase">Rooms</span></h1>
                    </div>
                    <div class="row g-4">
                        <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
                            <div class="room-item shadow rounded overflow-hidden">
                                <div class="position-relative">
                                    <img class="img-fluid" src="img/room-1.jpg" alt="">
                                    <small class="position-absolute start-0 top-100 translate-middle-y bg-primary text-white rounded py-1 px-3 ms-4">300.000 - 370.000/night</small>
                                </div>
                                <div class="p-4 mt-2">
                                    <div class="d-flex justify-content-between mb-3">
                                        <h5 class="mb-0">Silver room</h5>
                                        <div class="ps-2">
                                            <small class="fa fa-star text-primary"></small>
                                            <small class="fa fa-star text-primary"></small>
                                            <small class="fa fa-star text-primary"></small>
                                            <small class="fa fa-star text-primary"></small>
                                            <small class="fa fa-star text-primary"></small>
                                        </div>
                                    </div>
                                    <div class="d-flex mb-3">
                                        <small class="border-end me-3 pe-3"><i class="fa fa-bed text-primary me-2"></i>1-2 Bed</small>
                                        <small class="border-end me-3 pe-3"><i class="fa fa-bath text-primary me-2"></i>1 Bath</small>
                                        <small><i class="fa fa-wifi text-primary me-2"></i>Wifi</small>
                                    </div>
                                    <div class="d-flex justify-content-between">
                                        <a class="btn btn-sm btn-primary rounded py-2 px-4" href="">View Detail</a>
                                        <a class="btn btn-sm btn-dark rounded py-2 px-4" href="">Book Now</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
                            <div class="room-item shadow rounded overflow-hidden">
                                <div class="position-relative">
                                    <img class="img-fluid" src="img/room-2.jpg" alt="">
                                    <small class="position-absolute start-0 top-100 translate-middle-y bg-primary text-white rounded py-1 px-3 ms-4">380.000 - 450.000/night</small>
                                </div>
                                <div class="p-4 mt-2">
                                    <div class="d-flex justify-content-between mb-3">
                                        <h5 class="mb-0">Gold room</h5>
                                        <div class="ps-2">
                                            <small class="fa fa-star text-primary"></small>
                                            <small class="fa fa-star text-primary"></small>
                                            <small class="fa fa-star text-primary"></small>
                                            <small class="fa fa-star text-primary"></small>
                                            <small class="fa fa-star text-primary"></small>
                                        </div>
                                    </div>
                                    <div class="d-flex mb-3">
                                        <small class="border-end me-3 pe-3"><i class="fa fa-bed text-primary me-2"></i>1-2 Bed</small>
                                        <small class="border-end me-3 pe-3"><i class="fa fa-bath text-primary me-2"></i>1-2 Bath</small>
                                        <small><i class="fa fa-wifi text-primary me-2"></i>Wifi</small>
                                    </div>
                                    <div class="d-flex justify-content-between">
                                        <a class="btn btn-sm btn-primary rounded py-2 px-4" href="">View Detail</a>
                                        <a class="btn btn-sm btn-dark rounded py-2 px-4" href="">Book Now</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.6s">
                            <div class="room-item shadow rounded overflow-hidden">
                                <div class="position-relative">
                                    <img class="img-fluid" src="img/room-3.jpg" alt="">
                                    <small class="position-absolute start-0 top-100 translate-middle-y bg-primary text-white rounded py-1 px-3 ms-4">500.000 - 600.000/night</small>
                                </div>
                                <div class="p-4 mt-2">
                                    <div class="d-flex justify-content-between mb-3">
                                        <h5 class="mb-0">Platinum room</h5>
                                        <div class="ps-2">
                                            <small class="fa fa-star text-primary"></small>
                                            <small class="fa fa-star text-primary"></small>
                                            <small class="fa fa-star text-primary"></small>
                                            <small class="fa fa-star text-primary"></small>
                                            <small class="fa fa-star text-primary"></small>
                                        </div>
                                    </div>
                                    <div class="d-flex mb-3">
                                        <small class="border-end me-3 pe-3"><i class="fa fa-bed text-primary me-2"></i>1-3 Bed</small>
                                        <small class="border-end me-3 pe-3"><i class="fa fa-bath text-primary me-2"></i>2 Bath</small>
                                        <small><i class="fa fa-wifi text-primary me-2"></i>Wifi</small>
                                    </div>
                                    <div class="d-flex justify-content-between">
                                        <a class="btn btn-sm btn-primary rounded py-2 px-4" href="">View Detail</a>
                                        <a class="btn btn-sm btn-dark rounded py-2 px-4" href="">Book Now</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Room End -->


            <!-- Video Start -->
            <div class="container-xxl py-5 px-0 wow zoomIn" data-wow-delay="0.1s">
                <div class="row g-0">
                    <div class="col-md-6 bg-dark d-flex align-items-center">
                        <div class="p-5">
                            <h6 class="section-title text-start text-white text-uppercase mb-3">Luxury Living</h6>
                            <h1 class="text-white mb-4">Discover A Brand Luxurious Hotel</h1>
                            <p class="text-white mb-4">Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit. Aliqu diam amet diam et eos. Clita erat ipsum et lorem et sit, sed stet lorem sit clita duo justo magna dolore erat amet</p>
                            <a href="" class="btn btn-primary py-md-3 px-md-5 me-3">Our Rooms</a>
                            <a href="" class="btn btn-light py-md-3 px-md-5">Book A Room</a>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="video">
                            <button type="button" class="btn-play" data-bs-toggle="modal" data-src="https://www.youtube.com/embed/DWRcNpR6Kdc" data-bs-target="#videoModal">
                                <span></span>
                            </button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal fade" id="videoModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content rounded-0">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Youtube Video</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <!-- 16:9 aspect ratio -->
                            <div class="ratio ratio-16x9">
                                <iframe class="embed-responsive-item" src="" id="video" allowfullscreen allowscriptaccess="always"
                                        allow="autoplay"></iframe>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Video Start -->


            <!-- Service Start -->
            <div class="container-xxl py-5">
                <div class="container">
                    <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
                        <h6 class="section-title text-center text-primary text-uppercase">Our Services</h6>
                        <h1 class="mb-5">Explore Our <span class="text-primary text-uppercase">Services</span></h1>
                    </div>
                    <div class="row g-4">
                        <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
                            <a class="service-item rounded" href="">
                                <div class="service-icon bg-transparent border rounded p-1">
                                    <div class="w-100 h-100 border rounded d-flex align-items-center justify-content-center">
                                        <i class="fa fa-hotel fa-2x text-primary"></i>
                                    </div>
                                </div>
                                <h5 class="mb-3">Rooms & Appartment</h5>
                                <p class="text-body mb-0">Erat ipsum justo amet duo et elitr dolor, est duo duo eos lorem sed diam stet diam sed stet lorem.</p>
                            </a>
                        </div>
                        <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.2s">
                            <a class="service-item rounded" href="">
                                <div class="service-icon bg-transparent border rounded p-1">
                                    <div class="w-100 h-100 border rounded d-flex align-items-center justify-content-center">
                                        <i class="fa fa-utensils fa-2x text-primary"></i>
                                    </div>
                                </div>
                                <h5 class="mb-3">Food & Restaurant</h5>
                                <p class="text-body mb-0">Erat ipsum justo amet duo et elitr dolor, est duo duo eos lorem sed diam stet diam sed stet lorem.</p>
                            </a>
                        </div>
                        <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
                            <a class="service-item rounded" href="">
                                <div class="service-icon bg-transparent border rounded p-1">
                                    <div class="w-100 h-100 border rounded d-flex align-items-center justify-content-center">
                                        <i class="fa fa-spa fa-2x text-primary"></i>
                                    </div>
                                </div>
                                <h5 class="mb-3">Spa & Fitness</h5>
                                <p class="text-body mb-0">Erat ipsum justo amet duo et elitr dolor, est duo duo eos lorem sed diam stet diam sed stet lorem.</p>
                            </a>
                        </div>
                        <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.4s">
                            <a class="service-item rounded" href="">
                                <div class="service-icon bg-transparent border rounded p-1">
                                    <div class="w-100 h-100 border rounded d-flex align-items-center justify-content-center">
                                        <i class="fa fa-swimmer fa-2x text-primary"></i>
                                    </div>
                                </div>
                                <h5 class="mb-3">Sports & Gaming</h5>
                                <p class="text-body mb-0">Erat ipsum justo amet duo et elitr dolor, est duo duo eos lorem sed diam stet diam sed stet lorem.</p>
                            </a>
                        </div>
                        <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
                            <a class="service-item rounded" href="">
                                <div class="service-icon bg-transparent border rounded p-1">
                                    <div class="w-100 h-100 border rounded d-flex align-items-center justify-content-center">
                                        <i class="fa fa-glass-cheers fa-2x text-primary"></i>
                                    </div>
                                </div>
                                <h5 class="mb-3">Event & Party</h5>
                                <p class="text-body mb-0">Erat ipsum justo amet duo et elitr dolor, est duo duo eos lorem sed diam stet diam sed stet lorem.</p>
                            </a>
                        </div>
                        <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.6s">
                            <a class="service-item rounded" href="">
                                <div class="service-icon bg-transparent border rounded p-1">
                                    <div class="w-100 h-100 border rounded d-flex align-items-center justify-content-center">
                                        <i class="fa fa-dumbbell fa-2x text-primary"></i>
                                    </div>
                                </div>
                                <h5 class="mb-3">GYM & Yoga</h5>
                                <p class="text-body mb-0">Erat ipsum justo amet duo et elitr dolor, est duo duo eos lorem sed diam stet diam sed stet lorem.</p>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page="../header_footer/footer.jsp"></jsp:include>
    </body>
</html>