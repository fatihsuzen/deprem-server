package com.mbridge.msdk.playercommon.exoplayer2.util;

public final class LibraryLoader {
    private boolean isAvailable;
    private boolean loadAttempted;
    private String[] nativeLibraries;

    public LibraryLoader(String... strArr) {
        this.nativeLibraries = strArr;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:8|9|10|11|12|(1:14)|27|15|16|17|18|19) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x001e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean isAvailable() {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.loadAttempted     // Catch:{ all -> 0x0009 }
            if (r0 == 0) goto L_0x000b
            boolean r0 = r5.isAvailable     // Catch:{ all -> 0x0009 }
            monitor-exit(r5)
            return r0
        L_0x0009:
            r0 = move-exception
            goto L_0x0022
        L_0x000b:
            r0 = 1
            r5.loadAttempted = r0     // Catch:{ all -> 0x0009 }
            java.lang.String[] r1 = r5.nativeLibraries     // Catch:{ UnsatisfiedLinkError -> 0x001e }
            int r2 = r1.length     // Catch:{ UnsatisfiedLinkError -> 0x001e }
            r3 = 0
        L_0x0012:
            if (r3 >= r2) goto L_0x001c
            r4 = r1[r3]     // Catch:{ UnsatisfiedLinkError -> 0x001e }
            java.lang.System.loadLibrary(r4)     // Catch:{ UnsatisfiedLinkError -> 0x001e }
            int r3 = r3 + 1
            goto L_0x0012
        L_0x001c:
            r5.isAvailable = r0     // Catch:{ UnsatisfiedLinkError -> 0x001e }
        L_0x001e:
            boolean r0 = r5.isAvailable     // Catch:{ all -> 0x0009 }
            monitor-exit(r5)
            return r0
        L_0x0022:
            monitor-exit(r5)     // Catch:{ all -> 0x0009 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.util.LibraryLoader.isAvailable():boolean");
    }

    public final synchronized void setLibraries(String... strArr) {
        Assertions.checkState(!this.loadAttempted, "Cannot set libraries after loading");
        this.nativeLibraries = strArr;
    }
}
