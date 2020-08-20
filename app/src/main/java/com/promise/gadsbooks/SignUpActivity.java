package com.promise.gadsbooks;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;

import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;
import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN = 1;
    private static final int PERMISSION_CODE = 2;
    private static final int REQUEST_CODE = 3;
    Uri imageurl;
    private ImageView imageView;

    String email;
    String password;
    String name;

    private TextInputEditText nameInput;
    private ProgressBar progressBar;
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Objects.requireNonNull(getSupportActionBar()).setTitle("SIGN UP");

        Button submit = findViewById(R.id.submit);
        Button imageSelect = findViewById(R.id.select_pics);
        SignInButton signInButton = findViewById(R.id.google_sign_up);
        TextInputEditText emailInput = findViewById(R.id.email_input);
        TextInputEditText passwordInput = findViewById(R.id.password_input);
        nameInput = findViewById(R.id.name_input);
        imageView = findViewById(R.id.profile_image);
        cardView = findViewById(R.id.cardView);
        progressBar = findViewById(R.id.progress_circular);
        signInButton.setSize(SignInButton.SIZE_STANDARD);



        /*
         * submit is for email and password authentication
         * */
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = Objects.requireNonNull(emailInput.getText()).toString();
                password = Objects.requireNonNull(passwordInput.getText()).toString();
                name = Objects.requireNonNull(nameInput.getText()).toString();
                if (!email.isEmpty() && !password.isEmpty() && !name.isEmpty() && imageurl != null){

                } else {
                    Toast.makeText(SignUpActivity.this, " Fill in the forms", Toast.LENGTH_LONG).show();
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

        imageSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseImage();
            }
        });
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {

        //Objects.requireNonNull(auth.getCurrentUser()).getDisplayName();
    }

    private void chooseImage(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PermissionChecker.PERMISSION_DENIED) {
                String[] permission = {Manifest.permission.READ_EXTERNAL_STORAGE};
                requestPermissions(permission, PERMISSION_CODE);
            } else {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQUEST_CODE);
            }
        } else {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(intent, REQUEST_CODE);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach

        } else if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null){
            imageurl = data.getData();
            Bitmap bitmap;
            try {
                if (  Build.VERSION.SDK_INT < 28) {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageurl);
                } else {
                    ImageDecoder.Source source = ImageDecoder.createSource(getContentResolver(),imageurl);
                    bitmap = ImageDecoder.decodeBitmap(source);
                }
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else  {
            progressBar.setVisibility(View.GONE);
            cardView.setVisibility(View.VISIBLE);
            Toast.makeText(SignUpActivity.this, " Failed", Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_CODE) {
            if (grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQUEST_CODE);
            }else {
                Toast.makeText(this, "Permission Not Granted", Toast.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}