package com.example.hp.ss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pointers extends AppCompatActivity {
    public Button homeButton, nextButton,backButton;
    public void home()
    {
        homeButton=(Button)findViewById(R.id.button46 );
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(pointers.this,FrontPageActivity.class);
                startActivity(i);
            }
        });
    }
    public void next()
    {
        nextButton=(Button)findViewById(R.id.button48 );
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(pointers.this,ArrayCActivity.class);
            }
        });
    }

    public void back()
    {
        backButton=(Button)findViewById(R.id.button47);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(pointers.this,ArrayCActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pointers);
        next();
        home();
        back();
    }
}
