package org.example;

public class Book {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;
    private String author;
    private Member BorrowingMember;
    private boolean isBorrowed=false;
    public Member getBorrowingMember() {
        return BorrowingMember;
    }

    public void setBorrowingMember(Member borrowingMember) {
        BorrowingMember = borrowingMember;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(String title, String author) {
        this.title=title;
        this.author=author;
        this.isBorrowed=false;
    }

    void TypeOfBook(){
        System.out.println("general Book");
    }

    @Override
    public String toString(){
        String details="Title: "+getTitle()+ " Author: "+ getAuthor()+" Borrowing Member: "+ getBorrowingMember();
        if(isBorrowed()==false){
            details=details+" Book is available";
        }else{
            details=details+" Book isn't available";
        }
        return details;
    }
}
