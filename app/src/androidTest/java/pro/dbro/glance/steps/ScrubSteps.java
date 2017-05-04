package pro.dbro.glance.steps;

/**
 * Created by Ed on 5/3/2017.
 */

import android.support.test.rule.ActivityTestRule;

import junit.framework.Assert;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import pro.dbro.glance.activities.MainActivity;
import pro.dbro.glance.activities.MainActivityRobot;
import pro.dbro.glance.utils.ActivityFinisher;

public class ScrubSteps {

    private final MainActivityRobot mainActivityRobot = MainActivityRobot.create();

    @Given("^I have the link (.*) open$")
    public void I_have_link_open(String articleUri) {
        mainActivityRobot.launchMainActivityScreenAndOpenBook(new ActivityTestRule<>(MainActivity.class), articleUri);
    }

    @And("^I am at (.*) percent of the article$")
    public void I_am_at_beginning(float percent) throws Throwable {
        Assert.assertTrue(percent == 0);
    }

    @When("^I slide the Scrub bar forward (.*) percent$")
    public void I_slide_bar(float percent) throws Throwable {

    }

    @Then("^the word that should be displayed is at the 50 percent point of the entire article$")
    public void the_word_should_be_displayed(float percent) {
        Assert.assertTrue(percent == 50);
    }

    @After
    public void tearDown() {
        ActivityFinisher.finishOpenActivities();
    }
}
