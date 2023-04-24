package support;

import org.openqa.selenium.By;

public class commands extends driverHelper {
  

  public static void clickElement(By element) {

    driver.findElement(element).click();
  }


  public static void enterFieldValue(By element, String fieldValue) {
    /* enters the value into a field */

    waitHelper.elementWait(element);
    driver.findElement(element).click();
    driver.findElement(element).sendKeys(fieldValue);

  }

  
  public static void clickDropDownValue(By element, String fieldValue) {
    /* click a value in a dropdown */
    waitHelper.waitForElement(element);
    driver.findElement(element).click();
    System.out.println(ConsoleColors.PURPLE_BRIGHT + element + " Field Clicked" + ConsoleColors.RESET);
    driver.findElement(By.xpath(fieldValue)).click();
    System.out.println(ConsoleColors.PURPLE_BRIGHT + fieldValue + " Dropdown value Clicked" + ConsoleColors.RESET);
  }


  /* Console Message Colors */
  public class ConsoleColors {
    /* Reset */
    public static final String RESET = "\033[0m"; // Text Reset
    /* Bold */
    public static final String BLACK_BOLD = "\033[1;30m"; // BLACK
    public static final String RED_BOLD = "\033[1;31m"; // RED
    public static final String GREEN_BOLD = "\033[1;32m"; // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m"; // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m"; // CYAN
    public static final String WHITE_BOLD = "\033[1;37m"; // WHITE

    /* High Intensity */
    public static final String BLACK_BRIGHT = "\033[0;90m"; // BLACK
    public static final String RED_BRIGHT = "\033[0;91m"; // RED
    public static final String GREEN_BRIGHT = "\033[0;92m"; // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m"; // BLUE
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = "\033[0;96m"; // CYAN
    public static final String WHITE_BRIGHT = "\033[0;97m"; // WHITE

  }

}
