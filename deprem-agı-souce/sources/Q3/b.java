package Q3;

import X2.C2250q;
import android.text.Editable;
import android.text.Html;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import kotlin.jvm.internal.t;
import org.xml.sax.XMLReader;

public final class b implements Html.TagHandler {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f18943a = new ArrayList();

    public final void handleTag(boolean z4, String str, Editable editable, XMLReader xMLReader) {
        c cVar;
        t.e(editable, "output");
        int i5 = 0;
        if (t.a("customUl", str) && z4) {
            this.f18943a.add(0, new e());
        } else if (t.a("customOl", str) && z4) {
            this.f18943a.add(0, new d());
        } else if ((t.a("customUl", str) || t.a("customOl", str)) && !z4) {
            this.f18943a.remove(0);
        } else if (t.a("customLi", str) && z4) {
            ((c) C2250q.M(this.f18943a)).a(editable);
        } else if (t.a("customLi", str) && !z4) {
            c cVar2 = (c) C2250q.M(this.f18943a);
            int size = this.f18943a.size();
            cVar2.getClass();
            t.e(editable, MimeTypes.BASE_TYPE_TEXT);
            if (editable.length() > 0 && editable.charAt(editable.length() - 1) != 10) {
                editable.append("\n");
            }
            c[] cVarArr = (c[]) editable.getSpans(0, editable.length(), c.class);
            t.d(cVarArr, "listTags");
            if (cVarArr.length == 0) {
                cVar = null;
            } else {
                cVar = cVarArr[cVarArr.length - 1];
            }
            int spanStart = editable.getSpanStart(cVar);
            editable.removeSpan(cVar);
            if (spanStart != editable.length()) {
                Object[] b5 = cVar2.b(size);
                int length = b5.length;
                while (i5 < length) {
                    Object obj = b5[i5];
                    i5++;
                    editable.setSpan(obj, spanStart, editable.length(), 33);
                }
            }
        }
    }
}
