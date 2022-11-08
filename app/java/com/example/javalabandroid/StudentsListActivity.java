package com.example.javalabandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StudentsListActivity extends AppCompatActivity {
    public static final String GROUP_NUMBER = "groupnumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_list);

        Intent intent = getIntent();
        String grpNumber = intent.getStringExtra(GROUP_NUMBER);
        ListView listView = (ListView) findViewById(R.id.studentsList);
        ArrayAdapter<Student> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Student.getStudents()
                );
        listView.setAdapter(adapter);
    }
    public void onSendBtnClick(View view){

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT,"Список студентів");
        startActivity(intent);
    }

}