package com.mbridge.msdk.foundation.a.a;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.af;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f8768a = "a";

    /* renamed from: c  reason: collision with root package name */
    private static a f8769c;

    /* renamed from: b  reason: collision with root package name */
    FastKV f8770b;

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f8769c == null) {
                    f8769c = new a();
                }
                aVar = f8769c;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return aVar;
    }

    public final Long b(String str) {
        try {
            if (c.m().c() == null) {
                af.b(f8768a, "context is null in get");
                return 0L;
            }
            b();
            FastKV fastKV = this.f8770b;
            if (fastKV != null) {
                try {
                    return Long.valueOf(fastKV.getLong(str, 0));
                } catch (Exception unused) {
                    return 0L;
                }
            }
            return 0L;
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                String str2 = f8768a;
                af.a(str2, "getLong error: " + e5.getMessage());
            }
        }
    }

    public final void c(String str) {
        if (c.m().c() != null) {
            b();
            FastKV fastKV = this.f8770b;
            if (fastKV != null) {
                try {
                    fastKV.remove(str);
                } catch (Exception unused) {
                }
            }
        }
    }

    public final String a(String str) {
        try {
            if (c.m().c() == null) {
                return null;
            }
            b();
            FastKV fastKV = this.f8770b;
            if (fastKV != null) {
                try {
                    return fastKV.getString(str, "");
                } catch (Exception unused) {
                    return "";
                }
            }
            return null;
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                String str2 = f8768a;
                af.a(str2, "get error: " + e5.getMessage());
            }
        }
    }

    public final void b(String str, int i5) {
        try {
            if (c.m().c() != null) {
                b();
                FastKV fastKV = this.f8770b;
                if (fastKV != null) {
                    try {
                        fastKV.putInt(str, i5);
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final int a(String str, int i5) {
        try {
            if (c.m().c() != null) {
                b();
                FastKV fastKV = this.f8770b;
                if (fastKV != null) {
                    try {
                        return fastKV.getInt(str, i5);
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                String str2 = f8768a;
                af.a(str2, "getInt error: " + e5.getMessage());
            }
        }
        return i5;
    }

    private void b() {
        if (this.f8770b == null) {
            try {
                this.f8770b = new FastKV.Builder(e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "mbridge").build();
            } catch (Exception unused) {
                this.f8770b = null;
            }
        }
    }

    public final void a(String str, String str2) {
        try {
            if (c.m().c() != null) {
                b();
                FastKV fastKV = this.f8770b;
                if (fastKV != null) {
                    try {
                        fastKV.putString(str, str2);
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                String str3 = f8768a;
                af.a(str3, "put error: " + e5.getMessage());
            }
        }
    }

    public final void a(String str, long j5) {
        try {
            if (c.m().c() == null) {
                af.b(f8768a, "context is null in put");
                return;
            }
            b();
            FastKV fastKV = this.f8770b;
            if (fastKV != null) {
                try {
                    fastKV.putLong(str, j5);
                } catch (Exception unused) {
                }
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                String str2 = f8768a;
                af.a(str2, "putLong error: " + e5.getMessage());
            }
        }
    }
}
