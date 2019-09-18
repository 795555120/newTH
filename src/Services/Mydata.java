package Services;

import java.util.List;

public class Mydata {
    private List<String[]> list;
    private int length;

    public Mydata() {
    }

    public Mydata(List<String[]> list, int length) {
        this.list = list;
        this.length = length;
    }

    public List<String[]> getList() {
        return list;
    }

    public void setList(List<String[]> list) {
        this.list = list;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
