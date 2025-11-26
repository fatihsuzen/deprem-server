package com.mbridge.msdk.playercommon.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.util.DesugarCollections;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DefaultContentMetadata implements ContentMetadata {
    public static final DefaultContentMetadata EMPTY = new DefaultContentMetadata(Collections.EMPTY_MAP);
    private static final int MAX_VALUE_LENGTH = 10485760;
    private int hashCode;
    private final Map<String, byte[]> metadata;

    private DefaultContentMetadata(Map<String, byte[]> map) {
        this.metadata = DesugarCollections.unmodifiableMap(map);
    }

    private static void addValues(HashMap<String, byte[]> hashMap, Map<String, Object> map) {
        for (String next : map.keySet()) {
            byte[] bytes = getBytes(map.get(next));
            if (bytes.length <= MAX_VALUE_LENGTH) {
                hashMap.put(next, bytes);
            } else {
                throw new IllegalArgumentException(String.format("The size of %s (%d) is greater than maximum allowed: %d", new Object[]{next, Integer.valueOf(bytes.length), Integer.valueOf(MAX_VALUE_LENGTH)}));
            }
        }
    }

    private static Map<String, byte[]> applyMutations(Map<String, byte[]> map, ContentMetadataMutations contentMetadataMutations) {
        HashMap hashMap = new HashMap(map);
        removeValues(hashMap, contentMetadataMutations.getRemovedValues());
        addValues(hashMap, contentMetadataMutations.getEditedValues());
        return hashMap;
    }

    private static byte[] getBytes(Object obj) {
        if (obj instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
        }
        if (obj instanceof String) {
            return ((String) obj).getBytes(Charset.forName(C.UTF8_NAME));
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new IllegalArgumentException();
    }

    private boolean isMetadataEqual(Map<String, byte[]> map) {
        if (this.metadata.size() != map.size()) {
            return false;
        }
        for (Map.Entry next : this.metadata.entrySet()) {
            if (!Arrays.equals((byte[]) next.getValue(), map.get(next.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public static DefaultContentMetadata readFromStream(DataInputStream dataInputStream) throws IOException {
        int readInt = dataInputStream.readInt();
        HashMap hashMap = new HashMap();
        for (int i5 = 0; i5 < readInt; i5++) {
            String readUTF = dataInputStream.readUTF();
            int readInt2 = dataInputStream.readInt();
            if (readInt2 < 0 || readInt2 > MAX_VALUE_LENGTH) {
                throw new IOException("Invalid value size: " + readInt2);
            }
            byte[] bArr = new byte[readInt2];
            dataInputStream.readFully(bArr);
            hashMap.put(readUTF, bArr);
        }
        return new DefaultContentMetadata(hashMap);
    }

    private static void removeValues(HashMap<String, byte[]> hashMap, List<String> list) {
        for (int i5 = 0; i5 < list.size(); i5++) {
            hashMap.remove(list.get(i5));
        }
    }

    public final boolean contains(String str) {
        return this.metadata.containsKey(str);
    }

    public final DefaultContentMetadata copyWithMutationsApplied(ContentMetadataMutations contentMetadataMutations) {
        Map<String, byte[]> applyMutations = applyMutations(this.metadata, contentMetadataMutations);
        if (isMetadataEqual(applyMutations)) {
            return this;
        }
        return new DefaultContentMetadata(applyMutations);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DefaultContentMetadata.class != obj.getClass()) {
            return false;
        }
        return isMetadataEqual(((DefaultContentMetadata) obj).metadata);
    }

    public final byte[] get(String str, byte[] bArr) {
        if (!this.metadata.containsKey(str)) {
            return bArr;
        }
        byte[] bArr2 = this.metadata.get(str);
        return Arrays.copyOf(bArr2, bArr2.length);
    }

    public final int hashCode() {
        if (this.hashCode == 0) {
            int i5 = 0;
            for (Map.Entry next : this.metadata.entrySet()) {
                i5 += Arrays.hashCode((byte[]) next.getValue()) ^ ((String) next.getKey()).hashCode();
            }
            this.hashCode = i5;
        }
        return this.hashCode;
    }

    public final void writeToStream(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.metadata.size());
        for (Map.Entry next : this.metadata.entrySet()) {
            dataOutputStream.writeUTF((String) next.getKey());
            byte[] bArr = (byte[]) next.getValue();
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
    }

    public final String get(String str, String str2) {
        return this.metadata.containsKey(str) ? new String(this.metadata.get(str), Charset.forName(C.UTF8_NAME)) : str2;
    }

    public final long get(String str, long j5) {
        return this.metadata.containsKey(str) ? ByteBuffer.wrap(this.metadata.get(str)).getLong() : j5;
    }
}
