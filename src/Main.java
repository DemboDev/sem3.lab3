import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Client errorClient = new Client("1234");
        } catch (IllegalArgumentException errorClient) {
            System.out.println(errorClient.getMessage());
        }
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
        Collection collection;
        Book b = new Book();
        do {
            library.PrintLibrary();
            System.out.println("Библиотека создана. . .");
            System.out.println("Хотите добавить элемент в библиотеку?\n1) Добавить Книгу\n2) Добавить читателя\n3) Добавить операцию\n4) Работа со сборником\n5) Рассчитать эффективность библиотеки\n6) Выйти из программы\n");
            do {
                n = sc.nextInt();
            } while (n > 6 || n < 1);
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
                    int k;
                    System.out.println("Хотите использовать уже существующую книгу?\n1) Да\n2) Нет");
                    do {
                        k = sc.nextInt();
                    } while (k < 1 || k > 2);
                    if (k == 1) {
                        library.PrintLibrary();
                        System.out.println("Введите номер книги из списка");
                        int nOfBook;
                        do {
                            nOfBook = sc.nextInt();
                        } while (nOfBook < 1 || nOfBook > library.GetNumBooks());
                        b = library.books.get(nOfBook - 1);
                    }
                    else {
                        Author a = new Author();
                        a.input();
                        b.input(a);
                        library.AddBookToLibrary(b);
                    }
                    System.out.println("Хотите использовать уже существующего читателя?\n1) Да\n2) Нет");
                    do {
                        k = sc.nextInt();
                    } while (k < 1 || k > 2);
                    Client c = new Client();
                    if (k == 1) {
                        library.PrintLibrary();
                        System.out.println("Введите номер читателя из списка");
                        int nOfReader;
                        do {
                            nOfReader = sc.nextInt();
                        } while (nOfReader < 1 || nOfReader > library.GetNumReaders());
                        c = library.clients.get(nOfReader - 1);
                    }
                    else {
                        c.input();
                        library.AddClientToLibrary(c);
                    }
                    Operation op = new Operation();
                    op.input(b, c);
                    library.AddOperationToLibrary(op);
                    library.PrintLibrary();
                    break;
                case 4:
                    collection = new Collection();
                    int choice;
                    do {
                        System.out.println("Работа со сборником:\n\n1) Добавить книгу\n2) Вывести сборник\n3) Выход\n");

                        do{
                           choice = sc.nextInt();
                        } while (choice < 1 || choice > 3);
                        if (choice == 1) {
                            int num;
                            System.out.println("Введите номер тома (до " + (collection.GetNumOfToms() + 1) + ")\n");
                            do {
                                num = sc.nextInt();
                                num -= 1;
                            } while (num < 0 || num > collection.GetNumOfToms());
                            library.PrintLibrary();
                            System.out.println("Введите номер книги из списка");
                            int nOfBook;
                            do {
                                nOfBook = sc.nextInt();
                            } while (nOfBook < 1 || nOfBook > library.GetNumBooks());
                            b = library.books.get(nOfBook - 1);
                            collection.AddBook(num, b);
                        }
                        if (choice == 2) {
                            collection.Print();
                        }
                    } while (choice != 3);
                case 5:
                    System.out.println("Эффективность библиотеки составляет " + HelpClass.KEffectiveness(library));
                case 6:
                    int ans;
                    do{
                    System.out.println("Точно?\n1)Да\n2)Нет");
                    ans = sc.nextInt();} while (ans < 1 || ans > 2);
                    if (ans == 1) {
                        exit = 1;
                    }
                    break;
            }
        } while (exit == 0);
    }

}