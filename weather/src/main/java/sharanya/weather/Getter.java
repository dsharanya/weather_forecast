package sharanya.weather;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Getter{

	private int DATE;
	private double tmax;
	private double tmin;
	public int getDATE() {
		return DATE;
	}
	public void setDATE(int dATE) {
		DATE = dATE;
	}
	
	
	public Getter()
	{
	
	}
	public Getter(int date, double tmax, double tmin) {
		super();
		this.DATE = DATE;
		this.tmax = tmax;
		this.tmin = tmin;
	}
	
	public double getTmax() {
		return tmax;
	}
	public void setTmax(double tmax) {
		this.tmax = tmax;
	}
	public double getTmin() {
		return tmin;
	}
	public void setTmin(double tmin) {
		this.tmin = tmin;
	}
	
	
}

