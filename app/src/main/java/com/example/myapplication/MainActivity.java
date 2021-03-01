package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    public static int sa = 1;
    private String t;
    private Button button, btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.ImView);
        button = findViewById(R.id.btn);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivityForResult(intent, sa);
        });
        btn = findViewById(R.id.btn4);
        btn.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/html");
            intent.putExtra(Intent.EXTRA_EMAIL, "nurbekalikulov003@gmail.com");
            intent.putExtra(Intent.EXTRA_SUBJECT, "mdam");
            intent.putExtra(Intent.EXTRA_TEXT, "mdammdam");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(Intent.createChooser(intent, "Отправить на почту"));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == sa && resultCode == Activity.RESULT_OK && data != null) {
            imageView.setImageURI(data.getParcelableExtra(MainActivity2.h));
            t = data.getStringExtra("mail");
        }
    }
}