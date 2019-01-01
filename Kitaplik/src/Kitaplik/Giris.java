package Kitaplik;

import javax.swing.JOptionPane;

public class Giris extends javax.swing.JFrame {

    YeniKayit formKayit1;
    Guest guest;
    Admin admin;

    public Giris() {
        initComponents();
        frameOzellikleri();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 0, 51));
        jLabel1.setForeground(new java.awt.Color(0, 153, 102));
        jLabel1.setText("KULLANICI ADI :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, -1, -1));

        jButton1.setText("GİRİŞ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 136, 46));

        jButton2.setText("YENİ KAYIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 126, 45));

        jLabel2.setForeground(new java.awt.Color(0, 153, 102));
        jLabel2.setText("ŞİFRE :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, -1, -1));

        jTextField1.setText("Admin");
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 163, -1));

        jPasswordField1.setText("123");
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 163, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon("/home/mucahit/Desktop/qwe.jpg")); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void frameOzellikleri() {
        this.setTitle("GİRİŞ");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        jPasswordField1.setText("123");

    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (jTextField1.getText().equals("") || jPasswordField1.getText().equals("")) {
            JOptionPane.showMessageDialog(Giris.this, "Lütfen Giriş İçin Kullanıcı Adı ve Şifre Girin.", "HATA", JOptionPane.INFORMATION_MESSAGE);

        } else {
            DataBase dataBase = new DataBase();
            String role = dataBase.girisKontrol(jTextField1.getText(), jPasswordField1.getText());

            if (role.equals("admin")) {
                dataBase.veriTabaniBaglanti();
                if (dataBase.ilkGirisKontrol(jTextField1.getText(), jPasswordField1.getText())) {
                    this.setVisible(false);
                    admin = new Admin(jTextField1.getText());
                } else {
                    this.setVisible(false);
                    IlkOylama ilk = new IlkOylama(jTextField1.getText(),"admin");
                }

            } else if (role.equals("guest")) {
                dataBase.veriTabaniBaglanti();
                if (dataBase.ilkGirisKontrol(jTextField1.getText(), jPasswordField1.getText())) {
                    this.setVisible(false);
                    guest = new Guest(jTextField1.getText());
                } else {
                    this.setVisible(false);
                    IlkOylama ilk = new IlkOylama(jTextField1.getText(),"guest");
                }

            } else {
                JOptionPane.showMessageDialog(Giris.this, "Kullanıcı Adı veya Şifre Yanlış", "HATA", JOptionPane.ERROR_MESSAGE);
            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        formKayit1 = new YeniKayit();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
