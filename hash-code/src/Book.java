import java.util.Objects;

public class Book implements Comparable {
    public final int id;
    public final int score;

    public Book(int id, int score) {
        this.id = id;
        this.score = score;
    }

    @Override
    public int compareTo(Object other) {
        if (other == null || getClass() != other.getClass()){
            throw new RuntimeException("The given object is not a book thus it can't be compared");
        }
        Book otherBook = (Book) other;
        if(this.score > otherBook.score) return -1;
        else if (this.score < otherBook.score) return 1;
        return 0;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                score == book.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, score);
    }


}
