package com.example.assingment10;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btnAddUser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddUserActivity();
            }
        });

        findViewById(R.id.btnListUsers).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListUserActivity();
            }
        });
    }

    private void openAddUserActivity() {
        Intent intent = new Intent(this, AddUserActivity.class);
        startActivity(intent);
    }


    private void openListUserActivity() {
        Intent intent = new Intent(this, ListUserActivity.class);
        startActivity(intent);
    }
}
