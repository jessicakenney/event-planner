package models;

import java.util.HashMap;
import java.util.Map;

public class Event {
  private Integer numPeople;
  private String foodChoice;
  private String beverageChoice;
  private String entertainmentChoice;

  public Event( Integer numPeople, String foodChoice, String beverageChoice, String entertainmentChoice){
    this.numPeople = numPeople;
    this.foodChoice = foodChoice;
    this.beverageChoice = beverageChoice;
    this.entertainmentChoice = entertainmentChoice;
  }

  public Integer getNumPeople () {
    return numPeople;
  }
  public String getFoodChoice () {
    return foodChoice;
  }
  public String getBeverageChoice () {
    return beverageChoice;
  }
  public String getEntertainmentChoice () {
    return entertainmentChoice;
  }
  public Double getCostPerPerson (){
    double baseCostpp;
    //foodOptions {"apps","brunch","dessert-only","dinner:buffet","dinner:sit-down"};
    //Determine base cost on food and beverage options
    baseCostpp = 5.00;
    Map<String, Double> costSheet = new HashMap();
    costSheet.put("apps", 0.00);
    costSheet.put("brunch", 5.00);
    costSheet.put("NA", 0.00);
    baseCostpp += costSheet.get(foodChoice);

    return baseCostpp * getNumPeople();
  }
  public Double getTotalCost (){
    double total;
    total = 0.00;
   return  total;
  }


}
