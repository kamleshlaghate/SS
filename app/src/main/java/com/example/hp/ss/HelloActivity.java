package com.example.hp.ss;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HelloActivity extends AppCompatActivity {
    public Button homeButton, nextButton,backButton;

    public void home()
    {
        homeButton=(Button)findViewById(R.id.homeButton );
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(HelloActivity.this,FrontPageActivity.class);
                startActivity(i);
            }
        });
    }


    public void back()
    {
        backButton=(Button)findViewById(R.id.button83);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(HelloActivity.this,BasicCActivity.class);
                startActivity(i);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        back();
        home();
    }
}
