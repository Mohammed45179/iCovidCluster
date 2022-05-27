package com.example.icovidclusterpredictor;

import android.content.Intent;
import android.os.Bundle;

import com.example.icovidclusterpredictor.data.LoginDataSource;
import com.example.icovidclusterpredictor.data.model.LoggedInUser;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button createProfile = findViewById(R.id.create_profile);
        createProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoggedInUser user= LoginDataSource.getLoggedInUser();
                // get user details
                EditText name = findViewById(R.id.name);
                EditText city = findViewById(R.id.city);
                EditText suburb = findViewById(R.id.suburb);
                EditText postcode = findViewById(R.id.area_code);
                RadioGroup shreProfileGroupId = findViewById(R.id.shreProfileGroup);
                int selectedOption = shreProfileGroupId.getCheckedRadioButtonId();
                RadioButton radioGenderButton = findViewById(selectedOption);

                try {
                    user.setName(name.getText().toString());
                    user.setCity(city.getText().toString());
                    user.setSuburb(suburb.getText().toString());
                    user.setShredInfo(radioGenderButton.getText().toString());
                    Toast.makeText(getApplicationContext(), "User Profile Updated", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), ShowAreas.class);
                    startActivity(intent);

                }
                catch(Exception ex) {
                    Toast.makeText(getApplicationContext(), "Error in Profile Update", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
