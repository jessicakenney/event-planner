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
    //beverageOptions = {"nonalcoholic","wine","beer","cocktails"};
    //Determine base cost on food and beverage options
    baseCostpp = 5.00;
    Map<String, Double> costSheet = new HashMap();
    costSheet.put("apps", 3.00);
    costSheet.put("brunch", 10.00);
    costSheet.put("dessert-only", 8.00);
    costSheet.put("dinner:buffet", 15.00);
    costSheet.put("dinner:sit-down", 25.00);
    costSheet.put("nonalcoholic", 5.00);
    costSheet.put("wine", 10.00);
    costSheet.put("beer", 8.00);
    costSheet.put("cocktails", 15.00);
    costSheet.put("NA", 0.00);
    baseCostpp += costSheet.get(foodChoice);
    baseCostpp += costSheet.get(beverageChoice);

    return baseCostpp * getNumPeople();
  }
  public Double getTotalCost (){
    double subTotal;
    //entertainmentOptions = {"none","DJ","live-band","harpist","magician"};
    Map<String, Double> EntertainmentCostSheet = new HashMap();
    EntertainmentCostSheet.put("none", 0.00);
    EntertainmentCostSheet.put("DJ", 0.00);
    EntertainmentCostSheet.put("live-band", 0.00);
    EntertainmentCostSheet.put("harpist", 0.00);
    EntertainmentCostSheet.put("magician", 0.00);
    subTotal = getCostPerPerson() * getNumPeople() + EntertainmentCostSheet.get(entertainmentChoice) ;
   return  subTotal;
  }


}
