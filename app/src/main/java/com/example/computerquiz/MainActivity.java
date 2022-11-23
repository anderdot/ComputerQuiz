package com.example.computerquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String question, answer_a, answer_b, answer_c, answer_d, correct_answer, level, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.btnComecar);
        button.setTextColor(Color.BLACK);

        DatabaseController databaseController = new DatabaseController(getBaseContext());
        databaseController.truncateTable();

        question = "Qual o nome do sistema operacional da Apple?";
        answer_a = "Windows";
        answer_b = "Linux";
        answer_c = "MacOS";
        answer_d = "Android";
        correct_answer = "MacOS";
        level = "1";
        result = databaseController.insertData(question, answer_a, answer_b, answer_c, answer_d, correct_answer, level);
        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();

        question = "Qual a companhia dona do sistema Android?";
        answer_a = "Samsung";
        answer_b = "Nokia";
        answer_c = "Apple";
        answer_d = "Google";
        correct_answer = "Google";
        level = "1";

        result = databaseController.insertData(question, answer_a, answer_b, answer_c, answer_d, correct_answer, level);
        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();

        question = "Qual dessas não é uma linguagem de programação?";
        answer_a = "Kotlin";
        answer_b = "Notepad";
        answer_c = "Python";
        answer_d = "C#";
        correct_answer = "Notepad";
        level = "1";

        result = databaseController.insertData(question, answer_a, answer_b, answer_c, answer_d, correct_answer, level);
        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();

        question = "Qual alternativa corresponde ao número 42 em binário?";
        answer_a = "101010";
        answer_b = "01001";
        answer_c = "22";
        answer_d = "110010";
        correct_answer = "101010";
        level = "2";

        result = databaseController.insertData(question, answer_a, answer_b, answer_c, answer_d, correct_answer, level);
        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();

        question = "Qual a linguagem de programação mais popular do mundo?";
        answer_a = "Java";
        answer_b = "C#";
        answer_c = "Python";
        answer_d = "C++";
        correct_answer = "Java";
        level = "2";

        result = databaseController.insertData(question, answer_a, answer_b, answer_c, answer_d, correct_answer, level);
        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), QuestionActivity.class);
                startActivity(intent);
            }
        });
    }
}