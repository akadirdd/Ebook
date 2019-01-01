
package Kitaplik;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

public class PDFViewer {

    String filePath;

    public PDFViewer(String filePath) {
        this.filePath = filePath;
    }

    public void openPdf() {
        // build a component controller
        SwingController controller = new SwingController();

        SwingViewBuilder factory = new SwingViewBuilder(controller);

        JPanel viewerComponentPanel = factory.buildViewerPanel();

        // add interactive mouse link annotation support via callback
        controller.getDocumentViewController().setAnnotationCallback(
                new org.icepdf.ri.common.MyAnnotationCallback(
                        controller.getDocumentViewController()));

        JFrame applicationFrame = new JFrame();
        applicationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        applicationFrame.getContentPane().add(viewerComponentPanel);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        applicationFrame.setLocation(dim.width / 2 - 500, dim.height / 2 - 500);
        // Now that the GUI is all in place, we can try openning a PDF
        controller.openDocument(filePath);
        applicationFrame.pack();
        applicationFrame.setVisible(true);
    }
}
