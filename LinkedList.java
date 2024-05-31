package deleteAfterNode;

import java.util.Scanner;

//ASSIGNMENT 2 "Various Operations on LinkedList"
public class LinkedList {
	Node head;
	public LinkedList() {
		head = null;
	}
	void append(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			return;
		}
		// otherwise traverse to the end
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNode;
	}
	// 1. insertAtPos
    public void insertAtPos(int position, int data) {
        Node newNode = new Node(data);
        // If the list is empty or the position is 0, insert at the beginning
        if (head == null || position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        // Traverse to the node at the position before the desired position
        Node current = head;
        for (int i = 0; i < position - 1 && current.next != null; i++) {
            current = current.next;
        }

        // Insert the new node at the desired position
        newNode.next = current.next;
        current.next = newNode;
	}
	// 2. delete At Position
    public void deleteAtPosition(int position) {
        // If the list is empty, return
        if (head == null) {
            return;
        }

        // If the position is 0, delete the head node
        if (position == 0) {
            Node temp = head;
            head = head.next;
            temp.next = null;
            return;
        }

        // Traverse to the node at the position before the one to be deleted
        Node current = head;
        Node prev = null;
        int i = 0;
        while (current != null && i < position) {
            prev = current;
            current = current.next;
            i++;
        }

        // If the position is out of range, return
        if (i != position) {
            return;
        }

        // Delete the node at the given position
        prev.next = current.next;
        current.next = null;
	}
    //3. deleteAfterNode
    public void deleteAfterPosition(int position) {
        // If the list is empty or has only one node, return
        if (head == null || head.next == null) {
            return;
        }
        // Traverse to the node at the given position
        Node current = head;
        int i = 0;
        while (current != null && i < position) {
            current = current.next;
            i++;
        }
        // If the position is out of range, return
        if (i != position) {
            return;
        }
        // Check if the current node is the last node
        if (current.next == null) {
            return;
        }
        // Get the node after the node at the given position
        Node nodeToDelete = current.next;
        // Check if the node after the current node is the last node
        if (nodeToDelete.next == null) {
            return;
        }
        // Update the links to skip the node after the node at the given position
        current.next = nodeToDelete.next;
        // Set the next pointer of the node to be deleted to null
        // to allow the garbage collector to reclaim the memory
        nodeToDelete.next = null;
    }
	// 4. SearchNode
    public void searchAtPosition(int position) {
        // If the list is empty, return
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        // Traverse to the node at the given position
        Node current = head;
        int i = 0;
        while (current != null && i < position) {
            current = current.next;
            i++;
        }
        // If the position is out of range, print a message
        if (i != position) {
            System.out.println("The position is out of range.");
            return;
        }
        // Print the data of the node at the given position
        System.out.println("The element at position " + position + " is: " + current.data);
	}
	void display() {
	Node current = head;
	while (current != null) {
		System.out.print(current.data + " ");
		current = current.next;
		}
	System.out.println();
	} 
class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		LinkedList list = new LinkedList();
		list.append(11); list.append(2);
		list.append(4); list.append(13);
		list.append(20); list.append(17);
		list.display();
		//insertAtPos
		System.out.print("Position to add the new value: ");
		int num1 = input.nextInt();
		System.out.print("The new value to be inserted: ");
		int num2 = input.nextInt();
		list.insertAtPos(num1, num2);
		list.display();
		//deleteAtPos
		System.out.print("\nThe element to be deleted: ");
		list.deleteAtPosition(input.nextInt());
		list.display();
		//deleteAfterNode
		System.out.print("\nThe position of prevNode: ");
		int num4 = input.nextInt();
		list.deleteAfterPosition(num4);
		list.display();
		//SearchNode
		System.out.print("\nElement to be found at Positon: ");
		int m = input.nextInt();
		list.searchAtPosition(m);
		//Implementation of Stack.
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("\nTop element: " + stack.peek());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Top element: " + stack.peek());
        System.out.println("Is stack empty?: " + stack.isEmpty());
        //Assignment 1: ToDoList.
		ToDolist ToDoList = new ToDolist(); System.out.println();
		//adding tasks
		ToDoList.addToDo(new Task("Task 1", 
		"Description 1"));
		ToDoList.addToDo(new Task("Task 2", 
		"Description 2"));
		ToDoList.addToDo(new Task("Task 3", 
		"Description 3"));
		ToDoList.markToDoAsCompleted("Task 2");
		ToDoList.viewToDoList();
		input.close();
	}
}
// 5. Implementing a Stack Using LinkedLists.
class Stack {
    private class Node3 {
        int data;
        Node3 next;

        Node3(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node3 top;

    public Stack() {
        this.top = null;
    }

    // Push operation
    public void push(int data) {
        Node3 newNode = new Node3(data);
        newNode.next = top;
        top = newNode;
    }

    // Pop operation
    public int pop() {
        if (top == null) {
            System.out.println("Stack Underflow");
            return -1;
        }

        int data = top.data;
        top = top.next;
        return data;
    }

    // Peek operation
    public int peek() {
        if (top == null) {
            System.out.println("Stack Underflow");
            return -1;
        }

        return top.data;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }
}
//ASSSIGNMENT ONE "To Do List".
class Task {
	String title;
	String description;
	boolean completed;
	
	public Task(String title, String description) {
		this.title = title;
		this.description = description;
		this.completed = false;
	}
	public String getTitle() {
		return title;
	}
	public String getdescription() {
		return description;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void markCompleted() {
		completed = true;
	}
	public String toString() {
		return "Title: " + title + ", Description: " + 
		description + ", Completed: " + completed;
	}
}

class Node2 {
	Task task;
	Node2 next;
	public Node2(Task task) {
		this.task = task;
		next = null;
	}
}

class ToDolist {
	private Node2 head;
	
	public ToDolist() {
		head = null;
	}
	public void addToDo(Task task) {//Adds Tasks to the ToDoList.
		Node2 newNode = new Node2(task);
		if(head == null) {
		head = newNode;
		}
		else {
		Node2 current = head;
		while(current.next != null) {
		current = current.next;
		}
		current.next = newNode;
		}
		}
	public void markToDoAsCompleted(String title) {//marks true if they are completed.
		Node2 current = head;
		while(current != null) {
		if(current.task.getTitle().equals(title)) {
		current.task.markCompleted();
		return;
		}
		current = current.next;
		}
		System.out.println("Task not found");
		}

	public void viewToDoList() {//Shows the ToDoList.
		Node2 current = head;
		System.out.println("Task List: ");
		while(current != null) {
		System.out.println(current.task);
		current = current.next;
		}
	}
}
