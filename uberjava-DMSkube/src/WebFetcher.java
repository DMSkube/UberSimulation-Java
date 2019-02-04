import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WebFetcher {

    // Instance Variables
   // URLConnection connect;
    //HttpURLConnection u2;
    //BufferedReader bReader;

    String result;

    // Constructor
    public WebFetcher(String url) {
        try {
            URL webPage = new URL(url);
            URLConnection connect = webPage.openConnection();
            InputStream stream = connect.getInputStream();
            InputStreamReader reader = new InputStreamReader(stream);
            StringBuffer buffer = new StringBuffer();
            char[] allChars = new char[500]; // 500 is ample enough for longest webpage
            int totalCharsPresent;

            while ((totalCharsPresent = reader.read(allChars)) > 0) {
                buffer.append(allChars, 0, totalCharsPresent);
            }
            result = buffer.toString();

            //System.out.println(result); // Test tool
        } catch (MalformedURLException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public String toString(){
        return result;
    }


}

