package exercise11_lottery;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Lottery {
	Random random = new Random();
	TreeSet<Integer> lotteryWinSet;

	public Lottery () {
		getLotteryWinSet ();
	}
	
	public Set<Integer> getLotteryNum() {
		Set<Integer> lotteryNum = new TreeSet<Integer>();
		while (lotteryNum.size()<6) {
			lotteryNum.add(random.nextInt(46)+1);
		}return lotteryNum;
	}

	public void getLotteryWinSet () {
		lotteryWinSet = new TreeSet<Integer>();
		while(lotteryWinSet.size()<6) {
			lotteryWinSet.add(random.nextInt(46)+1);
		}
	}

	public void winLottery (){
		Set<Integer> lotteryNum = getLotteryNum();
		ArrayList<Integer> lotteryList = new ArrayList<Integer>(lotteryNum);
		List <Integer> lotteryResult = new ArrayList <Integer>();
		
		for (int i=0; i<lotteryNum.size();i++) {
			if (lotteryWinSet.contains(lotteryList.get(i))) {
				lotteryResult.add(1);
			}
		}
		
		if (lotteryResult.size()==6) {
			System.out.println("1µî!");
		} else if (lotteryResult.size()== 5) {
			System.out.println("2µî!");
		} else if (lotteryResult.size()== 4) {
			System.out.println("3µî!");
		} else if (lotteryResult.size()== 3) {
			System.out.println("4µî!");
		} else {
			System.out.println("²Î!");
		}
	}

}
