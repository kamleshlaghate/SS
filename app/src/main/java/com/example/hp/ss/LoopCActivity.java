package com.example.hp.ss;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LoopCActivity extends AppCompatActivity {

    public Button b1Button,b2Button,b3Button,b4Button,b5Button,b6Button;
    public void bB1Button()

    {

        b1Button=(Button)findViewById(R.id.b1Button);

        b1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(LoopCActivity.this,conditionals.class);

                startActivity(intent1);


            }
        });

    }

    public void bB2Button()

    {

        b2Button=(Button)findViewById(R.id.b2Button);

        b2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(LoopCActivity.this,nested_if.class);

                startActivity(intent2);


            }
        });

    }


    public void bB3Button()

    {

        b3Button=(Button)findViewById(R.id.b3Button);

        b3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(LoopCActivity.this,switch_stmt.class);

                startActivity(intent3);


            }
        });

    }

    public void bB4Button()

    {

        b4Button=(Button)findViewById(R.id.b4Button);

        b4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(LoopCActivity.this,logicoptrs.class);

                startActivity(intent4);


            }
        });

    }

    public void bB5Button()

    {

        b5Button=(Button)findViewById(R.id.b5Button);

        b5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(LoopCActivity.this,whileloop.class);

                startActivity(intent5);


            }
        });

    }

    public void bB6Button()

    {

        b6Button=(Button)findViewById(R.id.b6Button);

        b6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(LoopCActivity.this,forloop.class);

                startActivity(intent6);


            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop_c);

        bB1Button();
        bB2Button();
        bB3Button();
        bB4Button();
        bB5Button();
        bB6Button();
    }
}
