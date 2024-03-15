package Cache_LLD.Algorithms;


import Cache_LLD.Algorithms.exceptions.InvalidElementException;
import Cache_LLD.Algorithms.exceptions.InvalidNodeException;

//@Getter
public class DoubleLinkedList<E> {
        DoubleLinkedListNode<E> first;
         DoubleLinkedListNode<E> last;

      public DoubleLinkedList(){
          this.first=null;
          this.last=null;
      }

      public void detatchNode(DoubleLinkedListNode<E> node){
        if(node==null){
            return ;
        }

        if(node.equals(first)){
            first=first.next;
            if(first!=null){
                first.prev=null;
            }
        }else{
            node.prev.next=node.next;
          if(node.next!=null)  node.next.prev=node.prev;
        }
      }

      public void addNodeToLast(DoubleLinkedListNode<E> node) {
            if(node==null){
//                throw new InvalidNodeException();
            }

            if(last==null){
                last=node;
                first=node;
            }else{
                last.next=node;
                node.prev=last;
                node.next=null;
                last=node;
            }
      }

      public DoubleLinkedListNode<E> addElementAtLast(E element) {
            if(element==null){
                throw new InvalidElementException();
            }
            DoubleLinkedListNode<E> newNode =new DoubleLinkedListNode<>(element);

            addNodeToLast(newNode);
            return newNode;
      }

      public DoubleLinkedListNode<E> getFirst(){
        return first;
      }

      public void removeNode(DoubleLinkedListNode<E> node){

      }

}
