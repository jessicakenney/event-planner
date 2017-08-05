package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class App {

  public static void main(String[] args) {
    EventMenu newEventMenu = new EventMenu();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("\nLet's Plan a Party!");
    boolean partyPlanning = true;
    while (partyPlanning) {
      System.out.println("\n==========Event Planner Cost Estimator==========");
      System.out.println("Please enter number of people for your event : ");
      try {
        Integer inputNumPeople = Integer.parseInt(bufferedReader.readLine());
        System.out.println("\nEnter your food selection for the event : ");
        for (String item : newEventMenu.getFoodOptions()) {
          String optionString = String.format("   * %s", item);
          System.out.println(optionString);
        }
        String inputFoodChoice = bufferedReader.readLine();
        boolean validInput = Arrays.asList(newEventMenu.getFoodOptions()).contains(inputFoodChoice);
        while (!validInput) {
          System.out.println("\nInvalid Choice. Try again.");
          inputFoodChoice = bufferedReader.readLine();
          validInput = Arrays.asList(newEventMenu.getFoodOptions()).contains(inputFoodChoice);
        }
        System.out.println("\nEnter your beverage selection(s) for the event [option1,option2]: ");
        for (String item : newEventMenu.getBeverageOptions()) {
          System.out.println(String.format("   * %s", item));
        }
        String inputBeverageChoicesString = bufferedReader.readLine();
        String [] inputBeverageChoicesSplit = inputBeverageChoicesString.split(",");
        boolean valid;
        for (String bev: inputBeverageChoicesSplit) {
          valid = Arrays.asList(newEventMenu.getBeverageOptions()).contains(bev);
          validInput = valid && validInput;
        }
        while (!validInput) {
          System.out.println("\nInvalid Choice. Try again.");
          inputBeverageChoicesString = bufferedReader.readLine();
          inputBeverageChoicesSplit = inputBeverageChoicesString.split(",");
          validInput = true;
          for (String bev: inputBeverageChoicesSplit) {
            valid = Arrays.asList(newEventMenu.getBeverageOptions()).contains(bev);
            validInput = valid && validInput;
          }
        }
        System.out.println("\nEnter your entertainment selection for the event : ");
        for (String item : newEventMenu.getEntertainmentOptions()) {
          String optionString = String.format("   * %s", item);
          System.out.println(optionString);
        }
        String inputEntertainmentChoice = bufferedReader.readLine();
        validInput = Arrays.asList(newEventMenu.getEntertainmentOptions()).contains(inputEntertainmentChoice);
        while (!validInput) {
          System.out.println("\nInvalid Choice. Try again.");
          inputEntertainmentChoice = bufferedReader.readLine();
          validInput = Arrays.asList(newEventMenu.getEntertainmentOptions()).contains(inputEntertainmentChoice);
        }
        Event newEvent = new Event(inputNumPeople, inputFoodChoice, inputBeverageChoicesSplit, inputEntertainmentChoice);
        System.out.println("\n==========Event Summary==========");
        System.out.println(String.format("Number of People\t\t:%d people", inputNumPeople));
        System.out.println(String.format("Food Choice\t\t\t\t:%s", inputFoodChoice));
        System.out.println(String.format("Beverage Choices\t\t:%s", inputBeverageChoicesString));
        System.out.println(String.format("Entertainment Choice\t:%s", inputEntertainmentChoice));
        System.out.println("=================================");
        System.out.println(String.format("CostPerPerson\t\t\t:$%.2f", newEvent.getCostPerPerson()));
        System.out.println(String.format("Entertainment\t\t\t:$%.2f", newEventMenu.getCostSheet().get(inputEntertainmentChoice)));
        System.out.println(".................................");
        System.out.println(String.format("SubTotal\t\t\t\t:$%.2f", newEvent.getTotalCost()));
        System.out.println("=================================");
        System.out.println("\nEnter valid couponCode[20percentOff,freeDJ,na]:");
        String couponCode = bufferedReader.readLine();
        System.out.println("\n=================================");
        System.out.println(String.format("Total with discount\t\t:$%.2f", newEvent.applyCouponCode(couponCode)));
        System.out.println("=================================");
        System.out.println("Would you like to try again [y/n]?");
        partyPlanning = bufferedReader.readLine().equalsIgnoreCase("y");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    System.out.println("Thank You, Goodbye.");



  }
}
