package androidx.datastore.core;

import b3.C2308e;
import k3.l;
import k3.p;
import z3.C2972e;

public interface InterProcessCoordinator {
    C2972e getUpdateNotifications();

    Object getVersion(C2308e eVar);

    Object incrementAndGetVersion(C2308e eVar);

    <T> Object lock(l lVar, C2308e eVar);

    <T> Object tryLock(p pVar, C2308e eVar);
}
