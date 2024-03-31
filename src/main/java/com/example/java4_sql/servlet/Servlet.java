package com.example.java4_sql.servlet;

import com.example.java4_sql.model.ChiTietSP;
import com.example.java4_sql.model.DanhMuc;
import com.example.java4_sql.model.SanPham;
import com.example.java4_sql.repo.ChiTietSanPhamREPO;
import com.example.java4_sql.repo.DanhMucREPO;
import com.example.java4_sql.repo.SanPhamREPO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "Servlet-hienthi", value = {"/Servlet-hienthi/danhmuc", "/Servlet-hienthi/sanpham", "/Servlet-hienthi/ctsp", "/Servlet/add-sp",
        "/Servlet/update-sp", "/Servlet/delete-sp", "/Servlet/detail-sp"})
public class Servlet extends HttpServlet {

    ArrayList<DanhMuc> dmuc = new DanhMucREPO().getList();
    ArrayList<SanPham> spham;
    ArrayList<ChiTietSP> ct;
    SanPhamREPO sprp = new SanPhamREPO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/Servlet-hienthi/danhmuc")) {
            request.setAttribute("listDM", dmuc);
            request.getRequestDispatcher("/trang-chu.jsp").forward(request, response);
        } else if (uri.equals("/Servlet-hienthi/sanpham")) {
            spham = new SanPhamREPO().getList();
            request.setAttribute("listSP", spham);
            request.setAttribute("listDM", dmuc);
            request.getRequestDispatcher("/san-pham.jsp").forward(request, response);
        } else if (uri.equals("/Servlet-hienthi/ctsp")) {
            ct = new ChiTietSanPhamREPO().getList();
            request.setAttribute("listCTSP", ct);
            request.getRequestDispatcher("/ChiTietSP.jsp").forward(request, response);
        } else if (uri.equals("/Servlet/delete-sp")) {
            this.delete(request, response);
        } else if (uri.equals("/Servlet/detail-sp")) {
            this.detail(request, response);
        }
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        SanPham sm = sprp.getDetail(id);
        request.setAttribute("sanPham", sm);
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
        }
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
