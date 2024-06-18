import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Test {
    public static void main(String[] args) {
        System.setProperty("htttp.agent", "Chrome");
        try {
            URL url = new URL("https://coderbyte.com/api/challenges/json/age-counting");
            try {
                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder response = new StringBuilder();
                String thisLine;
                while ((thisLine = bufferedReader.readLine()) != null) {
                    response.append(thisLine);
                }
                String jsonString = response.toString();
                String[] keyValues = jsonString.split(",");
                long number = 0;
                for (String keyValue : keyValues) {
                    if (keyValue.contains("age")) {
                        String[] parts = keyValue.split("=");
                        String ageString = parts[1].replaceAll("[^0-9]", "");
                        int age = Integer.parseInt(ageString);
                        if (age >= 50) {
                            number++;
                        }
                    }
                }
                System.out.println(new StringBuilder(String.valueOf(number)).reverse() + ": d54grw35");
            } catch (IOException ioEx) {
                System.out.println(ioEx);
            }
        } catch (MalformedURLException malEx) {
            System.out.println(malEx);
        }

        //substituteCode();

    }


    public static void substituteCode() {

        URL url = null;
        try {
            url = new URL("https://coderbyte.com/api/challenges/json/age-counting");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        URLConnection urlConnection = null;
        try {
            urlConnection = url.openConnection();

            InputStream inputStream = urlConnection.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String thisLine = null;
            int count = 0;
            while ((thisLine = bufferedReader.readLine()) != null) {
                String[] text = thisLine.split(":");
                String parsedString = text[1].replaceAll("\"}", "").replace("\"", "");
                String[] ageEntries = parsedString.split(",");

                for (String entry : ageEntries) {
                    if (entry.contains("age")) {
                        String[] keyValue = entry.split("=");
                        if (keyValue.length == 2) {
                            int age = Integer.parseInt(keyValue[1]);
                            if (age >= 50) {
                                count++;
                            }
                        }
                    }
                }
                System.out.println(count);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
