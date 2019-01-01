package Kitaplik;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import static java.nio.file.Files.size;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class KitapAc extends JFrame {

    String gelenIsbn;
    String gelenUserId;
    DataBase dataBase;
    String veriler[];
    String kullaniciId;
    
    int say=0;

    public KitapAc(String gelenIsbn, String gelenUserId) {
        this.gelenUserId = gelenUserId;
        dataBase = new DataBase();
        kullaniciId = dataBase.kullaniciId(this.gelenUserId);
        this.gelenIsbn = gelenIsbn;
        System.out.println(kullaniciId);
        
        veriler = dataBase.kitapAc(gelenIsbn, kullaniciId);

        System.out.println(veriler[0] + "---" + veriler[1] + "---" + veriler[2] + "---" + veriler[3] + "---" + veriler[4]
                + "---" + veriler[5] + "---" + veriler[6] + "---" + veriler[7] + "---" + veriler[8] + "---" + veriler[9] + "---" + veriler[10] + "---");
        if(veriler[10].equals("0")){
            say=1;
        }

        init();

    }

    public void init() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((dim.width / 2) - 300, (dim.height / 2) - 300);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JButton button = new JButton("OKU");
        JLabel label = new JLabel();

        JLabel titleISBN = new JLabel("ISBN               :");
        JLabel titleBaslik = new JLabel("KİTAP ADI       :");
        JLabel titleYazar = new JLabel("YAZAR           :");
        JLabel titleYil = new JLabel("YAYIN YILI      :");
        JLabel titleYayinci = new JLabel("YAYIN EVİ       :");
        JLabel titleOrtPuan = new JLabel("ORT PUAN       :");

        JLabel isbn = new JLabel(veriler[0]);
        JLabel baslik = new JLabel(veriler[1]);
        JLabel yazar = new JLabel(veriler[2]);
        JLabel yil = new JLabel(veriler[3]);
        JLabel yayinci = new JLabel(veriler[4]);
        JLabel ortPuan = new JLabel(veriler[9]);

        JPanel panel = new JPanel();
        panel2.setLayout(new GridLayout(6, 2));

        label.setSize(330, 450);

        Image image = null;

        System.out.println(veriler[7]);
        
        try {
            URL url = new URL(veriler[7]);
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        image = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);

        label.setIcon(icon);
        panel1.add(label);

        panel1.setSize(330, 450);
        panel1.setLocation(10, 10);

        panel2.setSize(220, 450);
        panel2.setLocation(360, 10);
        panel2.add(titleISBN);
        panel2.add(isbn);
        panel2.add(titleBaslik);
        panel2.add(baslik);
        panel2.add(titleYazar);
        panel2.add(yazar);
        panel2.add(titleYil);
        panel2.add(yil);
        panel2.add(titleYayinci);
        panel2.add(yayinci);
        panel2.add(titleOrtPuan);
        panel2.add(ortPuan);

        panel3.setSize(330, 60);
        panel3.setLocation(10, 460);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PDFViewer componentExample = new PDFViewer(veriler[8]);
                componentExample.openPdf();
            }
        });

        panel4.setSize(250, 60);
        panel4.setLocation(340, 460);
        button.setPreferredSize(new Dimension(240, 50));
        panel4.add(button);

        StarRater starRater = new StarRater(10, Integer.valueOf(veriler[10]), 0);
        starRater.addStarListener(
                new StarRater.StarListener() {

            public void handleSelection(int selection) {
                System.out.println(selection);
                DataBase db=new DataBase();
                if(say==1){
                    db.puanKayit(gelenIsbn, kullaniciId,String.valueOf(selection));
                }else if(say==0){
                    db.puanUpdate(gelenIsbn, kullaniciId,String.valueOf(selection));
                }
                
            }
        });
        panel3.add(starRater);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);

        this.setResizable(false);
        this.setTitle(veriler[1]);
        this.getContentPane().setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setSize(600, 550);
    }
}
