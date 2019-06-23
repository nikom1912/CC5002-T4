package controller;

import model.Conection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/Comentar")
public class Comentar extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if(id == null){
            response.getWriter().write("<script> alert(' Problemas a leer la imagen' ); </script> ");
            request.getRequestDispatcher("/tarea3/index.php").forward(request, response);

        }
        try {
            Conection con = new Conection("localhost", "tarea2", "root", "");
            // Conection con = new Conection("localhost", "cc500221_db", "cc500221_u", "nissimnullaD");
            String query = "SELECT id, ruta_archivo as ruta, nombre_archivo as nombre FROM foto_mascota WHERE id=" + "'" + id + "';";
            String query2 = "SELECT id, comentario, fecha  FROM comentario_foto_mascota WHERE foto_mascota=" + "'" + id + "' ORDER BY fecha DESC;";
            ResultSet rs = con.ejecutarSelect(query);
            ResultSet rs2 = con.ejecutarSelect(query2);
            request.setAttribute("imagen", rs);
            request.setAttribute("comentarios", rs2);
            request.getRequestDispatcher("/tarea4/comentar.jsp").forward(request,response);
            con.desconectar();

        } catch (SQLException e) {
            response.getWriter().write("<script> alert(' Problemas a leer la imagen' ); </script> ");
            response.sendRedirect("/tarea3/index.php");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
