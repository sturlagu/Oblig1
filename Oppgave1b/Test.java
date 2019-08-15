/*
 * This program can alter a single-linked-list with the few methods; add an element at start,
 * remove an element at start, write the length of the list, write out the whole list, and
 * delete the whole list and its elements.
 */
import java.util.Scanner;
public class Test{
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		//Variables
		int choice;
		int status;
		boolean running = true;
		//Creating the list
		SingleLinkedList list = new SingleLinkedList();

		System.out.println("This program can make and edit a single linked list.");
		options();
		while(running){
			System.out.println("\nTyping 16 will give you all the options");
			System.out.println("Please choose one option:");
			choice = input.nextInt();
			if(choice == 1){
				errorUpdate(list.deleteElementOne(), "First element deleted");
			}
			else if(choice == 2){
				errorUpdate(list.deleteLastElement(), "Last element deleted");
			}
			else if(choice == 3){
				System.out.println("Enter the value to delete:");
				choice = input.nextInt();
				errorUpdate(list.deleteFirstGivenValue(choice), "First value of " + choice + " deleted");
			}
			else if(choice == 4){
				System.out.println("Enter the value to delete:");
				choice = input.nextInt();
				errorUpdate(list.deleteAllGivenValue(choice), "All values of " + choice + " deleted");
			}
			else if(choice == 5){
				System.out.println("Write the value of the element: ");
				choice = input.nextInt();
				errorUpdate(list.addElementOne(choice), "Value " + choice + " added to 1st position");
			}
			else if(choice == 6){
				System.out.println("Write the value of the element: ");
				choice = input.nextInt();
				errorUpdate(list.addGivenValueAtEnd(choice), "Value " + choice + " added last");
			}
			else if(choice == 7){
				int searchValue;
				System.out.println("Write the value to search for: ");
				searchValue = input.nextInt();
				System.out.println("Write the value of the element");
				choice = input.nextInt();
				errorUpdate(list.addGivenValueAfterElement(choice, searchValue), "Value " + choice + " added before element " + searchValue);
			}
			else if(choice == 8){
				int searchValue;
				System.out.println("Write the value to search for: ");
				searchValue = input.nextInt();
				System.out.println("Write the value of the element");
				choice = input.nextInt();
				errorUpdate(list.addGivenValueBeforeElement(choice, searchValue), "Value " + choice + " added after element " + searchValue);
			}
			else if(choice == 9){
				System.out.println("The length of the list is: " + list.listLength());
			}
			else if(choice == 10){
				System.out.println("List is equal to elementCount: " +list.checkElementcount());
			}
			else if(choice == 11){
				System.out.println("Enter the value to search for:");
				choice = input.nextInt();
				System.out.println("There is " + list.checkGivenValue(choice) + " encounters of value " +choice);
			}
			else if(choice == 12){
				System.out.println("List: ");
				System.out.println(list.writeList());
			}
			else if(choice == 13){
				int deletedElements = list.deleteList();
				System.out.println(+ deletedElements + " element(s) deleted");
			}
			else if(choice == 14){
				int error = list.findBiggestValue()[1];
				int value = list.findBiggestValue()[0];
				errorUpdate(error, "The biggest value is: " + value);
			}
			else if(choice == 15){
				int error = list.findSmallestValue()[1];
				int value = list.findSmallestValue()[0];
				errorUpdate(error, "The smallest value is: " + value);
			}
			else if(choice == 16){
				options();
			}
			else if(choice == 0){
				running = false;
			}
			else{
				System.out.println("Unknow choice, please try again");
			}
		}//While end
	}// main end
	public static void errorUpdate(int error, String errorMessage){
		int status = error;
		if(status == -1)
			System.out.println("List is empty!");
		else if(status == 0)
			System.out.println("Value not found!");
		else
			System.out.println(errorMessage);
	}
	public static void options(){
		System.out.println("1. Delete the first element of the list\n2. Delete the last element in the list."
					+  "\n3. Delete first given value\n4. Delete all given values"
					+  "\n5. Add an element to the first position of the list\n6. Add an element to the last position"
					+  "\n7. Search for value and add element after\n8. Search for value and add element before "
					+  "\n9. Get the length of the list\n10. Check elements to elementcount"
					+  "\n11. Check how many encounters of given value\n12. Print out the whole list\n13. Delete the whole list"
					+  "\n14. Find the largest value in the list\n15. Find the smallest value in the list"
					+  "\n16. Get the option menu\n0. Exit");
	}
}