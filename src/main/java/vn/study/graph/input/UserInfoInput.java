package vn.study.graph.input;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserInfoInput {
    private String userName;
    private String password;
    private String  fullName;
    private String email;
}
