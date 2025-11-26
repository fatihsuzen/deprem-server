package com.mbridge.msdk.playercommon.exoplayer2.metadata.id3;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.Metadata;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.MetadataDecoder;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.MetadataInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class Id3Decoder implements MetadataDecoder {
    private static final int FRAME_FLAG_V3_HAS_GROUP_IDENTIFIER = 32;
    private static final int FRAME_FLAG_V3_IS_COMPRESSED = 128;
    private static final int FRAME_FLAG_V3_IS_ENCRYPTED = 64;
    private static final int FRAME_FLAG_V4_HAS_DATA_LENGTH = 1;
    private static final int FRAME_FLAG_V4_HAS_GROUP_IDENTIFIER = 64;
    private static final int FRAME_FLAG_V4_IS_COMPRESSED = 8;
    private static final int FRAME_FLAG_V4_IS_ENCRYPTED = 4;
    private static final int FRAME_FLAG_V4_IS_UNSYNCHRONIZED = 2;
    public static final int ID3_HEADER_LENGTH = 10;
    public static final int ID3_TAG = Util.getIntegerCodeForString("ID3");
    private static final int ID3_TEXT_ENCODING_ISO_8859_1 = 0;
    private static final int ID3_TEXT_ENCODING_UTF_16 = 1;
    private static final int ID3_TEXT_ENCODING_UTF_16BE = 2;
    private static final int ID3_TEXT_ENCODING_UTF_8 = 3;
    public static final FramePredicate NO_FRAMES_PREDICATE = new FramePredicate() {
        public final boolean evaluate(int i5, int i6, int i7, int i8, int i9) {
            return false;
        }
    };
    private static final String TAG = "Id3Decoder";
    private final FramePredicate framePredicate;

    public interface FramePredicate {
        boolean evaluate(int i5, int i6, int i7, int i8, int i9);
    }

    private static final class Id3Header {
        /* access modifiers changed from: private */
        public final int framesSize;
        /* access modifiers changed from: private */
        public final boolean isUnsynchronized;
        /* access modifiers changed from: private */
        public final int majorVersion;

        public Id3Header(int i5, boolean z4, int i6) {
            this.majorVersion = i5;
            this.isUnsynchronized = z4;
            this.framesSize = i6;
        }
    }

    public Id3Decoder() {
        this((FramePredicate) null);
    }

    private static byte[] copyOfRangeIfValid(byte[] bArr, int i5, int i6) {
        if (i6 <= i5) {
            return new byte[0];
        }
        return Arrays.copyOfRange(bArr, i5, i6);
    }

    private static ApicFrame decodeApicFrame(ParsableByteArray parsableByteArray, int i5, int i6) throws UnsupportedEncodingException {
        int i7;
        String str;
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i8 = i5 - 1;
        byte[] bArr = new byte[i8];
        parsableByteArray.readBytes(bArr, 0, i8);
        if (i6 == 2) {
            str = "image/" + Util.toLowerInvariant(new String(bArr, 0, 3, "ISO-8859-1"));
            if ("image/jpg".equals(str)) {
                str = "image/jpeg";
            }
            i7 = 2;
        } else {
            i7 = indexOfZeroByte(bArr, 0);
            str = Util.toLowerInvariant(new String(bArr, 0, i7, "ISO-8859-1"));
            if (str.indexOf(47) == -1) {
                str = "image/" + str;
            }
        }
        int i9 = i7 + 2;
        int indexOfEos = indexOfEos(bArr, i9, readUnsignedByte);
        return new ApicFrame(str, new String(bArr, i9, indexOfEos - i9, charsetName), bArr[i7 + 1] & 255, copyOfRangeIfValid(bArr, indexOfEos + delimiterLength(readUnsignedByte), i8));
    }

    private static BinaryFrame decodeBinaryFrame(ParsableByteArray parsableByteArray, int i5, String str) {
        byte[] bArr = new byte[i5];
        parsableByteArray.readBytes(bArr, 0, i5);
        return new BinaryFrame(str, bArr);
    }

    private static ChapterFrame decodeChapterFrame(ParsableByteArray parsableByteArray, int i5, int i6, boolean z4, int i7, FramePredicate framePredicate2) throws UnsupportedEncodingException {
        long j5;
        int position = parsableByteArray.getPosition();
        int indexOfZeroByte = indexOfZeroByte(parsableByteArray.data, position);
        String str = new String(parsableByteArray.data, position, indexOfZeroByte - position, "ISO-8859-1");
        parsableByteArray.setPosition(indexOfZeroByte + 1);
        int readInt = parsableByteArray.readInt();
        int readInt2 = parsableByteArray.readInt();
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        if (readUnsignedInt == 4294967295L) {
            readUnsignedInt = -1;
        }
        long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
        if (readUnsignedInt2 == 4294967295L) {
            j5 = -1;
        } else {
            j5 = readUnsignedInt2;
        }
        ArrayList arrayList = new ArrayList();
        int i8 = position + i5;
        while (parsableByteArray.getPosition() < i8) {
            Id3Frame decodeFrame = decodeFrame(i6, parsableByteArray, z4, i7, framePredicate2);
            if (decodeFrame != null) {
                arrayList.add(decodeFrame);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterFrame(str, readInt, readInt2, readUnsignedInt, j5, id3FrameArr);
    }

    private static ChapterTocFrame decodeChapterTOCFrame(ParsableByteArray parsableByteArray, int i5, int i6, boolean z4, int i7, FramePredicate framePredicate2) throws UnsupportedEncodingException {
        boolean z5;
        boolean z6;
        int position = parsableByteArray.getPosition();
        int indexOfZeroByte = indexOfZeroByte(parsableByteArray.data, position);
        String str = new String(parsableByteArray.data, position, indexOfZeroByte - position, "ISO-8859-1");
        parsableByteArray.setPosition(indexOfZeroByte + 1);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((readUnsignedByte & 2) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if ((readUnsignedByte & 1) != 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        String[] strArr = new String[readUnsignedByte2];
        for (int i8 = 0; i8 < readUnsignedByte2; i8++) {
            int position2 = parsableByteArray.getPosition();
            int indexOfZeroByte2 = indexOfZeroByte(parsableByteArray.data, position2);
            strArr[i8] = new String(parsableByteArray.data, position2, indexOfZeroByte2 - position2, "ISO-8859-1");
            parsableByteArray.setPosition(indexOfZeroByte2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i9 = position + i5;
        while (parsableByteArray.getPosition() < i9) {
            Id3Frame decodeFrame = decodeFrame(i6, parsableByteArray, z4, i7, framePredicate2);
            if (decodeFrame != null) {
                arrayList.add(decodeFrame);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterTocFrame(str, z5, z6, strArr, id3FrameArr);
    }

    private static CommentFrame decodeCommentFrame(ParsableByteArray parsableByteArray, int i5) throws UnsupportedEncodingException {
        if (i5 < 4) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        byte[] bArr = new byte[3];
        parsableByteArray.readBytes(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i6 = i5 - 4;
        byte[] bArr2 = new byte[i6];
        parsableByteArray.readBytes(bArr2, 0, i6);
        int indexOfEos = indexOfEos(bArr2, 0, readUnsignedByte);
        String str2 = new String(bArr2, 0, indexOfEos, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        return new CommentFrame(str, str2, decodeStringIfValid(bArr2, delimiterLength, indexOfEos(bArr2, delimiterLength, readUnsignedByte), charsetName));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:135:0x01a0, code lost:
        r1 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0124, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0125, code lost:
        r1 = r6;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:87:0x0117, B:132:0x0197] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0204 A[Catch:{ UnsupportedEncodingException -> 0x0228 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0124 A[Catch:{ UnsupportedEncodingException -> 0x0128, all -> 0x0124 }, ExcHandler: all (th java.lang.Throwable), Splitter:B:87:0x0117] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:87:0x0117=Splitter:B:87:0x0117, B:132:0x0197=Splitter:B:132:0x0197} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.Id3Frame decodeFrame(int r18, com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r19, boolean r20, int r21, com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.Id3Decoder.FramePredicate r22) {
        /*
            r3 = r18
            r6 = r19
            int r2 = r6.readUnsignedByte()
            int r0 = r6.readUnsignedByte()
            int r4 = r6.readUnsignedByte()
            r7 = 0
            r8 = 3
            if (r3 < r8) goto L_0x001a
            int r1 = r6.readUnsignedByte()
            r5 = r1
            goto L_0x001b
        L_0x001a:
            r5 = r7
        L_0x001b:
            r9 = 4
            if (r3 != r9) goto L_0x003d
            int r1 = r6.readUnsignedIntToInt()
            if (r20 != 0) goto L_0x003b
            r10 = r1 & 255(0xff, float:3.57E-43)
            int r11 = r1 >> 8
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 7
            r10 = r10 | r11
            int r11 = r1 >> 16
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 14
            r10 = r10 | r11
            int r1 = r1 >> 24
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << 21
            r1 = r1 | r10
        L_0x003b:
            r10 = r1
            goto L_0x0049
        L_0x003d:
            if (r3 != r8) goto L_0x0044
            int r1 = r6.readUnsignedIntToInt()
            goto L_0x003b
        L_0x0044:
            int r1 = r6.readUnsignedInt24()
            goto L_0x003b
        L_0x0049:
            if (r3 < r8) goto L_0x0051
            int r1 = r6.readUnsignedShort()
            r11 = r1
            goto L_0x0052
        L_0x0051:
            r11 = r7
        L_0x0052:
            r12 = 0
            if (r2 != 0) goto L_0x0067
            if (r0 != 0) goto L_0x0067
            if (r4 != 0) goto L_0x0067
            if (r5 != 0) goto L_0x0067
            if (r10 != 0) goto L_0x0067
            if (r11 != 0) goto L_0x0067
            int r0 = r6.limit()
            r6.setPosition(r0)
            return r12
        L_0x0067:
            int r1 = r6.getPosition()
            int r13 = r1 + r10
            int r1 = r6.limit()
            java.lang.String r14 = "Id3Decoder"
            if (r13 <= r1) goto L_0x0082
            java.lang.String r0 = "Frame size exceeds remaining tag data"
            android.util.Log.w(r14, r0)
            int r0 = r6.limit()
            r6.setPosition(r0)
            return r12
        L_0x0082:
            if (r22 == 0) goto L_0x0098
            r1 = r3
            r3 = r0
            r0 = r22
            boolean r15 = r0.evaluate(r1, r2, r3, r4, r5)
            r0 = r3
            r3 = r1
            r1 = r0
            r0 = r2
            r2 = r4
            r4 = r5
            if (r15 != 0) goto L_0x009c
            r6.setPosition(r13)
            return r12
        L_0x0098:
            r1 = r0
            r0 = r2
            r2 = r4
            r4 = r5
        L_0x009c:
            r5 = 1
            if (r3 != r8) goto L_0x00bc
            r8 = r11 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x00a5
            r8 = r5
            goto L_0x00a6
        L_0x00a5:
            r8 = r7
        L_0x00a6:
            r15 = r11 & 64
            if (r15 == 0) goto L_0x00ac
            r15 = r5
            goto L_0x00ad
        L_0x00ac:
            r15 = r7
        L_0x00ad:
            r11 = r11 & 32
            if (r11 == 0) goto L_0x00b3
            r11 = r5
            goto L_0x00b4
        L_0x00b3:
            r11 = r7
        L_0x00b4:
            r17 = r7
            r7 = r8
            r16 = r15
            r15 = r7
            r8 = r11
            goto L_0x00e2
        L_0x00bc:
            if (r3 != r9) goto L_0x00e5
            r8 = r11 & 64
            if (r8 == 0) goto L_0x00c4
            r8 = r5
            goto L_0x00c5
        L_0x00c4:
            r8 = r7
        L_0x00c5:
            r15 = r11 & 8
            if (r15 == 0) goto L_0x00cb
            r15 = r5
            goto L_0x00cc
        L_0x00cb:
            r15 = r7
        L_0x00cc:
            r16 = r11 & 4
            if (r16 == 0) goto L_0x00d3
            r16 = r5
            goto L_0x00d5
        L_0x00d3:
            r16 = r7
        L_0x00d5:
            r17 = r11 & 2
            if (r17 == 0) goto L_0x00dc
            r17 = r5
            goto L_0x00de
        L_0x00dc:
            r17 = r7
        L_0x00de:
            r11 = r11 & r5
            if (r11 == 0) goto L_0x00e2
            r7 = r5
        L_0x00e2:
            r11 = r7
            r7 = r15
            goto L_0x00eb
        L_0x00e5:
            r8 = r7
            r11 = r8
            r16 = r11
            r17 = r16
        L_0x00eb:
            if (r7 != 0) goto L_0x00ef
            if (r16 == 0) goto L_0x00f4
        L_0x00ef:
            r1 = r6
            r16 = r12
            goto L_0x0235
        L_0x00f4:
            if (r8 == 0) goto L_0x00fb
            int r10 = r10 + -1
            r6.skipBytes(r5)
        L_0x00fb:
            if (r11 == 0) goto L_0x0102
            int r10 = r10 + -4
            r6.skipBytes(r9)
        L_0x0102:
            if (r17 == 0) goto L_0x0108
            int r10 = removeUnsynchronization(r6, r10)
        L_0x0108:
            r7 = 84
            r5 = 88
            r8 = 2
            if (r0 != r7) goto L_0x012d
            if (r1 != r5) goto L_0x012d
            if (r2 != r5) goto L_0x012d
            if (r3 == r8) goto L_0x0117
            if (r4 != r5) goto L_0x012d
        L_0x0117:
            com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.TextInformationFrame r5 = decodeTxxxFrame(r6, r10)     // Catch:{ UnsupportedEncodingException -> 0x0128, all -> 0x0124 }
        L_0x011b:
            r8 = r1
            r9 = r2
            r1 = r6
            r2 = r10
            r16 = r12
        L_0x0121:
            r10 = r4
            goto L_0x0202
        L_0x0124:
            r0 = move-exception
            r1 = r6
            goto L_0x0231
        L_0x0128:
            r1 = r6
            r16 = r12
            goto L_0x0228
        L_0x012d:
            if (r0 != r7) goto L_0x0138
            java.lang.String r5 = getFrameId(r3, r0, r1, r2, r4)     // Catch:{ UnsupportedEncodingException -> 0x0128, all -> 0x0124 }
            com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.TextInformationFrame r5 = decodeTextInformationFrame(r6, r10, r5)     // Catch:{ UnsupportedEncodingException -> 0x0128, all -> 0x0124 }
            goto L_0x011b
        L_0x0138:
            r9 = 87
            if (r0 != r9) goto L_0x0149
            if (r1 != r5) goto L_0x0149
            if (r2 != r5) goto L_0x0149
            if (r3 == r8) goto L_0x0144
            if (r4 != r5) goto L_0x0149
        L_0x0144:
            com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.UrlLinkFrame r5 = decodeWxxxFrame(r6, r10)     // Catch:{ UnsupportedEncodingException -> 0x0128, all -> 0x0124 }
            goto L_0x011b
        L_0x0149:
            if (r0 != r9) goto L_0x0154
            java.lang.String r5 = getFrameId(r3, r0, r1, r2, r4)     // Catch:{ UnsupportedEncodingException -> 0x0128, all -> 0x0124 }
            com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.UrlLinkFrame r5 = decodeUrlLinkFrame(r6, r10, r5)     // Catch:{ UnsupportedEncodingException -> 0x0128, all -> 0x0124 }
            goto L_0x011b
        L_0x0154:
            r5 = 73
            r9 = 80
            if (r0 != r9) goto L_0x0169
            r11 = 82
            if (r1 != r11) goto L_0x0169
            if (r2 != r5) goto L_0x0169
            r11 = 86
            if (r4 != r11) goto L_0x0169
            com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.PrivFrame r5 = decodePrivFrame(r6, r10)     // Catch:{ UnsupportedEncodingException -> 0x0128, all -> 0x0124 }
            goto L_0x011b
        L_0x0169:
            r11 = 71
            r15 = 79
            if (r0 != r11) goto L_0x0180
            r11 = 69
            if (r1 != r11) goto L_0x0180
            if (r2 != r15) goto L_0x0180
            r11 = 66
            if (r4 == r11) goto L_0x017b
            if (r3 != r8) goto L_0x0180
        L_0x017b:
            com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.GeobFrame r5 = decodeGeobFrame(r6, r10)     // Catch:{ UnsupportedEncodingException -> 0x0128, all -> 0x0124 }
            goto L_0x011b
        L_0x0180:
            r11 = 65
            r16 = r12
            r12 = 67
            if (r3 != r8) goto L_0x018f
            if (r0 != r9) goto L_0x01a3
            if (r1 != r5) goto L_0x01a3
            if (r2 != r12) goto L_0x01a3
            goto L_0x0197
        L_0x018f:
            if (r0 != r11) goto L_0x01a3
            if (r1 != r9) goto L_0x01a3
            if (r2 != r5) goto L_0x01a3
            if (r4 != r12) goto L_0x01a3
        L_0x0197:
            com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.ApicFrame r5 = decodeApicFrame(r6, r10, r3)     // Catch:{ UnsupportedEncodingException -> 0x01a0, all -> 0x0124 }
        L_0x019b:
            r8 = r1
            r9 = r2
            r1 = r6
            r2 = r10
            goto L_0x0121
        L_0x01a0:
            r1 = r6
            goto L_0x0228
        L_0x01a3:
            if (r0 != r12) goto L_0x01b4
            if (r1 != r15) goto L_0x01b4
            r5 = 77
            if (r2 != r5) goto L_0x01b4
            if (r4 == r5) goto L_0x01af
            if (r3 != r8) goto L_0x01b4
        L_0x01af:
            com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.CommentFrame r5 = decodeCommentFrame(r6, r10)     // Catch:{ UnsupportedEncodingException -> 0x01a0, all -> 0x0124 }
            goto L_0x019b
        L_0x01b4:
            if (r0 != r12) goto L_0x01d9
            r5 = 72
            if (r1 != r5) goto L_0x01d9
            if (r2 != r11) goto L_0x01d9
            if (r4 != r9) goto L_0x01d9
            r5 = r21
            r8 = r1
            r9 = r2
            r1 = r6
            r2 = r10
            r6 = r22
            r10 = r4
            r4 = r20
            com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.ChapterFrame r5 = decodeChapterFrame(r1, r2, r3, r4, r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x01d6, all -> 0x01d2 }
            r3 = r18
            r1 = r19
            goto L_0x0202
        L_0x01d2:
            r0 = move-exception
            r1 = r19
            goto L_0x0231
        L_0x01d6:
            r1 = r19
            goto L_0x0228
        L_0x01d9:
            r8 = r1
            r9 = r2
            r2 = r10
            r10 = r4
            if (r0 != r12) goto L_0x01f6
            if (r8 != r7) goto L_0x01f6
            if (r9 != r15) goto L_0x01f6
            if (r10 != r12) goto L_0x01f6
            r3 = r18
            r1 = r19
            r4 = r20
            r5 = r21
            r6 = r22
            com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.ChapterTocFrame r5 = decodeChapterTOCFrame(r1, r2, r3, r4, r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x0228 }
            goto L_0x0202
        L_0x01f4:
            r0 = move-exception
            goto L_0x0231
        L_0x01f6:
            r3 = r18
            r1 = r19
            java.lang.String r4 = getFrameId(r3, r0, r8, r9, r10)     // Catch:{ UnsupportedEncodingException -> 0x0228 }
            com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.BinaryFrame r5 = decodeBinaryFrame(r1, r2, r4)     // Catch:{ UnsupportedEncodingException -> 0x0228 }
        L_0x0202:
            if (r5 != 0) goto L_0x0224
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x0228 }
            r4.<init>()     // Catch:{ UnsupportedEncodingException -> 0x0228 }
            java.lang.String r6 = "Failed to decode frame: id="
            r4.append(r6)     // Catch:{ UnsupportedEncodingException -> 0x0228 }
            java.lang.String r0 = getFrameId(r3, r0, r8, r9, r10)     // Catch:{ UnsupportedEncodingException -> 0x0228 }
            r4.append(r0)     // Catch:{ UnsupportedEncodingException -> 0x0228 }
            java.lang.String r0 = ", frameSize="
            r4.append(r0)     // Catch:{ UnsupportedEncodingException -> 0x0228 }
            r4.append(r2)     // Catch:{ UnsupportedEncodingException -> 0x0228 }
            java.lang.String r0 = r4.toString()     // Catch:{ UnsupportedEncodingException -> 0x0228 }
            android.util.Log.w(r14, r0)     // Catch:{ UnsupportedEncodingException -> 0x0228 }
        L_0x0224:
            r1.setPosition(r13)
            return r5
        L_0x0228:
            java.lang.String r0 = "Unsupported character encoding"
            android.util.Log.w(r14, r0)     // Catch:{ all -> 0x01f4 }
            r1.setPosition(r13)
            return r16
        L_0x0231:
            r1.setPosition(r13)
            throw r0
        L_0x0235:
            java.lang.String r0 = "Skipping unsupported compressed or encrypted frame"
            android.util.Log.w(r14, r0)
            r1.setPosition(r13)
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.Id3Decoder.decodeFrame(int, com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray, boolean, int, com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.Id3Decoder$FramePredicate):com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.Id3Frame");
    }

    private static GeobFrame decodeGeobFrame(ParsableByteArray parsableByteArray, int i5) throws UnsupportedEncodingException {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i6 = i5 - 1;
        byte[] bArr = new byte[i6];
        parsableByteArray.readBytes(bArr, 0, i6);
        int indexOfZeroByte = indexOfZeroByte(bArr, 0);
        String str = new String(bArr, 0, indexOfZeroByte, "ISO-8859-1");
        int i7 = indexOfZeroByte + 1;
        int indexOfEos = indexOfEos(bArr, i7, readUnsignedByte);
        String decodeStringIfValid = decodeStringIfValid(bArr, i7, indexOfEos, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        int indexOfEos2 = indexOfEos(bArr, delimiterLength, readUnsignedByte);
        return new GeobFrame(str, decodeStringIfValid, decodeStringIfValid(bArr, delimiterLength, indexOfEos2, charsetName), copyOfRangeIfValid(bArr, indexOfEos2 + delimiterLength(readUnsignedByte), i6));
    }

    private static Id3Header decodeHeader(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.bytesLeft() < 10) {
            Log.w(TAG, "Data too short to be an ID3 tag");
            return null;
        }
        int readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
        if (readUnsignedInt24 != ID3_TAG) {
            Log.w(TAG, "Unexpected first three bytes of ID3 tag header: " + readUnsignedInt24);
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        boolean z4 = true;
        parsableByteArray.skipBytes(1);
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        int readSynchSafeInt = parsableByteArray.readSynchSafeInt();
        if (readUnsignedByte == 2) {
            if ((readUnsignedByte2 & 64) != 0) {
                Log.w(TAG, "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (readUnsignedByte == 3) {
            if ((readUnsignedByte2 & 64) != 0) {
                int readInt = parsableByteArray.readInt();
                parsableByteArray.skipBytes(readInt);
                readSynchSafeInt -= readInt + 4;
            }
        } else if (readUnsignedByte == 4) {
            if ((readUnsignedByte2 & 64) != 0) {
                int readSynchSafeInt2 = parsableByteArray.readSynchSafeInt();
                parsableByteArray.skipBytes(readSynchSafeInt2 - 4);
                readSynchSafeInt -= readSynchSafeInt2;
            }
            if ((readUnsignedByte2 & 16) != 0) {
                readSynchSafeInt -= 10;
            }
        } else {
            Log.w(TAG, "Skipped ID3 tag with unsupported majorVersion=" + readUnsignedByte);
            return null;
        }
        if (readUnsignedByte >= 4 || (readUnsignedByte2 & 128) == 0) {
            z4 = false;
        }
        return new Id3Header(readUnsignedByte, z4, readSynchSafeInt);
    }

    private static PrivFrame decodePrivFrame(ParsableByteArray parsableByteArray, int i5) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i5];
        parsableByteArray.readBytes(bArr, 0, i5);
        int indexOfZeroByte = indexOfZeroByte(bArr, 0);
        return new PrivFrame(new String(bArr, 0, indexOfZeroByte, "ISO-8859-1"), copyOfRangeIfValid(bArr, indexOfZeroByte + 1, i5));
    }

    private static String decodeStringIfValid(byte[] bArr, int i5, int i6, String str) throws UnsupportedEncodingException {
        if (i6 <= i5 || i6 > bArr.length) {
            return "";
        }
        return new String(bArr, i5, i6 - i5, str);
    }

    private static TextInformationFrame decodeTextInformationFrame(ParsableByteArray parsableByteArray, int i5, String str) throws UnsupportedEncodingException {
        if (i5 < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i6 = i5 - 1;
        byte[] bArr = new byte[i6];
        parsableByteArray.readBytes(bArr, 0, i6);
        return new TextInformationFrame(str, (String) null, new String(bArr, 0, indexOfEos(bArr, 0, readUnsignedByte), charsetName));
    }

    private static TextInformationFrame decodeTxxxFrame(ParsableByteArray parsableByteArray, int i5) throws UnsupportedEncodingException {
        if (i5 < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i6 = i5 - 1;
        byte[] bArr = new byte[i6];
        parsableByteArray.readBytes(bArr, 0, i6);
        int indexOfEos = indexOfEos(bArr, 0, readUnsignedByte);
        String str = new String(bArr, 0, indexOfEos, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        return new TextInformationFrame("TXXX", str, decodeStringIfValid(bArr, delimiterLength, indexOfEos(bArr, delimiterLength, readUnsignedByte), charsetName));
    }

    private static UrlLinkFrame decodeUrlLinkFrame(ParsableByteArray parsableByteArray, int i5, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i5];
        parsableByteArray.readBytes(bArr, 0, i5);
        return new UrlLinkFrame(str, (String) null, new String(bArr, 0, indexOfZeroByte(bArr, 0), "ISO-8859-1"));
    }

    private static UrlLinkFrame decodeWxxxFrame(ParsableByteArray parsableByteArray, int i5) throws UnsupportedEncodingException {
        if (i5 < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i6 = i5 - 1;
        byte[] bArr = new byte[i6];
        parsableByteArray.readBytes(bArr, 0, i6);
        int indexOfEos = indexOfEos(bArr, 0, readUnsignedByte);
        String str = new String(bArr, 0, indexOfEos, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        return new UrlLinkFrame("WXXX", str, decodeStringIfValid(bArr, delimiterLength, indexOfZeroByte(bArr, delimiterLength), "ISO-8859-1"));
    }

    private static int delimiterLength(int i5) {
        return (i5 == 0 || i5 == 3) ? 1 : 2;
    }

    private static String getCharsetName(int i5) {
        if (i5 == 1) {
            return C.UTF16_NAME;
        }
        if (i5 == 2) {
            return "UTF-16BE";
        }
        if (i5 != 3) {
            return "ISO-8859-1";
        }
        return C.UTF8_NAME;
    }

    private static String getFrameId(int i5, int i6, int i7, int i8, int i9) {
        if (i5 == 2) {
            return String.format(Locale.US, "%c%c%c", new Object[]{Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)});
        }
        return String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)});
    }

    private static int indexOfEos(byte[] bArr, int i5, int i6) {
        int indexOfZeroByte = indexOfZeroByte(bArr, i5);
        if (i6 == 0 || i6 == 3) {
            return indexOfZeroByte;
        }
        while (indexOfZeroByte < bArr.length - 1) {
            if (indexOfZeroByte % 2 == 0 && bArr[indexOfZeroByte + 1] == 0) {
                return indexOfZeroByte;
            }
            indexOfZeroByte = indexOfZeroByte(bArr, indexOfZeroByte + 1);
        }
        return bArr.length;
    }

    private static int indexOfZeroByte(byte[] bArr, int i5) {
        while (i5 < bArr.length) {
            if (bArr[i5] == 0) {
                return i5;
            }
            i5++;
        }
        return bArr.length;
    }

    private static int removeUnsynchronization(ParsableByteArray parsableByteArray, int i5) {
        byte[] bArr = parsableByteArray.data;
        int position = parsableByteArray.getPosition();
        while (true) {
            int i6 = position + 1;
            if (i6 >= i5) {
                return i5;
            }
            if ((bArr[position] & 255) == 255 && bArr[i6] == 0) {
                System.arraycopy(bArr, position + 2, bArr, i6, (i5 - position) - 2);
                i5--;
            }
            position = i6;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0079, code lost:
        if ((r10 & 1) != 0) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0089, code lost:
        if ((r10 & 128) != 0) goto L_0x008e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009b A[SYNTHETIC, Splitter:B:48:0x009b] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0097 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean validateFrames(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r1.getPosition()
        L_0x0008:
            int r3 = r1.bytesLeft()     // Catch:{ all -> 0x0022 }
            r4 = 1
            r5 = r20
            if (r3 < r5) goto L_0x00ae
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L_0x0025
            int r7 = r1.readInt()     // Catch:{ all -> 0x0022 }
            long r8 = r1.readUnsignedInt()     // Catch:{ all -> 0x0022 }
            int r10 = r1.readUnsignedShort()     // Catch:{ all -> 0x0022 }
            goto L_0x002f
        L_0x0022:
            r0 = move-exception
            goto L_0x00b2
        L_0x0025:
            int r7 = r1.readUnsignedInt24()     // Catch:{ all -> 0x0022 }
            int r8 = r1.readUnsignedInt24()     // Catch:{ all -> 0x0022 }
            long r8 = (long) r8
            r10 = r6
        L_0x002f:
            r11 = 0
            if (r7 != 0) goto L_0x003d
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x003d
            if (r10 != 0) goto L_0x003d
            r1.setPosition(r2)
            return r4
        L_0x003d:
            r7 = 4
            if (r0 != r7) goto L_0x006e
            if (r21 != 0) goto L_0x006e
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r11 == 0) goto L_0x004e
            r1.setPosition(r2)
            return r6
        L_0x004e:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L_0x006e:
            if (r0 != r7) goto L_0x007e
            r3 = r10 & 64
            if (r3 == 0) goto L_0x0076
            r3 = r4
            goto L_0x0077
        L_0x0076:
            r3 = r6
        L_0x0077:
            r7 = r10 & 1
            if (r7 == 0) goto L_0x007c
            goto L_0x008e
        L_0x007c:
            r4 = r6
            goto L_0x008e
        L_0x007e:
            if (r0 != r3) goto L_0x008c
            r3 = r10 & 32
            if (r3 == 0) goto L_0x0086
            r3 = r4
            goto L_0x0087
        L_0x0086:
            r3 = r6
        L_0x0087:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x007c
            goto L_0x008e
        L_0x008c:
            r3 = r6
            r4 = r3
        L_0x008e:
            if (r4 == 0) goto L_0x0092
            int r3 = r3 + 4
        L_0x0092:
            long r3 = (long) r3
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x009b
            r1.setPosition(r2)
            return r6
        L_0x009b:
            int r3 = r1.bytesLeft()     // Catch:{ all -> 0x0022 }
            long r3 = (long) r3
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x00a8
            r1.setPosition(r2)
            return r6
        L_0x00a8:
            int r3 = (int) r8
            r1.skipBytes(r3)     // Catch:{ all -> 0x0022 }
            goto L_0x0008
        L_0x00ae:
            r1.setPosition(r2)
            return r4
        L_0x00b2:
            r1.setPosition(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.Id3Decoder.validateFrames(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray, int, int, boolean):boolean");
    }

    public final Metadata decode(MetadataInputBuffer metadataInputBuffer) {
        ByteBuffer byteBuffer = metadataInputBuffer.data;
        return decode(byteBuffer.array(), byteBuffer.limit());
    }

    public Id3Decoder(FramePredicate framePredicate2) {
        this.framePredicate = framePredicate2;
    }

    public final Metadata decode(byte[] bArr, int i5) {
        ArrayList arrayList = new ArrayList();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i5);
        Id3Header decodeHeader = decodeHeader(parsableByteArray);
        if (decodeHeader == null) {
            return null;
        }
        int position = parsableByteArray.getPosition();
        int i6 = decodeHeader.majorVersion == 2 ? 6 : 10;
        int access$100 = decodeHeader.framesSize;
        if (decodeHeader.isUnsynchronized) {
            access$100 = removeUnsynchronization(parsableByteArray, decodeHeader.framesSize);
        }
        parsableByteArray.setLimit(position + access$100);
        boolean z4 = false;
        if (!validateFrames(parsableByteArray, decodeHeader.majorVersion, i6, false)) {
            if (decodeHeader.majorVersion != 4 || !validateFrames(parsableByteArray, 4, i6, true)) {
                Log.w(TAG, "Failed to validate ID3 tag with majorVersion=" + decodeHeader.majorVersion);
                return null;
            }
            z4 = true;
        }
        while (parsableByteArray.bytesLeft() >= i6) {
            Id3Frame decodeFrame = decodeFrame(decodeHeader.majorVersion, parsableByteArray, z4, i6, this.framePredicate);
            if (decodeFrame != null) {
                arrayList.add(decodeFrame);
            }
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }
}
