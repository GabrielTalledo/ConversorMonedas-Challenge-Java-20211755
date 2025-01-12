package Herramientas;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ApiTool {

    public static String obtenerJson(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public static Double obtenerConversionRate(String url,String codigoMoneda) throws IOException, InterruptedException {
        String json = obtenerJson(url);
        Gson gson = new Gson();
        Map map = gson.fromJson(json, Map.class);
        return (Double) ((Map) map.get("conversion_rates")).get(codigoMoneda);
    }


}
