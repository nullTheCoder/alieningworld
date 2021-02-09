package aw.generation;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class Generator {

    public static int[] rN;

    public static void startGen() {

        int numsToGenerate = 10;

        try {
            URLConnection connection = new URL("https://qrng.anu.edu.au/API/jsonI.php?length=" + numsToGenerate + "&type=uint8").openConnection();
            connection.connect();
            JsonParser jp = new JsonParser(); //from gson
            JsonElement root = jp.parse(new InputStreamReader((InputStream) connection.getContent())); //Convert the input stream to a json element
            JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.
            rN = new Gson().fromJson(rootobj.get("data"), int[].class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(rN[0]);

    }
}
