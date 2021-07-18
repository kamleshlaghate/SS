package com.example.hp.ss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class conditionals extends AppCompatActivity {

    public Button homeButton, nextButton,backButton;

    public void home()
    {
        homeButton=(Button)findViewById(R.id.button26 );
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(conditionals.this,FrontPageActivity.class);
                startActivity(i);
            }
        });
    }
    public void next()
    {
        nextButton=(Button)findViewById(R.id.button28 );
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(conditionals.this,nextconditionals.class);
                startActivity(i);
            }
        });
    }

    public void back()
    {
        backButton=(Button)findViewById(R.id.button27 );
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(conditionals.this,LoopCActivity.class);
                startActivity(i);
            }
        });
    }

        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conditionals);
            next();
            back();
            home();

    }
}


