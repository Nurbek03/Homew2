package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity2 extends AppCompatActivity {
    private ImageView imageView;
    public static final String h = "j";
    public static final int f = 1;
    private EditText editText;
    private Uri i;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText = findViewById(R.id.edtext1);
        imageView = findViewById(R.id.imageview3);
        button = findViewById(R.id.btn2);
        button.setOnClickListener(v -> {
            Intent intent = getIntent();
            intent.putExtra("text", editText.getText().toString());
            intent.putExtra(h, i);
            setResult(RESULT_OK, intent);
            finish();
        });
        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, f);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case f:
                if (resultCode == RESULT_OK) {
                    try {
                        i = data.getData();
                        final InputStream inputStream = getContentResolver().openInputStream(i);
                        final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                        imageView.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
        }
    }
}