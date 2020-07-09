package com.sagar.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LowestCommonManager {

	public static void main(String[] args) {
		OrgChart a = new OrgChart('a');

		OrgChart b = new OrgChart('b');
		OrgChart c = new OrgChart('c');
		OrgChart d = new OrgChart('d');
		OrgChart e = new OrgChart('e');
		OrgChart f = new OrgChart('f');
		OrgChart g = new OrgChart('g');
		OrgChart h = new OrgChart('h');
		OrgChart i = new OrgChart('i');

		a.directReports = Arrays.asList(b, c);
		b.directReports = Arrays.asList(d, e);
		c.directReports = Arrays.asList(f, g);
		d.directReports = Arrays.asList(h, i);
		e.directReports = Arrays.asList();
		f.directReports = Arrays.asList();
		g.directReports = Arrays.asList();
		h.directReports = Arrays.asList();
		i.directReports = Arrays.asList();

		OrgChart result = getLowestCommonManager(a,e, i);
		System.out.println(result.name);

	}

	public static OrgChart getLowestCommonManager(OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
		OrgChart lcm = new OrgChart(topManager.name);
		lcm.directReports = new ArrayList<>(topManager.directReports);

		searchLCM(reportOne, reportTwo, topManager, lcm);
		return lcm;
	}

	private static int searchLCM(OrgChart reportOne, OrgChart reportTwo, OrgChart currentManager, OrgChart lcm) {

		int count = 0;
		if (currentManager.directReports != null && !currentManager.directReports.isEmpty()) {
			for (OrgChart report : currentManager.directReports) {
				count = count + searchLCM(reportOne, reportTwo, report, lcm);
			}
		}
		if (currentManager.name == reportOne.name) {
			count++;
		}
		if (currentManager.name == reportTwo.name) {
			count++;
		}
		if (count == 2) {
			lcm.name = currentManager.name;
			lcm.directReports = currentManager.directReports;
			return 0;
		}
		return count;
	}

	static class OrgChart {
		public char name;
		public List<OrgChart> directReports;

		OrgChart(char name) {
			this.name = name;
			this.directReports = new ArrayList<OrgChart>();
		}

		// This method is for testing only.
		public void addDirectReports(OrgChart[] directReports) {
			for (OrgChart directReport : directReports) {
				this.directReports.add(directReport);
			}
		}
	}
}
