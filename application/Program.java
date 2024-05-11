// Made by:
// - Natan Moreira Passos - RA: 10417916
// - Nicolas Henriques de Almeida - RA: 10418357
// References:
// - Code Incomplete Zine, by André Kishimoto
// - https://profkishimoto.github.io/edi03d-2024-1/
// - https://profkishimoto.github.io/edi03d-2024-1/conteudo/semana-10/LinkedList.pdf
// - https://www.geeksforgeeks.org/how-to-sort-a-linkedlist-in-java/
// - https://www.geeksforgeeks.org/reverse-a-linked-list/

package application;

import linkedList.LinkedList;
import linkedList.Node;

public class Program {
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		Node node = new Node();
		
		//printing the empty list
		System.out.println(ll);
		
		//using the insert method
		System.out.println("========INSERT========");
		ll.insert(4.0f);
		ll.insert(3.0f);
		ll.insert(5.0f);
		System.out.println(ll);
		
		//using the append method
		System.out.println("========APPEND========");
		ll.append(6.0f);
		ll.append(7.0f);
		ll.append(9.0f);
		System.out.println(ll);
		
		//clearing the list and using
		//the insert ascending method
		System.out.println("========CLEAR========");
		ll.clear();
		System.out.println(ll);
		
		System.out.println("========INSERTASC========");
		ll.insertAsc(5.0f);
		ll.insertAsc(7.0f);
		ll.insertAsc(6.0f);
		ll.insertAsc(4.0f);
		ll.insertAsc(8.0f);
		System.out.println(ll);
		
		//clearing the list and using 
		//the insert ascending with
		//no duplicates method
		System.out.println("========CLEAR========");
		ll.clear();
		System.out.println(ll);
		
		System.out.println("========INSERTASCNODUP========");
		System.out.println(ll.insertAscNoDup(5.0f));
		System.out.println(ll.insertAscNoDup(3.0f));
		System.out.println(ll.insertAscNoDup(4.0f));
		System.out.println(ll.insertAscNoDup(5.0f));
		System.out.println(ll.insertAscNoDup(6.0f));
		System.out.println(ll);
		
		//clearing the list and using
		//the insert descending method
		System.out.println("========CLEAR========");
		ll.clear();
		System.out.println(ll);
		
		System.out.println("========INSERTDESC========");
		ll.insertDesc(5.0f);
		ll.insertDesc(7.0f);
		ll.insertDesc(6.0f);
		ll.insertDesc(4.0f);
		ll.insertDesc(7.0f);
		ll.insertDesc(8.0f);
		System.out.println(ll);
		
		//clearing the list and using 
		//the insert descending with
		//no duplicates method
		System.out.println("========CLEAR========");
		ll.clear();
		System.out.println(ll);
		
		System.out.println("========INSERTDESCNODUP========");
		System.out.println(ll.insertDescNoDup(5.0f));
		System.out.println(ll.insertDescNoDup(3.0f));
		System.out.println(ll.insertDescNoDup(4.0f));
		System.out.println(ll.insertDescNoDup(5.0f));
		System.out.println(ll.insertDescNoDup(6.0f));
		System.out.println(ll);
		
		//using the remove head method
		System.out.println("========REMOVEHEAD========");
		System.out.println(ll);
		node = ll.removeHead();
		System.out.println("Removed node: " + node);
		System.out.println(ll);
		
		//using the remove tail method
		System.out.println("========REMOVETAIL========");
		System.out.println(ll);
		node = ll.removeTail();
		System.out.println("Removed node: " + node);
		System.out.println(ll);
		
		//using the remove node method
		System.out.println("========REMOVENODE========");
		System.out.println(ll);
		node = ll.removeNode(3.0f);
		System.out.println("Removed node: " + node);
		System.out.println(ll);
		node = ll.removeNode(4.0f);
		System.out.println("Removed node: " + node);
		System.out.println(ll);
		
		//adding more values for the next test
		ll.append(5.0f);
		ll.append(4.0f);
		ll.append(5.0f);
		ll.append(3.0f);
		ll.append(5.0f);
		ll.append(2.0f);
		
		//using the remove duplicates method
		System.out.println("========REMOVEDUP========");
		System.out.println(ll);
		int count = ll.removeDup();
		System.out.println("Duplicates removed: " + count);
		System.out.println(ll);
		
		//using the get head method
		System.out.println("========GETHEAD========");
		System.out.println(ll);
		System.out.println("Head: " + ll.getHead());
		
		//using the get tail method
		System.out.println("========GETTAIL========");
		System.out.println(ll);
		System.out.println("Tail: " + ll.getTail());
		
		//using the get node method
		System.out.println("========GETNODE========");
		System.out.println(ll);
		System.out.println(ll.getNode(3.0f));
		System.out.println(ll.getNode(7.0f));
		
		//using the count method
		System.out.println("========COUNT========");
		System.out.println(ll);
		System.out.println("Count: " + ll.count());
		
		//using the is empty method
		System.out.println("========ISEMPTY========");
		System.out.println(ll);
		System.out.println("Is empty: " + ll.isEmpty());
		
		//using the clear method
		System.out.println("========CLEAR========");
		System.out.println(ll);
		ll.clear();
		System.out.println(ll);
		
		//adding more values for the next example
		ll.append(5.0f);
		ll.append(4.0f);
		ll.append(6.0f);
		ll.append(3.0f);
		ll.append(1.0f);
		ll.append(2.0f);
		
		//using the sort method
		System.out.println("========SORT========");
		System.out.println(ll);
		ll.sort();
		System.out.println(ll);
		
		//using the reverse method
		System.out.println("========REVERSE========");
		System.out.println(ll);
		ll.reverse();
		System.out.println(ll);
		System.out.println("Head: " + ll.getHead());
		System.out.println("Tail: " + ll.getTail());
		
		//using the is equal method
		System.out.println("========ISEQUAL========");
		LinkedList testList = ll;
		System.out.println(ll);
		System.out.println(testList);
		System.out.println(ll.isEqual(testList));
		LinkedList testList2 = new LinkedList();
		System.out.println(ll.isEqual(testList2));
	}
}