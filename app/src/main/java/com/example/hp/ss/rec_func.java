package com.example.hp.ss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class rec_func extends AppCompatActivity {
    public Button homeButton, nextButton,backButton;

    public void home()
    {
        homeButton=(Button)findViewById(R.id.button30 );
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(rec_func.this,FrontPageActivity.class);
                startActivity(i);
            }
        });
    }
    public void next()
    {
        nextButton=(Button)findViewById(R.id.button32 );
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(rec_func.this,ArrayCActivity.class);
            }
        });
    }

    public void back()
    {
        backButton=(Button)findViewById(R.id.button31 );
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(rec_func.this,ArrayCActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_func);
        home();
        next();
        back();
    }
}
