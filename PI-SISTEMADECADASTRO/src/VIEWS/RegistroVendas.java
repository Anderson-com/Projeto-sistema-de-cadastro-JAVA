package VIEWS;

import CONTROLLER.ClienteUtil;
import CONTROLLER.Conexao;
import CONTROLLER.VendasUtil;
import MODEL.Cliente;
import MODEL.Vendas;
import java.text.NumberFormat;
import javax.swing.*;
import java.text.ParseException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

public class RegistroVendas extends javax.swing.JFrame {
      private Cliente clienteAtual;
      private ClienteUtil clienteUtil;
      private String tipoUsuario;

    public RegistroVendas() {
        initComponents();
        setLocationRelativeTo(null);
        this.tipoUsuario = tipoUsuario;
        configurarFormatadores();
        configurarEventos();
        clienteAtual = null;
        clienteUtil = new ClienteUtil();
    }

    private void configurarFormatadores() {
    try {
        MaskFormatter cpfFormatter = new MaskFormatter("###.###.###-##");
        cpfFormatter.install(txtCpf); 
        MaskFormatter dataFormatter = new MaskFormatter("##/##/####");
        dataFormatter.install(txtData);
        MaskFormatter telFormatter = new MaskFormatter("(##) #####-####");
        telFormatter.setPlaceholderCharacter('_');
        telFormatter.install(txtTelefone); 
        NumberFormat format = NumberFormat.getNumberInstance();
        NumberFormatter valorFormatter = new NumberFormatter(format);
        txtValor.setFormatterFactory(new DefaultFormatterFactory(valorFormatter));
    } catch (ParseException e) {
        e.printStackTrace();
    }
}
    private void configurarEventos() {
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                Conexao.fecharConexao();
                System.exit(0);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        txtProduto = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtData = new javax.swing.JFormattedTextField();
        txtValor = new javax.swing.JFormattedTextField();
        btnVerCliente = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REGISTRAR VENDAS");
        setPreferredSize(new java.awt.Dimension(500, 500));

        jPanel1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 1, 40)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRO DE VENDAS");

        jLabel2.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel2.setText("NOME:");

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel3.setText("TELEFONE:");

        jLabel4.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel4.setText("PRODUTO:");

        jLabel5.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel5.setText("CPF:");

        jLabel6.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel6.setText("EMAIL:");

        jLabel7.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel7.setText("VALOR:");

        btnRegistrar.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnRegistrar.setText("REGISTRAR VENDA");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnVoltar.setText("VOLTAR");
        btnVoltar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        txtNome.setBackground(new java.awt.Color(244, 244, 244));

        txtProduto.setBackground(new java.awt.Color(244, 244, 244));

        txtEmail.setBackground(new java.awt.Color(244, 244, 244));

        jLabel8.setText("DATA:");

        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });

        btnVerCliente.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        btnVerCliente.setText("VERIFICAR CLIENTE");
        btnVerCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVerCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerClienteActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        btnLimpar.setText("LIMPAR");
        btnLimpar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtProduto, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNome)
                                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnVerCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEmail)
                                    .addComponent(txtCpf)
                                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtValor)))
                .addGap(97, 97, 97)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        new Menu(tipoUsuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (!validarCampos()) {
            return;
        }
        String cpf = txtCpf.getText().replaceAll("[^0-9]", "");
        String nome = txtNome.getText().trim();
        String email = txtEmail.getText().trim();
        String telefone = txtTelefone.getText().replaceAll("[^0-9]", "");
        String produto = txtProduto.getText().trim();
        double valor = (txtValor.getValue() != null) ? ((Number)txtValor.getValue()).doubleValue() : 0.0;
        String data = txtData.getText().trim();
        try {            
            Vendas venda = new Vendas(cpf, nome, email, telefone, produto, valor, data);
            VendasUtil vendasUtil = new VendasUtil();
            if (vendasUtil.adicionar(venda)) {
                JOptionPane.showMessageDialog(this, "Venda registrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
               
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao registrar venda", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor inválido. Use o formato 999,99", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnVerClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerClienteActionPerformed
        String cpf = txtCpf.getText().replaceAll("[^0-9]", "");
        
        if (cpf.isEmpty() || cpf.length() != 11) {
            JOptionPane.showMessageDialog(this, "Informe um CPF válido com 11 dígitos", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }        
        clienteAtual = clienteUtil.buscarPorCpf(cpf);
        
        if (clienteAtual != null) {
            // Cliente existe - preenche os campos
            txtNome.setText(clienteAtual.getNome());
            txtEmail.setText(clienteAtual.getEmail());
            //String telefone = clienteAtual.getTelefone();
            txtTelefone.setText(clienteAtual.getTelefone());
        } else {
           JOptionPane.showMessageDialog(this, "Cliente não cadastrado. Preencha os dados para cadastrar.", "Aviso", JOptionPane.WARNING_MESSAGE);
           dispose();
           Cadastro cadastro = new Cadastro();
           cadastro.setVisible(true);            
            
        }
    }//GEN-LAST:event_btnVerClienteActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroVendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVerCliente;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtProduto;
    private javax.swing.JFormattedTextField txtTelefone;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables
    private boolean validarCampos() {
        String cpf = txtCpf.getText().replaceAll("[^0-9]", "");
        if (cpf.length() != 11) {
            JOptionPane.showMessageDialog(this, "CPF inválido", "Erro", JOptionPane.ERROR_MESSAGE);
            txtCpf.requestFocus();
            return false;
        }
        if (txtNome.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nome é obrigatório", "Erro", JOptionPane.ERROR_MESSAGE);
            txtNome.requestFocus();
            return false;
        }
        if (txtProduto.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Produto é obrigatório", "Erro", JOptionPane.ERROR_MESSAGE);
            txtProduto.requestFocus();
            return false;
        }
        try {
            String valorText = txtValor.getText().trim().replace(",", ".");
            double valor = Double.parseDouble(valorText);
            if (valor <= 0) {
                JOptionPane.showMessageDialog(this, "Valor deve ser maior que zero", "Erro", JOptionPane.ERROR_MESSAGE);
                txtValor.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor inválido. Use o formato 999,99", "Erro", JOptionPane.ERROR_MESSAGE);
            txtValor.requestFocus();
            return false;
        }
        String data = txtData.getText().trim();
        if (data.isEmpty() || !data.matches("\\d{2}/\\d{2}/\\d{4}")) {
            JOptionPane.showMessageDialog(this, "Data inválida. Use o formato DD/MM/AAAA", "Erro", JOptionPane.ERROR_MESSAGE);
            txtData.requestFocus();
            return false;
        }
        return true;
    }
    private void limparCampos() {
        txtCpf.setValue("");
        txtNome.setText("");
        txtEmail.setText("");
        txtTelefone.setValue("");
        txtProduto.setText("");
        txtValor.setValue(0.00);
        txtData.setValue("");
        txtNome.requestFocus();
}
}
