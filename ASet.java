/** Set ADT 
A program to find the size of a set, check if an item is a member of a given set, check whether a given set is empty or not, 
 and find the union, intersection, difference, and symmetric difference of two sets.
    @author Ibsa Tassew Geleta
*/

class ASet<E> implements Set<E>  
{ 
  private static final int defaultSize = 20; // Default size
  private int maxSize;        // Maximum size of set
  private int setSize;       // Current # of set items
  private int curr;           // Position of current element
  private E[] setArray;      // Array holding set elements

   ASet() { this(defaultSize);}
    @SuppressWarnings("unchecked") // Generic array allocation
   ASet(int size) { 
    maxSize = size;
    setSize = curr = 0;
    setArray = (E[])new Object[size];  // Create setArray
  } 
  /** @return true if item is in this set; false otherwise. */
  public boolean contains(E item){
    for(int i = 0; i<size(); i++) {
  	  if (item == setArray[i]){
  		  return true;
  	}
   }
        return false;
   }
   /** @return true if this set is empty; false otherwise. */
  public boolean isEmpty(){
   	if(size()>0){
   		return false;
   	}
   		return true;
   
     }
   /** @return the number of elements in this set. */
  public int size(){
   	return setSize;
   
   }
   /** Insert an element at the current location. 
      @param item The element to be inserted. */
  public void insert(E item) {
      
    setArray[curr] = item;
    setSize++;   // Increment the size of set items           
    curr++; // Increment Position of current element
  
   }
   /** @return The data element of the item at position i. */
  public E getValue(int i){
   assert (curr>=0) && (curr<setSize):
           "No current element";
    return setArray[i];
   }
   /** Compute the union of two sets.
      @param S another set
      @return the union of this set with S.
   */
  public Set<E> union(Set<E> S) {
   	Set<E> union = new ASet<E>();
   	for(int i = 0; i<size(); i++){
   		union.insert(setArray[i]);
   		}
   	
   	for(int i = 0; i<S.size(); i++) {
   		if(!contains(S.getValue(i))){
   			 union.insert(S.getValue(i));
   		} 
   	}
   	return union;
   } 
    /** Compute the intersection of two sets.
      @param S another set
      @return the intersection of this set with S.
   */
  public Set<E> intersect(Set<E> S){
   Set<E> intersect = new ASet<E>();
   	for(int i = 0; i<S.size(); i++) {
   		if(contains(S.getValue(i))){
   			intersect.insert(S.getValue(i));
   		} 
   	}
   	return intersect;
   } 
  /** Compute the difference of two sets.
      @param S another set
      @return the difference of this set with S.
   */
  public Set<E> diff(Set<E> S) {
    Set<E> diff = new ASet<E>();
    for(int i = 0; i<setSize; i++) {
      if(!S.contains(setArray[i]))
        diff.insert(setArray[i]);
   }
    return diff;

  }
  /** Compute the symmetric difference of two sets.
      @param S another set
      @return the symmetric difference of this set with S.
   */
  public Set<E> symDiff(Set<E> S) {
    Set<E> symDiff = new ASet<E>();
    for(int i = 0; i<setSize; i++) {
      if(!S.contains(setArray[i])){
        symDiff.insert(setArray[i]);
      }
   }
   for(int i = 0; i<S.size(); i++) {
    if(!contains(S.getValue(i))){
      symDiff.insert(S.getValue(i));

    }
 }
    return symDiff;
    }
    /** @return a string that contains all elements in this set */
  public String toString()
  {
 
    StringBuffer out = new StringBuffer((size() + 1) * 4);

    out.append("< ");
    for (int i = 0; i < size(); i++) {
      out.append(getValue(i));
      out.append(" ");
    }
    out.append(">");
 
    return out.toString();
  }
}
