package com.example.sourabh.sharedpreferencesexamples;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    private String email,password,emailSharedPref,passwordSharedPref;
    private EditText emailEditText,passwordEditText;
    private final String DEFAULT = "Incorrect";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = (EditText)findViewById(R.id.editTextEmail);
        passwordEditText  =(EditText)findViewById(R.id.editTextPassword);
    }

    public void Login(View view)
   {
       //Check whether email and password exists
       email = emailEditText.getText().toString();
       password = passwordEditText.getText().toString();

       //To retrieve data from sharedPreference
       SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);  //First arg is filename and second arg is value i.e. private i.e. only app can access this file
       emailSharedPref=sharedPreferences.getString("Email", DEFAULT);  //First arg is key and second arg is value. If key/value doesnt exist then DEFAULT will be returned
       passwordSharedPref= sharedPreferences.getString("Password",DEFAULT);

       if(email.equals(emailSharedPref) && password.equals(passwordSharedPref)) {
           //Email and password matches

           String name = sharedPreferences.getString("Name", DEFAULT);  //Retrieving Name

           Intent i = new Intent(this, MainActivity3.class);
           i.putExtra("MyTagName", name);
           i.putExtra("Flag", 1);  //To indicate this activity
           startActivity(i);
       }

       else
       {
           //Email and password doesnt matches
           Toast.makeText(this,"Incorrect Email or Password",Toast.LENGTH_LONG).show();
       }


   }

   public void SignUp(View view)
   {
       startActivity(new Intent(this,MainActivity2.class));
   }

}
