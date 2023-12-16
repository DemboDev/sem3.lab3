import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class Library {
    private String address;
    public ArrayList<Book> books = new ArrayList<>();
    public ArrayList<Operation> operations = new ArrayList<>();
    public ArrayList<Client> clients = new ArrayList<>();
    public int NumBooks = 1;

    int GetNumBooks(){
        return NumBooks;
    }
    public int NumReaders = 1;

    int GetNumReaders () {
        return NumReaders;
    }
    public int NumOperations = 1;
    public Library(){}
    public Library(Book book, Client client, Operation operation, String address) {
        setArguments(book, client, operation, address);
    }

    public void setArguments(Book book, Client client, Operation operation, String address) {
        if (address.isEmpty()) {
            exit(-1);
        }
        else {
            this.address = address;

            this.books.add(this.NumBooks - 1, book);

            this.operations.add(this.NumOperations - 1, operation);

            this.clients.add(this.NumReaders - 1, client);
        }
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void AddBookToLibrary(Book book){
        this.NumBooks += 1;
        this.books.add(book);
    }

    public void AddClientToLibrary(Client client){
        this.NumReaders += 1;
        this.clients.add(client);
    }

    public void AddOperationToLibrary(Operation operation1){
        this.NumOperations += 1;
        this.operations.add(operation1);
    }
    void PrintLibrary() {
        System.out.println("\nБиблиотека:\n" + Book.getCount() + " Привязанные книги : ");
        for (int i = 0; i < this.NumBooks; i++) {
            System.out.println("\"" + this.books.get(i).getName() + "\", автор - " + this.books.get(i).author.getName() + ", год издания - " + this.books.get(i).getYear() + "\n" );
        }
        System.out.println("\n" + Client.getCount() + " Привязанных читателей : ");
        for (int i = 0; i < this.NumReaders; i++) {
            System.out.printf("Имя: " + this.clients.get(i).getName() + ", дата рождения:" + this.clients.get(i).getDate() + ", проживает по адресу - " + this.clients.get(i).getAddress() + "\n");
        }
        System.out.println("\n" + Operation.getCount() + " Привязанных операции в библиотеке : ");
        for (int i = 0; i < this.NumOperations; i++) {
            System.out.printf("Книга \"" + this.operations.get(i).book.getName() + "\", читатель: " + this.operations.get(i).client.getName() + ", Дата совершения операции: " + this.operations.get(i).getDate() + ", Тип операции: " + this.operations.get(i).getMove() + "\n");
        }
        System.out.println(" ");
    }

    public void input(Book book, Client client, Operation operation) {
        String address;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите адрес библиотеки");
        address = sc.nextLine();

        setArguments(book, client, operation, address);
    }
}
