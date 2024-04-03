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
<div class="row">
    <form action="/add/ctsp" class="row g-3 needs-validation" method="post">
        <div class="col-6 col-lg-6">
            <label for="exampleFormControlInput1" class="form-label">Sản phẩm</label>
            <select class="form-select" id="exampleFormControlInput1" name="idsp" required>
                <option selected value=""></option>
                <c:forEach items="${listSP}" var="ldm">
                    <option value="${ldm.id}">${ldm.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-6 col-lg-6">
            <label for="exampleFormControlInput6" class="form-label">Màu sắc</label>
            <select class="form-select" id="exampleFormControlInput6" name="idmau" required>
                <option selected value=""></option>
                <c:forEach items="${mau}" var="ldm">
                    <option value="${ldm.id}">${ldm.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-6 col-lg-6">
            <label for="exampleFormControlInput2" class="form-label">Size</label>
            <select class="form-select" id="exampleFormControlInput2" name="idsize" required>
                <option selected value=""></option>
                <c:forEach items="${size}" var="ldm">
                    <option value="${ldm.id}">${ldm.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-6 col-lg-6">
            <label for="exampleFormControlInput9" class="form-label">Giá bán</label>
            <input type="number" class="form-control" id="exampleFormControlInput9" name="gia" placeholder="">
        </div>
        <div class="col-6 col-lg-6">
            <label for="exampleFormControlInput4" class="form-label">Sô lượng tồn</label>
            <input type="number" class="form-control" id="exampleFormControlInput4" name="soluong" placeholder="">
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
                <a href="/detail/ctsp?id=${sp.id}" class="btn btn-info">Detail</a>
                <a onclick="" href="/delete/ctsp?id=${sp.id}" class="btn btn-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div style="float: right">
    <a href="/Servlet-hienthi/danhmuc" class="btn btn-outline-secondary btn-sm">Danh mục</a>
    <a href="/Servlet-hienthi/sanpham" class="btn btn-outline-secondary btn-sm">Sản phẩm</a>
</div>
</body>
</html>
