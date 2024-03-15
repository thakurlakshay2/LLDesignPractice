package Cache_LLD.Algorithms;

public class DoubleLinkedListNode<E> {

    DoubleLinkedListNode<E> prev;

    DoubleLinkedListNode<E> next;

    E element;

    public DoubleLinkedListNode(E element){
        this.element=element;
        this.prev=null;
        this.next=null;
    }

    public E getElement(){
        return this.element;
    }
}
