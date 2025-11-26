package com.mbridge.msdk.tracker.network;

import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;

public final class e implements z {

    /* renamed from: a  reason: collision with root package name */
    private int f11581a;

    /* renamed from: b  reason: collision with root package name */
    private long f11582b;

    /* renamed from: c  reason: collision with root package name */
    private int f11583c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11584d;

    public e() {
        this(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, 1);
    }

    public final int a() {
        return this.f11581a;
    }

    public final long b() {
        return this.f11582b;
    }

    public final int c() {
        return this.f11583c;
    }

    public e(int i5, int i6) {
        this(i5, ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS, i6);
    }

    public final boolean a(ad adVar) {
        int i5 = this.f11583c + 1;
        this.f11583c = i5;
        if (i5 <= this.f11584d) {
            return true;
        }
        return false;
    }

    public e(int i5, long j5, int i6) {
        this.f11582b = j5;
        this.f11581a = i5;
        this.f11584d = i6;
    }
}
