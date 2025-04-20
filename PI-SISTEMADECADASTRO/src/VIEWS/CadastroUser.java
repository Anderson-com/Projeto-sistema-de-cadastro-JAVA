package VIEWS;

import CONTROLLER.Conexao;
import CONTROLLER.UsuarioUtil;
import MODEL.Usuario;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class CadastroUser extends javax.swing.JFrame {

    private final UsuarioUtil usuarioUtil;

    public CadastroUser() {
        initComponents();
        this.usuarioUtil = new UsuarioUtil(); 
        setLocationRelativeTo(null);
        configurarEventos();
    }
    private void configurarEventos() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();
        btnCad = new javax.swing.JButton();
        btnList = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        txtCPF = new javax.swing.JTextField();
        cmbDep = new javax.swing.JComboBox<>();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));

        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CADASTRO DE NOVOS USUARIOS");

        jLabel2.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel2.setText("LOGIN:");

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel3.setText("SENHA:");

        jLabel4.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel4.setText("CPF:");

        jLabel5.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel5.setText("DEPARTAMENTO:");

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "LOGIN", "SENHA", "TIPO", "CPF"
            }
        ));
        jScrollPane1.setViewportView(jTableUsuarios);

        btnCad.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        btnCad.setText("CADASTRAR USUARIO");
        btnCad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadActionPerformed(evt);
            }
        });

        btnList.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        btnList.setText("LISTAR USUARIO");
        btnList.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnList.setMaximumSize(new java.awt.Dimension(149, 23));
        btnList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        btnExcluir.setText("EXCLUIR USUARIO");
        btnExcluir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        txtNome.setBackground(new java.awt.Color(244, 244, 244));

        txtPass.setBackground(new java.awt.Color(244, 244, 244));

        txtCPF.setBackground(new java.awt.Color(244, 244, 244));

        cmbDep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Operacional" }));

        btnVoltar.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnVoltar.setText("VOLTAR");
        btnVoltar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(btnCad, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnList, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome)
                    .addComponent(txtPass))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(cmbDep, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVoltar)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnList, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadActionPerformed
        String login = txtNome.getText().trim();
        String senha = txtPass.getText().trim(); 
        String cpf = txtCPF.getText().replaceAll("[^0-9]", "");
        String tipo = cmbDep.getSelectedItem().toString();
        
        if (!validarCampos(login, senha, cpf, tipo)) {
            return;
        }
        Usuario usuario = new Usuario(login, senha, tipo, cpf);
        if (usuarioUtil.cadastrar(usuario)) {
            JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
            limparCampos();
            usuarioUtil.listarUsuarios(jTableUsuarios);
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar usuário, Login ou CPF já cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_btnCadActionPerformed

    private void btnListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListActionPerformed
        usuarioUtil.listarUsuarios(jTableUsuarios);
    }//GEN-LAST:event_btnListActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        int linha = jTableUsuarios.getSelectedRow();
        if (linha >= 0) {
            String login = jTableUsuarios.getValueAt(linha, 0).toString();
            int confirmacao = JOptionPane.showConfirmDialog(
                    this,
                    "Tem certeza que deseja excluir o usuário " + login + "?",
                    "Confirmar Exclusão",
                    JOptionPane.YES_NO_OPTION);
            if (confirmacao == JOptionPane.YES_OPTION) {
                if (usuarioUtil.excluirUsuario(login)) {
                    usuarioUtil.listarUsuarios(jTableUsuarios);
                    JOptionPane.showMessageDialog(this, "Usuário excluído com sucesso!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um usuário para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        Menu menu = new Menu("admin");
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed
    private boolean validarCPF(String cpf) {
        return cpf.matches("\\d{11}");
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCad;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnList;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cmbDep;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPass;
    // End of variables declaration//GEN-END:variables
    private boolean validarCampos(String login, String senha, String cpf, String tipo) {
        if (login.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O login é obrigatório", "Erro", JOptionPane.ERROR_MESSAGE);
            txtNome.requestFocus();
            return false;
        }
        if (login.length() < 3) {
            JOptionPane.showMessageDialog(this, "Login deve ter pelo menos 3 caracteres", "Erro", JOptionPane.ERROR_MESSAGE);
            txtNome.requestFocus();
            return false;
        }
        if (!login.matches("^[a-zA-Z0-9._-]{3,}$")) {
            JOptionPane.showMessageDialog(this, "Login deve conter apenas letras, números, pontos, hífens ou underscores", "Erro", JOptionPane.ERROR_MESSAGE);
            txtNome.requestFocus();
            return false;
        }
        if (senha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "A senha é obrigatória", "Erro", JOptionPane.ERROR_MESSAGE);
            txtPass.requestFocus();
            return false;
        }
        if (senha.length() < 6) {
            JOptionPane.showMessageDialog(this, "Senha deve ter pelo menos 6 caracteres", "Erro", JOptionPane.ERROR_MESSAGE);
            txtPass.requestFocus();
            return false;
        }
        if (cpf.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O CPF é obrigatório", "Erro", JOptionPane.ERROR_MESSAGE);
            txtCPF.requestFocus();
            return false;
        }
        if (cpf.length() != 11) {
            JOptionPane.showMessageDialog(this, "CPF deve conter 11 dígitos", "Erro", JOptionPane.ERROR_MESSAGE);
            txtCPF.requestFocus();
            return false;
        }
        if (!validarCPF(cpf)) {
            JOptionPane.showMessageDialog(this, "CPF inválido", "Erro", JOptionPane.ERROR_MESSAGE);
            txtCPF.requestFocus();
            return false;
        }
        if (!tipo.equals("Admin") && !tipo.equals("Operacional")) {
            JOptionPane.showMessageDialog(this, "Selecione um tipo de usuário válido", "Erro", JOptionPane.ERROR_MESSAGE);
            cmbDep.requestFocus();
            return false;
        }
        return true;
    }
    private void limparCampos() {
        txtNome.setText("");
        txtPass.setText("");
        txtCPF.setText("");
        cmbDep.setSelectedIndex(0);
        txtNome.requestFocus();
    }
}
