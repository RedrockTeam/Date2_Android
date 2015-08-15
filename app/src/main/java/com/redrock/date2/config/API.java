package com.redrock.date2.config;

/**
 * Created by zhuchenxi on 15/8/2.
 */
public class API {
    public static final class URL{

        public static String QiniuToken = "";
    }

    public static class KEY {
        public static final String STATUS = "status";
        public static final String INFO = "info";
        public static final String DATA = "data";
    }

    public static class CODE {
        public static final int SUCCEED = 0;
        public static final int PARAMS_ERROR = 1;
        public static final int SERVER_ERROR = 1001;
        public static final int LOGINSTATUS_DENIED = 1002;
        public static final int ACCOUNT_DENIED = 1002;
        public static final int PARAMS_INVALID = -1;
        public static final int PERMISSION_DENIED = -3;
    }
}
