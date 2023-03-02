
package servicios;

import entidades.Editorial;
import java.util.List;
import java.util.Scanner;
import persistencia.EditorialDAO;


public class EditorialServicio  {
    Scanner leer = new Scanner (System.in).useDelimiter("\n");
    //EditorialDAO eD = new EditorialDAO();
    private AutorServicio autorServicio;
    private LibroServicio libroServicio;
    private final EditorialDAO DAO ;
    
    public EditorialServicio(){
        this.DAO = new EditorialDAO();
    }
    
    public void setServicios(AutorServicio autorServicio,LibroServicio libroServicio){
        this.autorServicio = autorServicio;
        this.libroServicio = libroServicio;
    }
    
    public Editorial crearEditorial() {
        Editorial ed = new Editorial();
        try {
            System.out.println("Ingrese el nombre de la editorial:");
            ed.setNombre(leer.next());
            ed.setAlta(true);
            DAO.guardar(ed);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return ed;

    }
    
    public void imprimirEditoriales(){
        List<Editorial> editoriales = DAO.listarEditoriales();
        for (Editorial edi : editoriales) {
            System.out.println(edi.getId() + " - " + edi.getNombre());
        }
        
        
    }

    public void editarEditorial() throws Exception{
        Editorial edit; 
        System.out.println("Ingrese autor que desea editar");
        imprimirEditoriales();
        String nombre = leer.next();
        edit= DAO.buscarPorNombre(nombre);
        System.out.println("-------------------------");
        System.out.println("Ingrese el nuevo nombre");
        String nuevoNombre= leer.next();
        edit.setNombre(nuevoNombre);
        DAO.editar(edit);
    }
    
    public void eliminarEditorial() throws Exception{
        Editorial editorial;
        try { 
            System.out.println("Ingrese el nombre de la editorial que desea eliminar");
            imprimirEditoriales(); 
            String nombre = leer.next();
            DAO.eliminar(DAO.buscarPorNombre(nombre));
        } catch (Exception e) {
            System.out.println("La editorial no se encuentra en la lista, intente de nuevo");
            String nombre = leer.next();
            DAO.eliminar(DAO.buscarPorNombre(nombre));            
        }

    }

    public void eliminarEditorialXid() {
        try {
            System.out.println("Ingrese el ID del autor que desea eliminar");
            List<Editorial> editoriales = DAO.listarEditoriales();
            for (Editorial edit : editoriales) {
                System.out.println(edit.getId() + " - " + edit.getNombre());
            }
            System.out.println("");
            System.out.print("Ingrese el ID: ");
            Long id = leer.nextLong();
            DAO.eliminar(DAO.buscarPorId(id));
        } catch (Exception e) {
            System.out.println("Id no valido, intente de nuevo");
            Long id = leer.nextLong();
            DAO.eliminar(DAO.buscarPorId(id));
        }

    }

    
    
    
    

    
    
    
    
    
    
}
