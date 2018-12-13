package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.jokeEndpoint.JokeEndpoint;
import com.udacity.gradle.builditbigger.front.ShowActivity;

import java.io.IOException;

class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {

    private JokeEndpoint jokeEndpointService = null;
    private Context context;

    @Override
    protected String doInBackground(Context... params) {
        if (jokeEndpointService == null) {  // Only do this once
            JokeEndpoint.Builder builder = new JokeEndpoint.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://api-graddle.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            ;
            jokeEndpointService = builder.build();
        }

        context = params[0];

        try {
            return jokeEndpointService.getJoke().execute().getData();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(context, ShowActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, result);
        context.startActivity(intent);
    }

}