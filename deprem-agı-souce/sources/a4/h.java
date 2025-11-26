package a4;

import V3.c;
import a4.d;
import e4.C2356e;
import e4.C2358g;
import e4.C2359h;
import e4.Z;
import e4.a0;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class h implements Closeable {

    /* renamed from: e  reason: collision with root package name */
    static final Logger f20419e = Logger.getLogger(e.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final C2358g f20420a;

    /* renamed from: b  reason: collision with root package name */
    private final a f20421b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f20422c;

    /* renamed from: d  reason: collision with root package name */
    final d.a f20423d;

    interface b {
        void a(int i5, b bVar, C2359h hVar);

        void ackSettings();

        void b(boolean z4, int i5, C2358g gVar, int i6);

        void c(boolean z4, m mVar);

        void d(int i5, b bVar);

        void headers(boolean z4, int i5, int i6, List list);

        void ping(boolean z4, int i5, int i6);

        void priority(int i5, int i6, int i7, boolean z4);

        void pushPromise(int i5, int i6, List list);

        void windowUpdate(int i5, long j5);
    }

    h(C2358g gVar, boolean z4) {
        this.f20420a = gVar;
        this.f20422c = z4;
        a aVar = new a(gVar);
        this.f20421b = aVar;
        this.f20423d = new d.a(4096, aVar);
    }

    static int a(int i5, byte b5, short s5) {
        if ((b5 & 8) != 0) {
            i5--;
        }
        if (s5 <= i5) {
            return (short) (i5 - s5);
        }
        throw e.d("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s5), Integer.valueOf(i5));
    }

    private void m(b bVar, int i5, byte b5, int i6) {
        boolean z4;
        short s5 = 0;
        if (i6 != 0) {
            if ((b5 & 1) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if ((b5 & 32) == 0) {
                if ((b5 & 8) != 0) {
                    s5 = (short) (this.f20420a.readByte() & 255);
                }
                bVar.b(z4, i6, this.f20420a, a(i5, b5, s5));
                this.f20420a.skip((long) s5);
                return;
            }
            throw e.d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        throw e.d("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
    }

    private void n(b bVar, int i5, byte b5, int i6) {
        if (i5 < 8) {
            throw e.d("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i5));
        } else if (i6 == 0) {
            int readInt = this.f20420a.readInt();
            int readInt2 = this.f20420a.readInt();
            int i7 = i5 - 8;
            b a5 = b.a(readInt2);
            if (a5 != null) {
                C2359h hVar = C2359h.f21567e;
                if (i7 > 0) {
                    hVar = this.f20420a.readByteString((long) i7);
                }
                bVar.a(readInt, a5, hVar);
                return;
            }
            throw e.d("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
        } else {
            throw e.d("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
    }

    private List o(int i5, short s5, byte b5, int i6) {
        a aVar = this.f20421b;
        aVar.f20428e = i5;
        aVar.f20425b = i5;
        aVar.f20429f = s5;
        aVar.f20426c = b5;
        aVar.f20427d = i6;
        this.f20423d.k();
        return this.f20423d.e();
    }

    private void p(b bVar, int i5, byte b5, int i6) {
        boolean z4;
        short s5 = 0;
        if (i6 != 0) {
            if ((b5 & 1) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if ((b5 & 8) != 0) {
                s5 = (short) (this.f20420a.readByte() & 255);
            }
            if ((b5 & 32) != 0) {
                t(bVar, i6);
                i5 -= 5;
            }
            bVar.headers(z4, i6, -1, o(a(i5, b5, s5), s5, b5, i6));
            return;
        }
        throw e.d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    static int q(C2358g gVar) {
        return (gVar.readByte() & 255) | ((gVar.readByte() & 255) << 16) | ((gVar.readByte() & 255) << 8);
    }

    private void s(b bVar, int i5, byte b5, int i6) {
        boolean z4 = true;
        if (i5 != 8) {
            throw e.d("TYPE_PING length != 8: %s", Integer.valueOf(i5));
        } else if (i6 == 0) {
            int readInt = this.f20420a.readInt();
            int readInt2 = this.f20420a.readInt();
            if ((b5 & 1) == 0) {
                z4 = false;
            }
            bVar.ping(z4, readInt, readInt2);
        } else {
            throw e.d("TYPE_PING streamId != 0", new Object[0]);
        }
    }

    private void t(b bVar, int i5) {
        boolean z4;
        int readInt = this.f20420a.readInt();
        if ((Integer.MIN_VALUE & readInt) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        bVar.priority(i5, readInt & Integer.MAX_VALUE, (this.f20420a.readByte() & 255) + 1, z4);
    }

    private void u(b bVar, int i5, byte b5, int i6) {
        if (i5 != 5) {
            throw e.d("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i5));
        } else if (i6 != 0) {
            t(bVar, i6);
        } else {
            throw e.d("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
    }

    private void v(b bVar, int i5, byte b5, int i6) {
        short s5 = 0;
        if (i6 != 0) {
            if ((b5 & 8) != 0) {
                s5 = (short) (this.f20420a.readByte() & 255);
            }
            bVar.pushPromise(i6, this.f20420a.readInt() & Integer.MAX_VALUE, o(a(i5 - 4, b5, s5), s5, b5, i6));
            return;
        }
        throw e.d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }

    private void x(b bVar, int i5, byte b5, int i6) {
        if (i5 != 4) {
            throw e.d("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i5));
        } else if (i6 != 0) {
            int readInt = this.f20420a.readInt();
            b a5 = b.a(readInt);
            if (a5 != null) {
                bVar.d(i6, a5);
                return;
            }
            throw e.d("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
        } else {
            throw e.d("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
    }

    private void y(b bVar, int i5, byte b5, int i6) {
        if (i6 != 0) {
            throw e.d("TYPE_SETTINGS streamId != 0", new Object[0]);
        } else if ((b5 & 1) != 0) {
            if (i5 == 0) {
                bVar.ackSettings();
                return;
            }
            throw e.d("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        } else if (i5 % 6 == 0) {
            m mVar = new m();
            for (int i7 = 0; i7 < i5; i7 += 6) {
                short readShort = this.f20420a.readShort() & 65535;
                int readInt = this.f20420a.readInt();
                if (readShort != 2) {
                    if (readShort == 3) {
                        readShort = 4;
                    } else if (readShort != 4) {
                        if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                            throw e.d("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                        }
                    } else if (readInt >= 0) {
                        readShort = 7;
                    } else {
                        throw e.d("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                    }
                } else if (!(readInt == 0 || readInt == 1)) {
                    throw e.d("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
                mVar.i(readShort, readInt);
            }
            bVar.c(false, mVar);
        } else {
            throw e.d("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i5));
        }
    }

    private void z(b bVar, int i5, byte b5, int i6) {
        if (i5 == 4) {
            long readInt = ((long) this.f20420a.readInt()) & 2147483647L;
            if (readInt != 0) {
                bVar.windowUpdate(i6, readInt);
                return;
            }
            throw e.d("windowSizeIncrement was 0", Long.valueOf(readInt));
        }
        throw e.d("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i5));
    }

    public void close() {
        this.f20420a.close();
    }

    public boolean d(boolean z4, b bVar) {
        try {
            this.f20420a.require(9);
            int q5 = q(this.f20420a);
            if (q5 < 0 || q5 > 16384) {
                throw e.d("FRAME_SIZE_ERROR: %s", Integer.valueOf(q5));
            }
            byte readByte = (byte) (this.f20420a.readByte() & 255);
            if (!z4 || readByte == 4) {
                byte readByte2 = (byte) (this.f20420a.readByte() & 255);
                int readInt = this.f20420a.readInt() & Integer.MAX_VALUE;
                Logger logger = f20419e;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(e.b(true, readInt, q5, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        m(bVar, q5, readByte2, readInt);
                        break;
                    case 1:
                        p(bVar, q5, readByte2, readInt);
                        break;
                    case 2:
                        u(bVar, q5, readByte2, readInt);
                        break;
                    case 3:
                        x(bVar, q5, readByte2, readInt);
                        break;
                    case 4:
                        y(bVar, q5, readByte2, readInt);
                        break;
                    case 5:
                        v(bVar, q5, readByte2, readInt);
                        break;
                    case 6:
                        s(bVar, q5, readByte2, readInt);
                        break;
                    case 7:
                        n(bVar, q5, readByte2, readInt);
                        break;
                    case 8:
                        z(bVar, q5, readByte2, readInt);
                        break;
                    default:
                        this.f20420a.skip((long) q5);
                        break;
                }
                return true;
            }
            throw e.d("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
        } catch (IOException unused) {
            return false;
        }
    }

    public void l(b bVar) {
        if (!this.f20422c) {
            C2358g gVar = this.f20420a;
            C2359h hVar = e.f20335a;
            C2359h readByteString = gVar.readByteString((long) hVar.F());
            Logger logger = f20419e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(c.o("<< CONNECTION %s", readByteString.m()));
            }
            if (!hVar.equals(readByteString)) {
                throw e.d("Expected a connection header but was %s", readByteString.L());
            }
        } else if (!d(true, bVar)) {
            throw e.d("Required SETTINGS preface not received", new Object[0]);
        }
    }

    static final class a implements Z {

        /* renamed from: a  reason: collision with root package name */
        private final C2358g f20424a;

        /* renamed from: b  reason: collision with root package name */
        int f20425b;

        /* renamed from: c  reason: collision with root package name */
        byte f20426c;

        /* renamed from: d  reason: collision with root package name */
        int f20427d;

        /* renamed from: e  reason: collision with root package name */
        int f20428e;

        /* renamed from: f  reason: collision with root package name */
        short f20429f;

        a(C2358g gVar) {
            this.f20424a = gVar;
        }

        private void a() {
            int i5 = this.f20427d;
            int q5 = h.q(this.f20424a);
            this.f20428e = q5;
            this.f20425b = q5;
            byte readByte = (byte) (this.f20424a.readByte() & 255);
            this.f20426c = (byte) (this.f20424a.readByte() & 255);
            Logger logger = h.f20419e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.b(true, this.f20427d, this.f20425b, readByte, this.f20426c));
            }
            int readInt = this.f20424a.readInt() & Integer.MAX_VALUE;
            this.f20427d = readInt;
            if (readByte != 9) {
                throw e.d("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            } else if (readInt != i5) {
                throw e.d("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        public long e(C2356e eVar, long j5) {
            while (true) {
                int i5 = this.f20428e;
                if (i5 == 0) {
                    this.f20424a.skip((long) this.f20429f);
                    this.f20429f = 0;
                    if ((this.f20426c & 4) != 0) {
                        return -1;
                    }
                    a();
                } else {
                    long e5 = this.f20424a.e(eVar, Math.min(j5, (long) i5));
                    if (e5 == -1) {
                        return -1;
                    }
                    this.f20428e = (int) (((long) this.f20428e) - e5);
                    return e5;
                }
            }
        }

        public a0 timeout() {
            return this.f20424a.timeout();
        }

        public void close() {
        }
    }
}
