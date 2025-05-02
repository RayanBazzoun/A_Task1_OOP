package org.example;

import java.util.ArrayList;

public abstract class LibraryItem {

    private ArrayList<Book>ListOfBooks=new ArrayList<>();
    private ArrayList<Member>ListOfMembers=new ArrayList<>();
    private int MemberIdCounter=1;
    void addBook(Book book){
        ListOfBooks.add(book);
    }
    void addBook(String Title,String author){
        Book newBook= new Book(Title,author);
        ListOfBooks.add(newBook);
    }
    void addMembers(Member member){
        member.setID(MemberIdCounter++);
        ListOfMembers.add(member);

    }
    void displayAllBooks(){
        for(int i = 0; i <ListOfBooks.size(); i++){
            System.out.println(ListOfBooks.get(i));
        }
    }

    public void borrowBook(String bookTitle, Member member) {
        for(int i = 0; i <ListOfBooks.size(); i++){
            if(bookTitle.equals(ListOfBooks.get(i).getTitle()) &&ListOfBooks.get(i).isBorrowed()==false)
            {
                ListOfBooks.get(i).setBorrowingMember(member);
                ListOfBooks.get(i).setBorrowed(true);
            }
        }
    }
    public void returnBook(String bookTitle){
        for(int i = 0; i <ListOfBooks.size(); i++){
            if(bookTitle.equals(ListOfBooks.get(i).getTitle()) &&ListOfBooks.get(i).isBorrowed()==true)
            {
                ListOfBooks.get(i).setBorrowingMember(null);
                ListOfBooks.get(i).setBorrowed(false);
            }
        }
    }


}
