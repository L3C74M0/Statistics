package model;

public class Row {
	private int number;
	private double dozen1;
	private double dozen2;
	private double dozen3;
	private double red;
	private double black;
	private double even;
	private double odd;
	private double t1to18;
	private double t19to36;

	public Row(int number, double dozen1, double dozen2, double dozen3, double red, double black, double even,
			double odd, double t1to18, double t19to36) {
		this.number = number;
		this.dozen1 = dozen1;
		this.dozen2 = dozen2;
		this.dozen3 = dozen3;
		this.red = red;
		this.black = black;
		this.even = even;
		this.odd = odd;
		this.t1to18 = t1to18;
		this.t19to36 = t19to36;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getDozen1() {
		return dozen1;
	}

	public void setDozen1(double dozen1) {
		this.dozen1 = dozen1;
	}

	public double getDozen2() {
		return dozen2;
	}

	public void setDozen2(double dozen2) {
		this.dozen2 = dozen2;
	}

	public double getDozen3() {
		return dozen3;
	}

	public void setDozen3(double dozen3) {
		this.dozen3 = dozen3;
	}

	public double getRed() {
		return red;
	}

	public void setRed(double red) {
		this.red = red;
	}

	public double getBlack() {
		return black;
	}

	public void setBlack(double black) {
		this.black = black;
	}

	public double getEven() {
		return even;
	}

	public void setEven(double even) {
		this.even = even;
	}

	public double getOdd() {
		return odd;
	}

	public void setOdd(double odd) {
		this.odd = odd;
	}

	public double getT1to18() {
		return t1to18;
	}

	public void setT1to18(double t1to18) {
		this.t1to18 = t1to18;
	}

	public double getT19to36() {
		return t19to36;
	}

	public void setT19to36(double t19to36) {
		this.t19to36 = t19to36;
	}
}
