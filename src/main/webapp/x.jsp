<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 12/03/2024
  Time: 17:48
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
    <div class="col-7">
        <h2>Danh sách hoá đơn</h2>
        <table class="table">
            <thead>
            <tr>
                <td>STT</td>
                <td>ID</td>
                <td>Ten khach hang</td>
                <td>Ngay tao</td>
                <td>Tong tien</td>
                <td>Trang Thai</td>
                <td>Chuc nang</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listHoaDon}" varStatus="i" var="x">
                <tr>
                    <td>${i.index}</td>
                    <td>${x.id}</td>
                    <td>${x.khachHang.hoTen}</td>
                    <td>${x.ngayTao}</td>
                    <td>Tong tien</td>
                    <td>${x.trangThai}</td>
                    <td><a href="/hoa-don/detail?idHoaDon=${x.id}" class="btn btn-primary">Chọn</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <h2>Danh sách hoá đơn chi tiết</h2>
        <table class="table">
            <thead>
            <tr>
                <td>STT</td>
                <td>ID</td>
                <td>Ten san pham</td>
                <td>So luong</td>
                <td>Gia ban</td>
                <td>Tong tien</td>
                <td>Chuc nang</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listHDCT}" varStatus="i" var="x">
                <tr>
                    <td>${i.index+1}</td>
                    <td>${x.id}</td>
                    <td>${x.chiTietSP.sanPham.ten_san_pham}</td>
                    <td>${x.soLuong}</td>
                    <td>${x.giaBan}</td>
                    <td>${x.tongTien}</td>
                    <td><a href="/hoa-don/delete?idHoaDon=${x.id}" class="btn btn-danger">Xóa</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="col-5">
        <h2>Tạo hoá đơn</h2>
        <div class="row">
            <div style="margin-bottom: 20px">
                <div>
                    <label class="mb-3 col-3">Số điện thoại</label>
                    <input type="text" class="col-7" name="sodt">
                </div>
                <a href="/searchKH?sdt=${sk.sdt}" class="btn btn-primary">Search</a>
            </div>
            <div class="mb-3">
                <label class="col-3">Ten Khach hang</label>
                <input type="text" class="col-7" readonly value="${sk.hoTen}">
            </div>
            <div class="mb-3">
                <label class="col-3">ID Hoa don</label>
                <input type="text" class="col-7" readonly>
            </div>
            <div class="mb-3">
                <label class="col-3">Tong tien</label>
                <input type="text" class="col-7" readonly>
            </div>
            <div>
                <button class="btn btn-primary">Tạo hoá đơn</button>
                <button class="btn btn-primary">Thanh toán</button>
            </div>
        </div>

    </div>
</div>
<div>
    <h2>Danh sách chi tiết sản phẩm</h2>
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
                    <a href="" class="btn btn-info">Chọn mua</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div style="float: right">
    <a href="/ServletHoaDon/HoaDon" class="btn btn-outline-secondary btn-sm">Hóa đơn</a>
    <a href="/ServletHoaDon/CTHD" class="btn btn-outline-secondary btn-sm">Chi Tiết Hóa Đơn</a>
    <a href="/Servlet-hienthi/sanpham" class="btn btn-outline-secondary btn-sm">Sản phẩm</a>
    <a href="/Servlet-hienthi/ctsp" class="btn btn-outline-secondary btn-sm">Chi Tiết Sản phẩm</a>
    <a href="/ServletHoaDon/KhachHang" class="btn btn-outline-secondary btn-sm">Khách hàng</a>
    <a href="/Servlet-hienthi/danhmuc" class="btn btn-outline-secondary btn-sm">Danh mục</a>
    <a href="/ServletMauSize/Mau" class="btn btn-outline-secondary btn-sm">Màu sắc</a>
    <a href="/ServletMauSize/Size" class="btn btn-outline-secondary btn-sm">Size</a>
    <a href="/servletX" class="btn btn-outline-secondary btn-sm">Bán hàng</a>
</div>
</body>
</html>
