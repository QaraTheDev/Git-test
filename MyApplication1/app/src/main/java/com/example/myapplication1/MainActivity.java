package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button showBtn;
    Button hideBtn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        unbindViews();
    }

    private void bindViews(){
        showBtn = findViewById(R.id.showTextBtn);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showText();
            }
        };
        showBtn.setOnClickListener(clickListener);
    }
    private void unbindViews(){
        hideBtn = findViewById(R.id.hideTextBtn);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideText();
            }
        };
        hideBtn.setOnClickListener(clickListener);
    }
    private void showText(){
        textView = findViewById(R.id.helloTextView);
        textView.setVisibility(View.VISIBLE);
    }
    private void hideText(){
        textView = findViewById(R.id.helloTextView);
        textView.setVisibility(View.INVISIBLE);
    }
}