package br.edu.ifba.dao;

import java.util.List;
import br.edu.ifba.basicas.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class FuncionarioDao {
    private EntityManager em;

    public FuncionarioDao(EntityManager em) {
        this.em = em;
    }

    public void adicionarFuncionario(Funcionario f) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(f);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            ex.printStackTrace();
        }
    }

    public Funcionario buscarFuncionario(int id) {
        return em.find(Funcionario.class, id);
    }

    public void atualizarFuncionario(Funcionario f) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(f);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            ex.printStackTrace();
        }
    }

    public void removerFuncionario(Funcionario f) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Funcionario funcionarioGerenciado = em.find(Funcionario.class, f.getId());
            if (funcionarioGerenciado != null) {
                em.remove(funcionarioGerenciado);
            }
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            ex.printStackTrace();
        }
    }

    public List<Funcionario> listarFuncionarios() {
        return em.createQuery("SELECT f FROM Funcionario f", Funcionario.class).getResultList();
    }
}
