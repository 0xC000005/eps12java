import java.util.*;

/**
 * The program should display all books in your collection
 * <p>
 * then ask for value for each book and then display the
 * collection again in increasing value.
 * <p>
 * run the display method
 * ------------------------------------------
 * My Collection
 * <p>
 * ISBN     Author          Title       Value
 * 12356    King, Stephen   Carrie      $0.00
 * 3265     Smith, Mike     Hockey Life $0.00
 * 68746    Wong, Sally     Survival    $0.00
 * <p>
 * Enter value of Carrie $  4.50
 * Enter value of Hockey Life $ 12.60
 * Enter value of Survival $ 6.99
 * <p>
 * ISBN     Author          Title       Value
 * 12356    King, Stephen   Carrie      $4.50
 * 68746    Wong, Sally     Survival    $6.99
 * 3265     Smith, Mike     Hockey Life $12.60
 */
public class Library {
    private final ArrayList<Books> bookList = new ArrayList<>();
    private final Input input = new Input();

    public Library() {
        bookList.add(new Books("Carrie  ", "Stephen", "King", 12356));
        bookList.add(new Books("Survival", "Sally", "Wong", 68746));
        bookList.add(new Books("Hockey Life", "Mike", "Smith", 3265));

    }

    public void printBookInfo(Books currentBook) {
        System.out.println(currentBook.getISBN() + "\t" + currentBook.getAuthor().getName() + "\t" + currentBook.getTitle() + "\t$" + String.format("%.2f", currentBook.getValue()));
    }

    public void displayBookList() {
        System.out.println("ISBN\tAuthor\t\tTitle\t\tValue");
        for (Books currentBook : bookList) {
            printBookInfo(currentBook);
        }
        System.out.println();
    }

    public void inputBooksValue() {
        for (Books books : bookList) {
            System.out.print("Enter value of " + books.getTitle() + " $  ");
            books.setValue(input.getDoubleWithNoneZeroErrorCheck());
        }
        System.out.println();
    }

    public Books popBook(int index) {
        Books currentBook = bookList.get(index);
        bookList.remove(index);
        return currentBook;
    }

    public void displaySortedBookList() {
        System.out.println("ISBN\tAuthor\t\tTitle\t\tValue");
        ArrayList<Books> tempBookList = bookList;
        while (tempBookList.size() != 0) {
            int cheepBookIndex = 0;
            for (int i = 1; i < tempBookList.size(); i++) {
                if (tempBookList.get(i).getValue() < tempBookList.get(cheepBookIndex).getValue()) cheepBookIndex = i;
            }
            printBookInfo(bookList.get(cheepBookIndex));
            popBook(cheepBookIndex);
        }
        System.out.println();
    }

    public void display() {
        System.out.println("My Collection\n" +
                "\n");
        displayBookList();
        inputBooksValue();
        displaySortedBookList();
    }

    public static void main(String[] args) {
        Library testObject = new Library();
        testObject.display();
    }
}