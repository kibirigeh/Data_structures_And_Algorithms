package topCoder;

public class ThreadsExample extends Thread {
	//using threads in java
	int i=10;
	public void run(){
		try{
			Thread.sleep(5000);//wait for 5 secs then start
			System.out.println(i);
			i*=i;
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadsExample ex = new ThreadsExample();
		ex.start();
	}

}
