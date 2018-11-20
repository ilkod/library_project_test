package com.library.test;
import java.util.Calendar;

public class Book {

    String title;
    String author;
    int year;
    boolean isAvailableToLent;

    Book(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.isAvailableToLent = true;

        //check if year is valid, if no it would be set default value - 1900
        if (year > 0 && year <= Calendar.getInstance().get(Calendar.YEAR)){
            this.year = year;
        }else {
            this.year = 1900;
        }
    }


}
