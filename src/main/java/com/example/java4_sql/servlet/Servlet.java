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

@WebServlet(name = "Servlet-hienthi", value = {"/Servlet-hienthi", "/Servlet-hienthi/sanpham", "/Servlet-hienthi/ctsp"})
public class Servlet extends HttpServlet {

    ArrayList<DanhMuc> dmuc;
    ArrayList<SanPham> spham;
    ArrayList<ChiTietSP> ct;
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
            request.getRequestDispatcher("/san-pham.jsp").forward(request, response);
        } else if (uri.equals("/Servlet-hienthi/ctsp")){
            ct = new ChiTietSanPhamREPO().getList();
            request.setAttribute("listCTSP", ct);
            request.getRequestDispatcher("/ChiTietSP.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
