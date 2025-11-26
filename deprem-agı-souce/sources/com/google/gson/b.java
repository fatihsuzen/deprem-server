package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;

public enum b implements d {
    IDENTITY {
        public String b(Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE {
        public String b(Field field) {
            return b.e(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES {
        public String b(Field field) {
            return b.e(b.d(field.getName(), ' '));
        }
    },
    UPPER_CASE_WITH_UNDERSCORES {
        public String b(Field field) {
            return b.d(field.getName(), '_').toUpperCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_UNDERSCORES {
        public String b(Field field) {
            return b.d(field.getName(), '_').toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DASHES {
        public String b(Field field) {
            return b.d(field.getName(), '-').toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DOTS {
        public String b(Field field) {
            return b.d(field.getName(), '.').toLowerCase(Locale.ENGLISH);
        }
    };

    static String d(String str, char c5) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            char charAt = str.charAt(i5);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(c5);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    static String e(String str) {
        int length = str.length();
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                break;
            }
            char charAt = str.charAt(i5);
            if (!Character.isLetter(charAt)) {
                i5++;
            } else if (!Character.isUpperCase(charAt)) {
                char upperCase = Character.toUpperCase(charAt);
                if (i5 == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i5) + upperCase + str.substring(i5 + 1);
            }
        }
        return str;
    }
}
