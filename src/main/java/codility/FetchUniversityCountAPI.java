package codility;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchUniversityCountAPI {

    public static void main(String[] args) {
        String endpoint = "https://jsonmock.hackerrank.com/api/universities";
        int page = 1;
        int totalPages = Integer.MAX_VALUE;
        System.out.println(" initial Total page :"+ totalPages);
        int count = 0;
        int initscore = 0;
        String universityToReturn = "";

        while (page <= totalPages) {
            try {
                URL url = new URL(endpoint + "?page=" + page);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");

                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

                String output;
                StringBuilder sb = new StringBuilder();
                while ((output = br.readLine()) != null) {
                    sb.append(output);
                }

                JSONObject jsonObj = new JSONObject(sb.toString());
                totalPages = jsonObj.getInt("total_pages");

                JSONArray data = jsonObj.getJSONArray("data");

                for (int i = 0; i < data.length(); i++) {
                    JSONObject uni = data.getJSONObject(i);

                    String university = uni.getString("university");
                    int score = uni.getInt("score");
                    JSONObject inner = uni.getJSONObject("location");
                    String country = inner.getString("country");

                    if ("United Kingdom".equals(country) && score > initscore) {
                        universityToReturn = university;
                        initscore = score;
                        count++;
                    }

                }

                conn.disconnect();
                page++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("University name is :"+ universityToReturn +"  score was :"+ initscore);


    }

}

/*
public static void main(String[] args) throws IOException, InterruptedException {
        String url = "https://jsonmock.hackerrank.com/api/universities";

        // Create an HttpClient and a HttpRequest
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        // Send the HttpRequest and get the HttpResponse as a string
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        // Convert the JSON string into a JSONObject
        JSONObject jsonObj = new JSONObject(json);

        // Get the total number of pages
        int totalPages = jsonObj.getInt("total_pages");

        // Loop through all pages and print out the names of the universities
        for (int page = 1; page <= totalPages; page++) {
            String pageUrl = url + "?page=" + page;
            HttpRequest pageRequest = HttpRequest.newBuilder()
                    .uri(URI.create(pageUrl))
                    .build();
            HttpResponse<String> pageResponse = client.send(pageRequest, HttpResponse.BodyHandlers.ofString());
            JSONObject pageJsonObj = new JSONObject(pageResponse.body());
            JSONArray data = pageJsonObj.getJSONArray("data");
            Stream<Object> stream = data.toList().stream().map(JSONObject.class::cast).map(jsonObject -> jsonObject.getString("name"));
            stream.forEach(System.out::println);
        }
    }
 */


