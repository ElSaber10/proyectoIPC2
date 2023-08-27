package com.ipc2.todoweb.web.Libro;

import com.ipc2.todoweb.data.Conexion;
import com.ipc2.todoweb.data.LibroDB;
import com.ipc2.todoweb.model.Libro;
import com.ipc2.todoweb.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/listarLibros")
public class ListarLibrosServlet extends HttpServlet {

    private LibroDB libroDB;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //processRequest(request, response);
        HttpSession session = request.getSession();
        Connection connection = (Connection) session.getAttribute("conexion");
        libroDB = new LibroDB(connection);
        request.setAttribute("libro", libroDB.listar());
        request.getRequestDispatcher("libros/libros.jsp").forward(request, response);
        System.out.println("mostrando informacion en jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
