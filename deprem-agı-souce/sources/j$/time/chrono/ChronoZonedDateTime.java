package j$.time.chrono;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.C0456b;
import j$.time.j;
import j$.time.temporal.m;

public interface ChronoZonedDateTime<D extends C0456b> extends m, Comparable<ChronoZonedDateTime<?>> {
    l getChronology();

    ZoneOffset getOffset();

    ZoneId getZone();

    ChronoZonedDateTime m(ZoneId zoneId);

    long toEpochSecond();

    Instant toInstant();

    C0456b toLocalDate();

    C0459e toLocalDateTime();

    j toLocalTime();
}
