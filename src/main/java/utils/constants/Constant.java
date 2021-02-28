package utils.constants;

import static utils.constants.Constant.Domains.UA;

public class Constant {
    public static class TimeoutVariables {
        public static final int IMPLICIT_WAIT = 10;
        public static final int EXPLICIT_WAIT = 40;
    }

    public static class Urls {
        public static final String HTTPS = "https://";
        public static final String HOST_NAME = "my.rozetka.com.ua";
        public static final String REGISTRATION_ENDPOINT = "/signup";
        public static final String REGISTRATION_URL = HTTPS + HOST_NAME + UA + REGISTRATION_ENDPOINT;
    }

    public static class Domains {
        public static final String UA = "/ua";
    }

}
