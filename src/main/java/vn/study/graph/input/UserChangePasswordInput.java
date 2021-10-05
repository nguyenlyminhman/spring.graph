package vn.study.graph.input;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class UserChangePasswordInput {
    private String oldPassword;
    private String newPassword;
    private String email;
}
