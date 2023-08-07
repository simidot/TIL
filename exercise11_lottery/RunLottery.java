package exercise11_lottery;

import java.util.Scanner;

public class RunLottery {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		//로또 생성 개수 입력받기
		System.out.println("로또를 몇개 생성하시겠습니까? ");
		int lotterySetNum = scanner.nextInt();
		
		Lottery lottery = new Lottery();
		for(Integer n:lottery.lotteryWinSet) System.out.print(n+" ");
		
		for (int i =0; i<lotterySetNum; i++) {
			lottery.winLottery();

		}

	}

}
