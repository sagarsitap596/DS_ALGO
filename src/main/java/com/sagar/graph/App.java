package com.sagar.graph;

import java.util.HashSet;
import java.util.Set;

public class App {
	
	private static int[] getWallLengths(int n, int s0, int mul, int offset, int modVal){
        int[] sizes = new int[n];
        sizes[0] = s0;
        for(int i = 1; i < n; i++){
            sizes[i] = ((mul * sizes[i -1] + offset) % modVal) + 1 + sizes[i - 1];
        }
        return sizes;
    }

	public static void main(String[] args) {
		int x = 0;
		int y = 0;
		for (int i = 0; i < 5; i++) {

			if ((++x > 2) && (++y > 2)) {
				x++;
			}
		}
		System.out.println(x);
		System.out.println(y);

		Set<Key> set = new HashSet<>();
		Key k1 = new Key(1);
		Key k2 = new Key(2);
		set.add(k1);
		set.add(k2);
		set.add(k2);
		System.out.println(k2.i);
		System.out.println(set);
		k2.i = 1;
//		set.remove(k2);
//		System.out.println(set);
		set.remove(k2);
		System.out.println(set);
		System.out.println(set.contains(k2));
	}

	static class Key {
		int i;

		Key(int i) {
			this.i = i;
		}

		@Override
		public int hashCode() {
			return i;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Key other = (Key) obj;
			if (i != other.i)
				return false;
			return true;
		}

	}

	private static void bad() {
		throw new Error();
	}
}

class MinMax<N extends Number>{
	private N min, max;
	public N get() {
		return max;
	}
	
	public void add(N addd) {
		addd.doubleValue()
	}
}
