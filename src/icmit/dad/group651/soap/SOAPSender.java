package icmit.dad.group651.soap;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class SOAPSender {

    public void sendNomenclature(File file) {


        try {
            URL url = new URL("http://185.20.227.163:8080/server4/addnomenclature");
            //URL url = new URL("http://localhost:8080/server4/addnomenclature");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/xml");

            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream();
                 FileInputStream fis = new FileInputStream(file)) {

                byte[] buf = new byte[2048];
                int r = 0;
                while ((r = fis.read(buf)) != -1) {
                    os.write(buf,0,r);
                }

                os.flush();
            }

            int rcode = connection.getResponseCode();
            System.out.println(rcode);

            String env = "";
            try (BufferedReader bf = new BufferedReader( new InputStreamReader(connection.getInputStream()))) {

                while (bf.ready()) {
                    env += bf.readLine();
                }

                System.out.println("response: " + env);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
