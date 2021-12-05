package opsgenie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetTopFoodRestaurants {

    public static void main(String[] args) throws IOException {

        int totalPages = getTotalPages();

        for(int i=0; i < totalPages; i++) {
            getData(i);
        }
    }

    public static int getTotalPages() throws IOException {
        int totalPages = 0;
        URL url = new URL("https://jsonmock.hackerrank.com/api/food_outlets?city=Denver&page=1");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        System.out.println(con.getResponseCode());
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        String response = content.toString();
        String [] arr = response.split("total_pages\":");
        if(arr.length > 1) {
            String responseStr = arr[1];
            totalPages  = Integer.parseInt(responseStr.substring(0, responseStr.indexOf(',')));
        }
        return totalPages;
    }


    public static void getData(int pageNumber) throws IOException {
        URL url = new URL("https://jsonmock.hackerrank.com/api/food_outlets?city=Denver&page="+ pageNumber +"");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        System.out.println(con.getResponseCode());
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        String response = content.toString();

        String [] arr = response.split("average_rating\":");
        double maxRating = 0.0;
        if(arr.length > 1) {
            for (int k = 1; k < arr.length; k++) {
                String responseStr = arr[k];
                double rating;
                rating  = Double.parseDouble(responseStr.substring(0, responseStr.indexOf(',')));
                System.out.println(rating);
                if( rating > maxRating) {
                    maxRating = rating;
                }
            }
        }
        in.close();
    }

}