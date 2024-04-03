package com.example.java4_sql.servlet;

import com.example.java4_sql.model.*;
import com.example.java4_sql.repo.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "Servlet-hienthi", value = {"/Servlet-hienthi/danhmuc", "/Servlet-hienthi/sanpham", "/Servlet-hienthi/ctsp",
        "/Servlet/add-sp", "/Servlet/update-sp", "/Servlet/delete-sp", "/Servlet/detail-sp",
        "/add/danhmuc", "/update/danhmuc", "/detail/danhmuc", "/delete/danhmuc",
        "/add/ctsp", "/update/ctsp", "/detail/ctsp", "/delete/ctsp"})
public class Servlet extends HttpServlet {

    ArrayList<DanhMuc> dmuc;
    ArrayList<SanPham> spham;
    ArrayList<ChiTietSP> ct;
    ArrayList<MauSac> listMau;
    ArrayList<Size> listSize;
    SanPhamREPO sprp = new SanPhamREPO();
    DanhMucREPO dmrp = new DanhMucREPO();
    ChiTietSanPhamREPO csprp = new ChiTietSanPhamREPO();
    SizeREPO srp = new SizeREPO();
    MauSacREPO mrp = new MauSacREPO();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/Servlet-hienthi/danhmuc")) {
            dmuc = new DanhMucREPO().getList();
            request.setAttribute("listDM", dmuc);
            request.getRequestDispatcher("/trang-chu.jsp").forward(request, response);
        } else if (uri.equals("/Servlet-hienthi/sanpham")) {
            spham = new SanPhamREPO().getList();
            request.setAttribute("listSP", spham);
            dmuc = new DanhMucREPO().getList();
            request.setAttribute("listDM", dmuc);
            request.getRequestDispatcher("/san-pham.jsp").forward(request, response);
        } else if (uri.equals("/Servlet-hienthi/ctsp")) {
            ct = new ChiTietSanPhamREPO().getList();
            request.setAttribute("listCTSP", ct);
            spham = new SanPhamREPO().getList();
            request.setAttribute("listSP", spham);
            listMau = new MauSacREPO().getList();
            request.setAttribute("mau", listMau);
            listSize = new SizeREPO().getList();
            request.setAttribute("size", listSize);
            request.getRequestDispatcher("/ChiTietSP.jsp").forward(request, response);
        } else if (uri.equals("/Servlet/delete-sp")) {
            this.delete(request, response);
        } else if (uri.equals("/Servlet/detail-sp")) {
            this.detail(request, response);
        } else if (uri.equals("/detail/danhmuc")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            DanhMuc dmuc = dmrp.getDetail(id);
            request.setAttribute("dmuc", dmuc);
            request.getRequestDispatcher("/suaDanhMuc.jsp").forward(request, response);
        } else if (uri.equals("/delete/danhmuc")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            DanhMuc dmuc = dmrp.getDetail(id);
            dmrp.delete(dmuc);
            response.sendRedirect("/Servlet-hienthi/danhmuc");
        } else if (uri.equals("/detail/ctsp")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            ChiTietSP chiTietSP = csprp.getDetail(id);
            spham = sprp.getList();
            request.setAttribute("listSP", spham);
            listMau = mrp.getList();
            request.setAttribute("mau", listMau);
            listSize = srp.getList();
            request.setAttribute("listsize", listSize);
            request.setAttribute("chiTietSPDetail", chiTietSP);

            request.getRequestDispatcher("/suaCTSP.jsp").forward(request, response);
        } else if (uri.equals("/delete/ctsp")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            ChiTietSP ct = csprp.getDetail(id);
            csprp.delete(ct);
            response.sendRedirect("/Servlet-hienthi/ctsp");
        }
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        SanPham sm = sprp.getDetail(id);
        request.setAttribute("sanPham", sm);
        dmuc = dmrp.getList();
        request.setAttribute("listDanhMuc", dmuc);
        request.getRequestDispatcher("/detailSP.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/Servlet/add-sp")) {
            this.add(request, response);
        } else if (uri.equals("/Servlet/update-sp")) {
            this.update(request, response);
        } else if (uri.equals("/add/danhmuc")) {
            this.addDM(request, response);
        } else if (uri.equals("/update/danhmuc")) {
            this.updateDM(request, response);
        } else if (uri.equals("/add/ctsp")) {
            this.addCTSP(request, response);
        } else if (uri.equals("/update/ctsp")) {
            this.updateCTSP(request, response);
        }
    }

    private void updateCTSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String sp = request.getParameter("idsp");
        String mau = request.getParameter("idmau");
        String size = request.getParameter("idsize");
        String gia = request.getParameter("gia");
        String sl = request.getParameter("soluong");
        String status = request.getParameter("Rdo");
        if (request.getParameter("Rdo") == "Active") {
            status = "Active";
        } else if (request.getParameter("Rdo") == "Inactive") {
            status = "Inactive";
        }

        ChiTietSP ctsanpham = csprp.getDetail(id);
        ctsanpham.setId(id);
        SanPham sp1 = new SanPham();
        sp1.setId(Integer.parseInt(sp));
        ctsanpham.setId_sp(sp1);

        MauSac ms1 = new MauSac();
        ms1.setId(Integer.parseInt(mau));
        ctsanpham.setId_MauSac(ms1);

        Size s1 = new Size();
        s1.setId(Integer.parseInt(size));
        ctsanpham.setId_Size(s1);

        ctsanpham.setGiaBan(gia);
        ctsanpham.setSoLuong(sl);
        ctsanpham.setTrangThai(status);
        ctsanpham.setNgaySua(new Date());

        csprp.add(ctsanpham);
        response.sendRedirect("/Servlet-hienthi/ctsp");
    }

    private void addCTSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sp = request.getParameter("idsp");
        String mau = request.getParameter("idmau");
        String size = request.getParameter("idsize");
        String gia = request.getParameter("gia");
        String sl = request.getParameter("soluong");
        String status = request.getParameter("Rdo");
        if (request.getParameter("Rdo") == "Active") {
            status = "Active";
        } else if (request.getParameter("Rdo") == "Inactive") {
            status = "Inactive";
        }

        ChiTietSP ctsanpham = new ChiTietSP();
        SanPham sp1 = new SanPham();
        sp1.setId(Integer.parseInt(sp));
        ctsanpham.setId_sp(sp1);

        MauSac ms1 = new MauSac();
        ms1.setId(Integer.parseInt(mau));
        ctsanpham.setId_MauSac(ms1);

        Size s1 = new Size();
        s1.setId(Integer.parseInt(size));
        ctsanpham.setId_Size(s1);

        ctsanpham.setGiaBan(gia);
        ctsanpham.setSoLuong(sl);
        ctsanpham.setTrangThai(status);
        ctsanpham.setNgayTao(new Date());
        ctsanpham.setNgaySua(new Date());

        csprp.add(ctsanpham);
        response.sendRedirect("/Servlet-hienthi/ctsp");
    }

    private void updateDM(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String status = request.getParameter("Rdo");
        if (request.getParameter("Rdo") == "Active") {
            status = "Active";
        } else if (request.getParameter("Rdo") == "Inactive") {
            status = "Inactive";
        }

        DanhMuc dm = dmrp.getDetail(id);
        dm.setId(id);
        dm.setMa_danh_muc(ma);
        dm.setTen_danh_muc(ten);
        dm.setTrang_thai(status);
        dm.setNgay_sua(new Date());

        dmrp.update(dm);
        response.sendRedirect("/Servlet-hienthi/danhmuc");
    }

    private void addDM(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String status = request.getParameter("Rdo");
        if (request.getParameter("Rdo") == "Active") {
            status = "Active";
        } else if (request.getParameter("Rdo") == "Inactive") {
            status = "Inactive";
        }

        DanhMuc dm = new DanhMuc();
        dm.setMa_danh_muc(ma);
        dm.setTen_danh_muc(ten);
        dm.setTrang_thai(status);
        dm.setNgay_tao(new Date());
        dm.setNgay_sua(new Date());

        dmrp.add(dm);
        response.sendRedirect("/Servlet-hienthi/danhmuc");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        SanPham sanPham = sprp.getDetail(id);
        sprp.delete(sanPham);
        response.sendRedirect("/Servlet-hienthi/sanpham");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String ma = request.getParameter("maSP");
        String ten = request.getParameter("tenSP");
        String danhmuc = request.getParameter("dmuc");
        String status = request.getParameter("Rdo");
        if (request.getParameter("Rdo") == "Active") {
            status = "Active";
        } else if (request.getParameter("Rdo") == "Inactive") {
            status = "Inactive";
        }

        SanPham spm = sprp.getDetail(id);
        spm.setId(id);
        spm.setMa(ma);
        spm.setTen(ten);
        spm.setTrangThai(status);
        spm.setNgaySua(new Date());
        DanhMuc dm = new DanhMuc();
        dm.setId(Integer.parseInt(danhmuc));
        spm.setId_danhMuc(dm);

        sprp.update(spm);
        response.sendRedirect("/Servlet-hienthi/sanpham");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("maSP");
        String ten = request.getParameter("tenSP");
        String danhmuc = request.getParameter("dmuc");
        String status = request.getParameter("Rdo");
        if (request.getParameter("Rdo") == "Active") {
            status = "Active";
        } else if (request.getParameter("Rdo") == "Inactive") {
            status = "Inactive";
        }
        SanPham spm = new SanPham();
        spm.setMa(ma);
        spm.setTen(ten);
        spm.setTrangThai(status);
        spm.setNgayTao(new Date());
        spm.setNgaySua(new Date());

        DanhMuc dm1 = new DanhMuc();
        dm1.setId(Integer.parseInt(danhmuc));
        spm.setId_danhMuc(dm1);

        sprp.add(spm);
        response.sendRedirect("/Servlet-hienthi/sanpham");
    }
}
