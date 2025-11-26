package androidx.datastore.core;

import b3.C2312i;
import k3.p;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class UpdatingDataContextElement implements C2312i.b {
    public static final Companion Companion = new Companion((C2633k) null);
    /* access modifiers changed from: private */
    public static final String NESTED_UPDATE_ERROR_MESSAGE = "Calling updateData inside updateData on the same DataStore instance is not supported\nsince updates made in the parent updateData call will not be visible to the nested\nupdateData call. See https://issuetracker.google.com/issues/241760537 for details.";
    private final DataStoreImpl<?> instance;
    private final UpdatingDataContextElement parent;

    public static final class Companion {

        public static final class Key implements C2312i.c {
            public static final Key INSTANCE = new Key();

            private Key() {
            }
        }

        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final String getNESTED_UPDATE_ERROR_MESSAGE$datastore_core_release() {
            return UpdatingDataContextElement.NESTED_UPDATE_ERROR_MESSAGE;
        }

        private Companion() {
        }
    }

    public UpdatingDataContextElement(UpdatingDataContextElement updatingDataContextElement, DataStoreImpl<?> dataStoreImpl) {
        t.e(dataStoreImpl, "instance");
        this.parent = updatingDataContextElement;
        this.instance = dataStoreImpl;
    }

    public final void checkNotUpdating(DataStore<?> dataStore) {
        t.e(dataStore, "candidate");
        if (this.instance != dataStore) {
            UpdatingDataContextElement updatingDataContextElement = this.parent;
            if (updatingDataContextElement != null) {
                updatingDataContextElement.checkNotUpdating(dataStore);
                return;
            }
            return;
        }
        throw new IllegalStateException(NESTED_UPDATE_ERROR_MESSAGE.toString());
    }

    public <R> R fold(R r5, p pVar) {
        return C2312i.b.a.a(this, r5, pVar);
    }

    public <E extends C2312i.b> E get(C2312i.c cVar) {
        return C2312i.b.a.b(this, cVar);
    }

    public C2312i.c getKey() {
        return Companion.Key.INSTANCE;
    }

    public C2312i minusKey(C2312i.c cVar) {
        return C2312i.b.a.c(this, cVar);
    }

    public C2312i plus(C2312i iVar) {
        return C2312i.b.a.d(this, iVar);
    }
}
