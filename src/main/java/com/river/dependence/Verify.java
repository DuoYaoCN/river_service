package com.river.dependence;

import com.baidu.aip.imageclassify.AipImageClassify;

public class Verify {
    static enum API {
        INSTANCE;
        private final AipImageClassify client;
        private static final String APP_ID = "17268189";
        private static final String API_KEY = "QI6jGRqAixgYnhWNFRyKS0dB";
        private static final String SECRET_KEY = "IrnXLep3ezNIsWPi5WxzwWDXGVzztKkQ";

        private API() {
            client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);
        }

        public AipImageClassify getInstnce() {
            return client;
        }
    }

    private Verify(){

    }

    public static AipImageClassify getInstance(){
        return API.INSTANCE.getInstnce();
    }

}
