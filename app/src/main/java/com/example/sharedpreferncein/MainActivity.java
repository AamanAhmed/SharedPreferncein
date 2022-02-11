package com.example.sharedpreferncein;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed;
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed = (EditText) findViewById(R.id.txt1);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);

        checkprefernce();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String txt = ed.getText().toString();
                SharedPreferences obj = getSharedPreferences("Myfile",MODE_PRIVATE);
                SharedPreferences.Editor ed = obj.edit();
                ed.putString("Username",txt);
                ed.apply();
                Toast.makeText(MainActivity.this, "File Created Successfully", Toast.LENGTH_SHORT).show();
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences obj = getSharedPreferences("Myfile",MODE_PRIVATE);
                SharedPreferences.Editor ed = obj.edit();
                ed.clear();
                ed.apply();

                Toast.makeText(MainActivity.this, "File Deleted Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void checkprefernce(){

        SharedPreferences obj = getSharedPreferences("Myfile",MODE_PRIVATE);
        if (obj.contains("Username")){
            ed.setText(obj.getString("Username",""));
        }
        else {
            ed.setText("No Username Found");
        }

    }
}