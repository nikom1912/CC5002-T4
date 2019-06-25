package controller;

import com.google.gson.JsonObject;
import com.sun.javafx.collections.MappingChange;
import model.Conection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
@WebServlet("/XDia")
@MultipartConfig
public class XDia extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Conection con = new Conection("localhost", "tarea2", "root", "");
            // Conection con = new Conection("localhost", "cc500221_db", "cc500221_u", "nissimnullaD");
            String query = "SELECT YEAR(fecha_viaje) as year, MONTH(fecha_viaje) as month, DAY(fecha_viaje) as day, COUNT(*) as cuenta " +
                    "FROM traslado GROUP BY YEAR(fecha_viaje), MONTH(fecha_viaje), DAY(fecha_viaje) DESC;";
            ResultSet rs = con.ejecutarSelect(query);
            Map<String, String> xdia = new HashMap<>();
            while(rs.next()){
                String year = rs.getString(1);
                String month = rs.getString(2);
                String day = rs.getString(3);
                String cuenta = rs.getString(4);
                String fecha = year + "-" + month + "-" + day;
                xdia.put(fecha, cuenta);
            }
            response.getWriter().write(json);
            con.desconectar();


        } catch (SQLException e) {
            response.getWriter().write("<script> alert(' Problemas a leer la imagen' ); </script> ");
            response.sendRedirect("/tarea3/index.php");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
