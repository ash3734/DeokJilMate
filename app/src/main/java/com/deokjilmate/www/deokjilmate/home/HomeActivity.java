package com.deokjilmate.www.deokjilmate.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.deokjilmate.www.deokjilmate.R;

public class HomeActivity extends AppCompatActivity {

    Button helloWorld;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}
