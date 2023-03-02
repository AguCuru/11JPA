
package persistencia;

import entidades.Autor;
import java.util.List;


public class AutorDAO extends DAO<Autor>{

    @Override
    public void eliminar(Autor objeto) {
        super.eliminar(objeto); 
    }

    @Override
    public void editar(Autor objeto) {
        super.editar(objeto);
        System.out.println("Editado con exito.");
    }

    @Override
    public void guardar(Autor objeto) {
        super.guardar(objeto); 
    }
    
    public Autor buscarPorNombre(String nombre) throws Exception {
        conectar();
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre").setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return autor;
    }
    
    public Autor buscarPorId (Long id){
        conectar();
        Autor autor = em.find(Autor.class, id);
        desconectar();
        return autor;
    }
    
    public List<Autor> listarAutores (){
        conectar();
        List<Autor> autores = em.createQuery("SELECT a from Autor a").getResultList();
        desconectar();
        return autores;        
    }
    


    


    
    
    
    
    
    
    
    
}
