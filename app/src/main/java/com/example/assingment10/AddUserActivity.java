package com.example.assingment10;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class AddUserActivity extends AppCompatActivity {

    EditText editFirstName, editLastName, editEmail;
    Button addUserButton;
    RadioGroup radioDegreeProgram;
    RadioButton seRadioButton, imRadioButton, ceRadioButton, eeRadioButton;
    CheckBox bcCheckBox, msCheckBox, lciCheckBox, phdCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        // Näkymä komponenttien alustus
        editFirstName = findViewById(R.id.editFirstName);
        editLastName = findViewById(R.id.editLastName);
        editEmail = findViewById(R.id.editEmail);
        addUserButton = findViewById(R.id.addUserButton);
        radioDegreeProgram = findViewById(R.id.radioDegreeProgram);
        seRadioButton = findViewById(R.id.seRadioButton);
        imRadioButton = findViewById(R.id.imRadioButton);
        ceRadioButton = findViewById(R.id.ceRadioButton);
        eeRadioButton = findViewById(R.id.eeRadioButton);
        bcCheckBox = findViewById(R.id.bcCheckBox);
        msCheckBox = findViewById(R.id.msCheckBox);
        lciCheckBox = findViewById(R.id.lciCheckBox);
        phdCheckBox = findViewById(R.id.phdCheckBox);

        // Listener käyttäjän lisäämiselle
        addUserButton.setOnClickListener(view -> addUser());
    }

    // Metodi tallentaa käyttäjälistan tiedostoon
    private void saveUserList(List<User> userList) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(getFilesDir() + "/users.data"));
            outputStream.writeObject(userList);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Metodi lataa käyttäjälistan tiedostosta
    private List<User> loadUserList() {
        List<User> userList = new ArrayList<>();
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(getFilesDir() + "/users.data"));
            userList = (ArrayList<User>) inputStream.readObject();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    // Metodi lisää käyttäjän ja päivittää käyttäjälistan
    private void addUserAndUpdateList(User user) {
        List<User> userList = loadUserList();
        userList.add(user);
        saveUserList(userList);
        UserStorage.getInstance().addUser(user); // Lisää käyttäjä myös UserStorageen
    }


    // Metodi lisää käyttäjän
    private void addUser() {
        String firstName = editFirstName.getText().toString();
        String lastName = editLastName.getText().toString();
        String email = editEmail.getText().toString();
        String degreeProgram = getSelectedDegreeProgram();
        String userDegree = getSelectedUserDegree(); // Lisätty tutkinnon tason haku

        User user = new User(firstName, lastName, email, degreeProgram, userDegree);
        // Lisätty tutkinnon taso konstruktorin parametriin
        addUserAndUpdateList(user);
        finish();
    }

    // Metodi palauttaa valitun tutkinto-ohjelman ja tutkintotason
    private String getSelectedDegreeProgram() {
        StringBuilder selectedProgram = new StringBuilder();

        // Tutkinto-ohjelman valinta
        int checkedDegreeId = radioDegreeProgram.getCheckedRadioButtonId();
        if (checkedDegreeId != -1) {
            RadioButton radioButton = findViewById(checkedDegreeId);
            selectedProgram.append(radioButton.getText().toString());
        }

        return selectedProgram.toString();
    }

    private String getSelectedUserDegree() {
        StringBuilder degreeBuilder = new StringBuilder();
        if (phdCheckBox.isChecked()) {
            degreeBuilder.append("Doctoral degree, ");
        }
        if (lciCheckBox.isChecked()) {
            degreeBuilder.append("Licenciate, ");
        }
        if (msCheckBox.isChecked()) {
            degreeBuilder.append("M.Sc. degree, ");
        }
        if (bcCheckBox.isChecked()) {
            degreeBuilder.append("B.Sc. degree, ");
        }

        if (degreeBuilder.length() > 0) {
            degreeBuilder.delete(degreeBuilder.length() - 2, degreeBuilder.length());
        }
        return degreeBuilder.toString();
    }

}


