package SistemaTransportadora.DataAccessObject;

import SistemaTransportadora.*;

import java.sql.*;

public class DaoEmbalagem {

    public static boolean salvar(Construtor_Embalagens embalagem, int produtoId, int tipoId)
    { //cria o statement
        String sql = "INSERT INTO embalagens (produto_id, tipo_id, altura, largura, comprimento, peso, empilhavel, observacoes) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        //cria o objeto conn usando o metodo Conectar da classe conexao DB
        try (Connection conn = ConexaoDB.conectar();
             //objeto stmt(statement) que e um query preparado
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            //index parameter indica a ordem que sera colocado os atributos
            //o set transforma o tipo(int) em java para SQL (integer),e designa seu valor,uma String se transforma em varchar e um double permanace
            
            stmt.setInt(2, tipoId);
            stmt.setDouble(3, embalagem.getDimensoes().getAltura());
            stmt.setDouble(4, embalagem.getDimensoes().getLargura());
            stmt.setDouble(5, embalagem.getDimensoes().getComprimento());
            stmt.setDouble(6, embalagem.getPeso());
            stmt.setBoolean(7, embalagem.isEmpilhavel());
            stmt.setString(8, embalagem.getObservacoes());
            //executa o objeto completo
            stmt.executeUpdate();
            //retorna true para sabermos se deu certo
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar embalagem: " + ex.getMessage());
            return false;
        }
    }
}
