package org.example;

import java.util.ArrayList;

public abstract class LibraryItem {

    private ArrayList<Book>ListOfBooks=new ArrayList<>();
    private ArrayList<Member>ListOfMembers=new ArrayList<>();
    private int MemberIdCounter=1;



    public ArrayList<Member> getListOfMembers() {
        return ListOfMembers;
    }



    void addBook(Book book){
        for(int i=0;i<ListOfBooks.size();i++){
            if(book.getTitle().equals(ListOfBooks.get(i).getTitle())){
                System.out.println("Book Already Exists in this library");
                return;
            }
        }
        ListOfBooks.add(book);
    }
    void addBook(String Title,String author){
        Book newBook= new Book(Title,author);
        for(int i=0;i<ListOfBooks.size();i++){
            if(newBook.getTitle().equals(ListOfBooks.get(i).getTitle())){
                System.out.println("Book Already Exists in this library");
                return;
            }
        }ListOfBooks.add(newBook);
    }
    void addMembers(Member member){
        for(int i=0;i<ListOfMembers.size();i++){
            if(member.getID()==ListOfMembers.get(i).getID()){
                System.out.println("Member already added");
                return;
            }
        }
        member.setID(MemberIdCounter++);
        ListOfMembers.add(member);

    }
    void displayAllBooks(){
        if(ListOfBooks.size()==0){
            System.out.println("No books in this library");
        }else {
            for (int i = 0; i < ListOfBooks.size(); i++) {
                System.out.println(ListOfBooks.get(i));
            }
        }
    }

    public void borrowBook(String bookTitle, Member member) {
        for(int i = 0; i <ListOfBooks.size(); i++){
            if(bookTitle.equals(ListOfBooks.get(i).getTitle()) &&ListOfBooks.get(i).isBorrowed()==false)
            {
                ListOfBooks.get(i).setBorrowingMember(member);
                ListOfBooks.get(i).setBorrowed(true);
                return;
            }else if(!bookTitle.equals(ListOfBooks.get(i).getTitle())){
                System.out.println("This book is not found in this library");
                return;
            }else if(ListOfBooks.get(i).isBorrowed()==true){
                System.out.println("This book is already borrowed");
                return;
            }
        }
    }
    public void returnBook(String bookTitle,Member member){
        for(int i = 0; i <ListOfBooks.size(); i++) {
                if (bookTitle.equals(ListOfBooks.get(i).getTitle()) && ListOfBooks.get(i).isBorrowed() == true) {
                    if(ListOfBooks.get(i).getBorrowingMember().getName().equals(member.getName())){
                        ListOfBooks.get(i).setBorrowingMember(null);
                        ListOfBooks.get(i).setBorrowed(false);
                    }else{
                        System.out.println("The person that rented the book is the person that needs to return it");
                    }

                }
        }

    }


}
