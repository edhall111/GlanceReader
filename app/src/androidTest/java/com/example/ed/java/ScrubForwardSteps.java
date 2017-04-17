package com.example.ed.java;
import org.jbehave.*;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class ScrubForwardSteps(){
    //set up spritzer and textview
    SpritzerTextView text = new SpritzerTextView(context);
    Spritzer reader = new Spritzer(text);

    @Given("The user has loaded in an article/text file/link/ebook/etc. to read from using the Glance reader")
    public void loadURL(String url){
        reader.setText(url);
    }

    @When("the user slides bar forward")
    public double slideBarForward(){
        return reader.getBarPercentage();
    }

    @Then("the user should move to that position in document")
    public void moveTextPosition(double percentage){
        index = words.length() * percentage;
        if(percentage!= 0.0 || percentage!=100.0){
            reader.setCurrentWord(index);
        }
    }
}