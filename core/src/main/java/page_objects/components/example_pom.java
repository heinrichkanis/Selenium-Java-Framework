package page_objects.components;

import org.openqa.selenium.By;

import support.commands;
import support.waitHelper;

public class example_pom {
	
    public static void populateForm(By signInElement , By emailElement , String emailValue , By passwordElement , String passwordValue , By signInButtonElement) {

        /* Wait for Web Page */
        waitHelper.elementWait(signInElement);

        /* Enter Email */
        commands.enterFieldValue(emailElement , emailValue );
        
        /* Enter Password */
        commands.enterFieldValue(passwordElement, passwordValue);

        /* Click Sing In */
		commands.clickElement(signInButtonElement);
        
    }

}
