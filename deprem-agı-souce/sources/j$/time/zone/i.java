package j$.time.zone;

import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

public final class i {

    /* renamed from: b  reason: collision with root package name */
    public static final CopyOnWriteArrayList f1250b;

    /* renamed from: c  reason: collision with root package name */
    public static final ConcurrentHashMap f1251c = new ConcurrentHashMap(512, 0.75f, 2);

    /* renamed from: a  reason: collision with root package name */
    public final Set f1252a;

    static {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        f1250b = copyOnWriteArrayList;
        ArrayList arrayList = new ArrayList();
        AccessController.doPrivileged(new h(arrayList));
        copyOnWriteArrayList.addAll(arrayList);
    }

    public static f a(String str) {
        Objects.requireNonNull(str, "zoneId");
        ConcurrentHashMap concurrentHashMap = f1251c;
        i iVar = (i) concurrentHashMap.get(str);
        if (iVar == null) {
            if (concurrentHashMap.isEmpty()) {
                throw new RuntimeException("No time-zone data files registered");
            }
            throw new RuntimeException("Unknown time-zone ID: " + str);
        } else if (iVar.f1252a.contains(str)) {
            return new f(TimeZone.getTimeZone(str));
        } else {
            throw new RuntimeException("Not a built-in time zone: " + str);
        }
    }

    public static void b(i iVar) {
        Objects.requireNonNull(iVar, "provider");
        synchronized (i.class) {
            try {
                for (String str : iVar.f1252a) {
                    Objects.requireNonNull(str, "zoneId");
                    if (((i) f1251c.putIfAbsent(str, iVar)) != null) {
                        throw new RuntimeException("Unable to register zone as one already registered with that ID: " + str + ", currently loading from provider: " + iVar);
                    }
                }
                Collections.unmodifiableSet(new HashSet(f1251c.keySet()));
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        f1250b.add(iVar);
    }

    public i() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String add : TimeZone.getAvailableIDs()) {
            linkedHashSet.add(add);
        }
        this.f1252a = Collections.unmodifiableSet(linkedHashSet);
    }
}
