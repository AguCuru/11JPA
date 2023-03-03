
package servicios;

import entidades.Autor;
import entidades.Editorial;
import entidades.Libro;
import java.util.List;
import java.util.Scanner;
import persistencia.LibroDao;


public class LibroServicio {
    Scanner leer = new Scanner (System.in).useDelimiter("\n");
    private EditorialServicio editorialServicio;
    private AutorServicio autorServicio;
    private final LibroDao DAO;
    
    public LibroServicio(){
        this.DAO = new LibroDao();
    }

    public void setServicios(EditorialServicio editorialServicio,AutorServicio autorServicio){
        this.autorServicio = autorServicio;
        this.editorialServicio = editorialServicio;
    }
    
    public Libro crearLibro (){
        Libro libro = new Libro();
        
        try {
            System.out.println("Ingrese los datos solicitados a continuacion:");
            System.out.println("ISBN: ");
            System.out.println("Generado con numero aleatorios");
            libro.setIsbn( (long)(Math.random()*1000+1));
            //libro.setIsbn(leer.nextLong());
            System.out.println("Titulo: ");    
            libro.setTitulo(leer.next());
            System.out.println("Año: ");     
            libro.setAnio(leer.nextInt());
            System.out.println("Cantidad de ejemplares: ");     
            libro.setEjemplares(leer.nextInt());
            DAO.guardar(libro);
            return libro;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    
    public void imprimirLibros()  {
        try {
            List<Libro> libros = DAO.listarLibros();
            for (Libro libro : libros) {
                System.out.println(libro.getId() + " - " + libro.getTitulo());
            }
        } catch (Exception e) {
            System.out.println("No hay libros en la base de datos.");
        }

        
        
    }
    public void editarLibro() throws Exception {
        Libro edit; 
        System.out.println("Ingrese autor que desea editar");
        imprimirLibros();
        String tit = leer.next();
        edit= DAO.buscarPorTitulo(tit);
        System.out.println("-------------------------");
        System.out.println("Ingrese el nuevo nombre");
        String nuevoTitulo= leer.next();
        edit.setTitulo(nuevoTitulo);
        System.out.println("Ingrese el año");
        edit.setAnio(leer.nextInt());
        DAO.editar(edit);
    }  
    
    public Libro buscarXtitulo() throws Exception{
        Libro l = null;
        System.out.println("Ingrese el libro de desea buscar");
        String tit = leer.next();
        DAO.buscarPorTitulo(tit);
        l.toString();
        return l;
    }


    


    
    
    
}
