package com.testappsandroid.fiestapp.Main.Login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.testappsandroid.fiestapp.Main.Main.MainActivity;
import com.testappsandroid.fiestapp.R;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Login Activity";

    //Firebase
    private FirebaseAuth mAuth;

    //Views
    private EditText tEmail;
    private EditText tPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate function");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Firebase
        mAuth = FirebaseAuth.getInstance();

        //Buttons
        findViewById(R.id.bLogin).setOnClickListener(this);

        //View
        tEmail = (EditText) findViewById(R.id.tEmail);
        tPassword = (EditText) findViewById(R.id.tPassword);

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

    public void onClick(View v){
        switch(v.getId()){
            case R.id.bLogin:
                //Login with Firebase Auth
                signIn(tEmail.getText().toString(),tPassword.getText().toString());
                break;
        }
    }

    private void signIn(String email, String password){
        Log.d(TAG, "singIn function");
        if(!validateFields()){
            return;
        }

        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(LoginActivity.this, "Authentication succeeded.",
                                    Toast.LENGTH_LONG).show();
                            Log.d(TAG, "user: " + user.getEmail());
                            Intent i = new Intent(LoginActivity.this, MainActivity.class);
                            i.putExtra("tProfileName", user.getEmail());
                            i.putExtra("UID", user.getUid());
                            startActivity(i);


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed." + task.getException().getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
    private boolean validateFields(){
        Log.d(TAG, "validateFields function");
        return (!TextUtils.isEmpty(tEmail.getText().toString()) && !TextUtils.isEmpty(tPassword.getText().toString()));
    }




}
