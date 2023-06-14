public class EMPTY extends LISTELEMENT {
    public EMPTY() {
    }
    public NODE insert(DATA dataN) {
        return new NODE(dataN, this);
    }

    public LISTELEMENT delete(String nameN) {
        return this;
    }

    public void update(String name, DATA dataN) { }
}
