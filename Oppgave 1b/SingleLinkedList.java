public class SingleLinkedList{
	private Node head;
	private int elementCount;
	public SingleLinkedList(){
		head = null;
		elementCount = 0;
	}
	//oblig 1a
	public int listLength(){
		return elementCount;
	}
	public int deleteList(){
		int deletedElements = elementCount;
		head = null;
		elementCount = 0;
		return deletedElements;
	}
	public String writeList(){
		String values = "";
		int shiftLine = 0;
		Node cPtr = head; // Making a copy of head because we don't want to mess with the position of the head
		if(elementCount == 0){
			values = "The list is empty!";
		}
		else{
			while(cPtr != null){ // "null" is the best indication to use for knowing when we hit the end of the list.
				values += cPtr.value+ ", ";
				cPtr = cPtr.next; // Making sure we move one step at a time.
				shiftLine++;
				if(shiftLine%5 == 0)// As long as shiftLine/5.0 does NOT make a rest, we do the following under.
					values += "\n";
			}
		}
		cPtr = head; // As cPtr hits the end of the list, we make sure to reset it to its original position(head)
		return values;
	}
	public int deleteElementOne(){
		int error = 0;
		if(head != null){ // if head = null the list is empty, so we want to make sure we dont delete elements when there are none.
			head = head.next; // We delete the first element by moving the first position one step ahead.
			elementCount--;
			error = 1;
		}
		else
			error = -1;

		return error;
	}
	public int addElementOne(int x){
		int error = 0;
		Node aNode = new Node(x, null);
		aNode.next = head; // the new node "aNode" needs to be linked to the seconds node in the list before we do anything
						   //else because we can lose its "reffering point"
		head = aNode; 	// head reefers to the first node in the list. The new node "aNode" will now be the new referring node.
		elementCount++;
		error = 1;
		return error;
	}// oblig 1a end
	//Oblig 1b
	public int deleteLastElement(){
		int error = 0;
		Node cPtr = head;
		if(elementCount == 0){
			error = -1;
		}
		else if(elementCount == 1){
			error = deleteElementOne();
		}
		else{
			for(int i = 1; i < listLength()-1; i++){
				cPtr = cPtr.next;
			}
			cPtr.next = null;
			cPtr = head;
			elementCount--;
			error = 1;
		}
		return error;
	}
	public int deleteFirstGivenValue(int value){
		int error = 0;
		Node cPtr = head;
		Node pPtr = head;
		if(elementCount == 0){
			error = -1;
		}
		else if(cPtr.value == value){
			error = deleteElementOne();
		}
		else{
			while(cPtr.value != value && cPtr.next != null){
				pPtr = cPtr;
				cPtr = cPtr.next;
			}
			if(cPtr.value == value){
				pPtr.next = cPtr.next;
				error = 1;
				elementCount--;
			}
			else{
				error = 0;
			}
		}
		pPtr = head;
		cPtr = head;
		return error;
	}
	public int deleteAllGivenValue(int value){
		int error = 0;
		int tempList = listLength();
		for(int i = listLength(); i >= 0; i--){
			deleteFirstGivenValue(value);
		}
		if(tempList > 0 && tempList == listLength()){
			error = 0;
		}
		else if(tempList == 0){
			error = -1;
		}
		else{
			error = 1;
		}
		return error;
	}
	public int addGivenValueAtEnd(int value){
		int error = 0;
		Node cPtr = head;
		if(elementCount > 0){
			while(cPtr.next != null){
				cPtr = cPtr.next;
			}
			Node aNode = new Node(value, null);
			cPtr.next = aNode;
			elementCount++;
			error = 1;
		}
		else{
			addElementOne(value);
			error = 1;
		}
		return error;
	}
	public int addGivenValueAfterElement(int value, int searchValue){
		int error = 0;
		Node cPtr = head;
		if(elementCount > 0){
			while(cPtr.value != searchValue && cPtr.next != null){
				cPtr = cPtr.next;
			}
			if(cPtr.value == searchValue && cPtr.next != null){
				Node aNode = new Node(value, null);
				aNode.next = cPtr.next;
				cPtr.next = aNode;
				elementCount++;
				error = 1;
			}
			else if(cPtr.value == searchValue && cPtr.next == null){
				addGivenValueAtEnd(value);
				error = 1;
			}
		}
		else{
			error = -1;
		}
		cPtr = head;
		return error;
	}
	public int addGivenValueBeforeElement(int value, int searchValue){
		int error = 0;
		Node cPtr = head;
		Node pPtr = head;
		if(elementCount > 0){
			while(cPtr.value != searchValue && cPtr.next != null){
				pPtr = cPtr;
				cPtr = cPtr.next;
		}
			if(cPtr == head && cPtr.value == searchValue){
				addElementOne(value);
				error = 1;
			}
			else if(cPtr.value == searchValue){
				Node aNode = new Node(value, null);
				aNode.next = cPtr;
				pPtr.next = aNode;
				elementCount++;
				error = 1;
			}
		}
		else{
			error = -1;
		}
		cPtr = head;
		pPtr = head;
		return error;
	}
	public boolean checkElementcount(){
		Node cPtr = head;
		int nodes = 0;
		boolean check;
		while(cPtr != null){
			cPtr = cPtr.next;
			nodes++;
		}
		if(elementCount == nodes){
			check = true;
		}
		else{
			check = false;
		}
		return check;
	}
	public int checkGivenValue(int value){
		Node cPtr = head;
		int valueCount = 0;
		while(cPtr != null){
			if(cPtr.value == value){
				valueCount++;
			}
			cPtr = cPtr.next;
		}
		return valueCount;
	}
	public int[] findBiggestValue(){
		int values[] = new int[2];
		int error;
		Node cPtr = head;
		if(head != null && elementCount != 0){
			int temp = head.value;
			while(cPtr != null){
				if(cPtr.value > temp){
					temp = cPtr.value;
				}
				cPtr = cPtr.next;
			}
			error = 1;
			values[0] = temp;
			values[1] = error;
		}
		else{
			error = -1;
			values[1] = error;
		}
		return values;
	}
	public int[] findSmallestValue(){
		int values[] = new int [2];
		int error;
		Node cPtr = head;
		if(head != null && elementCount != 0){
			while(cPtr != null){
				int temp = head.value;
				if(cPtr.value < temp){
					temp = cPtr.value;
				}
				cPtr = cPtr.next;
				error = 1;
				values[0] = temp;
				values[1] = error;
			}
		}
		else{
			error = -1;
			values[1] = error;
		}
		return values;
	}
}// Oblig 1b end