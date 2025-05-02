package org.example;

public class FictionBook extends Book {
    public FictionBook(String title, String author) {
        super(title, author);
    }

    @Override
    void TypeOfBook(){
        System.out.println("This type of book is a Fiction Book");
    }
}
