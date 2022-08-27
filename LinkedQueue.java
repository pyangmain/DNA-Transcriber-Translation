import java.util.NoSuchElementException;

/**
 * 
 * @author Peter
 *
 * @param <T> generic variable
 */
public class LinkedQueue<T> implements QueueADT<T> {
  protected Node<T> back;
  protected Node<T> front;
  private int n;

  /**
   * Adds the given data to this queue; every addition to a queue is made at the back
   * 
   * @param data - the data to add
   */
  @Override
  public void enqueue(T data) {
    Node<T> tempBack = new Node<T>(data);
    if (n == 0) {
      back = tempBack;
      front = tempBack;
    } else {
      back.setNext(tempBack);
      back = tempBack;
    }
    n = n + 1;
  }

  /**
   * Removes and returns the item from this queue that was least recently added
   * 
   * @return the item from this queue that was least recently added
   * @throws NoSuchElementException if this queue is empty
   */
  @Override
  public T dequeue() throws NoSuchElementException {
    if (this.size() == 0 || front == null || back == null) {
      throw new NoSuchElementException("Queue is empty");
    }
    T tempFront = front.getData();
    front = front.getNext();
    n = n - 1;
    return tempFront;
  }

  /**
   * Returns the item least recently added to this queue without removing it
   * 
   * @return the item least recently added to this queue
   * @throws NoSuchElementException if this queue is empty
   */
  @Override
  public T peek() throws NoSuchElementException {
    if (this.size() == 0) {
      throw new NoSuchElementException("Queue is empty");
    }
    return this.front.getData();
  }

  /**
   * Checks whether the queue contains any elements
   * 
   * @return true if this queue is empty; false otherwise
   */
  @Override
  public boolean isEmpty() {
    return n == 0;
  }

  /**
   * Returns the number of items in this queue
   * 
   * @return the number of items in this queue
   */
  @Override
  public int size() {
    return n;
  }

  /**
   * Returns a string representation of this queue, beginning at the front (least recently added) of
   * the queue and ending at the back (most recently added). An empty queue is represented as an
   * empty string; otherwise items in the queue are represented using their data separated by spaces
   * 
   * @return the sequence of items in FIFO order, separated by spaces
   */
  @Override
  public String toString() {
    String queueString = "";
    Node<T> tempFront = front;
    for (int i = 0; i < this.n; i++) {
      queueString = queueString.concat(" " + tempFront.getData().toString());
      tempFront = tempFront.getNext();
    }
    return queueString.trim();
  }
}
