<%@ page import="com.happycart.web.application.dto.AuthDTO" %>
<%@ page import="com.happycart.web.application.service.MessageService" %>
<%@ page import="com.happycart.web.application.service.UserService" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <!-- Google Font: Source Sans Pro -->
    <!-- <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback"> -->
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${BASE_URL}assets/plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="${BASE_URL}assets/https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Tempusdominus Bootstrap 4 -->
    <link rel="stylesheet" href="${BASE_URL}assets/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="${BASE_URL}assets/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
    <!-- JQVMap -->
    <link rel="stylesheet" href="${BASE_URL}assets/plugins/jqvmap/jqvmap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${BASE_URL}assets/dist/css/adminlte.min.css">
    <!-- overlayScrollbars -->
    <link rel="stylesheet" href="${BASE_URL}assets/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
    <!-- Daterange picker -->
    <link rel="stylesheet" href="${BASE_URL}assets/plugins/daterangepicker/daterangepicker.css">
    <!-- summernote -->
    <link rel="stylesheet" href="${BASE_URL}assets/plugins/summernote/summernote-bs4.min.css">





</head>

<body>
    <nav class="navbar navbar-expand navbar-white navbar-light">
        <!-- Left navbar links -->
        <ul class="navbar-nav">
            <li class="nav-item d-none d-sm-inline-block">
                <p class="p-2" > <b> Welcome</b> |</p>
            </li>
            <%
                if(session.getAttribute("user") != null ){
            %>
            <c:set var="user" value='<%= (AuthDTO) session.getAttribute("user")%>'/>

                <li class="nav-item">

                    <p class="p-2"><b><c:out value="${user.getEmail()}"/></b> |</p>

                </li>
                <li class="nav-item d-none d-sm-inline-block">
                    <p class="nav-link" onclick='ABC();'>Sign Out</p>
                </li>
            <%
            } else{
            %>
                <li class="nav-item">
                    <p class="p-2"><b>
                            <a href="login">Sign In or Register</a>
                        </b> |</p>

                </li>
            <%
                }
            %>


            <li class="nav-item d-none d-sm-inline-block">
                <a href="contact-us" class="nav-link">Contact</a>
            </li>
        </ul>

        <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">
            <!-- Navbar Search -->
            <!-- <li class="nav-item">
                <a class="nav-link" data-widget="navbar-search" href="#" role="button">
                    <i class="fas fa-search"></i>
                </a>
                <div class="navbar-search-block">
                    <form class="form-inline">
                        <div class="input-group input-group-sm">
                            <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
                            <div class="input-group-append">
                                <button class="btn btn-navbar" type="submit">
                                    <i class="fas fa-search"></i>
                                </button>

                                <button class="btn btn-navbar" type="button" data-widget="navbar-search">
                                    <i class="fas fa-times"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </li> -->

            <!-- Messages Dropdown Menu -->
            <%
                if(session.getAttribute("user") != null ){
                    AuthDTO user = (AuthDTO) session.getAttribute("user");
                    String email = user.getEmail();
            %>
            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="far fa-comments"></i>
                    <c:set var="msgCont" value="<%= MessageService.getUserCount(email)%>"/>

                                            <span class="badge badge-danger navbar-badge"><c:out value="${msgCont}"/></span>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                    <c:set var="getAllMessage" value="<%= new MessageService().getAllMessage(email)%>"/>
                    <c:forEach var="msgData" items="${getAllMessage}" >
                    <%--                        <?php--%>

                    <%--                        while ($msgData = $msgRs->fetch_assoc()) {--%>

                    <%--                        ?>--%>
<%--                        <c:set var="getAllMessage" value=""/>--%>

                                                <a href="message?to_email=${msgData.get("to_email")}" class="dropdown-item">
                    <!-- Message Start -->

<%--                                                    <c:set var="emailTo" value='${msgData.get("to_email")}' />--%>
<%--                                                    <c:set var="rr" value="<%= new UserService().getUserDataWithPics(emailTo) %>" />--%>




                                                <%--                                <?php--%>

                    <%--                                $user_rs = Database::search("SELECT * FROM `users` INNER JOIN profile_image ON profile_image.users_email=users.email WHERE `email`='" . $msgData["to"] . "'");--%>
                    <%--                                $user_data = $user_rs->fetch_assoc();--%>


                    <%--                                ?>--%>



                    <div class="media">
<%--                                                            <img src="" alt="User Avatar" class="img-size-50 mr-3 img-circle">--%>
                        <div class="media-body">
                            <h3 class="dropdown-item-title">

                                <%--                                            <?php echo $user_data["fname"] . " " . $user_data["lname"]; ?>--%>
                                <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span>
                            </h3>
                            <%--                                        <p class="text-sm"><?php echo $msgData["content"]; ?></p>--%>
<%--                            <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> <?php echo $msgData["date_time"] ?></p>--%>
                        </div>
                    </div>
                    <!-- Message End -->
                    </a>
                    <div class="dropdown-divider"></div>
                    <%--                        <?php--%>

                    <%--                        }--%>

                    <%--                        ?>--%>
                        </c:forEach>


                    <a href="message" class="dropdown-item dropdown-footer">See All Messages</a>
                </div>
            </li>
            <%
                }
            %>

            <!-- Notifications Dropdown Menu -->
            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="far fa-bell"></i>
                    <span class="badge badge-warning navbar-badge">0</span>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                    <span class="dropdown-item dropdown-header">0 Notifications</span>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
<%--                        <i class="fas fa-envelope mr-2"></i> <?php echo $msgNum; ?> new messages--%>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-users mr-2"></i> 0 Updates
                        <span class="float-right text-muted text-sm"></span>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item dropdown-footer">See All Notifications</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-widget="fullscreen" href="#" role="button">
                    <i class="fas fa-expand-arrows-alt"></i>
                </a>
            </li>
            <li class="nav-item dropdown">
                <div class="nav-link" data-toggle="dropdown">
                    <button class="btn btn-light dropdown-toggle " type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                        My Happy Cart
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                        <li><a class="dropdown-item" onclick="manu('userprofile');">My Profile</a></li>
                        <li><a class="dropdown-item" onclick="manu('sellingHistory');">My Sellings</a></li>
                        <li><a class="dropdown-item" onclick="manu('myproduct');">My Products</a></li>
                        <li><a class="dropdown-item" onclick="manu('watchlist');">Wish List</a></li>
                        <li><a class="dropdown-item" onclick="manu('purchasehistory');">Purchase History</a></li>
                        <li><a class="dropdown-item" onclick="manu('message');">Messages</a></li>
                        <!-- <li><a class="dropdown-item" href="#">Saved</a></li> -->
                        <li><a class="dropdown-item" onclick="manu('addproduct');">Sell</a></li>
                    </ul>
                </div>
            </li>
        </ul>
    </nav>





    <!-- jQuery -->
    <script src="${BASE_URL}assets/plugins/jquery/jquery.min.js"></script>
    <!-- jQuery UI 1.11.4 -->
    <script src="${BASE_URL}assets/plugins/jquery-ui/jquery-ui.min.js"></script>
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <script>
        $.widget.bridge('uibutton', $.ui.button)
    </script>
    <!-- Bootstrap 4 -->
    <script src="${BASE_URL}assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- ChartJS -->
    <script src="${BASE_URL}assets/plugins/chart.js/Chart.min.js"></script>
    <!-- Sparkline -->
    <script src="${BASE_URL}assets/plugins/sparklines/sparkline.js"></script>
    <!-- JQVMap -->
    <script src="${BASE_URL}assets/plugins/jqvmap/jquery.vmap.min.js"></script>
    <script src="${BASE_URL}assets/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
    <!-- jQuery Knob Chart -->
    <script src="${BASE_URL}assets/plugins/jquery-knob/jquery.knob.min.js"></script>
    <!-- daterangepicker -->
    <script src="${BASE_URL}assets/plugins/moment/moment.min.js"></script>
    <script src="${BASE_URL}assets/plugins/daterangepicker/daterangepicker.js"></script>
    <!-- Tempusdominus Bootstrap 4 -->
    <script src="${BASE_URL}assets/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
    <!-- Summernote -->
    <script src="${BASE_URL}assets/plugins/summernote/summernote-bs4.min.js"></script>
    <!-- overlayScrollbars -->
    <script src="${BASE_URL}assets/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
    <!-- AdminLTE App -->
    <script src="${BASE_URL}assets/dist/js/adminlte.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="${BASE_URL}assets/dist/js/demo.js"></script>
    <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
    <script src="${BASE_URL}assets/dist/js/pages/dashboard.js"></script>
    <script src="${BASE_URL}assets/script.js"></script>
<script>
    function ABC() {
        var r = new XMLHttpRequest();

        r.onreadystatechange = function() {
            if (r.readyState == 4) {
                window.location.href = 'index';
            }
        }

        r.open("GET", "${BASE_URL}signOutProccess", true);
        r.send();
    }
</script>

</body>

</html>