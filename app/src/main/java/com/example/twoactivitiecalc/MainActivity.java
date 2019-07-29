package com.example.twoactivitiecalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String FIRST = "first";
    public static String SECOND = "second";
    private EditText first, second;
    private TextView sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent get = getIntent();
        first = findViewById(R.id.firstNumber);
        second = findViewById(R.id.secondNumber);
        sum = findViewById(R.id.sum);
        if(get != null){
            first.setText(String.valueOf(get.getIntExtra(SecondActivity.FIRST, 0)));
            second.setText(String.valueOf(get.getIntExtra(SecondActivity.SECOND, 0)));
            sum.setText(String.valueOf(get.getIntExtra(SecondActivity.SUM, 0)));
        }

        first.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(first.getText().toString().equals("0") && hasFocus){
                    first.setText("");
                }
            }
        });

        second.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(second.getText().toString().equals("0") && hasFocus){
                    second.setText("");
                }
            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!check()) {
                    Intent intent = new Intent(getApplication(), SecondActivity.class);
                    putInIntent(intent);
                    startActivity(intent);
                }
            }
        });
    }

    private void putInIntent(Intent intent){
        intent.putExtra(FIRST, Integer.valueOf(first.getText().toString()));
        intent.putExtra(SECOND, Integer.valueOf(second.getText().toString()));
    }

    private boolean check(){
        return first.getText().toString().isEmpty() || second.getText().toString().isEmpty();
    }

}
