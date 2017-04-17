package pro.dbro.glance.test;

import android.test.ActivityInstrumentationTestCase2;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import pro.dbro.glance.activities.RewindActivity;

@CucumberOptions(features = "features")
public class RewindSteps extends ActivityInstrumentationTestCase2<RewindActivity> {
    public RewindSteps() {
        super(RewindActivity.class);
    }

    @Given("^I have Moby Dick loaded at word Some$")
    public void loadMobyDickAtWordCall() {

    }

    @When("^I click rewind sentence button$")
    public void clickRewindSentence() {

    }

    @Then("^The word Call should be displayed$")
    public void wordShouldBeDisplayed() {

    }
}
