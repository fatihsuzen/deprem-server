package com.google.android.gms.internal.measurement;

import android.support.v4.media.a;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Z4 {
    static R4 a(Class cls) {
        String str;
        Class<Z4> cls2 = Z4.class;
        ClassLoader classLoader = cls2.getClassLoader();
        if (cls.equals(R4.class)) {
            str = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";
        } else if (!cls.getPackage().equals(cls2.getPackage())) {
            throw new IllegalArgumentException(cls.getName());
        } else {
            str = String.format("%s.BlazeGenerated%sLoader", new Object[]{cls.getPackage().getName(), cls.getSimpleName()});
        }
        try {
            a.a(Class.forName(str, true, classLoader).getConstructor((Class[]) null).newInstance((Object[]) null));
            throw null;
        } catch (NoSuchMethodException e5) {
            throw new IllegalStateException(e5);
        } catch (InstantiationException e6) {
            throw new IllegalStateException(e6);
        } catch (IllegalAccessException e7) {
            throw new IllegalStateException(e7);
        } catch (InvocationTargetException e8) {
            throw new IllegalStateException(e8);
        } catch (ClassNotFoundException unused) {
            Iterator<S> it = ServiceLoader.load(cls2, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    a.a(it.next());
                    throw null;
                } catch (ServiceConfigurationError e9) {
                    Logger.getLogger(M4.class.getName()).logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load ".concat(cls.getSimpleName()), e9);
                }
            }
            if (arrayList.size() == 1) {
                return (R4) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (R4) cls.getMethod("combine", new Class[]{Collection.class}).invoke((Object) null, new Object[]{arrayList});
            } catch (NoSuchMethodException e10) {
                throw new IllegalStateException(e10);
            } catch (IllegalAccessException e11) {
                throw new IllegalStateException(e11);
            } catch (InvocationTargetException e12) {
                throw new IllegalStateException(e12);
            }
        }
    }
}
