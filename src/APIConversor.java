import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class APIConversor {
    private static final String URL_BASE = "https://api.exchangerate-api.com/v4/latest/";

    public static double obtenerTasaConversion(String monedaOrigen, String monedaDestino) {
        try {
            URL url = new URL(URL_BASE + monedaOrigen);
            URLConnection connection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();

            String jsonData = response.toString();
            String ratesString = jsonData.split("\"rates\":\\{")[1];
            ratesString = ratesString.substring(0, ratesString.indexOf('}'));
            String[] rates = ratesString.split(",");
            double tasaConversion = -1;
            for (String rate : rates) {
                if (rate.contains(monedaDestino)) {
                    tasaConversion = Double.parseDouble(rate.split(":")[1]);
                    break;
                }
            }
            return tasaConversion;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}