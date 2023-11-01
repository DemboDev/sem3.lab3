import java.util.Scanner;

import static java.lang.System.exit;

public class Author {
    final int LenDate = 11;
    final int Len = 30;
    private String name;
    private String date;
    private String country;

    public String getName() {
        return name;
    }
    public String getDate() {
        return date;
    }

    public String getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Author(){}
    public void setCountry(String country) {
        this.country = country;
    }

    public Author(String name, String date, String country) {
        setArguments(name, date, country);
    }

    public void setArguments(String name, String date, String country){
        if (name.isEmpty() || country.isEmpty()) {
            exit(-1);
        }
        else if (date.length() != LenDate - 1) {
            exit(-1);
        }
        else {
            setName(name);
            setDate(date);
            setCountry(country);
        }
    }
    public void printAuthor() { // вывод информации об авторе
        System.out.println(this.getName());
        System.out.println(this.getCountry());
        System.out.println(this.getDate());
    }

    public void input() {
        String name, date, country;

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите имя автора");
        name = sc.nextLine();
        char[] ch;
        do {
            do {
                System.out.println("Введите дату рождения автора в формате DD.MM.YYYY");
                date = sc.nextLine();
                ch = date.toCharArray();
            } while (ch[0] < '0' || ch[0] > '3' || ch[1] < '0' || (ch[1] > '1' && ch[0] > '2') || ch[1] > '9' || ch[2] != '.' || ch[3] < '0' || (ch[3] == '1' && ch[4] > '2') || ch[3] > '1' || ch[4] < '0' || (ch[4] > '0' && ch[3] > '2') || ch[4] > '9' || ch[5] != '.' || ch[6] < '0' || ch[6] > '9' || ch[7] < '0' || ch[7] > '9' || ch[8] < '0' || ch[8] > '9' || ch[9] < '0' || ch[9] > '9');
        } while (date.length() != 10);
        System.out.println("Введите страну происхождения автора");
        country = sc.nextLine();
        this.setArguments(name, date,country);
    }
}

