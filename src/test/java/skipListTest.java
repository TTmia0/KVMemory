import kvMeory.kvM;
import kvMeory.kvMImpl;
import skipList.SkipList;

public class skipListTest {
    public static void main(String[] args) {
         kvM list = new kvMImpl();
        for(int i=1;i<20;i++)
        {
            list.set(i, 666);
        }
        list.printList();
        list.rm(4);
        list.rm(8);
        list.printList();

        System.out.println(list.get(5));
    }
}
