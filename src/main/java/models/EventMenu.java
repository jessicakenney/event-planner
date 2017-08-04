package models;

import java.util.HashMap;
import java.util.Map;

public class EventMenu {
  private String[] foodOptions  = {"apps","brunch","dessert-only","dinner:buffet","dinner:sit-down"}; ;
  private String[] beverageOptions = {"nonalcoholic","wine","beer","cocktails"};
  private String[] entertainmentOptions = {"none","DJ","live-band","harpist","magician"};
  private Map<String, Double> costSheet = new HashMap();

  public String[] getFoodOptions (){
    return foodOptions;
  }
  public String[] getBeverageOptions (){
    return beverageOptions;
  }
  public String[] getEntertainmentOptions (){
    return entertainmentOptions;
  }
  public Map<String,Double> getCostSheet () {
    costSheet.put("apps", 3.00);
    costSheet.put("brunch", 10.00);
    costSheet.put("dessert-only", 8.00);
    costSheet.put("dinner:buffet", 15.00);
    costSheet.put("dinner:sit-down", 25.00);
    costSheet.put("nonalcoholic", 5.00);
    costSheet.put("wine", 10.00);
    costSheet.put("beer", 8.00);
    costSheet.put("cocktails", 15.00);
    costSheet.put("NA", 0.00);
    costSheet.put("none", 0.00);
    costSheet.put("DJ", 300.00);
    costSheet.put("live-band", 500.00);
    costSheet.put("harpist", 275.00);
    costSheet.put("magician", 250.00);
    return costSheet;
  }

}
