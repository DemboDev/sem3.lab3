import java.util.Scanner;

import static java.lang.System.exit;

public class Book implements Printable, Cloneable{
    private static int nBooks = 0;
    public static int getCount() {
        return nBooks;
    }
    protected int year;
    protected String name;
    protected Author author;
    public Book(){}
    public Book(Author author) {
        nBooks++;
        this.name = "Захар Беляков";
        this.year = 2000;
        this.author = author;
    }

    public void setArguments(String name, Author author, int year){
        if (name.isEmpty() || year < 1000) {
            exit(-1);
        }
        else {
            this.name = name;
            this.author = author;
            this.year = year;
        }
    }
    public Book(String name, Author author, int year) {
        nBooks++;
        setArguments(name, author, year);
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void PrintBook() {
        System.out.println(this.getName());
        System.out.println(this.getYear());
        System.out.println(this.author.getCountry());
        System.out.println(this.author.getName());
        System.out.println(this.author.getDate());
    }
    // Мелкое клонирование
    public Book shallowClone() throws CloneNotSupportedException {
        return (Book) super.clone();
    }

    // Глубокое клонирование
    public Book deepClone() throws CloneNotSupportedException {
        Book clonedBook = (Book) super.clone();
        clonedBook.setAuthor((Author) clonedBook.getAuthor().clone());
        return clonedBook;
    }

    public void input(Author author){
        nBooks++;
        int year;
        String name;

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название книги");
        name = sc.nextLine();
        System.out.println("Введите год издания книги");
        do {
            year = sc.nextInt();
            if (year < 1000) {
                System.out.println("А теперь введи нормально");
            }
        } while (year < 1000);

        setArguments(name, author, year);
    }
    public void Print() {
        System.out.println("Название: \"" + this.name + "\", год издания: " + year + ", Автор: " + author.getName() + "\n");
    }
}
