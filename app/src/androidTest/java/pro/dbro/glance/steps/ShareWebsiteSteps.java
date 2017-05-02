package pro.dbro.glance.steps;

import android.support.test.rule.ActivityTestRule;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import pro.dbro.glance.activities.MainActivity;
import pro.dbro.glance.activities.MainActivityRobot;
import java.net.URL;


public class ShareWebsiteSteps {
    private final MainActivityRobot mainActivityRobot = MainActivityRobot.create();

    @Given("^The webpage called (.*) is valid$")
    public void webiteValid(URL sharedURL){
        mainActivityRobot.launchMainActivityScreen(new ActivityTestRule<>(MainActivity.class));
        //See if sharedURL is valid or not.
    }

    @When("^A webpage is shared to GlanceReader$")
    public void listenForURLShare(){
        //Have a listener check to see if a URL is shared to GlanceReader
    }

    @Then("^The application will open the website and begin reading$")
    public void beginURLReader(){
        //Have GlanceReader begin reading through the website given.
    }

}
