package user;

import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;
@Data
@Builder
public class UserUITest {
        public String email;
        public String password;
        public String name;

        public static UserUITest getRandom() {
            final String email = RandomStringUtils.randomAlphabetic(8) + "@gmail.com";
            final String password = RandomStringUtils.randomAlphabetic(6);
            final String name = RandomStringUtils.randomAlphabetic(6);
            return new UserUITest(email, password, name);
        }

}
