package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

  public static void main(String[] args) {
    EventMenu newEventMenu = new EventMenu();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("\n==========Event Planner Cost Estimator==========");
    System.out.println("\nPlease enter number of people for your event : ");
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
    } catch(IOException e) {
        e.printStackTrace();
    }



  }
}
