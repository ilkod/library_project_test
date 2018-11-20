package com.library.test;
import java.util.*;


public class Library {
    private static int uniqueIdentifierOfBook = 0;

    protected Map<Integer, Book> library = new HashMap<>();
    protected Map<Integer, Person> listOfLentBooks = new HashMap<>();

    //every book, that I add will have unique identifier, so it is no reason to check, if my library contains book with such id
    protected void addBook(Book book){
        library.put(getUniqueIdentifier(), book);
    }

    protected void removeBookByID(int id){

        if (library.get(id) != null){  //check if exists
            if (library.get(id).isAvailableToLent) { //check if it is lent
                library.remove(id);
            }else {
                System.out.println("Book with id: " + id +
                        " is currently lent. You cannot delete this book from library, until it will be returned back");
            }
        }else {
            System.out.println("There is no book with such id: " + id + " in the library");
        }
    }

    protected void showNumberOfBooksInLibrary(){ //number of available and lent
        System.out.println("Total number of books in library: " + library.size() + 
                "\n Number of lent books: " + listOfLentBooks.size() +
                "\n Number of available books: " + (library.size() - listOfLentBooks.size()));
    }

    /*if method returns -1, it means that there is no book in library with such parameters
    returns list, because it is possible to store several number of the same book */
    protected List<Integer> searchBook(String title, String author, int year){

        List<Integer> listOfBooks = new ArrayList<>();

        for (Map.Entry<Integer, Book> entry : library.entrySet())
        {
            if (entry.getValue().title.equals(title) && entry.getValue().author.equals(author) && entry.getValue().year == year) {
                listOfBooks.add(entry.getKey());
            }
        }

        return listOfBooks;
    }

    //overload
    protected List<Integer> searchBook(String title, String author){

        List<Integer> listOfBooks = new ArrayList<>();

        for (Map.Entry<Integer, Book> entry : library.entrySet())
        {
            if (entry.getValue().title.equals(title) && entry.getValue().author.equals(author)) {
                listOfBooks.add(entry.getKey());
            }
        }

        return listOfBooks;
    }

    protected void lentBookByID(int id, Person person){
        if (library.get(id) != null){
           if (library.get(id).isAvailableToLent){
               listOfLentBooks.put(id, person);
               library.get(id).isAvailableToLent = false;
           }else {
               System.out.println("Book is already lend. Try another time");
           }

        }else {
            System.out.println("There is no book with such id: " + id + " in the library");
        }
    }

    protected void showBookInfoById(int id){
        if (library.get(id) != null){  //check if exists
            if (library.get(id).isAvailableToLent){
                show(library.get(id));
                System.out.println("Book available to lend");
            }else {
                show(library.get(id));
                System.out.println("Book is lended by: " + listOfLentBooks.get(id).name);
            }
        }else {
            System.out.println("There is no book with such id: " + id + " in the library");
        }
    }

    protected void printLibrary(){
        for (Map.Entry<Integer, Book> entry : library.entrySet())
        {
            System.out.println(entry.getKey() + ". \\u00AB" + entry.getValue().title + "\\u00BB. " + entry.getValue().author +
                    "; " + entry.getValue().year + ".");
        }
    }

    protected void show(Book book){
        System.out.println("Author: " + book.author +
                "\nTitle: " + book.title +
                "\nYear: " + book.year);
    }

    private int getUniqueIdentifier(){
        int temp = uniqueIdentifierOfBook;
        uniqueIdentifierOfBook += 1;
        return  temp;
    }
}
