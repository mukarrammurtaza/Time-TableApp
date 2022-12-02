package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class addTaskActivity extends AppCompatActivity {
    Context context;
    public static ArrayList<task> taskList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context=getApplicationContext();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addtask);
        EditText courseName = findViewById(R.id.courseName);
        EditText courseID = findViewById(R.id.courseID);
        EditText taskTitle = findViewById(R.id.taskTitle);
        EditText dueDate = findViewById(R.id.dueDate);
        EditText dueTime = findViewById(R.id.dueTime);

        Intent intent = getIntent();
        String cname = intent.getStringExtra("courseName");
        String cid = intent.getStringExtra("courseId");




        courseName.setText(cname);
        courseID.setText(cid);
        Button saveButton=findViewById(R.id.save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cName = courseName.getText().toString();
                String cid = (courseID.getText().toString());
                String taskT = taskTitle.getText().toString();
                String dd = dueDate.getText().toString();
                String dt = dueTime.getText().toString();
                int ncid = Integer.parseInt(cid);
                task task =new task(ncid,cName,taskT,dd,dt);
                taskList.add(task);
                Toast toast=Toast. makeText(getApplicationContext(),"task added successfully",Toast. LENGTH_SHORT);
                toast. show();
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public  ArrayList<task> getTaskList(){
        return taskList;
    }
}