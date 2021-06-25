package com.jackecxzerotwo.intenthomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class buttonsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons_activity);

        String userName = getIntent().getStringExtra("UserName");
        Integer gender = getIntent().getIntExtra("Genero", 1);

        TextView nombreView = findViewById(R.id.NOMBRE);
        TextView genderView = findViewById(R.id.GENDER);


        if(gender == 1){
            genderView.setText("Genero: Masculino");
        }else{
            genderView.setText("Genero: Femenino");
        }

        nombreView.setText("Su nombre es: " + userName);
    }
    public void seeImage(View view){
        Random rn = new Random();
        Integer random = rn.nextInt(5)+1;
        Log.d("Numero", random.toString());

        String userName = getIntent().getStringExtra("UserName");
        Integer gender = getIntent().getIntExtra("Genero", 1);
        Intent imageView = new Intent(this, ImageActivity.class);

        imageView.putExtra("UserName", userName);
        imageView.putExtra("ImageNumber", random);
        imageView.putExtra("Genero", gender);

        startActivity(imageView);
    }
    public void salir(View view){
        finish();
    }
    public void backToDataColectorButton(View view){
        Intent dataColectorView = new Intent(this, dataColector.class);
        startActivity(dataColectorView);
    }
}