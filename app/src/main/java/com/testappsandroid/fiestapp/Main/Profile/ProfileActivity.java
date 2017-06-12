package com.testappsandroid.fiestapp.Main.Profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.testappsandroid.fiestapp.R;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "Profile Activity";

    //Views
    private TextView tUserName;
    private TextView tAge;
    //Firebase
    private String user;


    private LinearLayout contentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
    @Override
    protected void onStart(){
        Log.d(TAG, "onStart function");
        super.onStart();
        //Buttons
        findViewById(R.id.bProfile).setOnClickListener(this);
        findViewById(R.id.bMessages).setOnClickListener(this);
        findViewById(R.id.bContacts).setOnClickListener(this);
        findViewById(R.id.bPlaces).setOnClickListener(this);
        findViewById(R.id.bExit).setOnClickListener(this);

        //Views
        tUserName = (TextView)findViewById(R.id.tUserName);
        tAge = (TextView)findViewById(R.id.tAge);
        contentLayout = (LinearLayout)findViewById(R.id.idContentLayout);
    }

    @Override
    protected void onRestart(){
        Log.d(TAG, "onRestart function");
        super.onRestart();

    }

    @Override
    protected void onResume(){
        Log.d(TAG, "onResume function");
        super.onResume();
    }

    @Override
    protected void onPause(){
        Log.d(TAG, "onPause function");
        super.onPause();
        user = getIntent().getStringExtra("tProfileName");
        Log.d(TAG, "User: " + user);
    }

    @Override
    protected void onStop(){
        Log.d(TAG, "onStop function");
        super.onStop();
    }

    @Override
    protected void onDestroy(){
        Log.d(TAG, "onDestroy function");
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bProfile:
                Log.d(TAG, "onClick, buttonProfile pressed");
                LinearLayout profileLayout = (LinearLayout) findViewById(R.id.profile_content);
                break;
            case R.id.bMessages:
                Log.d(TAG, "onClick, buttonMessages pressed");
                break;
            case R.id.bContacts:
                Log.d(TAG, "onClick, buttonContacts pressed");
                break;
            case R.id.bPlaces:
                Log.d(TAG, "onClick, buttonPlaces pressed");
                break;
            case R.id.bExit:
                Log.d(TAG, "onClick, buttonExit pressed");
                break;
        }
    }
}
