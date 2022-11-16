package BST;

public abstract class AbstractBST <T>{
    class Node extends AbstractNode{
        @Override
        void addNode(Object vali) {

        }

        @Override
        void searchForNodes(int number) {

        }
    }

    Node root;

    // Uruchom addNode dla Node (Node najpewniej powinien być priv)
    abstract void addNode(T value);

    //Porównanie wartości jakie są na węzłach
    abstract boolean compareValues(T a, T b);



}

