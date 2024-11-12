<%@ page import="com.happycart.web.application.service.ProductService" %><%--
  Created by IntelliJ IDEA.
  User: 1zt
  Date: 02/10/2023
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://callidora.lk/jsp/template-inheritance" prefix="layout" %>


<html>
<head>
    <title>Title</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<input type="number" placeholder="id" id="id"/><br><br>
<input type="text" placeholder="title" id="title"/><br><br>
<input type="text" placeholder="price" id="price"/><br><br>
<input type="text" placeholder="qty" id="qty"/><br><br>
<textarea id="description" name="description" placeholder="description" rows="4" cols="50"></textarea><br><br>
<input type="text" placeholder="delivery_fee_colombo" id="delivery_fee_colombo"/><br><br>
<input type="text" placeholder="delivery_fee_other" id="delivery_fee_other"/><br><br>

<button type="button" class="Save" >Save</button><br><br>


<button type="button" class="Update" >Update By ID</button><br><br>
<button type="button" class="Delete" >Delete By ID</button><br><br>
<button type="button" class="Search" >Search By ID</button>
<br><br>
<h1>Load all Product</h1>
<br>
<br>
<table id="example1">
    <tr>
        <th>Id</th>
        <th>delivery_fee_colombo</th>
        <th>delivery_fee_other</th>
        <th>description</th>
        <th>price</th>
        <th>qty</th>
        <th>title</th>
    </tr>
    <c:set var="producy" value="<%= new ProductService().getAllProduct()%>"/>

    <c:forEach var="newProduct" items="${producy}">
        <tr>
            <td>${newProduct.get("id")}</td>
            <td>${newProduct.get("delivery_fee_colombo")}</td>
            <td>${newProduct.get("delivery_fee_other")}</td>
            <td>${newProduct.get("description")}</td>
            <td>${newProduct.get("price")}</td>
            <td>${newProduct.get("qty")}</td>
            <td>${newProduct.get("title")}</td>
        </tr>
    </c:forEach>

</table>


</body>
<script type="text/javascript">


    document.getElementsByClassName('Save').item(0).addEventListener('click', function () {

        var title = document.getElementById("title").value;
        var price = document.getElementById("price").value;
        var qty = document.getElementById("qty").value;
        var description = document.getElementById("description").value;
        var delivery_fee_colombo = document.getElementById("delivery_fee_colombo").value;
        var delivery_fee_other = document.getElementById("delivery_fee_other").value;
        // alert("abct");

        fetch('addproduct',{
            method:'post',
            headers:{
                'Content-Type':'application/json'
            },
            body:JSON.stringify({
                title:title,
                price:price,
                qty:qty,
                description:description,
                delivery_fee_colombo:delivery_fee_colombo,
                delivery_fee_other:delivery_fee_other
            })
        }).then(response=> response.text())
            .then(text=>document.body.innerHTML=text);

    });

    document.getElementsByClassName('Update').item(0).addEventListener('click', function () {

        var id = document.getElementById("id").value;
        var title = document.getElementById("title").value;
        var price = document.getElementById("price").value;
        var qty = document.getElementById("qty").value;
        var description = document.getElementById("description").value;
        var delivery_fee_colombo = document.getElementById("delivery_fee_colombo").value;
        var delivery_fee_other = document.getElementById("delivery_fee_other").value;
        // alert("abct");

        fetch('updateproduct',{
            method:'post',
            headers:{
                'Content-Type':'application/json'
            },
            body:JSON.stringify({
                id:id,
                title:title,
                price:price,
                qty:qty,
                description:description,
                delivery_fee_colombo:delivery_fee_colombo,
                delivery_fee_other:delivery_fee_other
            })
        }).then(response=> response.text())
            .then(text=>document.body.innerHTML=text);

    });
    document.getElementsByClassName('Delete').item(0).addEventListener('click', function () {

        var id = document.getElementById("id").value;

        fetch('deleteproduct',{
            method:'post',
            headers:{
                'Content-Type':'application/json'
            },
            body:JSON.stringify(id)
        }).then(response=> response.text())
            .then(text=>document.body.innerHTML=text);

    });
    document.getElementsByClassName('Search').item(0).addEventListener('click', function () {

        var id = document.getElementById("id").value;
        fetch('searchproduct',{
            method:'post',
            headers:{
                'Content-Type':'application/json'
            },
            body:JSON.stringify(id)
        }).then(response=> response.text())
            .then(text=>document.body.innerHTML=text);

    });

</script>
</html>
