package JSON_APIS_ETC;

import org.json.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class web_stuff {
    public static void main(String[] args) throws IOException, JSONException {

        String usrArtist = new String();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter the name of the artist you would like to find on itunes ...");
        usrArtist = reader.readLine();

        URL myUrl = new URL("https://itunes.apple.com/search?term=" + usrArtist + "&entity=album");

        URLConnection myUrlConnection = myUrl.openConnection();

        java.io.InputStream myInputStream = myUrlConnection.getInputStream();

        InputStreamReader myInputStreamReader;
        myInputStreamReader = new InputStreamReader(myInputStream);

        BufferedReader in = new BufferedReader(myInputStreamReader);

        String line, str;
        str = "";

        System.out.print("\n");

        while ((line = in.readLine()) != null)
            str += line;

        JSONObject myJsonObject;
        myJsonObject = new JSONObject(str);

        JSONArray resultsArray = myJsonObject.getJSONArray("results");

        System.out.println("\nNumber of results: " + resultsArray.length());

        JSONObject[] objArr = new JSONObject[resultsArray.length()];
        String[] name = new String[resultsArray.length()];
        String[] album = new String[resultsArray.length()];
        String[] artwork = new String[resultsArray.length()];
        String[] viewUrl = new String[resultsArray.length()];

        for (int i = 0; i < resultsArray.length(); i++) {
            objArr[i] = resultsArray.getJSONObject(i);
            name[i] = objArr[i].getString("artistName");
            album[i] = objArr[i].getString("collectionName");
            artwork[i] = objArr[i].getString("artworkUrl100");
            viewUrl[i] = objArr[i].getString("collectionViewUrl");
        }

        for (int i = 0; i < resultsArray.length(); i++) {
            System.out.println();
            System.out.println(name[i]);
            System.out.println(album[i]);
            System.out.println(artwork[i]);
            System.out.println(viewUrl[i]);
            System.out.println();
        }

    }
}
