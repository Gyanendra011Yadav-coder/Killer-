package com.example.killer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LogInPage extends AppCompatActivity {
    TextView forgetPassword, signUp;
    EditText userName,password;
    Button logIn;
    FloatingActionButton googleBtn,facebookBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_page);

        //Assigning Values To The Initialised Variables
        forgetPassword=findViewById(R.id.forgotPasswordButton);
        signUp =findViewById(R.id.signUpTextView);
        userName=findViewById(R.id.inputUserName);
        password=findViewById(R.id.password);
        logIn=findViewById(R.id.logInButton);
        googleBtn=findViewById(R.id.fab_google);
        facebookBtn=findViewById(R.id.fab_fb);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, pass;
                email = userName.getText().toString();
                pass = password.getText().toString();


            }
        });



        //This Code Is for Changing The Activity for Sign-Up.
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LogInPage.this, "Moving To SignUp", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LogInPage.this, SignUpActivity.class));
            }
        });
    }
}