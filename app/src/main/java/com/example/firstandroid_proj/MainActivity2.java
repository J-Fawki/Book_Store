package com.example.firstandroid_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button newacc_btn=(Button)findViewById(R.id.Add_btn);
        newacc_btn.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View view) {
                                                 EditText newacc_name=(EditText)findViewById(R.id.NameTxt);
                                                 EditText newacc_age=(EditText)findViewById(R.id.Age);
                                                 EditText newacc_username=(EditText)findViewById(R.id.UsernameTxt);
                                                 EditText newacc_password=(EditText)findViewById(R.id.AccPass);
                                                 EditText newacc_confirmPassword=(EditText)findViewById(R.id.ConfPass);

                                                 if(!(newacc_username.getText().toString().equals(""))&&!(newacc_password.getText().toString().equals(""))&&!(newacc_confirmPassword.getText().toString().equals(""))&&!(newacc_age.getText().toString().equals(""))&&!(newacc_name.getText().toString().equals(""))){
                                                     if(newacc_password.getText().toString().equals(newacc_confirmPassword.getText().toString())){
                                                         //password = confirm password
                                                     }
                                                     else{
                                                         Toast.makeText(getApplicationContext(),"password and confirm password are not the same",Toast.LENGTH_LONG).show();
                                                     }
                                                     //put data validation and database here

                                                 }
                                                 else{
                                                     Toast.makeText(getApplicationContext(),"please fill the empty fields",Toast.LENGTH_LONG).show();
                                                 }
                                             }
                                         }
        );
    }
}