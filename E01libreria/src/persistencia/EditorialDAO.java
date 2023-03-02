
package persistencia;

import entidades.Editorial;
import java.util.List;

public class EditorialDAO extends DAO<Editorial> {

    @Override
    public void eliminar(Editorial objeto) {
        super.eliminar(objeto); 
    }

    @Override
    public void editar(Editorial objeto) {
        super.editar(objeto); 
    }

    @Override
    public void guardar(Editorial objeto) {
        super.guardar(objeto); 
    }

    public Editorial buscarPorNombre(String nombre) throws Exception {
        conectar();
        Editorial editorial = (Editorial) em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre").setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return editorial;
    }    
    
    public Editorial buscarPorId(Long id)  {
        conectar();
        Editorial editorial = em.find(Editorial.class, id);
        desconectar();
        return editorial;
    }
    
    public List<Editorial> listarEditoriales(){
        conectar();
        List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e").getResultList();
        desconectar();
        return editoriales;
    }
    
    
    
    
    
}
