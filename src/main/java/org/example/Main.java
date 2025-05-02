package org.example;

public class Main {
    public static void main(String[] args) {

        Member m1=new Member("Rayan");
        Member m2= new Member("Ahmad");
        Member m3= new Member("Razan");

        Book b1= new FictionBook("Book1","author1");
        Book b2= new FictionBook("Book2","author2");
        Book b3= new FictionBook("Book3","author3");
        Book b4= new ReferenceBook("Book4","author4");
        Book b5= new ReferenceBook("Book5","author5");
        Book b6= new ReferenceBook("Book6","author6");

        Library l1= new Library("Library1");
        l1.addBook(b1);
        l1.addBook("book7","author7");
        l1.addBook(b4);

        Library l2= new Library("Library1");
        l2.addBook(b2);
        l2.addBook("book8","author8");
        l2.addBook(b4);
        l2.addBook(b5);

        System.out.println("List of books in L1");
        l1.displayAllBooks();
        //System.out.println("List of books in L2");
        //l2.displayAllBooks();
        l1.addMembers(m1);
        l1.addMembers(m2);
        m1.borrowBook("Book1",l1);
        //m1.returnBook("Book1",l1);
        l1.displayAllBooks();
    }
}