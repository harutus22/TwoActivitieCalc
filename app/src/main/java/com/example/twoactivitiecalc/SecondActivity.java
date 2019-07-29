package com.example.twoactivitiecalc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static String FIRST = "First";
    public static String SECOND = "Second";
    public static String SUM = "sum";

    private TextView first, second;
    private Button add, substract;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initilize();
        final Intent intent = getIntent();
        final int a = intent.getIntExtra(MainActivity.FIRST, 0);
        final int b = intent.getIntExtra(MainActivity.SECOND, 0);
        first.setText(String.valueOf(a));
        second.setText(String.valueOf(b));
        final Intent send = new Intent(this, MainActivity.class);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send.putExtra(FIRST, a);
                send.putExtra(SECOND, b);
                send.putExtra(SUM, a + b);
                goTo(send);
            }
        });
        substract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send.putExtra(FIRST, a);
                send.putExtra(SECOND, b);
                send.putExtra(SUM, a - b);
                goTo(send);
            }
        });
    }

    private void initilize(){
        first = findViewById(R.id.getFirstNumber);
        second = findViewById(R.id.getSecondNumber);
        add = findViewById(R.id.addition);
        substract = findViewById(R.id.subtraction);
    }

    private void goTo(Intent intent){
        startActivity(intent);
    }
}
