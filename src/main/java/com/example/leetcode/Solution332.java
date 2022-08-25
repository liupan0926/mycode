package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <pre>
给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。

所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。

例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/reconstruct-itinerary
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月28日 上午11:39:37
 *
 */
public class Solution332 {

	List<String> path = new ArrayList<>();
	List<List<String>> res = new ArrayList<>();
	// used数组用于标记同一树枝不能重复使用！即不能重复使用一张票
	boolean[] used = new boolean[301];
	boolean find;

	public static void main(String[] args) {
		List<List<String>> tickets = new ArrayList<>();

//		List<String> a1 = new ArrayList<>();
//		a1.add("JFK");
//		a1.add("SFO");
//
//		List<String> a2 = new ArrayList<>();
//		a2.add("JFK");
//		a2.add("ATL");
//
//		List<String> a3 = new ArrayList<>();
//		a3.add("SFO");
//		a3.add("ATL");
//
//		List<String> a4 = new ArrayList<>();
//		a4.add("ATL");
//		a4.add("JFK");
//
//		List<String> a5 = new ArrayList<>();
//		a5.add("ATL");
//		a5.add("SFO");
//
//		tickets.add(a1);
//		tickets.add(a2);
//		tickets.add(a3);
//		tickets.add(a4);
//		tickets.add(a5);

//		
//		[["EZE","AXA"],["TIA","ANU"],["ANU","JFK"],["JFK","ANU"],["ANU","EZE"],
//		 ["TIA","ANU"],["AXA","TIA"],["TIA","JFK"],["ANU","TIA"],["JFK","TIA"]]

		addTickets(tickets, "EZE", "AXA");
		addTickets(tickets, "TIA", "ANU");
		addTickets(tickets, "ANU", "JFK");
		addTickets(tickets, "JFK", "ANU");
		addTickets(tickets, "ANU", "EZE");

		addTickets(tickets, "TIA", "ANU");
		addTickets(tickets, "AXA", "TIA");
		addTickets(tickets, "TIA", "JFK");
		addTickets(tickets, "ANU", "TIA");
		addTickets(tickets, "JFK", "TIA");

		Solution332 sol = new Solution332();
		Long start = System.currentTimeMillis();
		System.out.println(sol.findItinerary(tickets));
		Long cost = System.currentTimeMillis() - start;
		System.out.println(cost);
	}

	public static void addTickets(List<List<String>> tickets, String start, String end) {
		List<String> a5 = new ArrayList<>();
		a5.add(start);
		a5.add(end);
		tickets.add(a5);
	}

	public List<String> findItinerary(List<List<String>> tickets) {
		// 先按字典序从小到大排列降落地
		tickets.sort((o1, o2) -> o1.get(1).compareTo(o2.get(1)));
		path.add("JFK");
		backTracking(tickets, "JFK");
		return res.get(0);
	}

	void backTracking(List<List<String>> tickets, String outset) {
		// 算个小剪枝吧，找到一条就行
		if (find) {
			return;
		}
		// 因为这些航班肯定会有一条路线是正确的
		// 所以我们加入path的size如果等于tickets.size()+1说明我们找到路线了
		if (path.size() == tickets.size() + 1) {
			find = true;
			res.add(new ArrayList<>(path));
			return;
		}
		for (int i = 0; i < tickets.size(); i++) {
			// 如果出发地和上一个的降落地相同 并且 同一条路线中没有重复使用一张票
			if (tickets.get(i).get(0).equals(outset) && !used[i]) {
				// 标记该票已经使用过
				used[i] = true;
				path.add(tickets.get(i).get(1));
				// 把现在的降落地加入递归函数
				backTracking(tickets, tickets.get(i).get(1));
				// 回溯！ 该票标记为未使用 路线中移除该票
				used[i] = false;
				path.remove(path.size() - 1);
			}
		}
	}

}
