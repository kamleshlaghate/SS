package com.example.hp.ss;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DatabaseHelper extends SQLiteOpenHelper implements BaseColumns {
         /* this class should be implemented */

    SQLiteDatabase db;
    private static  final  int DATABASE_VERSION=1;
    private static  final String DATABASE_NAME="Login.db";
    private static  final String TABLE_NAME="contacts";
    private static  final String COLUMN_UNAME="uname";
    private static  final String COLUMN_PASS="pass";


    public DatabaseHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "("+_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ COLUMN_UNAME + " text not null ," + COLUMN_PASS + " text not null )");
        this.db=db;
    }

    public  void insertToDb(Contact c) {

        db=this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_UNAME,c.getUsername());
        values.put(COLUMN_PASS,c.getPassword());

        db.insert(TABLE_NAME,null,values);


    }
    public String searchPassword(String username){

        db = this.getReadableDatabase();
        String query="select uname,pass from "+TABLE_NAME;

        Cursor cursor =db.rawQuery(query,null);

        String u,p="Not Found";          //u=username(index 0), p=password(index 1)

        if (cursor.moveToFirst())
        {

            do{
                u = cursor.getString(0);

                if(u.equals(username))
                {

                    p = cursor.getString(1);
                }
            }while(cursor.moveToNext());
        }
       // cursor.close();

            return p;
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String Query="drop table if exists "+TABLE_NAME;
        db.execSQL(Query);
        this.onCreate(db);
    }




}
