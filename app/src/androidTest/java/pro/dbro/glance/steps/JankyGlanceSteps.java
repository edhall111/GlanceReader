package pro.dbro.glance.steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pro.dbro.glance.utils.ActivityFinisher;

public class JankyGlanceSteps {

    @Given("^The application is started$")
    public void the_application_is_started() {
        throw new PendingException();
    }

    @When("I connect to the backend$")
    public void I_connect_to_the_backend() {
        throw new PendingException();
    }

    @Then("^I should be using the endpoint: (.*)$")
    public void should_be_using_the_endpoint(String endpoint) {
        throw new PendingException();
    }

    @After
    public void tearDown() {
        ActivityFinisher.finishOpenActivities();
    }
}
