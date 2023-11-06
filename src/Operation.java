import java.util.Scanner;

import static java.lang.System.exit;

public class Operation {
    private static int nOperations = 0;
    public static int getCount() {
        return nOperations;
    }
    static final int Len = 30;
    static final int LenDate = 11;
    private String move;
    private String date;
    public Book book;
    public Client client;
    public Operation(){nOperations++;}
    public Operation(String move, String date, Book book, Client client) {nOperations++;
        setArguments(move, date, book, client);
    }

    public void setArguments(String move, String date, Book book, Client client) {
        if (move.isEmpty() || date.length() != LenDate - 1) {
            exit(-1);
        }
        else {
            this.book = book;
            this.client = client;
            this.move = move;
            this.date = date;
        }
    }
    public String getMove() {
        return move;
    }

    public String getDate() {
        return date;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public void input(Book book, Client client) {
        String move, date;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите тип совершённой операции");
        move = sc.nextLine();
        System.out.println("Введите дату совершения операции");
        date = sc.nextLine();

        setArguments(move, date, book, client);
    }
}
