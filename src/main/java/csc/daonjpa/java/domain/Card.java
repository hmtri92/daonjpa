package csc.daonjpa.java.domain;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table (name = "card")
@AttributeOverrides({
	@AttributeOverride(name = "availableAmount", column=@Column(name = "availableAmount"))
})
public class Card extends BaseInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static String VISA = "VISA";
	public static String MASTER = "MASTER";
	
	@NotEmpty
	@Column(name = "cardType")
	private String cardType;
	
	@ManyToOne
	@JoinColumn (name = "loginId")
	private Customer customer;
	
	/*public Card() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Card(Long id, String number, Long availableAmount, String cardType) {
		super(id, number, availableAmount);
		this.cardType = cardType;
		// TODO Auto-generated constructor stub
	}
*/
	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
