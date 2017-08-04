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
  public void getCostPerPerson_returnsBaseCostPP_Double(){
    Event testEvent = new Event (1,"NA","NA","none");
    Double baseCost = 5.00;
    Double expected = baseCost * testEvent.getNumPeople();
    assertEquals(expected, testEvent.getCostPerPerson());
  }
  @Test
  public void getCostPerPerson_returnsCostPPWithFood_Double(){
    Event testEvent = new Event (1,"apps","NA","none");
    Double baseCost = 5.00 + 3.00;
    Double expected = baseCost * testEvent.getNumPeople();
    assertEquals(expected, testEvent.getCostPerPerson());
  }
  @Test
  public void getCostPerPerson_returnsCostPPWithFoodAndBev_Double(){
    Event testEvent = new Event (1,"apps","wine","none");
    Double baseCost = 5.00 + 3.00 + 5.00;
    Double expected = baseCost * testEvent.getNumPeople();
    assertEquals(expected, testEvent.getCostPerPerson());
  }

}