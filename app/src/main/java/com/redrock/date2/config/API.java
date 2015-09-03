package com.redrock.date2.config;

/**
 * Created by zhuchenxi on 15/8/2.
 */
public class API {
    public static final class URL{
        public static final String BASEURL = "http://123.56.225.103/api/index.php?s=/api/";

        public static final String Register = BASEURL+"public/register";
        public static final String Login = BASEURL+"public/login";
        public static final String Pwdfind = BASEURL+"account/pwdfind";
        public static final String Certification = BASEURL+"account/verify";
        public static final String DateList = BASEURL+"date/datefilter";
        public static final String DateType = BASEURL+"public/datetype";
        public static final String PublishDate = BASEURL+"date/createdate";
        public static final String ActionList = BASEURL+"discover/discoverlist";
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
