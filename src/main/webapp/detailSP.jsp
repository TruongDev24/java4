<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 3/29/2024
  Time: 10:35 AM
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
<div style="text-align: center; margin-top: 30px"><h2><b>Detail</b></h2></div>
<hr>
<br>
<div class="row">
    <form action="/Servlet/update-sp" class="row g-3 needs-validation" method="post">
        <div class="col-6 col-lg-6">
            <label for="exampleFormControlInput1" class="form-label">Mã sản phẩm</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" name="maSP" value="${sanPham.ma}"
                   placeholder="">
        </div>
        <div class="col-6 col-lg-6">
            <label for="exampleFormControlInput6" class="form-label">Tên sản phẩm</label>
            <input type="text" class="form-control" id="exampleFormControlInput6" name="tenSP" value="${sanPham.ten}"
                   placeholder="">
        </div>
        <div class="col-6 col-lg-6">
            <label for="exampleFormControlInput2" class="form-label">Danh mục</label>
            <select class="form-select" id="exampleFormControlInput2" name="dmuc" required>
<%--                <c:forEach items="${listDM}" var="ldm">--%>
<%--                    <option value="${ldm.id}" <c:if test="${ldm.id == sanPham.DM.id}">selected</c:if>>--%>
<%--                            ${ldm.ten_danh_muc}--%>
<%--                    </option>--%>
<%--                </c:forEach>--%>

                <c:forEach items="${listDM}" var="dm">
                    <option value="${dm.id}"
                            <c:if test="${dm.id == sanPham.id}">selected </c:if>
                    >${dm.ten_danh_muc}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="col-6 col-lg-6 form-check">
            <label class="form-label">Trạng thái</label>
            <div style="display: flex">
                <div class="form-check" style="margin-right: 60px">
                    <input class="form-check-input" type="radio" name="Rdo" id="flexRadioDefault2" value="Active"
                           <c:if test="${sanPham.trangThai == 'Active'}">checked</c:if>>
                    <label class="form-check-label" for="flexRadioDefault2">
                        Active
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="Rdo" id="flexRadioDefault1" value="Inactive"
                           <c:if test="${sanPham.trangThai == 'Inactive'}">checked</c:if>>
                    <label class="form-check-label" for="flexRadioDefault1">
                        Inactive
                    </label>
                </div>
            </div>
        </div>

        <div>
            <button type="submit" class="btn btn-success">Update</button>
        </div>
    </form>
</div>
</body>
</html>
