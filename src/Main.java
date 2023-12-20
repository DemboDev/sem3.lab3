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
            library.Print();
            System.out.println("Библиотека создана. . .");
            System.out.println("Хотите добавить элемент в библиотеку?\n1) Добавить Книгу\n2) Добавить читателя\n3) Добавить операцию\n4) Работа со сборником\n5) Рассчитать эффективность библиотеки\n6) Демонстрация клонирования\n7) Выйти из программы\n");
            do {
                n = sc.nextInt();
            } while (n > 7 || n < 1);
            switch (n) {
                case 1:
                    System.out.println("1) Добавить книгу \n2) Добавить книгу-сборник\n");
                    do {
                        n = sc.nextInt();
                    } while (n < 1 || n > 2);
                    if (n == 1) {
                        Book NewBook = new Book();
                        Author NewAuthor = new Author();
                        NewAuthor.input();
                        NewBook.input(NewAuthor);
                        library.AddBookToLibrary(NewBook);
                        library.Print();
                    }
                    else {
                        Author NewAuthor = new Author();
                        NewAuthor.input();
                        BookCollection bc = new BookCollection();
                        bc.input(NewAuthor);
                        System.out.println("Введите количество рассказов (до 5)");
                        int k;
                        do {
                            k = sc.nextInt();
                        } while (k < 1 || k > 5);
                        String str;
                        for (int i = 0; i < k; i++) {
                            System.out.println("Введите название рассказа " + (i + 1) + "\n");
                            do{
                            str = sc.nextLine();
                            } while (str.isEmpty());
                            bc.AddStory(str);
                        }
                        library.AddBookCollectionToLibrary(bc);
                        library.Print();
                    }
                    break;
                case 2:
                    Client NewClient = new Client();
                    NewClient.input();
                    library.AddClientToLibrary(NewClient);
                    library.Print();
                    break;
                case 3:
                    int k;
                    System.out.println("Хотите использовать уже существующую книгу?\n1) Да\n2) Нет");
                    do {
                        k = sc.nextInt();
                    } while (k < 1 || k > 2);
                    if (k == 1) {
                        library.Print();
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
                        library.Print();
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
                    library.Print();
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
                            library.Print();
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
                    break;
                case 5:
                    System.out.println("Эффективность библиотеки составляет " + HelpClass.KEffectiveness(library));
                    break;
                case 6:
                    Author originalAuthor = new Author();
                    String dynamicName = "Иван";
                    originalAuthor.setName(dynamicName);
                    originalAuthor.setCountry("США");
                    originalAuthor.setDate("01.01.1910");
                    Book originalBook = new Book();
                    originalBook.setName("Книга");
                    originalBook.setYear(1999);
                    originalBook.setAuthor(originalAuthor);

                    try {
                        System.out.println("Имя оригинального автора: " + originalBook.author.getName());
                        System.out.println("Меняем имя автора у оригинальной книги. . .");
                        Book shallowClonedBook = originalBook.shallowClone();
                        Book deepClonedBook = originalBook.deepClone();
                        originalAuthor.setName("Игорь");
                        originalBook.setAuthor(originalAuthor);
                        System.out.println("Имя оригинального автора: " + originalBook.author.getName());
                        System.out.println("Имя клонированного автора (мелкое клонирование): " + shallowClonedBook.author.getName());
                        System.out.println("Имя клонированного автора (глубокое клонирование): " + deepClonedBook.author.getName());
                    } catch (CloneNotSupportedException e) {
                        System.out.println("Ошибка клонирования!");
                    }
                    break;
                case 7:
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