
public class NODE extends LISTELEMENT {
    private DATA data;
    private LISTELEMENT successor;

    public NODE(DATA dataN, LISTELEMENT successorN) {
        data = dataN;
        successor = successorN;
    }
    public NODE insert (DATA dataN) {
        successor = successor.insert(dataN);
        return this;
    }

    public LISTELEMENT delete (String nameN) {
        if(this.data.GetName().equals(nameN)) {
            return this.successor;
        }
        else {
            this.successor = this.successor.delete(nameN);
            return this;
        }
    }

    public void update (String name, DATA dataN) {
        if(this.data.GetName().equals(name)) {
            this.data = dataN;
        }
        else {
            this.successor.update(name, dataN);
        }
    }
}