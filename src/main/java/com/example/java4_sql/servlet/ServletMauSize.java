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

@WebServlet(name = "ServletMauSize", value = {"/ServletMauSize/Mau", "/ServletMauSize/Size", "/ServletMauSize/Mau/add",
        "/ServletMauSize/Mau/update", "/ServletMauSize/Mau/detail", "/ServletMauSize/Mau/delete",
"/ServletMauSize/Size/add", "/ServletMauSize/Size/update", "/ServletMauSize/Size/detail", "/ServletMauSize/Size/delete"})
public class ServletMauSize extends HttpServlet {

    ArrayList<MauSac> listMau = new MauSacREPO().getList();
    ArrayList<Size> listSize = new SizeREPO().getList();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.equals("/ServletMauSize/Mau")){
            request.setAttribute("mau", listMau);
            request.getRequestDispatcher("/MauSac.jsp").forward(request, response);
        } else if (uri.equals("/ServletMauSize/Size")) {
            request.setAttribute("size", listSize);
            request.getRequestDispatcher("/Size.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
