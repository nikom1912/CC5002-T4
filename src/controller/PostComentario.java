package controller;

import model.Conection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@WebServlet("/PostComentario")
public class PostComentario extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String comentario = request.getParameter("comentario-mascota");
        System.out.println(comentario + "123123");
        if(id == null){
            response.sendRedirect("/tarea4/Galeria");
            response.getWriter().write("<script> alert(' Problemas a procesar comentario' ); </script> ");
        }
        try {
            Conection con = new Conection("localhost", "tarea2", "root", "");
            // Conection con = new Conection("localhost", "cc500221_db", "cc500221_u", "nissimnullaD");
            Timestamp tm = new Timestamp(System.currentTimeMillis());
            String query = "INSERT INTO comentario_foto_mascota (fecha, comentario, foto_mascota)" +
                    "VALUES ('" + tm + "', '" + comentario + "', '" + id + "');";
            con.ejecutar(query);
            con.desconectar();
            response.sendRedirect("/tarea4/Comentar?id=" + id);
            // request.getRequestDispatcher("/Comentar?id=" + id).forward(request, response);

        } catch (SQLException e) {
            response.sendError(404 , "Error Conexion a base de datos");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
