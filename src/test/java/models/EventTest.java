package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class EventTest {

  @Test
  public void newEvent_instantiatesCorrectly() throws Exception {
    Event testEvent = new Event(50, "apps", "nonalcoholic", "none");
    assertEquals(true, testEvent instanceof Event);
  }
  @Test
  public void newTest_getsNumPeople_Integer() throws Exception{
    Event testEvent = new Event(50, "apps", "nonalcoholic", "none");
    Integer expected = 50;
    assertEquals(expected, testEvent.getNumPeople());
  }
  @Test
  public void newTest_getsFoodChoice_String() throws Exception{
    Event testEvent = new Event(50, "apps", "nonalcoholic", "none");
    String expected = "apps";
    assertEquals(expected, testEvent.getFoodChoice());
  }
  @Test
  public void newTest_getsBeverageChoice_String() throws Exception{
    Event testEvent = new Event(50, "apps", "nonalcoholic", "none");
    String expected = "nonalcoholic";
    assertEquals(expected, testEvent.getBeverageChoice());
  }
  @Test
  public void newTest_getsEntertainmentChoice_String() throws Exception{
    Event testEvent = new Event(50, "apps", "nonalcoholic", "none");
    String expected = "none";
    assertEquals(expected, testEvent.getEntertainmentChoice());
  }
  @Test
  public void newTest_getsFoodOptions_Array() throws Exception{
    Event testEvent = new Event(50, "apps", "nonalcoholic", "none");
    String expected = "none";
    assertEquals(expected, testEvent.getEntertainmentChoice());
  }
  @Test
  public void newTest_getsCostSheet() throws Exception{
    Event testEvent = new Event(50, "dessert-only", "cocktails", "none");
    EventMenu testEventMenu = new EventMenu();
    Double expectedfood = 8.00;
    Double expectedbev = 15.00;
    assertEquals(expectedfood, testEventMenu.getCostSheet().get(testEvent.getFoodChoice()));
    assertEquals(expectedbev, testEventMenu.getCostSheet().get(testEvent.getBeverageChoice()));
  }
  @Test
  public void getCostPerPerson_returnsBaseCostPP_Double(){
    Event testEvent = new Event (1,"NA","NA","none");
    Double baseCost = 5.00;
    Double expected = baseCost * testEvent.getNumPeople();
    assertEquals(expected, testEvent.getCostPerPerson());
  }
  @Test
  public void getCostPerPerson_returnsCostPPWithFood_Double(){
    Event testEvent = new Event (1,"apps","NA","none");
    Double expected = 5.00 + 3.00;
    assertEquals(expected, testEvent.getCostPerPerson());
  }
  @Test
  public void getCostPerPerson_returnsCostPPWithFoodAndBev_Double(){
    Event testEvent = new Event (1,"apps","wine","none");
    Double expected = 5.00 + 3.00 + 10.00;
    assertEquals(expected, testEvent.getCostPerPerson());
  }
  @Test
  public void getTotalCost_returnsCostPPPlusEntertainmentOption_Double(){
    Event testEvent = new Event ( 50,"apps","wine" ,"DJ");
    double sub = 5.00 + 3.00 + 10.00 ;
    Double expected = sub * testEvent.getNumPeople() + 300.00;
    assertEquals(expected, testEvent.getTotalCost());
  }
  @Test
  public void getTotalCost_returnsNewCostWithCoupon_Double(){
    Event testEvent = new Event ( 50,"apps","wine" ,"DJ");
    Double sub = 5.00 + 3.00 + 10.00 ;
    Double total = sub * testEvent.getNumPeople() + 300.00;
    Double discount = total * .20;
    Double expected = total - discount;
    assertEquals(expected, testEvent.applyCouponCode("20percentOff"));
  }
  @Test
  public void getTotalCost_freeDJCoupon_Double(){
    Event testEvent = new Event ( 50,"apps","wine" ,"DJ");
    Double sub = 5.00 + 3.00 + 10.00 ;
    Double total = sub * testEvent.getNumPeople();
    Double expected = total;
    assertEquals(expected, testEvent.applyCouponCode("freeDJ"));
  }
  @Test
  public void getTotalCost_freeDJCouponWithNoDJChoice_Double(){
    Event testEvent = new Event ( 50,"apps","wine" ,"harpist");
    Double sub = 5.00 + 3.00 + 10.00;
    Double total = sub * testEvent.getNumPeople() + 275.00;
    Double expected = total;
    assertEquals(expected, testEvent.applyCouponCode("freeDJ"));
  }
}