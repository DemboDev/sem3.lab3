import java.util.Scanner;

import static java.lang.System.exit;

public class Client {
    static final int Len = 30;
    static final int LenDate = 11;
    private static int nClients = 0;
    public static int getCount() {
        return nClients;
    }
    private String name;
    private String date;
    private String address;
    public Client(){nClients++;}
    public Client(String name) {nClients++;
        this.name = name;
        this.date = "11.11.1911\0";
        this.address = "Россия\0";
    }
    public Client(String name, String date, String address) {nClients++;
        setArguments(name, date, address);
    }


    public void setArguments(String name, String date, String address) {
        if (name.isEmpty() || date.length() != LenDate - 1 || address.isEmpty()) {
            exit(-1);
        }
        else {
            this.name = name;
            this.date = date;
            this.address = address;
        }
    }
    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void input() {
        String name, date, address;

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите имя читателя");
        name = sc.nextLine();
        char [] ch;
        do {
            do {
                System.out.println("Введите дату рождения читателя в формате DD.MM.YYYY");
                date = sc.nextLine();
                ch = date.toCharArray();
            } while (ch[0] < '0' || ch[0] > '3' || ch[1] < '0' || (ch[1] > '1' && ch[0] > '2') || ch[1] > '9' || ch[2] != '.' || ch[3] < '0' || (ch[3] == '1' && ch[4] > '2') || ch[3] > '1' || ch[4] < '0' || (ch[4] > '0' && ch[3] > '2') || ch[4] > '9' || ch[5] != '.' || ch[6] < '0' || ch[6] > '9' || ch[7] < '0' || ch[7] > '9' || ch[8] < '0' || ch[8] > '9' || ch[9] < '0' || ch[9] > '9');
        } while (date.length() != 10);
        System.out.println("Введите адрес проживания читателя");
        address = sc.nextLine();

        this.setArguments(name, date, address);
    }
}
