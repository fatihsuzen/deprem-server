package B0;

import A0.C0621a;
import A0.F;
import M0.d;
import android.util.Base64;
import android.util.JsonReader;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.entity.b;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import j$.util.DesugarCollections;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final K0.a f2292a = new d().j(C0621a.f1886a).k(true).i();

    private interface a {
        Object a(JsonReader jsonReader);
    }

    private static F.e.d.f A(JsonReader jsonReader) {
        F.e.d.f.a a5 = F.e.d.f.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            if (!nextName.equals("assignments")) {
                jsonReader.skipValue();
            } else {
                a5.b(n(jsonReader, new f()));
            }
        }
        jsonReader.endObject();
        return a5.a();
    }

    private static F.e.d.a.b.C0029d B(JsonReader jsonReader) {
        F.e.d.a.b.C0029d.C0030a a5 = F.e.d.a.b.C0029d.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -1147692044:
                    if (nextName.equals("address")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case 3059181:
                    if (nextName.equals("code")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 3373707:
                    if (nextName.equals(RewardPlus.NAME)) {
                        c5 = 2;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    a5.b(jsonReader.nextLong());
                    break;
                case 1:
                    a5.c(jsonReader.nextString());
                    break;
                case 2:
                    a5.d(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a5.a();
    }

    /* access modifiers changed from: private */
    public static F.e.d.a.b.C0031e C(JsonReader jsonReader) {
        F.e.d.a.b.C0031e.C0032a a5 = F.e.d.a.b.C0031e.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -1266514778:
                    if (nextName.equals(b.JSON_KEY_FRAME_ADS)) {
                        c5 = 0;
                        break;
                    }
                    break;
                case 3373707:
                    if (nextName.equals(RewardPlus.NAME)) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c5 = 2;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    a5.b(n(jsonReader, new i()));
                    break;
                case 1:
                    a5.d(jsonReader.nextString());
                    break;
                case 2:
                    a5.c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a5.a();
    }

    /* access modifiers changed from: private */
    public static F.d.b D(JsonReader jsonReader) {
        F.d.b.a a5 = F.d.b.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            if (nextName.equals("filename")) {
                a5.c(jsonReader.nextString());
            } else if (!nextName.equals("contents")) {
                jsonReader.skipValue();
            } else {
                a5.b(Base64.decode(jsonReader.nextString(), 2));
            }
        }
        jsonReader.endObject();
        return a5.a();
    }

    private static F.d E(JsonReader jsonReader) {
        F.d.a a5 = F.d.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            if (nextName.equals("files")) {
                a5.b(n(jsonReader, new e()));
            } else if (!nextName.equals("orgId")) {
                jsonReader.skipValue();
            } else {
                a5.c(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return a5.a();
    }

    private static F.e.C0038e F(JsonReader jsonReader) {
        F.e.C0038e.a a5 = F.e.C0038e.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -911706486:
                    if (nextName.equals("buildVersion")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -293026577:
                    if (nextName.equals("jailbroken")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 351608024:
                    if (nextName.equals("version")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 1874684019:
                    if (nextName.equals("platform")) {
                        c5 = 3;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    a5.b(jsonReader.nextString());
                    break;
                case 1:
                    a5.c(jsonReader.nextBoolean());
                    break;
                case 2:
                    a5.e(jsonReader.nextString());
                    break;
                case 3:
                    a5.d(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a5.a();
    }

    /* access modifiers changed from: private */
    public static F.e.d.a.c G(JsonReader jsonReader) {
        F.e.d.a.c.C0035a a5 = F.e.d.a.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case 110987:
                    if (nextName.equals("pid")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case 202325402:
                    if (nextName.equals("processName")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 1694598382:
                    if (nextName.equals("defaultProcess")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c5 = 3;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    a5.d(jsonReader.nextInt());
                    break;
                case 1:
                    a5.e(jsonReader.nextString());
                    break;
                case 2:
                    a5.b(jsonReader.nextBoolean());
                    break;
                case 3:
                    a5.c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a5.a();
    }

    private static F H(JsonReader jsonReader) {
        F.b b5 = F.b();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -2118372775:
                    if (nextName.equals("ndkPayload")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -1962630338:
                    if (nextName.equals("sdkVersion")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case -1907185581:
                    if (nextName.equals("appQualitySessionId")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case -1375141843:
                    if (nextName.equals("appExitInfo")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case -911706486:
                    if (nextName.equals("buildVersion")) {
                        c5 = 4;
                        break;
                    }
                    break;
                case -401988390:
                    if (nextName.equals("firebaseAuthenticationToken")) {
                        c5 = 5;
                        break;
                    }
                    break;
                case 344431858:
                    if (nextName.equals("gmpAppId")) {
                        c5 = 6;
                        break;
                    }
                    break;
                case 719853845:
                    if (nextName.equals("installationUuid")) {
                        c5 = 7;
                        break;
                    }
                    break;
                case 1047652060:
                    if (nextName.equals("firebaseInstallationId")) {
                        c5 = 8;
                        break;
                    }
                    break;
                case 1874684019:
                    if (nextName.equals("platform")) {
                        c5 = 9;
                        break;
                    }
                    break;
                case 1975623094:
                    if (nextName.equals("displayVersion")) {
                        c5 = 10;
                        break;
                    }
                    break;
                case 1984987798:
                    if (nextName.equals("session")) {
                        c5 = 11;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    b5.j(E(jsonReader));
                    break;
                case 1:
                    b5.l(jsonReader.nextString());
                    break;
                case 2:
                    b5.c(jsonReader.nextString());
                    break;
                case 3:
                    b5.b(m(jsonReader));
                    break;
                case 4:
                    b5.d(jsonReader.nextString());
                    break;
                case 5:
                    b5.f(jsonReader.nextString());
                    break;
                case 6:
                    b5.h(jsonReader.nextString());
                    break;
                case 7:
                    b5.i(jsonReader.nextString());
                    break;
                case 8:
                    b5.g(jsonReader.nextString());
                    break;
                case 9:
                    b5.k(jsonReader.nextInt());
                    break;
                case 10:
                    b5.e(jsonReader.nextString());
                    break;
                case 11:
                    b5.m(J(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return b5.a();
    }

    private static F.e.d.C0037e.b I(JsonReader jsonReader) {
        F.e.d.C0037e.b.a a5 = F.e.d.C0037e.b.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            if (nextName.equals("variantId")) {
                a5.c(jsonReader.nextString());
            } else if (!nextName.equals("rolloutId")) {
                jsonReader.skipValue();
            } else {
                a5.b(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return a5.a();
    }

    private static F.e J(JsonReader jsonReader) {
        F.e.b a5 = F.e.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -2128794476:
                    if (nextName.equals("startedAt")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -1907185581:
                    if (nextName.equals("appQualitySessionId")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case -1618432855:
                    if (nextName.equals("identifier")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case -1606742899:
                    if (nextName.equals("endedAt")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case -1335157162:
                    if (nextName.equals("device")) {
                        c5 = 4;
                        break;
                    }
                    break;
                case -1291329255:
                    if (nextName.equals("events")) {
                        c5 = 5;
                        break;
                    }
                    break;
                case 3556:
                    if (nextName.equals("os")) {
                        c5 = 6;
                        break;
                    }
                    break;
                case 96801:
                    if (nextName.equals(MBridgeConstans.DYNAMIC_VIEW_WX_APP)) {
                        c5 = 7;
                        break;
                    }
                    break;
                case 3599307:
                    if (nextName.equals("user")) {
                        c5 = 8;
                        break;
                    }
                    break;
                case 286956243:
                    if (nextName.equals("generator")) {
                        c5 = 9;
                        break;
                    }
                    break;
                case 1025385094:
                    if (nextName.equals("crashed")) {
                        c5 = 10;
                        break;
                    }
                    break;
                case 2047016109:
                    if (nextName.equals("generatorType")) {
                        c5 = 11;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    a5.m(jsonReader.nextLong());
                    break;
                case 1:
                    a5.c(jsonReader.nextString());
                    break;
                case 2:
                    a5.k(Base64.decode(jsonReader.nextString(), 2));
                    break;
                case 3:
                    a5.f(Long.valueOf(jsonReader.nextLong()));
                    break;
                case 4:
                    a5.e(q(jsonReader));
                    break;
                case 5:
                    a5.g(n(jsonReader, new d()));
                    break;
                case 6:
                    a5.l(F(jsonReader));
                    break;
                case 7:
                    a5.b(l(jsonReader));
                    break;
                case 8:
                    a5.n(K(jsonReader));
                    break;
                case 9:
                    a5.h(jsonReader.nextString());
                    break;
                case 10:
                    a5.d(jsonReader.nextBoolean());
                    break;
                case 11:
                    a5.i(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a5.a();
    }

    private static F.e.f K(JsonReader jsonReader) {
        F.e.f.a a5 = F.e.f.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if (jsonReader.nextName().equals("identifier")) {
                a5.b(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return a5.a();
    }

    private static F.e.a l(JsonReader jsonReader) {
        F.e.a.C0023a a5 = F.e.a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -1618432855:
                    if (nextName.equals("identifier")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -519438642:
                    if (nextName.equals("developmentPlatform")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 213652010:
                    if (nextName.equals("developmentPlatformVersion")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 351608024:
                    if (nextName.equals("version")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 719853845:
                    if (nextName.equals("installationUuid")) {
                        c5 = 4;
                        break;
                    }
                    break;
                case 1975623094:
                    if (nextName.equals("displayVersion")) {
                        c5 = 5;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    a5.e(jsonReader.nextString());
                    break;
                case 1:
                    a5.b(jsonReader.nextString());
                    break;
                case 2:
                    a5.c(jsonReader.nextString());
                    break;
                case 3:
                    a5.g(jsonReader.nextString());
                    break;
                case 4:
                    a5.f(jsonReader.nextString());
                    break;
                case 5:
                    a5.d(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a5.a();
    }

    private static F.a m(JsonReader jsonReader) {
        F.a.b a5 = F.a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -1516200806:
                    if (nextName.equals("buildIdMappingForArch")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case 110987:
                    if (nextName.equals("pid")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 111312:
                    if (nextName.equals("pss")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 113234:
                    if (nextName.equals("rss")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 55126294:
                    if (nextName.equals(CampaignEx.JSON_KEY_TIMESTAMP)) {
                        c5 = 4;
                        break;
                    }
                    break;
                case 202325402:
                    if (nextName.equals("processName")) {
                        c5 = 5;
                        break;
                    }
                    break;
                case 722137681:
                    if (nextName.equals("reasonCode")) {
                        c5 = 6;
                        break;
                    }
                    break;
                case 723857505:
                    if (nextName.equals("traceFile")) {
                        c5 = 7;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c5 = 8;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    a5.b(n(jsonReader, new a()));
                    break;
                case 1:
                    a5.d(jsonReader.nextInt());
                    break;
                case 2:
                    a5.f(jsonReader.nextLong());
                    break;
                case 3:
                    a5.h(jsonReader.nextLong());
                    break;
                case 4:
                    a5.i(jsonReader.nextLong());
                    break;
                case 5:
                    a5.e(jsonReader.nextString());
                    break;
                case 6:
                    a5.g(jsonReader.nextInt());
                    break;
                case 7:
                    a5.j(jsonReader.nextString());
                    break;
                case 8:
                    a5.c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a5.a();
    }

    private static List n(JsonReader jsonReader, a aVar) {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(aVar.a(jsonReader));
        }
        jsonReader.endArray();
        return DesugarCollections.unmodifiableList(arrayList);
    }

    /* access modifiers changed from: private */
    public static F.a.C0021a o(JsonReader jsonReader) {
        F.a.C0021a.C0022a a5 = F.a.C0021a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -609862170:
                    if (nextName.equals("libraryName")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case 3002454:
                    if (nextName.equals("arch")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 230943785:
                    if (nextName.equals("buildId")) {
                        c5 = 2;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    a5.d(jsonReader.nextString());
                    break;
                case 1:
                    a5.b(jsonReader.nextString());
                    break;
                case 2:
                    a5.c(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a5.a();
    }

    /* access modifiers changed from: private */
    public static F.c p(JsonReader jsonReader) {
        F.c.a a5 = F.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            if (nextName.equals("key")) {
                a5.b(jsonReader.nextString());
            } else if (!nextName.equals("value")) {
                jsonReader.skipValue();
            } else {
                a5.c(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return a5.a();
    }

    private static F.e.c q(JsonReader jsonReader) {
        F.e.c.a a5 = F.e.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -1981332476:
                    if (nextName.equals("simulator")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -1969347631:
                    if (nextName.equals("manufacturer")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 112670:
                    if (nextName.equals("ram")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 3002454:
                    if (nextName.equals("arch")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 81784169:
                    if (nextName.equals("diskSpace")) {
                        c5 = 4;
                        break;
                    }
                    break;
                case 94848180:
                    if (nextName.equals("cores")) {
                        c5 = 5;
                        break;
                    }
                    break;
                case 104069929:
                    if (nextName.equals("model")) {
                        c5 = 6;
                        break;
                    }
                    break;
                case 109757585:
                    if (nextName.equals(MRAIDCommunicatorUtil.KEY_STATE)) {
                        c5 = 7;
                        break;
                    }
                    break;
                case 2078953423:
                    if (nextName.equals("modelClass")) {
                        c5 = 8;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    a5.i(jsonReader.nextBoolean());
                    break;
                case 1:
                    a5.e(jsonReader.nextString());
                    break;
                case 2:
                    a5.h(jsonReader.nextLong());
                    break;
                case 3:
                    a5.b(jsonReader.nextInt());
                    break;
                case 4:
                    a5.d(jsonReader.nextLong());
                    break;
                case 5:
                    a5.c(jsonReader.nextInt());
                    break;
                case 6:
                    a5.f(jsonReader.nextString());
                    break;
                case 7:
                    a5.j(jsonReader.nextInt());
                    break;
                case 8:
                    a5.g(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a5.a();
    }

    /* access modifiers changed from: private */
    public static F.e.d r(JsonReader jsonReader) {
        F.e.d.b a5 = F.e.d.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -1335157162:
                    if (nextName.equals("device")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -259312414:
                    if (nextName.equals("rollouts")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 96801:
                    if (nextName.equals(MBridgeConstans.DYNAMIC_VIEW_WX_APP)) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 107332:
                    if (nextName.equals("log")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 3575610:
                    if (nextName.equals(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)) {
                        c5 = 4;
                        break;
                    }
                    break;
                case 55126294:
                    if (nextName.equals(CampaignEx.JSON_KEY_TIMESTAMP)) {
                        c5 = 5;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    a5.c(u(jsonReader));
                    break;
                case 1:
                    a5.e(A(jsonReader));
                    break;
                case 2:
                    a5.b(s(jsonReader));
                    break;
                case 3:
                    a5.d(y(jsonReader));
                    break;
                case 4:
                    a5.g(jsonReader.nextString());
                    break;
                case 5:
                    a5.f(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a5.a();
    }

    private static F.e.d.a s(JsonReader jsonReader) {
        F.e.d.a.C0024a a5 = F.e.d.a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -1405314732:
                    if (nextName.equals("appProcessDetails")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -1332194002:
                    if (nextName.equals("background")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case -1090974952:
                    if (nextName.equals("execution")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case -80231855:
                    if (nextName.equals("internalKeys")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 555169704:
                    if (nextName.equals("customAttributes")) {
                        c5 = 4;
                        break;
                    }
                    break;
                case 928737948:
                    if (nextName.equals("uiOrientation")) {
                        c5 = 5;
                        break;
                    }
                    break;
                case 1847730860:
                    if (nextName.equals("currentProcessDetails")) {
                        c5 = 6;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    a5.b(n(jsonReader, new c()));
                    break;
                case 1:
                    a5.c(Boolean.valueOf(jsonReader.nextBoolean()));
                    break;
                case 2:
                    a5.f(v(jsonReader));
                    break;
                case 3:
                    a5.g(n(jsonReader, new b()));
                    break;
                case 4:
                    a5.e(n(jsonReader, new b()));
                    break;
                case 5:
                    a5.h(jsonReader.nextInt());
                    break;
                case 6:
                    a5.d(G(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a5.a();
    }

    /* access modifiers changed from: private */
    public static F.e.d.a.b.C0025a t(JsonReader jsonReader) {
        F.e.d.a.b.C0025a.C0026a a5 = F.e.d.a.b.C0025a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case 3373707:
                    if (nextName.equals(RewardPlus.NAME)) {
                        c5 = 0;
                        break;
                    }
                    break;
                case 3530753:
                    if (nextName.equals("size")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 3601339:
                    if (nextName.equals("uuid")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 1153765347:
                    if (nextName.equals("baseAddress")) {
                        c5 = 3;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    a5.c(jsonReader.nextString());
                    break;
                case 1:
                    a5.d(jsonReader.nextLong());
                    break;
                case 2:
                    a5.f(Base64.decode(jsonReader.nextString(), 2));
                    break;
                case 3:
                    a5.b(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a5.a();
    }

    private static F.e.d.c u(JsonReader jsonReader) {
        F.e.d.c.a a5 = F.e.d.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -1708606089:
                    if (nextName.equals("batteryLevel")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -1455558134:
                    if (nextName.equals("batteryVelocity")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case -1439500848:
                    if (nextName.equals("orientation")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 279795450:
                    if (nextName.equals("diskUsed")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 976541947:
                    if (nextName.equals("ramUsed")) {
                        c5 = 4;
                        break;
                    }
                    break;
                case 1516795582:
                    if (nextName.equals("proximityOn")) {
                        c5 = 5;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    a5.b(Double.valueOf(jsonReader.nextDouble()));
                    break;
                case 1:
                    a5.c(jsonReader.nextInt());
                    break;
                case 2:
                    a5.e(jsonReader.nextInt());
                    break;
                case 3:
                    a5.d(jsonReader.nextLong());
                    break;
                case 4:
                    a5.g(jsonReader.nextLong());
                    break;
                case 5:
                    a5.f(jsonReader.nextBoolean());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a5.a();
    }

    private static F.e.d.a.b v(JsonReader jsonReader) {
        F.e.d.a.b.C0027b a5 = F.e.d.a.b.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -1375141843:
                    if (nextName.equals("appExitInfo")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -1337936983:
                    if (nextName.equals("threads")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case -902467928:
                    if (nextName.equals("signal")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 937615455:
                    if (nextName.equals("binaries")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 1481625679:
                    if (nextName.equals("exception")) {
                        c5 = 4;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    a5.b(m(jsonReader));
                    break;
                case 1:
                    a5.f(n(jsonReader, new g()));
                    break;
                case 2:
                    a5.e(B(jsonReader));
                    break;
                case 3:
                    a5.c(n(jsonReader, new h()));
                    break;
                case 4:
                    a5.d(w(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a5.a();
    }

    private static F.e.d.a.b.c w(JsonReader jsonReader) {
        F.e.d.a.b.c.C0028a a5 = F.e.d.a.b.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -1266514778:
                    if (nextName.equals(b.JSON_KEY_FRAME_ADS)) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -934964668:
                    if (nextName.equals("reason")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 3575610:
                    if (nextName.equals(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 91997906:
                    if (nextName.equals("causedBy")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 581754413:
                    if (nextName.equals("overflowCount")) {
                        c5 = 4;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    a5.c(n(jsonReader, new i()));
                    break;
                case 1:
                    a5.e(jsonReader.nextString());
                    break;
                case 2:
                    a5.f(jsonReader.nextString());
                    break;
                case 3:
                    a5.b(w(jsonReader));
                    break;
                case 4:
                    a5.d(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a5.a();
    }

    /* access modifiers changed from: private */
    public static F.e.d.a.b.C0031e.C0033b x(JsonReader jsonReader) {
        F.e.d.a.b.C0031e.C0033b.C0034a a5 = F.e.d.a.b.C0031e.C0033b.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -1019779949:
                    if (nextName.equals(TypedValues.CycleType.S_WAVE_OFFSET)) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -887523944:
                    if (nextName.equals("symbol")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 3571:
                    if (nextName.equals("pc")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 3143036:
                    if (nextName.equals("file")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c5 = 4;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    a5.d(jsonReader.nextLong());
                    break;
                case 1:
                    a5.f(jsonReader.nextString());
                    break;
                case 2:
                    a5.e(jsonReader.nextLong());
                    break;
                case 3:
                    a5.b(jsonReader.nextString());
                    break;
                case 4:
                    a5.c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a5.a();
    }

    private static F.e.d.C0036d y(JsonReader jsonReader) {
        F.e.d.C0036d.a a5 = F.e.d.C0036d.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if (jsonReader.nextName().equals("content")) {
                a5.b(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return a5.a();
    }

    /* access modifiers changed from: private */
    public static F.e.d.C0037e z(JsonReader jsonReader) {
        F.e.d.C0037e.a a5 = F.e.d.C0037e.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -1536268810:
                    if (nextName.equals("parameterKey")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -1027290370:
                    if (nextName.equals("templateVersion")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 1098747284:
                    if (nextName.equals("rolloutVariant")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 1124454216:
                    if (nextName.equals("parameterValue")) {
                        c5 = 3;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    a5.b(jsonReader.nextString());
                    break;
                case 1:
                    a5.e(jsonReader.nextLong());
                    break;
                case 2:
                    a5.d(I(jsonReader));
                    break;
                case 3:
                    a5.c(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a5.a();
    }

    public F L(String str) {
        JsonReader jsonReader;
        try {
            jsonReader = new JsonReader(new StringReader(str));
            F H4 = H(jsonReader);
            jsonReader.close();
            return H4;
        } catch (IllegalStateException e5) {
            throw new IOException(e5);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public String M(F f5) {
        return f2292a.b(f5);
    }

    public F.e.d j(String str) {
        JsonReader jsonReader;
        try {
            jsonReader = new JsonReader(new StringReader(str));
            F.e.d r5 = r(jsonReader);
            jsonReader.close();
            return r5;
        } catch (IllegalStateException e5) {
            throw new IOException(e5);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public String k(F.e.d dVar) {
        return f2292a.b(dVar);
    }
}
