
package servicios;

import entidades.Autor;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.AutorDAO;

public class AutorServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    private EditorialServicio editorialServicio;
    private LibroServicio libroServicio;
    private final AutorDAO DAO;

    public AutorServicio() {
        this.DAO = new AutorDAO();
    }

    public void setEditorialServicio(EditorialServicio editorialServicio) {
        this.editorialServicio = editorialServicio;
    }

    public void setLibroServicio(LibroServicio libroServicio) {
        this.libroServicio = libroServicio;
    }

    public Autor crearAutor() {
        Autor au = new Autor();
        try {
            System.out.println("Ingrese el nombre del autor:");
            au.setNombre(leer.next());
            au.setAlta(true);
            DAO.guardar(au);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return au;

    }

    public void imprimirAutores() {
        try {
            List<Autor> autores = DAO.listarAutores();            
            for (Autor aut : autores) {
                System.out.println(aut.getId() + " - " + aut.getNombre());
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
     
    public void editarAutor() throws Exception{
        Autor aut; 
        System.out.println("Ingrese autor que desea editar");
        imprimirAutores();
        String nombre = leer.next();
        aut= DAO.buscarPorNombre(nombre);
        System.out.println("-------------------------");
        System.out.println("Ingrese el nuevo nombre");
        String nuevoNombre= leer.next();
        aut.setNombre(nuevoNombre);
        DAO.editar(aut);
    }
    
    public void eliminarAutor(){
        Autor autor;
        try { 
            System.out.println("Ingrese el nombre del autor que desea eliminar");
            imprimirAutores(); 
            String nombre = leer.next();
            DAO.eliminar(DAO.buscarPorNombre(nombre));
        } catch (Exception e) {
            System.out.println("El auto no se encuentra en la lista, intente de nuevo");
            
        }

    }
    
    public void eliminarAutorXid(){
        System.out.println("Ingrese el ID del autor que desea eliminar");
        List<Autor> autores = DAO.listarAutores();
        for (Autor aut : autores) {
            System.out.println(aut.getId() + " - " + aut.getNombre());
        }
        System.out.println("");
        System.out.print ("Ingrese el ID: ") ;
        Long id = leer.nextLong();
        DAO.eliminar(DAO.buscarPorId(id));
        
    }
}
