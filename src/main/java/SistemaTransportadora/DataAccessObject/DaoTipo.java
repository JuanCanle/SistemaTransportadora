package SistemaTransportadora.DataAccessObject;

import java.sql.*;
import java.util.ArrayList;
import SistemaTransportadora.ConexaoDB;
//eu ja tinha explicado tudo isso,mas perdi o arquivo
public class DaoTipo {

    public ArrayList<String> listarTiposVeiculo()
    {
        //a boa pratica seria List<String> lista; e depois criar um construtor this.lista=new ArrayList<>();
        ArrayList<String> lista = new ArrayList<>();
        String sql = "SELECT nome FROM tipo_veiculo";

        try (Connection conn = ConexaoDB.conectar();
             //cria um stmt vazio
             Statement stmt = conn.createStatement();
             //insere o sql dentro do stmt,executando-o
             //ResultSet funciona como uma "tabela" de Resultados do query
             ResultSet resultSet = stmt.executeQuery(sql))
        {
            //esse metodo move o ponteiro(que e inicializado antes da primeira linha do tipo_veiculo) 1 linha a frente
            while (resultSet.next())
            {
                //aqui adiciona o resultado encontrado(nome do tipo) a lista,usando getString (que transforma o resultado para uma List<String> nesse caso
                lista.add(resultSet.getString("nome"));
            }
        } catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        //retorna a lista com os tipos
        return lista;
    }

    public ArrayList<String> listarTiposEmbalagem()
    {
        ArrayList<String> lista = new ArrayList<>();
        String sql = "SELECT nome FROM tipo_embalagem";

        try (Connection conn = ConexaoDB.conectar();
             Statement stmt = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql))
        {
            while (resultSet.next())
            {
                lista.add(resultSet.getString("nome"));
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }

        return lista;
    }

    public ArrayList<String> listarGrausFragilidade()
    {
        ArrayList<String> lista = new ArrayList<>();
        String sql = "SELECT nome FROM grau_fragilidade";

        try (Connection conn = ConexaoDB.conectar();
             Statement stmt = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql))
        {
            while (resultSet.next())
            {
                lista.add(resultSet.getString("nome"));
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }

        return lista;
    }
}
