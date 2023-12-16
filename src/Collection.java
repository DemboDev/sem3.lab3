import java.util.ArrayList;
import java.util.Scanner;

public class Collection {
    private String name;
    private ArrayList<ArrayList<Book>> books = new ArrayList<>();
    private void SetName(String name) {
        this.name = name;
    }
    public Scanner sc = new Scanner(System.in);
    public Collection() {
        String name;
        System.out.println("Введите название сборника");
        name = sc.nextLine();
        SetName(name);
        System.out.println("Сборник создан");
    }
    public void AddBook(int num, Book book) {
        if (books.size() == num) {
            ArrayList<Book> b = new ArrayList<>();
            b.add(book);
            books.add(b);
        }
        else {
            books.get(num).add(book);
        }
    }
    int GetNumOfToms() {
        return books.size();
    }
    int GetSize(int i) {
        return books.get(i).size();
    }
    String GetName() {
        return name;
    }
    void Print() {
        System.out.println( "Сборник \"" + this.GetName() + "\": \n");
        for (int i = 0; i < books.size(); i++) {
            System.out.println("\nВ томе номер " + (i + 1) + " содержатся следующие книги: \n");
            for (int j = 0; j < books.get(i).size(); j++) {
                System.out.println( "\"" + this.books.get(i).get(j).getName() + "\", автор - " + this.books.get(i).get(j).author.getName() + ", год издания - " + this.books.get(i).get(j).getYear() + "\n");
            }
        }
    }
}
