package com.example._10hin.myUtilities;

/**
 * 不変な2つ組<br>
 *
 * @author kei
 *
 */
public interface Tuple<CAR, CDR> {

	/**
	 * 第1要素
	 * @return この組の第1要素
	 */
	CAR getCar();

	/**
	 * 第2要素
	 * @return この組の第2要素
	 */
	CDR getCdr();

	static <CAR, CDR> Tuple<CAR, CDR> of(CAR car, CDR cdr) {
		return TupleImpl.of(car, cdr);
	}

}
