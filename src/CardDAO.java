import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardDAO {

    public void criarCard(int codBoard, String titulo, String descricao, String estado) {
        String sql = "INSERT INTO card (cod_board, titulo_card, desc_card, estado_card) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codBoard);
            stmt.setString(2, titulo);
            stmt.setString(3, descricao);
            stmt.setString(4, estado);
            stmt.executeUpdate();
            System.out.println("Card criado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarCards() {
        String sql = "SELECT * FROM card";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("cod_card") +
                        ", Board: " + rs.getInt("cod_board") +
                        ", Título: " + rs.getString("titulo_card") +
                        ", Estado: " + rs.getString("estado_card") +
                        ", Bloqueado: " + rs.getBoolean("bloqueado"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarCard(int codCard, String titulo, String descricao, String estado) {
        // Primeiro, verifica se o card está bloqueado
        String verificaSql = "SELECT bloqueado FROM card WHERE cod_card = ?";
        String atualizaSql = "UPDATE card SET titulo_card = ?, desc_card = ?, estado_card = ? WHERE cod_card = ?";

        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement verificaStmt = conn.prepareStatement(verificaSql)) {
            
            verificaStmt.setInt(1, codCard);
            ResultSet rs = verificaStmt.executeQuery();

            if (rs.next() && rs.getBoolean("bloqueado")) {
                System.out.println("Erro: O card está bloqueado e não pode ser alterado.");
                return;
            }

            try (PreparedStatement atualizaStmt = conn.prepareStatement(atualizaSql)) {
                atualizaStmt.setString(1, titulo);
                atualizaStmt.setString(2, descricao);
                atualizaStmt.setString(3, estado);
                atualizaStmt.setInt(4, codCard);
                atualizaStmt.executeUpdate();
                System.out.println("Card atualizado com sucesso!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarCard(int codCard) {
        String sql = "DELETE FROM card WHERE cod_card = ?";

        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codCard);
            stmt.executeUpdate();
            System.out.println("Card deletado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
