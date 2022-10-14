package kvMeory;

public interface kvM<T> {
    T get(int key);
    void set(int key, T value);
    void rm(int key);

    void printList();
}
