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

        TextView GENDERNAMETXT = findViewById(R.id.GENDERNAME);
        EditText userName = findViewById(R.id.user_name);
        Button maleRadioButton = findViewById(R.id.radioMale);
        Button femaleRadioButton = findViewById(R.id.radioFemale);
        TextView NAMETEXT = findViewById(R.id.TEXTNAME);

        String name = userName.getText().toString();
        Integer gender = 1;

        Log.d("FUNCTION", "SEND INFORMATION");

        if (maleRadioButton.isPressed()){
            maleRadioButton.setEnabled(false);
            gender = 1;
            GENDERNAMETXT.setText("HOMBRE");
            Log.d(
                    "FUNCTION GENDER", "HOMBRE"
            );
        } else if(femaleRadioButton.isPressed()) {
            femaleRadioButton.setEnabled(false);
            Log.d(
                    "FUNCTION GENDER", "MUJER"
            );
            GENDERNAMETXT.setText("MUJER");
            gender = 2;
        }
    }
    public void sendInformation(View view){
       EditText nameEdit = findViewById(R.id.user_name);
       TextView nameTxt = findViewById(R.id.TEXTNAME);
       TextView genderTxt = findViewById(R.id.GENDERNAME);
       String userName = "";
       userName = nameEdit.getText().toString();

       if(gender == 1){
           genderTxt.setText("Genero: Masculino");
       }else{
           genderTxt.setText("Genero: Femenino");
       }

       nameTxt.setText("Su nombre es: " + nameEdit.getText());

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