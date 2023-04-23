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

                    if ("North Korea".equals(country) && score > initscore) {
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
using System;
using System.Net.Http;
using System.Threading.Tasks;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;

class AllUniversities {
    static async Task Main() {
        int pageNumber = 1;
        string url = "https://jsonmock.hackerrank.com/api/universities?page=" + pageNumber;

        using (HttpClient client = new HttpClient()) {
            HttpResponseMessage response = await client.GetAsync(url);
            if (response.IsSuccessStatusCode) {
                string responseBody = await response.Content.ReadAsStringAsync();
                JObject jsonObject = JObject.Parse(responseBody);
                int totalPages = (int)jsonObject["total_pages"];

                Console.WriteLine("Total number of pages: " + totalPages);
                Console.WriteLine("List of universities on page " + pageNumber + ":");

                JArray dataArray = (JArray)jsonObject["data"];
                foreach (JObject university in dataArray) {
                    string name = (string)university["name"];
                    string country = (string)university["country"];
                    Console.WriteLine(name + " (" + country + ")");
                }
            } else {
                Console.WriteLine("Error: HTTP response code " + response.StatusCode);
            }
        }
    }
}

*/