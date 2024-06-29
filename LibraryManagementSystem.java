import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Search by Title");
            System.out.println("3. Search by Author");
            System.out.println("4. Check Out Book");
            System.out.println("5. Return Book");
            System.out.println("6. Display All Books");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    catalog.addBook(new Book(title, author));
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    List<Book> titleResults = catalog.searchByTitle(searchTitle);
                    if (titleResults.isEmpty()) {
                        System.out.println("No books found with the title: " + searchTitle);
                    } else {
                        for (Book book : titleResults) {
                            System.out.println(book);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter author to search: ");
                    String searchAuthor = scanner.nextLine();
                    List<Book> authorResults = catalog.searchByAuthor(searchAuthor);
                    if (authorResults.isEmpty()) {
                        System.out.println("No books found by the author: " + searchAuthor);
                    } else {
                        for (Book book : authorResults) {
                            System.out.println(book);
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter title to check out: ");
                    String checkOutTitle = scanner.nextLine();
                    if (catalog.checkOutBook(checkOutTitle)) {
                        System.out.println("Book checked out successfully!");
                    } else {
                        System.out.println("Book not available or doesn't exist.");
                    }
                    break;

                case 5:
                    System.out.print("Enter title to return: ");
                    String returnTitle = scanner.nextLine();
                    if (catalog.returnBook(returnTitle)) {
                        System.out.println("Book returned successfully!");
                    } else {
                        System.out.println("Book not found or wasn't checked out.");
                    }
                    break;

                case 6:
                    catalog.displayAllBooks();
                    break;

                case 7:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
