package psv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PoliticoDAO {

    private final Connection con;

    public PoliticoDAO(Connection con) {
        this.con = con;
    }

    // Cadastrar um político
    public boolean inserir(PoliticoBean p) throws SQLException {
        String sql = """
                INSERT INTO politico (nome, cargo, uf, ano_filiacao)
                VALUES (?, ?, ?, ?)
                """;

        try (PreparedStatement ps =
                     con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getNome());
            ps.setString(2, p.getCargo());
            ps.setString(3, p.getUf());
            ps.setInt(4, p.getAnoFiliacao());

            boolean ok = ps.executeUpdate() > 0;

            if (ok) {
                try (ResultSet keys = ps.getGeneratedKeys()) {
                    if (keys.next()) {
                        p.setId(keys.getInt(1));
                    }
                }
            }
            return ok;
        }
    }

    // Alterar informações (Exceto id)
    public boolean alterar(PoliticoBean p) throws SQLException {
        String sql = """
                UPDATE politico
                SET nome = ?, cargo = ?, uf = ?, ano_filiacao = ?
                WHERE id = ?
                """;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getNome());
            ps.setString(2, p.getCargo());
            ps.setString(3, p.getUf());
            ps.setInt(4, p.getAnoFiliacao());
            ps.setInt(5, p.getId());

            return ps.executeUpdate() > 0;
        }
    }

    // Excluir um político
    public boolean excluir(int id) throws SQLException {
        String sql = "DELETE FROM politico WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    // Pesquisar um político
    public PoliticoBean pesquisar(int id) throws SQLException {
        String sql = """
                SELECT id, nome, cargo, uf, ano_filiacao
                FROM politico
                WHERE id = ?
                """;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return montar(rs);
                }
            }
        }
        return null;
    }

    // Listar os políticos
    public List<PoliticoBean> listarTodos() throws SQLException {
        String sql = """
                SELECT id, nome, cargo, uf, ano_filiacao
                FROM politico
                ORDER BY nome
                """;

        List<PoliticoBean> lista = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(montar(rs));
            }
        }
        return lista;
    }

    private PoliticoBean montar(ResultSet rs) throws SQLException {
        PoliticoBean p = new PoliticoBean();
        p.setId(rs.getInt("id"));
        p.setNome(rs.getString("nome"));
        p.setCargo(rs.getString("cargo"));
        p.setUf(rs.getString("uf"));
        p.setAnoFiliacao(rs.getInt("ano_filiacao"));
        return p;
    }
}
