package com.promise.gadsbooks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.Objects;

public class AuthActivity  extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        Objects.requireNonNull(getSupportActionBar()).setTitle("AUTHENTICATION");
        Button login = findViewById(R.id.login);
        Button signup = findViewById(R.id.signup);
        login.setOnClickListener(this);
        signup.setOnClickListener(this);
        authListenerSetUp();
    }

    private void authListenerSetUp() {

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        if (view.getId() == R.id.login) {
            intent = new Intent(AuthActivity.this, SignInActivity.class);
        } else {
            intent = new Intent(AuthActivity.this, SignUpActivity.class);
        }
        startActivity(intent);
    }

    private boolean admin(String email){
        return email.substring(email.indexOf("@") + 1).toLowerCase(Locale.ROOT).equals("admin.com");
    }

}