package stacksAndQueues;

import java.util.LinkedList;

abstract class Animal {
	private int order;
	protected String name;
	
	public Animal(String name) {
		this.name = name;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	
	public boolean isOlder(Animal a) {
		return this.order < a.getOrder(); //O is the oldest
	}
}

class Dog extends Animal {

	public Dog(String name) {
		super(name);
	}
	
}

class Cat extends Animal {

	public Cat(String name) {
		super(name);
	}
	
}

public class AnimalShelter {
	
	LinkedList<Dog> dogs = new LinkedList<>();
	LinkedList<Cat> cats = new LinkedList<>();
	private int order = 0;
	
	public void add(Animal a) {
		a.setOrder(order);
		order++;
		
		if(a instanceof Dog) {
			dogs.addLast( (Dog) a);
		}
		else if(a instanceof Cat) {
			cats.addLast( (Cat) a);
		}
	}
	
	public Dog dequeueDog() {
		return dogs.poll(); // Removes the first element of a linked list
	}
	
	public Cat dequeueCat() {
		return cats.poll();
	}
	
	public Animal dequeueAny() {
		if(dogs.size() == 0) {
			return dequeueCat();
		}
		else if(cats.size() == 0) {
			return dequeueDog();
		}
		Dog dog = dogs.peek(); //Just returns the first element, doesn't removes
		Cat cat = cats.peek();
		
		if(dog.isOlder(cat)) { //dogOrder < catOrder
			return dequeueDog();
		}
		else {
			return dequeueCat();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
