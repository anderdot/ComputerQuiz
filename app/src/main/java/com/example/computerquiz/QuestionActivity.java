package com.example.computerquiz;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionActivity extends AppCompatActivity {
    TextView txtAnswer;
    Button btnA, btnB, btnC, btnD;
    String correct_answer;
    Cursor questions;
    Integer total = 0, correct = 0;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        txtAnswer = findViewById(R.id.txtAnswer);
        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnD = findViewById(R.id.btnD);

        DatabaseController databaseController = new DatabaseController(getBaseContext());
        questions = databaseController.selectData();

        if (questions.moveToFirst()) {
            txtAnswer.setText(questions.getString(questions.getColumnIndex("question")));
            btnA.setText(questions.getString(questions.getColumnIndex("answer_a")));
            btnB.setText(questions.getString(questions.getColumnIndex("answer_b")));
            btnC.setText(questions.getString(questions.getColumnIndex("answer_c")));
            btnD.setText(questions.getString(questions.getColumnIndex("answer_d")));
            correct_answer = questions.getString(questions.getColumnIndex("correct_answer"));
            total++;
        }

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnA.getText().toString().equals(correct_answer)) {
                    btnA.setBackgroundColor(Color.GREEN);
                    Toast.makeText(getApplicationContext(), "Resposta correta", Toast.LENGTH_SHORT).show();
                    correct++;
                } else {
                    btnA.setBackgroundColor(Color.RED);
                    Toast.makeText(getApplicationContext(), "Resposta incorreta", Toast.LENGTH_SHORT).show();
                }

                if (questions.moveToNext()) {
                    txtAnswer.setText(questions.getString(questions.getColumnIndex("question")));
                    btnA.setText(questions.getString(questions.getColumnIndex("answer_a")));
                    btnB.setText(questions.getString(questions.getColumnIndex("answer_b")));
                    btnC.setText(questions.getString(questions.getColumnIndex("answer_c")));
                    btnD.setText(questions.getString(questions.getColumnIndex("answer_d")));
                    correct_answer = questions.getString(questions.getColumnIndex("correct_answer"));
                    total++;
                } else {
                    Toast.makeText(getApplicationContext(), "Fim do jogo - " + correct + "/" + total, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnB.getText().toString().equals(correct_answer)) {
                    btnB.setBackgroundColor(Color.GREEN);
                    Toast.makeText(getApplicationContext(), "Resposta correta", Toast.LENGTH_SHORT).show();
                    correct++;
                } else {
                    btnB.setBackgroundColor(Color.RED);
                    Toast.makeText(getApplicationContext(), "Resposta incorreta", Toast.LENGTH_SHORT).show();
                }

                if (questions.moveToNext()) {
                    txtAnswer.setText(questions.getString(questions.getColumnIndex("question")));
                    btnA.setText(questions.getString(questions.getColumnIndex("answer_a")));
                    btnB.setText(questions.getString(questions.getColumnIndex("answer_b")));
                    btnC.setText(questions.getString(questions.getColumnIndex("answer_c")));
                    btnD.setText(questions.getString(questions.getColumnIndex("answer_d")));
                    correct_answer = questions.getString(questions.getColumnIndex("correct_answer"));
                    total++;
                } else {
                    Toast.makeText(getApplicationContext(), "Fim do jogo - " + correct + "/" + total, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnC.getText().toString().equals(correct_answer)) {
                    btnC.setBackgroundColor(Color.GREEN);
                    Toast.makeText(getApplicationContext(), "Resposta correta", Toast.LENGTH_SHORT).show();
                    correct++;
                } else {
                    btnC.setBackgroundColor(Color.RED);
                    Toast.makeText(getApplicationContext(), "Resposta incorreta", Toast.LENGTH_SHORT).show();
                }

                if (questions.moveToNext()) {
                    txtAnswer.setText(questions.getString(questions.getColumnIndex("question")));
                    btnA.setText(questions.getString(questions.getColumnIndex("answer_a")));
                    btnB.setText(questions.getString(questions.getColumnIndex("answer_b")));
                    btnC.setText(questions.getString(questions.getColumnIndex("answer_c")));
                    btnD.setText(questions.getString(questions.getColumnIndex("answer_d")));
                    correct_answer = questions.getString(questions.getColumnIndex("correct_answer"));
                    total++;
                } else {
                    Toast.makeText(getApplicationContext(), "Fim do jogo - " + correct + "/" + total, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnD.getText().toString().equals(correct_answer)) {
                    btnD.setBackgroundColor(Color.GREEN);
                    Toast.makeText(getApplicationContext(), "Resposta correta", Toast.LENGTH_SHORT).show();
                    correct++;
                } else {
                    btnD.setBackgroundColor(Color.RED);
                    Toast.makeText(getApplicationContext(), "Resposta incorreta", Toast.LENGTH_SHORT).show();
                }

                if (questions.moveToNext()) {
                    txtAnswer.setText(questions.getString(questions.getColumnIndex("question")));
                    btnA.setText(questions.getString(questions.getColumnIndex("answer_a")));
                    btnB.setText(questions.getString(questions.getColumnIndex("answer_b")));
                    btnC.setText(questions.getString(questions.getColumnIndex("answer_c")));
                    btnD.setText(questions.getString(questions.getColumnIndex("answer_d")));
                    correct_answer = questions.getString(questions.getColumnIndex("correct_answer"));
                    total++;
                } else {
                    Toast.makeText(getApplicationContext(), "Fim do jogo - " + correct + "/" + total, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}