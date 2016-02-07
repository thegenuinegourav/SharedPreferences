package com.example.sourabh.sharedpreferencesexamples;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private TextView text;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        text = (TextView)findViewById(R.id.textView);

        //From which activity (MainActivity,  or MainActivity2), this activity starts up
        int flag=getIntent().getExtras().getInt("Flag");
        if(flag==1)   //From MainActivity
        {
             name=getIntent().getExtras().getString("MyTagName");
        }
        else{    //From MainActivity2
             name = getIntent().getExtras().getString("MynameTag");
        }
        text.setText("Congratulations "+name+"\nYou have been signed in");

    }

    public void Continue(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }
}
