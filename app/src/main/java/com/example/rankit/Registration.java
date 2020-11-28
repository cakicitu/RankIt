package com.example.rankit;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private EditText mEditTextUsername, mEditTextEmail, meditTextPassword, mEditTextRetPassword;
    private TextView mTextViewGender, mTextViewCountry, mTextViewWarnUsername, mTextViewWarnEmail, mTextViewWarnPassword, mTextViewWarnRePassword;
    private Button mButtonPickImage, mButtonRegister2;
    private Spinner mSpinnerCountry;
    private ImageView mImageViewAvatar;
    private ConstraintLayout parent;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(ContextCompat.getColor(Registration.this,R.color.black));

        initViews();

        mButtonPickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(this,"To be continued", Toast.LENGTH_SHORT).show;
            }
        });//Pick Image
        mButtonRegister2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initRegister();
            }
        });//Register
    }

    private void initRegister(){

        if(validateData()){
            //Toast.makeText(this, "Successfull", Toast.LENGTH_SHORT).show();
            mTextViewWarnUsername.setVisibility(View.GONE);
            mTextViewWarnEmail.setVisibility(View.GONE);
            mTextViewWarnPassword.setVisibility(View.GONE);
            mTextViewWarnRePassword.setVisibility(View.GONE);
            openMainActivity();
        }
    }
    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private boolean validateData(){
        if(mEditTextUsername.getText().toString().equals("")){
            mTextViewWarnUsername.setText("Please enter a valid username");
            return false;
        }
        if(mEditTextEmail.getText().toString().equals("")){
            mTextViewWarnEmail.setText("Please enter a valid E-Mail");
            return false;
        }
        if(meditTextPassword.getText().toString().equals("")){
            mTextViewWarnPassword.setText("Please enter a valid Password");
            return false;
        }
        if(mEditTextRetPassword.getText().toString().equals(" ")){//meditTextPassword.getText().toString())
            mTextViewWarnUsername.setText("Please enter matching Passwords");
            return false;
        }

        return true;
    }
    private void initViews(){
        Log.d(TAG,"initViews: Started");

        mEditTextUsername = findViewById(R.id.editTextUsername);
        mEditTextEmail = findViewById(R.id.editTextEmail);
        meditTextPassword = findViewById(R.id.editTextLoginPassword);
        mEditTextRetPassword = findViewById(R.id.editTextRetPassword);

        mTextViewGender = findViewById(R.id.textViewGender);
        mTextViewCountry = findViewById(R.id.textViewCountry);
        mTextViewWarnUsername = findViewById(R.id.textViewWarnUsername);
        mTextViewWarnEmail = findViewById(R.id.textViewWarnEmail);
        mTextViewWarnPassword = findViewById(R.id.textViewWarnPassword);
        mTextViewWarnRePassword = findViewById(R.id.textViewWarnRePassword);

        mButtonPickImage = findViewById(R.id.buttonPickImage);
        mButtonRegister2 = findViewById(R.id.buttonRegister2);

        mSpinnerCountry = findViewById(R.id.spinnerCountry);

        mImageViewAvatar = findViewById(R.id.imageViewAvatar);

        parent = findViewById(R.id.parent);

    }
}