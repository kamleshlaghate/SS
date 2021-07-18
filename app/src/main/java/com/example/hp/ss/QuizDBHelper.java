package com.example.hp.ss;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import com.example.hp.ss.QuizContract.*;

public class QuizDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Quiz.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;


    public QuizDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE_ = "CREATE TABLE " + QuestionTable.TABLE_NAME + "(" +
                QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                QuestionTable.COLUMN_QUESTION + " TEXT," +
                QuestionTable.COLUMN_OPTION1 + " TEXT," +
                QuestionTable.COLUMN_OPTION2 + " TEXT," +
                QuestionTable.COLUMN_OPTION3 + " TEXT," +
                QuestionTable.COLUMN_OPTION4 + " TEXT," +
                QuestionTable.COLUMN_ANSWER_NR + " INTEGER"+")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE_);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        onCreate(db);

    }

    private void fillQuestionsTable() {
        Question q1= new Question("c is a ___________ language ?", "functional", "machine", "procedural", "modular", 3);
        addQuestion(q1);
        Question q2 = new Question("What is the size of ‘int’?", "2", "4", "6", "1", 2);
        addQuestion(q2);
        Question q3 = new Question("Which library functions help users to dynamically allocate memory?", "memalloc()and alloc() ", "malloc() and memalloc()", "malloc() and calloc()", "memalloc() and calloc()", 3);
        addQuestion(q3);
        Question q4 = new Question("A long double can be used if range of a double is not enough to accommodate a real number.", "True", "False", "cannot predict", "invalid", 1);
        addQuestion(q4);
        Question q5 = new Question("By default a real number is treated as a", "Float", "double", "Long Double", "Far Double", 2);
        addQuestion(q5);
        Question q6 = new Question("Is the following statement a declaration or definition?  =>extern int i;", "Declaration", "Definition", "Function", "Error", 1);
        addQuestion(q6);
        Question q7 = new Question(" The KeyWord 'break' cannot be simply used within ?", "do-While", "if-else", "for", "while", 2);
        addQuestion(q7);
        Question q8 = new Question(" Which keyword is used to come out of a loop only for that iterator ?", "break", "continue", "return", "none of the mentioned", 2);
        addQuestion(q8);
        Question q9 = new Question("Array index start with ?", "2", "-1", "1", "0", 4);
        addQuestion(q9);
        Question q10 = new Question("How to round-off a value “5.77” to 6.0?", " ceil(5.77)", "round-off(5.77)", "round-up(5.77)", "floor(5.77)", 1);
        addQuestion(q10);

    }

    private void addQuestion(Question question) {

        ContentValues cv = new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionTable.TABLE_NAME, null, cv);
    }

    public List<Question> getAllQue() {

        List<Question> queList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));
                queList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return queList;
    }
}
