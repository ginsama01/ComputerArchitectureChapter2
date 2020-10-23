package integer;

import doubletype.FormatDouble;

public class IntegerType {
    public static String tenToTwo(String ten, String bit) {
        ten = FormatDouble.formatONho(ten);
        if (ten.isEmpty()) {
            return "";
        }
        int num = Integer.parseInt(ten);
        if (num != Math.abs(num)) {
            return "None";
        }
        String result = "";
        while (num > 0) {
            result = (num % 2) + result;
            num /= 2;
        }
        if (bit.equals("Free")) {
            return result;
        }
        if (result.length() > Integer.parseInt(bit)) {
            return "Tràn số";
        } else {
            while (result.length() < Integer.parseInt(bit)) {
                result = "0" + result;
            }
            return result;
        }
    }

    public static String tenToBitDau(String ten, String bit) {
        ten = FormatDouble.formatONho(ten);
        if (ten.isEmpty()) {
            return "";
        }
        int num = Integer.parseInt(ten);
        int bitdau = 0;
        if (num < 0) {
            bitdau = 1;
            num = -num;
        }
        String result = "";
        while (num > 0) {
            result = (num % 2) + result;
            num /= 2;
        }
        if (result.length() > (Integer.parseInt(bit) - 1)) {
            return "Tràn số";
        } else {
            while (result.length() < (Integer.parseInt(bit) - 1)) {
                result = "0" + result;
            }
            result = bitdau + result;
            return result;
        }
    }

    public static String tenToChuanBu1(String ten, String bit) {
        ten = FormatDouble.formatONho(ten);
        if (ten.isEmpty()) {
            return "";
        }
        int num = Integer.parseInt(ten);
        int bitdau = 0;
        if (num < 0) {
            bitdau = 1;
            num = -num;
        }
        String result = "";
        while (num > 0) {
            result = (num % 2) + result;
            num /= 2;
        }
        if (result.length() > (Integer.parseInt(bit) - 1)) {
            return "Tràn số";
        } else {
            while (result.length() < Integer.parseInt(bit)) {
                result = "0" + result;
            }
            if (bitdau == 1) {
                result = result.replace('0', '2');
                result = result.replace('1', '0');
                result = result.replace('2', '1');
            }
            return result;
        }

    }

    public static String tenToChuanBu2(String ten, String bit) {
        ten = FormatDouble.formatONho(ten);
        if (ten.isEmpty()) {
            return "";
        }
        int num = Integer.parseInt(ten);
        int maxInt = (1 << (Integer.parseInt(bit)-1)) - 1;
        int minInt = - (1 << (Integer.parseInt(bit)-1));
        if (num > maxInt) {
            return "Tràn số";
        } else if (num < minInt) {
            return "Tràn số";
        }
        int bitdau = 0;
        if (num < 0) {
            bitdau = 1;
            num = -num;
        }
        String result = "";
        while (num > 0) {
            result = (num % 2) + result;
            num /= 2;
        }
        while (result.length() < Integer.parseInt(bit)) {
            result = "0" + result;
        }
        if (bitdau == 1) {
            result = result.replace('0', '2');
            result = result.replace('1', '0');
            result = result.replace('2', '1');
            String res = "";
            int nho = 0;
            if (result.charAt(result.length() - 1) == '0') {
                res = "1";
            } else {
                res = "0";
                nho = 1;
            }
            for (int i = result.length() - 2; i >= 0; --i) {
                int so = nho + result.charAt(i) - '0';
                nho = so/2;
                res = (char)(so % 2 + '0') + res;
            }
            return res;
        }
        return result;
    }

    public static String twoToTen(String two) {
        two = FormatDouble.formatONho(two);
        if (two.isEmpty()) {
            return "";
        }
        int num = 0;
        for (int i = 0; i < two.length(); ++i) {
            num += (two.charAt(i) - '0') * (1 << (two.length() - i - 1));
        }
        return String.valueOf(num);
    }

    public static String bitDauToTen(String bitdau) {
        bitdau = FormatDouble.formatONho(bitdau);
        if (bitdau.isEmpty()) {
            return "";
        }
        int num = 0;
        for (int i = 1; i < bitdau.length(); ++i) {
            num += (bitdau.charAt(i) - '0') * (1 << (bitdau.length() - i - 1));
        }
        if (bitdau.charAt(0) == '1') {
            return "-" + String.valueOf(num);
        } else {
            return String.valueOf(num);
        }
    }

    public static String chuanBu1ToTen(String cb1) {
        cb1 = FormatDouble.formatONho(cb1);
        if (cb1.isEmpty()) {
            return "";
        }
        int ok = 0;
        if (cb1.charAt(0) == '1') {
            cb1 = cb1.replace('0', '2');
            cb1 = cb1.replace('1', '0');
            cb1 = cb1.replace('2', '1');
            ok = 1;
        }
        int num = 0;
        for (int i = 1; i < cb1.length(); ++i) {
            num += (cb1.charAt(i) - '0') * (1 << (cb1.length() - i - 1));
        }
        if (ok == 1) {
            return "-" + String.valueOf(num);
        } else {
            return String.valueOf(num);
        }
    }

    public static String chuanBu2ToTen(String cb2) {
        cb2 = FormatDouble.formatONho(cb2);
        if (cb2.isEmpty()) {
            return "";
        }
        String result = cb2;
        if (cb2.charAt(0) == '1') {
            int nho = 0;
            if (cb2.charAt(cb2.length() - 1) == '0') {
                nho = 1;
                result = "1";
            } else {
                result = "0";
            }
            for (int i = cb2.length() - 2; i >= 0; --i) {
                int num = cb2.charAt(i) - nho - '0';
                if (num < 0) {
                    result = "1" + result;
                    nho = 1;
                } else {
                    nho = 0;
                    result = num + result;
                }
            }
            result = result.replace('0', '2');
            result = result.replace('1', '0');
            result = result.replace('2', '1');
            return "-" + twoToTen(result);
        }
        return twoToTen(result);
    }

    public static String twoToThapLucPhan(String two) {
        two = FormatDouble.formatONho(two);
        if (two.isEmpty()) {
            return "";
        }
        if (two.equals("None")) {
            return "None";
        }
        int dem = 0;
        int i = two.length()-1;
        int so = 0;
        String result = "";
        while (i >= 0) {
            so += (two.charAt(i) - '0') * (1 << dem);
            ++dem;
            if (dem == 4 || i == 0) {
                if (so <= 9) result = so + result;
                if (so == 10) result = 'A' + result;
                if (so == 11) result = 'B' + result;
                if (so == 12) result = 'C' + result;
                if (so == 13) result = 'D' + result;
                if (so == 14) result = 'E' + result;
                if (so == 15) result = 'F' + result;
                dem = 0;
                so = 0;
            }
            --i;
        }
        while (result.length() > 1 && result.charAt(0) == '0') result = result.substring(1);
        return result;
    }

    public static String twoToBatPhan(String two) {
        two = FormatDouble.formatONho(two);
        if (two.isEmpty()) {
            return "";
        }
        if (two.equals("None")) {
            return "None";
        }
        int dem = 0;
        int i = two.length()-1;
        int so = 0;
        String result = "";
        while (i >= 0) {
            so += (two.charAt(i) - '0') * (1 << dem);
            ++dem;
            if (dem == 3 || i == 0) {
                result = so + result;
                dem = 0;
                so = 0;
            }
            --i;
        }
        while (result.length() > 1 && result.charAt(0) == '0') result = result.substring(1);
        return result;
    }


}
