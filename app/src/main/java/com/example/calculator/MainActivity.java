package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private EditText billAmount;
    private TextView resultText;
    private Button btn5, btn10, btn15;
    private ImageView gifView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billAmount = findViewById(R.id.billAmount);
        resultText = findViewById(R.id.resultText);

        btn5 = findViewById(R.id.btn5);
        btn10 = findViewById(R.id.btn10);
        btn15 = findViewById(R.id.btn15);
        gifView = findViewById(R.id.gifView);

        Glide.with(this)
                .asGif()
                .load(R.drawable.ruba) // если гифка лежит в res/drawable
                .into(gifView);

        // Анимация кнопок
        AnimatedButton.applyAnimation(btn5);
        AnimatedButton.applyAnimation(btn10);
        AnimatedButton.applyAnimation(btn15);

        btn5.setOnClickListener(v -> calculateTip(5));
        btn10.setOnClickListener(v -> calculateTip(10));
        btn15.setOnClickListener(v -> calculateTip(15));
    }

    private void calculateTip(int percent) {
        String input = billAmount.getText().toString();
        if (input.isEmpty()) {
            resultText.setText("Введите сумму счёта!");
            return;
        }
        double bill = Double.parseDouble(input);
        double tip = bill * percent / 100.0;
        resultText.setText("Размер чаевых: " + String.format("%.2f", tip) + " ₽");
    }
}
