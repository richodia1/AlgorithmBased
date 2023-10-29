package Leo;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AlgorithmLearning {
    public static void main(String[] args){
        WriteStringToMap();
        //call();
    }
    public static void WriteListToMap(String[] args){
        List<String> items = Arrays.asList("Apple", "Banana", "Orange", "Grapes", "Cherry", "Apple", "Banana", "Cherry");

        // Convert the list into a map with item as the key and count as the value
        Map<String, Long> itemOccurrenceMap = items.stream()
                .collect(Collectors.groupingBy(
                        item -> item, // Key is the item itself
                        Collectors.counting() // Value is the count of occurrences
                ));

        // Print the resulting map
        itemOccurrenceMap.forEach((item, count) -> System.out.println(item + ": " + count));
    }
    public static void WriteStringToMap() {
        String inputString = "richard";

        // Create a character count map using Java Stream
        Map<Character, Long> charCountMap = inputString.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        // Find the character with the most occurrences
        char mostFrequentChar = charCountMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        //

char mf = charCountMap.entrySet().stream()
        .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                        .orElse(null);

        // Print the most frequent character and its count
        System.out.println("Most frequent character: " + mostFrequentChar);
        System.out.println("Most frequent character: " + mf);
        //System.out.println("Count: " + charCountMap.get(mostFrequentChar));
    }



        public static void call() {
            // Create an HttpClient instance
            HttpClient httpClient = HttpClient.newHttpClient();

            // Define the URL for the API
            String apiUrl = "https://jsonmock.hackerrank.com/api/articles?author=epaga&page=1";

            // Create an HttpRequest for a GET request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .build();

            try {
                // Send the GET request and handle the response
                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

                // Check the HTTP response status code
                int statusCode = response.statusCode();
                if (statusCode == 200) {
                    // Successful response
                    String responseBody = response.body();
                    System.out.println("Response Body:\n" + responseBody);
                } else {
                    // Handle error status codes
                    System.err.println("HTTP Request Failed with Status Code: " + statusCode);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


