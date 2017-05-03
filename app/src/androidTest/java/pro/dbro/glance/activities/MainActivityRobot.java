package pro.dbro.glance.activities;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import pro.dbro.glance.Robot;
import pro.dbro.glance.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class MainActivityRobot extends Robot<MainActivityRobot> {

    public static MainActivityRobot create() { return new MainActivityRobot(); }

    public MainActivityRobot() {
    }

    public MainActivityRobot launchMainActivityScreen(ActivityTestRule<MainActivity> testRule) {
        testRule.launchActivity(MainActivity.createIntentFor(InstrumentationRegistry
                .getInstrumentation()
                .getTargetContext()
                .getApplicationContext()));

        return new MainActivityRobot();
    }

    public MainActivityRobot launchMainActivityScreenAndOpenBook(ActivityTestRule<MainActivity> testRule, String bookUri) {
        testRule.launchActivity(MainActivity.createIntentFor(InstrumentationRegistry
                .getInstrumentation()
                .getTargetContext()
                .getApplicationContext(), bookUri));

        return new MainActivityRobot();
    }

    public boolean isDisplayed (String word) {
        return false;
    }
}
