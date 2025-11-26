package com.google.gson;

import com.google.gson.internal.x;
import com.google.gson.internal.z;
import j1.C1679a;
import java.math.BigDecimal;

public enum s implements t {
    DOUBLE {
        /* renamed from: c */
        public Double a(C1679a aVar) {
            return Double.valueOf(aVar.C());
        }
    },
    LAZILY_PARSED_NUMBER {
        public Number a(C1679a aVar) {
            return new x(aVar.L());
        }
    },
    LONG_OR_DOUBLE {
        private Number c(String str, C1679a aVar) {
            try {
                Double valueOf = Double.valueOf(str);
                if (!valueOf.isInfinite()) {
                    if (valueOf.isNaN()) {
                    }
                    return valueOf;
                }
                if (!aVar.y()) {
                    throw new j1.d("JSON forbids NaN and infinities: " + valueOf + "; at path " + aVar.u());
                }
                return valueOf;
            } catch (NumberFormatException e5) {
                throw new l("Cannot parse " + str + "; at path " + aVar.u(), e5);
            }
        }

        public Number a(C1679a aVar) {
            String L4 = aVar.L();
            if (L4.indexOf(46) >= 0) {
                return c(L4, aVar);
            }
            try {
                return Long.valueOf(Long.parseLong(L4));
            } catch (NumberFormatException unused) {
                return c(L4, aVar);
            }
        }
    },
    BIG_DECIMAL {
        /* renamed from: c */
        public BigDecimal a(C1679a aVar) {
            String L4 = aVar.L();
            try {
                return z.b(L4);
            } catch (NumberFormatException e5) {
                throw new l("Cannot parse " + L4 + "; at path " + aVar.u(), e5);
            }
        }
    };
}
