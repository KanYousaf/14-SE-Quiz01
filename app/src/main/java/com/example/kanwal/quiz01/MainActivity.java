package com.example.kanwal.quiz01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button left_btn, right_btn;
    private TextView display_score;
    private int x1, x2, score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //calling button id's
        left_btn = (Button) this.findViewById(R.id.Left_Button);
        right_btn = (Button) this.findViewById(R.id.Right_Button);

        //call roll function to get random numbers for left and right buttons
        roll();

    }

    public void btn_left_clicked_function(View view) {
        checkGreaterFunction(x1, x2);
        roll();
    }

    public void btn_right_clicked_function(View view) {
        checkGreaterFunction(x2, x1);
        roll();
    }

    public void checkGreaterFunction(int number1, int number2) {
        if (number1 > number2) {
            score += 10;
        } else {
            score -= 10;
        }
        display_score = (TextView) this.findViewById(R.id.Score_TV);
        display_score.setText(String.valueOf(score));
    }

    public void roll() {
        Random random = new Random();
        x1 = random.nextInt(1000);
        x2 = random.nextInt(1000);
        if (x1 == x2) {
            x1 = random.nextInt(1000);
        }
        // setting text for buttons
        left_btn.setText(String.valueOf(x1));
        right_btn.setText(String.valueOf(x2));
    }
}
