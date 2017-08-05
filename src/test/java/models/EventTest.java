package models;

import org.junit.Test;
import static org.junit.Assert.*;


public class EventTest {
  @Test
  public void newEvent_instantiatesCorrectly() throws Exception {
    String[] bevs = {"nonalcoholic"};
    Event testEvent = new Event(50, "apps", bevs, "none");
    assertEquals(true, testEvent instanceof Event);
  }
  @Test
  public void newEventMenu_instantiatesCorrectly() throws Exception {
    EventMenu testEventMenu = new EventMenu();
    assertEquals(true, testEventMenu instanceof EventMenu);
  }
  @Test
  public void newEventMenu_getsFoodOptions_String() throws Exception {
    EventMenu testEventMenu = new EventMenu();
    String actual[] = testEventMenu.getFoodOptions();
    assertEquals("dinner:buffet", actual[3]);
  }
  @Test
  public void newTest_getsNumPeople_Integer() throws Exception{
    String[] bevs = {"nonalcoholic"};
    Event testEvent = new Event(50, "apps", bevs, "none");
    Integer expected = 50;
    assertEquals(expected, testEvent.getNumPeople());
  }
  @Test
  public void newTest_getsFoodChoice_String() throws Exception{
    String[] bevs = {"nonalcoholic"};
    Event testEvent = new Event(50, "apps", bevs, "none");
    String expected = "apps";
    assertEquals(expected, testEvent.getFoodChoice());
  }
  @Test
  public void newTest_getsBeverageChoice_String() throws Exception{
    String[] bevs = {"nonalcoholic"};
    Event testEvent = new Event(50, "apps", bevs, "none");
    String expected = "nonalcoholic";
    String[] actuals = testEvent.getBeverageChoices();
    assertEquals(expected, actuals[0]);
  }
  @Test
  public void newTest_getsEntertainmentChoice_String() throws Exception{
    String[] bevs = {"nonalcoholic"};
    Event testEvent = new Event(50, "apps",bevs, "none");
    String expected = "none";
    assertEquals(expected, testEvent.getEntertainmentChoice());
  }
  @Test
  public void newTest_getsFoodOptions_Array() throws Exception{
    String[] bevs = {"nonalcoholic"};
    Event testEvent = new Event(50, "apps", bevs, "none");
    String expected = "none";
    assertEquals(expected, testEvent.getEntertainmentChoice());
  }
  @Test
  public void newTest_getsCostSheet() throws Exception{
    String[] bevs = {"cocktails"};
    Event testEvent = new Event(50, "dessert-only", bevs, "none");
    EventMenu testEventMenu = new EventMenu();
    Double expectedfood = 8.00;
    Double expectedbev = 15.00;
    String [] actuals = testEvent.getBeverageChoices();
    assertEquals(expectedfood, testEventMenu.getCostSheet().get(testEvent.getFoodChoice()));
    assertEquals(expectedbev,testEventMenu.getCostSheet().get(actuals[0]));
  }
  @Test
  public void getCostPerPerson_returnsBaseCostPP_Double(){
    String[] bevs = {"NA"};
    Event testEvent = new Event (1,"NA",bevs,"none");
    Double baseCost = 5.00;
    Double expected = baseCost * testEvent.getNumPeople();
    assertEquals(expected, testEvent.getCostPerPerson());
  }
  @Test
  public void getCostPerPerson_returnsCostPPWithFood_Double(){
    String[] bevs = {"NA"};
    Event testEvent = new Event (1,"apps",bevs,"none");
    Double expected = 5.00 + 3.00;
    assertEquals(expected, testEvent.getCostPerPerson());
  }
  @Test
  public void getCostPerPerson_returnsCostPPWithFoodAndBev_Double(){
    String[] bevs = {"wine"};
    Event testEvent = new Event (1,"apps",bevs,"none");
    Double expected = 5.00 + 3.00 + 10.00;
    assertEquals(expected, testEvent.getCostPerPerson());
  }
  @Test
  public void getCostPerPerson_returnsCostPPWithFoodAndTwoBevs_Double(){
    String[] bevs = {"wine","beer"};
    Event testEvent = new Event (1,"apps",bevs,"none");
    Double expected = 5.00 + 3.00 + 10.00 + 8.00;
    assertEquals(expected, testEvent.getCostPerPerson());
  }
  @Test
  public void getTotalCost_returnsCostPPPlusEntertainmentOption_Double(){
    String[] bevs = {"wine"};
    Event testEvent = new Event ( 50,"apps",bevs ,"DJ");
    double sub = 5.00 + 3.00 + 10.00 ;
    Double expected = sub * testEvent.getNumPeople() + 300.00;
    assertEquals(expected, testEvent.getTotalCost());
  }
  @Test
  public void getTotalCost_returnsNewCostWithCoupon_Double(){
    String[] bevs = {"wine"};
    Event testEvent = new Event ( 50,"apps",bevs ,"DJ");
    Double sub = 5.00 + 3.00 + 10.00 ;
    Double total = sub * testEvent.getNumPeople() + 300.00;
    Double discount = total * .20;
    Double expected = total - discount;
    assertEquals(expected, testEvent.applyCouponCode("20percentOff"));
  }
  @Test
  public void getTotalCost_freeDJCoupon_Double(){
    String[] bevs = {"wine"};
    Event testEvent = new Event ( 50,"apps",bevs ,"DJ");
    Double sub = 5.00 + 3.00 + 10.00 ;
    Double total = sub * testEvent.getNumPeople();
    Double expected = total;
    assertEquals(expected, testEvent.applyCouponCode("freeDJ"));
  }
  @Test
  public void getTotalCost_freeDJCouponWithNoDJChoice_Double(){
    String[] bevs = {"wine"};
    Event testEvent = new Event ( 50,"apps",bevs ,"harpist");
    Double sub = 5.00 + 3.00 + 10.00;
    Double total = sub * testEvent.getNumPeople() + 275.00;
    Double expected = total;
    assertEquals(expected, testEvent.applyCouponCode("freeDJ"));
  }
}