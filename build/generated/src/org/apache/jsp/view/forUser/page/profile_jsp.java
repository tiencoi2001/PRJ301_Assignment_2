package org.apache.jsp.view.forUser.page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../header_footer/header.jsp", out, false);
      out.write("\n");
      out.write("        <body>\n");
      out.write("            <div class=\"container-xxl bg-white p-0\">\n");
      out.write("                <!-- Spinner Start -->\n");
      out.write("                <div id=\"spinner\" class=\"show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center\">\n");
      out.write("                    <div class=\"spinner-border text-primary\" style=\"width: 3rem; height: 3rem;\" role=\"status\">\n");
      out.write("                        <span class=\"sr-only\">Loading...</span>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- Spinner End -->\n");
      out.write("\n");
      out.write("                <!-- Header Start -->\n");
      out.write("                <div class=\"container-fluid bg-dark px-0\">\n");
      out.write("                    <div class=\"row gx-0\">\n");
      out.write("                        <div class=\"col-lg-3 bg-dark d-none d-lg-block\">\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/home\" class=\"navbar-brand w-100 h-100 m-0 p-0 d-flex align-items-center justify-content-center\">\n");
      out.write("                            <h1 class=\"m-0 text-primary text-uppercase\">Hotelier</h1>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-9\">\n");
      out.write("                        <div class=\"row gx-0 bg-white d-none d-lg-flex\">\n");
      out.write("                            <div class=\"col-lg-7 px-5 text-start\">\n");
      out.write("                                <div class=\"h-100 d-inline-flex align-items-center py-2 me-4\">\n");
      out.write("                                    <i class=\"fa fa-envelope text-primary me-2\"></i>\n");
      out.write("                                    <p class=\"mb-0\">queenhotel@gmail.com</p>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"h-100 d-inline-flex align-items-center py-2\">\n");
      out.write("                                    <i class=\"fa fa-phone-alt text-primary me-2\"></i>\n");
      out.write("                                    <p class=\"mb-0\">0208 6288 388</p>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-1 px-2\"></div>\n");
      out.write("                            <div class=\"col-lg-4 px-5 text-start\">\n");
      out.write("                                <div class=\"h-100 d-inline-flex align-items-center py-2\">\n");
      out.write("                                    <i class=\"fa fa-users text-primary me-2\"></i>\n");
      out.write("                                    <a href=\"profile\"><p class=\"mb-0\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p></a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <nav class=\"navbar navbar-expand-lg bg-dark navbar-dark p-3 p-lg-0\">\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/home\" class=\"navbar-brand d-block d-lg-none\">\n");
      out.write("                                <h1 class=\"m-0 text-primary text-uppercase\">Hotelier</h1>\n");
      out.write("                            </a>\n");
      out.write("                            <button type=\"button\" class=\"navbar-toggler\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarCollapse\">\n");
      out.write("                                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                            </button>\n");
      out.write("                            <div class=\"collapse navbar-collapse justify-content-between\" id=\"navbarCollapse\">\n");
      out.write("                                <div class=\"navbar-nav mr-auto py-0\">\n");
      out.write("                                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/home\" class=\"nav-item nav-link active\">Home</a>\n");
      out.write("                                    <a href=\"about.html\" class=\"nav-item nav-link\">About</a>\n");
      out.write("                                    <a href=\"service.html\" class=\"nav-item nav-link\">Services</a>\n");
      out.write("                                    <a href=\"room.html\" class=\"nav-item nav-link\">Rooms</a>\n");
      out.write("                                    <div class=\"nav-item dropdown\">\n");
      out.write("                                        <a href=\"#\" class=\"nav-link dropdown-toggle\" data-bs-toggle=\"dropdown\">Pages</a>\n");
      out.write("                                        <div class=\"dropdown-menu rounded-0 m-0\">\n");
      out.write("                                            <a href=\"booking.html\" class=\"dropdown-item\">Booking</a>\n");
      out.write("                                            <a href=\"team.html\" class=\"dropdown-item\">Our Team</a>\n");
      out.write("                                            <a href=\"testimonial.html\" class=\"dropdown-item\">Testimonial</a>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <a href=\"contact.html\" class=\"nav-item nav-link\">Contact</a>\n");
      out.write("                                </div>\n");
      out.write("                                ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                    ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </nav>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- Header End -->\n");
      out.write("\n");
      out.write("            <div class=\"container-login bg-registration py-5\">\n");
      out.write("                <div class=\"container py-5\">\n");
      out.write("                    <div class=\"row align-items-center\">\n");
      out.write("                        <div class=\"col-lg-3 mb-5 mb-lg-0\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-lg-6\">\n");
      out.write("                            <div class=\"card border-0\">\n");
      out.write("                                <div class=\"card-header bg-light text-center p-4\" style=\"display: flex\">\n");
      out.write("                                    <div class=\"form-header form-active\"><a href=\"profile\"><h1 class=\"m-0\">Profile</h1></a></div>\n");
      out.write("                                    <div class=\"form-header\"><a href=\"transactionhistory\"><h1 class=\"m-0\">Transaction history</h1></a></div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"card-body rounded-bottom bg-primary p-5\">\n");
      out.write("                                    <form action=\"booking\" method=\"post\" id=\"bookingform\">\n");
      out.write("                                        <input type=\"hidden\" name=\"accountID\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <input name=\"name\" type=\"text\" class=\"form-control border-0 p-4\" placeholder=\"Fullname\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required=\"required\" />\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <input name=\"email\" type=\"email\" class=\"form-control border-0 p-4\" placeholder=\"Email\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required=\"required\" />\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <input name=\"phone\" type=\"tel\" class=\"form-control border-0 p-4\" placeholder=\"Phone\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.phone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required=\"required\" />\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <input name=\"checkIN\" type=\"date\" class=\"form-control border-0 p-4\" placeholder=\"Check In\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.order.checkIN}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required=\"required\" />\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <input name=\"checkOUT\" type=\"date\" class=\"form-control border-0 p-4\" placeholder=\"Check Out\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.order.checkOUT}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required=\"required\" />\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <input id=\"numberOfRooms\" name=\"numberOfRooms\" type=\"number\" class=\"form-control border-0 p-4\" placeholder=\"Number Of Room\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.order.numberOfRooms}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required=\"required\" />\n");
      out.write("                                        </div>\n");
      out.write("                                        <div id=\"number_alert\"></div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <select id=\"type\" name=\"type\">\n");
      out.write("                                                <option value=\"0\">----------Type Room----------</option>\n");
      out.write("                                                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                            </select>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div id=\"type_alert\"></div>\n");
      out.write("                                        <div>\n");
      out.write("                                            <button class=\"btn btn-dark btn-block border-0 py-3\" onclick=\"checkNum()\" type=\"button\">Booking</button>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div>\n");
      out.write("                                            ");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                    </form>\n");
      out.write("                                    <script>\n");
      out.write("                                        function checkNum() {\n");
      out.write("                                            var type = document.getElementById(\"type\").value;\n");
      out.write("                                            var numberOfRooms = document.getElementById(\"numberOfRooms\").value;\n");
      out.write("                                            if (type <= 0) {\n");
      out.write("                                                document.getElementById(\"type_alert\").innerHTML = \"<p>Please choose type</p>\";\n");
      out.write("                                            }\n");
      out.write("                                            if (numberOfRooms <= 0) {\n");
      out.write("                                                document.getElementById(\"number_alert\").innerHTML = \"<p>Number of room must bigger than 0</p>\";\n");
      out.write("                                            }\n");
      out.write("\n");
      out.write("                                            if (type > 0 && numberOfRooms > 0) {\n");
      out.write("                                                document.getElementById(\"type_alert\").innerHTML = \"\";\n");
      out.write("                                                document.getElementById(\"number_alert\").innerHTML = \"\";\n");
      out.write("                                                document.getElementById(\"bookingform\").onsubmit = function () {\n");
      out.write("                                                    return true;\n");
      out.write("                                                }\n");
      out.write("                                            }\n");
      out.write("                                        }\n");
      out.write("                                    </script>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../header_footer/footer.jsp", out, false);
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    <a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/login\" class=\"btn btn-primary rounded-0 py-4 px-md-5 d-none d-lg-block\">Log in<i class=\"fa fa-arrow-right ms-3\"></i></a>\n");
        out.write("                                    ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    <a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/logout\" class=\"btn btn-primary rounded-0 py-4 px-md-5 d-none d-lg-block\">Log out<i class=\"fa fa-arrow-right ms-3\"></i></a>\n");
        out.write("                                    ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.typeList}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("type");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                                    <option ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.order.typeID eq type.id ? \"selected=\\\"selected\\\"\" : \"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${type.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${type.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(' ');
          out.write('(');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${type.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("/day)</option>\n");
          out.write("                                                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent(null);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.success == true}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                <p>Booking successful!</p>\n");
        out.write("                                                <p>We will email you soon,</p>\n");
        out.write("                                                <p>Thank you and have a good day!</p>\n");
        out.write("                                            ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }
}
