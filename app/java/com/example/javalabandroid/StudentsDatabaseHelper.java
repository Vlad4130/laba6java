package com.example.javalabandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class StudentsDatabaseHelper extends SQLiteOpenHelper {
    private static String DB_NAME = "students";
    private static int DB_VERSIONS = 2;

    public StudentsDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSIONS);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlText = "CREATE TABLE Groups (\n"+
                "id INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
                "number TEXT (10) NOT NULL,\n " +
                "facultyName TIME(100),\n" +
                "educationLevel INTEGER,\n" +
                "contractExistsFlg BOOLEAN,\n" +
                "privilegeExistsFlg BOOLEAN\n" +
                ");";
        sqLiteDatabase.execSQL(sqlText);

        updateShema(sqLiteDatabase,0);

        populateDB(sqLiteDatabase);
    }

    private void populateDB(SQLiteDatabase db) {
       populateGroups(db);
       populateStudents(db);
    }
    private void populateGroups(SQLiteDatabase db) {
        for (Groups groups:Groups.getGroups()){
            insertRowToGroup(db,groups);
        }
    }
    private void populateStudents(SQLiteDatabase db) {
        for (Student student:Student.getStudents()){
            insertRowToStudent(db,student);
        }
    }

    private void insertRowToGroup(SQLiteDatabase db, Groups groups) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("number", groups.getNumber());
        contentValues.put("facultyName",groups.getFacultyName());
        contentValues.put("educationLevel",groups.getEducationLevel());
        contentValues.put("contractExistsFlg",groups.isContractExistsFlg());
        contentValues.put("privilegeExistsFlg",groups.isPrivilegeExistsFlg());
        db.insert("Groups",null,contentValues);
    }

    private void insertRowToStudent(SQLiteDatabase db, Student student){
        db.execSQL("insert into students(name,group_id)\n"+
                "select '"+student.getName()+"', id\n"+
                "from groups\n"+
                "where number='"+student.getGroupNumber()+"'");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldV, int newV) {
updateShema(sqLiteDatabase,oldV);
    }
    private void updateShema(SQLiteDatabase db, int oldV){
        if (oldV > 2){
            db.execSQL("CREATE TABLE Students (\n"+
                    "id INTEGER PRIMARY KEY AUTOINCREMENT,\n"+
                    "name TEXT(100) NOT NULL,\n"+
                    "group_id INTEGER REFERENCES Groups (id) ON DELETE RESTRICT\n"+
                    "ON UPDATE RESTRICT\n"+
                    ");");
            populateStudents(db);
        }
    }
}
