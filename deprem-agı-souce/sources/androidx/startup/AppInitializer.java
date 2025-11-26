package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.tracing.Trace;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class AppInitializer {
    private static final String SECTION_NAME = "Startup";
    private static volatile AppInitializer sInstance;
    private static final Object sLock = new Object();
    @NonNull
    final Context mContext;
    @NonNull
    final Set<Class<? extends Initializer<?>>> mDiscovered = new HashSet();
    @NonNull
    final Map<Class<?>, Object> mInitialized = new HashMap();

    AppInitializer(@NonNull Context context) {
        this.mContext = context.getApplicationContext();
    }

    @NonNull
    public static AppInitializer getInstance(@NonNull Context context) {
        if (sInstance == null) {
            synchronized (sLock) {
                try {
                    if (sInstance == null) {
                        sInstance = new AppInitializer(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sInstance;
    }

    static void setDelegate(@NonNull AppInitializer appInitializer) {
        synchronized (sLock) {
            sInstance = appInitializer;
        }
    }

    /* access modifiers changed from: package-private */
    public void discoverAndInitialize() {
        try {
            Trace.beginSection(SECTION_NAME);
            discoverAndInitialize(this.mContext.getPackageManager().getProviderInfo(new ComponentName(this.mContext.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            Trace.endSection();
        } catch (PackageManager.NameNotFoundException e5) {
            throw new StartupException((Throwable) e5);
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public <T> T doInitialize(@NonNull Class<? extends Initializer<?>> cls) {
        T t5;
        synchronized (sLock) {
            try {
                t5 = this.mInitialized.get(cls);
                if (t5 == null) {
                    t5 = doInitialize(cls, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t5;
    }

    @NonNull
    public <T> T initializeComponent(@NonNull Class<? extends Initializer<T>> cls) {
        return doInitialize(cls);
    }

    public boolean isEagerlyInitialized(@NonNull Class<? extends Initializer<?>> cls) {
        return this.mDiscovered.contains(cls);
    }

    @NonNull
    private <T> T doInitialize(@NonNull Class<? extends Initializer<?>> cls, @NonNull Set<Class<?>> set) {
        T t5;
        if (Trace.isEnabled()) {
            try {
                Trace.beginSection(cls.getSimpleName());
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        if (!set.contains(cls)) {
            if (!this.mInitialized.containsKey(cls)) {
                set.add(cls);
                Initializer initializer = (Initializer) cls.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
                List<Class<? extends Initializer<?>>> dependencies = initializer.dependencies();
                if (!dependencies.isEmpty()) {
                    for (Class next : dependencies) {
                        if (!this.mInitialized.containsKey(next)) {
                            doInitialize(next, set);
                        }
                    }
                }
                t5 = initializer.create(this.mContext);
                set.remove(cls);
                this.mInitialized.put(cls, t5);
            } else {
                t5 = this.mInitialized.get(cls);
            }
            Trace.endSection();
            return t5;
        }
        throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", new Object[]{cls.getName()}));
    }

    /* access modifiers changed from: package-private */
    public void discoverAndInitialize(@Nullable Bundle bundle) {
        String string = this.mContext.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String next : bundle.keySet()) {
                    if (string.equals(bundle.getString(next, (String) null))) {
                        Class<?> cls = Class.forName(next);
                        if (Initializer.class.isAssignableFrom(cls)) {
                            this.mDiscovered.add(cls);
                        }
                    }
                }
                for (Class<? extends Initializer<?>> doInitialize : this.mDiscovered) {
                    doInitialize(doInitialize, hashSet);
                }
            } catch (ClassNotFoundException e5) {
                throw new StartupException((Throwable) e5);
            }
        }
    }
}
