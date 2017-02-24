package com.example._10hin.myUtilities;

public class AutocloseableCarTuple<CAR extends AutoCloseable, CDR> extends TupleImpl<CAR, CDR> implements AutoCloseable {

	AutocloseableCarTuple(CAR car, CDR cdr) {
		super(car, cdr);
	}

	@Override
	public void close() throws Exception {
		this.getCar().close();
	}



}
