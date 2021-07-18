package com.example.hp.ss;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CertificateActivity extends AppCompatActivity {

    EditText print_name;
    TextView Name ;
    Button generate ;
    String print  ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificate);
        print_name=findViewById(R.id.printName);
        Name=findViewById(R.id.name);
        generate=findViewById(R.id.button_generate_certificate);
        print = print_name.getText().toString();

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("cer Name",print_name.getText().toString());
              Name.setText(print_name.getText().toString());
            }
        });

    }
}
