package com.example.cougarcrush;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String name, hobby1, hobby2, hobby3, birth, phoneNum;
    int grade, age;

    EditText myName;
    EditText myGrade;
    EditText myAge;
    EditText myHobby1;
    EditText myHobby2;
    EditText myHobby3;

    Button submit;

    EditText myPhone;


    private TextView mTextMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //bottom navigation code
        setContentView(R.layout.activity_main);
        mTextMessage = findViewById(R.id.message);

        //spinner code
        Spinner spinner = (Spinner)findViewById(R.id.myGender);
        ArrayAdapter<CharSequence> genderAdap;
        genderAdap = ArrayAdapter.createFromResource(this, R.array.gender_types, android.R.layout.simple_spinner_item);
        genderAdap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(genderAdap);
        spinner.setOnItemSelectedListener(this);

        //text input code
        myName = (EditText) findViewById(R.id.myName);
        myHobby1 = (EditText) findViewById(R.id.myHobby1);
        myHobby2 = (EditText) findViewById(R.id.myHobby2);
        myHobby3 = (EditText) findViewById(R.id.myHobby3);
        myAge = (EditText) findViewById(R.id.myAge);
        myGrade = (EditText) findViewById(R.id.myGrade);
        myPhone = (EditText) findViewById(R.id.myPhone);



        //submit button code
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = myName.getText().toString();
                hobby1 = myHobby1.getText().toString();
                hobby2 = myHobby2.getText().toString();
                hobby3 = myHobby3.getText().toString();
                age = Integer.valueOf(myAge.getText().toString());
                grade = Integer.valueOf(myGrade.getText().toString());
                phoneNum = myPhone.getText().toString();


                showToast(name);
                showToast(hobby1);
                showToast(hobby2);
                showToast(hobby3);
                showToast(String.valueOf(age));
                showToast(String.valueOf(grade));
                showToast(phoneNum);


            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //opens AboutYou
                openAboutYou();

            }
        });

    }

    public void openAboutYou() {
        Intent intent = new Intent(MainActivity.this, AboutYou.class);
        startActivity(intent);

    }


    private void showToast(String text){
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }




}
