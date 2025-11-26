package l2;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2657f;
import org.json.JSONArray;
import org.json.JSONObject;

public final class S {

    /* renamed from: d  reason: collision with root package name */
    public static final a f24852d = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private C2660i f24853a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList f24854b;

    /* renamed from: c  reason: collision with root package name */
    private int f24855c;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final S a(M m5, C2660i iVar) {
            int i5;
            t.e(m5, "res");
            t.e(iVar, "category");
            S s5 = new S((C2660i) null, (ArrayList) null, 0, 7, (C2633k) null);
            s5.e(iVar);
            if (m5.e() != null) {
                JSONObject e5 = m5.e();
                t.b(e5);
                if (!e5.isNull("success")) {
                    i5 = e5.optInt("success");
                } else {
                    i5 = 0;
                }
                JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                if (optJSONObject != null) {
                    if (!optJSONObject.isNull(CampaignEx.JSON_KEY_TITLE)) {
                        s5.b().x(optJSONObject.optString(CampaignEx.JSON_KEY_TITLE));
                    }
                    if (!optJSONObject.isNull("description")) {
                        s5.b().u(optJSONObject.optString("description"));
                    }
                    JSONArray optJSONArray = optJSONObject.optJSONArray("apps");
                    if (optJSONArray != null && i5 == 1 && optJSONArray.length() > 0) {
                        int length = optJSONArray.length();
                        for (int i6 = 0; i6 < length; i6++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i6);
                            t.d(optJSONObject2, "optJSONObject(...)");
                            s5.a().add(C2657f.b.b(C2657f.f25002J0, optJSONObject2, (Context) null, 2, (Object) null));
                        }
                    }
                }
            }
            return s5;
        }

        private a() {
        }
    }

    public S(C2660i iVar, ArrayList arrayList, int i5) {
        t.e(iVar, "category");
        t.e(arrayList, "apps");
        this.f24853a = iVar;
        this.f24854b = arrayList;
        this.f24855c = i5;
    }

    public final ArrayList a() {
        return this.f24854b;
    }

    public final C2660i b() {
        return this.f24853a;
    }

    public final int c() {
        return this.f24855c;
    }

    public final void d(ArrayList arrayList) {
        t.e(arrayList, "<set-?>");
        this.f24854b = arrayList;
    }

    public final void e(C2660i iVar) {
        t.e(iVar, "<set-?>");
        this.f24853a = iVar;
    }

    public final void f(int i5) {
        this.f24855c = i5;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ S(C2660i iVar, ArrayList arrayList, int i5, int i6, C2633k kVar) {
        this((i6 & 1) != 0 ? new C2660i(0, (String) null, (String) null, 7, (C2633k) null) : iVar, (i6 & 2) != 0 ? new ArrayList() : arrayList, (i6 & 4) != 0 ? 0 : i5);
    }
}
