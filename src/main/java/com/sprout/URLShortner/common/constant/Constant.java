package com.sprout.URLShortner.common.constant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Constant {

    private void Constant() {}

    public static final String URL_VALIDATION_REGEX = "[(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";

    public static final List<Character> ALLOWED_CHARACTERS_IN_URL_LIST = new ArrayList<>(IntStream.rangeClosed(45, 123)
            .filter(x -> Character.isLowerCase(x) || Character.isUpperCase(x) || Character.isDigit(x))
            .mapToObj(i -> (char) i)
            .collect(Collectors.toSet()));

    public static final int ALLOWED_CHARACTERS_IN_URL_COUNT = ALLOWED_CHARACTERS_IN_URL_LIST.size();

    public static final String SYSTEM_CREATOR = "System";

    public static final int SALTING_KEY = 13;

    public static final int NUMBER_OF_CHARACTERS_IN_SHORT_URL = 7;

    public static final String SHORT_URL_REGEX = "[a-zA-Z0-9]{%s,}";

}
