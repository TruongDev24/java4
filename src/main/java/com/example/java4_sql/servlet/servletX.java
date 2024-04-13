package com.example.java4_sql.servlet;

import com.example.java4_sql.model.*;
import com.example.java4_sql.repo.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "servletX", value = {"/servletX", "/searchKH", "/addHD", "/thanhToan", "/chonMua", "/xoaSP", "/chonHD"})
public class servletX extends HttpServlet {
    ArrayList<DanhMuc> dmuc;
    ArrayList<SanPham> spham;
    ArrayList<ChiTietSP> ct;
    ArrayList<MauSac> listMau;
    ArrayList<Size> listSize;
//    SanPhamREPO sprp = new SanPhamREPO();
//    DanhMucREPO dmrp = new DanhMucREPO();
//    ChiTietSanPhamREPO csprp = new ChiTietSanPhamREPO();
//    SizeREPO srp = new SizeREPO();
//    MauSacREPO mrp = new MauSacREPO();
    KhachHangREPO krp = new KhachHangREPO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.equals("/servletX")){
            ct = new ChiTietSanPhamREPO().getList();
            request.setAttribute("listCTSP", ct);
            spham = new SanPhamREPO().getList();
            request.setAttribute("listSP", spham);
            listMau = new MauSacREPO().getList();
            request.setAttribute("mau", listMau);
            listSize = new SizeREPO().getList();
            request.setAttribute("size", listSize);
            request.getRequestDispatcher("/x.jsp").forward(request, response);
        } else if (uri.equals("/searchKH")) {
            String sdt = request.getParameter("sodt");
            KhachHang k = krp.searchKH(sdt);
            request.setAttribute("sk", k);
            request.getRequestDispatcher("/servletX").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
