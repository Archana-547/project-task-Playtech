package org.example.junit5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.html.HTMLInputElement;

import java.io.FileWriter;
import java.io.IOException;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class MainTask {


    @Test
    public void locatingWebElements() {

        Selenide.open("https://www.playtech.ee"); // 1. Open a web browser at the URL https://www.playtech.ee;
        $x("//html/body/header/div/nav/a[1]").click(); // 2. Click on the “Who we are” tab.
        $x("/html/body/main/section[4]").should(Condition.exist, Condition.visible); // 3. Verified if the “Global presence” is shown on the page.
        Selenide.closeWebDriver();


    }

    //////----------------------Bonus Task------------------ ////////
    @Test
    public void LocatingWebElementWhoWeAreUsingCoordinates() { // 1. Use coordinates to click on the tab at main task step2
        Selenide.open("https://www.playtech.ee");
        Selenide.actions().moveByOffset(100, 200).click().perform();


    }

    @Test
    public void languageSelector () { //Switch the web page language from EN to ET. Repeat the main task.
        // Open the website
        Selenide.open("https://www.playtech.ee");
        $x("/html/body/header/div/div/div/div[1]").click();


    }
 @Test
 public void ExportGlobalPresenceTextToFile(){  //  2. Export main task step 3’s result as .txt file.
     Selenide.open("https://www.playtech.ee");
     $x("//html/body/header/div/nav/a[1]").click();
     String GlobalPresenceText = $x("/html/body/main/section[4]").getText();
     writeTextToFile(GlobalPresenceText);}

     private void writeTextToFile(String globalPresenceText){
         try (FileWriter writer = new FileWriter("global_presence.txt")) {

             // String Globalpresence = null;
             String globalPresenceDisplayed = null;
             writer.write(("Global presence is displayed: " + globalPresenceDisplayed));
         } catch (IOException e) {
             e.printStackTrace();
         }

    }


}
