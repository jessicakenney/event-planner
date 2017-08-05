package models;

public class Event {
  private Integer numPeople;
  private String foodChoice;
  private String[] beverageChoices;
  private String entertainmentChoice;
  private EventMenu theEventMenu = new EventMenu();

  public Event( Integer numPeople, String foodChoice, String[] beverageChoices, String entertainmentChoice){
    this.numPeople = numPeople;
    this.foodChoice = foodChoice;
    this.beverageChoices = beverageChoices;
    this.entertainmentChoice = entertainmentChoice;
  }

  public Integer getNumPeople () {
    return numPeople;
  }
  public String getFoodChoice () {
    return foodChoice;
  }
  public String[] getBeverageChoices () {
    return beverageChoices;
  }
  public String getEntertainmentChoice () {
    return entertainmentChoice;
  }

  public Double getCostPerPerson (){
    Double baseCostpp;
    baseCostpp = 5.00;
    baseCostpp += theEventMenu.getCostSheet().get(foodChoice);
    for ( String beverage : beverageChoices) {
      baseCostpp += theEventMenu.getCostSheet().get(beverage);
    }
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
