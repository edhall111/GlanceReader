package pro.dbro.glance.utils;

import android.os.Bundle;
import android.support.test.runner.AndroidJUnitRunner;

import cucumber.api.android.CucumberInstrumentationCore;

public class CucumberInstrumentation extends AndroidJUnitRunner {
    private final CucumberInstrumentationCore instrumentationCore =
            new CucumberInstrumentationCore(this);

    @Override
    public void onCreate(final Bundle bundle) {
        instrumentationCore.create(bundle);
        super.onCreate(bundle);
    }

    @Override
    public void onStart() {
        waitForIdleSync();
        instrumentationCore.start();
    }
}
