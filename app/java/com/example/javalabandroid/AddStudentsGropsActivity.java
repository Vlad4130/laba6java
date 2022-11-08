package com.example.javalabandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudentsGropsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_students_grops);
    }

    public void onGrpAddClick(View view){
        EditText number = (EditText) findViewById(R.id.txtGrpNumber2);
        EditText faculty = (EditText) findViewById(R.id.facultyEdit2);
        SQLiteOpenHelper sqLiteOpenHelper = new StudentsDatabaseHelper(this);
        try{
            SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("number",number.getText().toString());
            contentValues.put("faculty",faculty.getText().toString());
            contentValues.put("educationLevel",0);
            contentValues.put("contractExistsFlg",0);
            contentValues.put("privilegeExistsFlg",0);
            db.insert("groups",null,contentValues);
            db.close();
            NavUtils.navigateUpFromSameTask(this);
        }
        catch (SQLiteException e)
        {
            Toast toast = Toast.makeText(this,"Database unavailable",Toast.LENGTH_SHORT);
            toast.show();
        }


    }
}