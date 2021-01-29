import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.stream.Collectors;

public class BookScanner {
    //how many different books are there, with IDs from 0 to books –1.
    public final int books;
    //how many different libraries are there.
    public final int libraries;
    //How long you have to complete the work, including singing up and scanning
    public final int time;

    private final List<Book> allBooks;

    private final List<Library> allLibraries;

    private Queue<Book> booksToScan;

    private List<Library> signedLibraries = new ArrayList<>();

    public BookScanner(int books, int libraries, int time, List<Book> allBooks, List<Library> allLibraries) {
        this.books = books;
        this.libraries = libraries;
        this.time = time;
        this.allBooks = new ArrayList<>(allBooks);
        this.allLibraries = new ArrayList<>(allLibraries);
        this.booksToScan = new PriorityQueue<>(allBooks);
        this.signedLibraries = new ArrayList<>();
    }

    /**
     * Given a line it splits the numbers and group them in a list
     * The ASCII char for space is used as the delimiter
     * @param line
     * @return
     */
    public static List<Integer> splitNumbers(String line){
        return Arrays.stream(line.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static BookScanner initializeScanner(String filename) {
        Scanner sc;
        try {
            sc = new Scanner(new File(filename));


            int books = sc.nextInt();

            int libraries = sc.nextInt();

            int time = sc.nextInt();

            sc.nextLine();

            //______READ BOOKS DATA_______//

            List<Book> allBooks = new ArrayList<>();

            List<Integer> scores = splitNumbers(sc.nextLine());

            for (int i = 0; i < scores.size(); i++) {
                allBooks.add(new Book(i, scores.get(i)));
            }

            //______READ BOOKS DATA_______//

            List<Library> allLibraries = new ArrayList<>();

            while (sc.hasNextInt()){
                int library_num_books = sc.nextInt();

                int signupTime = sc.nextInt();

                int dailyScanning = sc.nextInt();

                sc.nextLine();

                Collection<Book> library_books = new ArrayList<>();
                for(Integer id : splitNumbers(sc.nextLine())){
                    library_books.add(allBooks.get(id));
                }

                allLibraries.add(new Library(allLibraries.size(), library_num_books, signupTime, dailyScanning, library_books));
            }

            sc.close();
            return new BookScanner (books, libraries, time, allBooks, allLibraries);

        } catch (FileNotFoundException e) {
            throw new RuntimeException("The given filename is incorrect "+e.getMessage());
        }
    }

    public static void main(String[] args) {

        BookScanner a = initializeScanner("data/a_example.txt");

        //BookScanner b = initializeScanner("data/c_incunabula.txt");





    }
}
