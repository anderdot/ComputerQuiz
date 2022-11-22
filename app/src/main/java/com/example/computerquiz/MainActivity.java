package com.example.computerquiz;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.btnComecar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseController databaseController = new DatabaseController(getBaseContext());
                String question = "Qual o nome do sistema operacional da Apple?";
                String answer_a = "Windows";
                String answer_b = "Linux";
                String answer_c = "MacOS";
                String answer_d = "Android";
                String correct_answer = "MacOS";
                String level = "1";

                String result = databaseController.insertData(question, answer_a, answer_b, answer_c, answer_d, correct_answer, level);
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
            }
        });
    }
}