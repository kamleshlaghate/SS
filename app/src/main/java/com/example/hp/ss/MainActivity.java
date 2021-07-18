package com.example.hp.ss;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public Button  loginButton;
    DatabaseHelper helper = new DatabaseHelper(this);

    public void msignUp ()

    {

        TextView signUpTextView = (TextView)findViewById(R.id.signUpTextView);


       signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,SignUpActivity.class);

                startActivity(i);


            }
        });

    }
    public void login (View view){

        EditText usernameEditText =(EditText) findViewById(R.id.usernameEditText);
        Log.i("username",usernameEditText.getText().toString());

        EditText passwordEditText =(EditText) findViewById(R.id.upasswordEditText);
        Log.i("password", passwordEditText.getText().toString());

        String Uname = usernameEditText.getText().toString();
        String pass = passwordEditText.getText().toString();

        String password = helper.searchPassword(Uname);
        if(pass.equals(password)){
            loginButton=(Button)findViewById(R.id.loginButton);

            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in = new Intent(MainActivity.this,FirstPageActivity.class);
                    startActivity(in);
                }
            });
        }
        else {
            Toast.makeText(MainActivity.this, " Username Or Password Don't Match ", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msignUp();
    }
}
