package com.example.assingment10;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListUserActivity extends AppCompatActivity {
    RecyclerView rvUserView;
    ListUserInRecycleViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        rvUserView = findViewById(R.id.rvUserView);
        rvUserView.setLayoutManager(new LinearLayoutManager(this));

        List<User> userList = UserStorage.getInstance().getUsers();

        // Järjestä käyttäjät sukunimen mukaan aakkosjärjestykseen
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return user1.getLastName().compareToIgnoreCase(user2.getLastName());
            }
        });

        adapter = new ListUserInRecycleViewAdapter(userList);
        rvUserView.setAdapter(adapter);
    }
}
