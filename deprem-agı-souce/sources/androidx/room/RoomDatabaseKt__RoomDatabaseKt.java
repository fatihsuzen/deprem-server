package androidx.room;

import androidx.room.migration.Migration;
import b3.C2308e;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import k3.p;
import kotlin.jvm.internal.t;
import r3.C2733c;
import w3.C2872g;

final /* synthetic */ class RoomDatabaseKt__RoomDatabaseKt {
    public static final <R> Object useReaderConnection(RoomDatabase roomDatabase, p pVar, C2308e eVar) {
        return C2872g.g(roomDatabase.getCoroutineScope().getCoroutineContext(), new RoomDatabaseKt__RoomDatabaseKt$useReaderConnection$2(roomDatabase, pVar, (C2308e) null), eVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <R> java.lang.Object useWriterConnection(androidx.room.RoomDatabase r5, k3.p r6, b3.C2308e r7) {
        /*
            boolean r0 = r7 instanceof androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1 r0 = (androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1 r0 = new androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.L$0
            androidx.room.RoomDatabase r5 = (androidx.room.RoomDatabase) r5
            W2.u.b(r7)
            goto L_0x0051
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            W2.u.b(r7)
            w3.M r7 = r5.getCoroutineScope()
            b3.i r7 = r7.getCoroutineContext()
            androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$2 r2 = new androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r7 = w3.C2872g.g(r7, r2, r0)
            if (r7 != r1) goto L_0x0051
            return r1
        L_0x0051:
            androidx.room.InvalidationTracker r5 = r5.getInvalidationTracker()
            r5.refreshAsync()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabaseKt__RoomDatabaseKt.useWriterConnection(androidx.room.RoomDatabase, k3.p, b3.e):java.lang.Object");
    }

    public static final void validateAutoMigrations(RoomDatabase roomDatabase, DatabaseConfiguration databaseConfiguration) {
        t.e(roomDatabase, "<this>");
        t.e(databaseConfiguration, "configuration");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Set<C2733c> requiredAutoMigrationSpecClasses = roomDatabase.getRequiredAutoMigrationSpecClasses();
        int size = requiredAutoMigrationSpecClasses.size();
        boolean[] zArr = new boolean[size];
        Iterator<C2733c> it = requiredAutoMigrationSpecClasses.iterator();
        while (true) {
            int i5 = -1;
            if (it.hasNext()) {
                C2733c next = it.next();
                int size2 = databaseConfiguration.autoMigrationSpecs.size() - 1;
                if (size2 >= 0) {
                    while (true) {
                        int i6 = size2 - 1;
                        if (next.f(databaseConfiguration.autoMigrationSpecs.get(size2))) {
                            zArr[size2] = true;
                            i5 = size2;
                            break;
                        } else if (i6 < 0) {
                            break;
                        } else {
                            size2 = i6;
                        }
                    }
                }
                if (i5 >= 0) {
                    linkedHashMap.put(next, databaseConfiguration.autoMigrationSpecs.get(i5));
                } else {
                    throw new IllegalArgumentException(("A required auto migration spec (" + next.a() + ") is missing in the database configuration.").toString());
                }
            } else {
                int size3 = databaseConfiguration.autoMigrationSpecs.size() - 1;
                if (size3 >= 0) {
                    while (true) {
                        int i7 = size3 - 1;
                        if (size3 < size && zArr[size3]) {
                            if (i7 < 0) {
                                break;
                            }
                            size3 = i7;
                        }
                    }
                    throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
                }
                for (Migration next2 : roomDatabase.createAutoMigrations(linkedHashMap)) {
                    if (!databaseConfiguration.migrationContainer.contains(next2.startVersion, next2.endVersion)) {
                        databaseConfiguration.migrationContainer.addMigration(next2);
                    }
                }
                return;
            }
        }
    }

    public static final void validateMigrationsNotRequired(Set<Integer> set, Set<Integer> set2) {
        t.e(set, "migrationStartAndEndVersions");
        t.e(set2, "migrationsNotRequiredFrom");
        if (!set.isEmpty()) {
            for (Integer intValue : set) {
                int intValue2 = intValue.intValue();
                if (set2.contains(Integer.valueOf(intValue2))) {
                    throw new IllegalArgumentException(("Inconsistency detected. A Migration was supplied to addMigration() that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(). Start version is: " + intValue2).toString());
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x006a A[LOOP:1: B:4:0x0039->B:15:0x006a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0074 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void validateTypeConverters(androidx.room.RoomDatabase r9, androidx.room.DatabaseConfiguration r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.t.e(r9, r0)
            java.lang.String r0 = "configuration"
            kotlin.jvm.internal.t.e(r10, r0)
            java.util.Map r0 = r9.getRequiredTypeConverterClassesMap$room_runtime_release()
            int r1 = r0.size()
            boolean[] r1 = new boolean[r1]
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x001c:
            boolean r2 = r0.hasNext()
            r3 = -1
            if (r2 == 0) goto L_0x00a4
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r4 = r2.getKey()
            r3.c r4 = (r3.C2733c) r4
            java.lang.Object r2 = r2.getValue()
            java.util.List r2 = (java.util.List) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x0039:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x001c
            java.lang.Object r5 = r2.next()
            r3.c r5 = (r3.C2733c) r5
            java.util.List<java.lang.Object> r6 = r10.typeConverters
            java.util.Collection r6 = (java.util.Collection) r6
            int r6 = r6.size()
            int r6 = r6 + r3
            if (r6 < 0) goto L_0x0067
        L_0x0050:
            int r7 = r6 + -1
            java.util.List<java.lang.Object> r8 = r10.typeConverters
            java.lang.Object r8 = r8.get(r6)
            boolean r8 = r5.f(r8)
            if (r8 == 0) goto L_0x0062
            r7 = 1
            r1[r6] = r7
            goto L_0x0068
        L_0x0062:
            if (r7 >= 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r6 = r7
            goto L_0x0050
        L_0x0067:
            r6 = r3
        L_0x0068:
            if (r6 < 0) goto L_0x0074
            java.util.List<java.lang.Object> r7 = r10.typeConverters
            java.lang.Object r6 = r7.get(r6)
            r9.addTypeConverter$room_runtime_release(r5, r6)
            goto L_0x0039
        L_0x0074:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "A required type converter ("
            r9.append(r10)
            java.lang.String r10 = r5.a()
            r9.append(r10)
            java.lang.String r10 = ") for "
            r9.append(r10)
            java.lang.String r10 = r4.a()
            r9.append(r10)
            java.lang.String r10 = " is missing in the database configuration."
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        L_0x00a4:
            java.util.List<java.lang.Object> r9 = r10.typeConverters
            java.util.Collection r9 = (java.util.Collection) r9
            int r9 = r9.size()
            int r9 = r9 + r3
            if (r9 < 0) goto L_0x00dc
        L_0x00af:
            int r0 = r9 + -1
            boolean r2 = r1[r9]
            if (r2 == 0) goto L_0x00ba
            if (r0 >= 0) goto L_0x00b8
            goto L_0x00dc
        L_0x00b8:
            r9 = r0
            goto L_0x00af
        L_0x00ba:
            java.util.List<java.lang.Object> r10 = r10.typeConverters
            java.lang.Object r9 = r10.get(r9)
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unexpected type converter "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder."
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r10.<init>(r9)
            throw r10
        L_0x00dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabaseKt__RoomDatabaseKt.validateTypeConverters(androidx.room.RoomDatabase, androidx.room.DatabaseConfiguration):void");
    }
}
