package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class EventTest {

  @Test
  public void newEvent_instantiatesCorrectly() throws Exception {
    Event testEvent = new Event(50, "lightsnacks", "nonalcoholic", "none");
    assertEquals(true, testEvent instanceof Event);
  }
  @Test
  public void newTest_getsNumPeople_Integer() throws Exception{
    Event testEvent = new Event(50, "lightsnacks", "nonalcoholic", "none");
    Integer expected = 50;
    assertEquals(expected, testEvent.getNumPeople());
  }

}