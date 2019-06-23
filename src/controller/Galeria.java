package controller;

import model.Conection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/*

Conexion a DB
    Anakena: $mysql = new mysqli("localhost", 'cc500221_u', 'nissimnullaD','cc500221_db');
    Local: $mysql = new mysqli("localhost", 'root', '','tarea2')
 */

@WebServlet("/Galeria")
public class Galeria extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("12313131");
        try {
            Conection con = new Conection("localhost", "tarea2", "root", "");
            // Conection con = new Conection("localhost", "cc500221_db", "cc500221_u", "nissimnullaD");
            String query = "SELECT id, ruta_archivo as ruta, nombre_archivo as nombre, traslado_id as t_id FROM foto_mascota";
            ResultSet rs = con.ejecutarSelect(query);
            request.setAttribute("imagenes", rs);
            System.out.println("Cargado rs");
            request.getRequestDispatcher("/galeria.jsp").forward(request,response);
            con.desconectar();

        } catch (SQLException e) {
            response.sendError(404 , "Error Conexion a base de datos");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
