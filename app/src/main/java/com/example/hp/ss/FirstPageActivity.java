package com.example.hp.ss;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FirstPageActivity extends AppCompatActivity {
    public Button cButton,b4Button,b2Button,b3Button;
    public void front()

    {

         cButton=(Button)findViewById(R.id.b1Button);

            cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstPageActivity.this,FrontPageActivity.class);

                startActivity(intent);
                }
            }

        );

    }


    public void d()

    {

        b2Button=(Button)findViewById(R.id.b2Button);

        b2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(FirstPageActivity.this,ComingSoonActivity.class);

                startActivity(intent2);

            }
        });

    }
    public void e()

    {

        b3Button=(Button)findViewById(R.id.b3Button);

        b3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(FirstPageActivity.this,ComingSoonActivity.class);

                startActivity(intent3);

            }
        });

    }
    public void c()

    {

        b4Button=(Button)findViewById(R.id.b4Button);

        b4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(FirstPageActivity.this,ComingSoonActivity.class);

                startActivity(intent1);

            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        front();
        c();
        d();
        e();
    }
}
