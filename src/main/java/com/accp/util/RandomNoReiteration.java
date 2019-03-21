package com.accp.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNoReiteration {
	/**
	 * 
	    * @Title: getRandom
	    * @Description: 初始化 避免重复随机数
	    * @param @param size 数组大小 
	    * @param @param scope 随机值范围
	    * @return Object[]    返回类型
	    * @throws
	 */
	public static Object[] getRandomInfo(int size,int scope) {
		Set<Integer> set = new HashSet<Integer>();
		Random random=new Random();	
		while(set.size()<size){
			int a = random.nextInt(scope);
			set.add(a);
			if(set.size() == scope) {
				break;
			}
		}
		Object[] ints = set.toArray();
		return ints;
	}
}
