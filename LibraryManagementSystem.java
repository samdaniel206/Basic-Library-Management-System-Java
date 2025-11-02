import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {

    static class Book {
        private String title;
        private String author;
        private String isbn;

        public Book(String title, String author, String isbn) {
            this.title = title.trim();
            this.author = author.trim();
            this.isbn = isbn.trim();
        }

        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return "Title: " + title + " | Author: " + author + " | ISBN: " + isbn;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add new book");
            System.out.println("2. Display all books");
            System.out.println("3. Search book by title");
            System.out.println("4. Remove book by title");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author name: ");
                    String author = sc.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = sc.nextLine();
                    books.add(new Book(title, author, isbn));
                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    if (books.isEmpty()) {
                        System.out.println("No books available.");
                    } else {
                        System.out.println("\n--- All Books ---");
                        for (int i = 0; i < books.size(); i++) {
                            System.out.println((i + 1) + ". " + books.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter title to search: ");
                    String searchTitle = sc.nextLine().trim().toLowerCase();
                    boolean found = false;
                    for (Book book : books) {
                        if (book.getTitle().toLowerCase().contains(searchTitle)) {
                            System.out.println(book);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No book found with that title.");
                    }
                    break;

                case 4:
                    System.out.print("Enter title to remove: ");
                    String removeTitle = sc.nextLine().trim().toLowerCase();
                    boolean removed = books.removeIf(b -> b.getTitle().toLowerCase().contains(removeTitle));
                    if (removed) {
                        System.out.println("Book removed successfully.");
                    } else {
                        System.out.println("No book found with that title.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }
        }

        sc.close();
    }
}