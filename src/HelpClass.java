public class HelpClass {
    static public int KEffectiveness(Library library) { // Оценка эффективности полезности библиотеки, исходя из того, сколько книг из имеющихся было взято в обращение (100 бальная)
        int k = (int) ((double) (library.NumBooks + library.NumReaders) / library.NumOperations) * 50;
        return k;
    }
}
