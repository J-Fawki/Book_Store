package com.example.firstandroid_proj;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.printservice.PrintDocument;
import android.util.Log;
import android.widget.Toast;

import java.util.*;

public class Database extends SQLiteOpenHelper {

    public Database(Context context){
        super(context, "BookStoreDB" , null , 1);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String UTableCreation = " CREATE TABLE Users ( id INTEGER PRIMARY KEY, Name TEXT ," +
                " Username TEXT, Age INTEGER, Password TEXT)";
        sqLiteDatabase.execSQL(UTableCreation);

//        String BTableCreation = " CREATE TABLE Books ( ID INTEGER PRIMARY KEY, Book_Name TEXT ," +
//                " Category INTEGER, Prod_Date TEXT, Author TEXT)";
//        sqLiteDatabase.execSQL(BTableCreation);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Users");
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Books");
        onCreate(sqLiteDatabase);
    }

    SQLiteDatabase dbase;
//    public void AddBook(Books book){
//
//        dbase = this.getWritableDatabase();
//        ContentValues value = new ContentValues();
//        value.put("Book_Name", book.getBook_Name());
//        value.put("Category", book.getCategory());
//        value.put("Prod_Date", book.getProd_Date());
//        value.put("Author", book.getAuthor());
//
//        dbase.insert("Books", null , value);
//        dbase.close();
//
//    }

    public void AddUser(Users user){

        dbase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Name", user.getName());
        values.put("Username", user.getUsername());
        values.put("Age", user.getAge());
        values.put("Password", user.getPassword());

        dbase.insert("Users", null , values);
        dbase.close();

    }
    List<Users> users = new ArrayList<Users>();

    public List<Users> getUsers(){

        String Query = "SELECT * FROM Users";

        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(Query, null);
        if(cursor.moveToFirst()){
            do{
                Users User = new Users();
                User.setName(cursor.getString(1));
                User.setUsername(cursor.getString(2));
                User.setAge(Integer.parseInt(cursor.getString(3)));
                User.setPassword(cursor.getString(4));

                users.add(User);
            } while(cursor.moveToNext());
        }

        return users;
    }

    public void deleteUser(Users User){
        dbase = this.getWritableDatabase();
        dbase.delete("Users ", "Name = ? " , new String[]{ String.valueOf(User.getName())});
        dbase.close();
    }

    public boolean Check(String username , String password){
        boolean check = false;
        for(int i = 0; i < users.size(); i++){
            if((username.equals(users.get(i).getUsername())) && (password.equals(users.get(i).getPassword()))){
                check = true;
            }
        }
        return check;
    }
}
