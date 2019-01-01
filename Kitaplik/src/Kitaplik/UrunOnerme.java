package Kitaplik;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UrunOnerme {
    
    public Connection con;
    public static String matris[][];
    public static int satirSayisi;
    public static int indexDegeri=0;
    ArrayList<String> isbnler=new ArrayList<String>();
    ArrayList<String> x=new ArrayList<String>();
    ArrayList<String> y=new ArrayList<String>();
    ArrayList<String> x2=new ArrayList<String>();
    ArrayList<String> y2=new ArrayList<String>();
    ArrayList<String> xy=new ArrayList<String>();
    
    ArrayList<String> yer=new ArrayList<String>();
    ArrayList<String> isban=new ArrayList<String>();
    
    public static String kitaplar[]=new String[10];

    
    
    public void baglanti(){
        try{
            con =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/KitapKurdu","root","573586");
            System.out.println("connection success");
            //create_matris();
            
        
        }catch(Exception e){
            System.out.println("CONNECTİON ERROR");
        }
    }
    public void korelasyon(int id){
        baglanti();
        String loc="";
        String locationCountry="";
        String age="";
        int asd=0;
        int carp=0;
        String carpstr="";
        int diziboyutu=0;
        
        for (int i = 0; i < yer.size(); i++) {
            yer.remove(i);
        }
        for (int i = 0; i < isban.size(); i++) {
            isban.remove(i);
        }
        try{
            
            String query = "select * from bx_users where user_id="+id;
            
            Statement durum = (Statement) con.createStatement();
            ResultSet rs = (ResultSet) durum.executeQuery(query);
            
            while (rs.next()) {
                System.out.println(rs.getString(1)+" - "+rs.getString(2)+" - "+rs.getString(3)+" - "+rs.getString(4)+" - "+rs.getString(5)+" - "+rs.getString(6));
                loc=rs.getString(5);
                age=rs.getString(6);
            }    //String bolge=locationAyraci(rs.getString(5),3);
            String query1 = "select * from bx_book_ratings where user_id="+id+" and book_rating != 0 ";
            System.out.println(query1);
            Statement durum1 = (Statement) con.createStatement();
            ResultSet rs1 = (ResultSet) durum1.executeQuery(query1);
            //bizim kullanıcının verilerinin matrise kaydı
            while (rs1.next()) {
                System.out.println(rs1.getString(1)+" - "+rs1.getString(2)+" - "+rs1.getString(3)+" - "+rs1.getString(4));
                //String bolge=locationAyraci(rs.getString(5),3);
                isbnler.add(rs1.getString(3));
                x.add(rs1.getString(4));
                y.add("0");
                y2.add("0");
                xy.add("0");
                asd=Integer.parseInt(rs1.getString(4));
                carp=asd*asd;
                carpstr=Integer.toString(carp);
                x2.add(carpstr);

            }
            diziboyutu=isbnler.size();
            locationCountry=locationAyraci(loc,3);
            //location='"+loc+"\'";
            
            
            
            String query2 = "select user_id from bx_users where location like '%"+locationCountry+"' and age='"+age+"'" ;
            
            System.out.println(query2);
            Statement durum2 = (Statement) con.createStatement();
            ResultSet rs2 = (ResultSet) durum2.executeQuery(query2);

            while (rs2.next()) {
                System.out.println("y.size: "+ y.size());
                for (int i = y.size()-1; i >= diziboyutu; i--) {
                    isbnler.remove(i);
                    x.remove(i);
                    y.remove(i);
                    x2.remove(i);
                    y2.remove(i);
                    xy.remove(i);
                }
                y.clear();
                y2.clear();
                xy.clear();
                for (int i = 0; i < diziboyutu; i++) {
                    y.add("0");
                    y2.add("0");
                    xy.add("0");
                }
                System.out.println("sadşz: "+y.size());
                
                int adda=Integer.parseInt(rs2.getString(1));
                if(adda!=id){
                    System.out.println(rs2.getString(1));

                    String query3 = "select * from bx_book_ratings where user_id="+rs2.getString(1);
                    System.out.println(query3);
                    Statement durum3 = (Statement) con.createStatement();
                    ResultSet rs3 = (ResultSet) durum3.executeQuery(query3);

                    while (rs3.next()) {

                        System.out.println(rs3.getString(1)+" - "+rs3.getString(2)+" - "+rs3.getString(3)+" - "+rs3.getString(4));
                        int dege=isbnler.indexOf(rs3.getString(3));
                        int sifirmi=Integer.parseInt(rs3.getString(4));
                        if(sifirmi!=0){//oy sıfır değilse
                            if( dege != -1 ){ // isbn tabloda varsa
                                    
                                y.set(dege,rs3.getString(4));
                                asd=Integer.parseInt(rs3.getString(4));
                                carp=asd*asd;
                                carpstr=Integer.toString(carp);
                                y2.set(dege,carpstr);
                                int ss=Integer.parseInt(x.get(dege));
                                int ss1=asd*ss;
                                String setr=Integer.toString(ss1);
                                xy.set(dege, setr);
                                
                            }else{//isbn bulunamazsa
                                
                                System.out.println("son");
                                
                                isbnler.add(rs3.getString(3));
                                x.add("0");
                                y.add(rs3.getString(4));
                                x2.add("0");
                                asd=Integer.parseInt(rs3.getString(4));
                                carp=asd*asd;
                                carpstr=Integer.toString(carp);
                                y2.add(carpstr);
                                xy.add("0");
                                
                            }

                        }



                    }

                }
                System.out.println("isbler - x - y - x2 - y2 - xy");
                for (int i = 0; i < isbnler.size(); i++) {
                    System.out.println(isbnler.get(i)+" - "+x.get(i)+" - "+y.get(i)+" - "+x2.get(i)+" - "+y2.get(i)+" - "+xy.get(i));
                }
                int toplam_x=0,toplam_y=0,toplam_xKare=0,toplam_yKare=0,toplam_XY=0;
                
                for (int r = 0; r < isbnler.size(); r++) {
                    int int_deger=Integer.parseInt(x.get(r));
                    toplam_x+=int_deger;
                    int_deger=Integer.parseInt(y.get(r));
                    toplam_y+=int_deger;
                    int_deger=Integer.parseInt(x2.get(r));
                    toplam_xKare+=int_deger;
                    int_deger=Integer.parseInt(y2.get(r));
                    toplam_yKare+=int_deger;
                    int_deger=Integer.parseInt(xy.get(r));
                    toplam_XY+=int_deger;
                }
                System.out.println(toplam_x+" - "+toplam_y+" - "+toplam_xKare+" - "+toplam_yKare+" - "+toplam_XY);
                double sonuc=0.0;
                int ustDeger=((isbnler.size())*toplam_XY)-(toplam_x*toplam_y);
                //System.out.println(ustDeger);
                int altDeger1=((isbnler.size())*toplam_xKare)-(int)Math.pow(toplam_x, 2);
                //System.out.println(altDeger1);
                int altDeger2=((isbnler.size())*toplam_yKare)-(int)Math.pow(toplam_y, 2);
                int altDeger=altDeger1*altDeger2;
                double altD=Math.sqrt(altDeger);
                //System.out.println(altD);
                sonuc=(double)ustDeger/altD;
                System.out.println("sonuc11: "+ sonuc);
                int ff=isbnler.size()-diziboyutu;
                if(sonuc>(-1.0) && ff!=0){
                    //int ff=isbnler.size()-diziboyutu;
                    for (int i = diziboyutu; i < isbnler.size(); i++) {
                        isban.add(isbnler.get(i));
                    }
                    yer.add(sonuc+","+ff+","+indexDegeri);
                    indexDegeri =indexDegeri+ff;
                }
                
                
                

            }
            bubble();
            System.out.println("YERLER:");
            for (int i = 0; i < yer.size(); i++) {
                System.out.println(yer.get(i));
            }
            System.out.println(yer.size());
            System.out.println("İSBNLAR:");
            for (int i = 0; i < isban.size(); i++) {
                System.out.println(i+" - "+isban.get(i));
            }
            
//            onerilenKitaplar();
//            for (int i = 0; i < 10; i++) {
//                System.out.println(kitaplar[i]);
//            }
            System.out.println(isban.size());
            //System.out.println("sonuç: "+sondeger);
        
        }catch(Exception e){
            System.out.println("CONNECTİON LOST");
        }
    }
    public String[] onerilenKitaplar(){
        int indisimiz=0;
        int kitapsayisi=0;
        int kitapyeri=0;
        
        for (int i = 0; i < kitaplar.length; i++) {
            kitaplar[i]="0";
        }
        for (int i = 0; i < yer.size(); i++) {
            
            kitapsayisi=kitapAyraci(yer.get(i), 2);
            kitapyeri=kitapAyraci(yer.get(i), 3);
            for (int j = kitapyeri; j < kitapyeri+kitapsayisi; j++) {
                if(indisimiz!=10){
                    kitaplar[indisimiz]=isban.get(j);
                    indisimiz++;
                }else{
                    break;
                }
                
            }
            if(indisimiz==10){
                break;
            }
            
            
        }
        int sayimiz1=0;
        for (int i = 0; i < 10; i++) {
            if((kitaplar[i]).equals("0")){
                sayimiz1=1;
            }
        }
        if(sayimiz1==1){
            try{
                String query2 = "SELECT isbn FROM bx_books LIMIT 80,10" ;
            
                System.out.println(query2);
                Statement durum2 = (Statement) con.createStatement();
                ResultSet rs2 = (ResultSet) durum2.executeQuery(query2);
                int sayac20=0;
                while (rs2.next()) {
                    kitaplar[sayac20]=rs2.getString(1);
                    sayac20++;
                }
                
            }catch(Exception e){
                
            }
            return kitaplar;
        }else{
            return kitaplar;
        }
        
        
        
    }
    public int kitapAyraci(String bolunen,int donecek){
        
        String[] kelime = null;
        kelime = bolunen.split(",");
        int x123=Integer.parseInt(kelime[1]);
        int y123=Integer.parseInt(kelime[2]);
        if(donecek==2){
            return x123;
        }else if(donecek==3){
            return y123;
        }else{
            return 0;
        }
        
    }
    public String locationAyraci(String bolunen,int donecek){
        
        String[] kelime = null;
        kelime = bolunen.split(", ");
        
        if(donecek==1){
            return kelime[0];
        }else if(donecek==2){
            return kelime[1];
        }else{
            return kelime[2];
        }
        
    }
    
    public ArrayList<String> bubble(){
        
        double k1=0,k2=0;
        
        int n=yer.size();
        
        String tut;
        
        for (int i = 0; i < n-1; i++) {
            int sirali=1;
            for (int j = 0; j < n-i-1; j++) {
                
                k1=arrayAyracı(yer.get(j));
                k2=arrayAyracı(yer.get(j+1));
                if(k1<k2){// k1<k2
                    tut=yer.get(j);
                    yer.set(j, yer.get(j+1));
                    yer.set(j+1, tut);
//                    tut=A[j]; 
//                    A[j]=A[j+1];
//                    A[j+1]=tut;
                    sirali=0;
                }
                
                
            }
            if(sirali==1){
                break;
            }
            
        }
        
        return yer;
    }
    public double arrayAyracı(String bolunen){
        String[] ayrilmis=null;
        ayrilmis = bolunen.split(",");
        double x=Double.parseDouble(ayrilmis[0]);
        return x;
        
    }
    
}

