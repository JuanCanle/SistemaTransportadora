/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package SistemaTransportadora;
import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus
 */
public class tela_resumo extends javax.swing.JInternalFrame {

    /**
     * Creates new form tela_resumo
     */
    public tela_resumo() 
    {
        initComponents();
        gerarResumo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        resumoArea = new javax.swing.JTextArea();

        resumoArea.setColumns(20);
        resumoArea.setRows(5);
        jScrollPane1.setViewportView(resumoArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 private void gerarResumo() 
 {
          try ( Connection conn = ConexaoDB.conectar() ) 
          {
            Statement stmt = conn.createStatement();

            // Veículos por tipo
            resumoArea.append("Veículos por Tipo:\n");
            ResultSet resultado = stmt.executeQuery("""
                SELECT tv.nome, COUNT(*) AS total
                FROM veiculos v
                JOIN tipo_veiculo tv ON v.tipo_id = tv.id
                GROUP BY tv.nome
            """);
            int totalVeiculos = 0;
            while (resultado.next()) 
            {
                resumoArea.append("  " + resultado.getString("nome") + ": " + resultado.getInt("total") + "\n");
                totalVeiculos += resultado.getInt("total");
            }
            resumoArea.append("  Total de veículos: " + totalVeiculos + "\n\n");

            // Produtos por tipo
            resumoArea.append("Produtos por Tipo:\n");
            resultado = stmt.executeQuery("SELECT tipo, COUNT(*) AS total FROM produtos GROUP BY tipo");
            int totalProdutos = 0;
            while (resultado.next()) 
            {
                resumoArea.append("  " + resultado.getString("tipo") + ": " + resultado.getInt("total") + "\n");
                totalProdutos += resultado.getInt("total");
            }
            resumoArea.append("  Total de produtos: " + totalProdutos + "\n\n");

            // Embalagens por tipo
            resumoArea.append("Embalagens por Tipo:\n");
            resultado = stmt.executeQuery("""
                SELECT te.nome, COUNT(*) AS total
                FROM embalagens e
                JOIN tipo_embalagem te ON e.tipo_id = te.id
                GROUP BY te.nome
            """);
            int totalEmbalagens = 0;
            while (resultado.next()) 
            {
                resumoArea.append("  " + resultado.getString("nome") + ": " + resultado.getInt("total") + "\n");
                totalEmbalagens += resultado.getInt("total");
            }
            resumoArea.append("  Total de embalagens: " + totalEmbalagens + "\n\n");

            // Famílias
            resultado = stmt.executeQuery("SELECT COUNT(DISTINCT familia) AS total FROM produtos WHERE familia IS NOT NULL AND familia != ''");
            if (resultado.next()) 
            {
                resumoArea.append("️Famílias de Produtos: " + resultado.getInt("total") + "\n");
            }

            // Tipos de produtos
            resultado = stmt.executeQuery("SELECT COUNT(DISTINCT tipo) AS total FROM produtos WHERE tipo IS NOT NULL AND tipo != ''");
            if (resultado.next()) 
            {
                resumoArea.append("Tipos de Produtos: " + resultado.getInt("total") + "\n");
            }

            // Lotes
            resultado = stmt.executeQuery("SELECT COUNT(DISTINCT lote) AS total FROM produtos WHERE lote IS NOT NULL AND lote != ''");
            if (resultado.next()) 
            {
                resumoArea.append("Lotes Cadastrados: " + resultado.getInt("total") + "\n");
            }
          } 
          catch (SQLException ex) 
          {
            Logger.getLogger(tela_resumo.class.getName()).log(Level.SEVERE, null, ex);
          }
 }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea resumoArea;
    // End of variables declaration//GEN-END:variables
}
