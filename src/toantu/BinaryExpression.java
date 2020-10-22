package toantu;

import doubletype.DoubleType;
import doubletype.FormatDouble;

import static doubletype.FormatDouble.formatTo;

public class BinaryExpression {

    public static String add(String a, String b) {
        a = formatTo(a);
        b = formatTo(b);
        String giatriA = "", giatriB = "";
        int muA = 0, muB = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) == '(') {
                if (a.charAt(0) == '-') {
                    giatriA = a.substring(1, i-5);
                } else {
                    giatriA = a.substring(0, i-5);
                }
                muA = Integer.parseInt(a.substring(i+1, a.length() - 1));
            }
        }
        for (int i = 0; i < b.length(); ++i) {
            if (b.charAt(i) == '(') {
                if (b.charAt(0) == '-') {
                    giatriB = b.substring(1, i-5);
                } else {
                    giatriB = b.substring(0, i-5);
                }
                muB = Integer.parseInt(b.substring(i+1, b.length() - 1));
            }
        }
        double gtA = Double.parseDouble(giatriA);
        double gtB = Double.parseDouble(giatriB);
        while (muA < muB) {
            gtA /= 10;
            muA++;
        }
        while (muB < muA) {
            gtB /= 10;
            muB++;
        }
        giatriA = String.valueOf(gtA);
        giatriB = String.valueOf(gtB);
        gtA = Double.parseDouble(DoubleType.tinhToTen(giatriA));
        gtB = Double.parseDouble(DoubleType.tinhToTen(giatriB));
        if (a.charAt(0) == '-') gtA *= (-1);
        if (b.charAt(0) == '-') gtB *= (-1);
        double ketqua = gtA + gtB;
        String result = DoubleType.tenToDauPhayDong(String.valueOf(ketqua));
        result = formatTo(result);
        int mu = 0;
        for (int i = 0; i < result.length(); ++i) {
            if (result.charAt(i) == '(') {
                mu = Integer.parseInt(result.substring(i+1, result.length() - 1));
                result = result.substring(0, i);
                break;
            }
        }
        int newmu = mu + muA;
        String newNotOld = "(" + String.valueOf(newmu) + ")";
        result += newNotOld;
        return FormatDouble.formatReverse(result);
    }

    public static String sub(String a, String b) {
        a = formatTo(a);
        b = formatTo(b);
        String giatriA = "", giatriB = "";
        int muA = 0, muB = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) == '(') {
                if (a.charAt(0) == '-') {
                    giatriA = a.substring(1, i-5);
                } else {
                    giatriA = a.substring(0, i-5);
                }
                muA = Integer.parseInt(a.substring(i+1, a.length() - 1));
            }
        }
        for (int i = 0; i < b.length(); ++i) {
            if (b.charAt(i) == '(') {
                if (b.charAt(0) == '-') {
                    giatriB = b.substring(1, i-5);
                } else {
                    giatriB = b.substring(0, i-5);
                }
                muB = Integer.parseInt(b.substring(i+1, b.length() - 1));
            }
        }
        double gtA = Double.parseDouble(giatriA);
        double gtB = Double.parseDouble(giatriB);
        while (muA < muB) {
            gtA /= 10;
            muA++;
        }
        while (muB < muA) {
            gtB /= 10;
            muB++;
        }
        giatriA = String.valueOf(gtA);
        giatriB = String.valueOf(gtB);
        gtA = Double.parseDouble(DoubleType.tinhToTen(giatriA));
        gtB = Double.parseDouble(DoubleType.tinhToTen(giatriB));
        if (a.charAt(0) == '-') gtA *= (-1);
        if (b.charAt(0) == '-') gtB *= (-1);
        double ketqua = gtA - gtB;
        String result = DoubleType.tenToDauPhayDong(String.valueOf(ketqua));
        result = formatTo(result);
        int mu = 0;
        for (int i = 0; i < result.length(); ++i) {
            if (result.charAt(i) == '(') {
                mu = Integer.parseInt(result.substring(i+1, result.length() - 1));
                result = result.substring(0, i);
                break;
            }
        }
        int newmu = mu + muA;
        String newNotOld = "(" + String.valueOf(newmu) + ")";
        result += newNotOld;
        return FormatDouble.formatReverse(result);
    }

    public static String mul(String a, String b) {
        a = formatTo(a);
        b = formatTo(b);
        String giatriA = "", giatriB = "";
        int muA = 0, muB = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) == '(') {
                if (a.charAt(0) == '-') {
                    giatriA = a.substring(1, i-5);
                } else {
                    giatriA = a.substring(0, i-5);
                }
                muA = Integer.parseInt(a.substring(i+1, a.length() - 1));
            }
        }
        for (int i = 0; i < b.length(); ++i) {
            if (b.charAt(i) == '(') {
                if (b.charAt(0) == '-') {
                    giatriB = b.substring(1, i-5);
                } else {
                    giatriB = b.substring(0, i-5);
                }
                muB = Integer.parseInt(b.substring(i+1, b.length() - 1));
            }
        }
        double gtA = Double.parseDouble(DoubleType.tinhToTen(giatriA));
        double gtB = Double.parseDouble(DoubleType.tinhToTen(giatriB));
        if (a.charAt(0) == '-') gtA *= (-1);
        if (b.charAt(0) == '-') gtB *= (-1);
        double ketqua = gtA * gtB;
        String result = DoubleType.tenToDauPhayDong(String.valueOf(ketqua));
        result = formatTo(result);
        int mu = 0;
        for (int i = 0; i < result.length(); ++i) {
            if (result.charAt(i) == '(') {
                mu = Integer.parseInt(result.substring(i+1, result.length() - 1));
                result = result.substring(0, i);
                break;
            }
        }
        int newmu = mu + muA + muB;
        String newNotOld = "(" + String.valueOf(newmu) + ")";
        result += newNotOld;
        return FormatDouble.formatReverse(result);

    }

    public static String divide(String a, String b) {
        a = formatTo(a);
        b = formatTo(b);
        String giatriA = "", giatriB = "";
        int muA = 0, muB = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) == '(') {
                if (a.charAt(0) == '-') {
                    giatriA = a.substring(1, i-5);
                } else {
                    giatriA = a.substring(0, i-5);
                }
                muA = Integer.parseInt(a.substring(i+1, a.length() - 1));
            }
        }
        for (int i = 0; i < b.length(); ++i) {
            if (b.charAt(i) == '(') {
                if (b.charAt(0) == '-') {
                    giatriB = b.substring(1, i-5);
                } else {
                    giatriB = b.substring(0, i-5);
                }
                muB = Integer.parseInt(b.substring(i+1, b.length() - 1));
            }
        }
        double gtA = Double.parseDouble(DoubleType.tinhToTen(giatriA));
        double gtB = Double.parseDouble(DoubleType.tinhToTen(giatriB));
        if (a.charAt(0) == '-') gtA *= (-1);
        if (b.charAt(0) == '-') gtB *= (-1);
        double ketqua = gtA / gtB;
        String result = DoubleType.tenToDauPhayDong(String.valueOf(ketqua));
        result = formatTo(result);
        int mu = 0;
        for (int i = 0; i < result.length(); ++i) {
            if (result.charAt(i) == '(') {
                mu = Integer.parseInt(result.substring(i+1, result.length() - 1));
                result = result.substring(0, i);
                break;
            }
        }
        int newmu = mu + muA - muB;
        String newNotOld = "(" + String.valueOf(newmu) + ")";
        result += newNotOld;
        return FormatDouble.formatReverse(result);

    }
}
