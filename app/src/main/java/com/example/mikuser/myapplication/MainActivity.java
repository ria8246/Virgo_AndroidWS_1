package com.example.mikuser.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    private EditText input;
    private Button send;
    private MessageAdatper adatper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.list);
        input = (EditText) findViewById(R.id.editText);
        send = (Button) findViewById(R.id.send);
        adatper = new MessageAdatper(this, new ArrayList<String>());
        list.setAdapter(adatper);
        adatper.add("Hey!!");

        send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String text = input.getText().toString();
                adatper.add(text);
                input.setText("");
                respond(text);
            }
        });
    }

    private void respond(String text) {
        adatper.add(text);
    }

}
