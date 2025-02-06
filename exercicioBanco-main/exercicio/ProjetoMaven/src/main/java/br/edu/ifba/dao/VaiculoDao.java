package br.edu.ifba.dao;

import java.util.List;
import br.edu.ifba.basicas.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class VeiculoDao {

    private EntityManager em;

    public VeiculoDao(EntityManager em) {
        this.em = em;
    }

    public void adicionarVeiculo(Veiculo v) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(v);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            ex.printStackTrace();
        }
    }

    public Veiculo buscarVeiculo(int id) {
        return em.find(Veiculo.class, id);
    }

    public void atualizarVeiculo(Veiculo v) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(v);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            ex.printStackTrace();
        }
    }

    public void removerVeiculo(Veiculo v) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Veiculo veiculoGerenciado = em.find(Veiculo.class, v.getId());
            if (veiculoGerenciado != null) {
                em.remove(veiculoGerenciado);
            }
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            ex.printStackTrace();
        }
    }

    public List<Veiculo> listarVeiculos() {
        return em.createQuery("SELECT v FROM Veiculo v", Veiculo.class).getResultList();
    }
}
