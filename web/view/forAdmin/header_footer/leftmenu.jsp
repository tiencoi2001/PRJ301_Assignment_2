<%-- 
    Document   : leftmenu
    Created on : Mar 3, 2022, 5:49:57 PM
    Author     : Vu Duc Tien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- Left side column. contains the logo and sidebar -->

<aside class="left-side sidebar-offcanvas">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel" style="    display: flex;">
            <div class="pull-left image">
                <img src="https://th.bing.com/th/id/OIP.CPCyt52dUDhWIhy1K3guLAHaHa?pid=ImgDet&rs=1" class="img-circle" alt="User Image" />
            </div>
            <div class="pull-left info">
                <p>Hello, ${sessionScope.user.name}</p>

                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li>
                <a href="${pageContext.request.contextPath}/home">
                    <i class="fa fa-home"></i> <span>Home</span>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/admin/vieworder">
                    <i class="fa fa-calendar"></i> <span>View Order</span>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/admin/paid">
                    <i class="fa fa-money"></i> <span>Paid Invoices</span>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/admin/unpaid">
                    <i class="fa fa-plus-circle"></i> <span>Unpaid Invoices</span>
                </a>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
