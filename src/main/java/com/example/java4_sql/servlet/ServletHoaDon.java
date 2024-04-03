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
import java.util.Date;

@WebServlet(name = "ServletHoaDon", value = {"/ServletHoaDon/HoaDon", "/ServletHoaDon/KhachHang", "/ServletHoaDon/CTHD",
        "/add/khachhang", "/update/khachhang", "/detail/khachhang", "/delete/khachhang"})
public class ServletHoaDon extends HttpServlet {

    ArrayList<HoaDon> listHD = new HoaDonREPO().getList();
    ArrayList<KhachHang> listKH;
    ArrayList<ChiTietSP> ct = new ChiTietSanPhamREPO().getList();
    ArrayList<HoaDonChiTiet> hoadonct = new hdctREPO().getList();

    KhachHangREPO krp = new KhachHangREPO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/ServletHoaDon/HoaDon")) {
            request.setAttribute("hoadon", listHD);
            request.setAttribute("khachhang", listKH);
            request.getRequestDispatcher("/hoa-don.jsp").forward(request, response);
        } else if (uri.equals("/ServletHoaDon/KhachHang")) {
            listKH = new KhachHangREPO().getList();
            request.setAttribute("khachhang", listKH);
            request.getRequestDispatcher("/khach-hang.jsp").forward(request, response);
        } else if (uri.equals("/ServletHoaDon/CTHD")) {
            request.setAttribute("hoadon", listHD);
            request.setAttribute("listCTSP", ct);
            request.setAttribute("listHDCT", hoadonct);
            request.getRequestDispatcher("/ct_hoadon.jsp").forward(request, response);
        } else if (uri.equals("/detail/khachhang")) {
            this.detailKH(request, response);
        } else if (uri.equals("/delete/khachhang")) {
            this.deleteKH(request, response);
        }
    }

    private void deleteKH(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        KhachHang khg = krp.getDetail(id);
        krp.delete(khg);
        response.sendRedirect("/ServletHoaDon/KhachHang");
    }

    private void detailKH(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        KhachHang khg = krp.getDetail(id);
        request.setAttribute("khachhang", khg);
        request.getRequestDispatcher("/detailKhachHang.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/add/khachhang")) {
            String hoten = request.getParameter("hoten");
            String diachi = request.getParameter("diachi");
            String sdt = request.getParameter("sodt");
            String status = request.getParameter("Rdo");
            if (request.getParameter("Rdo") == "Active") {
                status = "Active";
            } else if (request.getParameter("Rdo") == "Inactive") {
                status = "Inactive";
            }

            KhachHang kh = new KhachHang();
            kh.setHoTen(hoten);
            kh.setDiaChi(diachi);
            kh.setSdt(sdt);
            kh.setTrangThai(status);
            kh.setNgayTao(new Date());
            kh.setNgaySua(new Date());

            krp.add(kh);
            response.sendRedirect("/ServletHoaDon/KhachHang");
        } else if (uri.equals("/update/khachhang")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            String hoten = request.getParameter("hoten");
            String diachi = request.getParameter("diachi");
            String sdt = request.getParameter("sodt");
            String status = request.getParameter("Rdo");
            if (request.getParameter("Rdo") == "Active") {
                status = "Active";
            } else if (request.getParameter("Rdo") == "Inactive") {
                status = "Inactive";
            }

            KhachHang kh = krp.getDetail(id);
            kh.setId(id);
            kh.setHoTen(hoten);
            kh.setDiaChi(diachi);
            kh.setSdt(sdt);
            kh.setTrangThai(status);
            kh.setNgaySua(new Date());

            krp.update(kh);
            response.sendRedirect("/ServletHoaDon/KhachHang");
        }
    }
}
