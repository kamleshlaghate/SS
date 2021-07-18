package com.example.hp.ss;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FrontPageActivity extends AppCompatActivity {

    public Button QuizButton,basicConceptButton,ConditionalsAndLoopsButton,arrayButton,StringsPointersButton,structuresAndUnionButton;
    public void quizActivity()

    {

        QuizButton=(Button)findViewById(R.id.QuizButton);

        QuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(FrontPageActivity.this,QuizActivity.class);

                startActivity(intent1);


            }
        });

    }



    public void bBasicConceptButton ()

    {

        basicConceptButton=(Button)findViewById(R.id.basicConceptButton);

        basicConceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(FrontPageActivity.this,BasicCActivity.class);

                startActivity(intent2);


            }
        });

    }


    public void cConditionalsAndLoopsButton ()

    {

        ConditionalsAndLoopsButton=(Button)findViewById(R.id.ConditionalsAndLoopsButton);

        ConditionalsAndLoopsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(FrontPageActivity.this,LoopCActivity.class);

                startActivity(intent3);


            }
        });

    }


    public void aArrayButton ()

    {

        arrayButton=(Button)findViewById(R.id.arrayButton);

        arrayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(FrontPageActivity.this,ArrayCActivity.class);

                startActivity(intent4);


            }
        });

    }


    public void sStringsPointersButton ()

    {

        StringsPointersButton=(Button)findViewById(R.id.StringsPointersButton);

        StringsPointersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(FrontPageActivity.this,StringCActivity.class);

                startActivity(intent5);


            }
        });

    }


    public void sStructuresAndUnionButton ()

    {

        structuresAndUnionButton=(Button)findViewById(R.id.structuresAndUnionButton);

        structuresAndUnionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FrontPageActivity.this,StructCActivity.class);

                startActivity(i);


            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);
        quizActivity();
        bBasicConceptButton();
        cConditionalsAndLoopsButton();
        aArrayButton();
        sStringsPointersButton();
        sStructuresAndUnionButton();
    }
}
