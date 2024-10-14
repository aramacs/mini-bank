package org.example;

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
}
