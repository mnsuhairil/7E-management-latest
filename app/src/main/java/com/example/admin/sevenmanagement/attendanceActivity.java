package com.example.admin.sevenmanagement;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class attendanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
    }

    public void gotoclockin(View view) {
        Intent intent = new Intent(this,clockinActivity.class);
        startActivity(intent);
    }
    public void gotoclockout(View view) {
        Intent intent = new Intent(this,clockoutActivity.class);
        startActivity(intent);
    }
}