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

@WebServlet(name = "Servlet-hienthi", value = {"/Servlet-hienthi", "/Servlet-hienthi/sanpham", "/Servlet-hienthi/ctsp", "/Servlet/add-sp"})
public class Servlet extends HttpServlet {

    ArrayList<DanhMuc> dmuc;
    ArrayList<SanPham> spham;
    ArrayList<ChiTietSP> ct;
    SanPhamREPO sprp = new SanPhamREPO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.equals("/Servlet-hienthi")){
            dmuc = new DanhMucREPO().getList();
            request.setAttribute("listDM", dmuc);
            request.getRequestDispatcher("/trang-chu.jsp").forward(request, response);
        } else if (uri.equals("/Servlet-hienthi/sanpham")) {
            spham = new SanPhamREPO().getList();
            request.setAttribute("listSP", spham);
            dmuc = new DanhMucREPO().getList();
            request.setAttribute("listDM", dmuc);
            request.getRequestDispatcher("/san-pham.jsp").forward(request, response);
        } else if (uri.equals("/Servlet-hienthi/ctsp")){
            ct = new ChiTietSanPhamREPO().getList();
            request.setAttribute("listCTSP", ct);
            request.getRequestDispatcher("/ChiTietSP.jsp").forward(request, response);
        }
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
        DanhMuc dm = new DanhMuc();
        dm.setId(Integer.parseInt(danhmuc));
        spm.setId_danhMuc(dm);

        sprp.add(spm);
        response.sendRedirect("/Servlet-hienthi/sanpham");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/Servlet/add-sp")) {
            this.add(request, response);
        }
    }
}
