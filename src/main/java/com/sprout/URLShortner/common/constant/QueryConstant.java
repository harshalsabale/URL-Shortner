package com.sprout.URLShortner.common.constant;

public class QueryConstant {

    private void QueryConstant() {}

    public static final String GET_URL_FROM_KEY = "SELECT value FROM LinkMappingEntity lm where lm.key = :keyUrl";

}
