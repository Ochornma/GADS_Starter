package com.promise.gadsbooks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class SignInActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 2;

    String email;
    String password;

    private ProgressBar progressBar;
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Objects.requireNonNull(getSupportActionBar()).setTitle("SIGN IN");

        Button submit = findViewById(R.id.submit);
        Button forgetPassword = findViewById(R.id.forget_password);
        SignInButton signInButton = findViewById(R.id.google_sign_in);
        TextInputEditText emailInput = findViewById(R.id.email_input);
        TextInputEditText passwordInput = findViewById(R.id.password_input);
        cardView = findViewById(R.id.cardView);
        progressBar = findViewById(R.id.progress_circular);
        signInButton.setSize(SignInButton.SIZE_STANDARD);


        /*
         * submit is for email and password authentication
         * */

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                cardView.setVisibility(View.GONE);
                email = Objects.requireNonNull(emailInput.getText()).toString();
                password = Objects.requireNonNull(passwordInput.getText()).toString();
                if (!email.isEmpty() && !password.isEmpty()){

                } else {
                    Toast.makeText(SignInActivity.this, "Fill the forms", Toast.LENGTH_SHORT).show();
                }
            }
        });


        /*
         * signInButton is for google sign in
         * */
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                cardView.setVisibility(View.GONE);

            }
        });

        /*
         * reset password
         * */

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = Objects.requireNonNull(emailInput.getText()).toString();
                if (!email.isEmpty()){

                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.


        } else {
            progressBar.setVisibility(View.GONE);
            cardView.setVisibility(View.VISIBLE);
            Toast.makeText(SignInActivity.this, " Failed", Toast.LENGTH_LONG).show();
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {

    }
}