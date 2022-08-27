import java.util.NoSuchElementException;

/**
 * Test methods.
 */
public class DNATester {



  /**
   * Tests the transcribeDNA() method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testTranscribeDNA() {
    DNA testDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
    String mRNA = "CCUCAGUCAAUUCGCUGGCCCUGUAUGACAGAACCAUUAGAGGCUCGAUCUUUCAGAGAC";
    System.out.println(testDNA.transcribeDNA().toString());
    if (testDNA.transcribeDNA().toString().replaceAll(" ", "").equals(mRNA)) {
      return true;
    }
    return false;
  }

  /**
   * Tests the translateDNA() method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testTranslateDNA() {
    DNA testDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
    System.out.println(testDNA.translateDNA().toString());
    if (testDNA.translateDNA().toString().replaceAll(" ", "").equals("PQSIRWPCMTEPLEARSFRD")) {
      return true;
    }
    return false;
  }

  /**
   * tests adding and removing things from your queue
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testEnqueueDequeue() {
    try {
    LinkedQueue<Integer> myInts = new LinkedQueue<Integer>();
    myInts.enqueue(1);
    myInts.enqueue(2);
    myInts.enqueue(3);
    if (myInts.front.getNext().getNext().getData() == null
        || myInts.front.getNext().getNext().getData() != 3) {
      System.out.println(
          "ERROR detected in class LinkedQueue method enqueue: your enqueue method failed to add a node");
      return false;
    }
    myInts.dequeue();
    if (myInts.front.getData() != 2) {
      System.out.println(
          "ERROR detected in class LinkedQueue method dequeue: your dequeue method failed to correctly dequeue a node");
      return false;
    }
    myInts.dequeue();
    myInts.dequeue();
    try {
      myInts.dequeue();
      System.out.println(
          "ERROR detected in class LinkedQueue method dequeue: your dequeue method failed to throw a NoSuchElementException when removing from a LinkedQueue of size 0");
      return false;
    } catch (NoSuchElementException e) {
    } catch (Exception e) {
      System.out.println(
          "ERROR detected in class LinkedQueue method dequeue: your dequeue method failed to throw a NoSuchElementException when removing from a LinkedQueue of size 0");
      return false;
    } } catch(Exception e) {
      System.out.println(
          "ERROR detected in class LinkedQueue method dequeue/enqueue: one of your enqueue dequeue methods wrongly thew an exception");
      return false;
    }
    return true;
  }

  /**
   * tests the queue's size and isEmpty methods
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testQueueSize() {
    
    try {
    LinkedQueue<Integer> myInts = new LinkedQueue<Integer>();
 
    myInts.enqueue(1);
    myInts.enqueue(2);
    myInts.enqueue(3);
    if (myInts.size() != 3) {
      System.out.println(
          "ERROR detected in class LinkedQueue method size: your size method failed to return the correct size");
      return false;
    }
    myInts.dequeue();
    myInts.dequeue();
    if (myInts.isEmpty()) {
      System.out.println(
          "ERROR detected in class LinkedQueue method isEmpty: your isEmpty method returned true when the LinkedQueue was not empty");
      return false;
    }
    
    myInts.dequeue();
    if (!myInts.isEmpty()) {
      System.out.println(
          "ERROR detected in class LinkedQueue method isEmpty: your isEmpty method returned false when the LinkedQueue was empty");
      return false;
    } } catch (Exception e) {
      System.out.println(
          "ERROR detected in class LinkedQueue method size: one of your enqueue dequeue methods wrongly thew an exception");
      return false;
    }
    
    return true;
  }

  /**
   * Tests the DNA class' mRNATranslate method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testMRNATranslate() {
    try {
    DNA testDNA = new DNA("CCGGCCCTCCGGTGGATCCAA");
    DNA testDNA2 = new DNA("GATTACA");
    
    System.out.println(testDNA.translateDNA().toString());
    if(!testDNA2.translateDNA().toString().replaceAll(" ", "").equals("LM")) {
      return false;
    }
    if (!testDNA.translateDNA().toString().replaceAll(" ", "").equals("GREAT")) { 
      return false;
    }
    return true;
    } catch(Exception e) {
      System.out.println(
          "ERROR detected in class LinkedQueue method translateDNA: your translateDNA method wrongly threw an exception");
      return false;
    }
  }


  /**
   * Main method - use this to run your test methods and output the results (ungraded)
   * 
   * @param args unused
   */
  public static void main(String[] args) {
    System.out.println("transcribeDNA: " + testTranscribeDNA());
    System.out.println("translateDNA: " + testTranslateDNA());
    System.out.println("QueueSize: " + testQueueSize());
    System.out.println("EnqueueDequeue: " + testEnqueueDequeue());
    System.out.println("MRNATranslate: " + testMRNATranslate());
  }

}
