package sample.app.entity.type;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	public String zipCode;
	public String state;
	public String city;
	public String addressLine1;
	public String addressLine2;
}
