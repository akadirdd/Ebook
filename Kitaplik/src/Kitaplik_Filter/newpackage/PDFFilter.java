package Kitaplik_Filter.newpackage;

import java.io.File;


public class PDFFilter extends javax.swing.filechooser.FileFilter {
  @Override
  public boolean accept(File file) {
    // Sadece directorylere ve XML dosyalarına izin verilmektedir.
    return file.isDirectory() || file.getAbsolutePath().endsWith(".pdf");
  }
  @Override
  public String getDescription() {
    // Bu tanımlama dialogda gösterilecektir.
    return "Pdf Dosyaları (*.pdf)";
  }
}
