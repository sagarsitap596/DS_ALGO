package com.sagar.designpatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * This patter is used when object creation is expensive. For Example, creating
 * object BookShop with all book details fetched from database. So next time if
 * we want to an object we dont want to go to database and fetch values and
 * create object. Instead we can create object from already exsiting object by
 * cloning it.
 * 
 * -- as per requirement we can have shallow cloning or deep cloning.
 *
 * @author sitapsha
 *
 */
public class PrototypeExample {

	public static void main(String[] args) throws CloneNotSupportedException {
		BookShop bookShop1 = new BookShop();

		BookShop bookShop2 = bookShop1.clone();
		bookShop2.getBooks().remove(3);

		System.out.println(bookShop1);
		System.out.println("=========================================");
		System.out.println(bookShop2);
		;

	}

}

class BookShop implements Cloneable {
	private String name;
	private String id;
	private List<String> books = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getBooks() {
		return books;
	}

	public void setBooks(List<String> books) {
		this.books = books;
	}

	public BookShop() {
		loadData();
	}

	private void loadData() {
		this.setId("123");
		this.setName("Ami");
		List<String> books = new ArrayList<String>();
		books.add("English");
		books.add("Maths");
		books.add("Science");
		books.add("History");
		this.setBooks(books);
	}

	/**
	 * shallow clone
	 */
//	@Override
//	protected Object clone() throws CloneNotSupportedException {
//		// TODO Auto-generated method stub
//		return super.clone();
//	}

	/**
	 * Deep cloning
	 */
	@Override
	protected BookShop clone() throws CloneNotSupportedException {
		BookShop bs = new BookShop();
		bs.setId(this.id);
		bs.setName(this.name);
		List<String> books = new ArrayList<String>();
		books.addAll(this.books);
		return bs;
	}

	@Override
	public String toString() {
		return "BookShop [name=" + name + ", id=" + id + ", books=" + books + "]";
	}

}
