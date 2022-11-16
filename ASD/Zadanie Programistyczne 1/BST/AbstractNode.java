package BST;

public abstract class AbstractNode <T> {

    T value;
    AbstractNode leftNode;
    AbstractNode rightNode;

    //Możliwość dodawania kolejnych węzłów
    // Musisz najpierw sprawdzić czy mniejszy czy większe
    // Następnie zależnie od wyniku dodać, do lewej lub prawej strony
    // Ale trzeba sprawdzić czy lewa / prawa jest null, jak tak to tam tworzymy node
    // W innym przypadku rekurencyjnie uruchamiamy to na tym węźle
     abstract void addNode(T vali);

     abstract void searchForNodes (int number);
}
