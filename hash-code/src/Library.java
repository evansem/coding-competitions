import java.util.*;

public class Library {
    public final int id;

    public final int numBooks;

    public final int signupTime;

    public final int dailyScanning;

    private Queue<Book> booksToScan;
    
    private List<Book> booksCompleted = new ArrayList<>();

    public Library(int id, int numBooks, int signupTime, int dailyScanning, Collection<Book> unorderedBooks) {
        this.id = id;
        this.numBooks = numBooks;
        this.signupTime = signupTime;
        this.dailyScanning = dailyScanning;
        this.booksToScan = new PriorityQueue<Book>(unorderedBooks); 
    }
}
