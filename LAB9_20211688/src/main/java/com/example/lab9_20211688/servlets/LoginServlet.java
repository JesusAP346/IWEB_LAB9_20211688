package com.example.lab9_20211688.servlets;
import com.example.lab9_20211688.beans.UsuarioB;
import com.example.lab9_20211688.daos.UsuarioDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;


@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession httpSession = request.getSession();
        UsuarioB usuarioLogeado = (UsuarioB) httpSession.getAttribute("usuarioLogueado");
        if(usuarioLogeado != null && usuarioLogeado.getIdUsuario() > 0){
            if(request.getParameter("a") != null){ //para hacer un logout
                httpSession.invalidate();//INVALIDATE borra atributos y deja la sesion en blanco
            }
            response.sendRedirect(request.getContextPath());
        }else{
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //System.out.println("username: " + username + " \npassword: " + password);
        UsuarioDao usuarioDao = new UsuarioDao();
        if(usuarioDao.validarUsuarioPasswordHashed(username,password)){
            UsuarioB usuarioB = usuarioDao.obtenerUsuario(username);
            HttpSession httpSession = request.getSession();//lo mandamos por sesion
            httpSession.setAttribute("usuarioLogueado",usuarioB);//session
            //System.out.println("usuario y password valido");
            response.sendRedirect(request.getContextPath());
            //Cuanto tiempo de inactivo voy a soportar sin que el usuario mande un get,post:
            httpSession.setMaxInactiveInterval(10*60); //60 minutos
        }
        else{
            //System.out.println("usuario o password incorrecto");
            request.setAttribute("err","Usuario o password incorrectos");//request
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}