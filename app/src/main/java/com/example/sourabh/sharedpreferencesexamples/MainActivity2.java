package com.example.sourabh.sharedpreferencesexamples;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.sourabh.sharedpreferencesexamples.R;

public class MainActivity2 extends AppCompatActivity {

    private EditText name,email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = (EditText)findViewById(R.id.nameEditText);
        email  =(EditText)findViewById(R.id.emailEditText);
        password = (EditText)findViewById(R.id.passwordEditText);
    }

    public void Submit(View view)
    {
        //Putting data into SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();  //to edit the sharedPreference

        //Adding values to sharedPreference
        editor.putString("Email", email.getText().toString());
        editor.putString("Password", password.getText().toString());
        editor.putString("Name", name.getText().toString());

        //Commiting the changes in the sharedPreference
        editor.commit();

        Intent intent = new Intent(this,MainActivity3.class);
        intent.putExtra("MynameTag",name.getText().toString());
        intent.putExtra("Flag",2);  //to indicate this activity
        startActivity(intent);


    }


}
