package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        ArrayList<Book>Books= new ArrayList<>();
        ArrayList<Library> libraries = new ArrayList<>();
        ArrayList<Member> Members= new ArrayList<>();
        while (!exit) {
            System.out.println("1. Add a new Library");
            System.out.println("2. Add a new Book");
            System.out.println("3. Add a new Member");
            System.out.println("4. Add a new Book to a Library");
            System.out.println("5. Add a new Member to a Library");
            System.out.println("6. Borrow a Book");
            System.out.println("7. Return a Book");
            System.out.println("8. Display All Books in a Library");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    System.out.print("Enter the name of the library: ");
                    String libraryName = scanner.nextLine();
                    if (findLibrary(libraries, libraryName) == null) {
                        Library library= new Library(libraryName);
                        libraries.add(library);
                        System.out.println("created successfully");
                    } else {
                        System.out.println("Library already exists!");
                    }
                    break;
                }
                case 2:{
                    System.out.print("Enter the title of the book: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter the author of the book: ");
                    String bookAuthor = scanner.nextLine();
                    if(findBook(Books,bookTitle)!=null){
                        System.out.println("Book already exists");
                    }
                    System.out.print("Enter book type 1 for Fiction and 2 for Reference: ");
                    int bookType = scanner.nextInt();
                    scanner.nextLine();

                    Book book;
                    if (bookType == 1) {
                        book = new FictionBook(bookTitle, bookAuthor);
                        Books.add(book);
                    } else if(bookType==2) {
                        book = new ReferenceBook(bookTitle, bookAuthor);
                        Books.add(book);
                    }else{
                        System.out.println("Enter a valid option");
                    }
                    break;
                }
                case 3:{
                    System.out.print("Enter the name of the member ");
                    String name=scanner.nextLine();
                    Member member= new Member(name);
                    if(findMember(Members,member.getName())==null) {
                        Members.add(member);
                        System.out.println("Member added successfully");
                    }else{
                        System.out.println("Member already exists");
                    }
                    break;
                }
                case 4:{
                    System.out.print("Enter the name of the library you want to add the book to: ");
                    String LibraryName = scanner.nextLine();
                    if (LibraryName == null) {
                        System.out.println("Library not found.");
                        break;
                    }
                    Library library = findLibrary(libraries, LibraryName);

                    System.out.print("Enter the title of the book: ");
                    String bookTitle = scanner.nextLine();
                    Book book=findBook(Books,bookTitle);
                    if(book!=null){
                        library.addBook(book);
                    }
                    else{
                        System.out.print("Enter the author of the book: ");
                        String bookAuthor = scanner.nextLine();
                        library.addBook(bookTitle,bookAuthor);
                    }
                    System.out.println("Book added successfully!");
                    break;

                }
                case 5:{
                    System.out.print("Enter the name of the library to add the member to: ");
                    String LibraryName = scanner.nextLine();
                    Library library = findLibrary(libraries, LibraryName);
                    if (library == null) {
                        System.out.println("Library not found.");
                        break;
                    }

                    System.out.print("Enter the name of the member: ");
                    String memberName = scanner.nextLine();
                    Member member= findMember(Members,memberName);
                    if(member!=null){
                        library.addMembers(member);
                    }
                    System.out.println("added successfully");
                    break;
                }
                case 6:{
                    System.out.print("Enter the library name: ");
                    String LibraryName = scanner.nextLine();
                    Library library = findLibrary(libraries, LibraryName);
                    if (library == null) {
                        System.out.println("Library not found.");
                        break;
                    }

                    System.out.print("Enter member name to borrow a book: ");
                    String BorrowingMember = scanner.nextLine();
                    Member borrowingMember = findMemberInLib(library, BorrowingMember);
                    if (borrowingMember == null) {
                        System.out.println("Member not found.");
                        break;
                    }

                    System.out.print("Enter the title of the book to borrow: ");
                    String book = scanner.nextLine();
                    borrowingMember.borrowBook(book, library);
                    break;
                }
                case 7:{
                    System.out.print("Enter the library name: ");
                    String LibraryName = scanner.nextLine();
                    Library library = findLibrary(libraries, LibraryName);
                    if (library == null) {
                        System.out.println("Library not found.");
                        break;
                    }

                    System.out.print("Enter member name to return a book: ");
                    String member = scanner.nextLine();
                    Member returningMember = findMemberInLib(library, member);
                    if (returningMember == null) {
                        System.out.println("Member not found.");
                        break;
                    }

                    System.out.print("Enter the title of the book to return: ");
                    String book = scanner.nextLine();
                    returningMember.returnBook(book, library);
                    break;
                }
                case 8:{
                    System.out.print("Enter the library name to display books: ");
                    String LibraryName = scanner.nextLine();
                    Library library = findLibrary(libraries, LibraryName);
                    if (library == null) {
                        System.out.println("Library not found.");
                        break;
                    }

                    library.displayAllBooks();
                    break;
                }
                case 9:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid");
                    break;
            }
        }

        scanner.close();
    }

    public static Library findLibrary(List<Library> libraries, String name) {
        for (Library refactor : libraries) {
            if (refactor.getName().equals(name)) {
                return refactor;
            }
        }
        return null;
    }
    public static Book findBook(List<Book> books, String bookTitle){
        for(Book book:  books){
            if(book.getTitle().equals(bookTitle)){
                return book;
            }
        }
        return null;
    }
    public static Member findMemberInLib(Library library, String memberName) {
        for (Member member : library.getListOfMembers()) {
            if (member.getName().equals(memberName)) {
                return member;
            }
        }
        return null;
    }
    public static Member findMember(List<Member> Members, String memberName) {
        for (Member member : Members) {
            if (member.getName().equals(memberName)) {
                return member;
            }
        }
        return null;
    }


}


//the previous static example: (easier to read but more simple)
//
//Member m1=new Member("Rayan");
//Member m2= new Member("Ahmad");
//Member m3= new Member("Razan");
//
//Book b1= new FictionBook("Book1","author1");
//Book b2= new FictionBook("Book2","author2");
//Book b3= new FictionBook("Book3","author3");
//Book b4= new ReferenceBook("Book4","author4");
//Book b5= new ReferenceBook("Book5","author5");
//Book b6= new ReferenceBook("Book6","author6");
//
//Library l1= new Library("Library1");
//        l1.addBook(b1);
//        l1.addBook("book7","author7");
//        l1.addBook(b4);
//
//Library l2= new Library("Library1");
//        l2.addBook(b2);
//        l2.addBook("book8","author8");
//        l2.addBook(b4);
//        l2.addBook(b5);
//
//        System.out.println("List of books in L1");
//        l1.displayAllBooks();
////System.out.println("List of books in L2");
////l2.displayAllBooks();
//        l1.addMembers(m1);
//        l1.addMembers(m2);
//        m1.borrowBook("Book1",l1);
////m1.returnBook("Book1",l1);
//        l1.displayAllBooks();
