package com.example.computerquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseController {
    private SQLiteDatabase db;
    private CreateDatabase database;

    public DatabaseController(Context context) {
        database = new CreateDatabase(context);
    }

    public String insertData(String question, String answer_a, String answer_b, String answer_c, String answer_d, String correct_answer, String level) {
        ContentValues values;
        long result;

        db = database.getWritableDatabase();
        values = new ContentValues();
        values.put(CreateDatabase.QUESTION, question);
        values.put(CreateDatabase.ANSWER_A, answer_a);
        values.put(CreateDatabase.ANSWER_B, answer_b);
        values.put(CreateDatabase.ANSWER_C, answer_c);
        values.put(CreateDatabase.ANSWER_D, answer_d);
        values.put(CreateDatabase.CORRECT_ANSWER, correct_answer);
        values.put(CreateDatabase.LEVEL, level);

        result = db.insert(CreateDatabase.TABLE, null, values);
        db.close();

        if (result == -1)
            return "Erro ao inserir registro.";
        else
            return "Registro Inserido com sucesso!";
    }

    public Cursor selectData() {
        Cursor cursor;
        String[] fields = {database.ID_QUESTION, database.QUESTION, database.ANSWER_A, database.ANSWER_B, database.ANSWER_C, database.ANSWER_D, database.CORRECT_ANSWER, database.LEVEL};
        db = database.getReadableDatabase();
        cursor = db.query(database.TABLE, fields, null, null, null, null, database.LEVEL, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public void truncateTable() {
        db = database.getWritableDatabase();
        db.delete(CreateDatabase.TABLE, null, null);
        db.close();
    }
}
