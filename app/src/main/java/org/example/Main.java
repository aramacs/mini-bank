package org.example;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import java.util.Scanner;

/**
 * Main
 */
public class Main {

  public static void main(String[] args) {

    HashMap<Integer, String> coinCodes = new HashMap<Integer, String>();

    // Add some coins to get the format required from the API
    coinCodes.put(1, "USD");
    coinCodes.put(2, "BRA");
    coinCodes.put(3, "EUR");
    coinCodes.put(4, "HKD");
    coinCodes.put(5, "EGP");
    coinCodes.put(6, "CNY");

    String keyFrom, keyTo;
    double qtde;

    Scanner scan = new Scanner(System.in);

    System.out.println("Bem vindo ao Conversor de Moedas");

    // Input of coin
    System.out.println("De qual moeda você gostaria de converter");

    System.out.println(
        "1:USD (Dólar Americano)\t 2:BRA (Real)\t 3:EUR (Euro)\t 4:HKD (Hong Kong Dólar)\t 5:EGP (Libra Egípcia)\t 6:CNY (Yuan)");
    // get the value from the user as integer
    keyFrom = coinCodes.get(scan.nextInt());

    // Output of conversion
    System.out.println("De qual moeda você gostaria de converter");

    System.out.println(
        "1:USD (Dólar Americano)\t 2:BRA (Real)\t 3:EUR (Euro)\t 4:HKD (Hong Kong Dólar)\t 5:EGP (Libra Egípcia)\t 6:CNY (Yuan)");
    // get the value from the user as integer
    keyFrom = coinCodes.get(scan.nextInt());

    // Get the amount of money to convert
    System.out.println("Quanto você gostaria de converter");
    qtde = scan.nextFloat();
  }

  private static void sendHttpGetRequest(String keyFrom, String keyTo, double qtde) throws IOException {

    String GET_URL = "https://api.exchangeratesapi.io/latest?base" + keyTo + "&symbols="
        + keyFrom;
    URL url = new URL(GET_URL);
    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
    int httpCodeResponse = httpURLConnection.getResponseCode();

    if (httpCodeResponse == HttpURLConnection.HTTP_OK) {
      BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
      String inputLine;
      StringBuffer response = new StringBuffer();

      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();

      JSONObject obj = new JSONObject(response.toString());
      Double exchange = obj.getJSONObject("rates").getDouble(keyFrom);
      System.out.println("rates");
      System.out.println("exchange");
      System.out.println(qtde + keyFrom + " = " + qtde / exchange + keyTo);
    } else {
      System.out.println("Get request failed");
    }
  }
}
