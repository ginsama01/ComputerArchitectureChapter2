package doubletype;

import integer.IntegerType;

public class DoubleType {

    public static String tenToTinh(String ten) {
        ten = FormatDouble.formatONho(ten);
        if (ten.isEmpty()) {
            return "";
        }
        if (ten.equals(0)) {
            return "0";
        }
        double phanThuc = Double.parseDouble(ten);
        if (phanThuc < 0) {
            return "None";
        }
        int phanNguyen = (int)phanThuc;
        phanThuc -= phanNguyen;
        String result = "";
        if (phanNguyen == 0) result = "0";
        while (phanNguyen > 0) {
            result = (phanNguyen % 2) + result;
            phanNguyen /= 2;
        }
        if (phanThuc == 0) {
            return result;
        }
        result += ".";
        int dem = 0;
        while (phanThuc != 0 && dem < 16) {
            phanThuc *= 2;
            if (phanThuc >= 1) {
                result += "1";
                phanThuc -= 1;
                dem++;
            } else {
                result += "0";
                dem++;
            }
        }
        return result;
    }

    public static String tenToTinhSign(String ten, String bitNguyen, String bitThuc) {
        ten = FormatDouble.formatONho(ten);
        String result;
        if (ten.charAt(0) == '-') {
            result = tenToTinh(ten.substring(1));
        } else {
            result = tenToTinh(ten);
        }
        String phanNguyen = "", phanThuc = "";
        for (int i = 0; i < result.length(); ++i)
            if (result.charAt(i) == '.') {
                for (int j = i + 1; j < result.length(); ++j) {
                    phanThuc += result.charAt(j);
                }
                break;
            } else {
                phanNguyen += result.charAt(i);
            }
        int num = (int)Double.parseDouble(ten);
        int maxInt = (1 << (Integer.parseInt(bitNguyen)-1)) - 1;
        int minInt = - (1 << (Integer.parseInt(bitNguyen)-1));
        if (num > maxInt) {
            return "Tràn số";
        } else if (num < minInt) {
            return "Tràn số";
        }
        if (phanNguyen.length() >= Integer.parseInt(bitNguyen)) {
            return "Tràn số";
        }
        while (phanNguyen.length() < Integer.parseInt(bitNguyen)) {
            phanNguyen = "0" + phanNguyen;
        }
        while (phanThuc.length() > Integer.parseInt(bitThuc)) {
            phanThuc = phanThuc.substring(0, phanThuc.length() - 1);
        }
        while (phanThuc.length() < Integer.parseInt(bitThuc)) {
            phanThuc += "0";
        }
        result = phanNguyen + phanThuc;
        if (ten.charAt(0) == '-') {
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

    public static String tenToDauPhayDong(String ten) {
        ten = FormatDouble.formatONho(ten);
        String result;
        if (ten.charAt(0) == '-') {
            result = tenToTinh(ten.substring(1));
        } else {
            result = tenToTinh(ten);
        }
        if (result.length() == 1) {
            if (ten.charAt(0) == '-') {
                return "-" + result + " x 2^0";
            } else {
                return result + " x 2^0";
            }
        }
        if (result.charAt(0) == '0') {
            int dem = -1;
            for (int i = 0; i < result.length(); ++i) {
                if (result.charAt(i) == '1') {
                    dem = i;
                    break;
                }
            }
            String res = "1";
            if (dem != result.length() - 1) {
                res += ".";
                for (int i = dem + 1; i < result.length(); ++i) {
                    res += result.charAt(i);
                }
                while (res.charAt(res.length() - 1) == '0') {
                    res = res.substring(0, res.length() - 1);
                }
            }
            res = res + " x 2^(" + String.valueOf(1-dem) + ")";
            if (ten.charAt(0) == '-') {
                return FormatDouble.formatReverse("-" + res);
            } else {
                return FormatDouble.formatReverse(res);
            }
        }
        int dem = -1;
        for (int i = 0; i < result.length(); ++i) {
            if (result.charAt(i) == '.') {
                dem = i - 1;
                break;
            }
        }
        String res = "1.";
        if (dem == -1) dem = result.length() - 1;
        for (int i = 1; i < result.length(); ++i) {
            if (result.charAt(i) != '.') {
                res += result.charAt(i);
            }
        }
        while (res.charAt(res.length() - 1) == '0') {
            res = res.substring(0, res.length() - 1);
        }
        if (res.charAt(res.length() - 1) == '.') {
            res = res.substring(0, res.length() - 1);
        }
        res = res + " x 2^(" + dem + ")";
        if (ten.charAt(0) == '-') {
            return FormatDouble.formatReverse("-" + res);
        } else {
            return FormatDouble.formatReverse(res);
        }
    }

    public static String dauPhayDongToDoCxacDon(String dpd) {
        dpd = FormatDouble.formatTo(dpd);
        String result = "";
        int so = 2;
        if (dpd.charAt(0) == '-') {
            result = result + "1";
            so = 3;
            if (dpd.charAt(2) != '.') {
                so = 2;
            }
        } else {
            result = result + "0";
            if (dpd.charAt(1) != '.') {
                so = 1;
            }
        }
        int dau = 0;
        for (int i = dpd.length() - 1; i >= 0; --i) {
            if (dpd.charAt(i) == '(') {
                dau = i;
                break;
            }
        }
        String mu = dpd.substring(dau + 1, dpd.length() - 1);
        String ex = IntegerType.tenToTwo(String.valueOf(Integer.parseInt(mu) + 127), "8");
        result += ex;
        String fraction = FormatDouble.formatFraction(dpd.substring(so, dau - 5), "23");
        return result + fraction;
    }

    public static String doCxacDonToDauPhayDong(String single) {
        single = FormatDouble.formatONho(single);
        String ex = single.substring(1, 9);
        String fraction = single.substring(9, 32);
        while (!fraction.isEmpty() && fraction.charAt(fraction.length() - 1) == '0') {
            fraction = fraction.substring(0, fraction.length() - 1);
        }
        if (!fraction.isEmpty()) {
            fraction = "." + fraction;
        }
        if (ex.equals("00000000")) {
            if (single.charAt(0) == '1') {
                return "-0" + fraction + " x 2^(-127)";
            } else {
                return "0" + fraction + " x 2^(-127)";
            }
        } else if (ex.equals("11111111")) {
            if (fraction.isEmpty()) {
                return "Vô cùng lớn";
            } else {
                return "NaN";
            }
        } else {
            int mu = Integer.parseInt(IntegerType.twoToTen(ex));
            mu -= 127;
            if (single.charAt(0) == '1') {
                return FormatDouble.formatReverse("-1" + fraction + " x 2^(" + String.valueOf(mu) + ")");
            } else {
                return FormatDouble.formatReverse("1" + fraction + " x 2^(" + String.valueOf(mu) + ")");
            }
        }
    }

    public static String dauPhayDongToDoCxacKep(String dpd) {
        dpd = FormatDouble.formatTo(dpd);
        String result = "";
        int so = 2;
        if (dpd.charAt(0) == '-') {
            result = result + "1";
            so = 3;
            if (dpd.charAt(2) != '.') {
                so = 2;
            }
        } else {
            result = result + "0";
            if (dpd.charAt(1) != '.') {
                so = 1;
            }
        }
        int dau = 0;
        for (int i = dpd.length() - 1; i >= 0; --i) {
            if (dpd.charAt(i) == '(') {
                dau = i;
                break;
            }
        }
        String mu = dpd.substring(dau + 1, dpd.length() - 1);
        String ex = IntegerType.tenToTwo(String.valueOf(Integer.parseInt(mu) + 1023), "11");
        result += ex;
        String fraction = FormatDouble.formatFraction(dpd.substring(so, dau - 5), "52");
        return result + fraction;
    }

    public static String doCxacKepToDauPhayDong(String single) {
        single = FormatDouble.formatONho(single);
        String ex = single.substring(1, 12);
        String fraction = single.substring(12, 64);
        while (!fraction.isEmpty() && fraction.charAt(fraction.length() - 1) == '0') {
            fraction = fraction.substring(0, fraction.length() - 1);
        }
        if (!fraction.isEmpty()) {
            fraction = "." + fraction;
        }
        if (ex.equals("00000000000")) {
            if (single.charAt(0) == '1') {
                return "-0" + fraction + " x 2^(-1023)";
            } else {
                return "0" + fraction + " x 2^(-1023)";
            }
        } else if (ex.equals("11111111111")) {
            if (fraction.isEmpty()) {
                return "Vô cùng lớn";
            } else {
                return "NaN";
            }
        } else {
            int mu = Integer.parseInt(IntegerType.twoToTen(ex));
            mu -= 1023;
            if (single.charAt(0) == '1') {
                return FormatDouble.formatReverse("-1" + fraction + " x 2^(" + String.valueOf(mu) + ")");
            } else {
                return FormatDouble.formatReverse("1" + fraction + " x 2^(" + String.valueOf(mu) + ")");
            }
        }
    }

    public static String tinhToTen(String tinh) {
        tinh = FormatDouble.formatONho(tinh);
        int ok = 0;
        for (int i = 0; i < tinh.length(); ++i) {
            if (tinh.charAt(i) == '.') {
                ok = i;
                break;
            }
        }
        if (ok == 0) {
            for (int i = 0; i < tinh.length(); ++i) {
                ok += (tinh.charAt(i) - '0') * (1 << (tinh.length() - i - 1));
            }
            return String.valueOf(ok);
        } else {
            double so = 0;
            for (int i = 0; i < ok; ++i) {
                so += (tinh.charAt(i) - '0') * (1 << (ok - i - 1));
            }
            double mu = 1;
            for (int i = ok + 1; i < tinh.length(); ++i) {
                mu /= 2;
                so += (tinh.charAt(i) - '0') * mu;
            }
            return String.valueOf(so);
        }
    }

    public static String bitdauToTen(String bitdau, String bitNguyen, String bitThuc) {
        bitdau = FormatDouble.formatONho(bitdau);
        for (int i = 0; i < bitdau.length(); ++i) {
            if (bitdau.charAt(i) == '.') {
                bitdau = bitdau.substring(0, i) + bitdau.substring(i+1, bitdau.length());
                bitNguyen = String.valueOf(i);
                bitThuc = String.valueOf(bitdau.length() - i);
                break;
            }
        }
        int sign = 0;
        String result = bitdau;
        if (bitdau.charAt(0) == '1') {
            sign = 1;
            int nho = 0;
            if (bitdau.charAt(bitdau.length() - 1) == '0') {
                nho = 1;
                result = "1";
            } else {
                result = "0";
            }
            for (int i = bitdau.length() - 2; i >= 0; --i) {
                int num = bitdau.charAt(i) - nho - '0';
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
        }
        result = result.substring(0, Integer.parseInt(bitNguyen)) + "."
                + result.substring(Integer.parseInt(bitNguyen), result.length());
        if (sign == 1) {
            return "-" + tinhToTen(result);
        } else {
            return tinhToTen(result);
        }
    }
}
