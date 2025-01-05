package zona_fit.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static Connection getConexion(){
        Connection connection = null;
        var baseDatos = "zona_fit_db";
        var url = "jdbc:mysql://localhost:3306/" + baseDatos;
        var usuario = "root";
        var password = "benja123.";
        try {
            //Clase de conexion
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,usuario,password);
        } catch (Exception e) {
            System.out.println("Error al conectarnos a la BD: " + e.getMessage());
        }

        return connection;
    }

    public static void main(String[] args) {
        var conexion = Conexion.getConexion();
        if (conexion != null)
            System.out.println("Conexion Exitosa: " + conexion);
        else
            System.out.println("Error al conectarse");
    }
}
