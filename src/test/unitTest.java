package test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class unitTest {

	@Test
	void test() {
		Double double1 = 2.38;
		BigDecimal b1 = new BigDecimal(double1);
		BigDecimal b2 = new BigDecimal(100);
		System.out.println((b1.multiply(b2)).intValue());
	}

}
