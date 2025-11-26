package j$.time.chrono;

import j$.time.ZoneOffset;
import j$.time.j;
import j$.time.temporal.m;
import j$.time.temporal.o;

/* renamed from: j$.time.chrono.e  reason: case insensitive filesystem */
public interface C0459e extends m, o, Comparable {
    l getChronology();

    ChronoZonedDateTime i(ZoneOffset zoneOffset);

    int t(C0459e eVar);

    C0456b toLocalDate();

    j toLocalTime();
}
