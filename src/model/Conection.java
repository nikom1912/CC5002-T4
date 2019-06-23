package model;


import java.sql.*; // pack
/*

Conexion a DB
    Anakena: $mysql = new mysqli("localhost", 'cc500221_u', 'nissimnullaD','cc500221_db');
    Local: $mysql = new mysqli("localhost", 'root', '','tarea2')
 */
public class Conection {
    private Connection con; // Establecer la conexión
    private Statement sen;  // Ejecutar consultas
    private ResultSet rs;   // Recorrer los resultados (Tabla)

    // localhost --> ip --> mysql --> afuera
    public Conection(String server, String bd, String user, String pass) throws SQLException, ClassNotFoundException{
        String protocolo = "jdbc:mysql://";
        String lineaUser = "user="+user;
        String lineaPass = "password="+pass;
        String tz = "useLegacyDatetimeCode=false&serverTimezone=America/Santiago";

        String url = protocolo +
                server + "/" +
                bd + "?" +
                lineaUser + "&" +
                lineaPass +
                tz;
        if(pass.equals("")) url = protocolo +
                server + "/" +
                bd + "?" +
                lineaUser + "&" +
                tz;

        System.out.println(url);

        Class.forName("com.mysql.cj.jdbc.Driver"); // jar, INCLUIR!!!!!
        con = DriverManager.getConnection(url);
    }

    /*
    consultas actualizan los datos --> delete, insert, update
    ver datos --> select
    */

    // insert, delete, update
    public void ejecutar(String query) throws SQLException{
        sen = con.createStatement();
        sen.executeUpdate(query);
        desconectar();
    }

    // select
    public ResultSet ejecutarSelect(String query) throws SQLException{
        sen = con.createStatement();
        rs = sen.executeQuery(query);
        return rs;
    }

    public void desconectar() throws SQLException{
        sen.close();
    }
}
