package ru.kpfu.icmit.testing.model.soap;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SOAPSender {

    public void sendNomenclature(File file) {


        try {
            URL url = new URL("http://185.20.227.163:8080/addnomenclature");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/xml");

            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream();
                 FileInputStream fis = new FileInputStream(file)) {

                byte[] buf = new byte[2048];
                int r = 0;
                while ((r = fis.read(buf)) != -1) {
                    os.write(buf);
                }

                os.flush();
            }

//            int rcode = connection.getResponseCode();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
