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
<div style="text-align: center; margin-top: 30px"><h2><b>Sản phẩm</b></h2></div>
<hr>
<br>
<div class="row">
    <form action="/Servlet/add-sp" class="row g-3 needs-validation" method="post">
        <div class="col-6 col-lg-6">
            <label for="exampleFormControlInput1" class="form-label">Mã sản phẩm</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" name="maSP" placeholder="">
        </div>
        <div class="col-6 col-lg-6">
            <label for="exampleFormControlInput6" class="form-label">Tên sản phẩm</label>
            <input type="text" class="form-control" id="exampleFormControlInput6" name="tenSP" placeholder="">
        </div>
        <div class="col-6 col-lg-6">
            <label for="exampleFormControlInput2" class="form-label">Danh mục</label>
            <select class="form-select" id="exampleFormControlInput2" name="dmuc" required>
                <option selected value=""></option>
                <c:forEach items="${listDM}" var="ldm">
                    <option value="${ldm.id}">${ldm.ten_danh_muc}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-6 col-lg-6 form-check">
            <label class="form-label">Trạng thái</label>
            <div style="display: flex">
                <div class="form-check" style="margin-right: 60px">
                    <input class="form-check-input" type="radio" name="Rdo" id="flexRadioDefault2" value="Active"
                           checked>
                    <label class="form-check-label" for="flexRadioDefault2">
                        Active
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="Rdo" id="flexRadioDefault1" value="Inactive">
                    <label class="form-check-label" for="flexRadioDefault1">
                        Inactive
                    </label>
                </div>
            </div>
        </div>

        <div>
            <button type="submit" class="btn btn-success">Save</button>
        </div>
    </form>
</div>
<table class="table table-striped-columns">
    <thead>
    <tr>
        <td>ID</td>
        <td>Mã</td>
        <td>Tên</td>
        <td>Trạng thái</td>
        <td>Ngày tạo</td>
        <td>Ngày sửa</td>
        <td>Danh mục</td>
        <td>Chức năng</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listSP}" var="sp" varStatus="i">
        <tr>
            <td>${sp.id}</td>
            <td>${sp.ma}</td>
            <td>${sp.ten}</td>
            <td>${sp.trangThai}</td>
            <td>${sp.ngayTao}</td>
            <td>${sp.ngaySua}</td>
            <td>${sp.id_danhMuc.ten_danh_muc}</td>
            <td>
                <a href="" class="btn btn-info">Detail</a>
                <a onclick="" href="/Servlet/delete-sp?id=${sp.id}" class="btn btn-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div style="float: right">
    <a href="/Servlet-hienthi" class="btn btn-outline-secondary btn-sm">Danh mục</a>
    <a href="" class="btn btn-outline-secondary btn-sm">Kích thước</a>
    <a href="" class="btn btn-outline-secondary btn-sm">Màu sắc</a>
    <a href="/Servlet-hienthi/ctsp" class="btn btn-outline-secondary btn-sm">Chi Tiết Sản phẩm</a>
</div>
</body>
</html>
