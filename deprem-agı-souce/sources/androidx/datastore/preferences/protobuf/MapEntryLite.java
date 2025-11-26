package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.MessageLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;

public class MapEntryLite<K, V> {
    private static final int KEY_FIELD_NUMBER = 1;
    private static final int VALUE_FIELD_NUMBER = 2;
    private final K key;
    private final Metadata<K, V> metadata;
    private final V value;

    /* renamed from: androidx.datastore.preferences.protobuf.MapEntryLite$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.datastore.preferences.protobuf.WireFormat$FieldType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MapEntryLite.AnonymousClass1.<clinit>():void");
        }
    }

    static class Metadata<K, V> {
        public final K defaultKey;
        public final V defaultValue;
        public final WireFormat.FieldType keyType;
        public final WireFormat.FieldType valueType;

        public Metadata(WireFormat.FieldType fieldType, K k5, WireFormat.FieldType fieldType2, V v5) {
            this.keyType = fieldType;
            this.defaultKey = k5;
            this.valueType = fieldType2;
            this.defaultValue = v5;
        }
    }

    private MapEntryLite(WireFormat.FieldType fieldType, K k5, WireFormat.FieldType fieldType2, V v5) {
        this.metadata = new Metadata<>(fieldType, k5, fieldType2, v5);
        this.key = k5;
        this.value = v5;
    }

    static <K, V> int computeSerializedSize(Metadata<K, V> metadata2, K k5, V v5) {
        return FieldSet.computeElementSize(metadata2.keyType, 1, k5) + FieldSet.computeElementSize(metadata2.valueType, 2, v5);
    }

    public static <K, V> MapEntryLite<K, V> newDefaultInstance(WireFormat.FieldType fieldType, K k5, WireFormat.FieldType fieldType2, V v5) {
        return new MapEntryLite<>(fieldType, k5, fieldType2, v5);
    }

    static <T> T parseField(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, WireFormat.FieldType fieldType, T t5) throws IOException {
        int i5 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()];
        if (i5 == 1) {
            MessageLite.Builder builder = ((MessageLite) t5).toBuilder();
            codedInputStream.readMessage(builder, extensionRegistryLite);
            return builder.buildPartial();
        } else if (i5 == 2) {
            return Integer.valueOf(codedInputStream.readEnum());
        } else {
            if (i5 != 3) {
                return FieldSet.readPrimitiveField(codedInputStream, fieldType, true);
            }
            throw new RuntimeException("Groups are not allowed in maps.");
        }
    }

    static <K, V> void writeTo(CodedOutputStream codedOutputStream, Metadata<K, V> metadata2, K k5, V v5) throws IOException {
        FieldSet.writeElement(codedOutputStream, metadata2.keyType, 1, k5);
        FieldSet.writeElement(codedOutputStream, metadata2.valueType, 2, v5);
    }

    public int computeMessageSize(int i5, K k5, V v5) {
        return CodedOutputStream.computeTagSize(i5) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSerializedSize(this.metadata, k5, v5));
    }

    public K getKey() {
        return this.key;
    }

    /* access modifiers changed from: package-private */
    public Metadata<K, V> getMetadata() {
        return this.metadata;
    }

    public V getValue() {
        return this.value;
    }

    public Map.Entry<K, V> parseEntry(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return parseEntry(byteString.newCodedInput(), this.metadata, extensionRegistryLite);
    }

    public void parseInto(MapFieldLite<K, V> mapFieldLite, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
        Metadata<K, V> metadata2 = this.metadata;
        K k5 = metadata2.defaultKey;
        V v5 = metadata2.defaultValue;
        while (true) {
            int readTag = codedInputStream.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == WireFormat.makeTag(1, this.metadata.keyType.getWireType())) {
                k5 = parseField(codedInputStream, extensionRegistryLite, this.metadata.keyType, k5);
            } else if (readTag == WireFormat.makeTag(2, this.metadata.valueType.getWireType())) {
                v5 = parseField(codedInputStream, extensionRegistryLite, this.metadata.valueType, v5);
            } else if (!codedInputStream.skipField(readTag)) {
                break;
            }
        }
        codedInputStream.checkLastTagWas(0);
        codedInputStream.popLimit(pushLimit);
        mapFieldLite.put(k5, v5);
    }

    public void serializeTo(CodedOutputStream codedOutputStream, int i5, K k5, V v5) throws IOException {
        codedOutputStream.writeTag(i5, 2);
        codedOutputStream.writeUInt32NoTag(computeSerializedSize(this.metadata, k5, v5));
        writeTo(codedOutputStream, this.metadata, k5, v5);
    }

    static <K, V> Map.Entry<K, V> parseEntry(CodedInputStream codedInputStream, Metadata<K, V> metadata2, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        K k5 = metadata2.defaultKey;
        V v5 = metadata2.defaultValue;
        while (true) {
            int readTag = codedInputStream.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == WireFormat.makeTag(1, metadata2.keyType.getWireType())) {
                k5 = parseField(codedInputStream, extensionRegistryLite, metadata2.keyType, k5);
            } else if (readTag == WireFormat.makeTag(2, metadata2.valueType.getWireType())) {
                v5 = parseField(codedInputStream, extensionRegistryLite, metadata2.valueType, v5);
            } else if (!codedInputStream.skipField(readTag)) {
                break;
            }
        }
        return new AbstractMap.SimpleImmutableEntry(k5, v5);
    }

    private MapEntryLite(Metadata<K, V> metadata2, K k5, V v5) {
        this.metadata = metadata2;
        this.key = k5;
        this.value = v5;
    }
}
