package androidx.fragment.app;

import k3.l;
import kotlin.jvm.internal.t;

public final class FragmentManagerKt {
    public static final void commit(FragmentManager fragmentManager, boolean z4, l lVar) {
        t.e(fragmentManager, "$this$commit");
        t.e(lVar, TtmlNode.TAG_BODY);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        t.d(beginTransaction, "beginTransaction()");
        lVar.invoke(beginTransaction);
        if (z4) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void commit$default(FragmentManager fragmentManager, boolean z4, l lVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z4 = false;
        }
        t.e(fragmentManager, "$this$commit");
        t.e(lVar, TtmlNode.TAG_BODY);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        t.d(beginTransaction, "beginTransaction()");
        lVar.invoke(beginTransaction);
        if (z4) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static final void commitNow(FragmentManager fragmentManager, boolean z4, l lVar) {
        t.e(fragmentManager, "$this$commitNow");
        t.e(lVar, TtmlNode.TAG_BODY);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        t.d(beginTransaction, "beginTransaction()");
        lVar.invoke(beginTransaction);
        if (z4) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    public static /* synthetic */ void commitNow$default(FragmentManager fragmentManager, boolean z4, l lVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z4 = false;
        }
        t.e(fragmentManager, "$this$commitNow");
        t.e(lVar, TtmlNode.TAG_BODY);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        t.d(beginTransaction, "beginTransaction()");
        lVar.invoke(beginTransaction);
        if (z4) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    public static final void transaction(FragmentManager fragmentManager, boolean z4, boolean z5, l lVar) {
        t.e(fragmentManager, "$this$transaction");
        t.e(lVar, TtmlNode.TAG_BODY);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        t.d(beginTransaction, "beginTransaction()");
        lVar.invoke(beginTransaction);
        if (z4) {
            if (z5) {
                beginTransaction.commitNowAllowingStateLoss();
            } else {
                beginTransaction.commitNow();
            }
        } else if (z5) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void transaction$default(FragmentManager fragmentManager, boolean z4, boolean z5, l lVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z4 = false;
        }
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        t.e(fragmentManager, "$this$transaction");
        t.e(lVar, TtmlNode.TAG_BODY);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        t.d(beginTransaction, "beginTransaction()");
        lVar.invoke(beginTransaction);
        if (z4) {
            if (z5) {
                beginTransaction.commitNowAllowingStateLoss();
            } else {
                beginTransaction.commitNow();
            }
        } else if (z5) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }
}
