package com.example.firstandroid_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Books book = new Books("Human_Resources",2,"25_August_2022", "Basma-Yasser");

        Users User = new Users("Ahmed", "amanda",12,"Iam123");
        Users User1 = new Users("basma", "basm",12,"Iam167");

        Database db = new Database(this);

//        db.AddBook(book);
//        System.out.println("Book is added successfully");

        db.AddUser(User1);
        db.AddUser(User);
        System.out.println("users is added successfully");

        List<Users> user_list = new ArrayList<Users>();
        user_list = db.getUsers();

        for(int i = 0; i < user_list.size(); i++){
            System.out.println(user_list.get(i).getName());
        }

        final Button NewAccount = (Button) findViewById(R.id.Accbtn);
        NewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });

        final Button Submit_btn = (Button) findViewById(R.id.SubBtn);
        Submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText Username = (EditText) findViewById(R.id.login_Username);
                EditText Password = (EditText) findViewById(R.id.login_password);

                if(!(Username.getText().toString().equals("")) && !(Password.getText().toString().equals("")))
                {

                    boolean logincheck = db.Check(Username.getText().toString(), Password.getText().toString());
                    if(logincheck)
                    {
                        Toast.makeText(getApplicationContext(), "Welcome to our Book Store", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(MainActivity.this, Library.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Sorry, invalid username or password", Toast.LENGTH_LONG).show();

                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "username or password are empty", Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}