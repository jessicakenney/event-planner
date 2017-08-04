package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

  public static void main(String[] args) {
    EventMenu newEventMenu = new EventMenu();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("\n==========Event Planner Cost Estimator==========");
    System.out.println("Please enter number of people for your event : ");
    try {
      Integer inputNumPeople = Integer.parseInt(bufferedReader.readLine());
      System.out.println("\nEnter your food selection for the event : ");
      for (String item: newEventMenu.getFoodOptions()) {
        String optionString = String.format("   * %s",item);
        System.out.println(optionString);
      }
      String inputFoodChoice = bufferedReader.readLine();
      System.out.println("\nEnter your beverage selection for the event : ");
      for (String item: newEventMenu.getBeverageOptions()) {
        String optionString = String.format("   * %s",item);
        System.out.println(optionString);
      }
      String inputBeverageChoice = bufferedReader.readLine();
      System.out.println("\nEnter your entertainment selection for the event : ");
      for (String item: newEventMenu.getEntertainmentOptions()) {
        String optionString = String.format("   * %s",item);
        System.out.println(optionString);
      }
      String inputEntertainmentChoice = bufferedReader.readLine();
      Event newEvent = new Event(inputNumPeople,inputFoodChoice,inputBeverageChoice,inputEntertainmentChoice);
      System.out.println("\n==========Event Summary==========");
      System.out.println(String.format("Number of People\t\t:%d people",inputNumPeople));
      System.out.println(String.format("Food Choice\t\t\t\t:%s",inputFoodChoice));
      System.out.println(String.format("Beverage Choice\t\t\t:%s",inputBeverageChoice));
      System.out.println(String.format("Entertainment Choice\t:%s",inputEntertainmentChoice));
      System.out.println("=================================");
      System.out.println(String.format("SubTotal\t\t:$%.2f",newEvent.getTotalCost()));
      System.out.println("\nEnter valid couponCode[20percentOff,freeDJ]");
      String couponCode = bufferedReader.readLine();
      System.out.println("\n=================================");
      System.out.println(String.format("Total with discount\t:$%.2f",newEvent.applyCouponCode(couponCode)));
    } catch(IOException e) {
        e.printStackTrace();
    }



  }
}
