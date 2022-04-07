package senzor;

import java.util.Timer;
import java.util.TimerTask;

public class TemperaturniSenzor implements Runnable {
	// Opseg: -55 do 125 stupnjeva
	final private double MIN_TEMP = -55;
	final private double MAX_TEMP = 125;
	// Tocnost: 0.1 stupanj
	final private int TOCNOST = 1;
	// Kasnjenje u ocitanju (ms)
	final int KASNJENJE = 750;
	
	// Atribut senzora
	private double temperatura;
	
	private double pocetnaTemperatura;

	public TemperaturniSenzor(){
		pocetnaTemperatura = Math.random() * (MAX_TEMP - MIN_TEMP + 1) + MIN_TEMP; 
		pocetnaTemperatura = (double) (Math.round(pocetnaTemperatura * Math.pow(10, TOCNOST)) / (Math.pow(10, TOCNOST)));
		
		setTemperatura(pocetnaTemperatura);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			// Opseg promjena temperature: -5 do 5 stupnjeva
			final private double MIN_PROMJENA_TEMP = -5;
			final private double MAX_PROMJENA_TEMP = 5;

			@Override
			public void run() {
				double temperaturnaPromjena;
				// TODO Auto-generated method stub
					temperaturnaPromjena = pocetnaTemperatura + (Math.random() * (MAX_PROMJENA_TEMP - MIN_PROMJENA_TEMP + 1) + MIN_PROMJENA_TEMP);
					temperaturnaPromjena = (double) (Math.round(temperaturnaPromjena * Math.pow(10, TOCNOST)) / (Math.pow(10, TOCNOST)));
					setTemperatura(temperaturnaPromjena);
			}
		};
		timer.schedule(timerTask, 0, KASNJENJE);
	}
	public double  getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

}
