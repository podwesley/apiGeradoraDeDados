package br.com.generate.gen.util;

public class Util {

	public static Long generatedLong() {
		long leftLimit = 1L;
		long rightLimit = 780L;
		return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
	}

}
