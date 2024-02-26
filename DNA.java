/**
 * This class models a DNA sequence
 *
 * @author Peter, made this back in wisconsin madison cs 300, i miss that place! I still like michgian though!
 *
 */
public class DNA {
  protected LinkedQueue<Character> DNA;
  protected static String[][] mRNAtoProteinMap =
      {{"UUU", "F"}, {"UUC", "F"}, {"UUA", "L"}, {"UUG", "L"}, {"UCU", "S"}, {"UCC", "S"},
          {"UCA", "S"}, {"UCG", "S"}, {"UAU", "Y"}, {"UAC", "Y"}, {"UAA", "STOP"}, {"UAG", "STOP"},
          {"UGU", "C"}, {"UGC", "C"}, {"UGA", "STOP"}, {"UGG", "W"}, {"CUU", "L"}, {"CUC", "L"},
          {"CUA", "L"}, {"CUG", "L"}, {"CCU", "P"}, {"CCC", "P"}, {"CCA", "P"}, {"CCG", "P"},
          {"CAU", "H"}, {"CAC", "H"}, {"CAA", "Q"}, {"CAG", "Q"}, {"CGU", "R"}, {"CGC", "R"},
          {"CGA", "R"}, {"CGG", "R"}, {"AUU", "I"}, {"AUC", "I"}, {"AUA", "I"}, {"AUG", "M"},
          {"ACU", "T"}, {"ACC", "T"}, {"ACA", "T"}, {"ACG", "T"}, {"AAU", "N"}, {"AAC", "N"},
          {"AAA", "K"}, {"AAG", "K"}, {"AGU", "S"}, {"AGC", "S"}, {"AGA", "R"}, {"AGG", "R"},
          {"GUU", "V"}, {"GUC", "V"}, {"GUA", "V"}, {"GUG", "V"}, {"GCU", "A"}, {"GCC", "A"},
          {"GCA", "A"}, {"GCG", "A"}, {"GAU", "D"}, {"GAC", "D"}, {"GAA", "E"}, {"GAG", "E"},
          {"GGU", "G"}, {"GGC", "G"}, {"GGA", "G"}, {"GGG", "G"}};

  /**
   * Creates the DNA queue from the provided String. Each Node contains a single Character from the
   * sequence.
   * 
   * @param sequence - a String containing the original DNA sequence
   */
  public DNA(String sequence) {
    DNA = new LinkedQueue<Character>();
    for (int i = 0; i < sequence.length(); i++) {
      DNA.enqueue(sequence.charAt(i));
    }
  }

  /**
   * Creates and returns a new queue of mRNA characters from the stored DNA. The transcription is
   * done one character at a time, as (A->U, T->A, C->G, G->C).
   * 
   * @return the queue containing the mRNA sequence corresponding to the stored DNA sequence
   */
  public LinkedQueue<Character> transcribeDNA() {
    LinkedQueue<Character> transcribedDNA = new LinkedQueue<Character>();
    LinkedQueue<Character> DNACopy = new LinkedQueue<Character>();
    int fixedSize = DNA.size();
    for (int i = 0; i < fixedSize; i++) {
      Character currChar = DNA.dequeue();
      if (currChar.equals('A')) {
        transcribedDNA.enqueue('U');
      } else if (currChar.equals('T')) {
        transcribedDNA.enqueue('A');
      } else if (currChar.equals('C')) {
        transcribedDNA.enqueue('G');
      } else if (currChar.equals('G')) {
        transcribedDNA.enqueue('C');
      }
      DNACopy.enqueue(currChar);
    }
    for (int i = 0; i < fixedSize; i++) {
      DNA.enqueue(DNACopy.dequeue());
    }
    return transcribedDNA;


  }

  /**
   * Creates and returns a new queue of amino acids from a provided queue of mRNA characters. The
   * translation is done three characters at a time, according to the static mRNAtoProteinMap
   * provided above. Translation ends either when you run out of mRNA characters OR when a STOP
   * codon is reached (i.e. the three-character sequence corresponds to the word STOP in the map,
   * rather than a single amino acid character).
   * 
   * @param mRNA - a queue containing the mRNA sequence corresponding to the stored DNA sequence
   * @return the queue containing the amino acid sequence corresponding to the provided mRNA
   *         sequence
   */
  public LinkedQueue<String> mRNATranslate(LinkedQueue<Character> mRNA) {
    LinkedQueue<String> codonQueue = new LinkedQueue<String>();
    LinkedQueue<String> aminoAcidSequence = new LinkedQueue<String>();
    while (mRNA.size() >= 3) {
      String toTranslate =
          mRNA.dequeue().toString() + mRNA.dequeue().toString() + mRNA.dequeue().toString();
      codonQueue.enqueue(toTranslate);
    }
    while (codonQueue.size() > 0) {
      String currCodon = codonQueue.dequeue();
      if (currCodon.equals("UAG") || currCodon.equals("UGA") || currCodon.equals("UAA")) {
        break;
      }
      for (int i = 0; i < mRNAtoProteinMap.length; i++) {
        if (currCodon.equals(mRNAtoProteinMap[i][0])) {
          aminoAcidSequence.enqueue(mRNAtoProteinMap[i][1]);
        }
      }
    }
    return aminoAcidSequence;
  }

  /**
   * A shortcut method that translates the stored DNA sequence to a queue of amino acids using the
   * other two methods in this class
   * 
   * @return the queue containing the amino acid sequence corresponding to the stored DNA sequence,
   *         via its mRNA transcription
   */
  public LinkedQueue<String> translateDNA() {
    return mRNATranslate(transcribeDNA());
  }
}
