package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.test.InstrumentationRegistry;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.front.ShowActivity;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainActivityTest {


    @Test
    public void asyncTest() throws Exception {
        EndpointsAsyncTask endPointAsyncTask =  new EndpointsAsyncTask();
        endPointAsyncTask.execute();
        String endPointAsyncTaskResult = endPointAsyncTask.get(5, TimeUnit.SECONDS);
        Assert.assertEquals(5,endPointAsyncTaskResult.length());
    }
}
