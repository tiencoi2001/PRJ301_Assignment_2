package org.apache.jsp.view.forUser.page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contact_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
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
      out.write("            <!-- Page Header Start -->\n");
      out.write("            <div class=\"container-fluid page-header mb-5 p-0\" style=\"background-image: url(img/carousel-1.jpg);\">\n");
      out.write("                <div class=\"container-fluid page-header-inner py-5\">\n");
      out.write("                    <div class=\"container text-center pb-5\">\n");
      out.write("                        <h1 class=\"display-3 text-white mb-3 animated slideInDown\">Contact</h1>\n");
      out.write("                        <nav aria-label=\"breadcrumb\">\n");
      out.write("                            <ol class=\"breadcrumb justify-content-center text-uppercase\">\n");
      out.write("                                <li class=\"breadcrumb-item\"><a href=\"#\">Home</a></li>\n");
      out.write("                                <li class=\"breadcrumb-item\"><a href=\"#\">Pages</a></li>\n");
      out.write("                                <li class=\"breadcrumb-item text-white active\" aria-current=\"page\">Contact</li>\n");
      out.write("                            </ol>\n");
      out.write("                        </nav>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- Page Header End -->\n");
      out.write("\n");
      out.write("\n");
      out.write("            <!-- Booking Start -->\n");
      out.write("            <div class=\"container-fluid booking pb-5 wow fadeIn\" data-wow-delay=\"0.1s\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"bg-white shadow\" style=\"padding: 35px;\">\n");
      out.write("                        <div class=\"row g-2\">\n");
      out.write("                            <div class=\"col-md-10\">\n");
      out.write("                                <div class=\"row g-2\">\n");
      out.write("                                    <div class=\"col-md-3\">\n");
      out.write("                                        <div class=\"date\" id=\"date1\" data-target-input=\"nearest\">\n");
      out.write("                                            <input type=\"text\" class=\"form-control datetimepicker-input\"\n");
      out.write("                                                   placeholder=\"Check in\" data-target=\"#date1\" data-toggle=\"datetimepicker\" />\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-3\">\n");
      out.write("                                        <div class=\"date\" id=\"date2\" data-target-input=\"nearest\">\n");
      out.write("                                            <input type=\"text\" class=\"form-control datetimepicker-input\" placeholder=\"Check out\" data-target=\"#date2\" data-toggle=\"datetimepicker\"/>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-3\">\n");
      out.write("                                        <select class=\"form-select\">\n");
      out.write("                                            <option selected>Adult</option>\n");
      out.write("                                            <option value=\"1\">Adult 1</option>\n");
      out.write("                                            <option value=\"2\">Adult 2</option>\n");
      out.write("                                            <option value=\"3\">Adult 3</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-3\">\n");
      out.write("                                        <select class=\"form-select\">\n");
      out.write("                                            <option selected>Child</option>\n");
      out.write("                                            <option value=\"1\">Child 1</option>\n");
      out.write("                                            <option value=\"2\">Child 2</option>\n");
      out.write("                                            <option value=\"3\">Child 3</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-2\">\n");
      out.write("                                <button class=\"btn btn-primary w-100\">Submit</button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- Booking End -->\n");
      out.write("\n");
      out.write("            <!-- Contact Start -->\n");
      out.write("            <div class=\"container-xxl py-5\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"text-center wow fadeInUp\" data-wow-delay=\"0.1s\">\n");
      out.write("                        <h6 class=\"section-title text-center text-primary text-uppercase\">Contact Us</h6>\n");
      out.write("                        <h1 class=\"mb-5\"><span class=\"text-primary text-uppercase\">Contact</span> For Any Query</h1>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row g-4\">\n");
      out.write("                        <div class=\"col-12\">\n");
      out.write("                            <div class=\"row gy-4\">\n");
      out.write("                                <div class=\"col-md-4\">\n");
      out.write("                                    <h6 class=\"section-title text-start text-primary text-uppercase\">Booking</h6>\n");
      out.write("                                    <p><i class=\"fa fa-envelope-open text-primary me-2\"></i>book@example.com</p>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-4\">\n");
      out.write("                                    <h6 class=\"section-title text-start text-primary text-uppercase\">General</h6>\n");
      out.write("                                    <p><i class=\"fa fa-envelope-open text-primary me-2\"></i>info@example.com</p>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-4\">\n");
      out.write("                                    <h6 class=\"section-title text-start text-primary text-uppercase\">Technical</h6>\n");
      out.write("                                    <p><i class=\"fa fa-envelope-open text-primary me-2\"></i>tech@example.com</p>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-6 wow fadeIn\" data-wow-delay=\"0.1s\">\n");
      out.write("                            <iframe class=\"position-relative rounded w-100 h-100\"\n");
      out.write("                                    src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3001156.4288297426!2d-78.01371936852176!3d42.72876761954724!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4ccc4bf0f123a5a9%3A0xddcfc6c1de189567!2sNew%20York%2C%20USA!5e0!3m2!1sen!2sbd!4v1603794290143!5m2!1sen!2sbd\"\n");
      out.write("                                    frameborder=\"0\" style=\"min-height: 350px; border:0;\" allowfullscreen=\"\" aria-hidden=\"false\"\n");
      out.write("                                    tabindex=\"0\"></iframe>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-6\">\n");
      out.write("                            <div class=\"wow fadeInUp\" data-wow-delay=\"0.2s\">\n");
      out.write("                                <form>\n");
      out.write("                                    <div class=\"row g-3\">\n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <div class=\"form-floating\">\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" id=\"name\" placeholder=\"Your Name\">\n");
      out.write("                                                <label for=\"name\">Your Name</label>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <div class=\"form-floating\">\n");
      out.write("                                                <input type=\"email\" class=\"form-control\" id=\"email\" placeholder=\"Your Email\">\n");
      out.write("                                                <label for=\"email\">Your Email</label>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-12\">\n");
      out.write("                                            <div class=\"form-floating\">\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" id=\"subject\" placeholder=\"Subject\">\n");
      out.write("                                                <label for=\"subject\">Subject</label>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-12\">\n");
      out.write("                                            <div class=\"form-floating\">\n");
      out.write("                                                <textarea class=\"form-control\" placeholder=\"Leave a message here\" id=\"message\" style=\"height: 150px\"></textarea>\n");
      out.write("                                                <label for=\"message\">Message</label>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-12\">\n");
      out.write("                                            <button class=\"btn btn-primary w-100 py-3\" type=\"submit\">Send Message</button>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- Contact End -->\n");
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
}
