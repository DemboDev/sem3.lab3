public abstract class AbstractAuthor<D, N, C> {
    public abstract N getName();
    public abstract C getCountry();
    public abstract D getDate();
    public abstract void setName(N name);
    public abstract void setDate(D date);
    public abstract void setCountry(C country);
    public abstract void setArguments(C name, D date, C country);
}
