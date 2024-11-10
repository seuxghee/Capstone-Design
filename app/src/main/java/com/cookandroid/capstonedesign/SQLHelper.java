package com.cookandroid.capstonedesign;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "userDB.db";
    private static final int DATABASE_VERSION = 1;

    // 테이블 컬럼 정의
    private static final String TABLE_USER = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_BIRTH = "birth";
    private static final String COLUMN_GENDER = "gender";


    public SQLHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
                + COLUMN_ID +  " TEXT PRIMARY KEY,"
                + COLUMN_EMAIL + " TEXT,"
                + COLUMN_PASSWORD + " TEXT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_BIRTH + " INTEGER,"
                + COLUMN_GENDER + " TEXT"
                + ")";
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }
    // id 중복 확인 메서드
    public boolean isUserIdExists(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USER,
                new String[]{COLUMN_ID},
                COLUMN_ID + " = ?",
                new String[]{id},
                null, null, null);

        boolean exists = (cursor.getCount() > 0); // 중복 여부 확인
        cursor.close();
        db.close();
        return exists;
    }
    // 이메일 중복 확인 메서드
    public boolean isEmailExists(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USER,
                new String[]{COLUMN_EMAIL},
                COLUMN_EMAIL + " = ?",
                new String[]{email},
                null, null, null);

        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        db.close();
        return exists;
    }

    // 회원 정보 삽입 메서드 (추가된 필드 포함)
    public void insertUser(String id, String email, String password, String name, String birth, String gender) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, id);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PASSWORD, password);
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_BIRTH, birth);
        values.put(COLUMN_GENDER, gender);


        db.insert(TABLE_USER, null, values);
        db.close();
    }

    // 이메일과 비밀번호 확인 메서드
    public boolean checkUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_USER + " WHERE " + COLUMN_ID + " = ? AND " + COLUMN_PASSWORD + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{email, password});

        if (cursor != null && cursor.moveToFirst()) {
            cursor.close();
            return true; // 일치하는 사용자 존재
        } else {
            return false; // 사용자 불일치
        }
    }
}
