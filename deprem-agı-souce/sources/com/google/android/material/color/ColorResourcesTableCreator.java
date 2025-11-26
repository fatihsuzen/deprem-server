package com.google.android.material.color;

import android.content.Context;
import android.util.Pair;
import androidx.annotation.ColorInt;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class ColorResourcesTableCreator {
    private static final byte ANDROID_PACKAGE_ID = 1;
    private static final PackageInfo ANDROID_PACKAGE_INFO = new PackageInfo(1, "android");
    private static final byte APPLICATION_PACKAGE_ID = Byte.MAX_VALUE;
    /* access modifiers changed from: private */
    public static final Comparator<ColorResource> COLOR_RESOURCE_COMPARATOR = new Comparator<ColorResource>() {
        public int compare(ColorResource colorResource, ColorResource colorResource2) {
            return colorResource.entryId - colorResource2.entryId;
        }
    };
    private static final short HEADER_TYPE_PACKAGE = 512;
    private static final short HEADER_TYPE_RES_TABLE = 2;
    private static final short HEADER_TYPE_STRING_POOL = 1;
    private static final short HEADER_TYPE_TYPE = 513;
    private static final short HEADER_TYPE_TYPE_SPEC = 514;
    private static final String RESOURCE_TYPE_NAME_COLOR = "color";
    /* access modifiers changed from: private */
    public static byte typeIdColor;

    static class ColorResource {
        /* access modifiers changed from: private */
        public final short entryId;
        /* access modifiers changed from: private */
        public final String name;
        /* access modifiers changed from: private */
        public final byte packageId;
        /* access modifiers changed from: private */
        public final byte typeId;
        /* access modifiers changed from: private */
        @ColorInt
        public final int value;

        ColorResource(int i5, String str, int i6) {
            this.name = str;
            this.value = i6;
            this.entryId = (short) (65535 & i5);
            this.typeId = (byte) ((i5 >> 16) & 255);
            this.packageId = (byte) ((i5 >> 24) & 255);
        }
    }

    private static class PackageChunk {
        private static final short HEADER_SIZE = 288;
        private static final int PACKAGE_NAME_MAX_LENGTH = 128;
        private final ResChunkHeader header = new ResChunkHeader(ColorResourcesTableCreator.HEADER_TYPE_PACKAGE, HEADER_SIZE, getChunkSize());
        private final StringPoolChunk keyStrings;
        private final PackageInfo packageInfo;
        private final TypeSpecChunk typeSpecChunk;
        private final StringPoolChunk typeStrings;

        PackageChunk(PackageInfo packageInfo2, List<ColorResource> list) {
            this.packageInfo = packageInfo2;
            this.typeStrings = new StringPoolChunk(false, generateTypeStrings(list));
            this.keyStrings = new StringPoolChunk(true, generateKeyStrings(list));
            this.typeSpecChunk = new TypeSpecChunk(list);
        }

        private String[] generateKeyStrings(List<ColorResource> list) {
            String[] strArr = new String[list.size()];
            for (int i5 = 0; i5 < list.size(); i5++) {
                strArr[i5] = list.get(i5).name;
            }
            return strArr;
        }

        private String[] generateTypeStrings(List<ColorResource> list) {
            int i5 = 0;
            if (list.isEmpty()) {
                return new String[0];
            }
            int access$200 = list.get(0).typeId;
            String[] strArr = new String[access$200];
            while (true) {
                int i6 = access$200 - 1;
                if (i5 < i6) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("?");
                    int i7 = i5 + 1;
                    sb.append(i7);
                    strArr[i5] = sb.toString();
                    i5 = i7;
                } else {
                    strArr[i6] = "color";
                    return strArr;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int getChunkSize() {
            return this.typeStrings.getChunkSize() + 288 + this.keyStrings.getChunkSize() + this.typeSpecChunk.getChunkSizeWithTypeChunk();
        }

        /* access modifiers changed from: package-private */
        public void writeTo(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.header.writeTo(byteArrayOutputStream);
            byteArrayOutputStream.write(ColorResourcesTableCreator.intToByteArray(this.packageInfo.id));
            char[] charArray = this.packageInfo.name.toCharArray();
            for (int i5 = 0; i5 < 128; i5++) {
                if (i5 < charArray.length) {
                    byteArrayOutputStream.write(ColorResourcesTableCreator.charToByteArray(charArray[i5]));
                } else {
                    byteArrayOutputStream.write(ColorResourcesTableCreator.charToByteArray(0));
                }
            }
            byteArrayOutputStream.write(ColorResourcesTableCreator.intToByteArray(288));
            byteArrayOutputStream.write(ColorResourcesTableCreator.intToByteArray(0));
            byteArrayOutputStream.write(ColorResourcesTableCreator.intToByteArray(this.typeStrings.getChunkSize() + 288));
            byteArrayOutputStream.write(ColorResourcesTableCreator.intToByteArray(0));
            byteArrayOutputStream.write(ColorResourcesTableCreator.intToByteArray(0));
            this.typeStrings.writeTo(byteArrayOutputStream);
            this.keyStrings.writeTo(byteArrayOutputStream);
            this.typeSpecChunk.writeTo(byteArrayOutputStream);
        }
    }

    static class PackageInfo {
        /* access modifiers changed from: private */
        public final int id;
        /* access modifiers changed from: private */
        public final String name;

        PackageInfo(int i5, String str) {
            this.id = i5;
            this.name = str;
        }
    }

    private static class ResChunkHeader {
        private final int chunkSize;
        private final short headerSize;
        private final short type;

        ResChunkHeader(short s5, short s6, int i5) {
            this.type = s5;
            this.headerSize = s6;
            this.chunkSize = i5;
        }

        /* access modifiers changed from: package-private */
        public void writeTo(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            byteArrayOutputStream.write(ColorResourcesTableCreator.shortToByteArray(this.type));
            byteArrayOutputStream.write(ColorResourcesTableCreator.shortToByteArray(this.headerSize));
            byteArrayOutputStream.write(ColorResourcesTableCreator.intToByteArray(this.chunkSize));
        }
    }

    private static class ResEntry {
        private static final byte DATA_TYPE_AARRGGBB = 28;
        private static final short ENTRY_SIZE = 8;
        private static final short FLAG_PUBLIC = 2;
        private static final int SIZE = 16;
        private static final short VALUE_SIZE = 8;
        private final int data;
        private final int keyStringIndex;

        ResEntry(int i5, @ColorInt int i6) {
            this.keyStringIndex = i5;
            this.data = i6;
        }

        /* access modifiers changed from: package-private */
        public void writeTo(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            byteArrayOutputStream.write(ColorResourcesTableCreator.shortToByteArray(8));
            byteArrayOutputStream.write(ColorResourcesTableCreator.shortToByteArray(2));
            byteArrayOutputStream.write(ColorResourcesTableCreator.intToByteArray(this.keyStringIndex));
            byteArrayOutputStream.write(ColorResourcesTableCreator.shortToByteArray(8));
            byteArrayOutputStream.write(new byte[]{0, DATA_TYPE_AARRGGBB});
            byteArrayOutputStream.write(ColorResourcesTableCreator.intToByteArray(this.data));
        }
    }

    private static class ResTable {
        private static final short HEADER_SIZE = 12;
        private final ResChunkHeader header;
        private final List<PackageChunk> packageChunks = new ArrayList();
        private final int packageCount;
        private final StringPoolChunk stringPool;

        ResTable(Map<PackageInfo, List<ColorResource>> map) {
            this.packageCount = map.size();
            this.stringPool = new StringPoolChunk(new String[0]);
            for (Map.Entry next : map.entrySet()) {
                List list = (List) next.getValue();
                Collections.sort(list, ColorResourcesTableCreator.COLOR_RESOURCE_COMPARATOR);
                this.packageChunks.add(new PackageChunk((PackageInfo) next.getKey(), list));
            }
            this.header = new ResChunkHeader(2, 12, getOverallSize());
        }

        private int getOverallSize() {
            int i5 = 0;
            for (PackageChunk chunkSize : this.packageChunks) {
                i5 += chunkSize.getChunkSize();
            }
            return this.stringPool.getChunkSize() + 12 + i5;
        }

        /* access modifiers changed from: package-private */
        public void writeTo(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.header.writeTo(byteArrayOutputStream);
            byteArrayOutputStream.write(ColorResourcesTableCreator.intToByteArray(this.packageCount));
            this.stringPool.writeTo(byteArrayOutputStream);
            for (PackageChunk writeTo : this.packageChunks) {
                writeTo.writeTo(byteArrayOutputStream);
            }
        }
    }

    private static class StringPoolChunk {
        private static final int FLAG_UTF8 = 256;
        private static final short HEADER_SIZE = 28;
        private static final int STYLED_SPAN_LIST_END = -1;
        private final int chunkSize;
        private final ResChunkHeader header;
        private final int stringCount;
        private final List<Integer> stringIndex;
        private final List<byte[]> strings;
        private final int stringsPaddingSize;
        private final int stringsStart;
        private final int styledSpanCount;
        private final List<Integer> styledSpanIndex;
        private final List<List<StringStyledSpan>> styledSpans;
        private final int styledSpansStart;
        private final boolean utf8Encode;

        StringPoolChunk(String... strArr) {
            this(false, strArr);
        }

        private Pair<byte[], List<StringStyledSpan>> processString(String str) {
            byte[] bArr;
            if (this.utf8Encode) {
                bArr = ColorResourcesTableCreator.stringToByteArrayUtf8(str);
            } else {
                bArr = ColorResourcesTableCreator.stringToByteArray(str);
            }
            return new Pair<>(bArr, Collections.EMPTY_LIST);
        }

        /* access modifiers changed from: package-private */
        public int getChunkSize() {
            return this.chunkSize;
        }

        /* access modifiers changed from: package-private */
        public void writeTo(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            int i5;
            this.header.writeTo(byteArrayOutputStream);
            byteArrayOutputStream.write(ColorResourcesTableCreator.intToByteArray(this.stringCount));
            byteArrayOutputStream.write(ColorResourcesTableCreator.intToByteArray(this.styledSpanCount));
            if (this.utf8Encode) {
                i5 = 256;
            } else {
                i5 = 0;
            }
            byteArrayOutputStream.write(ColorResourcesTableCreator.intToByteArray(i5));
            byteArrayOutputStream.write(ColorResourcesTableCreator.intToByteArray(this.stringsStart));
            byteArrayOutputStream.write(ColorResourcesTableCreator.intToByteArray(this.styledSpansStart));
            for (Integer intValue : this.stringIndex) {
                byteArrayOutputStream.write(ColorResourcesTableCreator.intToByteArray(intValue.intValue()));
            }
            for (Integer intValue2 : this.styledSpanIndex) {
                byteArrayOutputStream.write(ColorResourcesTableCreator.intToByteArray(intValue2.intValue()));
            }
            for (byte[] write : this.strings) {
                byteArrayOutputStream.write(write);
            }
            int i6 = this.stringsPaddingSize;
            if (i6 > 0) {
                byteArrayOutputStream.write(new byte[i6]);
            }
            for (List<StringStyledSpan> it : this.styledSpans) {
                for (StringStyledSpan writeTo : it) {
                    writeTo.writeTo(byteArrayOutputStream);
                }
                byteArrayOutputStream.write(ColorResourcesTableCreator.intToByteArray(-1));
            }
        }

        StringPoolChunk(boolean z4, String... strArr) {
            this.stringIndex = new ArrayList();
            this.styledSpanIndex = new ArrayList();
            this.strings = new ArrayList();
            this.styledSpans = new ArrayList();
            this.utf8Encode = z4;
            int i5 = 0;
            int i6 = 0;
            for (String processString : strArr) {
                Pair<byte[], List<StringStyledSpan>> processString2 = processString(processString);
                this.stringIndex.add(Integer.valueOf(i6));
                Object obj = processString2.first;
                i6 += ((byte[]) obj).length;
                this.strings.add((byte[]) obj);
                this.styledSpans.add((List) processString2.second);
            }
            int i7 = 0;
            for (List<StringStyledSpan> next : this.styledSpans) {
                for (StringStyledSpan stringStyledSpan : next) {
                    this.stringIndex.add(Integer.valueOf(i6));
                    i6 += stringStyledSpan.styleString.length;
                    this.strings.add(stringStyledSpan.styleString);
                }
                this.styledSpanIndex.add(Integer.valueOf(i7));
                i7 += (next.size() * 12) + 4;
            }
            int i8 = i6 % 4;
            int i9 = i8 == 0 ? 0 : 4 - i8;
            this.stringsPaddingSize = i9;
            int size = this.strings.size();
            this.stringCount = size;
            this.styledSpanCount = this.strings.size() - strArr.length;
            boolean z5 = this.strings.size() - strArr.length > 0;
            if (!z5) {
                this.styledSpanIndex.clear();
                this.styledSpans.clear();
            }
            int size2 = (size * 4) + 28 + (this.styledSpanIndex.size() * 4);
            this.stringsStart = size2;
            int i10 = i6 + i9;
            this.styledSpansStart = z5 ? size2 + i10 : 0;
            int i11 = size2 + i10 + (z5 ? i7 : i5);
            this.chunkSize = i11;
            this.header = new ResChunkHeader(1, HEADER_SIZE, i11);
        }
    }

    private static class StringStyledSpan {
        private int firstCharacterIndex;
        private int lastCharacterIndex;
        private int nameReference;
        /* access modifiers changed from: private */
        public byte[] styleString;

        private StringStyledSpan() {
        }

        /* access modifiers changed from: package-private */
        public void writeTo(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            byteArrayOutputStream.write(ColorResourcesTableCreator.intToByteArray(this.nameReference));
            byteArrayOutputStream.write(ColorResourcesTableCreator.intToByteArray(this.firstCharacterIndex));
            byteArrayOutputStream.write(ColorResourcesTableCreator.intToByteArray(this.lastCharacterIndex));
        }
    }

    private static class TypeChunk {
        private static final byte CONFIG_SIZE = 64;
        private static final short HEADER_SIZE = 84;
        private static final int OFFSET_NO_ENTRY = -1;
        private final byte[] config;
        private final int entryCount;
        private final ResChunkHeader header;
        private final int[] offsetTable;
        private final ResEntry[] resEntries;

        TypeChunk(List<ColorResource> list, Set<Short> set, int i5) {
            byte[] bArr = new byte[64];
            this.config = bArr;
            this.entryCount = i5;
            bArr[0] = CONFIG_SIZE;
            this.resEntries = new ResEntry[list.size()];
            for (int i6 = 0; i6 < list.size(); i6++) {
                this.resEntries[i6] = new ResEntry(i6, list.get(i6).value);
            }
            this.offsetTable = new int[i5];
            int i7 = 0;
            for (short s5 = 0; s5 < i5; s5 = (short) (s5 + 1)) {
                if (set.contains(Short.valueOf(s5))) {
                    this.offsetTable[s5] = i7;
                    i7 += 16;
                } else {
                    this.offsetTable[s5] = -1;
                }
            }
            this.header = new ResChunkHeader(ColorResourcesTableCreator.HEADER_TYPE_TYPE, HEADER_SIZE, getChunkSize());
        }

        private int getEntryStart() {
            return getOffsetTableSize() + 84;
        }

        private int getOffsetTableSize() {
            return this.offsetTable.length * 4;
        }

        /* access modifiers changed from: package-private */
        public int getChunkSize() {
            return getEntryStart() + (this.resEntries.length * 16);
        }

        /* access modifiers changed from: package-private */
        public void writeTo(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.header.writeTo(byteArrayOutputStream);
            byteArrayOutputStream.write(new byte[]{ColorResourcesTableCreator.typeIdColor, 0, 0, 0});
            byteArrayOutputStream.write(ColorResourcesTableCreator.intToByteArray(this.entryCount));
            byteArrayOutputStream.write(ColorResourcesTableCreator.intToByteArray(getEntryStart()));
            byteArrayOutputStream.write(this.config);
            for (int access$500 : this.offsetTable) {
                byteArrayOutputStream.write(ColorResourcesTableCreator.intToByteArray(access$500));
            }
            for (ResEntry writeTo : this.resEntries) {
                writeTo.writeTo(byteArrayOutputStream);
            }
        }
    }

    private static class TypeSpecChunk {
        private static final short HEADER_SIZE = 16;
        private static final int SPEC_PUBLIC = 1073741824;
        private final int entryCount;
        private final int[] entryFlags;
        private final ResChunkHeader header;
        private final TypeChunk typeChunk;

        TypeSpecChunk(List<ColorResource> list) {
            this.entryCount = list.get(list.size() - 1).entryId + 1;
            HashSet hashSet = new HashSet();
            for (ColorResource access$000 : list) {
                hashSet.add(Short.valueOf(access$000.entryId));
            }
            this.entryFlags = new int[this.entryCount];
            for (short s5 = 0; s5 < this.entryCount; s5 = (short) (s5 + 1)) {
                if (hashSet.contains(Short.valueOf(s5))) {
                    this.entryFlags[s5] = 1073741824;
                }
            }
            this.header = new ResChunkHeader(ColorResourcesTableCreator.HEADER_TYPE_TYPE_SPEC, 16, getChunkSize());
            this.typeChunk = new TypeChunk(list, hashSet, this.entryCount);
        }

        private int getChunkSize() {
            return (this.entryCount * 4) + 16;
        }

        /* access modifiers changed from: package-private */
        public int getChunkSizeWithTypeChunk() {
            return getChunkSize() + this.typeChunk.getChunkSize();
        }

        /* access modifiers changed from: package-private */
        public void writeTo(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.header.writeTo(byteArrayOutputStream);
            byteArrayOutputStream.write(new byte[]{ColorResourcesTableCreator.typeIdColor, 0, 0, 0});
            byteArrayOutputStream.write(ColorResourcesTableCreator.intToByteArray(this.entryCount));
            for (int access$500 : this.entryFlags) {
                byteArrayOutputStream.write(ColorResourcesTableCreator.intToByteArray(access$500));
            }
            this.typeChunk.writeTo(byteArrayOutputStream);
        }
    }

    private ColorResourcesTableCreator() {
    }

    /* access modifiers changed from: private */
    public static byte[] charToByteArray(char c5) {
        return new byte[]{(byte) (c5 & 255), (byte) ((c5 >> 8) & 255)};
    }

    private static byte[] concat(byte[]... bArr) {
        int i5 = 0;
        for (byte[] length : bArr) {
            i5 += length.length;
        }
        byte[] bArr2 = new byte[i5];
        int i6 = 0;
        for (byte[] bArr3 : bArr) {
            System.arraycopy(bArr3, 0, bArr2, i6, bArr3.length);
            i6 += bArr3.length;
        }
        return bArr2;
    }

    static byte[] create(Context context, Map<Integer, Integer> map) throws IOException {
        PackageInfo packageInfo;
        if (!map.entrySet().isEmpty()) {
            PackageInfo packageInfo2 = new PackageInfo(127, context.getPackageName());
            HashMap hashMap = new HashMap();
            ColorResource colorResource = null;
            for (Map.Entry next : map.entrySet()) {
                ColorResource colorResource2 = new ColorResource(((Integer) next.getKey()).intValue(), context.getResources().getResourceEntryName(((Integer) next.getKey()).intValue()), ((Integer) next.getValue()).intValue());
                if (context.getResources().getResourceTypeName(((Integer) next.getKey()).intValue()).equals("color")) {
                    if (colorResource2.packageId == 1) {
                        packageInfo = ANDROID_PACKAGE_INFO;
                    } else if (colorResource2.packageId == Byte.MAX_VALUE) {
                        packageInfo = packageInfo2;
                    } else {
                        throw new IllegalArgumentException("Not supported with unknown package id: " + colorResource2.packageId);
                    }
                    if (!hashMap.containsKey(packageInfo)) {
                        hashMap.put(packageInfo, new ArrayList());
                    }
                    ((List) hashMap.get(packageInfo)).add(colorResource2);
                    colorResource = colorResource2;
                } else {
                    throw new IllegalArgumentException("Non color resource found: name=" + colorResource2.name + ", typeId=" + Integer.toHexString(colorResource2.typeId & 255));
                }
            }
            byte access$200 = colorResource.typeId;
            typeIdColor = access$200;
            if (access$200 != 0) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new ResTable(hashMap).writeTo(byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            }
            throw new IllegalArgumentException("No color resources found for harmonization.");
        }
        throw new IllegalArgumentException("No color resources provided for harmonization.");
    }

    private static byte[] encodeLengthUtf8(short s5) {
        if (s5 > 127) {
            return new byte[]{(byte) ((127 & (s5 >> 8)) | 128), (byte) (s5 & 255)};
        }
        return new byte[]{(byte) (s5 & 255)};
    }

    /* access modifiers changed from: private */
    public static byte[] intToByteArray(int i5) {
        return new byte[]{(byte) (i5 & 255), (byte) ((i5 >> 8) & 255), (byte) ((i5 >> 16) & 255), (byte) ((i5 >> 24) & 255)};
    }

    /* access modifiers changed from: private */
    public static byte[] shortToByteArray(short s5) {
        return new byte[]{(byte) (s5 & 255), (byte) ((s5 >> 8) & 255)};
    }

    /* access modifiers changed from: private */
    public static byte[] stringToByteArray(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length * 2;
        byte[] bArr = new byte[(length + 4)];
        byte[] shortToByteArray = shortToByteArray((short) charArray.length);
        bArr[0] = shortToByteArray[0];
        bArr[1] = shortToByteArray[1];
        for (int i5 = 0; i5 < charArray.length; i5++) {
            byte[] charToByteArray = charToByteArray(charArray[i5]);
            int i6 = i5 * 2;
            bArr[i6 + 2] = charToByteArray[0];
            bArr[i6 + 3] = charToByteArray[1];
        }
        bArr[length + 2] = 0;
        bArr[length + 3] = 0;
        return bArr;
    }

    /* access modifiers changed from: private */
    public static byte[] stringToByteArrayUtf8(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        return concat(encodeLengthUtf8((short) str.length()), encodeLengthUtf8((short) bytes.length), bytes, new byte[]{0});
    }
}
