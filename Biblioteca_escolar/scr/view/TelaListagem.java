//Raphael Cordeiro Lopes 4°Semestre Uniplan
package view;

import dao.LivroDAO;
import model.Livro;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JOptionPane;


public class TelaListagem extends javax.swing.JFrame {
private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaListagem.class.getName());

    public TelaListagem() {
        initComponents();
        carregarLivros(""); 
    }

    
    private void carregarLivros(String filtro) {
        
        LivroDAO dao = new LivroDAO();
        List<Livro> listaLivros = dao.listarTodos();

        
        DefaultTableModel modelo = (DefaultTableModel) tabelaLivros.getModel();
        
        
        modelo.setRowCount(0); 

        
        TableColumnModel columnModel = tabelaLivros.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(0); 
        columnModel.getColumn(0).setMinWidth(0);
        columnModel.getColumn(0).setMaxWidth(0);

        
        for (Livro livro : listaLivros) {
            modelo.addRow(new Object[]{
                livro.getIdLivro(),      
                livro.getTitulo(),       
                livro.getAutor(),        
                livro.getAnoPublicacao(),
                livro.getStatus()        
            });
        }
    }
    
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaLivros = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        txtPesquisa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelaLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Autor", "Titulo", "Ano", "Status"
            }
        ));
        jScrollPane1.setViewportView(tabelaLivros);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        txtPesquisa.setColumns(20);
        txtPesquisa.setAlignmentX(5.0F);
        txtPesquisa.setAutoscrolls(false);
        txtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaActionPerformed(evt);
            }
        });
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(btnEditar)
                .addGap(46, 46, 46)
                .addComponent(btnVoltar)
                .addGap(73, 73, 73)
                .addComponent(btnExcluir)
                .addGap(37, 37, 37))
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnVoltar)
                    .addComponent(btnExcluir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

    int linhaSelecionada = tabelaLivros.getSelectedRow();
    
    if (linhaSelecionada == -1) {
        JOptionPane.showMessageDialog(this, "Selecione um livro na tabela para excluir.", "Atenção", JOptionPane.WARNING_MESSAGE);
        return;
    }

    
    int confirmacao = JOptionPane.showConfirmDialog(this, 
            "Tem certeza que deseja excluir o livro selecionado?", "Confirmar Exclusão", 
            JOptionPane.YES_NO_OPTION);

    if (confirmacao == JOptionPane.YES_OPTION) {
        
        DefaultTableModel modelo = (DefaultTableModel) tabelaLivros.getModel();
        int idLivro = (int) modelo.getValueAt(linhaSelecionada, 0);

        
        LivroDAO dao = new LivroDAO();
        boolean sucesso = dao.deletar(idLivro);

        
        if (sucesso) {
            JOptionPane.showMessageDialog(this, "Livro excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
            
            String filtroAtual = txtPesquisa.getText();
            carregarLivros(filtroAtual); 
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao excluir livro.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
        Tela telaPrincipal = new Tela();
    telaPrincipal.setVisible(true);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linhaSelecionada = tabelaLivros.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um livro para Editar","Atenção", JOptionPane.WARNING_MESSAGE );
            return;
        }
        DefaultTableModel modelo = (DefaultTableModel)tabelaLivros.getModel();
        int idLivro = (int) modelo.getValueAt(linhaSelecionada, 0);
        
        this.dispose();
        
        TelaCadastro telaCadastro = new TelaCadastro(idLivro);
        telaCadastro.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
       String filtro = txtPesquisa.getText();
       carregarLivros(filtro);
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed
        // TODO a handling code here:
    }//GEN-LAST:event_txtPesquisaActionPerformed

    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new TelaListagem().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaLivros;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
