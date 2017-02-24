package com.example._10hin.myUtilities;

public class TupleImpl<CAR, CDR> implements Tuple<CAR, CDR> {

	private final CAR car;
	private final CDR cdr;
	protected TupleImpl(CAR car, CDR cdr) {
		this.car = car;
		this.cdr = cdr;
	}
	public CAR getCar() {
		return this.car;
	}
	public CDR getCdr() {
		return this.cdr;
	}

	public static <CAR, CDR> TupleImpl<CAR, CDR> of(CAR car, CDR cdr) {
		return new TupleImpl<>(car, cdr);
	}

}
