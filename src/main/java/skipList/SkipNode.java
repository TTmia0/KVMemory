package skipList;

public class SkipNode<T> {

        public int key;
        public T value;
        SkipNode right;
        SkipNode down;
        public SkipNode(int key, T value){
            this.key = key;
            this.value = value;
        }

}
