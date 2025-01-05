package maquina_snacks_archivos.servicio;

import maquina_snacks_archivos.dominio.Snack;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ServicioSnacksArchivos implements IServicioSnacks{
    private final String NOMBRE_ARCHIVO = "snacks.txt";

    // Crear la lista de snacks
    private List<Snack> snacks = new ArrayList<>();


    // Constructor de clase
    public ServicioSnacksArchivos(){
        //Creamos el archivo si no existe
        var archivo = new File(NOMBRE_ARCHIVO);
        var existe = false;
        try {
            existe = archivo.exists();
            if (existe){

                this.snacks = obtenerSnacks();

            }else { // Creamos el archivo
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close(); //Guarda el archivo en disco
                System.out.println("Se ha creado el archivo");

            }
        }catch (Exception e){
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
        // Si no existe, cargamos argunos snacks iniciales
        if (!existe)
            cargarSnacksIniciales();
    }

    private void cargarSnacksIniciales(){
        this.agregarSnack(new Snack("Papas", 70));
        this.agregarSnack(new Snack("Refresco", 50));
        this.agregarSnack(new Snack("Sandwich", 120));
    }

    private List<Snack> obtenerSnacks(){
        var snacks = new ArrayList<Snack>();
        try {
            List<String> lineas = Files.readAllLines(Paths.get(NOMBRE_ARCHIVO));
            for (var linea: lineas){
                String[] lineaSnack =  linea.split(",");// Parseo separado por coma
                var idSnack = lineaSnack[0]; // No se usa
                var nombre = lineaSnack[1];
                var precio = Double.parseDouble(lineaSnack[2]);
                var snack = new Snack(nombre,precio);
                snacks.add(snack); // Agregamos el snack leido a la lista
            }
        }catch (Exception e){
            System.out.println("Error al leer arhivo de snacks: " + e.getMessage());
            e.printStackTrace();
        }

        return snacks;
    }

    @Override
    public void agregarSnack(Snack snack) {
        //Agregar el nuevo snack, 1. a la lista en memoria
        this.snacks.add(snack);
        // 2. Guardamos el nuevo snack en el archivo
        this.agregarSnackArchivo(snack);
    }

    private void agregarSnackArchivo(Snack snack){
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(snack.escribirSnack());
            salida.close(); // Se escribe la informacion en el archivo
        }catch (Exception e){
            System.out.println("Error al agregar snack: " + e.getMessage());
        }
    }

    @Override
    public void mostrarSnacks() {
        System.out.println("\n--- Snacks en el inventario ---");
        //Mostramos la lista de snacks en el archivo
        var inventarioSnacks = "";
        for (var snacks: this.snacks){
            inventarioSnacks += snacks.toString() + "\n";
        }
        System.out.println(inventarioSnacks);
    }

    @Override
    public List<Snack> getSnacks() {
        return this.snacks;
    }
}
