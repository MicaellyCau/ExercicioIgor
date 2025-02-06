package br.edu.ifba.dao;
    import java.util.List;
    import br.edu.ifba.basicas.Endereco;
    import jakarta.persistence.EntityManager;
    import jakarta.persistence.EntityTransaction;
    
    public class EnderecoDao {
        
        private EntityManager em;
    
        public EnderecoDao(EntityManager em) {
            this.em = em;
        }
    
        public void adicionarEndereco(Endereco e) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                em.persist(e);
                tx.commit();
            } catch (Exception ex) {
                tx.rollback();
                ex.printStackTrace();
            }
        }
    
        public Endereco buscarEndereco(int id) {
            return em.find(Endereco.class, id);
        }
    
        public void atualizarEndereco(Endereco e) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                em.merge(e);
                tx.commit();
            } catch (Exception ex) {
                tx.rollback();
                ex.printStackTrace();
            }
        }
    
        public void removerEndereco(Endereco e) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                Endereco enderecoGerenciado = em.find(Endereco.class, e.getId());
                if (enderecoGerenciado != null) {
                    em.remove(enderecoGerenciado);
                }
                tx.commit();
            } catch (Exception ex) {
                tx.rollback();
                ex.printStackTrace();
            }
        }
    
        public List<Endereco> listarEnderecos() {
            return em.createQuery("SELECT e FROM Endereco e", Endereco.class).getResultList();
        }
    }
    

