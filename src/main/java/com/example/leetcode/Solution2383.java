package com.example.leetcode;

/**
 * 
 * <pre>
你正在参加一场比赛，给你两个 正 整数 initialEnergy 和 initialExperience 分别表示你的初始精力和初始经验。

另给你两个下标从 0 开始的整数数组 energy 和 experience，长度均为 n 。

你将会 依次 对上 n 个对手。第 i 个对手的精力和经验分别用 energy[i] 和 experience[i] 表示。当你对上对手时，需要在经验和精力上都 严格 超过对手才能击败他们，然后在可能的情况下继续对上下一个对手。

击败第 i 个对手会使你的经验 增加 experience[i]，但会将你的精力 减少  energy[i] 。

在开始比赛前，你可以训练几个小时。每训练一个小时，你可以选择将增加经验增加 1 或者 将精力增加 1 。

返回击败全部 n 个对手需要训练的 最少 小时数目。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/minimum-hours-of-training-to-win-a-competition
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月23日 下午4:15:19
 *
 */
public class Solution2383 {

	public static void main(String[] args) {
		int initialEnergy = 2;
		int initialExperience = 2;

		int[] energy = { 1 };
		int[] experience = { 2 };

		Solution2383 sol = new Solution2383();

		int res = sol.minNumberOfHours(initialEnergy, initialExperience, energy, experience);

		System.out.println(res);
	}

	/**
	 * 输入：initialEnergy = 5, initialExperience = 3, energy = [1,4,3,2], experience =
	 * [2,6,3,1] 输出：8
	 * 
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode.cn/problems/minimum-hours-of-training-to-win-a-competition
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 * @param initialEnergy
	 * @param initialExperience
	 * @param energy
	 * @param experience
	 * @return
	 */
	public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {

		int sum = 0;
		for (int i = 0; i < energy.length; i++) {
			sum += energy[i];
		}

		int maxEx = 0;
		int maxIndex = 0;
		for (int i = 0; i < experience.length; i++) {
			if (experience[i] > maxEx) {
				maxEx = experience[i];
				maxIndex = i;
			}
		}
		int needEnergy = 0;

		if (initialEnergy > sum) {

		} else {
			needEnergy = sum - initialEnergy + 1;
		}

		System.out.println("sumEnergy:" + sum + ",needEnergy:" + needEnergy);

		System.out.println("maxEx:" + maxEx + ",maxIndex:" + maxIndex);

		// 需要训练的经验
		int needExper = 0;
		if (initialExperience <= maxEx) {
			// 打怪得到的经验
			int sumExper = initialExperience;
			for (int i = 0; i < maxIndex; i++) {
				if (sumExper <= experience[i]) {
					needExper += experience[i] - sumExper + 1;
					// 等于当前经验+1
					sumExper = experience[i] + 1;
				} else { // 如果经验大于 不用训练

				}
				sumExper += experience[i];
			}
			if (sumExper > maxEx) {

			} else {
				needExper += maxEx - sumExper + 1;
			}
		}

		return needEnergy + needExper;

	}
}
