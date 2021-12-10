package com.example.killer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    EditText userName,email,password,confirmPassword;
    Button signUpBtn;
    TextView logInBtn;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth=FirebaseAuth.getInstance();
        userName=findViewById(R.id.inputUserName);
        email=findViewById(R.id.inputEmail);
        password=findViewById(R.id.inputPassword);
        confirmPassword=findViewById(R.id.inputConfirmPassword);
        progressDialog=new ProgressDialog(this);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerformAuth();
            }
        });

        //this will be changing Class from SignUp to LogIn Button
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this,LogInPage.class));
            }
        });
    }

    private void PerformAuth(){
        String emailId=email.getText().toString();
        String pass=password.getText().toString();
        String passConfirm=confirmPassword.getText().toString();

        if(!emailId.matches(emailPattern)){
            email.setError("Enter The Correct Email-Address...");
        }else if(pass.isEmpty() || pass.length()<6){
            password.setError("Enter The Corrrect Password...");
        }else if(pass.equals(confirmPassword)){
            confirmPassword.setError("Password Does Not Match...");
        }else{
            progressDialog.setMessage("Wait While Regestring...");
            progressDialog.setTitle("Registring...");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
        }

    }
}