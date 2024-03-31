package com.example.sd18308.servlet;

import com.example.sd18308.model.ChiTietSanPham;
import com.example.sd18308.model.HoaDon;
import com.example.sd18308.model.HoaDonChiTiet;
import com.example.sd18308.repository.ChiTietSanPhamRepo;
import com.example.sd18308.repository.HoaDonChiTietRepo;
import com.example.sd18308.repository.HoaDonRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "XServlet", value = {"/ban-hang",
        "/hoa-don/detail",
        "/hoa-don/thanh-toan",
        "/hoa-don/add",
})
public class XServlet extends HttpServlet {

    HoaDonRepo hoaDonRepo = new HoaDonRepo();

    ChiTietSanPhamRepo chiTietSanPhamRepo = new ChiTietSanPhamRepo();

    HoaDonChiTietRepo hoaDonChiTietRepo = new HoaDonChiTietRepo();

    ArrayList<HoaDon> listHoaDon = new ArrayList<>();

    ArrayList<ChiTietSanPham> listChiTietSanPham = new ArrayList<>();

    ArrayList<HoaDonChiTiet> listHDCT = new ArrayList<>();

    Double tongTien = Double.valueOf(0);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/ban-hang")) {
            listHoaDon = hoaDonRepo.getList();
            listChiTietSanPham = chiTietSanPhamRepo.getList();
            request.setAttribute("chiTietSanPham", listChiTietSanPham);
            request.setAttribute("listHoaDon", listHoaDon);
            request.getRequestDispatcher("x.jsp").forward(request, response);
        } else if (uri.contains("/hoa-don/detail")) {
            this.hoaDonDetail(request, response);
        } else if (uri.contains("/hoa-don/add")) {
            HoaDon hoaDon = new HoaDon();
            hoaDon.setNgayTao(new Date());
            hoaDon.setNgaySua(new Date());
            hoaDon.setTrangThai("Chua thanh toan");
            hoaDonRepo.add(hoaDon);
            response.sendRedirect("/ban-hang");
        }
    }

    private void hoaDonDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idHoaDon = Integer.parseInt(request.getParameter("idHoaDon"));
        HoaDon hoaDonDetail = hoaDonRepo.getDetail(idHoaDon);
        listHDCT = hoaDonChiTietRepo.getDetail(idHoaDon);
        tongTien = Double.valueOf(0);
        for (HoaDonChiTiet hoaDonChiTiet : listHDCT) {
            tongTien += hoaDonChiTiet.getTongTien();
        }
        request.setAttribute("tongTien", tongTien);
        request.setAttribute("listHDCT", listHDCT);
        request.setAttribute("hoaDonDetail", hoaDonDetail);
        request.setAttribute("chiTietSanPham", listChiTietSanPham);
        request.setAttribute("listHoaDon", listHoaDon);
        request.getRequestDispatcher("/x.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hoa-don/thanh-toan")) {
            Integer idHoaDon = Integer.parseInt(request.getParameter("idHoaDon"));
            HoaDon hoaDonDetail = hoaDonRepo.getDetail(idHoaDon);
            hoaDonDetail.setTrangThai("Da thanh toan");
            hoaDonDetail.setNgaySua(new Date());
            hoaDonRepo.add(hoaDonDetail);
            response.sendRedirect("/ban-hang");
        }

    }
}
