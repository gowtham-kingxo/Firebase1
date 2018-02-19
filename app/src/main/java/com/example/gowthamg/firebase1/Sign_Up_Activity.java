package com.example.gowthamg.firebase1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Sign_Up_Activity extends AppCompatActivity implements View.OnClickListener {

    EditText username;
    EditText password;
    Button submit;
    FirebaseAuth mAuth;
    String Entered_Username = null;
    String Entered_Password = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username  = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        findViewById(R.id.submit).setOnClickListener(this);





        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }

    @Override
    public void onClick(View view) {

        int i = view.getId();

        if(i == R.id.submit)
            //Toast.makeText(this, "Hii submit clicked", Toast.LENGTH_SHORT).show();

        Entered_Username = username.getText().toString();
        Entered_Password = password.getText().toString();

        Toast.makeText(this, "Email: "+Entered_Username+" Password: "+Entered_Password, Toast.LENGTH_SHORT).show();

        if(!Entered_Username.equals(""))
        {
            if(!Entered_Password.equals(""))
            {
                Toast.makeText(this, "All ok", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(this, "Please enter the password!", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Please enter the email address!", Toast.LENGTH_SHORT).show();

    }
}
