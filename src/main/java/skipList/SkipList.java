package skipList;

import java.util.Random;
import java.util.Stack;

public class SkipList {
    SkipNode headNode;
    int highLevel;
    Random random;

    final int MaxLevel = 32;

    public SkipList(){
        random = new Random();
        headNode = new SkipNode<>(Integer.MIN_VALUE, null);
        highLevel = 0;
    }

    public SkipNode search(int key){
        SkipNode teamNode = headNode;
        while(teamNode != null){
            if(teamNode.key == key){
                return teamNode;
            }else if(teamNode.right == null){
                teamNode = teamNode.down;
            }else if(teamNode.right.key > key){
                teamNode = teamNode.down;
            }else{
                teamNode = teamNode.right;
            }
        }
        return null;
    }

    public void delete(int key){
        SkipNode teamNode = headNode;
        while(teamNode != null){
            if(teamNode.right == null){
                teamNode = teamNode.down;
            }else if(teamNode.right.key == key){
                teamNode.right = teamNode.right.right;
                teamNode = teamNode.down;
            }else if(teamNode.right.key > key){
                teamNode = teamNode.down;
            }else{
                teamNode =teamNode.right;
            }
        }
    }

    public <T> void add(int key, T value){
        SkipNode node = new SkipNode(key, value);
        SkipNode findNode = search(node.key);
        if(findNode != null){
            findNode.value = node.value;
            return;
        }

        SkipNode teamNode = headNode;
        Stack<SkipNode> stack = new Stack<>();
        while(teamNode != null){
            if(teamNode.right == null){
                stack.push(teamNode);
                teamNode = teamNode.down;
            }else if(teamNode.right.key > node.key){
                stack.push(teamNode);
                teamNode = teamNode.down;
            }else{
                teamNode = teamNode.right;
            }
        }

        int level = 1;
        SkipNode pre = null;
        while(!stack.isEmpty()){
            SkipNode newNode = new SkipNode<>(key, value);
            newNode.down = pre;
            pre = newNode;
            SkipNode sNode = stack.pop();
            if (sNode.right != null) {
                newNode.right = sNode.right;
            }
            sNode.right = newNode;

            if(level > MaxLevel){
                break;
            }
            double num = random.nextDouble();
            if(num > 0.5){
                break;
            }
            level++;
            if(level > highLevel){
                highLevel = level;
                SkipNode newHeadNode = new SkipNode(Integer.MIN_VALUE, null);
                newHeadNode.down = headNode;
                headNode = newHeadNode;
                stack.push(headNode);
            }
        }
    }

    public void printList(){
        SkipNode teamNode = headNode;
        SkipNode LastNode = headNode;
        while(LastNode != null && LastNode.down != null){
            LastNode = LastNode.down;
        }
        while(teamNode != null){
            SkipNode HighNode = teamNode.right;
            SkipNode LowNode = LastNode.right;
            System.out.printf("%-8s", "head->");
            while(HighNode != null && LowNode != null){
                if(HighNode.key == LowNode.key){
                    System.out.printf("%-5s", HighNode.key+"->");
                    HighNode = HighNode.right;
                }else{
                    System.out.printf("%-5s", "");
                }
                LowNode = LowNode.right;
            }
            System.out.println();
            teamNode = teamNode.down;
        }
    }

}


