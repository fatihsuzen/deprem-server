package com.google.firebase.installations;

import com.google.firebase.installations.g;

final class a extends g {

    /* renamed from: a  reason: collision with root package name */
    private final String f7227a;

    /* renamed from: b  reason: collision with root package name */
    private final long f7228b;

    /* renamed from: c  reason: collision with root package name */
    private final long f7229c;

    static final class b extends g.a {

        /* renamed from: a  reason: collision with root package name */
        private String f7230a;

        /* renamed from: b  reason: collision with root package name */
        private Long f7231b;

        /* renamed from: c  reason: collision with root package name */
        private Long f7232c;

        b() {
        }

        public g a() {
            String str = "";
            if (this.f7230a == null) {
                str = str + " token";
            }
            if (this.f7231b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (this.f7232c == null) {
                str = str + " tokenCreationTimestamp";
            }
            if (str.isEmpty()) {
                return new a(this.f7230a, this.f7231b.longValue(), this.f7232c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public g.a b(String str) {
            if (str != null) {
                this.f7230a = str;
                return this;
            }
            throw new NullPointerException("Null token");
        }

        public g.a c(long j5) {
            this.f7232c = Long.valueOf(j5);
            return this;
        }

        public g.a d(long j5) {
            this.f7231b = Long.valueOf(j5);
            return this;
        }
    }

    public String b() {
        return this.f7227a;
    }

    public long c() {
        return this.f7229c;
    }

    public long d() {
        return this.f7228b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (this.f7227a.equals(gVar.b()) && this.f7228b == gVar.d() && this.f7229c == gVar.c()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        long j5 = this.f7228b;
        long j6 = this.f7229c;
        return ((((this.f7227a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)));
    }

    public String toString() {
        return "InstallationTokenResult{token=" + this.f7227a + ", tokenExpirationTimestamp=" + this.f7228b + ", tokenCreationTimestamp=" + this.f7229c + "}";
    }

    private a(String str, long j5, long j6) {
        this.f7227a = str;
        this.f7228b = j5;
        this.f7229c = j6;
    }
}
