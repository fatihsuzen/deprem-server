package com.google.firebase.sessions;

import S0.e;
import X2.C2250q;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.datastore.DataStoreFile;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.MultiProcessDataStoreFactory;
import androidx.datastore.core.Serializer;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import b1.C1017b;
import b1.C1028m;
import b1.C1031p;
import b1.C1032q;
import b1.C1033s;
import b1.H;
import b1.I;
import b1.W;
import b1.a0;
import b1.b0;
import b1.c0;
import b1.d0;
import b1.r;
import b3.C2312i;
import e1.h;
import e1.i;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.List;
import k3.C2616a;
import kotlin.jvm.internal.t;
import o0.f;
import w3.M;
import w3.N;

public interface b {

    public interface a {
        a a(C2312i iVar);

        a b(e eVar);

        b build();

        a c(C2312i iVar);

        a d(f fVar);

        a e(Context context);

        a f(R0.b bVar);
    }

    /* renamed from: com.google.firebase.sessions.b$b  reason: collision with other inner class name */
    public interface C0073b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f7517a = a.f7518a;

        /* renamed from: com.google.firebase.sessions.b$b$a */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ a f7518a = new a();

            private a() {
            }

            private final DataStore f(Serializer serializer, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, M m5, C2616a aVar) {
                if (h()) {
                    return MultiProcessDataStoreFactory.INSTANCE.create(serializer, replaceFileCorruptionHandler, list, m5, aVar);
                }
                return DataStoreFactory.INSTANCE.create(serializer, replaceFileCorruptionHandler, list, m5, aVar);
            }

            static /* synthetic */ DataStore g(a aVar, Serializer serializer, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, M m5, C2616a aVar2, int i5, Object obj) {
                if ((i5 & 4) != 0) {
                    list = C2250q.g();
                }
                return aVar.f(serializer, replaceFileCorruptionHandler, list, m5, aVar2);
            }

            private final boolean h() {
                try {
                    System.loadLibrary("datastore_shared_counter");
                    return true;
                } catch (SecurityException | UnsatisfiedLinkError unused) {
                    return false;
                }
            }

            private final void i(File file) {
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    if (parentFile.exists() && !parentFile.isDirectory() && t.a(parentFile.getName(), "firebaseSessions") && !parentFile.delete()) {
                        throw new IOException("Failed to delete conflicting file: " + parentFile);
                    } else if (!parentFile.isDirectory()) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            try {
                                Path unused = Files.createDirectories(parentFile.toPath(), new FileAttribute[0]);
                            } catch (Exception e5) {
                                throw new IOException("Failed to create directory: " + parentFile, e5);
                            }
                        } else if (!parentFile.mkdirs() && !parentFile.isDirectory()) {
                            throw new IOException("Failed to create directory: " + parentFile);
                        }
                    }
                }
            }

            /* access modifiers changed from: private */
            public static final h k(CorruptionException corruptionException) {
                t.e(corruptionException, "ex");
                Log.w("FirebaseSessions", "CorruptionException in session configs DataStore", corruptionException);
                return i.f15272a.a();
            }

            /* access modifiers changed from: private */
            public static final File l(Context context) {
                File dataStoreFile = DataStoreFile.dataStoreFile(context, "firebaseSessions/sessionConfigsDataStore.data");
                f7518a.i(dataStoreFile);
                return dataStoreFile;
            }

            /* access modifiers changed from: private */
            public static final H n(I i5, CorruptionException corruptionException) {
                t.e(corruptionException, "ex");
                Log.w("FirebaseSessions", "CorruptionException in session data DataStore", corruptionException);
                return i5.getDefaultValue();
            }

            /* access modifiers changed from: private */
            public static final File o(Context context) {
                File dataStoreFile = DataStoreFile.dataStoreFile(context, "firebaseSessions/sessionDataStore.data");
                f7518a.i(dataStoreFile);
                return dataStoreFile;
            }

            public final C1017b e(f fVar) {
                t.e(fVar, "firebaseApp");
                return b1.M.f4547a.b(fVar);
            }

            public final DataStore j(Context context, C2312i iVar) {
                t.e(context, "appContext");
                t.e(iVar, "blockingDispatcher");
                return g(this, i.f15272a, new ReplaceFileCorruptionHandler(new C1031p()), (List) null, N.a(iVar), new C1032q(context), 4, (Object) null);
            }

            public final DataStore m(Context context, C2312i iVar, I i5) {
                t.e(context, "appContext");
                t.e(iVar, "blockingDispatcher");
                t.e(i5, "sessionDataSerializer");
                return g(this, i5, new ReplaceFileCorruptionHandler(new r(i5)), (List) null, N.a(iVar), new C1033s(context), 4, (Object) null);
            }

            public final a0 p() {
                return b0.f4652a;
            }

            public final c0 q() {
                return d0.f4698a;
            }
        }
    }

    C1028m a();

    W b();
}
