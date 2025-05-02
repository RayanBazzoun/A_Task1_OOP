package org.example;

public class ReferenceBook extends Book{
    public ReferenceBook(String title, String author) {
        super(title, author);
    }

    @Override
    void TypeOfBook(){
        System.out.println("This book is a Reference book");
    }
}
