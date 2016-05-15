package main.lanqiaocup.hzu._20160514;

import java.util.Scanner;

///*
// * 放苹果
// * 
// * Time Limit: 1000MS
// * Memory Limit: 10000K
// * Total Submissions: 30105
// * Accepted: 19001
// * 
// * Description
// * 把M个同样的苹果放在N个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？
// * （用K表示）5，1，1和1，5，1 是同一种分法。
// * Input
// * 第一行是测试数据的数目t（0 <= t <= 20）。以下每行均包含二个整数M和N，以空格分开。1<=M，N<=10。
// * Output
// * 对输入的每组数据M和N，用一行输出相应的K。
// * 
// * Sample Input
// * 1
// * 7 3
// * Sample Output
// * 8
// * 
// * 解题分析：
// * 设f(m,n) 为m个苹果，n个盘子的放法数目，则先对n作讨论，
// * 当n>m：必定有n-m个盘子永远空着，去掉它们对摆放苹果方法数目不产生影响。即if(n>m) f(m,n) = f(m,m)　　
// * 当n<=m：不同的放法可以分成两类：
// * 1、有至少一个盘子空着，即相当于f(m,n) = f(m,n-1);  
// * 2、所有盘子都有苹果，相当于可以从每个盘子中拿掉一个苹果，不影响不同放法的数目，即f(m,n) = f(m-n,n).
// * 而总的放苹果的放法数目等于两者的和，即 f(m,n) =f(m,n-1)+f(m-n,n) 
// * 递归出口条件说明：
// * 当n=1时，所有苹果都必须放在一个盘子里，所以返回１；
// * 当没有苹果可放时，定义为１种放法；
// * 递归的两条路，第一条n会逐渐减少，终会到达出口n==1; 
// * 第二条m会逐渐减少，因为n>m时，我们会return f(m,m)　所以终会到达出口m==0．
// */
public class _4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int m[] = new int[t];
		int n[] = new int[t];
		for (int i = 0; i < t; i++) {
			m[i] = sc.nextInt();
			n[i] = sc.nextInt();
		}
		sc.close();

		for (int i = 0; i < t; i++) {
			System.out.println(fun(m[i], n[i]));
		}

	}

	public static int fun(int m, int n) // m个苹果放在n个盘子中共有几种方法
	{
		if (m == 0 || n == 1) // 因为我们总是让m>=n来求解的，所以m-n>=0,所以让m=0时候结束，如果改为m=1，
			return 1; // 则可能出现m-n=0的情况从而不能得到正确解
		if (n > m)
			return fun(m, m);
		else
			return fun(m, n - 1) + fun(m - n, n);
	}

}
