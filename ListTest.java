/**
 *  Testing List ADT
 */
public class ListTest
{
   public static void main(String[] argv)
   {
      List<Integer> L = new AList<Integer>(12);

      // testing append
      L.append(10);
      L.append(20);
      L.append(15);
      System.out.println(L);

      // testing remove
      L.append(1);
      System.out.println(L);
      L.remove();
      System.out.println(L);

      // testing insert
      L.clear();
      L.moveToStart();
      L.insert(1);
      System.out.println(L);
      L.insert(2);
      System.out.println(L);
      L.moveToPos(2);
      L.insert(3);
      System.out.println(L);
  }
}
