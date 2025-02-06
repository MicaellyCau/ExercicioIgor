package br.edu.ifba.dao;
import java.util.List;
import br.edu.ifba.basicas.Cliente;
import jakarta.persistence.EntityManager;

public class ClienteDao {
EntityManager em = GetEntityManager.getConnectionJpa();

public void adicionarCliente(Cliente c ){
    em.getTransaction().begin();
    em.persist(c);
        em.getTransaction().commit();
    
}
public Cliente buscarCliente(int id){
    return em.find( Cliente.class, id);

}
public void atualizarCliente(Cliente c){
    em.getTransaction().begin();
    em.merge(c);
    em.getTransaction().commit();
}
public void removerCliente(Cliente c){
    em.getTransaction().begin();
    em.remove(c);
    em.getTransaction();
}
public List<Cliente> listarclientes() {
    return em.createQuery("select c from Cliente", Cliente.class).getResultList();
    
}
}
