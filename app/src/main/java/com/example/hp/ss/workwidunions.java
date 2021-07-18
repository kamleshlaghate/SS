package com.example.hp.ss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class workwidunions extends AppCompatActivity {
    public Button homeButton, nextButton,backButton;
    public void home()
    {
        homeButton=(Button)findViewById(R.id.button78);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(workwidunions.this,FrontPageActivity.class);
                startActivity(i);
            }
        });
    }


    public void back()
    {
        backButton=(Button)findViewById(R.id.button79);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(workwidunions.this,StructCActivity.class);
                startActivity(i);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workwidunions);
        home();
        back();
    }
}
