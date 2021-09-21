package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mainText;
    Button mainBtn;
    Button mainBtn_1;
    Button nullifier;

    private long score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainText = (TextView) findViewById(R.id.mainTxt);
        mainBtn = (Button) findViewById(R.id.main_btn);
        mainBtn_1 = (Button) findViewById(R.id.main_btn_1);
        nullifier = (Button) findViewById(R.id.main_nullifier);
        mainBtn.setOnClickListener(clickListener);
        mainBtn_1.setOnClickListener(clickListener_1);
        nullifier.setOnClickListener(Nullifier);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            score++;
            String s = "Кликов: " + score;
            mainText.setText(s.toCharArray(),0, s.length());
        }
    };

    View.OnClickListener clickListener_1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            score--;
            String s = "Кликов: " + score;
            mainText.setText(s.toCharArray(),0, s.length());
        }
    };

    View.OnClickListener Nullifier = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            score = 0;
            String s = "Кликов: " + score;
            mainText.setText(s.toCharArray(),0, s.length());
        }
    };

}