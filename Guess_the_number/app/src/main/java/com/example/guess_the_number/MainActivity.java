package com.example.guess_the_number;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    TextView tvInfo;
    EditText etInput;
    Button bControl;
    Button ExitButton;
    int number;
    boolean flag;
    int users_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView)findViewById(R.id.textView1);
        etInput = (EditText)findViewById(R.id.editText1);
        bControl = (Button)findViewById(R.id.button1);
        ExitButton = (Button)findViewById(R.id.exit_button);
        number = 0;
        flag = false;
        users_number = 0;

        number = (int)(Math.random() * 100);
        System.out.println(number);

        //Integer.parseInt(etInput.getText().toString()); //получение числа из поля ввода
        //tvInfo.setText(getResources().getString(R.string.ahead)); //изменить значение текста в информационном поле
    }

    public void onClick(View v)
    {
        try {
            users_number = Integer.parseInt(etInput.getText().toString());
        }
        catch (NumberFormatException a) {
            tvInfo.setText(getResources().getString(R.string.error));
        }
        if(bControl.getText().toString().equals("Сыграть еще"))
        {
            number = (int)(Math.random() * 100);
            System.out.println(number);
            bControl.setText(getResources().getString(R.string.try_to_guess));
        }
        //System.out.println(users_number);
        if(users_number == number)
        {
            tvInfo.setText(getResources().getString(R.string.hit));
            bControl.setText(getResources().getString(R.string.pLay_more));
        }
        if(users_number > number && users_number < 100 && users_number > 0)
        { tvInfo.setText(getResources().getString(R.string.ahead)); }
        if(users_number < number && users_number < 100 && users_number > 0)
        { tvInfo.setText(getResources().getString(R.string.behind)); }
        //System.out.println(bControl.getText().toString());
        if(users_number > 100 || users_number < 0)
        { tvInfo.setText(getResources().getString(R.string.range)); }
    }

    public void onExit(View v)
    {
        System.exit(0);
    }
}