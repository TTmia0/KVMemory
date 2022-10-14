package kvMeory;

import skipList.SkipList;
import skipList.SkipNode;

public class kvMImpl<T> implements kvM{

    SkipList skipList;

    public kvMImpl(){
        this.skipList = new SkipList();
    }

    @Override
    public Object get(int key) {
        return this.skipList.search(key).value;
    }

    @Override
    public void set(int key, Object value) {
        this.skipList.add(key, value);
    }

    @Override
    public void rm(int key) {
        this.skipList.delete(key);
    }

    @Override
    public void printList() {
        this.skipList.printList();
    }
}
