/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.sun.security.ntlm.Client;
import dao.ClienteDAO;
import java.util.Calendar;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
;import model.Cidade;
import model.Cliente;

/**
 *
 * @author 181720083
 */
public class ListClientes extends javax.swing.JInternalFrame {

    /**
     * Creates new form ListClientes
     */
    
    private JDesktopPane jdpTelaInicial;
    
    public ListClientes(JDesktopPane jdpTelaInicial) {
        initComponents();
        carregarTabela();
        this.jdpTelaInicial = jdpTelaInicial;
    }
   
    public void carregarTabela(){
        List<Cliente> lista = ClienteDAO.getClientes();
        String[] colunas = {"código", "Nome", "Telefone", 
             "Data de Nacimento", "CPF", "sexo", "Casado?",
             "Filhos?", "Salario", "Cidade", "Estado"};
        
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(colunas);
        
        for(Cliente cliente : lista ) {
            Calendar nasc = cliente .getNasimento();
            String data = "" +
                    nasc.get( Calendar.DAY_OF_MONTH) +
                  "/"+ (nasc.get( Calendar.MONTH)+1) +
                  "/"+ nasc.get( Calendar.YEAR);
            
            String casado ="Não";
            if( cliente.isCasado() )
                 casado = "Sim";
            String filhos = "Não";
            if(cliente.isTemFilhos())
                filhos ="Sim";
            String sexo = "";
            if( cliente.getSexo().equals("f") )
                sexo = "Feminino";
            if( cliente.getSexo().equals("m") )
                sexo="Masculino";
            
            Object[] dados = {
              cliente.getCodigo(),
              cliente.getNome(),
              cliente.getNome(),
              cliente.getTelefone(),
              cliente.getCpf(), data,
              sexo, casado, filhos, cliente.getSalario(),
              cliente.getCidade().getNome(),
              cliente.getCidade().getEstado().getNome()
            };
                
               model.addRow(dados);
        }
        tableClientes.setModel(model);
    }  
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableClientes = new javax.swing.JTable();
        btnEditar = new javax.swing.JToggleButton();
        btnExcluir = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));

        tableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Título 1", "Título 2", "Título 3"
            }
        ));
        jScrollPane1.setViewportView(tableClientes);

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnExcluir.setText("Excluir ");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Lista de Clientes ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(jLabel1)
                .addGap(77, 77, 77)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
       int linha = tableClientes.getSelectedRow();
       if( linha < 0){
           JOptionPane.showMessageDialog(this,
                   "um cliente deve ser selecionado!");
       }else{
          int codigo = (int) tableClientes.getValueAt(linha, 0);
          Cliente cliente = ClienteDAO.getClienteByCodigo(codigo);
          
          int resposta = JOptionPane.showConfirmDialog
               (this, 
                "confirma a exclusão do cliente " + cliente.getNome()+"?",
                "Excluir cliente",
                JOptionPane.YES_NO_OPTION);
          if( resposta == JOptionPane.YES_NO_OPTION){
              ClienteDAO.excluir(cliente);
              carregarTabela(); 
          }
       }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
 int linha = tableClientes.getSelectedRow();
       if( linha < 0){
           JOptionPane.showMessageDialog(this,
                   "um cliente deve ser selecionado!");
       }else{
          int codigo = (int) tableClientes.getValueAt(linha, 0); 
           FrmCliente tela = new FrmCliente( codigo , this );
           this.jdpTelaInicial.add(tela);
           tela.setVisible(true);
       }
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnEditar;
    private javax.swing.JToggleButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableClientes;
    // End of variables declaration//GEN-END:variables
}
