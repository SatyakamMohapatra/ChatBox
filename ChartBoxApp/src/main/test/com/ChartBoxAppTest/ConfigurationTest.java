package com.ChartBoxAppTest;

import java.util.ArrayList;
import java.util.List;

import com.chartboxapp.config.ChartBoxAppCoreConfig;

public class ConfigurationTest {

	public static void main(String[] args) {
		
		int arrt[]={5,7,2,10,4};
		int high=arrt[0];
		int sec=0;
		for (int i = 1; i < arrt.length; i++) {
			if(high<arrt[i]){
				sec=high;
			high=arrt[i];
			}
		}
		
		System.out.println(sec+"bbb"+high);
		List listA= new ArrayList<>();
		listA.add(1);
		listA.add(2);
		listA.add(3);
		List listB= new ArrayList<>();
		listB.add(1);
		listB.add(2);
		//listA.removeAll(listB);
		//listA.clear();
		//listA.retainAll(listB);
		System.out.println(listA);

		

	}

}
