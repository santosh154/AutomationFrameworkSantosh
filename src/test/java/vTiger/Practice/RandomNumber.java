package vTiger.Practice;

import java.util.Random;

public class RandomNumber {

	public static void main(String[] args) {
		Random r=new Random();
	    int rand  =	r.nextInt(1000);
		System.out.println(rand);
	}

}
