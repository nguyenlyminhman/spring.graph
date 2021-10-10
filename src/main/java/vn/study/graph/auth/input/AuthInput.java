package vn.study.graph.auth.input;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AuthInput {
    private String email;
    private String password;
}
