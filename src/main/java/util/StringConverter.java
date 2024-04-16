package util;

import java.nio.charset.StandardCharsets;

public class StringConverter {

    public static String bytesToString(byte[] bytes) {
        if (bytes == null) {
            return "";
        }
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public static byte[] stringToBytes(String string) {
        if (string == null) {
            return null;
        }
        return string.getBytes(StandardCharsets.UTF_8);
    }

}
