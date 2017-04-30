package pro.dbro.glance.steps;

import android.support.test.rule.ActivityTestRule;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import pro.dbro.glance.activities.MainActivity;
import pro.dbro.glance.activities.MainActivityRobot;

public class RewindSteps {

    private final MainActivityRobot mainActivityRobot = MainActivityRobot.create();

    @Given("^I have (.*) open$")
    public void I_have_book_open(String bookTitle) {
        mainActivityRobot.launchMainActivityScreen(new ActivityTestRule<>(MainActivity.class));
    }

    @When("^I click rewind$")
    public void I_click_rewind() {

    }

    @Then("^The word should be displayed$")
    public void the_word_should_be_displayed() {

    }
}
