<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 4/1/2024
  Time: 9:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="container">
<div style="text-align: center; margin-top: 30px"><h2><b>Khách hàng</b></h2></div>
<hr>
<br>
<div class="row">
    <form action="/add/khachhang" class="row g-3 needs-validation" method="post">
        <div class="col-6 col-lg-6">
            <label for="exampleFormControlInput1" class="form-label">Họ tên</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" name="hoten" placeholder="">
        </div>
        <div class="col-6 col-lg-6">
            <label for="exampleFormControlInput6" class="form-label">Địa chỉ</label>
            <input type="text" class="form-control" id="exampleFormControlInput6" name="diachi" placeholder="">
        </div>
        <div class="col-6 col-lg-6">
            <label for="exampleFormControlInput7" class="form-label">Số điện thoại</label>
            <input type="text" class="form-control" id="exampleFormControlInput7" name="sodt" placeholder="">
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
        <td>Họ tên</td>
        <td>Địa chỉ</td>
        <td>Số điện thoại</td>
        <td>Trạng thái</td>
        <td>Ngày tạo</td>
        <td>Ngày sửa</td>
        <td>Chức năng</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${khachhang}" var="sp" varStatus="i">
        <tr>
            <td>${sp.id}</td>
            <td>${sp.hoTen}</td>
            <td>${sp.diaChi}</td>
            <td>${sp.sdt}</td>
            <td>${sp.trangThai}</td>
            <td>${sp.ngayTao}</td>
            <td>${sp.ngaySua}</td>
            <td>
                <a href="/detail/khachhang?id=${sp.id}" class="btn btn-info">Detail</a>
                <a onclick="" href="/delêt/khachhang?id=${sp.id}" class="btn btn-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div style="float: right">
    <a href="/ServletHoaDon/HoaDon" class="btn btn-outline-secondary btn-sm">Hóa đơn</a>
    <a href="/ServletHoaDon/CTHD" class="btn btn-outline-secondary btn-sm">Chi Tiết Hóa Đơn</a>
</div>
</body>
</html>
