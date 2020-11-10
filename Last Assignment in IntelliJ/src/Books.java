/**
 * @author m04.zhang
 * @version 2020-11-10
 * @project Last Assignment in IntelliJ
 * @description
 */
public class Books {
    private String title;
    private Author author;
    private int ISBN;
    private double value = 0;

    public Books() {

    }

    public Books(String title, String firstName, String lastName, int ISBN) {
        setTitle(title);
        setAuthor(firstName, lastName);
        setISBN(ISBN);
    }

    public void setBook(String title, String firstName, String lastName, int ISBN, double value) {
        setTitle(title);
        setAuthor(firstName, lastName);
        setISBN(ISBN);
        setValue(value);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(String firstName, String lastName) {
        author = new Author(firstName, lastName);
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
