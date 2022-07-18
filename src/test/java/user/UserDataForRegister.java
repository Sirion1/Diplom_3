package user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDataForRegister extends UserGetter {
        private String email;
        private String password;
    }

