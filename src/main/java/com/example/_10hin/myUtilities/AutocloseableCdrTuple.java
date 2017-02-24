package com.example._10hin.myUtilities;

public class AutocloseableCdrTuple<CAR extends AutoCloseable, CDR extends AutoCloseable> extends TupleImpl<CAR, CDR> implements AutoCloseable {

	AutocloseableCdrTuple(CAR car, CDR cdr) {
		super(car, cdr);
	}

	@Override
	public void close() throws Exception {
		try {
			this.getCar().close();
		} finally {
			this.getCdr().close();
		}
	}



}
