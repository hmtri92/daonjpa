package csc.daonjpa.java.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table (name = "BaseInfo")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BaseInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column (name = "Id")
	protected long id;
	
	@NotEmpty
	@Column (name = "availableAmount")
	private Long availableAmount;
	
	public BaseInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	/*public BaseInfo(long id, String number, Long availableAmount) {
		super();
		this.id = id;
		this.availableAmount = availableAmount;
	}*/

	public Long getAvailableAmount() {
		return availableAmount;
	}

	public void setAvailableAmount(Long availableAmount) {
		this.availableAmount = availableAmount;
	}
	
	
	
}
