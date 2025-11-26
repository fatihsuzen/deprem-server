package com.mbridge.msdk.playercommon.exoplayer2.text.dvb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.ViewCompat;
import androidx.work.WorkInfo;
import com.mbridge.msdk.playercommon.exoplayer2.text.Cue;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class DvbParser {
    private static final int DATA_TYPE_24_TABLE_DATA = 32;
    private static final int DATA_TYPE_28_TABLE_DATA = 33;
    private static final int DATA_TYPE_2BP_CODE_STRING = 16;
    private static final int DATA_TYPE_48_TABLE_DATA = 34;
    private static final int DATA_TYPE_4BP_CODE_STRING = 17;
    private static final int DATA_TYPE_8BP_CODE_STRING = 18;
    private static final int DATA_TYPE_END_LINE = 240;
    private static final int OBJECT_CODING_PIXELS = 0;
    private static final int OBJECT_CODING_STRING = 1;
    private static final int PAGE_STATE_NORMAL = 0;
    private static final int REGION_DEPTH_4_BIT = 2;
    private static final int REGION_DEPTH_8_BIT = 3;
    private static final int SEGMENT_TYPE_CLUT_DEFINITION = 18;
    private static final int SEGMENT_TYPE_DISPLAY_DEFINITION = 20;
    private static final int SEGMENT_TYPE_OBJECT_DATA = 19;
    private static final int SEGMENT_TYPE_PAGE_COMPOSITION = 16;
    private static final int SEGMENT_TYPE_REGION_COMPOSITION = 17;
    private static final String TAG = "DvbParser";
    private static final byte[] defaultMap2To4 = {0, 7, 8, 15};
    private static final byte[] defaultMap2To8 = {0, 119, -120, -1};
    private static final byte[] defaultMap4To8 = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private Bitmap bitmap;
    private final Canvas canvas = new Canvas();
    private final ClutDefinition defaultClutDefinition = new ClutDefinition(0, generateDefault2BitClutEntries(), generateDefault4BitClutEntries(), generateDefault8BitClutEntries());
    private final DisplayDefinition defaultDisplayDefinition = new DisplayDefinition(719, 575, 0, 719, 0, 575);
    private final Paint defaultPaint;
    private final Paint fillRegionPaint;
    private final SubtitleService subtitleService;

    private static final class ClutDefinition {
        public final int[] clutEntries2Bit;
        public final int[] clutEntries4Bit;
        public final int[] clutEntries8Bit;
        public final int id;

        public ClutDefinition(int i5, int[] iArr, int[] iArr2, int[] iArr3) {
            this.id = i5;
            this.clutEntries2Bit = iArr;
            this.clutEntries4Bit = iArr2;
            this.clutEntries8Bit = iArr3;
        }
    }

    private static final class DisplayDefinition {
        public final int height;
        public final int horizontalPositionMaximum;
        public final int horizontalPositionMinimum;
        public final int verticalPositionMaximum;
        public final int verticalPositionMinimum;
        public final int width;

        public DisplayDefinition(int i5, int i6, int i7, int i8, int i9, int i10) {
            this.width = i5;
            this.height = i6;
            this.horizontalPositionMinimum = i7;
            this.horizontalPositionMaximum = i8;
            this.verticalPositionMinimum = i9;
            this.verticalPositionMaximum = i10;
        }
    }

    private static final class ObjectData {
        public final byte[] bottomFieldData;
        public final int id;
        public final boolean nonModifyingColorFlag;
        public final byte[] topFieldData;

        public ObjectData(int i5, boolean z4, byte[] bArr, byte[] bArr2) {
            this.id = i5;
            this.nonModifyingColorFlag = z4;
            this.topFieldData = bArr;
            this.bottomFieldData = bArr2;
        }
    }

    private static final class PageComposition {
        public final SparseArray<PageRegion> regions;
        public final int state;
        public final int timeOutSecs;
        public final int version;

        public PageComposition(int i5, int i6, int i7, SparseArray<PageRegion> sparseArray) {
            this.timeOutSecs = i5;
            this.version = i6;
            this.state = i7;
            this.regions = sparseArray;
        }
    }

    private static final class PageRegion {
        public final int horizontalAddress;
        public final int verticalAddress;

        public PageRegion(int i5, int i6) {
            this.horizontalAddress = i5;
            this.verticalAddress = i6;
        }
    }

    private static final class RegionComposition {
        public final int clutId;
        public final int depth;
        public final boolean fillFlag;
        public final int height;
        public final int id;
        public final int levelOfCompatibility;
        public final int pixelCode2Bit;
        public final int pixelCode4Bit;
        public final int pixelCode8Bit;
        public final SparseArray<RegionObject> regionObjects;
        public final int width;

        public RegionComposition(int i5, boolean z4, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, SparseArray<RegionObject> sparseArray) {
            this.id = i5;
            this.fillFlag = z4;
            this.width = i6;
            this.height = i7;
            this.levelOfCompatibility = i8;
            this.depth = i9;
            this.clutId = i10;
            this.pixelCode8Bit = i11;
            this.pixelCode4Bit = i12;
            this.pixelCode2Bit = i13;
            this.regionObjects = sparseArray;
        }

        public final void mergeFrom(RegionComposition regionComposition) {
            if (regionComposition != null) {
                SparseArray<RegionObject> sparseArray = regionComposition.regionObjects;
                for (int i5 = 0; i5 < sparseArray.size(); i5++) {
                    this.regionObjects.put(sparseArray.keyAt(i5), sparseArray.valueAt(i5));
                }
            }
        }
    }

    private static final class RegionObject {
        public final int backgroundPixelCode;
        public final int foregroundPixelCode;
        public final int horizontalPosition;
        public final int provider;
        public final int type;
        public final int verticalPosition;

        public RegionObject(int i5, int i6, int i7, int i8, int i9, int i10) {
            this.type = i5;
            this.provider = i6;
            this.horizontalPosition = i7;
            this.verticalPosition = i8;
            this.foregroundPixelCode = i9;
            this.backgroundPixelCode = i10;
        }
    }

    private static final class SubtitleService {
        public final SparseArray<ClutDefinition> ancillaryCluts = new SparseArray<>();
        public final SparseArray<ObjectData> ancillaryObjects = new SparseArray<>();
        public final int ancillaryPageId;
        public final SparseArray<ClutDefinition> cluts = new SparseArray<>();
        public DisplayDefinition displayDefinition;
        public final SparseArray<ObjectData> objects = new SparseArray<>();
        public PageComposition pageComposition;
        public final SparseArray<RegionComposition> regions = new SparseArray<>();
        public final int subtitlePageId;

        public SubtitleService(int i5, int i6) {
            this.subtitlePageId = i5;
            this.ancillaryPageId = i6;
        }

        public final void reset() {
            this.regions.clear();
            this.cluts.clear();
            this.objects.clear();
            this.ancillaryCluts.clear();
            this.ancillaryObjects.clear();
            this.displayDefinition = null;
            this.pageComposition = null;
        }
    }

    public DvbParser(int i5, int i6) {
        Paint paint = new Paint();
        this.defaultPaint = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect((PathEffect) null);
        Paint paint2 = new Paint();
        this.fillRegionPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect((PathEffect) null);
        this.subtitleService = new SubtitleService(i5, i6);
    }

    private static byte[] buildClutMapTable(int i5, int i6, ParsableBitArray parsableBitArray) {
        byte[] bArr = new byte[i5];
        for (int i7 = 0; i7 < i5; i7++) {
            bArr[i7] = (byte) parsableBitArray.readBits(i6);
        }
        return bArr;
    }

    private static int[] generateDefault2BitClutEntries() {
        return new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
    }

    private static int[] generateDefault4BitClutEntries() {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i10 = 1; i10 < 16; i10++) {
            if (i10 < 8) {
                if ((i10 & 1) != 0) {
                    i7 = 255;
                } else {
                    i7 = 0;
                }
                if ((i10 & 2) != 0) {
                    i8 = 255;
                } else {
                    i8 = 0;
                }
                if ((i10 & 4) != 0) {
                    i9 = 255;
                } else {
                    i9 = 0;
                }
                iArr[i10] = getColor(255, i7, i8, i9);
            } else {
                int i11 = 127;
                if ((i10 & 1) != 0) {
                    i5 = 127;
                } else {
                    i5 = 0;
                }
                if ((i10 & 2) != 0) {
                    i6 = 127;
                } else {
                    i6 = 0;
                }
                if ((i10 & 4) == 0) {
                    i11 = 0;
                }
                iArr[i10] = getColor(255, i5, i6, i11);
            }
        }
        return iArr;
    }

    private static int[] generateDefault8BitClutEntries() {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i23 = 0; i23 < 256; i23++) {
            int i24 = 255;
            if (i23 < 8) {
                if ((i23 & 1) != 0) {
                    i21 = 255;
                } else {
                    i21 = 0;
                }
                if ((i23 & 2) != 0) {
                    i22 = 255;
                } else {
                    i22 = 0;
                }
                if ((i23 & 4) == 0) {
                    i24 = 0;
                }
                iArr[i23] = getColor(63, i21, i22, i24);
            } else {
                int i25 = i23 & 136;
                int i26 = 170;
                int i27 = 85;
                if (i25 == 0) {
                    if ((i23 & 1) != 0) {
                        i5 = 85;
                    } else {
                        i5 = 0;
                    }
                    if ((i23 & 16) != 0) {
                        i6 = 170;
                    } else {
                        i6 = 0;
                    }
                    int i28 = i5 + i6;
                    if ((i23 & 2) != 0) {
                        i7 = 85;
                    } else {
                        i7 = 0;
                    }
                    if ((i23 & 32) != 0) {
                        i8 = 170;
                    } else {
                        i8 = 0;
                    }
                    int i29 = i7 + i8;
                    if ((i23 & 4) == 0) {
                        i27 = 0;
                    }
                    if ((i23 & 64) == 0) {
                        i26 = 0;
                    }
                    iArr[i23] = getColor(255, i28, i29, i27 + i26);
                } else if (i25 != 8) {
                    int i30 = 43;
                    if (i25 == 128) {
                        if ((i23 & 1) != 0) {
                            i13 = 43;
                        } else {
                            i13 = 0;
                        }
                        int i31 = i13 + 127;
                        if ((i23 & 16) != 0) {
                            i14 = 85;
                        } else {
                            i14 = 0;
                        }
                        int i32 = i31 + i14;
                        if ((i23 & 2) != 0) {
                            i15 = 43;
                        } else {
                            i15 = 0;
                        }
                        int i33 = i15 + 127;
                        if ((i23 & 32) != 0) {
                            i16 = 85;
                        } else {
                            i16 = 0;
                        }
                        int i34 = i33 + i16;
                        if ((i23 & 4) == 0) {
                            i30 = 0;
                        }
                        int i35 = i30 + 127;
                        if ((i23 & 64) == 0) {
                            i27 = 0;
                        }
                        iArr[i23] = getColor(255, i32, i34, i35 + i27);
                    } else if (i25 == 136) {
                        if ((i23 & 1) != 0) {
                            i17 = 43;
                        } else {
                            i17 = 0;
                        }
                        if ((i23 & 16) != 0) {
                            i18 = 85;
                        } else {
                            i18 = 0;
                        }
                        int i36 = i17 + i18;
                        if ((i23 & 2) != 0) {
                            i19 = 43;
                        } else {
                            i19 = 0;
                        }
                        if ((i23 & 32) != 0) {
                            i20 = 85;
                        } else {
                            i20 = 0;
                        }
                        int i37 = i19 + i20;
                        if ((i23 & 4) == 0) {
                            i30 = 0;
                        }
                        if ((i23 & 64) == 0) {
                            i27 = 0;
                        }
                        iArr[i23] = getColor(255, i36, i37, i30 + i27);
                    }
                } else {
                    if ((i23 & 1) != 0) {
                        i9 = 85;
                    } else {
                        i9 = 0;
                    }
                    if ((i23 & 16) != 0) {
                        i10 = 170;
                    } else {
                        i10 = 0;
                    }
                    int i38 = i9 + i10;
                    if ((i23 & 2) != 0) {
                        i11 = 85;
                    } else {
                        i11 = 0;
                    }
                    if ((i23 & 32) != 0) {
                        i12 = 170;
                    } else {
                        i12 = 0;
                    }
                    int i39 = i11 + i12;
                    if ((i23 & 4) == 0) {
                        i27 = 0;
                    }
                    if ((i23 & 64) == 0) {
                        i26 = 0;
                    }
                    iArr[i23] = getColor(127, i38, i39, i27 + i26);
                }
            }
        }
        return iArr;
    }

    private static int getColor(int i5, int i6, int i7, int i8) {
        return (i5 << 24) | (i6 << 16) | (i7 << 8) | i8;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int paint2BitPixelCodeString(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray r9, int[] r10, byte[] r11, int r12, int r13, android.graphics.Paint r14, android.graphics.Canvas r15) {
        /*
            r6 = 0
            r0 = r6
        L_0x0002:
            r1 = 2
            int r2 = r9.readBits(r1)
            r3 = 1
            if (r2 == 0) goto L_0x000d
            r7 = r0
            r8 = r3
            goto L_0x0059
        L_0x000d:
            boolean r2 = r9.readBit()
            r4 = 3
            if (r2 == 0) goto L_0x0021
            int r2 = r9.readBits(r4)
            int r2 = r2 + r4
            int r1 = r9.readBits(r1)
        L_0x001d:
            r7 = r0
            r8 = r2
            r2 = r1
            goto L_0x0059
        L_0x0021:
            boolean r2 = r9.readBit()
            if (r2 == 0) goto L_0x002b
            r7 = r0
            r8 = r3
        L_0x0029:
            r2 = r6
            goto L_0x0059
        L_0x002b:
            int r2 = r9.readBits(r1)
            if (r2 == 0) goto L_0x0057
            if (r2 == r3) goto L_0x0054
            if (r2 == r1) goto L_0x0048
            if (r2 == r4) goto L_0x003b
            r7 = r0
        L_0x0038:
            r2 = r6
            r8 = r2
            goto L_0x0059
        L_0x003b:
            r2 = 8
            int r2 = r9.readBits(r2)
            int r2 = r2 + 29
            int r1 = r9.readBits(r1)
            goto L_0x001d
        L_0x0048:
            r2 = 4
            int r2 = r9.readBits(r2)
            int r2 = r2 + 12
            int r1 = r9.readBits(r1)
            goto L_0x001d
        L_0x0054:
            r7 = r0
            r8 = r1
            goto L_0x0029
        L_0x0057:
            r7 = r3
            goto L_0x0038
        L_0x0059:
            if (r8 == 0) goto L_0x0073
            if (r14 == 0) goto L_0x0073
            if (r11 == 0) goto L_0x0061
            byte r2 = r11[r2]
        L_0x0061:
            r0 = r10[r2]
            r14.setColor(r0)
            float r1 = (float) r12
            float r2 = (float) r13
            int r0 = r12 + r8
            float r0 = (float) r0
            int r3 = r3 + r13
            float r4 = (float) r3
            r5 = r14
            r3 = r0
            r0 = r15
            r0.drawRect(r1, r2, r3, r4, r5)
        L_0x0073:
            int r12 = r12 + r8
            if (r7 == 0) goto L_0x0077
            return r12
        L_0x0077:
            r0 = r7
            goto L_0x0002
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.text.dvb.DvbParser.paint2BitPixelCodeString(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int paint4BitPixelCodeString(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray r9, int[] r10, byte[] r11, int r12, int r13, android.graphics.Paint r14, android.graphics.Canvas r15) {
        /*
            r6 = 0
            r0 = r6
        L_0x0002:
            r1 = 4
            int r2 = r9.readBits(r1)
            r3 = 1
            if (r2 == 0) goto L_0x000e
            r7 = r0
            r8 = r3
            goto L_0x0066
        L_0x000e:
            boolean r2 = r9.readBit()
            r4 = 3
            if (r2 != 0) goto L_0x0025
            int r1 = r9.readBits(r4)
            if (r1 == 0) goto L_0x0021
            int r1 = r1 + 2
            r7 = r0
            r8 = r1
        L_0x001f:
            r2 = r6
            goto L_0x0066
        L_0x0021:
            r7 = r3
        L_0x0022:
            r2 = r6
            r8 = r2
            goto L_0x0066
        L_0x0025:
            boolean r2 = r9.readBit()
            r7 = 2
            if (r2 != 0) goto L_0x0039
            int r2 = r9.readBits(r7)
            int r2 = r2 + r1
            int r1 = r9.readBits(r1)
        L_0x0035:
            r7 = r0
            r8 = r2
            r2 = r1
            goto L_0x0066
        L_0x0039:
            int r2 = r9.readBits(r7)
            if (r2 == 0) goto L_0x0063
            if (r2 == r3) goto L_0x005f
            if (r2 == r7) goto L_0x0054
            if (r2 == r4) goto L_0x0047
            r7 = r0
            goto L_0x0022
        L_0x0047:
            r2 = 8
            int r2 = r9.readBits(r2)
            int r2 = r2 + 25
            int r1 = r9.readBits(r1)
            goto L_0x0035
        L_0x0054:
            int r2 = r9.readBits(r1)
            int r2 = r2 + 9
            int r1 = r9.readBits(r1)
            goto L_0x0035
        L_0x005f:
            r2 = r6
            r8 = r7
            r7 = r0
            goto L_0x0066
        L_0x0063:
            r7 = r0
            r8 = r3
            goto L_0x001f
        L_0x0066:
            if (r8 == 0) goto L_0x0080
            if (r14 == 0) goto L_0x0080
            if (r11 == 0) goto L_0x006e
            byte r2 = r11[r2]
        L_0x006e:
            r0 = r10[r2]
            r14.setColor(r0)
            float r1 = (float) r12
            float r2 = (float) r13
            int r0 = r12 + r8
            float r0 = (float) r0
            int r3 = r3 + r13
            float r4 = (float) r3
            r5 = r14
            r3 = r0
            r0 = r15
            r0.drawRect(r1, r2, r3, r4, r5)
        L_0x0080:
            int r12 = r12 + r8
            if (r7 == 0) goto L_0x0084
            return r12
        L_0x0084:
            r0 = r7
            goto L_0x0002
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.text.dvb.DvbParser.paint4BitPixelCodeString(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int paint8BitPixelCodeString(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray r9, int[] r10, byte[] r11, int r12, int r13, android.graphics.Paint r14, android.graphics.Canvas r15) {
        /*
            r6 = 0
            r0 = r6
        L_0x0002:
            r1 = 8
            int r2 = r9.readBits(r1)
            r3 = 1
            if (r2 == 0) goto L_0x000e
            r7 = r0
            r8 = r3
            goto L_0x002e
        L_0x000e:
            boolean r2 = r9.readBit()
            r4 = 7
            if (r2 != 0) goto L_0x0023
            int r1 = r9.readBits(r4)
            if (r1 == 0) goto L_0x001f
            r7 = r0
            r8 = r1
            r2 = r6
            goto L_0x002e
        L_0x001f:
            r7 = r3
            r2 = r6
            r8 = r2
            goto L_0x002e
        L_0x0023:
            int r2 = r9.readBits(r4)
            int r1 = r9.readBits(r1)
            r7 = r0
            r8 = r2
            r2 = r1
        L_0x002e:
            if (r8 == 0) goto L_0x0048
            if (r14 == 0) goto L_0x0048
            if (r11 == 0) goto L_0x0036
            byte r2 = r11[r2]
        L_0x0036:
            r0 = r10[r2]
            r14.setColor(r0)
            float r1 = (float) r12
            float r2 = (float) r13
            int r0 = r12 + r8
            float r0 = (float) r0
            int r3 = r3 + r13
            float r4 = (float) r3
            r5 = r14
            r3 = r0
            r0 = r15
            r0.drawRect(r1, r2, r3, r4, r5)
        L_0x0048:
            int r12 = r12 + r8
            if (r7 == 0) goto L_0x004c
            return r12
        L_0x004c:
            r0 = r7
            goto L_0x0002
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.text.dvb.DvbParser.paint8BitPixelCodeString(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    private static void paintPixelDataSubBlock(byte[] bArr, int[] iArr, int i5, int i6, int i7, Paint paint, Canvas canvas2) {
        Canvas canvas3;
        Paint paint2;
        int[] iArr2;
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        byte[] bArr5 = null;
        int i8 = i6;
        int i9 = i7;
        byte[] bArr6 = null;
        while (parsableBitArray.bitsLeft() != 0) {
            int readBits = parsableBitArray.readBits(8);
            if (readBits != 240) {
                switch (readBits) {
                    case 16:
                        iArr2 = iArr;
                        Paint paint3 = paint;
                        canvas3 = canvas2;
                        if (i5 != 3) {
                            if (i5 != 2) {
                                bArr2 = null;
                                paint2 = paint3;
                                i8 = paint2BitPixelCodeString(parsableBitArray, iArr2, bArr2, i8, i9, paint2, canvas3);
                                parsableBitArray.byteAlign();
                                break;
                            } else if (bArr5 == null) {
                                bArr3 = defaultMap2To4;
                            } else {
                                bArr3 = bArr5;
                            }
                        } else if (bArr6 == null) {
                            bArr3 = defaultMap2To8;
                        } else {
                            bArr3 = bArr6;
                        }
                        paint2 = paint3;
                        bArr2 = bArr3;
                        i8 = paint2BitPixelCodeString(parsableBitArray, iArr2, bArr2, i8, i9, paint2, canvas3);
                        parsableBitArray.byteAlign();
                    case 17:
                        iArr2 = iArr;
                        Paint paint4 = paint;
                        canvas3 = canvas2;
                        if (i5 == 3) {
                            bArr4 = defaultMap4To8;
                        } else {
                            bArr4 = null;
                        }
                        paint2 = paint4;
                        i8 = paint4BitPixelCodeString(parsableBitArray, iArr2, bArr4, i8, i9, paint2, canvas3);
                        Paint paint5 = paint2;
                        parsableBitArray.byteAlign();
                        break;
                    case 18:
                        iArr2 = iArr;
                        paint2 = paint;
                        canvas3 = canvas2;
                        i8 = paint8BitPixelCodeString(parsableBitArray, iArr2, (byte[]) null, i8, i9, paint2, canvas3);
                        break;
                    default:
                        switch (readBits) {
                            case 32:
                                bArr5 = buildClutMapTable(4, 4, parsableBitArray);
                                break;
                            case 33:
                                bArr6 = buildClutMapTable(4, 8, parsableBitArray);
                                break;
                            case 34:
                                bArr6 = buildClutMapTable(16, 8, parsableBitArray);
                                break;
                        }
                        iArr2 = iArr;
                        paint2 = paint;
                        canvas3 = canvas2;
                        break;
                }
            } else {
                iArr2 = iArr;
                paint2 = paint;
                canvas3 = canvas2;
                i9 += 2;
                i8 = i6;
            }
            iArr = iArr2;
            paint = paint2;
            canvas2 = canvas3;
        }
    }

    private static void paintPixelDataSubBlocks(ObjectData objectData, ClutDefinition clutDefinition, int i5, int i6, int i7, Paint paint, Canvas canvas2) {
        int[] iArr;
        if (i5 == 3) {
            iArr = clutDefinition.clutEntries8Bit;
        } else if (i5 == 2) {
            iArr = clutDefinition.clutEntries4Bit;
        } else {
            iArr = clutDefinition.clutEntries2Bit;
        }
        int[] iArr2 = iArr;
        int i8 = i5;
        int i9 = i6;
        int i10 = i7;
        Paint paint2 = paint;
        Canvas canvas3 = canvas2;
        paintPixelDataSubBlock(objectData.topFieldData, iArr2, i8, i9, i10, paint2, canvas3);
        paintPixelDataSubBlock(objectData.bottomFieldData, iArr2, i8, i9, i10 + 1, paint2, canvas3);
    }

    private static ClutDefinition parseClutDefinition(ParsableBitArray parsableBitArray, int i5) {
        int[] iArr;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        ParsableBitArray parsableBitArray2 = parsableBitArray;
        int i11 = 8;
        int readBits = parsableBitArray2.readBits(8);
        parsableBitArray2.skipBits(8);
        int i12 = 2;
        int i13 = i5 - 2;
        int[] generateDefault2BitClutEntries = generateDefault2BitClutEntries();
        int[] generateDefault4BitClutEntries = generateDefault4BitClutEntries();
        int[] generateDefault8BitClutEntries = generateDefault8BitClutEntries();
        while (i13 > 0) {
            int readBits2 = parsableBitArray2.readBits(i11);
            int readBits3 = parsableBitArray2.readBits(i11);
            if ((readBits3 & 128) != 0) {
                iArr = generateDefault2BitClutEntries;
            } else if ((readBits3 & 64) != 0) {
                iArr = generateDefault4BitClutEntries;
            } else {
                iArr = generateDefault8BitClutEntries;
            }
            if ((readBits3 & 1) != 0) {
                i9 = parsableBitArray2.readBits(i11);
                i8 = parsableBitArray2.readBits(i11);
                i7 = parsableBitArray2.readBits(i11);
                i6 = parsableBitArray2.readBits(i11);
                i10 = i13 - 6;
            } else {
                i7 = parsableBitArray2.readBits(4) << 4;
                i10 = i13 - 4;
                int readBits4 = parsableBitArray2.readBits(4) << 4;
                i6 = parsableBitArray2.readBits(i12) << 6;
                i9 = parsableBitArray2.readBits(6) << i12;
                i8 = readBits4;
            }
            if (i9 == 0) {
                i6 = 255;
                i8 = 0;
                i7 = 0;
            }
            double d5 = (double) i9;
            double d6 = (double) (i8 + WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT);
            double d7 = (double) (i7 + WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT);
            iArr[readBits2] = getColor((byte) (255 - (i6 & 255)), Util.constrainValue((int) (d5 + (1.402d * d6)), 0, 255), Util.constrainValue((int) ((d5 - (0.34414d * d7)) - (d6 * 0.71414d)), 0, 255), Util.constrainValue((int) (d5 + (d7 * 1.772d)), 0, 255));
            i13 = i10;
            readBits = readBits;
            i11 = 8;
            i12 = 2;
        }
        return new ClutDefinition(readBits, generateDefault2BitClutEntries, generateDefault4BitClutEntries, generateDefault8BitClutEntries);
    }

    private static DisplayDefinition parseDisplayDefinition(ParsableBitArray parsableBitArray) {
        int i5;
        int i6;
        int i7;
        int i8;
        parsableBitArray.skipBits(4);
        boolean readBit = parsableBitArray.readBit();
        parsableBitArray.skipBits(3);
        int readBits = parsableBitArray.readBits(16);
        int readBits2 = parsableBitArray.readBits(16);
        if (readBit) {
            int readBits3 = parsableBitArray.readBits(16);
            int readBits4 = parsableBitArray.readBits(16);
            int readBits5 = parsableBitArray.readBits(16);
            i5 = parsableBitArray.readBits(16);
            i7 = readBits4;
            i6 = readBits5;
            i8 = readBits3;
        } else {
            i8 = 0;
            i6 = 0;
            i7 = readBits;
            i5 = readBits2;
        }
        return new DisplayDefinition(readBits, readBits2, i8, i7, i6, i5);
    }

    private static ObjectData parseObjectData(ParsableBitArray parsableBitArray) {
        byte[] bArr;
        int readBits = parsableBitArray.readBits(16);
        parsableBitArray.skipBits(4);
        int readBits2 = parsableBitArray.readBits(2);
        boolean readBit = parsableBitArray.readBit();
        parsableBitArray.skipBits(1);
        byte[] bArr2 = null;
        if (readBits2 == 1) {
            parsableBitArray.skipBits(parsableBitArray.readBits(8) * 16);
        } else if (readBits2 == 0) {
            int readBits3 = parsableBitArray.readBits(16);
            int readBits4 = parsableBitArray.readBits(16);
            if (readBits3 > 0) {
                bArr2 = new byte[readBits3];
                parsableBitArray.readBytes(bArr2, 0, readBits3);
            }
            if (readBits4 > 0) {
                bArr = new byte[readBits4];
                parsableBitArray.readBytes(bArr, 0, readBits4);
                return new ObjectData(readBits, readBit, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new ObjectData(readBits, readBit, bArr2, bArr);
    }

    private static PageComposition parsePageComposition(ParsableBitArray parsableBitArray, int i5) {
        int readBits = parsableBitArray.readBits(8);
        int readBits2 = parsableBitArray.readBits(4);
        int readBits3 = parsableBitArray.readBits(2);
        parsableBitArray.skipBits(2);
        int i6 = i5 - 2;
        SparseArray sparseArray = new SparseArray();
        while (i6 > 0) {
            int readBits4 = parsableBitArray.readBits(8);
            parsableBitArray.skipBits(8);
            i6 -= 6;
            sparseArray.put(readBits4, new PageRegion(parsableBitArray.readBits(16), parsableBitArray.readBits(16)));
        }
        return new PageComposition(readBits, readBits2, readBits3, sparseArray);
    }

    private static RegionComposition parseRegionComposition(ParsableBitArray parsableBitArray, int i5) {
        int i6;
        int i7;
        char c5;
        int i8;
        ParsableBitArray parsableBitArray2 = parsableBitArray;
        int readBits = parsableBitArray2.readBits(8);
        int i9 = 4;
        parsableBitArray2.skipBits(4);
        boolean readBit = parsableBitArray2.readBit();
        parsableBitArray2.skipBits(3);
        int i10 = 16;
        int readBits2 = parsableBitArray2.readBits(16);
        int readBits3 = parsableBitArray2.readBits(16);
        int i11 = readBits2;
        int readBits4 = parsableBitArray2.readBits(3);
        int readBits5 = parsableBitArray2.readBits(3);
        int i12 = 2;
        parsableBitArray2.skipBits(2);
        int i13 = readBits3;
        int i14 = readBits5;
        int i15 = i11;
        int readBits6 = parsableBitArray2.readBits(8);
        int readBits7 = parsableBitArray2.readBits(8);
        int i16 = i13;
        int readBits8 = parsableBitArray2.readBits(4);
        int i17 = readBits7;
        int readBits9 = parsableBitArray2.readBits(2);
        parsableBitArray2.skipBits(2);
        int i18 = i5 - 10;
        int i19 = i16;
        SparseArray sparseArray = new SparseArray();
        while (i18 > 0) {
            int readBits10 = parsableBitArray2.readBits(i10);
            int readBits11 = parsableBitArray2.readBits(i12);
            int readBits12 = parsableBitArray2.readBits(i12);
            int readBits13 = parsableBitArray2.readBits(12);
            parsableBitArray2.skipBits(i9);
            int readBits14 = parsableBitArray2.readBits(12);
            int i20 = i18 - 6;
            if (readBits11 != 1) {
                i8 = 2;
                if (readBits11 != 2) {
                    i7 = 0;
                    i6 = 0;
                    i18 = i20;
                    c5 = 8;
                    sparseArray.put(readBits10, new RegionObject(readBits11, readBits12, readBits13, readBits14, i7, i6));
                    char c6 = c5;
                    i10 = 16;
                    i12 = i8;
                    i9 = 4;
                }
            } else {
                i8 = 2;
            }
            c5 = 8;
            i18 -= 8;
            i7 = parsableBitArray2.readBits(8);
            i6 = parsableBitArray2.readBits(8);
            sparseArray.put(readBits10, new RegionObject(readBits11, readBits12, readBits13, readBits14, i7, i6));
            char c62 = c5;
            i10 = 16;
            i12 = i8;
            i9 = 4;
        }
        return new RegionComposition(readBits, readBit, i15, i19, readBits4, i14, readBits6, i17, readBits8, readBits9, sparseArray);
    }

    private static void parseSubtitlingSegment(ParsableBitArray parsableBitArray, SubtitleService subtitleService2) {
        int readBits = parsableBitArray.readBits(8);
        int readBits2 = parsableBitArray.readBits(16);
        int readBits3 = parsableBitArray.readBits(16);
        int bytePosition = parsableBitArray.getBytePosition() + readBits3;
        if (readBits3 * 8 > parsableBitArray.bitsLeft()) {
            Log.w(TAG, "Data field length exceeds limit");
            parsableBitArray.skipBits(parsableBitArray.bitsLeft());
            return;
        }
        switch (readBits) {
            case 16:
                if (readBits2 == subtitleService2.subtitlePageId) {
                    PageComposition pageComposition = subtitleService2.pageComposition;
                    PageComposition parsePageComposition = parsePageComposition(parsableBitArray, readBits3);
                    if (parsePageComposition.state == 0) {
                        if (!(pageComposition == null || pageComposition.version == parsePageComposition.version)) {
                            subtitleService2.pageComposition = parsePageComposition;
                            break;
                        }
                    } else {
                        subtitleService2.pageComposition = parsePageComposition;
                        subtitleService2.regions.clear();
                        subtitleService2.cluts.clear();
                        subtitleService2.objects.clear();
                        break;
                    }
                }
                break;
            case 17:
                PageComposition pageComposition2 = subtitleService2.pageComposition;
                if (readBits2 == subtitleService2.subtitlePageId && pageComposition2 != null) {
                    RegionComposition parseRegionComposition = parseRegionComposition(parsableBitArray, readBits3);
                    if (pageComposition2.state == 0) {
                        parseRegionComposition.mergeFrom(subtitleService2.regions.get(parseRegionComposition.id));
                    }
                    subtitleService2.regions.put(parseRegionComposition.id, parseRegionComposition);
                    break;
                }
            case 18:
                if (readBits2 != subtitleService2.subtitlePageId) {
                    if (readBits2 == subtitleService2.ancillaryPageId) {
                        ClutDefinition parseClutDefinition = parseClutDefinition(parsableBitArray, readBits3);
                        subtitleService2.ancillaryCluts.put(parseClutDefinition.id, parseClutDefinition);
                        break;
                    }
                } else {
                    ClutDefinition parseClutDefinition2 = parseClutDefinition(parsableBitArray, readBits3);
                    subtitleService2.cluts.put(parseClutDefinition2.id, parseClutDefinition2);
                    break;
                }
                break;
            case 19:
                if (readBits2 != subtitleService2.subtitlePageId) {
                    if (readBits2 == subtitleService2.ancillaryPageId) {
                        ObjectData parseObjectData = parseObjectData(parsableBitArray);
                        subtitleService2.ancillaryObjects.put(parseObjectData.id, parseObjectData);
                        break;
                    }
                } else {
                    ObjectData parseObjectData2 = parseObjectData(parsableBitArray);
                    subtitleService2.objects.put(parseObjectData2.id, parseObjectData2);
                    break;
                }
                break;
            case 20:
                if (readBits2 == subtitleService2.subtitlePageId) {
                    subtitleService2.displayDefinition = parseDisplayDefinition(parsableBitArray);
                    break;
                }
                break;
        }
        parsableBitArray.skipBytes(bytePosition - parsableBitArray.getBytePosition());
    }

    public final List<Cue> decode(byte[] bArr, int i5) {
        int i6;
        Paint paint;
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr, i5);
        while (parsableBitArray.bitsLeft() >= 48 && parsableBitArray.readBits(8) == 15) {
            parseSubtitlingSegment(parsableBitArray, this.subtitleService);
        }
        SubtitleService subtitleService2 = this.subtitleService;
        if (subtitleService2.pageComposition == null) {
            return Collections.EMPTY_LIST;
        }
        DisplayDefinition displayDefinition = subtitleService2.displayDefinition;
        if (displayDefinition == null) {
            displayDefinition = this.defaultDisplayDefinition;
        }
        Bitmap bitmap2 = this.bitmap;
        if (!(bitmap2 != null && displayDefinition.width + 1 == bitmap2.getWidth() && displayDefinition.height + 1 == this.bitmap.getHeight())) {
            Bitmap createBitmap = Bitmap.createBitmap(displayDefinition.width + 1, displayDefinition.height + 1, Bitmap.Config.ARGB_8888);
            this.bitmap = createBitmap;
            this.canvas.setBitmap(createBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<PageRegion> sparseArray = this.subtitleService.pageComposition.regions;
        for (int i7 = 0; i7 < sparseArray.size(); i7++) {
            PageRegion valueAt = sparseArray.valueAt(i7);
            RegionComposition regionComposition = this.subtitleService.regions.get(sparseArray.keyAt(i7));
            int i8 = valueAt.horizontalAddress + displayDefinition.horizontalPositionMinimum;
            int i9 = valueAt.verticalAddress + displayDefinition.verticalPositionMinimum;
            int min = Math.min(regionComposition.width + i8, displayDefinition.horizontalPositionMaximum);
            float f5 = (float) i8;
            float f6 = (float) i9;
            float f7 = (float) min;
            this.canvas.clipRect(f5, f6, f7, (float) Math.min(regionComposition.height + i9, displayDefinition.verticalPositionMaximum), Region.Op.REPLACE);
            float f8 = f6;
            float f9 = f5;
            ClutDefinition clutDefinition = this.subtitleService.cluts.get(regionComposition.clutId);
            if (clutDefinition == null && (clutDefinition = this.subtitleService.ancillaryCluts.get(regionComposition.clutId)) == null) {
                clutDefinition = this.defaultClutDefinition;
            }
            ClutDefinition clutDefinition2 = clutDefinition;
            SparseArray<RegionObject> sparseArray2 = regionComposition.regionObjects;
            int i10 = 0;
            while (i10 < sparseArray2.size()) {
                int keyAt = sparseArray2.keyAt(i10);
                RegionObject valueAt2 = sparseArray2.valueAt(i10);
                ObjectData objectData = this.subtitleService.objects.get(keyAt);
                if (objectData == null) {
                    objectData = this.subtitleService.ancillaryObjects.get(keyAt);
                }
                if (objectData != null) {
                    if (objectData.nonModifyingColorFlag) {
                        paint = null;
                    } else {
                        paint = this.defaultPaint;
                    }
                    Paint paint2 = paint;
                    paintPixelDataSubBlocks(objectData, clutDefinition2, regionComposition.depth, i8 + valueAt2.horizontalPosition, i9 + valueAt2.verticalPosition, paint2, this.canvas);
                }
                i10++;
                clutDefinition2 = clutDefinition2;
            }
            ClutDefinition clutDefinition3 = clutDefinition2;
            if (regionComposition.fillFlag) {
                int i11 = regionComposition.depth;
                if (i11 == 3) {
                    i6 = clutDefinition3.clutEntries8Bit[regionComposition.pixelCode8Bit];
                } else if (i11 == 2) {
                    i6 = clutDefinition3.clutEntries4Bit[regionComposition.pixelCode4Bit];
                } else {
                    i6 = clutDefinition3.clutEntries2Bit[regionComposition.pixelCode2Bit];
                }
                this.fillRegionPaint.setColor(i6);
                this.canvas.drawRect(f9, f8, (float) (regionComposition.width + i8), (float) (regionComposition.height + i9), this.fillRegionPaint);
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(this.bitmap, i8, i9, regionComposition.width, regionComposition.height);
            int i12 = displayDefinition.width;
            int i13 = displayDefinition.height;
            arrayList.add(new Cue(createBitmap2, f9 / ((float) i12), 0, f8 / ((float) i13), 0, ((float) regionComposition.width) / ((float) i12), ((float) regionComposition.height) / ((float) i13)));
            this.canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        return arrayList;
    }

    public final void reset() {
        this.subtitleService.reset();
    }
}
