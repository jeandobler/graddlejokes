package com.udacity.gradle.builditbigger.front;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    TextView mTvJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        String joke = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        TextView mTvJoke = (TextView) findViewById(R.id.tv_joke);
        mTvJoke.setText(joke);
    }
}
