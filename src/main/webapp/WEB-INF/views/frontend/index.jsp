<%@ page import="com.happycart.web.application.service.ProductService" %>
<%@ taglib uri="http://callidora.lk/jsp/template-inheritance" prefix="layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib uri="jakarta.tags.core" prefix="c" %>--%>

<!DOCTYPE html>


<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="${BASE_URL}assets/resources/img/logo.svg">
    <link rel="stylesheet" href="${BASE_URL}assets/style.css">
    <title>Happy Cart | Home</title>

    <!-- SweetAlert2 -->
    <link rel="stylesheet" href="${BASE_URL}assets/plugins/sweetalert2-theme-bootstrap-4/bootstrap-4.min.css">
    <!-- Toastr -->
    <link rel="stylesheet" href="${BASE_URL}assets/plugins/toastr/toastr.min.css">


</head>

<body>
<%--<jsp:include page="../frontend/include/header.jsp"/>--%>
<c:import url="../frontend/include/header.jsp" />

    <hr class="hr-break-1" />

    <div class="col-12 justify-content-center">
        <div class="row mb-3">

            <div class="col-4 col-lg-1 offset-4 offset-lg-1 logo-img"></div>

            <div class="col-8 col-lg-6">
                <div class="input-group input-group-lg mt-3 mb-3">
                    <input type="text" class="form-control" aria-label="Text input with dropdown button" id="basic_search_text" />

                    <select class="btn btn-outline-success" id="basic_search_select">
                        <option value="0" readonly>Select Category</option>

                        <c:set var="newCategoryService" value="<%= new ProductService().getAllCategories()%>"/>
                       <c:forEach var="newCategory" items="${newCategoryService}">
                                            <option value="${newCategory.get("id")}" >${newCategory.get("category_name")}</option>
                                        </c:forEach>

                    </select>

                </div>
            </div>

            <div class="col-2 d-grid gap-2">
                <button class="btn btn-success mt-3 search-btn" onclick="basicSearch(0);">Search</button>
            </div>

            <div class="col-2 mt-4">
                <a href="advancedSearch.jsp" class="link-secondary link-1">Advanced</a>
            </div>

        </div>
    </div>

    <hr class="hr-break-1" />

    <div class="col-12" id="basicSearchResult">

        <div class="col-12 d-none d-lg-block">
            <div class="row">
                <div id="carouselExampleCaptions" class="col-8 offset-2 carousel slide" data-bs-ride="carousel">
                    <div class="carousel-indicators">
                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
                    </div>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="${BASE_URL}assets/resources/slider images/posterimg.png" class="d-block poster-img-1">
                            <div class="carousel-caption d-none d-md-block poster-caption">
                                <h5 class="poster-title">Welcome to Happy Cart</h5>
                                <p class="poster-text" >The World's Best Online Store By One Click.</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="${BASE_URL}assets/resources/slider images/posterimg2.jpg" class="d-block poster-img-1">
                        </div>
                        <div class="carousel-item">
                            <img src="${BASE_URL}assets/resources/slider images/posterimg3.jpg" class="d-block poster-img-1">
                            <div class="carousel-caption d-none d-md-block poster-caption-1">
                                <h5 class="poster-title">Be Free...</h5>
                                <p class="poster-text">Experience the Lowest Delivery Costs With Us.</p>
                            </div>
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </div>
        </div>

        <c:forEach var="newCategory" items="${newCategoryService}">
            <c:set var="categoryId" value='${newCategory.get("id")}' />
            <!-- Category name -->
            <div class="col-12">
                <a href="#" class="link-dark link2">${newCategory.get("category_name")}</a>&nbsp;&nbsp;
                <a href="#" class="link-dark link3">See All&nbsp; &rarr;</a>
            </div>
            <!-- Category name -->

            <!-- Products -->

            <div class="col-12 mb-3">

                <div class="row border border-primary">

                    <div class="col-12 col-lg-12">

                        <div class="row justify-content-center gap-2">

<%--                            <?php--%>

<%--                            $productrs = Database::search("SELECT * FROM `product` WHERE `category_id` = '" . $d["id"] . "' AND `status` = '1' ORDER BY `datetime_added` DESC LIMIT 4 OFFSET 0");--%>

<%--                            $pn = $productrs->num_rows;--%>


<%--                            for ($z = 0; $z < $pn; $z++) {--%>

<%--                                $pd = $productrs->fetch_assoc();--%>

<%--                            ?>--%>

<c:set var="product" value="<%= new ProductService()%>"/>
<%--    <label>${BASE_URL}assets/resources/product_img/63bf8c4ad6e38.png</label>--%>
    <c:forEach var="getProduct" items="${product.getProductByCategory(categoryId)}">
<%--        <option value="${getProduct.getId()}" >${getProduct.getId()}</option>--%>


                                <div class="card col-6 col-lg-2 mt-2 mb-2" style="width: 18rem;">

<%--                                    <?php--%>

<%--                                    $imagers = Database::search("SELECT * FROM `images` WHERE `product_id` = '" . $pd["id"] . "'");--%>
<%--                                    $image = $imagers->fetch_assoc();--%>


<%--                                    ?>--%>
    <c:set var="getProImg" value="<%= new ProductService()%>"/>
    <c:set var="getimg" value='${getProImg.getImagesByProductId(getProduct.getId())}'/>

                                    <img src="${getimg.getCode()}" class="card-img-top img-thumbnail" style="height: 200px;" />
                                    <div class="card-body ms-0 m-0">
                                        <h5 class="card-title">${getProduct.getTitle()}<span class="badge bg-info">New</span></h5>
                                        <span class="card-text text-primary">RS.${getProduct.getPrice()}.00</span>
                                        <br />

                                        <c:if test="${getProduct.getQty()>0}" >

                                            <span class="card-text text-warning"><b>In Stock</b></span>
                                            <br />
                                            <span class="card-text text-success fw-bold">${getProduct.getQty()} Items Available</span>
                                            <a href='singleProductView?id=${getProduct.getId()}' class="btn btn-success col-12">Buy Now</a>
                                            <a onclick="addToCart(${getProduct.getId()})" class="btn btn-danger col-12 mt-1" >Add to Cart</a>
                                        </c:if>
                                        <c:if test="${getProduct.getQty()<=0}" >
                                            <span class="card-text text-danger"><b>Out Of Stock</b></span>
                                            <br />
                                            <span class="card-text text-success fw-bold">00 Items Available</span>
                                            <a href="#" class="btn btn-success col-12 disabled">Buy Now</a>
                                            <a href="#" class="btn btn-danger col-12 mt-1 disabled">Add to Cart</a>

                                        </c:if>

                                        <%
                                            if(session.getAttribute("user") != null ){
                                        %>
                                        <c:set var="watchlist" value="<%= new ProductService()%>"/>
                                        <c:set var="watchListDetails" value='${watchlist.watchList(getProduct.getId(),session.getAttribute("user").getEmail())}'/>
<c:if test="${watchListDetails.getId()>=1}">
    <a class="btn btn-secondary col-12 mt-1" onclick="addToWatchlist(${getProduct.getId()});">
        <i class="bi bi-heart-fill fs-5 text-danger" id="heart${getProduct.getId()}"></i></a>
</c:if>
                                        <c:if test="${watchListDetails.getId()==0}">
                                            <a class="btn btn-secondary col-12 mt-1" onclick="addToWatchlist(${getProduct.getId()});">
                                                <i class="bi bi-heart-fill fs-5 text-white" id="heart${getProduct.getId()}"></i></a>
                                        </c:if>


                                        <%
                                        }
                                        %>


                                    </div>

                                </div>
<%--                            <?php--%>
<%--                            }--%>

<%--                            ?>--%>
    </c:forEach>




                        </div>

                    </div>

                </div>

            </div>

            <!-- Products -->

        </c:forEach>


    </div>

<jsp:include page="../frontend/include/footer.jsp"/>


    <script src="${BASE_URL}assets/script.js"></script>
    <script src="${BASE_URL}assets/bootstrap.bundle.js"></script>
    <script src="${BASE_URL}assets/bootstrap.js"></script>

    <!-- SweetAlert2 -->
    <script src="${BASE_URL}assets/plugins/sweetalert2/sweetalert2.min.js"></script>
    <!-- Toastr -->
    <script src="${BASE_URL}assets/plugins/toastr/toastr.min.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="${BASE_URL}assets/dist/js/demo.js"></script>
    <!-- Page specific script -->

</body>

</html>