package com.blz.admin.model;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.blz.admin.DTO.AdminDTO;
import lombok.Data;

@Entity
@Table(name="admin")
@Data
public class AdminModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String mobile;
	private String emailId;
	private String profilePath;
	private boolean status;
	private String password;
	private LocalDateTime creatorStamp;
	private LocalDateTime updatedStamp;

	public AdminModel() {

	}

	public AdminModel(AdminDTO adminDTO) {
		this.firstName = adminDTO.getFirstName();
		this.lastName = adminDTO.getLastName();
		this.mobile = adminDTO.getMobile();
		this.emailId = adminDTO.getEmailId();
		this.profilePath = adminDTO.getProfilePath();
		this.status = adminDTO.isStatus();
		this.password = adminDTO.getPassword();
		this.creatorStamp = adminDTO.getCreatorStamp();
		this.updatedStamp = adminDTO.getUpdatedStamp();
	}
}