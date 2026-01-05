
// Online Library Management System - Java
// B.Tech 3rd Semester Mini Project

import java.util.*;

class Book {
    private int id;
    private String title;
    private String author;
    private boolean issued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public boolean isIssued() { return issued; }

    public void issueBook() { issued = true; }
    public void returnBook() { issued = false; }

    public void display() {
        System.out.println(id + " | " + title + " | " + author + " | " +
                (issued ? "Issued" : "Available"));
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(int id, String title, String author) {
        books.add(new Book(id, title, author));
        System.out.println("Book added successfully.");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book b : books) b.display();
    }

    public void searchBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                b.display();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void issueBook(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                if (!b.isIssued()) {
                    b.issueBook();
                    System.out.println("Book issued.");
                } else {
                    System.out.println("Book already issued.");
                }
                return;
            }
        }
        System.out.println("Invalid Book ID.");
    }

    public void returnBook(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                if (b.isIssued()) {
                    b.returnBook();
                    System.out.println("Book returned.");
                } else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }
        System.out.println("Invalid Book ID.");
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("1.Add 2.View 3.Search 4.Issue 5.Return 6.Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    lib.addBook(id, title, author);
                    break;
                case 2:
                    lib.viewBooks();
                    break;
                case 3:
                    sc.nextLine();
                    System.out.print("Title: ");
                    lib.searchBook(sc.nextLine());
                    break;
                case 4:
                    System.out.print("ID: ");
                    lib.issueBook(sc.nextInt());
                    break;
                case 5:
                    System.out.print("ID: ");
                    lib.returnBook(sc.nextInt());
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
