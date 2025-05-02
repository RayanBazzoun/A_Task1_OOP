package org.example;

public class Member {
    private String name;
    private int ID;

    public void setID(int ID) {
        this.ID = ID;
    }

    public Member(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + ID;
    }

    public void borrowBook(String bookTitle, LibraryItem library) {
        library.borrowBook(bookTitle, this);
    }

    public void returnBook(String bookTitle, LibraryItem library) {
        library.returnBook(bookTitle,this);
    }

}
