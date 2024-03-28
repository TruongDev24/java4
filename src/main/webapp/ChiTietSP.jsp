<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 3/23/2024
  Time: 1:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="container">
<%--<div style="text-align: center; color: red; margin-bottom: 30px"><h1>Đây là trang chủ</h1></div>--%>
<%--</h1>--%>
<%--<br/>--%>
<div style="text-align: center; margin-top: 30px"><h2><b>Chi Tiết Sản phẩm</b></h2></div>
<hr>
<br>
<table class="table table-striped-columns">
    <thead>
    <tr>
        <td>ID</td>
        <td>Tên sản phẩm</td>
        <td>Màu sắc</td>
        <td>Size</td>
        <td>Danh mục</td>
        <td>Giá bán</td>
        <td>Số lượng tồn</td>
        <td>Trạng thái</td>
        <td>Ngày tạo</td>
        <td>Ngày sửa</td>
        <td>Chức năng</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listCTSP}" var="sp" varStatus="i">
        <tr>
            <td>${sp.id}</td>
            <td>${sp.id_sp.ten}</td>
            <td>${sp.id_MauSac.ten}</td>
            <td>${sp.id_Size.ten}</td>
            <td>${sp.id_sp.id_danhMuc.ten_danh_muc}</td>
            <td>${sp.giaBan}</td>
            <td>${sp.soLuong}</td>
            <td>${sp.trangThai}</td>
            <td>${sp.ngayTao}</td>
            <td>${sp.ngaySua}</td>
            <td>
                <a href="" class="btn btn-info">Detail</a>
                <a onclick="" class="btn btn-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div style="float: right">
    <a href="/Servlet-hienthi" class="btn btn-outline-secondary btn-sm">Danh mục</a>
    <a href="" class="btn btn-outline-secondary btn-sm">Kích thước</a>
    <a href="" class="btn btn-outline-secondary btn-sm">Màu sắc</a>
    <a href="/Servlet-hienthi/sanpham" class="btn btn-outline-secondary btn-sm">Sản phẩm</a>
</div>
</body>
</html>
