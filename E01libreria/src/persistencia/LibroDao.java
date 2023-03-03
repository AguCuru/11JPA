
package persistencia;

import entidades.Libro;
import static entidades.Libro_.titulo;
import java.util.List;

public class LibroDao extends DAO<Libro>{

    @Override
    public void guardar(Libro libro) {
        super.guardar(libro); 
    }
    
    public void eliminar(Long id) throws Exception {
        Libro libro = buscarPorId(id);
        super.eliminar(libro); 
    }

    @Override
    public void editar(Libro objeto)  {
        super.editar(objeto); 
    }

    public Libro buscarPorTitulo(String titulo) throws Exception {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :titulo")
                .setParameter("titulo", titulo)
                .getSingleResult();
        desconectar();
        return libro;
    }     

    
    public Libro buscarPorId(Long id) throws Exception{
        conectar();
        Libro libro = em.find(Libro.class, id);
        desconectar();
        return libro;
    }
    
    public List<Libro> listarLibros() throws Exception {
        conectar();
        List<Libro> libro = em.createQuery("SELECT l FROM Libro l").getResultList();

        desconectar();
        return libro;
    }
    
}
