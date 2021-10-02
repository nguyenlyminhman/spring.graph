package vn.study.graph.input;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserInput {
    private String userName;
    private String password;
    private String confirmPassword;
    private String  fullName;
    private String email;

}
