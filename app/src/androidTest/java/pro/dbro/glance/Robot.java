package pro.dbro.glance;

import android.support.annotation.IdRes;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.core.AllOf.allOf;

public abstract class Robot<T extends Robot> {

    protected T checkTextIsDisplayed(String text, @IdRes int view) {
        onView(allOf(withId(view), withText(text))).check(matches(isDisplayed()));
        return (T) this;
    }

    public T waitFor(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
        return (T) this;
    }


    public <K> K toRobot(Class<K> robotClass) throws IllegalAccessException, InstantiationException {
        return robotClass.newInstance();
    }
}