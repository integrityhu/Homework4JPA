package hu.infokristaly.jpa.back.domain;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Continents")
public class Continents {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Byte id;
	
	@Basic
	private String Name;
	
	@Basic
	private Byte phonePrefix;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Byte getPhonePrefix() {
		return phonePrefix;
	}
	public void setPhonePrefix(Byte phonePrefix) {
		this.phonePrefix = phonePrefix;
	}
	
}
