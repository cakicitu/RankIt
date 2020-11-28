package com.example.rankit;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    EditText mUsername, mPassword;
    Button mRegister, mLogin;
    CheckBox mStayChecked;

    //TESTESTEST

    private void checkSharedPreferences(){ // CHeck shared preferneces and set them accordingly
        String checkbox = mPreferences.getString(getString(R.string.checkbox), "False");
        String username = mPreferences.getString(getString(R.string.username), "");
        String password = mPreferences.getString(getString(R.string.password), "");

        mUsername.setText(username);
        mPassword.setText(password);

        if(checkbox.equals("True")){
            mStayChecked.setChecked(true);
        }else
        {
            mStayChecked.setChecked(false);
        }
    }
    public void openRegistration(){
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }
    public void openMainMenu(){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.black));

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

        mUsername = (EditText) findViewById(R.id.usernameLogin);
        mPassword = (EditText )findViewById(R.id.editTextLoginPassword);
        mRegister = (Button) findViewById(R.id.buttonRegister);
        mLogin = (Button) findViewById(R.id.buttonLogin);
        mStayChecked = (CheckBox) findViewById(R.id.checkBoxLogin);

        checkSharedPreferences();

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //save the checkbox preference
                if(mStayChecked.isChecked()){
                    //set a checkbox when the application starts
                    mEditor.putString(getString(R.string.checkbox), "True");
                    mEditor.commit();

                    //save the name
                    String username = mUsername.getText().toString();
                    mEditor.putString(getString(R.string.username), username);
                    mEditor.commit();

                    //save the password
                    String password = mPassword.getText().toString();
                    mEditor.putString(getString(R.string.password), password);
                    mEditor.commit();

                }else
                {
                    //set uncheck checkbox when the application starts
                    mEditor.putString(getString(R.string.checkbox), "False");
                    mEditor.commit();

                    mEditor.putString(getString(R.string.username), " ");
                    mEditor.commit();

                    mEditor.putString(getString(R.string.username), " ");
                    mEditor.commit();

                }

                openMainMenu();
            }
        }); //SharedPreferences speichern beim Login

        mRegister.setOnClickListener(new View.OnClickListener() {  // Registration oeffnen
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.buttonRegister:


                        openRegistration();
                        break;
                    default:
                        break;
                }
            }
        });

    }
}