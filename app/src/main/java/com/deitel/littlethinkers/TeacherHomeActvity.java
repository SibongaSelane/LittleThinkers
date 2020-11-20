package com.deitel.littlethinkers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TeacherHomeActvity extends AppCompatActivity {

    Button btnLogout;

    TextView txtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_home_actvity);

        btnLogout = findViewById(R.id.btnLogout);
        txtUsername = findViewById(R.id.txtUsername);


        // Method
        Logout();
        DisplayUserName();

    }

    // Displays the users name and surname in the home page
    /**
     * REFERENCE
     * Video - https://youtu.be/eGWu0-0TWFI
     **/
    public void DisplayUserName(){
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String surname = intent.getStringExtra("surname");

        txtUsername.setText(name + " " + surname);
    }

    // Method - redirects the user to the login screen
    public void Logout(){

        // When the user clicks on the text -- the login page will open
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginInt = new Intent(TeacherHomeActvity.this, LoginActivity.class);
                startActivity(loginInt);
            }
        });
    }
}