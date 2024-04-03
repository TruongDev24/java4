<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 4/1/2024
  Time: 9:22 AM
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
<div class="row">
    <form action="/update/ctsp?id=${chiTietSPDetail.id}" class="row g-3 needs-validation" method="post">
        <div class="col-6 col-lg-6">
            <label for="exampleFormControlInput1" class="form-label">Sản phẩm</label>
            <select class="form-select" id="exampleFormControlInput1" name="idsp" required>
                <option selected value=""></option>
                <c:forEach items="${listSP}" var="ldm">
                    <option value="${ldm.id}" <c:if test="${ldm.id == chiTietSPDetail.id_sp.id}">selected</c:if>>
                            ${ldm.ten}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="col-6 col-lg-6">
            <label for="exampleFormControlInput6" class="form-label">Màu sắc</label>
            <select class="form-select" id="exampleFormControlInput6" name="idmau" required>
                <option selected value=""></option>
                <c:forEach items="${mau}" var="ldm">
                    <option value="${ldm.id}" <c:if test="${ldm.id == chiTietSPDetail.id_MauSac.id}">selected</c:if>>
                            ${ldm.ten}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="col-6 col-lg-6">
            <label for="exampleFormControlInput2" class="form-label">Size</label>
            <select class="form-select" id="exampleFormControlInput2" name="idsize" required>
                <option selected value=""></option>
                <c:forEach items="${listsize}" var="ldm">
                    <option value="${ldm.id}" <c:if test="${ldm.id == chiTietSPDetail.id_Size.id}">selected</c:if>>
                            ${ldm.ten}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="col-6 col-lg-6">
            <label for="exampleFormControlInput9" class="form-label">Giá bán</label>
            <input type="number" class="form-control" id="exampleFormControlInput9" name="gia" placeholder="" value="${chiTietSPDetail.giaBan}">
        </div>
        <div class="col-6 col-lg-6">
            <label for="exampleFormControlInput4" class="form-label">Số lượng tồn</label>
            <input type="number" class="form-control" id="exampleFormControlInput4" name="soluong" placeholder="" value="${chiTietSPDetail.soLuong}">
        </div>
        <div class="col-6 col-lg-6 form-check">
            <label class="form-label">Trạng thái</label>
            <div style="display: flex">
                <div class="form-check" style="margin-right: 60px">
                    <input class="form-check-input" type="radio" name="Rdo" id="flexRadioDefault2" value="Active"
                           <c:if test="${chiTietSPDetail.trangThai == 'Active'}">checked</c:if>>
                    <label class="form-check-label" for="flexRadioDefault2">
                        Active
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="Rdo" id="flexRadioDefault1" value="Inactive"
                           <c:if test="${chiTietSPDetail.trangThai == 'Inactive'}">checked</c:if>>
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
</body>
</html>
