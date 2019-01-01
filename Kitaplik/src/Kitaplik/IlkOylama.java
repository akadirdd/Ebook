package Kitaplik;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class IlkOylama extends javax.swing.JFrame {

    int oySayisi = 0;
    Guest guest;
    String kullaniciAdi;
    String verilerKitap[][];
    String role;

    int kitapSayfa = 0;
    String kullaniciId;
    SpinnerModel spinnerModel = new SpinnerNumberModel(0, //initial value
            0, //min
            10, //max
            1);//step

    

    public IlkOylama(String kullaniciAdi,String role) {
        this.kullaniciAdi = kullaniciAdi;
        this.role = role;
        
        DataBase dataBase = new DataBase();
        kullaniciId = dataBase.kullaniciId(this.kullaniciAdi);

        initComponents();
        frameOzellikleri();
        //resimCek();
        kitapIlkOnVeri();
        Uyarı();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel24 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        jSpinner4 = new javax.swing.JSpinner();
        jSpinner5 = new javax.swing.JSpinner();
        jPanel28 = new javax.swing.JPanel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jSpinner6 = new javax.swing.JSpinner();
        jSpinner7 = new javax.swing.JSpinner();
        jSpinner8 = new javax.swing.JSpinner();
        jSpinner9 = new javax.swing.JSpinner();
        jSpinner10 = new javax.swing.JSpinner();
        jPanel30 = new javax.swing.JPanel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel61.setText("jLabel4");
        jLabel61.setMaximumSize(null);
        jLabel61.setMinimumSize(null);
        jLabel61.setPreferredSize(null);

        jLabel62.setText("jLabel2");
        jLabel62.setMaximumSize(null);
        jLabel62.setMinimumSize(null);
        jLabel62.setPreferredSize(null);

        jLabel63.setText("dsfds");
        jLabel63.setMaximumSize(null);
        jLabel63.setMinimumSize(null);
        jLabel63.setPreferredSize(null);

        jLabel64.setText("jLabel3");
        jLabel64.setMaximumSize(null);
        jLabel64.setMinimumSize(null);
        jLabel64.setPreferredSize(null);

        jLabel65.setText("jLabel5");
        jLabel65.setMaximumSize(null);
        jLabel65.setMinimumSize(null);
        jLabel65.setPreferredSize(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157)
                .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155)
                .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174)
                .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel127.setText("asdasdsad");

        jLabel128.setText("jLabel67");

        jLabel129.setText("jLabel67");

        jLabel130.setText("jLabel67");

        jLabel131.setText("jLabel67");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel128, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel128, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel66.setText("jLabel6");

        jLabel67.setText("jLabel7");

        jLabel68.setText("jLabel8");

        jLabel69.setText("jLabel9");

        jLabel70.setText("jLabel10");
        jLabel70.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel70MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jSpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSpinner7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157)
                .addComponent(jSpinner8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155)
                .addComponent(jSpinner9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174)
                .addComponent(jSpinner10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel137.setText("asdasdsad");

        jLabel138.setText("jLabel67");

        jLabel139.setText("jLabel67");

        jLabel140.setText("jLabel67");

        jLabel141.setText("jLabel67");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel137, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel138, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel139, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel140, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel141, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel137, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel138, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel139, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel140, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel141, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton16.setIcon(new javax.swing.ImageIcon("/home/mucahit/NetBeansProjects/Kitaplik/icon/if_circle-arrow-right_173182.png")); // NOI18N
        jButton16.setOpaque(false);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("ONAYLA");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(385, 385, 385)
                        .addComponent(jButton17))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addComponent(jButton17)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public ImageIcon resimCek(String image_Url, int imageWidth, int imageHeight) {
        Image image = null;
        try {
            URL url = new URL(image_Url);
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        image = image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);

        return icon;
    }

    public void frameOzellikleri() {
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        jSpinner1.setModel(spinnerModel);

    }

    public void kitapIlkOnVeri() {
        DataBase db = new DataBase();
        verilerKitap = db.kitalarOnVeri(kitapSayfa);

        jLabel127.setText(verilerKitap[0][1]);
        jLabel128.setText(verilerKitap[1][1]);
        jLabel129.setText(verilerKitap[2][1]);
        jLabel130.setText(verilerKitap[3][1]);
        jLabel131.setText(verilerKitap[4][1]);
        jLabel137.setText(verilerKitap[5][1]);
        jLabel138.setText(verilerKitap[6][1]);
        jLabel139.setText(verilerKitap[7][1]);
        jLabel140.setText(verilerKitap[8][1]);
        jLabel141.setText(verilerKitap[9][1]);

        jLabel63.setIcon(resimCek(verilerKitap[0][7], jLabel63.getWidth(), jLabel63.getHeight()));
        jLabel62.setIcon(resimCek(verilerKitap[1][7], jLabel63.getWidth(), jLabel63.getHeight()));
        jLabel64.setIcon(resimCek(verilerKitap[2][7], jLabel63.getWidth(), jLabel63.getHeight()));
        jLabel61.setIcon(resimCek(verilerKitap[3][7], jLabel63.getWidth(), jLabel63.getHeight()));
        jLabel65.setIcon(resimCek(verilerKitap[4][7], jLabel63.getWidth(), jLabel63.getHeight()));
        jLabel66.setIcon(resimCek(verilerKitap[5][7], jLabel63.getWidth(), jLabel63.getHeight()));
        jLabel67.setIcon(resimCek(verilerKitap[6][7], jLabel63.getWidth(), jLabel63.getHeight()));
        jLabel68.setIcon(resimCek(verilerKitap[7][7], jLabel63.getWidth(), jLabel63.getHeight()));
        jLabel69.setIcon(resimCek(verilerKitap[8][7], jLabel63.getWidth(), jLabel63.getHeight()));
        jLabel70.setIcon(resimCek(verilerKitap[9][7], jLabel63.getWidth(), jLabel63.getHeight()));
        System.out.println("bitti");
    }

    public void Uyarı() {
        JOptionPane.showMessageDialog(IlkOylama.this, "Giriş yapabilmek için en az 10 kitap oylamalısınız.", "UYARI", WIDTH);
    }
    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        DataBase db = new DataBase();
        kitapSayfa = kitapSayfa + 10;
        kitapIlkOnVeri();
        Object a = 0;

        if (!jSpinner1.getValue().toString().equals("0")) {
            db.oyKaydet(verilerKitap[0][0], kullaniciId, jSpinner1.getValue());
            oySayisi++;

            jSpinner1.setValue(a);

        }
        if (!jSpinner2.getValue().toString().equals("0")) {
            db.oyKaydet(verilerKitap[1][0], kullaniciId, jSpinner2.getValue());
            oySayisi++;
            jSpinner2.setValue(a);
        }
        if (!jSpinner3.getValue().toString().equals("0")) {
            db.oyKaydet(verilerKitap[2][0], kullaniciId, jSpinner3.getValue());
            oySayisi++;
            jSpinner3.setValue(a);
        }
        if (!jSpinner4.getValue().toString().equals("0")) {
            db.oyKaydet(verilerKitap[3][0], kullaniciId, jSpinner4.getValue());
            oySayisi++;
            jSpinner4.setValue(a);
        }
        if (!jSpinner5.getValue().toString().toString().equals("0")) {
            db.oyKaydet(verilerKitap[4][0], kullaniciId, jSpinner5.getValue());
            oySayisi++;
            jSpinner5.setValue(a);
        }
        if (!jSpinner6.getValue().toString().equals("0")) {
            db.oyKaydet(verilerKitap[5][0], kullaniciId, jSpinner6.getValue());
            oySayisi++;
            jSpinner6.setValue(a);
        }
        if (!jSpinner7.getValue().toString().equals("0")) {
            db.oyKaydet(verilerKitap[6][0], kullaniciId, jSpinner7.getValue());
            oySayisi++;
            jSpinner7.setValue(a);
        }
        if (!jSpinner8.getValue().toString().equals("0")) {
            db.oyKaydet(verilerKitap[7][0], kullaniciId, jSpinner8.getValue());
            oySayisi++;
            jSpinner8.setValue(a);
        }
        if (!jSpinner9.getValue().toString().equals("0")) {
            db.oyKaydet(verilerKitap[8][0], kullaniciId, jSpinner9.getValue());
            oySayisi++;
            jSpinner9.setValue(a);
        }
        if (!jSpinner10.getValue().toString().equals("0")) {
            db.oyKaydet(verilerKitap[9][0], kullaniciId, jSpinner10.getValue());
            oySayisi++;
            jSpinner10.setValue(a);
        }

    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        if (oySayisi >= 10) {
            DataBase db = new DataBase();
            Object a = 0;

            if (!jSpinner1.getValue().toString().equals("0")) {
                db.oyKaydet(verilerKitap[0][0], kullaniciId, jSpinner1.getValue());
                oySayisi++;

                jSpinner1.setValue(a);

            }
            if (!jSpinner2.getValue().toString().equals("0")) {
                db.oyKaydet(verilerKitap[1][0], kullaniciId, jSpinner2.getValue());
                oySayisi++;
                jSpinner2.setValue(a);
            }
            if (!jSpinner3.getValue().toString().equals("0")) {
                db.oyKaydet(verilerKitap[2][0], kullaniciId, jSpinner3.getValue());
                oySayisi++;
                jSpinner3.setValue(a);
            }
            if (!jSpinner4.getValue().toString().equals("0")) {
                db.oyKaydet(verilerKitap[3][0], kullaniciId, jSpinner4.getValue());
                oySayisi++;
                jSpinner4.setValue(a);
            }
            if (!jSpinner5.getValue().toString().toString().equals("0")) {
                db.oyKaydet(verilerKitap[4][0], kullaniciId, jSpinner5.getValue());
                oySayisi++;
                jSpinner5.setValue(a);
            }
            if (!jSpinner6.getValue().toString().equals("0")) {
                db.oyKaydet(verilerKitap[5][0], kullaniciId, jSpinner6.getValue());
                oySayisi++;
                jSpinner6.setValue(a);
            }
            if (!jSpinner7.getValue().toString().equals("0")) {
                db.oyKaydet(verilerKitap[6][0], kullaniciId, jSpinner7.getValue());
                oySayisi++;
                jSpinner7.setValue(a);
            }
            if (!jSpinner8.getValue().toString().equals("0")) {
                db.oyKaydet(verilerKitap[7][0], kullaniciId, jSpinner8.getValue());
                oySayisi++;
                jSpinner8.setValue(a);
            }
            if (!jSpinner9.getValue().toString().equals("0")) {
                db.oyKaydet(verilerKitap[8][0], kullaniciId, jSpinner9.getValue());
                oySayisi++;
                jSpinner9.setValue(a);
            }
            if (!jSpinner10.getValue().toString().equals("0")) {
                db.oyKaydet(verilerKitap[9][0], kullaniciId, jSpinner10.getValue());
                oySayisi++;
                jSpinner10.setValue(a);
            }
            
            
            if(role.equals("guest")){
                DataBase base=new DataBase();
                base.ilkGirisUpdate(kullaniciId);
                Guest guest=new Guest(kullaniciAdi);
                this.setVisible(false);
                
            }else if(role.equals("admin")){
                DataBase base=new DataBase();
                base.ilkGirisUpdate(kullaniciId);
                Admin admin=new Admin(kullaniciAdi);
                this.setVisible(false);
            }
            
        } else {
            int a = 10 - oySayisi;
            JOptionPane.showMessageDialog(null, "En az 10 oylama yapamnız gerkiyor." + a + " tane daha oylama yapınız.", "EKSİK OYLAMA", JOptionPane.CLOSED_OPTION);
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jLabel70MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel70MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel70MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner10;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JSpinner jSpinner6;
    private javax.swing.JSpinner jSpinner7;
    private javax.swing.JSpinner jSpinner8;
    private javax.swing.JSpinner jSpinner9;
    // End of variables declaration//GEN-END:variables
}
