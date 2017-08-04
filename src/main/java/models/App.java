package models;

public class App {

  public static void main(String[] args) {
    EventMenu newEventMenu = new EventMenu();
    String [] foods = newEventMenu.getFoodOptions();
    System.out.println(foods[0]);
  }
}
