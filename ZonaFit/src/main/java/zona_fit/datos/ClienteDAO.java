package zona_fit.datos;

import zona_fit.conexion.Conexion;
import zona_fit.dominio.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static zona_fit.conexion.Conexion.getConexion;

public class ClienteDAO implements IClienteDAO {
    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs; // Objeto para recuperar informacion
        Connection con = getConexion();
        var sql = "SELECT * FROM cliente ORDER BY id";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                var cliente = new Cliente();
                cliente.setId(rs.getInt("Id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                clientes.add(cliente);
            }
        } catch (Exception e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }

        }
        return clientes;
    }

    @Override
    public boolean buscarClientePorId(Cliente cliente) {
        PreparedStatement ps;
        ResultSet rs;
        var con = getConexion();
        var sql = "SELECT * FROM cliente WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error al recuperar cliente por id: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al crear conexion: " + e.getMessage());
            }

        }
        return false;
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "INSERT INTO cliente(nombre, apellido, membresia) " +" VALUES(?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getMembresia());
            ps.execute();
            return true;

        }catch (Exception e){
            System.out.println("Error al agregar cliente: " + e.getMessage());
        }finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean modificarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = getConexion();
        var sql = "UPDATE cliente SET nombre = ?, apellido = ?, membresia=? " + " WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getMembresia());
            ps.execute();
            return true;

        }catch (Exception e){
            System.out.println("Error al modificar cliente: " + e.getMessage());
        }finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = getConexion();
        var sql = "DELETE FROM cliente WHERE id = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,cliente.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
        }finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }

    public static void main(String[] args) {

        IClienteDAO clienteDAO = new ClienteDAO();

        // Listar Clientes
//        System.out.println("\n--- Listar Clientes ---");
//        IClienteDAO clienteDAO = new ClienteDAO();
//        var clientes = clienteDAO.listarClientes();
//        clientes.forEach(System.out::println);

        //Buscar por id
//        System.out.print("Insertar id a recuperar: " );
//        var consola = new Scanner(System.in).nextLine();
//        Integer.parseInt(consola);
//        var cliente1 = new Cliente(Integer.parseInt(consola));
//        System.out.println("Cliente antes de la busqueda: " + cliente1);
//        var encontrado = clienteDAO.buscarClientePorId(cliente1);
//        if (encontrado)
//            System.out.println("Cliente encontrado: " + cliente1);
//        else
//            System.out.println("No se encontro cliente");


        //Agregar cliente
//        var nuevoCLiente = new Cliente("Jose", "Martinez",400);
//        var agregado = clienteDAO.agregarCliente(nuevoCLiente);
//        if (agregado)
//            System.out.println("Cliente agregado: " + nuevoCLiente);
//        else
//            System.out.println("No se agrego el cliente: " + nuevoCLiente);

        var EliminarCliente = new Cliente(11);
        var Eliminado = clienteDAO.eliminarCliente(EliminarCliente);
        if (Eliminado)
            System.out.println("Cliente eliminado con exito: " + EliminarCliente);
        else
            System.out.println("No se pudo eliminar");

        // Listar clientes
        System.out.println("*** Listar Clientes ***");
        var clientes = clienteDAO.listarClientes();
        clientes.forEach(System.out::println);





    }
}
