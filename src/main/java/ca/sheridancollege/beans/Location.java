package ca.sheridancollege.beans;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Location {

	@Id
	@GeneratedValue
	private int locationId;
	
	private String locationName;
	private String address;
	private String phoneNum;
	private String storeHours;
	
	
	public Location(String locationName, String address, String phoneNum, String storeHours) {
		super();
		this.locationName = locationName;
		this.address = address;
		this.phoneNum = phoneNum;
		this.storeHours = storeHours;
	}	
}
