package com.example.leetcode;

// Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
// '.' Matches any single character.​​​​
// '*' Matches zero or more of the preceding element.
// The matching should cover the entire input string (not partial). 

public class Code {
	public static void main(String[] args) {
		String s = "aa";
		String p = "a*";
		System.out.println(isMatch(s, p));
	}

	public static boolean isMatch(String s, String p) {
		s = " " + s;
		p = " " + p;
		int m = s.length();
		int n = p.length();
		boolean[][] dp = new boolean[m][n];
		dp[0][0] = true;
		for (int i = 2; i < n; i++) {
			if (p.charAt(i) == '*') dp[0][i] = dp[0][i-2];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (p.charAt(j) == '*') {
					dp[i][j] = dp[i][j - 2];

					if (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') {
						dp[i][j] = dp[i][j] || dp[i - 1][j];
					}
				} else {
					dp[i][j] = false;
				}
			}
		}
		return dp[m - 1][n - 1];
	}
}
