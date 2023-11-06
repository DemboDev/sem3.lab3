import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Author author = new Author();
        author.input();
        Client client = new Client();
        client.input();
        Book book = new Book();
        book.input(author);
        Operation operation = new Operation();
        operation.input(book, client);
        Library library = new Library();
        library.input(book, client, operation);
        int exit = 0; int n;
        Scanner sc = new Scanner(System.in);
        do {
            library.PrintLibrary();
            System.out.println("Библиотека создана. . .");
            System.out.println("Хотите добавить элемент в библиотеку?\n1) Добавить Книгу\n2) Добавить читателя\n3) Добавить операцию\n4) Выйти из программы\n");
            do {
                n = sc.nextInt();
            } while (n > 4 || n < 1);
            switch (n) {
                case 1:
                    Book NewBook = new Book();
                    Author NewAuthor = new Author();
                    NewAuthor.input();
                    NewBook.input(NewAuthor);
                    library.AddBookToLibrary(NewBook);
                    library.PrintLibrary();
                    break;
                case 2:
                    Client NewClient = new Client();
                    NewClient.input();
                    library.AddClientToLibrary(NewClient);
                    library.PrintLibrary();
                    break;
                case 3:
                    Book NewBook2 = new Book();
                    Author NewAuthor2 = new Author();
                    NewAuthor2.input();
                    NewBook2.input(NewAuthor2);
                    Client NewClient2 = new Client();
                    NewClient2.input();
                    Operation NewOperation = new Operation();
                    NewOperation.input(NewBook2, NewClient2);
                    library.AddBookToLibrary(NewBook2);
                    library.AddClientToLibrary(NewClient2);
                    library.AddOperationToLibrary(NewOperation);
                    library.PrintLibrary();
                    break;
                case 4:
                    exit = 1;
                    break;
            }
        } while (exit == 0);
    }

}