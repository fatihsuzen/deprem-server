package U3;

import V3.c;
import e4.C2357f;

public abstract class y {

    class a extends y {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19660a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ byte[] f19661b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f19662c;

        a(t tVar, int i5, byte[] bArr, int i6) {
            this.f19660a = i5;
            this.f19661b = bArr;
            this.f19662c = i6;
        }

        public long a() {
            return (long) this.f19660a;
        }

        public t b() {
            return null;
        }

        public void e(C2357f fVar) {
            fVar.write(this.f19661b, this.f19662c, this.f19660a);
        }
    }

    public static y c(t tVar, byte[] bArr) {
        return d(tVar, bArr, 0, bArr.length);
    }

    public static y d(t tVar, byte[] bArr, int i5, int i6) {
        if (bArr != null) {
            c.c((long) bArr.length, (long) i5, (long) i6);
            return new a(tVar, i6, bArr, i5);
        }
        throw new NullPointerException("content == null");
    }

    public abstract long a();

    public abstract t b();

    public abstract void e(C2357f fVar);
}
