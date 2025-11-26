package k0;

/* renamed from: k0.d  reason: case insensitive filesystem */
public final class C1690d extends IllegalStateException {
    private C1690d(String str, Throwable th) {
        super(str, th);
    }

    public static IllegalStateException a(C1698l lVar) {
        String str;
        if (!lVar.m()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception i5 = lVar.i();
        if (i5 != null) {
            str = "failure";
        } else if (lVar.n()) {
            str = "result ".concat(String.valueOf(lVar.j()));
        } else if (lVar.l()) {
            str = "cancellation";
        } else {
            str = "unknown issue";
        }
        return new C1690d("Complete with: ".concat(str), i5);
    }
}
