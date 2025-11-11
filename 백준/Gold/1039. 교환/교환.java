import java.io.*;
import java.util.*;

public class Main {
	static int k, ans;
	static int[] num;
	static HashSet<String>[] v;
	static boolean found;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// input
		String str = st.nextToken();
		k = Integer.parseInt(st.nextToken());

		// 초기화
		num = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			num[i] = str.charAt(i) - '0';
		}
		v = new HashSet[k + 1];
		for (int i = 0; i <= k; i++) {
			v[i] = new HashSet<>();
		}

		// solve
		ans = 0;
		if (num.length == 1) {
			System.out.println(-1);
			return;
		}
		dfs(0);

		// print
		System.out.println(found ? ans : -1);
	}

	static void dfs(int depth) {
	

		StringBuilder sb = new StringBuilder();
		for (int i : num) {
			sb.append(i);
		}

		if (v[depth].contains(sb.toString()))
			return;
		v[depth].add(sb.toString());

		if (depth == k) {
			int digit = Integer.parseInt(sb.toString());
			ans = Math.max(ans, digit);
			found = true;
			return;
		}

		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				swap(i, j);

				if (num[0] == 0) {
					swap(i, j);

					continue;
				}

				dfs(depth + 1);
				swap(i, j);

			}
		}
	}

	static void swap(int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;

	}

}
