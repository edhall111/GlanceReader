package pro.dbro.glance.steps;

import android.support.test.rule.ActivityTestRule;

import java.net.URL;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import pro.dbro.glance.activities.MainActivity;
import pro.dbro.glance.activities.MainActivityRobot;


public class ShareTextSteps {
    private final MainActivityRobot mainActivityRobot = MainActivityRobot.create();

    @Given("^The selected text: (.*) is readable$")
    public void isSelectedTextReadable(String sharedText){
        mainActivityRobot.launchMainActivityScreen(new ActivityTestRule<>(MainActivity.class));
        //See if selected text is readable or not.
    }

    @When("^A selected text is shared to GlanceReader$")
    public void listenForTextShare(){
        //Have a listener check to see if a selected text is shared to GlanceReader
    }

    @Then("^The application will begin reading the selected text$")
    public void beginTextReader(){
        //Have GlanceReader begin reading through the selected text given.
    }
}
