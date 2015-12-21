import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;
import java.nio.ByteBuffer;


public class Html_Downloader {

	public String download(String new_url) {
		// TODO Auto-generated method stub
		try {    
            URL url = new URL(new_url);
            StringBuilder sb = new StringBuilder();
            String temp = "";
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is ,"UTF-8"));
            
            while((temp = br.readLine())!=null){
            	sb.append(temp);
            }
//            System.out.println(new String(sb.toString().getBytes(),"UTF-8"));
            return sb.toString();
            
           } catch (Exception e) {
             
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
            return null;
           }
		
	}

}
