package psv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL =
            "jdbc:mysql://localhost:3306/politicos_pt";

    private static final String USUARIO = "root";

    // Substitua pela senha do seu MySQL
    private static final String SENHA = "";

    public static Connection abrirConexao() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
