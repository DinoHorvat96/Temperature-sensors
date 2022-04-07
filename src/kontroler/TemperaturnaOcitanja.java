package kontroler;

import java.util.Timer;
import java.util.TimerTask;

import senzor.TemperaturniSenzor;

public class TemperaturnaOcitanja {
	//Ucestalost ocitanja (ms)
	final private static int UCESTALOST_OCITANJA = 2000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		TemperaturniSenzor temperaturniSenzor1 = new TemperaturniSenzor();
		TemperaturniSenzor temperaturniSenzor2 = new TemperaturniSenzor();
		TemperaturniSenzor temperaturniSenzor3 = new TemperaturniSenzor();
		
		Thread ocitanjeSenzor1 = new Thread(temperaturniSenzor1);
		Thread ocitanjeSenzor2 = new Thread(temperaturniSenzor2);
		Thread ocitanjeSenzor3 = new Thread(temperaturniSenzor3);
		Timer periodickaOcitavanja = new Timer();
		TimerTask ocitaj = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Senzor 1: " + temperaturniSenzor1.getTemperatura() + 
								   "\tSenzor 2: " + temperaturniSenzor2.getTemperatura() + 
								   "\tSenzor 3: " + temperaturniSenzor3.getTemperatura());
			}
		};
		
		System.out.println("Senzor 1: " + temperaturniSenzor1.getTemperatura() + 
				   "\tSenzor 2: " + temperaturniSenzor2.getTemperatura() + 
				   "\tSenzor 3: " + temperaturniSenzor3.getTemperatura());
		
		ocitanjeSenzor1.start();
		ocitanjeSenzor2.start();
		ocitanjeSenzor3.start();
		
		periodickaOcitavanja.schedule(ocitaj, 0, UCESTALOST_OCITANJA);
	}

}
