package cracking_Coding_Interviews;

import java.util.Arrays;

public class CircusTower {

	/*
	 * A circus is designing a tower routine consisting of people standing atop one another's shoulders. 
	 * For practical and aesthetic reasons, each person must be both shorter and lighter than the person below him or her. 
	 * Given the heights and weights of each person in the circus, 
	 * write a method to compute the largest possible number of people in such a tower.
	 */
	
	public static class Person implements Comparable{
		Integer height;
		Integer weight;
		int sum;
		Person(int h,int w){
			weight=w;
			height=h;
			sum=weight+height;
		}
		
		@Override
		public int compareTo(Object arg0) {
			// TODO Auto-generated method stub
			Person that = (Person) arg0;
			if (this.height != that.height) //sort by Height first
				return (this.height).compareTo(that.height);
			else 
				return this.weight.compareTo(that.weight); //then sort by Weight
		}
	}
	
	/*
	 * Using Person Object then sorting based on Height and Weight Combination
	 * This is achieved using mergeSort O(n log n)
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// (65,100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
		//(56, 90) (60,95) (65,100) (68,110) (70,150) (75,190)

		Person people [] = {new Person(65,100),new Person(70,150),new Person(56,90),new Person(75,190),new Person(60,95),new Person(68,110) }; 
		Arrays.sort(people);
		int tLength = 1;
		Person prev = people[0];
		String tower="("+prev.height+","+prev.weight+") ";
		for(int i=1;i<people.length;i++){
			if(people[i].equals(prev)) continue;
			tower+="("+people[i].height+","+people[i].weight+") ";
			tLength++;
		}
		System.out.println("The longest tower is length "+ tLength +" and includes from top to bottom:");
		System.out.println(tower);
	}

}
