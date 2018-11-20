package com.library.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void addBook() {
        Library instance = new Library();

        instance.addBook(new Book("The Trial", "Kafka", 1925));
        instance.addBook(new Book("The Room", "James", 1997));
        instance.addBook(new Book("La Plague", "Camus", 1947));
        instance.addBook(new Book("The Trial", "Kafka", 2020));

        assertEquals(4, instance.library.size());
        assertEquals(1900, instance.library.get(3).year);
        assertEquals("Kafka", instance.library.get(0).author);
        assertEquals("The Room", instance.library.get(1).title);

        instance.printLibrary();

    }

    @Test
    public void removeBookByID() {
        Library instance = new Library();

        instance.addBook(new Book("The Trial", "Kafka", 1925));
        instance.addBook(new Book("The Room", "James", 1997));
        instance.addBook(new Book("La Plague", "Camus", 1947));
        instance.addBook(new Book("The Trial", "Kafka", 2020));

        instance.printLibrary();

        assertEquals(4, instance.library.size());

        instance.removeBookByID(2);

        instance.printLibrary();

        assertEquals(3, instance.library.size());
        assertEquals(null, instance.library.get(2)); //book with id 2 equals null
    }

    @Test
    public void showNumberOfBooksInLibrary() {
        Library instance = new Library();

        instance.addBook(new Book("The Trial", "Kafka", 1925));
        instance.addBook(new Book("The Room", "James", 1997));
        instance.addBook(new Book("La Plague", "Camus", 1947));
        instance.addBook(new Book("The Trial", "Kafka", 2020));

        instance.printLibrary();

        assertEquals(4, instance.library.size());


    }

    @Test
    public void searchBook() {

        Library instance = new Library();

        instance.addBook(new Book("The Trial", "Kafka", 1925));
        instance.addBook(new Book("The Room", "James", 1997));
        instance.addBook(new Book("La Plague", "Camus", 1947));
        instance.addBook(new Book("The Trial", "Kafka", 2020));

        instance.printLibrary();

        List<Integer> list = new ArrayList<>();
        list.add(1);

        assertEquals(list, instance.searchBook("The Room", "James", 1997));
    }

    @Test
    public void searchBook1() {

        Library instance = new Library();

        instance.addBook(new Book("The Trial", "Kafka", 1925));
        instance.addBook(new Book("The Room", "James", 1997));
        instance.addBook(new Book("La Plague", "Camus", 1947));
        instance.addBook(new Book("The Trial", "Kafka", 2020));

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(3); //in case, if we have two similar books in the library (different print year)


        assertEquals(list, instance.searchBook("The Trial", "Kafka"));
    }

    @Test
    public void lentBookByID() { //first lend
        Library instance = new Library();

        instance.addBook(new Book("La Plague", "Camus", 1947));
        instance.addBook(new Book("The Trial", "Kafka", 2020));

        instance.lentBookByID(1, new Person("Illia Demchuk"));

        assertEquals("Illia Demchuk", instance.listOfLentBooks.get(1).name);//check lended book by person and id, which will be returned
    }

    @Test
    public void lentBookByID1() { // lending the same book
        Library instance = new Library();

        instance.addBook(new Book("The Trial", "Kafka", 1925));
        instance.addBook(new Book("The Room", "James", 1997));

        instance.lentBookByID(1, new Person("Illia Demchuk"));

        instance.lentBookByID(1, new Person("Szymon Zawada"));

        //sout result says, that this book is lended already
    }

    @Test
    public void showBookInfoById() {
        Library instance = new Library();

        instance.addBook(new Book("The Trial", "Kafka", 1925));

        instance.showBookInfoById(0);
    }
}