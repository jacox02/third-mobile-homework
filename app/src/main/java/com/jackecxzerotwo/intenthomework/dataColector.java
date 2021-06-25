package com.jackecxzerotwo.intenthomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class dataColector extends AppCompatActivity {
    // If 1 = Male, 2 = Female
    Integer gender = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_colector);

        EditText userName = findViewById(R.id.user_name);
        Button maleRadioButton = findViewById(R.id.radioMale);
        Button femaleRadioButton = findViewById(R.id.radioFemale);
        String name = userName.getText().toString();
        Integer gender = 1;
        if (maleRadioButton.isPressed()){
            maleRadioButton.setEnabled(false);
            gender = 1;
        } else if(femaleRadioButton.isPressed()) {
            femaleRadioButton.setEnabled(false);
            Log.d(
                    "FUNCTION GENDER", "MUJER"
            );
            gender = 2;
        }
    }
    public void sendInformation(View view){
       EditText nameEdit = findViewById(R.id.user_name);
       String userName = "";
       userName = nameEdit.getText().toString();

       Intent nextView = new Intent(this, buttonsActivity.class);
       nextView.putExtra("UserName", userName);
       nextView.putExtra("Genero", gender);
       startActivity(nextView);
    }
    public void changeGenderToMale(View view){
        gender = 1;
        Log.d("Actual Gender: ", gender.toString());
    }
    public void changeGenderToFemale(View view){
        gender = 2;
        Log.d("Actual Gender: ", gender.toString());
    }
    public void getBack(View view){
        Intent mainView =  new Intent(this, MainActivity.class);
        startActivity(mainView);
    }
}