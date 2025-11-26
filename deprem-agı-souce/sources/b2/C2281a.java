package b2;

import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.io.StringReader;
import kotlin.jvm.internal.t;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import t3.s;

/* renamed from: b2.a  reason: case insensitive filesystem */
public final class C2281a {

    /* renamed from: b2.a$a  reason: collision with other inner class name */
    private static final class C0204a {

        /* renamed from: a  reason: collision with root package name */
        private String f20685a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f20686b;

        public final String a() {
            return this.f20685a;
        }

        public final Integer b() {
            return this.f20686b;
        }

        public final void c(String str) {
            this.f20685a = str;
        }

        public final void d(Integer num) {
            this.f20686b = num;
        }
    }

    public final String a(String str) {
        t.e(str, "androidManifest");
        String str2 = str;
        String substring = str2.substring(s.f0(str2, "split=\"config.", 0, false, 6, (Object) null) + 14);
        t.d(substring, "substring(...)");
        String substring2 = substring.substring(0, s.f0(substring, "\"", 0, false, 6, (Object) null));
        t.d(substring2, "substring(...)");
        return substring2;
    }

    public final boolean b(String str) {
        t.e(str, "androidManifest");
        if (!s.V(str, "configForSplit=", false, 2, (Object) null) || s.V(str, "configForSplit=\"\"", false, 2, (Object) null)) {
            return false;
        }
        return true;
    }

    public final boolean c(String str) {
        t.e(str, "androidManifest");
        return s.T(str, "isFeatureSplit=\"-1\"", true);
    }

    public final boolean d(String str) {
        t.e(str, "androidManifest");
        return s.V(str, "split=\"config.", false, 2, (Object) null);
    }

    public final int e(String str) {
        t.e(str, "androidManifest");
        int i5 = -1;
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            XmlPullParser newPullParser = newInstance.newPullParser();
            newPullParser.setInput(new StringReader(str));
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2 && s.E(newPullParser.getName(), "meta-data", true)) {
                    C0204a aVar = new C0204a();
                    int attributeCount = newPullParser.getAttributeCount();
                    for (int i6 = 0; i6 < attributeCount; i6++) {
                        if (s.E(newPullParser.getAttributeName(i6), RewardPlus.NAME, true) && s.E(newPullParser.getAttributeValue(i6), "com.android.vending.derived.apk.id", true)) {
                            aVar.c(newPullParser.getAttributeValue(i6));
                        } else if (s.E(newPullParser.getAttributeName(i6), "value", true)) {
                            try {
                                String attributeValue = newPullParser.getAttributeValue(i6);
                                t.d(attributeValue, "getAttributeValue(...)");
                                aVar.d(Integer.valueOf(Integer.parseInt(attributeValue)));
                            } catch (NumberFormatException unused) {
                            }
                        }
                    }
                    String a5 = aVar.a();
                    if (a5 != null) {
                        if (a5.length() != 0) {
                            if (aVar.b() != null) {
                                Integer b5 = aVar.b();
                                t.b(b5);
                                i5 = b5.intValue();
                            }
                        }
                    }
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        return i5;
    }
}
