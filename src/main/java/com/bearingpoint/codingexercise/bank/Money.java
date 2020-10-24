package com.bearingpoint.codingexercise.bank;

public class Money {
    
	public static Money ZERO = new Money(0);
	
    private final double value;
    public Money (double Value){
        value = Value;
    }

	public Money subtract(Money amount) {
		return new Money (this.value-amount.value);
	}

	public Money add(Money amount) {
		return new Money (this.value+amount.value);
	}	

	public double getValue(){
		return this.value;
	}
}
