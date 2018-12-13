package com.udacity.gradle.builditbigger;

import android.test.ActivityInstrumentationTestCase2;

import org.junit.Test;

import java.util.concurrent.ExecutionException;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mMainActivity;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mMainActivity = getActivity();
    }

    @Test
    public void testAsyncTask() throws InterruptedException {
        try {
            String returns = new EndpointsAsyncTask().execute(mMainActivity.getBaseContext()).get();
            Thread.sleep(1500);

            assertTrue(returns != null && !returns.equals(""));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}