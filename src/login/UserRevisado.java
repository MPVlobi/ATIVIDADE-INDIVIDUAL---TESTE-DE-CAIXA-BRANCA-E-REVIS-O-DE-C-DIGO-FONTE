package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRevisado {

    /*
     * Método responsável por estabelecer
     * a conexão com o banco de dados.
     *
     * Retorna um objeto Connection caso a
     * conexão seja criada com sucesso.
     */
    public Connection conectarBD() {

        // Variável que armazenará a conexão
        Connection conn = null;

        try {

            // URL de conexão com o banco
            String url = "jdbc:mysql://127.0.0.1/test";

            // Usuário do banco de dados
            String usuario = "lopes";

            // Senha do banco de dados
            String senhaBanco = "123";

            // Criação da conexão
            conn = DriverManager.getConnection(
                    url,
                    usuario,
                    senhaBanco
            );

            // Mensagem indicando sucesso na conexão
            System.out.println(
                    "Conexão realizada com sucesso."
            );

        } catch (Exception e) {

            // Exibe o erro ocorrido durante a conexão
            System.out.println(
                    "Erro ao conectar ao banco: "
                    + e.getMessage()
            );
        }

        // Retorna a conexão criada
        return conn;
    }

    /*
     * Método responsável por verificar
     * se o usuário existe no banco de dados.
     *
     * Recebe login e senha informados pelo usuário.
     *
     * Retorna:
     * true  -> usuário autenticado
     * false -> usuário não autenticado
     */
    public boolean verificarUsuario(
            String login,
            String senha) {

        // Consulta SQL utilizando parâmetros
        // para evitar SQL Injection
        String sql =
                "SELECT nome FROM usuarios "
              + "WHERE login = ? "
              + "AND senha = ?";

        try (

                // Abre conexão com banco
                Connection conn = conectarBD();

                // Cria PreparedStatement
                PreparedStatement ps =
                        conn.prepareStatement(sql)

        ) {

            /*
             * Verifica se a conexão foi criada.
             * Caso seja nula, encerra o método.
             */
            if (conn == null) {

                System.out.println(
                        "Não foi possível conectar ao banco."
                );

                return false;
            }

            /*
             * Substitui os parâmetros da consulta.
             *
             * Primeiro ? recebe o login.
             */
            ps.setString(1, login);

            /*
             * Segundo ? recebe a senha.
             */
            ps.setString(2, senha);

            /*
             * Executa a consulta no banco.
             */
            ResultSet rs = ps.executeQuery();

            /*
             * Se existir pelo menos um registro,
             * o usuário foi autenticado.
             */
            if (rs.next()) {

                // Obtém o nome do usuário
                String nomeUsuario =
                        rs.getString("nome");

                // Exibe mensagem de sucesso
                System.out.println(
                        "Usuário autenticado: "
                        + nomeUsuario
                );

                return true;
            }

            /*
             * Caso não encontre registros,
             * login ou senha estão incorretos.
             */
            System.out.println(
                    "Usuário ou senha inválidos."
            );

        } catch (Exception e) {

            /*
             * Captura qualquer erro ocorrido
             * durante a autenticação.
             */
            System.out.println(
                    "Erro durante autenticação: "
                    + e.getMessage()
            );
        }

        // Retorna falso caso a autenticação falhe
        return false;
    }
}