package com.example.java4_sql.servlet;

import com.example.java4_sql.model.MauSac;
import com.example.java4_sql.model.Size;
import com.example.java4_sql.repo.MauSacREPO;
import com.example.java4_sql.repo.SizeREPO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "ServletMauSize", value = {"/ServletMauSize/Mau", "/ServletMauSize/Size", "/ServletMauSize/Mau/add",
        "/ServletMauSize/Mau/update", "/ServletMauSize/Mau/detail", "/ServletMauSize/Mau/delete",
"/ServletMauSize/Size/add", "/ServletMauSize/Size/update", "/ServletMauSize/Size/detail", "/ServletMauSize/Size/delete"})
public class ServletMauSize extends HttpServlet {

    ArrayList<MauSac> listMau;
    ArrayList<Size> listSize;
    
    MauSacREPO mrp = new MauSacREPO();
    SizeREPO srp = new SizeREPO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.equals("/ServletMauSize/Mau")){
            listMau = new MauSacREPO().getList();
            request.setAttribute("mau", listMau);
            request.getRequestDispatcher("/MauSac.jsp").forward(request, response);
        } else if (uri.equals("/ServletMauSize/Size")) {
            listSize = new SizeREPO().getList();
            request.setAttribute("size", listSize);
            request.getRequestDispatcher("/Size.jsp").forward(request, response);
        } else if (uri.equals("/ServletMauSize/Mau/detail")) {
            this.detailMau(request, response);
        } else if (uri.equals("/ServletMauSize/Mau/delete")) {
            this.deleteMau(request, response);
        } else if (uri.equals("/ServletMauSize/Size/detail")) {
            this.detailSize(request, response);
        } else if (uri.equals("/ServletMauSize/Size/delete")) {
            this.deleteSize(request, response);
        }
    }

    private void deleteSize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Size s = srp.getDetail(id);
        srp.delete(s);
        response.sendRedirect("/ServletMauSize/Size");
    }

    private void detailSize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Size s = srp.getDetail(id);
        request.setAttribute("size", s);
        request.getRequestDispatcher("/suaSize.jsp").forward(request, response);
    }

    private void deleteMau(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        MauSac ms = mrp.getDetail(id);
        mrp.delete(ms);
        response.sendRedirect("/ServletMauSize/Mau");
    }

    private void detailMau(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        MauSac ms = mrp.getDetail(id);
        request.setAttribute("mausac", ms);
        request.getRequestDispatcher("/suaMauSac.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/ServletMauSize/Mau/add")) {
            this.addMau(request, response);
        } else if (uri.equals("/ServletMauSize/Mau/update")) {
            this.updateMau(request, response);
        } else if (uri.equals("/ServletMauSize/Size/add")) {
            this.addSize(request, response);
        } else if (uri.equals("/ServletMauSize/Size/update")) {
            this.updateSize(request, response);
        }
    }

    private void updateSize(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String status = request.getParameter("Rdo");
        if (request.getParameter("Rdo") == "Hoạt động") {
            status = "Hoạt động";
        } else if (request.getParameter("Rdo") == "Tạm ngưng") {
            status = "Tạm ngưng";
        }

        Size s = srp.getDetail(id);
        s.setId(id);
        s.setMa(ma);
        s.setTen(ten);
        s.setTrangThai(status);
        s.setNgaySua(new Date());

        srp.update(s);
        response.sendRedirect("/ServletMauSize/Size");
    }

    private void addSize(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String status = request.getParameter("Rdo");
        if (request.getParameter("Rdo") == "Hoạt động") {
            status = "Hoạt động";
        } else if (request.getParameter("Rdo") == "Tạm ngưng") {
            status = "Tạm ngưng";
        }

        Size s = new Size();
        s.setMa(ma);
        s.setTen(ten);
        s.setTrangThai(status);
        s.setNgayTao(new Date());
        s.setNgaySua(new Date());

        srp.add(s);
        response.sendRedirect("/ServletMauSize/Size");
    }

    private void updateMau(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String status = request.getParameter("Rdo");
        if (request.getParameter("Rdo") == "Active") {
            status = "Active";
        } else if (request.getParameter("Rdo") == "Inactive") {
            status = "Inactive";
        }

        MauSac ms = mrp.getDetail(id);
        ms.setId(id);
        ms.setMa(ma);
        ms.setTen(ten);
        ms.setTrangThai(status);
        ms.setNgaySua(new Date());

        mrp.update(ms);
        response.sendRedirect("/ServletMauSize/Mau");
    }

    private void addMau(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String status = request.getParameter("Rdo");
        if (request.getParameter("Rdo") == "Active") {
            status = "Active";
        } else if (request.getParameter("Rdo") == "Inactive") {
            status = "Inactive";
        }

        MauSac ms = new MauSac();
        ms.setMa(ma);
        ms.setTen(ten);
        ms.setTrangThai(status);
        ms.setNgayTao(new Date());
        ms.setNgaySua(new Date());

        mrp.add(ms);
        response.sendRedirect("/ServletMauSize/Mau");
    }
}
