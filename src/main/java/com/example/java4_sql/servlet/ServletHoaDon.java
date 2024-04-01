package com.example.java4_sql.servlet;

import com.example.java4_sql.model.ChiTietSP;
import com.example.java4_sql.model.HoaDon;
import com.example.java4_sql.model.HoaDonChiTiet;
import com.example.java4_sql.model.KhachHang;
import com.example.java4_sql.repo.ChiTietSanPhamREPO;
import com.example.java4_sql.repo.HoaDonREPO;
import com.example.java4_sql.repo.KhachHangREPO;
import com.example.java4_sql.repo.hdctREPO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletHoaDon", value = {"/ServletHoaDon/HoaDon", "/ServletHoaDon/KhachHang", "/ServletHoaDon/CTHD"})
public class ServletHoaDon extends HttpServlet {

    ArrayList<HoaDon> listHD = new HoaDonREPO().getList();
    ArrayList<KhachHang> listKH = new KhachHangREPO().getList();
    ArrayList<ChiTietSP> ct = new ChiTietSanPhamREPO().getList();
    ArrayList<HoaDonChiTiet> hoadonct = new hdctREPO().getList();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.equals("/ServletHoaDon/HoaDon")){
            request.setAttribute("hoadon", listHD);
            request.setAttribute("khachhang", listKH);
            request.getRequestDispatcher("/hoa-don.jsp").forward(request, response);
        } else if (uri.equals("/ServletHoaDon/KhachHang")) {
            request.setAttribute("khachhang", listKH);
            request.getRequestDispatcher("/khach-hang.jsp").forward(request, response);
        } else if (uri.equals("/ServletHoaDon/CTHD")) {
            request.setAttribute("hoadon", listHD);
            request.setAttribute("listCTSP", ct);
            request.setAttribute("listHDCT", hoadonct);
            request.getRequestDispatcher("/ct_hoadon.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
