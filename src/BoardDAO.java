import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardDAO {

    public void criarBoard(String titulo, String estado) {
        String sql = "INSERT INTO Board (titulo_board, estado_board) VALUES (?, ?)";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, titulo);
            stmt.setString(2, estado);
            stmt.executeUpdate();
            System.out.println("Board criado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarBoards() {
        String sql = "SELECT * FROM Board";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("cod_board") +
                        ", Título: " + rs.getString("titulo_board") +
                        ", Estado: " + rs.getString("estado_board"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarBoard(int id, String titulo, String estado) {
        String sql = "UPDATE Board SET titulo_board = ?, estado_board = ? WHERE cod_board = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, titulo);
            stmt.setString(2, estado);
            stmt.setInt(3, id);
            stmt.executeUpdate();
            System.out.println("Board atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarBoard(int id) {
        String sql = "DELETE FROM Board WHERE cod_board = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Board deletado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
