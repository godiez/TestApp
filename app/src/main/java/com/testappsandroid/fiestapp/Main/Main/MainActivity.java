package com.testappsandroid.fiestapp.Main.Main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.testappsandroid.fiestapp.R;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "Profile Activity";

    //Views
    private LinearLayout profileContent, messagesContent;
    private TextView tUserName;
    private TextView tAge;

    private TextView test;

    //User to connect with Firebase (ID)
    private String userUID;


    //Active button (layout option active)
    private String activeLayout;

    private Map<String, LinearLayout> menuOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttons
        findViewById(R.id.bProfile).setOnClickListener(this);
        findViewById(R.id.bMessages).setOnClickListener(this);
        findViewById(R.id.bContacts).setOnClickListener(this);
        findViewById(R.id.bPlaces).setOnClickListener(this);
        findViewById(R.id.bExit).setOnClickListener(this);

        //Views
        tUserName = (TextView)findViewById(R.id.tUserName);
        tAge = (TextView)findViewById(R.id.tAge);
        profileContent = (LinearLayout)findViewById(R.id.profile_content);
        test = (TextView)findViewById(R.id.test);
        messagesContent = (LinearLayout)findViewById(R.id.messages_content);


        //Helper dictionary for menu options
        menuOptions = new HashMap<>();
        menuOptions.put("bProfile", profileContent);
        menuOptions.put("bMessages", messagesContent);

        //Active layout default
        activeLayout = "bProfile";

        //
        userUID = getIntent().getStringExtra("UID");
    }
    @Override
    protected void onStart(){
        Log.d(TAG, "onStart function");
        super.onStart();

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
                //Hide previous layout
                menuOptions.get(activeLayout).setVisibility(View.INVISIBLE);
                //Set current layout
                activeLayout = "bProfile";
                profileContent.setVisibility(View.VISIBLE);
                //Access for extras passed in from login activity
                tUserName.setText(getIntent().getStringExtra("tProfileName"));
                break;
            case R.id.bMessages:
                Log.d(TAG, "onClick, buttonMessages pressed");
                menuOptions.get(activeLayout).setVisibility(View.INVISIBLE);
                activeLayout = "bMessages";
                messagesContent.setVisibility(View.VISIBLE);
                //Read messages from Firebase Database
                test.setText("Test" + userUID);
                break;
            case R.id.bContacts:
                Log.d(TAG, "onClick, buttonContacts pressed");
                activeLayout = "bContacts";
                break;
            case R.id.bPlaces:
                Log.d(TAG, "onClick, buttonPlaces pressed");
                activeLayout = "bPlaces";
                break;
            case R.id.bExit:
                Log.d(TAG, "onClick, buttonExit pressed");
                activeLayout = "bExit";
                break;
        }
    }
}
