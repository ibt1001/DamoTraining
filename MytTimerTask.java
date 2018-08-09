package com.mingrisoft;
import java.util.*;
public class MytTimerTask extends TimerTask{
	private String name;
	public MytTimerTask(String inputname) {
		name = inputname;
	}
	public void run() {
		System.out.println("Current exec name is "+name);
	}
	public String getName() {
		return name;
	}
	public void setName() {
		this.name = name;
	}
	public static void main(String [] args) throws InterruptedException {
		Timer timer = new Timer();
		MytTimerTask myTimerTask = new MytTimerTask("NO.1");
		timer.schedule(myTimerTask, 2000);
		
		
	}
}

