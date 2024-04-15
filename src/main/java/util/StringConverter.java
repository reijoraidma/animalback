package util;

import java.nio.charset.StandardCharsets;

public class StringConverter {

    public static String bytesToString(byte[] bytes) {
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public static byte[] stringToBytes(String string) {
        byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
        return bytes;
    }

}
