package com.example.hp.ss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class structures extends AppCompatActivity {
    public Button homeButton, nextButton,backButton;
    public void home()
    {
        homeButton=(Button)findViewById(R.id.button66);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(structures.this,FrontPageActivity.class);
                startActivity(i);
            }
        });
    }
    public void next()
    {
        nextButton=(Button)findViewById(R.id.button68 );
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(structures.this,nextstructures.class);
                startActivity(i);
            }
        });
    }

    public void back()
    {
        backButton=(Button)findViewById(R.id.button67);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(structures.this,StructCActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structures);
        home();
        next();
        back();
    }
}
