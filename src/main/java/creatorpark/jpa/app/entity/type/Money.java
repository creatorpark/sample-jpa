package creatorpark.jpa.app.entity.type;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Money {
	private static DecimalFormat format8 = new DecimalFormat("0.########");
	private static String zero8String = "0.00000000";
	private static BigDecimal zero = new BigDecimal("0.0");  

	public BigDecimal amount;
	
	public String format8() {
		if (amount == null || (zero.compareTo(amount) == 0)) {
			return zero8String;
		} else {
			return format8.format(amount.setScale(8, BigDecimal.ROUND_DOWN));	
		}
	}
}
