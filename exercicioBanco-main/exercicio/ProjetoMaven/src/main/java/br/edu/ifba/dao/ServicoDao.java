package br.edu.ifba.dao;

    import java.util.List;
    import br.edu.ifba.basicas.Servico;
    import jakarta.persistence.EntityManager;
    import jakarta.persistence.EntityTransaction;
    
    public class ServicoDao {
    
        private EntityManager em;
    
        public ServicoDao(EntityManager em) {
            this.em = em;
        }
    
        public void adicionarServico(Servico s) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                em.persist(s);
                tx.commit();
            } catch (Exception ex) {
                tx.rollback();
                ex.printStackTrace();
            }
        }
    
        public Servico buscarServico(int id) {
            return em.find(Servico.class, id);
        }
    
        public void atualizarServico(Servico s) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                em.merge(s);
                tx.commit();
            } catch (Exception ex) {
                tx.rollback();
                ex.printStackTrace();
            }
        }
    
        public void removerServico(Servico s) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                Servico servicoGerenciado = em.find(Servico.class, s.getId());
                if (servicoGerenciado != null) {
                    em.remove(servicoGerenciado);
                }
                tx.commit();
            } catch (Exception ex) {
                tx.rollback();
                ex.printStackTrace();
            }
        }
    
        public List<Servico> listarServicos() {
            return em.createQuery("SELECT s FROM Servico s", Servico.class).getResultList();
        }
}
