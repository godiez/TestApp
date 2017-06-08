package com.testappsandroid.fiestapp.Main.Profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.testappsandroid.fiestapp.R;

import static com.testappsandroid.fiestapp.R.id.tEmail;
import static com.testappsandroid.fiestapp.R.id.tPassword;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "Profile Activity";
    private EditText tProfileName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        tProfileName = (EditText) findViewById(R.id.tProfileName);
    }
    @Override
    protected void onStart(){
        Log.d(TAG, "onStart function");
        super.onStart();
        //Get data from LoginActivity
        String user = getIntent().getStringExtra("tProfileName");
        tProfileName.setEnabled(false);
        tProfileName.setText(user, TextView.BufferType.NORMAL);

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

}
