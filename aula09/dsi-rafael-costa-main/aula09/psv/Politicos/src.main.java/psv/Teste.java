package psv;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Teste {

    public static void main(String[] args) {
        try (Connection con = Conexao.abrirConexao()) {
            System.out.println("Conexão com MySQL realizada!\n");

            PoliticoDAO dao = new PoliticoDAO(con);

            
            PoliticoBean p1 = new PoliticoBean("Fulano de Tal", "Vereador", "SP", 2004);
            PoliticoBean p2 = new PoliticoBean("Beltrana da Silva", "Deputada Estadual", "BA", 1998);
            PoliticoBean p3 = new PoliticoBean("Ciclano Souza", "Prefeito", "MG", 2010);
            PoliticoBean p4 = new PoliticoBean("Luiz Inácio Lula da Silva", "Presidente da República", "SP", 1980);

            // INSERIR
            System.out.println("--- Inserindo ---");
            System.out.println("p1: " + (dao.inserir(p1) ? "ok" : "erro") + " (id " + p1.getId() + ")");
            System.out.println("p2: " + (dao.inserir(p2) ? "ok" : "erro") + " (id " + p2.getId() + ")");
            System.out.println("p3: " + (dao.inserir(p3) ? "ok" : "erro") + " (id " + p3.getId() + ")");
            System.out.println("p4: " + (dao.inserir(p4) ? "ok" : "erro") + " (id " + p4.getId() + ")");

            // LISTAR
            System.out.println("\n--- Listando todos ---");
            listar(dao);

            // PESQUISAR
            System.out.println("\n--- Pesquisando o id " + p2.getId() + " ---");
            System.out.println(dao.pesquisar(p2.getId()));

            // ALTERAR
            System.out.println("\n--- Alterando o id " + p1.getId() + " ---");
            p1.setCargo("Deputado Estadual");
            System.out.println(dao.alterar(p1) ? "Alterado com sucesso." : "Erro ao alterar.");
            System.out.println(dao.pesquisar(p1.getId()));

            // EXCLUIR
            System.out.println("\n--- Excluindo o id " + p3.getId() + " ---");
            System.out.println(dao.excluir(p3.getId()) ? "Excluído com sucesso." : "Erro ao excluir.");

            System.out.println("\n--- Lista final ---");
            listar(dao);

        } catch (SQLException e) {
            System.err.println("Erro de banco de dados:");
            e.printStackTrace();
        }
    }

    private static void listar(PoliticoDAO dao) throws SQLException {
        List<PoliticoBean> lista = dao.listarTodos();
        if (lista.isEmpty()) {
            System.out.println("(nenhum registro)");
        }
        for (PoliticoBean p : lista) {
            System.out.println(p);
        }
    }
}
