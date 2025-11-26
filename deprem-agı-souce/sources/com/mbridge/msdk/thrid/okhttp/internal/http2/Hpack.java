package com.mbridge.msdk.thrid.okhttp.internal.http2;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSource;
import com.mbridge.msdk.thrid.okio.ByteString;
import com.mbridge.msdk.thrid.okio.Okio;
import com.mbridge.msdk.thrid.okio.Source;
import j$.util.DesugarCollections;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class Hpack {
    static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX = nameToFirstIndex();
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    static final Header[] STATIC_HEADER_TABLE;

    static final class Reader {
        Header[] dynamicTable;
        int dynamicTableByteCount;
        int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final BufferedSource source;

        Reader(int i5, Source source2) {
            this(i5, i5, source2);
        }

        private void adjustDynamicTableByteCount() {
            int i5 = this.maxDynamicTableByteCount;
            int i6 = this.dynamicTableByteCount;
            if (i5 >= i6) {
                return;
            }
            if (i5 == 0) {
                clearDynamicTable();
            } else {
                evictToRecoverBytes(i6 - i5);
            }
        }

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int dynamicTableIndex(int i5) {
            return this.nextHeaderIndex + 1 + i5;
        }

        private int evictToRecoverBytes(int i5) {
            int i6;
            int i7 = 0;
            if (i5 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i6 = this.nextHeaderIndex;
                    if (length < i6 || i5 <= 0) {
                        Header[] headerArr = this.dynamicTable;
                        System.arraycopy(headerArr, i6 + 1, headerArr, i6 + 1 + i7, this.headerCount);
                        this.nextHeaderIndex += i7;
                    } else {
                        int i8 = this.dynamicTable[length].hpackSize;
                        i5 -= i8;
                        this.dynamicTableByteCount -= i8;
                        this.headerCount--;
                        i7++;
                    }
                }
                Header[] headerArr2 = this.dynamicTable;
                System.arraycopy(headerArr2, i6 + 1, headerArr2, i6 + 1 + i7, this.headerCount);
                this.nextHeaderIndex += i7;
            }
            return i7;
        }

        private ByteString getName(int i5) throws IOException {
            if (isStaticHeader(i5)) {
                return Hpack.STATIC_HEADER_TABLE[i5].name;
            }
            int dynamicTableIndex = dynamicTableIndex(i5 - Hpack.STATIC_HEADER_TABLE.length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    return headerArr[dynamicTableIndex].name;
                }
            }
            throw new IOException("Header index too large " + (i5 + 1));
        }

        private void insertIntoDynamicTable(int i5, Header header) {
            this.headerList.add(header);
            int i6 = header.hpackSize;
            if (i5 != -1) {
                i6 -= this.dynamicTable[dynamicTableIndex(i5)].hpackSize;
            }
            int i7 = this.maxDynamicTableByteCount;
            if (i6 > i7) {
                clearDynamicTable();
                return;
            }
            int evictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i6) - i7);
            if (i5 == -1) {
                int i8 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i8 > headerArr.length) {
                    Header[] headerArr2 = new Header[(headerArr.length * 2)];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i9 = this.nextHeaderIndex;
                this.nextHeaderIndex = i9 - 1;
                this.dynamicTable[i9] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[i5 + dynamicTableIndex(i5) + evictToRecoverBytes] = header;
            }
            this.dynamicTableByteCount += i6;
        }

        private boolean isStaticHeader(int i5) {
            if (i5 < 0 || i5 > Hpack.STATIC_HEADER_TABLE.length - 1) {
                return false;
            }
            return true;
        }

        private int readByte() throws IOException {
            return this.source.readByte() & 255;
        }

        private void readIndexedHeader(int i5) throws IOException {
            if (isStaticHeader(i5)) {
                this.headerList.add(Hpack.STATIC_HEADER_TABLE[i5]);
                return;
            }
            int dynamicTableIndex = dynamicTableIndex(i5 - Hpack.STATIC_HEADER_TABLE.length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    this.headerList.add(headerArr[dynamicTableIndex]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i5 + 1));
        }

        private void readLiteralHeaderWithIncrementalIndexingIndexedName(int i5) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(i5), readByteString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingIndexedName(int i5) throws IOException {
            this.headerList.add(new Header(getName(i5), readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        public List<Header> getAndResetHeaderList() {
            ArrayList arrayList = new ArrayList(this.headerList);
            this.headerList.clear();
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        public int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        /* access modifiers changed from: package-private */
        public ByteString readByteString() throws IOException {
            boolean z4;
            int readByte = readByte();
            if ((readByte & 128) == 128) {
                z4 = true;
            } else {
                z4 = false;
            }
            int readInt = readInt(readByte, Hpack.PREFIX_7_BITS);
            if (z4) {
                return ByteString.of(Huffman.get().decode(this.source.readByteArray((long) readInt)));
            }
            return this.source.readByteString((long) readInt);
        }

        /* access modifiers changed from: package-private */
        public void readHeaders() throws IOException {
            while (!this.source.exhausted()) {
                byte readByte = this.source.readByte();
                byte b5 = readByte & 255;
                if (b5 == 128) {
                    throw new IOException("index == 0");
                } else if ((readByte & 128) == 128) {
                    readIndexedHeader(readInt(b5, Hpack.PREFIX_7_BITS) - 1);
                } else if (b5 == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((readByte & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(b5, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int readInt = readInt(b5, 31);
                    this.maxDynamicTableByteCount = readInt;
                    if (readInt < 0 || readInt > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    adjustDynamicTableByteCount();
                } else if (b5 == 16 || b5 == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(b5, 15) - 1);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int readInt(int i5, int i6) throws IOException {
            int i7 = i5 & i6;
            if (i7 < i6) {
                return i7;
            }
            int i8 = 0;
            while (true) {
                int readByte = readByte();
                if ((readByte & 128) == 0) {
                    return i6 + (readByte << i8);
                }
                i6 += (readByte & Hpack.PREFIX_7_BITS) << i8;
                i8 += 7;
            }
        }

        Reader(int i5, int i6, Source source2) {
            this.headerList = new ArrayList();
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i5;
            this.maxDynamicTableByteCount = i6;
            this.source = Okio.buffer(source2);
        }
    }

    static final class Writer {
        private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
        private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
        Header[] dynamicTable;
        int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        int headerCount;
        int headerTableSizeSetting;
        int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        Writer(Buffer buffer) {
            this(4096, true, buffer);
        }

        private void adjustDynamicTableByteCount() {
            int i5 = this.maxDynamicTableByteCount;
            int i6 = this.dynamicTableByteCount;
            if (i5 >= i6) {
                return;
            }
            if (i5 == 0) {
                clearDynamicTable();
            } else {
                evictToRecoverBytes(i6 - i5);
            }
        }

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int evictToRecoverBytes(int i5) {
            int i6;
            int i7 = 0;
            if (i5 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i6 = this.nextHeaderIndex;
                    if (length < i6 || i5 <= 0) {
                        Header[] headerArr = this.dynamicTable;
                        System.arraycopy(headerArr, i6 + 1, headerArr, i6 + 1 + i7, this.headerCount);
                        Header[] headerArr2 = this.dynamicTable;
                        int i8 = this.nextHeaderIndex;
                        Arrays.fill(headerArr2, i8 + 1, i8 + 1 + i7, (Object) null);
                        this.nextHeaderIndex += i7;
                    } else {
                        int i9 = this.dynamicTable[length].hpackSize;
                        i5 -= i9;
                        this.dynamicTableByteCount -= i9;
                        this.headerCount--;
                        i7++;
                    }
                }
                Header[] headerArr3 = this.dynamicTable;
                System.arraycopy(headerArr3, i6 + 1, headerArr3, i6 + 1 + i7, this.headerCount);
                Header[] headerArr22 = this.dynamicTable;
                int i82 = this.nextHeaderIndex;
                Arrays.fill(headerArr22, i82 + 1, i82 + 1 + i7, (Object) null);
                this.nextHeaderIndex += i7;
            }
            return i7;
        }

        private void insertIntoDynamicTable(Header header) {
            int i5 = header.hpackSize;
            int i6 = this.maxDynamicTableByteCount;
            if (i5 > i6) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i5) - i6);
            int i7 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i7 > headerArr.length) {
                Header[] headerArr2 = new Header[(headerArr.length * 2)];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i8 = this.nextHeaderIndex;
            this.nextHeaderIndex = i8 - 1;
            this.dynamicTable[i8] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i5;
        }

        /* access modifiers changed from: package-private */
        public void setHeaderTableSizeSetting(int i5) {
            this.headerTableSizeSetting = i5;
            int min = Math.min(i5, 16384);
            int i6 = this.maxDynamicTableByteCount;
            if (i6 != min) {
                if (min < i6) {
                    this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, min);
                }
                this.emitDynamicTableSizeUpdate = true;
                this.maxDynamicTableByteCount = min;
                adjustDynamicTableByteCount();
            }
        }

        /* access modifiers changed from: package-private */
        public void writeByteString(ByteString byteString) throws IOException {
            if (!this.useCompression || Huffman.get().encodedLength(byteString) >= byteString.size()) {
                writeInt(byteString.size(), Hpack.PREFIX_7_BITS, 0);
                this.out.write(byteString);
                return;
            }
            Buffer buffer = new Buffer();
            Huffman.get().encode(byteString, buffer);
            ByteString readByteString = buffer.readByteString();
            writeInt(readByteString.size(), Hpack.PREFIX_7_BITS, 128);
            this.out.write(readByteString);
        }

        /* access modifiers changed from: package-private */
        public void writeHeaders(List<Header> list) throws IOException {
            int i5;
            int i6;
            if (this.emitDynamicTableSizeUpdate) {
                int i7 = this.smallestHeaderTableSizeSetting;
                if (i7 < this.maxDynamicTableByteCount) {
                    writeInt(i7, 31, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
                writeInt(this.maxDynamicTableByteCount, 31, 32);
            }
            int size = list.size();
            for (int i8 = 0; i8 < size; i8++) {
                Header header = list.get(i8);
                ByteString asciiLowercase = header.name.toAsciiLowercase();
                ByteString byteString = header.value;
                Integer num = Hpack.NAME_TO_FIRST_INDEX.get(asciiLowercase);
                if (num != null) {
                    int intValue = num.intValue();
                    i5 = intValue + 1;
                    if (i5 > 1 && i5 < 8) {
                        Header[] headerArr = Hpack.STATIC_HEADER_TABLE;
                        if (Util.equal(headerArr[intValue].value, byteString)) {
                            i6 = i5;
                        } else if (Util.equal(headerArr[i5].value, byteString)) {
                            int i9 = i5;
                            i5 = intValue + 2;
                            i6 = i9;
                        }
                    }
                    i6 = i5;
                    i5 = -1;
                } else {
                    i6 = -1;
                    i5 = -1;
                }
                if (i5 == -1) {
                    int i10 = this.nextHeaderIndex + 1;
                    int length = this.dynamicTable.length;
                    while (true) {
                        if (i10 >= length) {
                            break;
                        }
                        if (Util.equal(this.dynamicTable[i10].name, asciiLowercase)) {
                            if (Util.equal(this.dynamicTable[i10].value, byteString)) {
                                i5 = (i10 - this.nextHeaderIndex) + Hpack.STATIC_HEADER_TABLE.length;
                                break;
                            } else if (i6 == -1) {
                                i6 = (i10 - this.nextHeaderIndex) + Hpack.STATIC_HEADER_TABLE.length;
                            }
                        }
                        i10++;
                    }
                }
                if (i5 != -1) {
                    writeInt(i5, Hpack.PREFIX_7_BITS, 128);
                } else if (i6 == -1) {
                    this.out.writeByte(64);
                    writeByteString(asciiLowercase);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header);
                } else if (!asciiLowercase.startsWith(Header.PSEUDO_PREFIX) || Header.TARGET_AUTHORITY.equals(asciiLowercase)) {
                    writeInt(i6, 63, 64);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header);
                } else {
                    writeInt(i6, 15, 0);
                    writeByteString(byteString);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void writeInt(int i5, int i6, int i7) {
            if (i5 < i6) {
                this.out.writeByte(i5 | i7);
                return;
            }
            this.out.writeByte(i7 | i6);
            int i8 = i5 - i6;
            while (i8 >= 128) {
                this.out.writeByte(128 | (i8 & Hpack.PREFIX_7_BITS));
                i8 >>>= 7;
            }
            this.out.writeByte(i8);
        }

        Writer(int i5, boolean z4, Buffer buffer) {
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i5;
            this.maxDynamicTableByteCount = i5;
            this.useCompression = z4;
            this.out = buffer;
        }
    }

    static {
        Header header = new Header(Header.TARGET_AUTHORITY, "");
        ByteString byteString = Header.TARGET_METHOD;
        Header header2 = new Header(byteString, ShareTarget.METHOD_GET);
        Header header3 = new Header(byteString, ShareTarget.METHOD_POST);
        ByteString byteString2 = Header.TARGET_PATH;
        Header header4 = new Header(byteString2, "/");
        Header header5 = new Header(byteString2, "/index.html");
        ByteString byteString3 = Header.TARGET_SCHEME;
        Header header6 = new Header(byteString3, "http");
        Header header7 = new Header(byteString3, "https");
        ByteString byteString4 = Header.RESPONSE_STATUS;
        Header header8 = header;
        Header header9 = header2;
        STATIC_HEADER_TABLE = new Header[]{header8, header9, header3, header4, header5, header6, header7, new Header(byteString4, "200"), new Header(byteString4, "204"), new Header(byteString4, "206"), new Header(byteString4, "304"), new Header(byteString4, "400"), new Header(byteString4, "404"), new Header(byteString4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header(DownloadModel.ETAG, ""), new Header("expect", ""), new Header("expires", ""), new Header(TypedValues.TransitionType.S_FROM, ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header(ToolBar.REFRESH, ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
    }

    private Hpack() {
    }

    static ByteString checkLowercase(ByteString byteString) throws IOException {
        int size = byteString.size();
        int i5 = 0;
        while (i5 < size) {
            byte b5 = byteString.getByte(i5);
            if (b5 < 65 || b5 > 90) {
                i5++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }

    private static Map<ByteString, Integer> nameToFirstIndex() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
        int i5 = 0;
        while (true) {
            Header[] headerArr = STATIC_HEADER_TABLE;
            if (i5 >= headerArr.length) {
                return DesugarCollections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(headerArr[i5].name)) {
                linkedHashMap.put(headerArr[i5].name, Integer.valueOf(i5));
            }
            i5++;
        }
    }
}
