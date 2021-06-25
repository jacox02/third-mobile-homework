package com.jackecxzerotwo.intenthomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageActivity extends AppCompatActivity {
    Integer ImageNumber = 1;
    Integer Gender = 1;
    String UserName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);


        TextView nameView = findViewById(R.id.userNameView);
        TextView genderView = findViewById(R.id.userGenderView);

        nameView.setText("Su nombre es: "+ UserName);
        if(Gender == 1){
            genderView.setText("Y su genero es: Masculino");
        }else{
            genderView.setText("Y su genero es: Femenino");
        }
        ImageNumber =  getIntent().getIntExtra("ImageNumber", 1);
        Gender = getIntent().getIntExtra("Genero", 1);
        UserName = getIntent().getStringExtra("UserName");
        setImage();
    }
    public void setImage(){
       ImageView imageSetter =  findViewById(R.id.imageView);
        if (Gender == 1){
            int id = getResources().getIdentifier("com.jackecxzerotwo.intenthomework:drawable/men_" + ImageNumber, null, null);
            imageSetter.setImageResource(id);
        } else if(Gender == 2){
            int id = getResources().getIdentifier("com.jackecxzerotwo.intenthomework:drawable/women_" + ImageNumber, null, null);
            imageSetter.setImageResource(id);
        }
    }
    public void getBack(View view){
        Intent getBackToButtons = new Intent(this, buttonsActivity.class);
        getBackToButtons.putExtra("UserName", UserName);
        getBackToButtons.putExtra("Genero", Gender);
        startActivity(getBackToButtons);
    }

    public void exit(View view){

    }
}