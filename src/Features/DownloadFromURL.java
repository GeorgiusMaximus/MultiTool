package Features;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Scanner;

public class DownloadFromURL {



    public DownloadFromURL(){
        try {
            String address = JOptionPane.showInputDialog("Geben Sie die URL der Datei ein:");
            if (address == null || address.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Keine gültige URL eingegeben.");
                return;
            }

            URL url = new URL(address);
            String[] paths = address.split("/");
            String fileName = paths[paths.length - 1];

            String desktopPath = Paths.get(System.getProperty("user.home"), "Desktop", fileName).toString();
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(desktopPath);

            byte[] bytes = new byte[1024];
            int len;
            int downloaded = 0;
            while ((len = is.read(bytes)) != -1) {
                os.write(bytes, 0, len);
                downloaded += len;
            }

            is.close();
            os.close();
            JOptionPane.showMessageDialog(null, "Download abgeschlossen! Datei gespeichert unter:\n" + desktopPath);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fehler beim Herunterladen: " + e.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }


}
