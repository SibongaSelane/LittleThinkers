package com.deitel.littlethinkers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    // Textview
    TextView txtViewReg;

    // Input fields
    TextInputLayout txtUsername, txtPassword;

    // Button
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtViewReg = findViewById(R.id.txtViewReg);

        txtUsername = findViewById(R.id.username);
        txtPassword = findViewById(R.id.password);

        btnLogin = findViewById(R.id.btnLogin);

        // Calling of methods
        MoveToReg();
        LoginUser();

    }

    // Method - redirects the user to the login screen
    public void MoveToReg(){

        // When the user clicks on the text -- the registration page will open
        txtViewReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regInt = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(regInt);
            }
        });
    }


    /**
     * REFERENCE
     * Video - https://youtu.be/o9Y7HDkopHg
     **/

    // Username validation
    private Boolean validateUsername(){
        String val = txtUsername.getEditText().getText().toString();

        // If the user does not enter data for following message is displayed
        if (val.isEmpty()) {
            txtUsername.setError("Field required");
            return false;
        }
        else {
            // clears the fields once the user enters data
            txtUsername.setError(null);
            txtUsername.setErrorEnabled(false);
            return true;
        }
    }

    // Password validation
    private Boolean validatePassword(){
        String val = txtPassword.getEditText().getText().toString();

        // If the user does not enter data for following message is displayed
        if (val.isEmpty()) {
            txtPassword.setError("Field required");
            return false;
        }
        else {

            // clears the fields once the user enters data
            txtPassword.setError(null);
            txtPassword.setErrorEnabled(false);
            return true;
        }
    }


    public void LoginUser(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // IF -- the fields are empty the validation method will be executed
                if (!validateUsername() | !validatePassword()){
                    return;
                }
                // IF --  the fields contain input then the user data is checked
                else {
                    // Method -- checks user details entered
                    CheckLoginDetails();
                }
            }
        });
    }

    /**
     * REFERENCE
     * Video - https://youtu.be/eGWu0-0TWFI
     **/
    public void  CheckLoginDetails(){

        // Gets data entered
        final String EnteredUsername = txtUsername.getEditText().getText().toString().trim();
        final String EnteredPassword = txtPassword.getEditText().getText().toString().trim();

        // Calls the firebase database
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Registration Information");

        // Query - checks if the username matches the entered username
        Query checkUser = reference.orderByChild("username").equalTo(EnteredUsername);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                // IF statement - username exists continue by checking password and user type
                if(dataSnapshot.exists()){

                    txtUsername.setError(null);
                    txtUsername.setErrorEnabled(false);

                    // Retrieving password for a specific username and storing it in a variable
                    String passwordInDB = dataSnapshot.child(EnteredUsername).child("password").getValue(String.class);

                    // IF statement - password entered equals password in database continue
                    if(passwordInDB.equals(EnteredPassword)){

                        txtUsername.setError(null);
                        txtUsername.setErrorEnabled(false);

                        // Checks the user type stored for the specific username
                        String userTypeInDB = dataSnapshot.child(EnteredUsername).child("user_role").getValue(String.class);

                        // If the user is a parent, the following will be executed
                        if(userTypeInDB.equals("Parent")){

                            String nameInDB = dataSnapshot.child(EnteredUsername).child("name").getValue(String.class);
                            String surnameInDB = dataSnapshot.child(EnteredUsername).child("surname").getValue(String.class);
                            String DOBInDB = dataSnapshot.child(EnteredUsername).child("date_of_birth").getValue(String.class);
                            String contactNoInDB = dataSnapshot.child(EnteredUsername).child("contact_no").getValue(String.class);
                            String emailInDB = dataSnapshot.child(EnteredUsername).child("email").getValue(String.class);
                            String usernameInDB = dataSnapshot.child(EnteredUsername).child("username").getValue(String.class);

                            // Redirected the user to the parent home page
                            Intent intParent = new Intent(getApplicationContext(), ParentHomeActivity.class);

                            intParent.putExtra("name", nameInDB);
                            intParent.putExtra("surname", surnameInDB);
                            intParent.putExtra("date_of_birth", DOBInDB);
                            intParent.putExtra("contact_no", contactNoInDB);
                            intParent.putExtra("email", emailInDB);
                            intParent.putExtra("username", usernameInDB);
                            intParent.putExtra("password", passwordInDB);
                            intParent.putExtra("user_role", userTypeInDB);

                            startActivity(intParent);
                        }

                        // If the user is a teacher, the following will be executed
                        else if(userTypeInDB.equals("Teacher")){

                            String nameInDB = dataSnapshot.child(EnteredUsername).child("name").getValue(String.class);
                            String surnameInDB = dataSnapshot.child(EnteredUsername).child("surname").getValue(String.class);
                            String DOBInDB = dataSnapshot.child(EnteredUsername).child("date_of_birth").getValue(String.class);
                            String contactNoInDB = dataSnapshot.child(EnteredUsername).child("contact_no").getValue(String.class);
                            String emailInDB = dataSnapshot.child(EnteredUsername).child("email").getValue(String.class);
                            String usernameInDB = dataSnapshot.child(EnteredUsername).child("username").getValue(String.class);

                            // Redirects the user to the teacher home page
                            Intent intTeacher = new Intent(getApplicationContext(), TeacherHomeActvity.class);

                            intTeacher.putExtra("name", nameInDB);
                            intTeacher.putExtra("surname", surnameInDB);
                            intTeacher.putExtra("date_of_birth", DOBInDB);
                            intTeacher.putExtra("contact_no", contactNoInDB);
                            intTeacher.putExtra("email", emailInDB);
                            intTeacher.putExtra("username", usernameInDB);
                            intTeacher.putExtra("password", passwordInDB);
                            intTeacher.putExtra("user_role", userTypeInDB);

                            startActivity(intTeacher);
                        }

                        // If the user is a student, the following will be executed
                        else{
                            String nameInDB = dataSnapshot.child(EnteredUsername).child("name").getValue(String.class);
                            String surnameInDB = dataSnapshot.child(EnteredUsername).child("surname").getValue(String.class);
                            String DOBInDB = dataSnapshot.child(EnteredUsername).child("date_of_birth").getValue(String.class);
                            String contactNoInDB = dataSnapshot.child(EnteredUsername).child("contact_no").getValue(String.class);
                            String emailInDB = dataSnapshot.child(EnteredUsername).child("email").getValue(String.class);
                            String usernameInDB = dataSnapshot.child(EnteredUsername).child("username").getValue(String.class);

                            // Redirects the user to the student home page
                            Intent intStudent = new Intent(getApplicationContext(), StudentHomeActivity.class);

                            intStudent.putExtra("name", nameInDB);
                            intStudent.putExtra("surname", surnameInDB);
                            intStudent.putExtra("date_of_birth", DOBInDB);
                            intStudent.putExtra("contact_no", contactNoInDB);
                            intStudent.putExtra("email", emailInDB);
                            intStudent.putExtra("username", usernameInDB);
                            intStudent.putExtra("password", passwordInDB);
                            intStudent.putExtra("user_role", userTypeInDB);

                            startActivity(intStudent);
                        }
                    }

                    // If the password is incorrect the following message will be displayed
                    else {
                        txtPassword.setError("Incorrect password");
                        txtPassword.requestFocus();
                    }
                }

                // If the username does not exist in the database then the following message will be displayed
                else {
                    txtUsername.setError("User does not exist");
                    txtPassword.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}