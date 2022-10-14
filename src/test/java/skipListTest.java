import skipList.SkipList;

public class skipListTest {
    public static void main(String[] args) {
        SkipList list=new SkipList();
        for(int i=1;i<20;i++)
        {
            list.add(i, 666);
        }
        list.printList();
        list.delete(4);
        list.delete(8);
        list.printList();

        System.out.println(list.search(5).value);
    }
}
