import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;
public class BookCollection extends Book implements Printable{
    private static int nBookColl = 0;
    private ArrayList<String> stories = new ArrayList<>();

    @Override
    public void input(Author author) {
        super.input(author);
    }

    public BookCollection(String name, Author author, int year, ArrayList<String> stories) {
        super(name, author, year);
        nBookColl++;
        this.stories = stories;
    }
    public BookCollection(String name, Author author, int year) {
        super(name, author, year);
        nBookColl++;
    }
    public BookCollection() {
        nBookColl++;
    }
    public void AddStory(String story) {
        stories.add(story);
    }
    public void Print() {
        super.Print();
        for (int i = 0; i < stories.size(); i++) {
            System.out.println("    |" + (i + 1) + "| Рассказ \"" + stories.get(i) + "\"" + "\n");
        }
    }
    public static int getCountBC() {
        return nBookColl;
    }
}
