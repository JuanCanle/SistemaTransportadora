package SistemaTransportadora.DataAccessObject;

import SistemaTransportadora.*;

import java.sql.*;
import java.util.ArrayList;

public class DaoVeiculo {

    public static boolean salvar(Construtor_Veiculos veiculos, int tipoId) {
        String sql = "INSERT INTO veiculos (nome_veiculo, placa, modelo, tipo_id, altura_interna, largura_interna, comprimento_interno, capacidade_peso, observacoes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, veiculos.getNome());
            stmt.setString(2, veiculos.getPlaca());
            stmt.setString(3, veiculos.getModelo());
            stmt.setInt(4, tipoId);
            stmt.setDouble(5, veiculos.getDimesoes().getAltura());
            stmt.setDouble(6, veiculos.getDimesoes().getLargura());
            stmt.setDouble(7, veiculos.getDimesoes().getComprimento());
            stmt.setDouble(8, veiculos.getCapacidade_peso());
            stmt.setString(9, veiculos.getObservacoes());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao salvar veículo: " + e.getMessage());
            return false;
        }
    }
}
