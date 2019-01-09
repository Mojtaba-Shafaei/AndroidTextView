package com.mojtaba_shafaei.androidTextView;

import java.text.NumberFormat;
import java.util.Locale;

public class Persian {

    private static Locale loc;
    private static NumberFormat nf;

    public static NumberFormat getNumberFormat() {
        if (loc == null) loc = new Locale("fa", "FA");
        if (nf == null) nf = NumberFormat.getNumberInstance(loc);
        return nf;
    }

    public static String formatInteger(String input) {
        return formatInteger(Integer.parseInt(input));
    }

    public static String formatInteger(int input) {
        return getNumberFormat().format(input);
    }

    public static String formatDobule(String input) {
        return formatDobule(Double.parseDouble(input));
    }

    public static String formatDobule(double input) {
        return getNumberFormat().format(input);
    }

    public static String format(String input) {
        if (null == input || input.isEmpty()) {
            return "";
        }
        String[][] replacements = {
                {"ا", "ا"}, {"أ", "ا"}, {"آ", "آ"}, {"ب", "ب"}, {"پ", "پ"}, {"ت", "ت"}, {"ث", "ث"}, {"ج", "ج"},
                {"چ", "چ"}, {"ح", "ح"}, {"خ", "خ"}, {"د", "د"}, {"ذ", "ذ"}, {"ر", "ر"}, {"ز", "ز"}, {"ژ", "ژ"},
                {"س", "س"}, {"ش", "ش"}, {"ص", "ص"}, {"ض", "ض"}, {"ط", "ط"}, {"ظ", "ظ"}, {"ع", "ع"}, {"غ", "غ"},
                {"ف", "ف"}, {"ق", "ق"}, {"ک", "ک"}, {"ك", "ک"}, {"گ", "گ"}, {"ل", "ل"}, {"م", "م"}, {"ن", "ن"},
                {"و", "و"}, {"ؤ", "و"}, {"ه", "ه"}, {"ة", "ه"}, {"ئ", "ئ"}, {"ى", "ی"}, {"ي", "ی"}, {"ی", "ی"},
                {"0", "۰"}, {"1", "۱"}, {"2", "۲"}, {"3", "۳"}, {"4", "۴"}, {"5", "۵"}, {"6", "۶"}, {"7", "۷"},
                {"8", "۸"}, {"9", "۹"}, {"٠", "۰"}, {"١", "۱"}, {"٢", "۲"}, {"٣", "۳"}, {"٤", "۴"}, {"٥", "۵"},
                {"٦", "۶"}, {"٧", "۷"}, {"٨", "۸"}, {"٩", "۹"}
        };

        for (String[] replacement : replacements) {
            input = input.replace(replacement[0], replacement[1]);
        }

        return input;
    }

    static String rtl(String input) {
        return "\u200F" + input;
    }

}
