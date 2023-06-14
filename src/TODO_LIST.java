public class TODO_LIST {
    LISTELEMENT start;
    public TODO_LIST() {
        start = new EMPTY();
    }

    public void insert(DATA dataN) {
        NODE nodeN = new NODE(dataN, start);
        start = nodeN;
    }

    public void delete(String nameN) {
        start = start.delete(nameN);
    }

    public void update(String name, DATA dataN) {
        start.update(name, dataN);
    }


}
