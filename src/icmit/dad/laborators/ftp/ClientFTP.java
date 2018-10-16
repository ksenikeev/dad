package icmit.dad.laborators.ftp;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClientFTP {

    public static void main(String[] args){
        System.out.println(Paths.get("12.zip"));
        System.out.println(Paths.get("12.zip").getFileName());
        System.out.println(Paths.get("12.zip").toAbsolutePath());
        sendFile("127.0.0.1", "admin", "admin", Paths.get("12.zip"),"12");
    }

    public static boolean sendFile(String host, String user, String password, Path file, String dstDir){
        boolean result = false;
        try {
            URL url = new URL("ftp://"+user+":"+password+"@"+host+"/"+dstDir+"/"+file.getFileName());
            URLConnection conn = url.openConnection();
            try(OutputStream os = conn.getOutputStream();
                FileInputStream fis = new FileInputStream(file.toFile())) {

                int i;
                byte[] buf = new byte[4096];
                while ((i = fis.read(buf)) != -1) {
                    os.write(buf, 0, i);
                }
            }
            result = true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
