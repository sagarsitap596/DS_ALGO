package com.sagar.trie;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

public class App {
	public static class RatingStatisticsCollectorImpl implements RatingStatisticsCollector {

		Map<String, RatingCount> appRatings = new ConcurrentHashMap<>();

		@Override
		public void putNewRating(String app, int rating) {
			if (!appRatings.containsKey(app)) {
				appRatings.put(app, new RatingCount(rating));
			} else {
				appRatings.get(app).updateRatingData(rating);
			}

		}

		@Override
		public double getAverageRating(String app) {
			return appRatings.get(app).average;
		}

		@Override
		public int getRatingsCount(String app) {
			return appRatings.get(app).count;
		}
	}

	static class RatingCount {
		int count;
		double average;

		RatingCount(int rating) {
			this.average = rating;
			count = 1;
		}

		public synchronized void updateRatingData(int rating) {
			average = ((average * count) + rating) / (count + 1);
			count++;
		}

	}

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface RatingStatisticsCollector {
		// Ratings feed will call this method when new app rating information is
		// received. This is input to your class. ratings is a non negative integer
		// between 0 to 10.
		public void putNewRating(String app, int rating);

		// Report the average rating of the app.
		public double getAverageRating(String app);

		// Report the total number of rating for an app.
		public int getRatingsCount(String app);
	}

	public static void main(String[] args) {
		int[][] parkingStartEndTimes = { { 5, 10 }, { 0, 20 }, { 20, 40 }, { 35, 45 } };
		Arrays.sort(parkingStartEndTimes, (a1, a2) -> Integer.compare(a1[0], a2[0]));
		PriorityQueue<Integer> parkingStatus = new PriorityQueue<>();
		int maxCount = 0;
		for (int[] park : parkingStartEndTimes) {
			int size = parkingStatus.size();
			while (size > 0) {
				if (park[0] >= parkingStatus.peek()) {
					parkingStatus.poll();
				} else {
					break;
				}
				size--;
			}
			parkingStatus.add(park[1]);
			if (parkingStatus.size() > maxCount) {
				maxCount = parkingStatus.size();
			}
		}
		System.out.println(maxCount);
	}

//	public static void main(String[] args) {
//
//		int[][] parkingStartEndTimes = { { 5, 10 }, { 0, 20 }, { 25, 40 }, { 35, 45 } };
//		Arrays.sort(parkingStartEndTimes, (a1, a2) -> Integer.compare(a1[0], a2[0]));
//
//		
//		
//		
//		
//		Scanner scanner = new Scanner(System.in);
//		int numLines = Integer.parseInt(scanner.nextLine());
//		int currentLine = 0;
//		while (currentLine++ < numLines) {
//			final RatingStatisticsCollector stats = new RatingStatisticsCollectorImpl();
//			final Set<String> apps = new TreeSet<>();
//
//			String line = scanner.nextLine();
//			String[] inputs = line.split(",");
//			for (int i = 0; i < inputs.length; ++i) {
//				String[] tokens = inputs[i].split(" ");
//				final String app = tokens[0];
//				apps.add(app);
//				final int runs = Integer.parseInt(tokens[1]);
//
//				stats.putNewRating(app, runs);
//
//			}
//
//			for (String app : apps) {
//				System.out.println(
//						String.format("%s %.2f %d", app, stats.getAverageRating(app), stats.getRatingsCount(app)));
//			}
//
//		}
//		scanner.close();
//
//	}
}