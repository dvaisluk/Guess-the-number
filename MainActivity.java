package com.example.myapplication;



import java.lang.NumberFormatException;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText in;
    TextView out;
    TextView an;
    View imb;


    Button button;
    int rInt;
    int inInt;

    @SuppressLint({"WrongViewCast", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        out = findViewById(R.id.i);
        in = findViewById(R.id.o);
        an = findViewById(R.id.answer);
        button = findViewById(R.id.button);
        imb = findViewById(R.id.imageButton);

        Random random = new Random();
        rInt = random.nextInt(100);
        rInt++;
        button.setOnClickListener(v -> {
            String str = in.getText().toString();
            if (str.equals("")){
                an.setText("Вы не ввели число!");
            } else{
                inInt = Integer.parseInt(str);
                if ((0 > inInt) || (inInt > 100)) {
                    an.setText("Число " + inInt + " Не в диапазоне. Попробуйте ещё раз!");
                } else {
                    if (rInt > inInt) {
                        an.setText("Число " + inInt + " меньше. Попробуйте ещё раз!");
                    } else if (rInt < inInt) {
                        an.setText("Число " + inInt + " больше. Попробуйте ещё раз!");
                    } else {
                        an.setText("Вы угадали!");
                    }
                }
            }

        });

        imb.setOnClickListener(v -> {
            finish();
            System.exit(0);

        });
    }
}

