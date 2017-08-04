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
    return 0;
  }
  public String getFoodChoice () {
    return "";
  }
  public String getBeverageChoice () {
    return "";
  }
  public String getEntertainmentChoice () {
    return "";
  }


}
