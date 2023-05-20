package org.example;

import org.example.modelo.Libro;
import org.example.persistencia.DemoLibroDB;

public class Main {
    public static void main(String[] args) {
        DemoLibroDB demo = new DemoLibroDB();
        demo.insertarStatement();
        System.out.println("Con prepared");
        demo.insertarPreparedStatement();

        Libro libro = new Libro(1,"El Juego", "Desconocido");

        if(demo.insertarLibro(libro)){
            System.out.println("Se inserto correctamente");

        }else{
            System.out.println("No se inserto");
        }

        System.out.println(demo.buscarLibroPorId(6));

        System.out.println("-------------");
        for (Libro tmp:demo.obtenerTodos()){
            System.out.println("Libro: " + tmp);
            System.out.println("Titulo: " + tmp.getTitulo());

        }
    }
}