package models;

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
    double baseCost;
    baseCost = 5.00;
    return baseCost * getNumPeople();
  }
  public Double getTotalCost (){
    double total;
    total = 0.00;
   return  total;
  }


}
