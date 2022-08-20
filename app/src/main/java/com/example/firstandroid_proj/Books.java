package com.example.firstandroid_proj;

public class Books {
    private String Book_Name;
    private String Author;
    private String Prod_Date;
    private Integer Category;

    public Books(){

    }

    public Books(String book_Name, Integer category, String prod_Date, String author) {
        Book_Name = book_Name;
        Author = author;
        Prod_Date = prod_Date;
        Category = category;
    }

    public String getBook_Name() {
        return Book_Name;
    }

    public void setBook_Name(String book_Name) {
        Book_Name = book_Name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getProd_Date() {
        return Prod_Date;
    }

    public void setProd_Date(String prod_Date) {
        Prod_Date = prod_Date;
    }

    public Integer getCategory() {
        return Category;
    }

    public void setCategory(Integer category) {
        Category = category;
    }
}
