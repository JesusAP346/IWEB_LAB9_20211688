package com.example.lab9_20211688.servlets;
import com.example.lab9_20211688.beans.UsuarioB;
import com.example.lab9_20211688.daos.UsuarioDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


@WebServlet(name = "UsuarioServlet", urlPatterns ={"/UsuarioServlet",""} )
public class UsuarioServlet extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        //primero obtengo la lista del Dao
        UsuarioDao usuarioDao = new UsuarioDao();
        ArrayList<UsuarioB> listarUsuariosOperativos= usuarioDao.listarUsuariosOperativos();
        String vista;
        String action = request.getParameter("action")==null?"lista":request.getParameter("action");
        switch(action){
            case "lista":
                vista = "usuarios/listaUsuarios.jsp";
                request.setAttribute("lista",listarUsuariosOperativos);
                request.getRequestDispatcher(vista).forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        UsuarioDao usuarioDao = new UsuarioDao();
        String action = request.getParameter("action")==null?"crear":request.getParameter("action");

    }





}
