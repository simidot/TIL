package exercise11_lottery;

import java.util.Scanner;

public class RunLottery {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		//�ζ� ���� ���� �Է¹ޱ�
		System.out.println("�ζǸ� � �����Ͻðڽ��ϱ�? ");
		int lotterySetNum = scanner.nextInt();
		
		Lottery lottery = new Lottery();
		for(Integer n:lottery.lotteryWinSet) System.out.print(n+" ");
		
		for (int i =0; i<lotterySetNum; i++) {
			lottery.winLottery();

		}

	}

}
