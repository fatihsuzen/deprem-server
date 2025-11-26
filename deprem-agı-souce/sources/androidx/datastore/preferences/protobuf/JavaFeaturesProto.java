package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.DescriptorProtos;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class JavaFeaturesProto {
    public static final int JAVA_FIELD_NUMBER = 1001;
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FeatureSet, JavaFeatures> java_ = GeneratedMessageLite.newSingularGeneratedExtension(DescriptorProtos.FeatureSet.getDefaultInstance(), JavaFeatures.getDefaultInstance(), JavaFeatures.getDefaultInstance(), (Internal.EnumLiteMap<?>) null, 1001, WireFormat.FieldType.MESSAGE, JavaFeatures.class);

    /* renamed from: androidx.datastore.preferences.protobuf.JavaFeaturesProto$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke[] r0 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r0
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.JavaFeaturesProto.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class JavaFeatures extends GeneratedMessageLite<JavaFeatures, Builder> implements JavaFeaturesOrBuilder {
        /* access modifiers changed from: private */
        public static final JavaFeatures DEFAULT_INSTANCE;
        public static final int LEGACY_CLOSED_ENUM_FIELD_NUMBER = 1;
        private static volatile Parser<JavaFeatures> PARSER = null;
        public static final int UTF8_VALIDATION_FIELD_NUMBER = 2;
        private int bitField0_;
        private boolean legacyClosedEnum_;
        private int utf8Validation_;

        public static final class Builder extends GeneratedMessageLite.Builder<JavaFeatures, Builder> implements JavaFeaturesOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearLegacyClosedEnum() {
                copyOnWrite();
                ((JavaFeatures) this.instance).clearLegacyClosedEnum();
                return this;
            }

            public Builder clearUtf8Validation() {
                copyOnWrite();
                ((JavaFeatures) this.instance).clearUtf8Validation();
                return this;
            }

            public boolean getLegacyClosedEnum() {
                return ((JavaFeatures) this.instance).getLegacyClosedEnum();
            }

            public Utf8Validation getUtf8Validation() {
                return ((JavaFeatures) this.instance).getUtf8Validation();
            }

            public boolean hasLegacyClosedEnum() {
                return ((JavaFeatures) this.instance).hasLegacyClosedEnum();
            }

            public boolean hasUtf8Validation() {
                return ((JavaFeatures) this.instance).hasUtf8Validation();
            }

            public Builder setLegacyClosedEnum(boolean z4) {
                copyOnWrite();
                ((JavaFeatures) this.instance).setLegacyClosedEnum(z4);
                return this;
            }

            public Builder setUtf8Validation(Utf8Validation utf8Validation) {
                copyOnWrite();
                ((JavaFeatures) this.instance).setUtf8Validation(utf8Validation);
                return this;
            }

            private Builder() {
                super(JavaFeatures.DEFAULT_INSTANCE);
            }
        }

        public enum Utf8Validation implements Internal.EnumLite {
            UTF8_VALIDATION_UNKNOWN(0),
            DEFAULT(1),
            VERIFY(2);
            
            public static final int DEFAULT_VALUE = 1;
            public static final int UTF8_VALIDATION_UNKNOWN_VALUE = 0;
            public static final int VERIFY_VALUE = 2;
            private static final Internal.EnumLiteMap<Utf8Validation> internalValueMap = null;
            private final int value;

            private static final class Utf8ValidationVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = null;

                static {
                    INSTANCE = new Utf8ValidationVerifier();
                }

                private Utf8ValidationVerifier() {
                }

                public boolean isInRange(int i5) {
                    if (Utf8Validation.forNumber(i5) != null) {
                        return true;
                    }
                    return false;
                }
            }

            static {
                internalValueMap = new Internal.EnumLiteMap<Utf8Validation>() {
                    public Utf8Validation findValueByNumber(int i5) {
                        return Utf8Validation.forNumber(i5);
                    }
                };
            }

            private Utf8Validation(int i5) {
                this.value = i5;
            }

            public static Utf8Validation forNumber(int i5) {
                if (i5 == 0) {
                    return UTF8_VALIDATION_UNKNOWN;
                }
                if (i5 == 1) {
                    return DEFAULT;
                }
                if (i5 != 2) {
                    return null;
                }
                return VERIFY;
            }

            public static Internal.EnumLiteMap<Utf8Validation> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return Utf8ValidationVerifier.INSTANCE;
            }

            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static Utf8Validation valueOf(int i5) {
                return forNumber(i5);
            }
        }

        static {
            JavaFeatures javaFeatures = new JavaFeatures();
            DEFAULT_INSTANCE = javaFeatures;
            GeneratedMessageLite.registerDefaultInstance(JavaFeatures.class, javaFeatures);
        }

        private JavaFeatures() {
        }

        /* access modifiers changed from: private */
        public void clearLegacyClosedEnum() {
            this.bitField0_ &= -2;
            this.legacyClosedEnum_ = false;
        }

        /* access modifiers changed from: private */
        public void clearUtf8Validation() {
            this.bitField0_ &= -3;
            this.utf8Validation_ = 0;
        }

        public static JavaFeatures getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static JavaFeatures parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (JavaFeatures) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static JavaFeatures parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (JavaFeatures) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<JavaFeatures> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setLegacyClosedEnum(boolean z4) {
            this.bitField0_ |= 1;
            this.legacyClosedEnum_ = z4;
        }

        /* access modifiers changed from: private */
        public void setUtf8Validation(Utf8Validation utf8Validation) {
            this.utf8Validation_ = utf8Validation.getNumber();
            this.bitField0_ |= 2;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new JavaFeatures();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002᠌\u0001", new Object[]{"bitField0_", "legacyClosedEnum_", "utf8Validation_", Utf8Validation.internalGetVerifier()});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<JavaFeatures> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (JavaFeatures.class) {
                        try {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public boolean getLegacyClosedEnum() {
            return this.legacyClosedEnum_;
        }

        public Utf8Validation getUtf8Validation() {
            Utf8Validation forNumber = Utf8Validation.forNumber(this.utf8Validation_);
            if (forNumber == null) {
                return Utf8Validation.UTF8_VALIDATION_UNKNOWN;
            }
            return forNumber;
        }

        public boolean hasLegacyClosedEnum() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasUtf8Validation() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(JavaFeatures javaFeatures) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(javaFeatures);
        }

        public static JavaFeatures parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (JavaFeatures) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static JavaFeatures parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (JavaFeatures) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static JavaFeatures parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (JavaFeatures) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static JavaFeatures parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (JavaFeatures) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static JavaFeatures parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (JavaFeatures) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static JavaFeatures parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (JavaFeatures) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static JavaFeatures parseFrom(InputStream inputStream) throws IOException {
            return (JavaFeatures) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static JavaFeatures parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (JavaFeatures) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static JavaFeatures parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (JavaFeatures) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static JavaFeatures parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (JavaFeatures) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface JavaFeaturesOrBuilder extends MessageLiteOrBuilder {
        boolean getLegacyClosedEnum();

        JavaFeatures.Utf8Validation getUtf8Validation();

        boolean hasLegacyClosedEnum();

        boolean hasUtf8Validation();
    }

    private JavaFeaturesProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.add((GeneratedMessageLite.GeneratedExtension<?, ?>) java_);
    }
}
