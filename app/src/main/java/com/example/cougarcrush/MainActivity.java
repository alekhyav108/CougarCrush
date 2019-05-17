package com.example.cougarcrush;

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
    String name, hobby1, hobby2, hobby3, birth;
    int grade, age;

    EditText myName;
    EditText myGrade;
    EditText myAge;
    EditText myHobby1;
    EditText myHobby2;
    EditText myHobby3;
    EditText myBirth;

    Button submit;


    private TextView mTextMessage;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //bottom navigation code
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

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
        myBirth = (EditText) findViewById(R.id.myBirth);


        //submit button code
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = myName.getText().toString();
                hobby1 = myHobby1.getText().toString();
                hobby2 = myHobby2.getText().toString();
                hobby3 = myHobby3.getText().toString();
                birth = myBirth.getText().toString();
                age = Integer.valueOf(myAge.getText().toString());
                grade = Integer.valueOf(myGrade.getText().toString());


                showToast(name);
                showToast(hobby1);
                showToast(hobby2);
                showToast(hobby3);
                showToast(birth);
                showToast(String.valueOf(age));
                showToast(String.valueOf(grade));

            }
        });

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
