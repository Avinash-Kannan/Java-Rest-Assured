import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Data
public class UserDetails {

    private String email;
    private String password;
    private String passwordRepeat;
    private SecurityQuestion securityQuestion;
    private String securityAnswer;

}
