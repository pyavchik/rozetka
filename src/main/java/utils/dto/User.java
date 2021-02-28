package utils.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private String name;
    private String email;
    private String password;
}
