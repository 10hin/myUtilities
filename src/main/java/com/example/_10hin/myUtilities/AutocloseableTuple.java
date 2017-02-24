package com.example._10hin.myUtilities;

public class AutocloseableTuple<CAR extends AutoCloseable, CDR> extends TupleImpl<CAR, CDR> implements AutoCloseable {

	AutocloseableTuple(CAR car, CDR cdr) {
		super(car, cdr);
	}

	@Override
	public void close() throws Exception {
		this.getCar().close();
	}



}
