package models;

import java.util.HashMap;
import java.util.Map;

public class Event {
  //private Map<String, Double> costSheet = new HashMap();
  private Integer numPeople;
  private String foodChoice;
  private String beverageChoice;
  private String entertainmentChoice;
  private EventMenu theEventMenu = new EventMenu();


  public Event( Integer numPeople, String foodChoice, String beverageChoice, String entertainmentChoice){
    this.numPeople = numPeople;
    this.foodChoice = foodChoice;
    this.beverageChoice = beverageChoice;
    this.entertainmentChoice = entertainmentChoice;
  }
//  public Map<String,Double> getCostSheet () {
//    costSheet.put("apps", 3.00);
//    costSheet.put("brunch", 10.00);
//    costSheet.put("dessert-only", 8.00);
//    costSheet.put("dinner:buffet", 15.00);
//    costSheet.put("dinner:sit-down", 25.00);
//    costSheet.put("nonalcoholic", 5.00);
//    costSheet.put("wine", 10.00);
//    costSheet.put("beer", 8.00);
//    costSheet.put("cocktails", 15.00);
//    costSheet.put("NA", 0.00);
//    costSheet.put("none", 0.00);
//    costSheet.put("DJ", 300.00);
//    costSheet.put("live-band", 500.00);
//    costSheet.put("harpist", 275.00);
//    costSheet.put("magician", 250.00);
//    return costSheet;
//  }

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
    Double baseCostpp;
    //Determine base cost on food and beverage options
    baseCostpp = 5.00;
    baseCostpp += theEventMenu.getCostSheet().get(foodChoice);
    baseCostpp += theEventMenu.getCostSheet().get(beverageChoice);

    return baseCostpp;
  }
  public Double getTotalCost (){
    Double subTotal;
    subTotal =  getCostPerPerson() * getNumPeople() + theEventMenu.getCostSheet().get(entertainmentChoice) ;
   return  subTotal;
  }
  public Double applyCouponCode(String couponCode) {
   double total = getTotalCost();
   double discountedTotal;
   if (couponCode.equals( "20percentOff")) {
     discountedTotal =  total - (total * .20);
   } else if (couponCode.equals("freeDJ") && getEntertainmentChoice().equals("DJ")) {
     discountedTotal = total - 300.00;
   } else if (couponCode.equals("NA")) {
     discountedTotal = total;
   } else {
     discountedTotal = total;
   }
   return discountedTotal;
  }

}
