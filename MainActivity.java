package com.example.durgeshdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,pass,rePass;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().hide();
        databse databse=new databse(MainActivity.this,"jayesh",null,1);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.editTextTextPersonName);
        pass=findViewById(R.id.editTextTextPassword);
        rePass=findViewById(R.id.editTextTextPassword2);
        btn=findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name="",Pass="",RePass="";
                Name=name.getText().toString();
                Pass=pass.getText().toString();
                RePass=rePass.getText().toString();
                if((Name.matches("")!=true) && (Pass.matches("")!=true) ){
                    if(Pass.matches(RePass)){
                        databse.insertInto(Name,Pass);
                    }else{
                        Toast.makeText(MainActivity.this, "please Enter Correct Password ", Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(MainActivity.this, "please fill all details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}