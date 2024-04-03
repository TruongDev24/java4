<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 4/1/2024
  Time: 8:46 AM
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
<div style="text-align: center; margin-top: 30px"><h2><b>Size</b></h2></div>
<hr>
<br>
<div class="row">
    <form action="/ServletMauSize/Size/add" class="row g-3 needs-validation" method="post">
        <div class="col-6 col-lg-6">
            <label for="exampleFormControlInput1" class="form-label">Mã size</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" name="ma" placeholder="">
        </div>
        <div class="col-6 col-lg-6">
            <label for="exampleFormControlInput6" class="form-label">Tên size</label>
            <input type="text" class="form-control" id="exampleFormControlInput6" name="ten" placeholder="">
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
        <td>Chức năng</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${size}" var="m" varStatus="i">
        <tr>
            <td>${m.id}</td>
            <td>${m.ma}</td>
            <td>${m.ten}</td>
            <td>${m.trangThai}</td>
            <td>${m.ngayTao}</td>
            <td>${m.ngaySua}</td>
            <td>
                <a href="/ServletMauSize/Size/detail?id=${m.id}" class="btn btn-info">Detail</a>
                <a onclick="" href="/ServletMauSize/Size/delete?id=${m.id}" class="btn btn-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div style="float: right">
    <a href="/ServletMauSize/Mau" class="btn btn-outline-secondary btn-sm">Màu sắc</a>
    <a href="" class="btn btn-outline-secondary btn-sm">Size</a>
</div>
</body>
</html>
