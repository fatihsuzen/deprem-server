package a4;

import e4.C2358g;
import java.util.List;

public interface l {

    /* renamed from: a  reason: collision with root package name */
    public static final l f20467a = new a();

    boolean a(int i5, C2358g gVar, int i6, boolean z4);

    void b(int i5, b bVar);

    boolean onHeaders(int i5, List list, boolean z4);

    boolean onRequest(int i5, List list);

    class a implements l {
        a() {
        }

        public boolean a(int i5, C2358g gVar, int i6, boolean z4) {
            gVar.skip((long) i6);
            return true;
        }

        public boolean onHeaders(int i5, List list, boolean z4) {
            return true;
        }

        public boolean onRequest(int i5, List list) {
            return true;
        }

        public void b(int i5, b bVar) {
        }
    }
}
