package com.example.hp.ss;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    DatabaseHelper helper =new DatabaseHelper(this);
    public Button signInButton;

    public void click(View view){

        Log.i("info","acc created");

        EditText usernameEditText = (EditText)findViewById(R.id.usernameEditText);
        Log.i("username",usernameEditText.getText().toString());

        EditText passwordEditText = (EditText)findViewById(R.id.upasswordEditText);
        Log.i("pswd",passwordEditText.getText().toString());

        EditText rePasswordEditText=findViewById(R.id.rePasswordEditText);
        Log.i("repswd",rePasswordEditText.getText().toString());

        String uname=usernameEditText.getText().toString();

        String pass=passwordEditText.getText().toString();

        String repass=rePasswordEditText.getText().toString();

        if(!pass.equals(repass)){
            Toast match = Toast.makeText(SignUpActivity.this, "Password Don't Match ", Toast.LENGTH_SHORT);
             match.show();
        }
        else
        {
            //inserting info to database
            Contact c = new Contact();
            c.setUserName(uname);
            c.setPassword(pass);
            helper.insertToDb(c);
            Toast.makeText(this, "Sign up Sucessful...", Toast.LENGTH_SHORT).show();

        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

    }
}
