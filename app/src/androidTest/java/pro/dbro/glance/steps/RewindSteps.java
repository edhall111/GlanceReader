package pro.dbro.glance.steps;

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

public class RewindSteps {

    private final MainActivityRobot mainActivityRobot = MainActivityRobot.create();

    @Given("^I have (.*) open$")
    public void I_have_book_open(String bookUri) {
        mainActivityRobot.launchMainActivityScreenAndOpenBook(new ActivityTestRule<>(MainActivity.class), bookUri);
    }

    @And("^The word (.*) is displayed$")
    public void I_am_at_word(String word) throws Throwable {

    }

    @When("^I click rewind (.*)$")
    public void I_click_rewind(String rewindType) throws Throwable {

    }

    @Then("^The word (.*) should be displayed$")
    public void the_word_should_be_displayed(String word) {
        Assert.assertTrue(mainActivityRobot.isDisplayed(word));
    }

    @After
    public void tearDown() {
        ActivityFinisher.finishOpenActivities();
    }
}
