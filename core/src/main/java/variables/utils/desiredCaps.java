package variables.utils;

public class desiredCaps {

    /* https://appium.io/docs/en/writing-running-appium/caps/ */

    /* Automation Platform used */
    public static String automationName =   "UIAutomator2" ;
    
    /* Operation System */
    public static String platformName = "Android" ;
    public static String platformVersion =   "12" ;

    /* The absolute local path or remote http URL */
    public static String app =  "C:\\application location\\app-debug.apk" ;

    /* Device / emulator Name  */
    public static String deviceName = "pixel4-api" ;

    /* Emulator Name in adb -list */
    public static String udid =   "emulator-5554" ;

    /* Set Orientation */
    public static String orientation = "PORTRAIT" ;

    /* Enable or disable the reporting of the timings */
    public static boolean  eventTimings = true ;

    /* This is to hide the on Screen Keyboard */
    public static boolean  unicodeKeyboard = true ;
    public static boolean resetKeyboard = true ;

    /* Settings for android */
    public static String appPackage =   "";
    public static String appActivity =  "";
    public static int newCommandTimeout =   60;
    public static String browserName ="";
    public static boolean isHeadless =false ;

}
