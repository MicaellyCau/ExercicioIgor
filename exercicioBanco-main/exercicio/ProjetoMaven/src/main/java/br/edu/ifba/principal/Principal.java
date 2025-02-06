package br.edu.ifba.principal;


import java.util.List;


import br.edu.ifba.basicas.Funcionario;
import br.edu.ifba.basicas.Cliente;
import br.edu.ifba.basicas.Endereco;
import br.edu.ifba.basicas.Veiculo;
import br.edu.ifba.basicas.Servico;
import br.edu.ifba.dao.GetEntityManager;
import jakarta.persistence.EntityManager;

public class Principal {

	public static void main(String[] args) {
        EntityManager em = GetEntityManager.getJpaConnection();

        ClienteDao clienteDao = new ClienteDao(em);
        EnderecoDao enderecoDao = new EnderecoDao(em);
        FuncionarioDao funcionarioDao = new FuncionarioDao(em);
        ServicoDao servicoDao = new ServicoDao(em);
        VeiculoDao veiculoDao = new VeiculoDao(em);

        Funcionario funcionario = new Funcionario(1, "Mecânico", "12345678900", "José Silva");
        funcionarioDao.adicionarFuncionario(funcionario);

        Endereco endereco = new Endereco("48562-000", "Rua ABC", "100", "Centro", "Salvador");
        enderecoDao.adicionarEndereco(endereco);

        Cliente cliente = new Cliente(1, "Carlos Souza", "0568953", "956233254", funcionario, endereco);
        clienteDao.adicionarCliente(cliente);

        // Criando um Serviço e um Veículo
        Veiculo veiculo = new Veiculo("Civic", "Honda");
        veiculoDao.adicionarVeiculo(veiculo);

        Servico servico = new Servico("Troca de óleo", cliente);
        servicoDao.adicionarServico(servico);

        em.close();
        GetEntityManager.closeEntityManagerFactory();
    }
}
