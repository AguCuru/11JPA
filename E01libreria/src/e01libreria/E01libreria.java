
package e01libreria;

import entidades.Autor;
import entidades.Editorial;
import entidades.Libro;

import java.util.Scanner;
import persistencia.LibroDao;
import servicios.AutorServicio;
import servicios.EditorialServicio;
import servicios.LibroServicio;


public class E01libreria {

    public static void main(String[] args) throws Exception {
        AutorServicio as = new AutorServicio();
        EditorialServicio es = new EditorialServicio();
        LibroServicio ls = new LibroServicio();

        //es.crearEditorial();
        //es.imprimirEditoriales();
        //as.crearAutor();
        //as.imprimirAutores();
        //as.editarAutor();
        //as.eliminarAutor();
        
        //as.eliminarAutorXid();
        //as.imprimirAutores();
        //es.eliminarEditorialXid();
        //ls.crearLibro();
        
        //ls.editarLibro();
        ls.buscarXtitulo();
        ls.imprimirLibros();
        
//        Scanner leer = new Scanner (System.in);
//        String opcion = "";

//        do {
//            System.out.println("\n***********Menu******************");
//            System.out.println("1- Crear.");
//            System.out.println("2- Remove.");
//            System.out.println("3- Upload.");
//            System.out.println("4- Delete.");
//            System.out.println("5- Buscar.");
//            System.out.println("6- .");
//            System.out.println("7- .");
//            System.out.println("8- .");
//            System.out.println("9- Salir");
//            
//            System.out.println("Ingrese una opcion");
//            opcion = leer.next();
//            
//            switch (opcion) {
//                case "1":
//                    
//                    break;
//                default:
//                    throw new AssertionError();
//            }
//        } while (true); 

//        do {
//            System.out.println("\n***********Menu******************");
//            System.out.println("1- Autor.");
//            System.out.println("2- Editorial.");
//            System.out.println("3- Libro.");
//            System.out.println("4- Delete.");

//            System.out.println("9- Salir");
//            
//            System.out.println("Ingrese una opcion");
//            opcion = leer.next();
//            
//            switch (opcion) {
//                case "1":
//                    
//                    break;
//                default:
//                    throw new AssertionError();
//            }
//        } while (true); 

//        do {
//            System.out.println("\n***********Menu******************");
//            System.out.println("1- Autor.");
//            System.out.println("2- Editorial.");
//            System.out.println("3- Libro.");
//            System.out.println("4- Delete.");

//            System.out.println("9- Salir");
//            
//            System.out.println("Ingrese una opcion");
//            opcion = leer.next();
//            
//            switch (opcion) {
//                case "1":
//                    
//                    break;
//                default:
//                    throw new AssertionError();
//            }
//        } while (true); 


    }
}
    

