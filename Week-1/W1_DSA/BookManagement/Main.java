package BookManagement;

import java.util.Arrays;
import java.util.Comparator;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookID: " + bookId + ", Title: \"" + title + "\", Author: " + author;
    }
}

class BookManager {
    private Book[] books;
    private int count;

    public BookManager(int size) {
        books = new Book[size];
        count = 0;
    }

    // Add a book
    public void addBook(Book book) {
        if (count < books.length) {
            books[count++] = book;
        } else {
            System.out.println("Book list is full.");
        }
    }

    // Linear search by title
    public void linearSearch(String title) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                System.out.println("Found: " + books[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found with title: " + title);
        }
    }

    // Sort books by title (for binary search)
    public void sortBooksByTitle() {
        Arrays.sort(books, 0, count, Comparator.comparing(book -> book.title.toLowerCase()));
    }

    // Binary search by title
    public void binarySearch(String title) {
        int low = 0;
        int high = count - 1;
        title = title.toLowerCase();

        while (low <= high) {
            int mid = (low + high) / 2;
            String midTitle = books[mid].title.toLowerCase();

            if (midTitle.equals(title)) {
                System.out.println("Found: " + books[mid]);
                return;
            } else if (midTitle.compareTo(title) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Book not found with title: " + title);
    }

    // Display all books
    public void displayBooks() {
        for (int i = 0; i < count; i++) {
            System.out.println(books[i]);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        BookManager manager = new BookManager(10);

        manager.addBook(new Book(101, "The Alchemist", "Paulo Coelho"));
        manager.addBook(new Book(102, "Clean Code", "Robert C. Martin"));
        manager.addBook(new Book(103, "Thinking in Java", "Bruce Eckel"));
        manager.addBook(new Book(104, "Design Patterns", "Erich Gamma"));

        System.out.println("\nAll Books:");
        manager.displayBooks();

        System.out.println("\nLinear Search for 'Clean Code':");
        manager.linearSearch("Clean Code");

        System.out.println("\nBinary Search for 'Design Patterns':");
        manager.sortBooksByTitle(); // Important before binary search
        manager.binarySearch("Design Patterns");

        System.out.println("\nBinary Search for 'Unknown Book':");
        manager.binarySearch("Unknown Book");
    }
}
