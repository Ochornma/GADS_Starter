package com.promise.gadsbooks;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;

import java.util.Objects;

public class BookActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private SharedPreferences sharedpreferences;
    private SharedPreferences.Editor editor;
    private String PREFRENCES = "subscription";
    private SwitchCompat java, kotlin, firebase;
    private String javaSubscribe = "Java";
    private String kotlinSubscribe = "Kotlin";
    private String firebaseSubscribe = "Firebase";
    CardView cardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Objects.requireNonNull(getSupportActionBar()).setTitle("BOOK");
        cardView = findViewById(R.id.admin_card);
        boolean admin = getIntent().getBooleanExtra(Constant.admin, false);
        if (!admin){
            cardView.setVisibility(View.GONE);
        }
        sharedpreferences = getSharedPreferences(PREFRENCES, Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
        java = findViewById(R.id.java_subscribe);
        kotlin = findViewById(R.id.kotlin_subscribe);
        firebase = findViewById(R.id.firebase_subscribe);
        java.setChecked(sharedpreferences.getBoolean(javaSubscribe, false));
        kotlin.setChecked(sharedpreferences.getBoolean(kotlinSubscribe, false));
        firebase.setChecked(sharedpreferences.getBoolean(firebaseSubscribe, false));
        java.setOnCheckedChangeListener(this);
        kotlin.setOnCheckedChangeListener(this);
        firebase.setOnCheckedChangeListener(this);
        authListenerSetUp();
    }

    public void viewBooks(View view) {
        Intent intent = new Intent(BookActivity.this, SpecificBookActivity.class);
        int id = view.getId();
        String extra = " ";
        switch (id){
            case R.id.button_java:
                extra = javaSubscribe;
                intent.putExtra(Constant.extra, extra);
                startActivity(intent);
                break;
            case  R.id.button_kotlin:
                extra = kotlinSubscribe;
                intent.putExtra(Constant.extra, extra);
                startActivity(intent);
                break;
            case R.id.button_firebase:
                extra = firebaseSubscribe;
                intent.putExtra(Constant.extra, extra);
                startActivity(intent);
                break;
            case R.id.button_android:
                Intent intentAndroid = new Intent(BookActivity.this, BookViewActivity.class);
                startActivity(intentAndroid);
                break;
            case R.id.button_admin:
                Intent intentAdmin = new Intent(BookActivity.this, AdminActivity.class);
                startActivity(intentAdmin);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + id);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.profile){
            Intent intent = new Intent(BookActivity.this, ProfileActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        int id = compoundButton.getId();
        switch (id){
            case R.id.java_subscribe:

                switchCheck(b, javaSubscribe);
                break;
            case R.id.kotlin_subscribe:
                switchCheck(b, kotlinSubscribe);
                break;
            case  R.id.firebase_subscribe:
                switchCheck(b, firebaseSubscribe);
        }


    }

    private void switchCheck(boolean check, String topic){
        if (check){

        } else {

        }
        editor.putBoolean(topic, check);
        editor.apply();
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
}