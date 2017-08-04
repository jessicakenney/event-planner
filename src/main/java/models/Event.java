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
   Double total = getTotalCost();
   Double discountedTotal;
   if (couponCode.equals( "20percentOff")) {
     discountedTotal =  total - (total * .20);
   } else if (couponCode.equals("freeDJ") && getEntertainmentChoice().equals("DJ")) {
     discountedTotal = total - theEventMenu.getCostSheet().get("DJ");
   } else if (couponCode.equals("NA")) {
     discountedTotal = total;
   } else {
     discountedTotal = total;
   }
   return discountedTotal;
  }

}
