package pro.dbro.glance.activities;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import pro.dbro.glance.Robot;

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
}
