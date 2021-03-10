package com.example.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edntd;
    private TextView jpView;
    private TextView usView;
    private Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        edntd = findViewById(R.id.edntd);
        jpView = findViewById(R.id.jp);
        usView = findViewById(R.id.us);
        go = findViewById((R.id.go));
        Button de = findViewById(R.id.delete);
        de.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edntd.setText("");
                jpView.setText("");
                usView.setText("");
            }
        });
    }

    public void go(View view){
        String n = edntd.getText().toString();
        if(n.length() ==0 ) {
            new AlertDialog.Builder(this)
                    .setTitle("Problem")
                    .setMessage("Please enter your ntd amount !!")
                    .setPositiveButton("OK", null)
                    .show();
        }else{
            float ntd = Float.parseFloat(n);
            float jp = ntd*3.85f;
            float us = ntd/30.9f;
            new AlertDialog.Builder(this)
                    .setTitle("Result")
                    .setMessage(" JPD  is  "+jp+"\n"+" USD  is  "+us)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            jpView.setText(String.valueOf(jp));
                            usView.setText(String.valueOf(us));
                        }
                    })
                    .show();
        }

    }
}