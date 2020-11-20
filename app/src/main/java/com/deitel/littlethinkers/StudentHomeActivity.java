package com.deitel.littlethinkers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentHomeActivity extends AppCompatActivity {

    Button btnLogout, btnArrow, btnArrow1;

    ConstraintLayout expandableView, expandableView1;

    CardView Shapes, Numbers, cardView, cardView1;

    TextView txtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);

        btnLogout = findViewById(R.id.btnLogout);

        btnArrow = findViewById(R.id.btnArrow);
        btnArrow1 = findViewById(R.id.btnArrow1);

        expandableView = findViewById(R.id.expandable);
        expandableView1 = findViewById(R.id.expandable1);

        Numbers = findViewById(R.id.btnNumbers);
        Shapes = findViewById(R.id.btnShapes);
        cardView = findViewById(R.id.cardView);
        cardView1 = findViewById(R.id.cardView1);

        txtUsername = findViewById(R.id.txtUsername);

        // Method
        Logout();
        DisplayUserName();
        ArrowClickEM();
        ArrowClickMD();
        MoveToNumbersPage();
        MoveToShapesPage();
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

    public void ArrowClickEM(){
        btnArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(expandableView.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.VISIBLE);
                    btnArrow.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                }
                else{
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.GONE);
                    btnArrow.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                }
            }
        });

    }

    public void ArrowClickMD(){
        btnArrow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(expandableView1.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView1, new AutoTransition());
                    expandableView1.setVisibility(View.VISIBLE);
                    btnArrow1.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                }
                else{
                    TransitionManager.beginDelayedTransition(cardView1, new AutoTransition());
                    expandableView1.setVisibility(View.GONE);
                    btnArrow1.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                }
            }
        });

    }
    // Method - redirects the user to the login screen
    public void Logout(){

        // When the user clicks on the text -- the login page will open
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginInt = new Intent(StudentHomeActivity.this, LoginActivity.class);
                startActivity(loginInt);
            }
        });
    }


    // Method - redirects the user to numbers page
    public void MoveToNumbersPage() {
        // When the user clicks on the text -- the login page will open
        Numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginInt = new Intent(StudentHomeActivity.this, NumbersActivity.class);
                startActivity(loginInt);
            }
        });
    }


    // Method - redirects the user to shapes page
    public void MoveToShapesPage() {
        // When the user clicks on the text -- the login page will open
        Shapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginInt = new Intent(StudentHomeActivity.this, ShapesActivity.class);
                startActivity(loginInt);
            }
        });
    }
}