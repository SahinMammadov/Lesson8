import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        boolean exit = true;
        while (exit) {
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Search for books");
            System.out.println("4. Display all books sorted");
            System.out.println("5. Calculate average publication year");
            System.out.println("6. Count the number of books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter publication year: ");
                    int publicationYear = scanner.nextInt();
                    library.addBook(new Book(title, author, genre, publicationYear));
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    System.out.print("Enter title of the book to remove: ");
                    String titleToRemove = scanner.nextLine();
                    List<Book> booksToRemove = library.searchByTitle(titleToRemove);
                    if (!booksToRemove.isEmpty()) {
                        System.out.println("Select the book to remove:");
                        for (int i = 0; i < booksToRemove.size(); i++) {
                            System.out.println((i + 1) + ". " + booksToRemove.get(i));
                        }
                        int bookIndexToRemove = scanner.nextInt();
                        library.removeBook(booksToRemove.get(bookIndexToRemove - 1));
                        System.out.println("Book removed successfully.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.println("1. Search by title");
                    System.out.println("2. Search by author");
                    System.out.println("3. Search by genre");
                    System.out.print("Enter your choice: ");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (searchChoice) {
                        case 1:
                            System.out.print("Enter title to search: ");
                            String searchTitle = scanner.nextLine();
                            List<Book> searchResult = library.searchByTitle(searchTitle);
                            for (Book book : searchResult) {
                                System.out.println(book);
                            }
                            break;
                        case 2:
                            System.out.print("Enter author to search: ");
                            String searchAuthor = scanner.nextLine();
                            List<Book> searchResultByAuthor = library.searchByAuthor(searchAuthor);
                            for (Book book : searchResultByAuthor) {
                                System.out.println(book);
                            }
                            break;
                        case 3:
                            System.out.print("Enter genre to search: ");
                            String searchGenre = scanner.nextLine();
                            List<Book> searchResultByGenre = library.searchByGenre(searchGenre);
                            for (Book book : searchResultByGenre) {
                                System.out.println(book);
                            }
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;
                case 4:
                    System.out.println("1. Sort by title");
                    System.out.println("2. Sort by author");
                    System.out.println("3. Sort by publication year");
                    System.out.print("Enter your choice: ");
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine();

                    List<Book> sortedBooks;
                    switch (sortChoice) {
                        case 1:
                            sortedBooks = library.sortByTitle();
                            break;
                        case 2:
                            sortedBooks = library.sortByAuthor();
                            break;
                        case 3:
                            sortedBooks = library.sortByPublicationYear();
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            continue;
                    }
                    for (Book book : sortedBooks) {
                        System.out.println(book);
                    }
                    break;
                case 5:
                    System.out.println("Average publication year: " + library.calculateAveragePublicationYear());
                    break;
                case 6:
                    System.out.println("Number of books: " + library.countBooks());
                    break;
                case 7:
                    exit = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}