package com.sagar.java8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sagar.graph.App;

public class App {

	public static void main(String[] args) {

		List<Person> persons = null;
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new App().getClass().getClassLoader().getResourceAsStream("age_data.txt")));
				Stream<String> lines = br.lines();) {

			persons = lines.map(line -> new Person(line.split(" ")[0], Integer.parseInt(line.split(" ")[1])))
					.collect(Collectors.toList());

			System.out.println(persons);

		} catch (Exception e) {
			e.printStackTrace();
		}

		/**
		 * Youngest person older than 30
		 */
		Person p1 = persons.stream().filter(p -> p.getAge() > 30).min(Comparator.comparing(Person::getAge)).get();
		System.out.println("Youngest person older than 30 : " + p1);

		/**
		 * Oldest person
		 */
		p1 = persons.stream().max(Comparator.comparing(Person::getAge)).get();
		System.out.println("Oldest person older than 30 : " + p1);

		/**
		 * Group by age
		 */

		Map<Integer, List<Person>> map = persons.stream().collect(Collectors.groupingBy(Person::getAge));

		System.out.println(map);

		/**
		 * Group by age and count
		 */

		Map<Integer, Long> map2 = persons.stream()
				.collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));

		System.out.println(map2);

		/**
		 * Group by age and get list of names
		 */

		Map<Integer, List<String>> map3 = persons.stream().collect(
				Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));

		System.out.println(map3);

		/**
		 * Group by age and get treeSet of names
		 */

		Map<Integer, Set<String>> map4 = persons.stream().collect(Collectors.groupingBy(Person::getAge,
				Collectors.mapping(Person::getName, Collectors.toCollection(TreeSet::new))));

		System.out.println(map4);

		/**
		 * Group by age and get comma sepearted names
		 */

		Map<Integer, String> map5 = persons.stream().collect(
				Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.joining(", "))));

		System.out.println(map5);
	}

	public static void show(String name) throws InterruptedException {
		synchronized (name) {
			for (int i = 0; i < 5; i++) {
				Thread.sleep(1000);
				System.out.print(name + " ");
			}
			System.out.println();
		}
	}

}

class Person {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
