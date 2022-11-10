package pojos;


import lombok.Data;

@Data
public class UserDto {

    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String dob;

}
