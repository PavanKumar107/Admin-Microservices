package com.blz.admin.DTO;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AdminDTO {
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "First name Invalid")
	private String firstName;

	@Pattern(regexp = "^[a-zA-Z]{1}[a-zA-Z\\s]{2,}$",message = "Last name Invalid")
	private String lastName;

	@Pattern(regexp = "^[6-9]{1}[0-9]{9}$",message = "Enter valid mobile number")
	private String mobile;

	@Pattern(regexp = "^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$",message ="Enter valid email address")
	private String emailId;

	@NotBlank(message = "profilepath cannot be empty")
	private String profilePath;

	private boolean status;

	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",message ="Enter valid email password")
	private String password;

	private LocalDateTime creatorStamp;

	private LocalDateTime updatedStamp;
}
