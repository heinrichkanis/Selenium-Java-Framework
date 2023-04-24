package support;

import  java.sql.Connection;		
import  java.sql.Statement;
import org.openqa.selenium.By;

import  java.sql.ResultSet;		
import  java.sql.DriverManager;
import  java.sql.SQLException;	

public class databaseHelper {

    public static void retrieveDBData  (String dbUrl,String username,String password, String query, By element) throws SQLException, ClassNotFoundException
        {           
            String  Value;

                //Load mysql jdbc driver		
                Class.forName("com.mysql.cj.jdbc.Driver");	

                //Create Connection to DB		
                Connection con = DriverManager.getConnection(dbUrl,username,password);

                //Create Statement Object		
                Statement stmt = con.createStatement();
        
                // Execute the SQL Query. Store results in ResultSet		
                ResultSet rs= stmt.executeQuery(query);
                // store all the rows data into one variable
                              
                while (rs.next()){
                    Value = rs.getString(1);								        
                    System. out.println(Value);		             
         		                 
                    waitHelper.waitForElement(element);
                    driverHelper.driver.findElement(element).click();
                    System.out.println(commands.ConsoleColors.PURPLE_BRIGHT + element + " Field Clicked" + commands.ConsoleColors.RESET);
                    driverHelper.driver.findElement(element).sendKeys(Value);
                    System.out.println(commands.ConsoleColors.GREEN_BOLD + Value + " Entered" + commands.ConsoleColors.RESET);

                }               
    
        }


        public static void closeConnection (String dbUrl, String username,String password ) throws SQLException
        {
        Connection con = DriverManager.getConnection(dbUrl,username,password);
        // closing DB Connection		
        con.close();

        };
    
}
