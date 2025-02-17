package Features;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Paths;


public class DownloadFromURL {



    public DownloadFromURL(){
        try {
            String address = JOptionPane.showInputDialog("Put in the URL of the wanted File: ");
            if (address == null || address.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No fitting URL");
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
            JOptionPane.showMessageDialog(null, "Download completed. File saved at:\n" + desktopPath);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error during download: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}
