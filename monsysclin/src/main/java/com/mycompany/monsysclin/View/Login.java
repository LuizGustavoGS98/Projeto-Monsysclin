/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.monsysclin.View;

import com.mycompany.monsysclin.Controller.Conexao;
import com.mycompany.monsysclin.Controller.Conexao2;
import com.mycompany.monsysclin.Controller.Inserts;
import com.mycompany.monsysclin.Model.Usuario;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 *
 * @author gabsg
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        fundo.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/login.png")).getImage().getScaledInstance(450, 300, Image.SCALE_SMOOTH)));
    }
    private String emailUser;
    private String senhaUser;
    private String userValido1;
    private String senhaValida;
    

    public String valida() {
        Conexao conexao = new Conexao();
        emailUser = jTextField1.getText();
        senhaUser = jPasswordField1.getText();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(conexao.getStringUrl());
            String query1 = "SELECT * FROM usuario where emailUsuario = '" + emailUser + "' and senhaUsuario = '" + senhaUser + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query1);
            Usuario user;
            while (rs.next()) {
                user = new Usuario(rs.getInt("idUsuario"), rs.getInt("tipo_usuario"), rs.getString("nomeUsuario"), rs.getString("emailUsuario"), rs.getString("senhaUsuario"));
                userValido1 = rs.getString(3);
                senhaValida = rs.getString(4);
            }

            executaValida();

        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Credenciais incorretas", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return userValido1;
    }
    
    public String validaMysql() {
        Conexao2 conexao = new Conexao2();
        emailUser = jTextField1.getText();
        senhaUser = jPasswordField1.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = conexao.getDatasourceMysql().getConnection();
            String query1 = "SELECT * FROM usuario where emailUsuario = '" + emailUser + "' and senhaUsuario = '" + senhaUser + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query1);
            Usuario user;
            while (rs.next()) {
                user = new Usuario(rs.getInt("idUsuario"), rs.getInt("tipo_usuario"), rs.getString("nomeUsuario"), rs.getString("emailUsuario"), rs.getString("senhaUsuario"));
                userValido1 = rs.getString(3);
                senhaValida = rs.getString(4);
            }

            executaValidaMysql();

        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Credenciais incorretas", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return userValido1;
    }

    public void executaValida() {

        if (userValido1.equals(emailUser) && senhaValida.equals(senhaUser)) {
            JOptionPane.showMessageDialog(null, "Credenciais corretas");

            Inserts inserts = new Inserts();
            inserts.insereMaquina();
            inserts.insereDados();
            new Leituras().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Credenciais incorretas", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void executaValidaMysql() {

        if (userValido1.equals(emailUser) && senhaValida.equals(senhaUser)) {
            JOptionPane.showMessageDialog(null, "Credenciais corretas");

            Inserts inserts = new Inserts();
            inserts.insereMaquinaMysql();
            inserts.insereDadosMysql();
            new Leituras().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Credenciais incorretas", "Erro", JOptionPane.ERROR_MESSAGE);
        }
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
        jTextField1 = new javax.swing.JTextField();
        btnLogar = new javax.swing.JButton();
        email = new javax.swing.JLabel();
        senha = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        btnSair = new javax.swing.JButton();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(160, 120, 140, 24);

        btnLogar.setText("Logar");
        btnLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogar);
        btnLogar.setBounds(175, 260, 100, 32);

        email.setBackground(new java.awt.Color(255, 255, 255));
        email.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        email.setForeground(new java.awt.Color(255, 255, 255));
        email.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        email.setText("Login");
        jPanel1.add(email);
        email.setBounds(90, 122, 60, 15);

        senha.setBackground(new java.awt.Color(255, 255, 255));
        senha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        senha.setForeground(new java.awt.Color(255, 255, 255));
        senha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        senha.setText("Senha");
        jPanel1.add(senha);
        senha.setBounds(90, 170, 60, 15);
        jPanel1.add(jPasswordField1);
        jPasswordField1.setBounds(160, 170, 140, 22);

        btnSair.setBackground(new java.awt.Color(255, 0, 0));
        btnSair.setText("X");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel1.add(btnSair);
        btnSair.setBounds(380, 0, 70, 25);
        jPanel1.add(fundo);
        fundo.setBounds(0, 0, 450, 300);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 450, 300);

        setSize(new java.awt.Dimension(450, 300));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogarActionPerformed
        valida();
        validaMysql();
    }//GEN-LAST:event_btnLogarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel email;
    private javax.swing.JLabel fundo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel senha;
    // End of variables declaration//GEN-END:variables
}
