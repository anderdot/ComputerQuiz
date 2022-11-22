package com.example.computerquiz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CreateDatabase extends SQLiteOpenHelper{
    public static final String DATABASE = "ComputerQuiz.db";
    public static final String TABLE = "Question";
    public static final String ID_QUESTION = "id_question";
    public static final String QUESTION = "question";
    public static final String ANSWER_A = "answer_a";
    public static final String ANSWER_B = "answer_b";
    public static final String ANSWER_C = "answer_c";
    public static final String ANSWER_D = "answer_d";
    public static final String CORRECT_ANSWER = "correct_answer";
    public static final String LEVEL = "level";
    private static final int VERSION = 1;

    public CreateDatabase(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE + " ("
                + ID_QUESTION + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + QUESTION + " TEXT,"
                + ANSWER_A + " TEXT,"
                + ANSWER_B + " TEXT,"
                + ANSWER_C + " TEXT,"
                + ANSWER_D + " TEXT,"
                + CORRECT_ANSWER + " TEXT,"
                + LEVEL + " INTEGER);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }
}
