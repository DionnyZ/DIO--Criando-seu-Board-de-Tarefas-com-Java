public class Main {
    public static void main(String[] args) {
        BoardDAO boardDao = new BoardDAO();
        CardDAO cardDao = new CardDAO();

        // Criar um novo board
        boardDao.criarBoard("Projeto X", "Ativo");

        // Listar boards
        boardDao.listarBoards();

        // Atualizar um board
        boardDao.atualizarBoard(1, "Projeto Y", "Finalizado");

        // Deletar um board
        boardDao.deletarBoard(1);

        // Criar um novo card
        cardDao.criarCard(3, "Tarefa Importante", "Descrição da tarefa", "Em andamento");

        // Listar cards
        cardDao.listarCards();

        // Tentar atualizar um card bloqueado
        cardDao.atualizarCard(1, "Nova Tarefa", "Nova descrição", "Finalizado");

        // Deletar um card
        cardDao.deletarCard(1);
    }
}
