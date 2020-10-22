package integer;

public class FormatInteger {
    public static String formatBinary(String binary, String bit) {
        if (binary.isEmpty()) {
            return "";
        }
        while (binary.length() < Integer.parseInt(bit)) {
            binary = "0" + binary;
        }
        return binary;
    }

    public static String formatBinaryBit(String binary, String bit) {
        if (binary.isEmpty()) {
            return "";
        }
        String result = binary.substring(1);
        while (result.length() < (Integer.parseInt(bit) - 1)) {
            result = "0" + result;
        }
        return binary.charAt(0) + result;
    }

    public static String formatBinaryCb(String binary, String bit) {
        if (binary.isEmpty()) {
            return "";
        }
        while (binary.length() < (Integer.parseInt(bit))) {
            binary = binary.charAt(0) + binary;
        }
        return binary;
    }

}
