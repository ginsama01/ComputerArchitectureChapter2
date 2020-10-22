package doubletype;

public class FormatDouble {

    public static String formatFraction(String fraction, String bit) {
        int so = Integer.parseInt(bit);
        if (fraction.length() > so) {
            return fraction.substring(0, so);
        } else {
            while (fraction.length() < so) {
                fraction += "0";
            }
            return fraction;
        }
    }

    public static String formatTo(String a) {
        while (a.charAt(a.length() - 1) == ' ') {
            a = a.substring(0, a.length() - 1);
        }
        for (int i = 0; i< a.length(); ++i) {
            if (a.charAt(i) == 'x') {
                if (a.charAt(i - 1) != ' ') {
                    String b = a.substring(0, i) + " " + a.substring(i, a.length());
                    a = b;
                }
            }
        }
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) == 'x') {
                if (a.charAt(i + 1) != ' ') {
                    String b = a.substring(0, i + 1) + " " + a.substring(i+1, a.length());
                    a = b;
                }
            }
        }
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) == '^') {
                if (a.charAt(i + 1) != '(') {
                    String b = a.substring(0, i + 1);
                    b = b + "(" + a.substring(i + 1, a.length()) + ")";
                    return b;
                }
            }
        }
        return a;
    }

    public static String formatReverse(String a) {
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) == '(') {
                if (a.charAt(i + 1) != '-') {
                    String b = a.substring(0, i);
                    b = b + a.substring(i + 1, a.length() - 1);
                    return b;
                }
            }
        }
        return a;
    }

    public static String formatONho(String a) {
        a = a.replaceAll("\\s+", "");
        return a;
    }
}
