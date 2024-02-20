import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> searchByTitle(String title) {
        return books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());

    }

    public List<Book> searchByAuthor(String author) {
        return books.stream().filter(book -> book.getAuthor().equalsIgnoreCase(author)).collect(Collectors.toList());
    }

    public List<Book> searchByGenre(String genre) {
        return books.stream().filter(book -> book.getGenre().equalsIgnoreCase(genre)).collect(Collectors.toList());
    }

    public List<Book> sortByTitle() {
        return books.stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
    }

    public List<Book> sortByAuthor() {
        return books.stream().sorted(Comparator.comparing(Book::getAuthor)).collect(Collectors.toList());
    }

    public List<Book> sortByPublicationYear() {
        return books.stream().sorted(Comparator.comparingInt(Book::getPublicationYear)).collect(Collectors.toList());
    }

    public double calculateAveragePublicationYear() {
        return books.stream().mapToInt(Book::getPublicationYear).average().orElse(0);
    }

    public int countBooks() {
        return books.size();
    }

    public void displayInventory() {
        for (Book book : books) {
            System.out.println(book);
        }
    }


}
