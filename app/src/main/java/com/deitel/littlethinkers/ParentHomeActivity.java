package com.deitel.littlethinkers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ParentHomeActivity extends AppCompatActivity {

    // Declaration of variables
    Button btnLogout, btnAddChild;

    TextView txtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_home);

        btnLogout = findViewById(R.id.btnLogout);
        btnAddChild = findViewById(R.id.btnAddChild);
        txtUsername = findViewById(R.id.txtUsername);


        // Methods
        Logout();
        AddChild();
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
                Intent loginInt = new Intent(ParentHomeActivity.this, LoginActivity.class);
                startActivity(loginInt);
            }
        });
    }

    // Method - redirects the user to the login screen
    public void AddChild(){

        // When the user clicks on the button -- the student registration page will open
        btnAddChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regInt = new Intent(ParentHomeActivity.this, StudRegistrationActivity.class);
                startActivity(regInt);
            }
        });
    }
}