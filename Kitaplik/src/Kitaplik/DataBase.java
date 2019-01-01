package Kitaplik;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DataBase {

    public Statement sqlDurum = null;
    public ResultSet satir;
    public Connection conn = null;

    public DataBase() {
        veriTabaniBaglanti();
    }

    public void veriTabaniBaglanti() {
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost:3306/KitapKurdu";
        final String USER = "root";
        final String PASS = "573586";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            sqlDurum = conn.createStatement();
            System.out.println("***********************************Connected.");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean yeniKayit(String userName, String password, String role, String location, String age) {
        try {
            String sqlCumle = "INSERT INTO KitapKurdu.bx_users (user_name,user_password,role,location,age,first_login) "
                    + "VALUES "
                    + "('" + userName + "','" + password + "','" + role + "','" + location + "','" + age + "',0)";
            System.out.println(sqlCumle);
            sqlDurum = conn.prepareStatement(sqlCumle);
            int i = 0;
            i = sqlDurum.executeUpdate(sqlCumle);

            if (i == 1) {
                System.out.println(" Başarılı Kayıt.");
                return true;

            } else {
                return false;
            }
        } catch (SQLException ex) {

        } finally {
            try {
                if (sqlDurum != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        try {
            System.out.println(conn.isClosed());
        } catch (SQLException ex) {
        }
        return false;
    }

    public String girisKontrol(String userName, String password) {
        try {

            String sqlden = "SELECT * FROM KitapKurdu.bx_users WHERE BINARY user_name='" + userName + "' && user_password='" + password + "'";
            System.out.println(sqlden);
            satir = sqlDurum.executeQuery(sqlden);

            while (satir.next()) {

                System.out.println("Kullanıcı Var.");
                return satir.getString(4);
            }
            return "empty";
        } catch (SQLException ex) {
        } finally {
            try {
                if (sqlDurum != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        try {
            System.out.println(conn.isClosed());
        } catch (SQLException ex) {
        }
        return "empty";
    }

    public String[][] tumListeKitaplar() {
        String veriler[][];
        try {
            System.out.println("123");
            int i = 0;
            String say = "SELECT COUNT(isbn) FROM bx_books";
            String sqlVerGet = "SELECT isbn,book_title,book_author,year_of_publication,publisher,image_url_s,image_url_m,image_url_l,pdf_url FROM bx_books";

            satir = sqlDurum.executeQuery(say);
            satir.next();
            System.out.println("Kitap Sayısı : " + satir.getInt(1));
            veriler = new String[satir.getInt(1)][9];
            satir = sqlDurum.executeQuery(sqlVerGet);

            while (satir.next()) {

                veriler[i][0] = satir.getString(1);
                veriler[i][1] = satir.getString(2);
                veriler[i][2] = satir.getString(3);
                veriler[i][3] = satir.getString(4);
                veriler[i][4] = satir.getString(5);
                veriler[i][5] = satir.getString(6);
                veriler[i][6] = satir.getString(7);
                veriler[i][7] = satir.getString(8);
                veriler[i][8] = satir.getString(9);

                i++;
            }

            System.out.println("Tüm Liste Getirildi");
            return veriler;

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (sqlDurum != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        try {
            System.out.println(conn.isClosed());

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String[][] tumListeKullanıcılar() {
        String veriler[][];
        try {
            int i = 0;
            String say = "SELECT COUNT(user_id) FROM bx_users";
            String sqlVerGet = "SELECT * FROM bx_users";

            satir = sqlDurum.executeQuery(say);
            satir.next();
            System.out.println("Kullanıcı Sayısı : " + satir.getInt(1));
            veriler = new String[satir.getInt(1)][6];
            satir = sqlDurum.executeQuery(sqlVerGet);

            while (satir.next()) {

                veriler[i][0] = String.valueOf(satir.getInt(1));
                veriler[i][1] = satir.getString(2);
                veriler[i][2] = satir.getString(3);
                veriler[i][3] = satir.getString(4);
                veriler[i][4] = satir.getString(5);
                veriler[i][5] = satir.getString(6);

                i++;
            }
            System.out.println("Tüm Kullanicilar Getirildi.");
            return veriler;

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (sqlDurum != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        try {
            System.out.println(conn.isClosed());

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void kitapKayit(String isbn, String book_title, String book_author, String year,
            String publisher, String image_s, String image_m, String image_l, String pdf_url) {

        try {
            String sayisi = "SELECT COUNT(isbn) FROM bx_books ";
            System.out.println(sayisi);
            ResultSet satir15 = sqlDurum.executeQuery(sayisi);
            int adet = 0;
            satir15.next();
            adet = Integer.valueOf(satir15.getString(1)) + 1;

            String kitapKayitSql
                    = "INSERT INTO bx_books "
                    + "(isbn,book_title,book_author,year_of_publication,publisher,"
                    + "image_url_s,image_url_m,image_url_l,pdf_url,siralama) "
                    + "VALUES ('"
                    + isbn + "','" + book_title + "','"
                    + book_author + "','" + year + "','" + publisher + "','"
                    + image_s + "','" + image_m + "','" + image_l + "','"
                    + pdf_url + "'," + adet + ")";
            System.out.println(kitapKayitSql);
            sqlDurum.executeUpdate(kitapKayitSql);
            JOptionPane.showMessageDialog(null, "Kayıt Başarılı .", "BAŞARILI", JOptionPane.CLOSED_OPTION);
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void kitapUpdate(String isbn, String isbnDegis, String book_title, String book_author, String year,
            String publisher, String image_s, String image_m, String image_l, String pdf_url) {
        try {
            String kitapKayitSql
                    = "UPDATE bx_books "
                    + "SET isbn='" + isbnDegis + "' ,book_title='" + book_title + "',book_author='" + book_author + "',year_of_publication='" + year + "',"
                    + "publisher='" + publisher + "',image_url_s='" + image_s + "',image_url_m='" + image_m + "',image_url_l='" + image_l + "',pdf_url='" + pdf_url + "' "
                    + "WHERE isbn='" + isbn + "'";
            System.out.println(kitapKayitSql);
            sqlDurum.executeUpdate(kitapKayitSql);
            JOptionPane.showMessageDialog(null, "Güncelleme Başarılı .", "BAŞARILI", JOptionPane.CLOSED_OPTION);
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void kitapSil(String isbn) {
        try {
            String kitapSil = "DELETE FROM bx_books WHERE isbn='" + isbn + "'";
            System.out.println(kitapSil);
            sqlDurum.executeUpdate(kitapSil);
            JOptionPane.showMessageDialog(null, "Silme Başarılı .", "BAŞARILI", JOptionPane.CLOSED_OPTION);
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String[][] isbnVeriCek(String isbn) {
        String veriler[][];
        try {
            int i = 0;
            String say = "SELECT COUNT(isbn) FROM bx_books WHERE isbn='" + isbn + "'";
            String sqlVerGet = "SELECT isbn,book_title,book_author,year_of_publication,publisher,image_url_s,image_url_m,image_url_l,pdf_url FROM bx_books WHERE isbn='" + isbn + "'";
            System.out.println(sqlVerGet);
            satir = sqlDurum.executeQuery(say);
            satir.next();
            veriler = new String[satir.getInt(1)][9];
            satir = sqlDurum.executeQuery(sqlVerGet);
            while (satir.next()) {

                veriler[i][0] = satir.getString(1);;
                veriler[i][1] = satir.getString(2);
                veriler[i][2] = satir.getString(3);
                veriler[i][3] = satir.getString(4);
                veriler[i][4] = satir.getString(5);
                veriler[i][5] = satir.getString(6);
                veriler[i][6] = satir.getString(7);
                veriler[i][7] = satir.getString(8);
                veriler[i][8] = satir.getString(9);

                i++;
            }

            System.out.println("5555");
            return veriler;

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (sqlDurum != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        try {
            System.out.println(conn.isClosed());

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String[][] kitapAdiVeriCek(String kitapAdi) {
        String veriler[][];
        try {
            int i = 0;
            String say = "SELECT COUNT(book_title) FROM bx_books WHERE book_title='" + kitapAdi + "'";
            String sqlVerGet = "SELECT isbn,book_title,book_author,year_of_publication,publisher,image_url_s,image_url_m,image_url_l,pdf_url FROM bx_books WHERE book_title='" + kitapAdi + "'";

            satir = sqlDurum.executeQuery(say);
            satir.next();
            System.out.println(satir.getInt(1));
            veriler = new String[satir.getInt(1)][9];
            satir = sqlDurum.executeQuery(sqlVerGet);
            while (satir.next()) {

                veriler[i][0] = satir.getString(1);
                veriler[i][1] = satir.getString(2);
                veriler[i][2] = satir.getString(3);
                veriler[i][3] = satir.getString(4);
                veriler[i][4] = satir.getString(5);
                veriler[i][5] = satir.getString(6);
                veriler[i][6] = satir.getString(7);
                veriler[i][7] = satir.getString(8);
                veriler[i][8] = satir.getString(9);

                i++;
            }

            System.out.println("5555");
            return veriler;

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (sqlDurum != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        try {
            System.out.println(conn.isClosed());

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String[][] yazarVeriCek(String yazar) {
        String veriler[][];
        try {
            int i = 0;
            String say = "SELECT COUNT(book_author) FROM bx_books WHERE book_author='" + yazar + "'";
            String sqlVerGet = "SELECT isbn,book_title,book_author,year_of_publication,publisher,image_url_s,image_url_m,image_url_l,pdf_url FROM bx_books WHERE book_author='" + yazar + "'";

            satir = sqlDurum.executeQuery(say);
            satir.next();
            System.out.println(satir.getInt(1));
            veriler = new String[satir.getInt(1)][9];
            satir = sqlDurum.executeQuery(sqlVerGet);
            while (satir.next()) {

                veriler[i][0] = satir.getString(1);
                veriler[i][1] = satir.getString(2);
                veriler[i][2] = satir.getString(3);
                veriler[i][3] = satir.getString(4);
                veriler[i][4] = satir.getString(5);
                veriler[i][5] = satir.getString(6);
                veriler[i][6] = satir.getString(7);
                veriler[i][7] = satir.getString(8);
                veriler[i][8] = satir.getString(9);

                i++;
            }

            System.out.println("5555");
            return veriler;

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (sqlDurum != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        try {
            System.out.println(conn.isClosed());

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String[][] yilVeriCek(String yil) {
        String veriler[][];
        try {
            int i = 0;
            String say = "SELECT COUNT(year_of_publication) FROM bx_books WHERE year_of_publication='" + yil + "'";
            String sqlVerGet = "SELECT isbn,book_title,book_author,year_of_publication,publisher,image_url_s,image_url_m,image_url_l,pdf_url FROM bx_books WHERE year_of_publication='" + yil + "'";

            satir = sqlDurum.executeQuery(say);
            satir.next();
            System.out.println(satir.getInt(1));
            veriler = new String[satir.getInt(1)][9];
            satir = sqlDurum.executeQuery(sqlVerGet);
            while (satir.next()) {

                veriler[i][0] = satir.getString(1);
                veriler[i][1] = satir.getString(2);
                veriler[i][2] = satir.getString(3);
                veriler[i][3] = satir.getString(4);
                veriler[i][4] = satir.getString(5);
                veriler[i][5] = satir.getString(6);
                veriler[i][6] = satir.getString(7);
                veriler[i][7] = satir.getString(8);
                veriler[i][8] = satir.getString(9);

                i++;
            }

            System.out.println("5555");
            return veriler;

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (sqlDurum != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        try {
            System.out.println(conn.isClosed());

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String[][] yayinEviVeriCek(String yayinEvi) {
        String veriler[][];
        try {
            int i = 0;
            String say = "SELECT COUNT(publisher) FROM bx_books WHERE publisher='" + yayinEvi + "'";
            String sqlVerGet = "SELECT isbn,book_title,book_author,year_of_publication,publisher,image_url_s,image_url_m,image_url_l,pdf_url FROM bx_books WHERE publisher='" + yayinEvi + "'";

            satir = sqlDurum.executeQuery(say);
            satir.next();
            System.out.println(satir.getInt(1));
            veriler = new String[satir.getInt(1)][9];
            satir = sqlDurum.executeQuery(sqlVerGet);
            while (satir.next()) {

                veriler[i][0] = satir.getString(1);
                veriler[i][1] = satir.getString(2);
                veriler[i][2] = satir.getString(3);
                veriler[i][3] = satir.getString(4);
                veriler[i][4] = satir.getString(5);
                veriler[i][5] = satir.getString(6);
                veriler[i][6] = satir.getString(7);
                veriler[i][7] = satir.getString(8);
                veriler[i][8] = satir.getString(9);

                i++;
            }

            System.out.println("5555");
            return veriler;

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (sqlDurum != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        try {
            System.out.println(conn.isClosed());

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void kullaniciKayit(String userName, String password, String role, String location, String yas) {
        try {
            String kullaniciKayitSql
                    = "INSERT INTO bx_users "
                    + "(user_name,user_password,role,location,age,first_login) "
                    + "VALUES ('"
                    + userName + "','" + password + "','"
                    + role + "','" + location + "','" + yas + "',0)";
            System.out.println(kullaniciKayitSql+"--------------------hatalııı");
            sqlDurum.executeUpdate(kullaniciKayitSql);
            JOptionPane.showMessageDialog(null, "Kayıt Başarılı .", "BAŞARILI", JOptionPane.CLOSED_OPTION);
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void kullaniciUpdate(int id, String userName, String password, String role, String location, String yas) {
        try {
            String kullaniciKayitSql
                    = "UPDATE bx_users "
                    + "SET user_name='" + userName + "',user_password='" + password + "',role='" + role + "',location='" + location + "',"
                    + "age='" + yas + "' WHERE user_id=" + id;
            System.out.println(kullaniciKayitSql);
            sqlDurum.executeUpdate(kullaniciKayitSql);
            JOptionPane.showMessageDialog(null, "Güncelleme Başarılı .", "BAŞARILI", JOptionPane.CLOSED_OPTION);
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void kullaniciSil(int id) {
        try {
            String kullaniciSil = "DELETE FROM bx_users WHERE user_id=" + id;
            System.out.println(kullaniciSil);
            sqlDurum.executeUpdate(kullaniciSil);
            JOptionPane.showMessageDialog(null, "Silme Başarılı .", "BAŞARILI", JOptionPane.CLOSED_OPTION);

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String[][] kullaniciAdiVeriCek(String kullaniciAdi) {
        String veriler[][];
        try {
            int i = 0;
            String say = "SELECT COUNT(user_name) FROM bx_users WHERE user_name='" + kullaniciAdi + "'";
            String sqlVerGet = "SELECT * FROM bx_users WHERE user_name='" + kullaniciAdi + "'";

            satir = sqlDurum.executeQuery(say);
            satir.next();
            System.out.println(satir.getInt(1));
            veriler = new String[satir.getInt(1)][10];
            satir = sqlDurum.executeQuery(sqlVerGet);
            while (satir.next()) {

                veriler[i][0] = String.valueOf(satir.getInt(1));
                veriler[i][1] = satir.getString(2);
                veriler[i][2] = satir.getString(3);
                veriler[i][3] = satir.getString(4);
                veriler[i][4] = satir.getString(5);
                veriler[i][5] = satir.getString(6);
                i++;
            }

            System.out.println("5555");
            return veriler;

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (sqlDurum != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        try {
            System.out.println(conn.isClosed());

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String[][] kitalarOnVeri(int baslangıc) {
        String veriler[][];
        try {
            int i = 0;
            int say = 0;
            String sqlVerGet = "SELECT * FROM bx_books LIMIT " + baslangıc + ",10";
            System.out.println(sqlVerGet);
            satir = sqlDurum.executeQuery(sqlVerGet);
            while (satir.next()) {
                say++;
            }
            satir.absolute(0);
            System.out.println(say);
            veriler = new String[say][9];
            satir = sqlDurum.executeQuery(sqlVerGet);

            while (satir.next()) {

                veriler[i][0] = satir.getString(1);
                veriler[i][1] = satir.getString(2);
                veriler[i][2] = satir.getString(3);
                veriler[i][3] = satir.getString(4);
                veriler[i][4] = satir.getString(5);
                veriler[i][5] = satir.getString(6);
                veriler[i][6] = satir.getString(7);
                veriler[i][7] = satir.getString(8);
                veriler[i][8] = satir.getString(9);

                i++;
            }

            System.out.println("Kitap 10 geldi.");
            return veriler;

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (sqlDurum != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        try {
            System.out.println(conn.isClosed());

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String[][] enIyiOnKitap() {
        String veriler[][] = new String[10][9];
        String iyiKitapIsbn[][] = new String[10][2];
        ResultSet satir2 = null;
        try {
            int i = 0;
            int j = 0;

            String sqlIyiIlkOn = "SELECT isbn ,AVG(book_rating) FROM KitapKurdu.bx_book_ratings GROUP BY isbn ORDER BY AVG(book_rating) desc,sum(book_rating) desc limit 10";
            satir = sqlDurum.executeQuery(sqlIyiIlkOn);
            while (satir.next()) {
                iyiKitapIsbn[i][0] = satir.getString(1);
                iyiKitapIsbn[i][1] = satir.getString(2);

                System.out.println(iyiKitapIsbn[i][0]);

                i++;
            }

            while (j < 10) {
                String sqlVerGet = "SELECT isbn,book_title,book_author,year_of_publication,publisher,image_url_s,image_url_m,image_url_l,pdf_url FROM bx_books WHERE isbn='" + iyiKitapIsbn[j][0] + "'";
                System.out.println(sqlVerGet);
                satir2 = sqlDurum.executeQuery(sqlVerGet);

                satir2.absolute(1);

                veriler[j][0] = satir2.getString(1);
                veriler[j][1] = satir2.getString(2);
                veriler[j][2] = satir2.getString(3);
                veriler[j][3] = satir2.getString(4);
                veriler[j][4] = satir2.getString(5);
                veriler[j][5] = satir2.getString(6);
                veriler[j][6] = satir2.getString(7);
                veriler[j][7] = satir2.getString(8);
                veriler[j][8] = satir2.getString(9);

                j++;
            }

            System.out.println("En iyi 10 geldi.");
            return veriler;

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (sqlDurum != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        try {
            System.out.println(conn.isClosed());

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String[][] enPopulerOnKitap() {
        String veriler[][] = new String[10][10];
        String populerKitapIsbn[][] = new String[10][2];
        ResultSet satir2 = null;
        try {
            int i = 0;
            int j = 0;
            int k = 0;

            String sqlPopulerIlkOn = "SELECT isbn ,avg(book_rating) FROM KitapKurdu.bx_book_ratings GROUP BY isbn order by count(isbn) desc limit 10";
            satir = sqlDurum.executeQuery(sqlPopulerIlkOn);
            while (satir.next()) {
                populerKitapIsbn[i][0] = satir.getString(1);
                populerKitapIsbn[i][1] = satir.getString(2);

                System.out.println(populerKitapIsbn[i][0]);
                i++;
            }

            System.out.println("-------");
            while (j < 10) {
                String sqlVerGet = "SELECT isbn,book_title,book_author,year_of_publication,publisher,image_url_s,image_url_m,image_url_l,pdf_url FROM bx_books WHERE isbn='" + populerKitapIsbn[j][0] + "'";
                System.out.println(sqlVerGet);
                satir2 = sqlDurum.executeQuery(sqlVerGet);

                satir2.absolute(1);

                veriler[j][0] = satir2.getString(1);
                veriler[j][1] = satir2.getString(2);
                veriler[j][2] = satir2.getString(3);
                veriler[j][3] = satir2.getString(4);
                veriler[j][4] = satir2.getString(5);
                veriler[j][5] = satir2.getString(6);
                veriler[j][6] = satir2.getString(7);
                veriler[j][7] = satir2.getString(8);
                veriler[j][8] = satir2.getString(9);
                //veriler[j][9] = populerKitapIsbn[j][1];

                System.out.println(veriler[j][0] + "---" + veriler[j][1] + "----" + veriler[j][9]);

                j++;
            }
            System.out.println("En popüler 10 geldi.");
            return veriler;

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (sqlDurum != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        try {
            System.out.println(conn.isClosed());

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String[][] enYeniKitap() {
        String veriler[][] = new String[10][10];
        int kitapKayitSayi = 0;
        int j = 0;
        ResultSet satir2 = null;
        try {
            String enYeniKitap = "select count(isbn) from bx_books";
            satir = sqlDurum.executeQuery(enYeniKitap);
            while (satir.next()) {
                kitapKayitSayi = satir.getInt(1);
                System.out.println(kitapKayitSayi);
            }

            System.out.println("-------");

            String sqlVerGet = "SELECT isbn,book_title,book_author,year_of_publication,publisher,image_url_s,image_url_m,image_url_l,pdf_url FROM bx_books ORDER BY siralama ASC LIMIT " + (kitapKayitSayi - 10) + ",10";
            System.out.println(sqlVerGet);
            satir2 = sqlDurum.executeQuery(sqlVerGet);

            while (satir2.next()) {

                veriler[j][0] = satir2.getString(1);
                veriler[j][1] = satir2.getString(2);
                veriler[j][2] = satir2.getString(3);
                veriler[j][3] = satir2.getString(4);
                veriler[j][4] = satir2.getString(5);
                veriler[j][5] = satir2.getString(6);
                veriler[j][6] = satir2.getString(7);
                veriler[j][7] = satir2.getString(8);
                veriler[j][8] = satir2.getString(9);

                System.out.println(veriler[j][0] + "---" + veriler[j][1] + "----" + veriler[j][9]);

                j++;
            }
            System.out.println("En yeni 10 geldi.");
            return veriler;

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (sqlDurum != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        try {
            System.out.println(conn.isClosed());

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String[] kitapAc(String isbn, String userId) {
        String veriler[] = new String[11];
        try {
            String sqlVerGet = "SELECT isbn,book_title,book_author,year_of_publication,publisher,image_url_s,image_url_m,image_url_l,pdf_url FROM bx_books WHERE isbn='" + isbn + "'";
            satir = sqlDurum.executeQuery(sqlVerGet);

            while (satir.next()) {
                veriler[0] = satir.getString(1);
                veriler[1] = satir.getString(2);
                veriler[2] = satir.getString(3);
                veriler[3] = satir.getString(4);
                veriler[4] = satir.getString(5);
                veriler[5] = satir.getString(6);
                veriler[6] = satir.getString(7);
                veriler[7] = satir.getString(8);
                veriler[8] = satir.getString(9);
            }

            String sqlVerOrtPuan = "SELECT AVG(book_rating) FROM bx_book_ratings WHERE isbn='" + isbn + "'";
            ResultSet satirort = sqlDurum.executeQuery(sqlVerOrtPuan);
            System.out.println(sqlVerOrtPuan);

            int a = 0;
            while (satirort.next()) {
                a++;
            }
            if (a == 1) {
                satirort.absolute(1);
                veriler[9] = satirort.getString(1);
            } else if (a == 0) {
                veriler[9] = "0";
            }

            System.out.println(veriler[9]);

            String sqlVerUserPuan = "SELECT book_rating FROM bx_book_ratings WHERE isbn='" + isbn + "' and user_id=" + userId;
            System.out.println(sqlVerUserPuan);
            ResultSet satirPuan = sqlDurum.executeQuery(sqlVerUserPuan);
            int b = 0;
            while (satirPuan.next()) {
                b++;
            }
            if (b == 1) {
                satirPuan.absolute(1);
                veriler[10] = satirPuan.getString(1);
            } else if (b == 0) {
                veriler[10] = "0";
            }

            System.out.println("5555");
            return veriler;

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (sqlDurum != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        try {
            System.out.println(conn.isClosed());

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String kullaniciId(String gelenKulaniciAdi) {
        try {
            String donenDeger;
            String kullaniciIdGel = "SELECT user_id FROM bx_users WHERE user_name='" + gelenKulaniciAdi + "'";
            System.out.println(kullaniciIdGel);
            ResultSet usersId = sqlDurum.executeQuery(kullaniciIdGel);
            usersId.next();
            donenDeger = usersId.getString(1);
            return donenDeger;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void puanKayit(String isbn, String kullaniciId, String puan) {
        try {
            String kullaniciKayitSql
                    = "INSERT INTO bx_book_ratings "
                    + "(user_id,isbn,book_rating) "
                    + "VALUES ('"
                    + kullaniciId + "','" + isbn + "','" + puan + "')";
            System.out.println(kullaniciKayitSql);
            sqlDurum.executeUpdate(kullaniciKayitSql);
            JOptionPane.showMessageDialog(null, "KİTABI OYLADINIZ.", "BAŞARILI", JOptionPane.CLOSED_OPTION);
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void puanUpdate(String isbn, String kullaniciId, String puan) {
        try {
            String kullaniciKayitSql
                    = "UPDATE bx_book_ratings SET "
                    + "book_rating='" + puan + "' where user_id='" + kullaniciId + "' and isbn='" + isbn + "'";
            System.out.println(kullaniciKayitSql);
            sqlDurum.executeUpdate(kullaniciKayitSql);
            JOptionPane.showMessageDialog(null, "Oyunuz Güncellendi.", "BAŞARILI", JOptionPane.CLOSED_OPTION);
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void oyKaydet(String isbn, String kullaniciId, Object puan) {
        try {
            System.out.println("GEldi Buraya");
            String puanKayitSql
                    = "INSERT INTO bx_book_ratings "
                    + "(user_id,isbn,book_rating) "
                    + "VALUES ('"
                    + kullaniciId + "','" + isbn + "','" + puan + "')";
            System.out.println(puanKayitSql);
            sqlDurum.executeUpdate(puanKayitSql);
            JOptionPane.showMessageDialog(null, "KİTABI OYLADINIZ.", "BAŞARILI", JOptionPane.CLOSED_OPTION);
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String[][] kitapAdiAra(String kitapAdi) {
        String veriler[][];
        try {
            int i = 0;
            String say = "SELECT COUNT(book_title) FROM bx_books WHERE book_title LIKE '%" + kitapAdi + "%'";
            String sqlVerGet = "SELECT isbn,book_title,book_author FROM bx_books WHERE book_title LIKE '%" + kitapAdi + "%'";

            System.out.println(say);
            System.out.println(sqlVerGet);
            satir = sqlDurum.executeQuery(say);
            satir.next();
            System.out.println(satir.getInt(1));
            veriler = new String[satir.getInt(1)][9];
            satir = sqlDurum.executeQuery(sqlVerGet);
            while (satir.next()) {

                veriler[i][0] = satir.getString(1);
                veriler[i][1] = satir.getString(2);
                veriler[i][2] = satir.getString(3);

                i++;
            }

            System.out.println("5555");
            return veriler;

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (sqlDurum != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        try {
            System.out.println(conn.isClosed());

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void userAd() {
        try {
            Statement sqldene = null;
            String sqlVerGet = "SELECT isbn FROM bx_books ";
            System.out.println(sqlVerGet);
            ResultSet satir15 = sqlDurum.executeQuery(sqlVerGet);

            int ad = 1;
            while (satir15.next()) {

                String kitapKayitSql = "UPDATE bx_books SET siralama='" + ad + "' WHERE isbn='" + satir15.getString(1) + "'";
                System.out.println(kitapKayitSql);
                sqldene = conn.createStatement();
                sqldene.executeUpdate(kitapKayitSql);
                ad++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean ilkGirisKontrol(String kullaniciAdi, String psw) {
        try {
            int girdiMi;
            String kont = "SELECT first_login FROM bx_users WHERE user_name='" + kullaniciAdi + "' AND user_password='" + psw + "'";
            satir = sqlDurum.executeQuery(kont);
            while (satir.next()) {
                girdiMi = satir.getInt(1);
                if (girdiMi == 1) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void ilkGirisUpdate(String kullaniciId) {
        try {
            String sorgu
                    = "UPDATE bx_users SET "
                    + "first_login='1' WHERE user_id='" + kullaniciId + "'";
            System.out.println(sorgu);
            sqlDurum.executeUpdate(sorgu);
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int kitapSayisi() {
        try {
            String say = "SELECT COUNT(isbn) FROM bx_books";
            System.out.println(say);
            int sayac = 0;
            satir = sqlDurum.executeQuery(say);
            satir.next();
            sayac = satir.getInt(1);
            return sayac;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public String[] onerilenKitap(String GelenIsbn) {
        String veriler[] = new String[10];
        ResultSet satir2 = null;
        try {
            String sqlVerGet = "SELECT isbn,book_title,book_author,year_of_publication,"
                    + "publisher,image_url_s,image_url_m,image_url_l,pdf_url FROM bx_books WHERE isbn='"+GelenIsbn+"'";
            System.out.println(sqlVerGet);
            satir2 = sqlDurum.executeQuery(sqlVerGet);

            while (satir2.next()) {

                veriler[0] = satir2.getString(1);
                veriler[1] = satir2.getString(2);
                veriler[2] = satir2.getString(3);
                veriler[3] = satir2.getString(4);
                veriler[4] = satir2.getString(5);
                veriler[5] = satir2.getString(6);
                veriler[6] = satir2.getString(7);
                veriler[7] = satir2.getString(8);
                veriler[8] = satir2.getString(9);

                System.out.println(veriler[0] + "---" + veriler[1] + "----" + veriler[9]);
            }
            System.out.println("En öneri geldi.");
            return veriler;

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (sqlDurum != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        try {
            System.out.println(conn.isClosed());

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int userId(String gelenKullanıcıAdi) {
        ResultSet satir2 = null;
        int donenID = 0;
        try {
            String sqlVerGet = "SELECT user_id FROM bx_users WHERE user_name='"+gelenKullanıcıAdi+"'";
            System.out.println(sqlVerGet);
            satir2 = sqlDurum.executeQuery(sqlVerGet);

            while (satir2.next()) {
                donenID=satir2.getInt(1);
            }
            System.out.println("En id geldi.");
            return donenID;

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (sqlDurum != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        try {
            System.out.println(conn.isClosed());

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return donenID;
    }
    
    public int ayniKullaniciVarMi(String gelenKullanıcıAdi) {
        ResultSet satir2 = null;
        int i = 0;
        try {
            String sqlVerGet = "SELECT user_id FROM bx_users WHERE user_name='"+gelenKullanıcıAdi+"'";
            System.out.println(sqlVerGet);
            satir2 = sqlDurum.executeQuery(sqlVerGet);

            while (satir2.next()) {
                i++;
            }
            System.out.println("En id geldi.");
            System.out.println(i+"------qwewqeweweq");
            return i;

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (sqlDurum != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        try {
            System.out.println(conn.isClosed());

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
}
