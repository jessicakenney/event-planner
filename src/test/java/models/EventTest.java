package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class EventTest {

  @Test
  public void newEvent_instantiatesCorrectly() throws Exception {
    Event testEvent = new Event(50, "lightsnacks", "nonalcoholic", "none");
    assertEquals(true, testEvent instanceof Event);

  }
}