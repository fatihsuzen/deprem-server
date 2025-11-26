package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;

final class Sniffer {
    private static final int[] COMPATIBLE_BRANDS = {Util.getIntegerCodeForString("isom"), Util.getIntegerCodeForString("iso2"), Util.getIntegerCodeForString("iso3"), Util.getIntegerCodeForString("iso4"), Util.getIntegerCodeForString("iso5"), Util.getIntegerCodeForString("iso6"), Util.getIntegerCodeForString("avc1"), Util.getIntegerCodeForString("hvc1"), Util.getIntegerCodeForString("hev1"), Util.getIntegerCodeForString("mp41"), Util.getIntegerCodeForString("mp42"), Util.getIntegerCodeForString("3g2a"), Util.getIntegerCodeForString("3g2b"), Util.getIntegerCodeForString("3gr6"), Util.getIntegerCodeForString("3gs6"), Util.getIntegerCodeForString("3ge6"), Util.getIntegerCodeForString("3gg6"), Util.getIntegerCodeForString("M4V "), Util.getIntegerCodeForString("M4A "), Util.getIntegerCodeForString("f4v "), Util.getIntegerCodeForString("kddi"), Util.getIntegerCodeForString("M4VP"), Util.getIntegerCodeForString("qt  "), Util.getIntegerCodeForString("MSNV")};
    private static final int SEARCH_LENGTH = 4096;

    private Sniffer() {
    }

    private static boolean isCompatibleBrand(int i5) {
        if ((i5 >>> 8) == Util.getIntegerCodeForString("3gp")) {
            return true;
        }
        for (int i6 : COMPATIBLE_BRANDS) {
            if (i6 == i5) {
                return true;
            }
        }
        return false;
    }

    public static boolean sniffFragmented(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return sniffInternal(extractorInput, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c2, code lost:
        r0 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean sniffInternal(com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput r20, boolean r21) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r0 = r20
            long r1 = r0.getLength()
            r3 = -1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r6 = 4096(0x1000, double:2.0237E-320)
            if (r5 == 0) goto L_0x0012
            int r5 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x0013
        L_0x0012:
            r1 = r6
        L_0x0013:
            int r1 = (int) r1
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r2 = new com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray
            r5 = 64
            r2.<init>((int) r5)
            r5 = 0
            r6 = r5
            r7 = r6
        L_0x001e:
            r8 = 1
            if (r6 >= r1) goto L_0x00c2
            r9 = 8
            r2.reset(r9)
            byte[] r10 = r2.data
            r0.peekFully(r10, r5, r9)
            long r10 = r2.readUnsignedInt()
            int r12 = r2.readInt()
            r13 = 1
            int r13 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r13 != 0) goto L_0x004d
            byte[] r10 = r2.data
            r0.peekFully(r10, r9, r9)
            r10 = 16
            r2.setLimit(r10)
            long r13 = r2.readUnsignedLongToLong()
            r18 = r13
            r13 = r10
            r10 = r18
            goto L_0x0063
        L_0x004d:
            r13 = 0
            int r13 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r13 != 0) goto L_0x0062
            long r13 = r0.getLength()
            int r15 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r15 == 0) goto L_0x0062
            long r10 = r0.getPosition()
            long r13 = r13 - r10
            long r10 = (long) r9
            long r10 = r10 + r13
        L_0x0062:
            r13 = r9
        L_0x0063:
            long r14 = (long) r13
            int r16 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r16 >= 0) goto L_0x0069
            return r5
        L_0x0069:
            int r6 = r6 + r13
            int r13 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_moov
            if (r12 != r13) goto L_0x006f
            goto L_0x001e
        L_0x006f:
            int r13 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_moof
            if (r12 == r13) goto L_0x00c0
            int r13 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_mvex
            if (r12 != r13) goto L_0x0078
            goto L_0x00c0
        L_0x0078:
            long r3 = (long) r6
            long r3 = r3 + r10
            long r3 = r3 - r14
            r13 = r5
            r17 = r6
            long r5 = (long) r1
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 < 0) goto L_0x0084
            goto L_0x00c2
        L_0x0084:
            long r10 = r10 - r14
            int r3 = (int) r10
            int r6 = r17 + r3
            int r4 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_ftyp
            if (r12 != r4) goto L_0x00b6
            if (r3 >= r9) goto L_0x008f
            return r13
        L_0x008f:
            r2.reset(r3)
            byte[] r4 = r2.data
            r0.peekFully(r4, r13, r3)
            int r3 = r3 / 4
            r4 = 0
        L_0x009a:
            if (r4 >= r3) goto L_0x00b2
            if (r4 != r8) goto L_0x00a3
            r5 = 4
            r2.skipBytes(r5)
            goto L_0x00af
        L_0x00a3:
            int r5 = r2.readInt()
            boolean r5 = isCompatibleBrand(r5)
            if (r5 == 0) goto L_0x00af
            r7 = r8
            goto L_0x00b2
        L_0x00af:
            int r4 = r4 + 1
            goto L_0x009a
        L_0x00b2:
            if (r7 != 0) goto L_0x00bb
            r13 = 0
            return r13
        L_0x00b6:
            if (r3 == 0) goto L_0x00bb
            r0.advancePeekPosition(r3)
        L_0x00bb:
            r3 = -1
            r5 = 0
            goto L_0x001e
        L_0x00c0:
            r0 = r8
            goto L_0x00c3
        L_0x00c2:
            r0 = 0
        L_0x00c3:
            if (r7 == 0) goto L_0x00ca
            r1 = r21
            if (r1 != r0) goto L_0x00ca
            return r8
        L_0x00ca:
            r13 = 0
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Sniffer.sniffInternal(com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput, boolean):boolean");
    }

    public static boolean sniffUnfragmented(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return sniffInternal(extractorInput, false);
    }
}
