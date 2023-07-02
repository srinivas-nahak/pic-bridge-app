package com.example.materialviewpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //private RecyclerView recyclerView;
    private Spinner spinner;
    private EditText editName, editEmail, editPassword, editRepass;
    private TextView errName, errEmail, errPass, errRePass,agreementText;
    private CheckBox agreeCheckbox;
    private Button pickImgBtn, registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaring all the views by a method
        declareViews();

        //Setting adapter and data to the spinner
        ArrayList<String> countryList = new ArrayList<>();
        countryList.add("India");
        countryList.add("Africa");
        countryList.add("America");
        countryList.add("Spain");

        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, countryList);

        spinner.setAdapter(adapter);

        //Showing the error message for edit Texts if they're empty on click
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateData()){

                    if(agreeCheckbox.isChecked()){

                        showSnackBar(view);
                    } else{
                        Toast.makeText(MainActivity.this, "You need to agree to our agreements.", Toast.LENGTH_SHORT).show();
                    }



                }

            }
        });


    }

    void declareViews() {
        //Declaring the Spinner
        spinner = findViewById(R.id.countrySpinner);

        //Declaring Edit Texts
        editName = findViewById(R.id.editTextPersonName);
        editEmail = findViewById(R.id.editTextEmailAddress);
        editPassword = findViewById(R.id.editTextPassword);
        editRepass = findViewById(R.id.editTextRepassword);

        //Declaring the Error Texts
        errName = findViewById(R.id.nameWarning);
        errEmail = findViewById(R.id.emailWarning);
        errPass = findViewById(R.id.passwordWarning);
        errRePass = findViewById(R.id.rePasswordWarning);

        //Declaring checkbox
        agreeCheckbox = findViewById(R.id.agreeCheckBox);

        //Declaring the Buttons
        pickImgBtn = findViewById(R.id.pickImgBtn);
        registerBtn = findViewById(R.id.registerBtn);

        //Declaring agreementText
        agreementText = findViewById(R.id.agreementText);
        agreementText.setText("App terms and conditions are an important legal document for app developers and owners, as they establish the rules and restrictions for app use. Terms and conditions for mobile apps help protect your intellectual property, prevent misuse of your app, and limit legal disputes.");
    }

    boolean validateData(){
        if (editName.getText().toString().equals("")) {
            errName.setVisibility(View.VISIBLE);
            errName.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_in));
            errName.setText("Please Enter Your Name!");
            return false;
        }

        if (editEmail.getText().toString().equals("")) {
            errEmail.setVisibility(View.VISIBLE);
            errEmail.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_in));
            errEmail.setText("Please Enter Your Email!");
            return false;
        }

        if (editPassword.getText().toString().equals("")) {
            errPass.setVisibility(View.VISIBLE);
            errPass.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_in));
            errPass.setText("Please Enter Your Password!");
            return false;
        }

        if (editRepass.getText().toString().equals("")) {
            errRePass.setVisibility(View.VISIBLE);
            errRePass.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_in));
            errRePass.setText("Please Re-enter Your Password!");
            return false;
        }

        if(!editPassword.getText().toString().equals(editRepass.getText().toString())){
            errPass.setVisibility(View.VISIBLE);
            errPass.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_in));
            errPass.setText("Passwords don't match!!");
            return false;
        }
        return true;
    }

    void showSnackBar(View view){
        //Making the error Texts invisible
        errName.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_out));
        errName.setVisibility(View.GONE);

        errEmail.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_out));
        errEmail.setVisibility(View.GONE);

        errPass.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_out));
        errPass.setVisibility(View.GONE);

        errRePass.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_out));
        errRePass.setVisibility(View.GONE);

        Snackbar.make(view,"Sucessfully Registered",Snackbar.LENGTH_SHORT).setAction("Done", new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        }).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "You're Back :)", Toast.LENGTH_SHORT).show();
    }


    //Showing RecyclerView
       /* recyclerView = findViewById(R.id.recyclerView);

        ArrayList<Contacts> contacts = new ArrayList<>();
        contacts.add(new Contacts("Goal Keeper", "30", "https://images.freejpg.com.ar/400/2205/goalkeeper-F100031461.jpg"));
        contacts.add(new Contacts("Microphone", "40", "https://images.freejpg.com.ar/400/2105/microphone-F100031384.jpg"));
        contacts.add(new Contacts("Ice Hockey", "90", "https://images.freejpg.com.ar/400/2205/hockey-goalkeeper-F100031448.jpg"));
        contacts.add(new Contacts("Light House", "20", "https://images.freejpg.com.ar/400/2105/lighthouse-at-the-end-of-the-world-in-ushuaia-argentina-F100031265.jpg"));
        contacts.add(new Contacts("Bearded Man", "43", "https://images.freejpg.com.ar/400/2105/man-with-a-long-beard-looking-at-the-horizon-F100031252.jpg"));
        contacts.add(new Contacts("Clouds", "230", "https://images.freejpg.com.ar/400/2005/sky-with-pink-clouds-F100031216.jpg"));
        contacts.add(new Contacts("Path", "1000", "https://images.freejpg.com.ar/400/2005/path-in-a-field-of-colorful-flowers-F100031199.jpg"));
        contacts.add(new Contacts("Speaker", "343", "https://images.freejpg.com.ar/400/0205/speaker-on-red-background-F100031190.jpg"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(contacts,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));*/
}