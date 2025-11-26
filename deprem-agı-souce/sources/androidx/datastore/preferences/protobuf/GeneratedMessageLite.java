package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractMessageLite;
import androidx.datastore.preferences.protobuf.ArrayDecoders;
import androidx.datastore.preferences.protobuf.FieldSet;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite.Builder;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.MessageLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected UnknownFieldSetLite unknownFields = UnknownFieldSetLite.getDefaultInstance();

    /* renamed from: androidx.datastore.preferences.protobuf.GeneratedMessageLite$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.datastore.preferences.protobuf.WireFormat$JavaType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$WireFormat$JavaType = r0
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$JavaType     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.ENUM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.GeneratedMessageLite.AnonymousClass1.<clinit>():void");
        }
    }

    public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {
        private final MessageType defaultInstance;
        protected MessageType instance;

        protected Builder(MessageType messagetype) {
            this.defaultInstance = messagetype;
            if (!messagetype.isMutable()) {
                this.instance = newMutableInstance();
                return;
            }
            throw new IllegalArgumentException("Default instance must be immutable.");
        }

        private static <MessageType> void mergeFromInstance(MessageType messagetype, MessageType messagetype2) {
            Protobuf.getInstance().schemaFor(messagetype).mergeFrom(messagetype, messagetype2);
        }

        private MessageType newMutableInstance() {
            return this.defaultInstance.newMutableInstance();
        }

        /* access modifiers changed from: protected */
        public final void copyOnWrite() {
            if (!this.instance.isMutable()) {
                copyOnWriteInternal();
            }
        }

        /* access modifiers changed from: protected */
        public void copyOnWriteInternal() {
            MessageType newMutableInstance = newMutableInstance();
            mergeFromInstance(newMutableInstance, this.instance);
            this.instance = newMutableInstance;
        }

        public final boolean isInitialized() {
            return GeneratedMessageLite.isInitialized(this.instance, false);
        }

        public final MessageType build() {
            MessageType buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public MessageType buildPartial() {
            if (!this.instance.isMutable()) {
                return this.instance;
            }
            this.instance.makeImmutable();
            return this.instance;
        }

        public final BuilderType clear() {
            if (!this.defaultInstance.isMutable()) {
                this.instance = newMutableInstance();
                return this;
            }
            throw new IllegalArgumentException("Default instance must be immutable.");
        }

        public MessageType getDefaultInstanceForType() {
            return this.defaultInstance;
        }

        /* access modifiers changed from: protected */
        public BuilderType internalMergeFrom(MessageType messagetype) {
            return mergeFrom(messagetype);
        }

        public BuilderType clone() {
            BuilderType newBuilderForType = getDefaultInstanceForType().newBuilderForType();
            newBuilderForType.instance = buildPartial();
            return newBuilderForType;
        }

        public BuilderType mergeFrom(MessageType messagetype) {
            if (getDefaultInstanceForType().equals(messagetype)) {
                return this;
            }
            copyOnWrite();
            mergeFromInstance(this.instance, messagetype);
            return this;
        }

        public BuilderType mergeFrom(byte[] bArr, int i5, int i6, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            copyOnWrite();
            try {
                Protobuf.getInstance().schemaFor(this.instance).mergeFrom(this.instance, bArr, i5, i5 + i6, new ArrayDecoders.Registers(extensionRegistryLite));
                return this;
            } catch (InvalidProtocolBufferException e5) {
                throw e5;
            } catch (IndexOutOfBoundsException unused) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } catch (IOException e6) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e6);
            }
        }

        public BuilderType mergeFrom(byte[] bArr, int i5, int i6) throws InvalidProtocolBufferException {
            return mergeFrom(bArr, i5, i6, ExtensionRegistryLite.getEmptyRegistry());
        }

        public BuilderType mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            copyOnWrite();
            try {
                Protobuf.getInstance().schemaFor(this.instance).mergeFrom(this.instance, CodedInputStreamReader.forCodedInput(codedInputStream), extensionRegistryLite);
                return this;
            } catch (RuntimeException e5) {
                if (e5.getCause() instanceof IOException) {
                    throw ((IOException) e5.getCause());
                }
                throw e5;
            }
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        protected ExtendableBuilder(MessageType messagetype) {
            super(messagetype);
        }

        private FieldSet<ExtensionDescriptor> ensureExtensionsAreMutable() {
            FieldSet<ExtensionDescriptor> fieldSet = ((ExtendableMessage) this.instance).extensions;
            if (!fieldSet.isImmutable()) {
                return fieldSet;
            }
            FieldSet<ExtensionDescriptor> clone = fieldSet.clone();
            ((ExtendableMessage) this.instance).extensions = clone;
            return clone;
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public final <Type> BuilderType addExtension(ExtensionLite<MessageType, List<Type>> extensionLite, Type type) {
            GeneratedExtension access$000 = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(access$000);
            copyOnWrite();
            ensureExtensionsAreMutable().addRepeatedField(access$000.descriptor, access$000.singularToFieldSetType(type));
            return this;
        }

        public final BuilderType clearExtension(ExtensionLite<MessageType, ?> extensionLite) {
            GeneratedExtension access$000 = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(access$000);
            copyOnWrite();
            ensureExtensionsAreMutable().clearField(access$000.descriptor);
            return this;
        }

        /* access modifiers changed from: protected */
        public void copyOnWriteInternal() {
            super.copyOnWriteInternal();
            if (((ExtendableMessage) this.instance).extensions != FieldSet.emptySet()) {
                MessageType messagetype = this.instance;
                ((ExtendableMessage) messagetype).extensions = ((ExtendableMessage) messagetype).extensions.clone();
            }
        }

        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite) {
            return ((ExtendableMessage) this.instance).getExtension(extensionLite);
        }

        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite) {
            return ((ExtendableMessage) this.instance).getExtensionCount(extensionLite);
        }

        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite) {
            return ((ExtendableMessage) this.instance).hasExtension(extensionLite);
        }

        /* access modifiers changed from: package-private */
        public void internalSetExtensionSet(FieldSet<ExtensionDescriptor> fieldSet) {
            copyOnWrite();
            ((ExtendableMessage) this.instance).extensions = fieldSet;
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, Type> extensionLite, Type type) {
            GeneratedExtension access$000 = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(access$000);
            copyOnWrite();
            ensureExtensionsAreMutable().setField(access$000.descriptor, access$000.toFieldSetType(type));
            return this;
        }

        /* JADX WARNING: type inference failed for: r2v0, types: [androidx.datastore.preferences.protobuf.ExtensionLite, androidx.datastore.preferences.protobuf.ExtensionLite<MessageType, java.util.List<Type>>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final <Type> Type getExtension(androidx.datastore.preferences.protobuf.ExtensionLite<MessageType, java.util.List<Type>> r2, int r3) {
            /*
                r1 = this;
                MessageType r0 = r1.instance
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtendableMessage r0 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessage) r0
                java.lang.Object r2 = r0.getExtension(r2, r3)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableBuilder.getExtension(androidx.datastore.preferences.protobuf.ExtensionLite, int):java.lang.Object");
        }

        public final MessageType buildPartial() {
            if (!((ExtendableMessage) this.instance).isMutable()) {
                return (ExtendableMessage) this.instance;
            }
            ((ExtendableMessage) this.instance).extensions.makeImmutable();
            return (ExtendableMessage) super.buildPartial();
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i5, Type type) {
            GeneratedExtension access$000 = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(access$000);
            copyOnWrite();
            ensureExtensionsAreMutable().setRepeatedField(access$000.descriptor, i5, access$000.singularToFieldSetType(type));
            return this;
        }
    }

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends MessageLiteOrBuilder {
        <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite);

        <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i5);

        <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite);

        <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite);
    }

    static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {
        final Internal.EnumLiteMap<?> enumTypeMap;
        final boolean isPacked;
        final boolean isRepeated;
        final int number;
        final WireFormat.FieldType type;

        ExtensionDescriptor(Internal.EnumLiteMap<?> enumLiteMap, int i5, WireFormat.FieldType fieldType, boolean z4, boolean z5) {
            this.enumTypeMap = enumLiteMap;
            this.number = i5;
            this.type = fieldType;
            this.isRepeated = z4;
            this.isPacked = z5;
        }

        public Internal.EnumLiteMap<?> getEnumType() {
            return this.enumTypeMap;
        }

        public WireFormat.JavaType getLiteJavaType() {
            return this.type.getJavaType();
        }

        public WireFormat.FieldType getLiteType() {
            return this.type;
        }

        public int getNumber() {
            return this.number;
        }

        public MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite) {
            return ((Builder) builder).mergeFrom((GeneratedMessageLite) messageLite);
        }

        public boolean isPacked() {
            return this.isPacked;
        }

        public boolean isRepeated() {
            return this.isRepeated;
        }

        public int compareTo(ExtensionDescriptor extensionDescriptor) {
            return this.number - extensionDescriptor.number;
        }
    }

    public static class GeneratedExtension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {
        final ContainingType containingTypeDefaultInstance;
        final Type defaultValue;
        final ExtensionDescriptor descriptor;
        final MessageLite messageDefaultInstance;

        GeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, ExtensionDescriptor extensionDescriptor, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (extensionDescriptor.getLiteType() == WireFormat.FieldType.MESSAGE && messageLite == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.containingTypeDefaultInstance = containingtype;
                this.defaultValue = type;
                this.messageDefaultInstance = messageLite;
                this.descriptor = extensionDescriptor;
            }
        }

        /* access modifiers changed from: package-private */
        public Object fromFieldSetType(Object obj) {
            if (!this.descriptor.isRepeated()) {
                return singularFromFieldSetType(obj);
            }
            if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            for (Object singularFromFieldSetType : (List) obj) {
                arrayList.add(singularFromFieldSetType(singularFromFieldSetType));
            }
            return arrayList;
        }

        public ContainingType getContainingTypeDefaultInstance() {
            return this.containingTypeDefaultInstance;
        }

        public Type getDefaultValue() {
            return this.defaultValue;
        }

        public WireFormat.FieldType getLiteType() {
            return this.descriptor.getLiteType();
        }

        public MessageLite getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }

        public int getNumber() {
            return this.descriptor.getNumber();
        }

        public boolean isRepeated() {
            return this.descriptor.isRepeated;
        }

        /* access modifiers changed from: package-private */
        public Object singularFromFieldSetType(Object obj) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) {
                return this.descriptor.enumTypeMap.findValueByNumber(((Integer) obj).intValue());
            }
            return obj;
        }

        /* access modifiers changed from: package-private */
        public Object singularToFieldSetType(Object obj) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) {
                return Integer.valueOf(((Internal.EnumLite) obj).getNumber());
            }
            return obj;
        }

        /* access modifiers changed from: package-private */
        public Object toFieldSetType(Object obj) {
            if (!this.descriptor.isRepeated()) {
                return singularToFieldSetType(obj);
            }
            if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            for (Object singularToFieldSetType : (List) obj) {
                arrayList.add(singularToFieldSetType(singularToFieldSetType));
            }
            return arrayList;
        }
    }

    public enum MethodToInvoke {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    protected static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final byte[] asBytes;
        private final Class<?> messageClass;
        private final String messageClassName;

        SerializedForm(MessageLite messageLite) {
            this.messageClass = messageLite.getClass();
            this.messageClassName = messageLite.getClass().getName();
            this.asBytes = messageLite.toByteArray();
        }

        public static SerializedForm of(MessageLite messageLite) {
            return new SerializedForm(messageLite);
        }

        private Class<?> resolveMessageClass() throws ClassNotFoundException {
            Class<?> cls = this.messageClass;
            if (cls != null) {
                return cls;
            }
            return Class.forName(this.messageClassName);
        }

        /* access modifiers changed from: protected */
        public Object readResolve() throws ObjectStreamException {
            try {
                Field declaredField = resolveMessageClass().getDeclaredField("DEFAULT_INSTANCE");
                declaredField.setAccessible(true);
                return ((MessageLite) declaredField.get((Object) null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
            } catch (ClassNotFoundException e5) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e5);
            } catch (NoSuchFieldException e6) {
                throw new RuntimeException("Unable to find DEFAULT_INSTANCE in " + this.messageClassName, e6);
            } catch (SecurityException e7) {
                throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.messageClassName, e7);
            } catch (IllegalAccessException e8) {
                throw new RuntimeException("Unable to call parsePartialFrom", e8);
            } catch (InvalidProtocolBufferException e9) {
                throw new RuntimeException("Unable to understand proto buffer", e9);
            }
        }
    }

    /* access modifiers changed from: private */
    public static <MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>, T> GeneratedExtension<MessageType, T> checkIsLite(ExtensionLite<MessageType, T> extensionLite) {
        if (extensionLite.isLite()) {
            return (GeneratedExtension) extensionLite;
        }
        throw new IllegalArgumentException("Expected a lite extension.");
    }

    private static <T extends GeneratedMessageLite<T, ?>> T checkMessageInitialized(T t5) throws InvalidProtocolBufferException {
        if (t5 == null || t5.isInitialized()) {
            return t5;
        }
        throw t5.newUninitializedMessageException().asInvalidProtocolBufferException().setUnfinishedMessage(t5);
    }

    private int computeSerializedSize(Schema<?> schema) {
        if (schema == null) {
            return Protobuf.getInstance().schemaFor(this).getSerializedSize(this);
        }
        return schema.getSerializedSize(this);
    }

    protected static Internal.BooleanList emptyBooleanList() {
        return BooleanArrayList.emptyList();
    }

    protected static Internal.DoubleList emptyDoubleList() {
        return DoubleArrayList.emptyList();
    }

    protected static Internal.FloatList emptyFloatList() {
        return FloatArrayList.emptyList();
    }

    protected static Internal.IntList emptyIntList() {
        return IntArrayList.emptyList();
    }

    protected static Internal.LongList emptyLongList() {
        return LongArrayList.emptyList();
    }

    protected static <E> Internal.ProtobufList<E> emptyProtobufList() {
        return ProtobufArrayList.emptyList();
    }

    private void ensureUnknownFieldsInitialized() {
        if (this.unknownFields == UnknownFieldSetLite.getDefaultInstance()) {
            this.unknownFields = UnknownFieldSetLite.newInstance();
        }
    }

    static <T extends GeneratedMessageLite<?, ?>> T getDefaultInstance(Class<T> cls) {
        T t5 = (GeneratedMessageLite) defaultInstanceMap.get(cls);
        if (t5 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t5 = (GeneratedMessageLite) defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException("Class initialization cannot fail.", e5);
            }
        }
        if (t5 != null) {
            return t5;
        }
        T defaultInstanceForType = ((GeneratedMessageLite) UnsafeUtil.allocateInstance(cls)).getDefaultInstanceForType();
        if (defaultInstanceForType != null) {
            defaultInstanceMap.put(cls, defaultInstanceForType);
            return defaultInstanceForType;
        }
        throw new IllegalStateException();
    }

    static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e5);
        }
    }

    static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e5);
        } catch (InvocationTargetException e6) {
            Throwable cause = e6.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static Internal.IntList mutableCopy(Internal.IntList intList) {
        int size = intList.size();
        return intList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static Object newMessageInfo(MessageLite messageLite, String str, Object[] objArr) {
        return new RawMessageInfo(messageLite, str, objArr);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i5, WireFormat.FieldType fieldType, boolean z4, Class cls) {
        Internal.EnumLiteMap<?> enumLiteMap2 = enumLiteMap;
        int i6 = i5;
        return new GeneratedExtension<>(containingtype, Collections.EMPTY_LIST, messageLite, new ExtensionDescriptor(enumLiteMap2, i6, fieldType, true, z4), cls);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i5, WireFormat.FieldType fieldType, Class cls) {
        Internal.EnumLiteMap<?> enumLiteMap2 = enumLiteMap;
        MessageLite messageLite2 = messageLite;
        return new GeneratedExtension<>(containingtype, type, messageLite2, new ExtensionDescriptor(enumLiteMap2, i5, fieldType, false, false), cls);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T t5, InputStream inputStream) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialDelimitedFrom(t5, inputStream, ExtensionRegistryLite.getEmptyRegistry()));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t5, ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parseFrom(t5, CodedInputStream.newInstance(byteBuffer), extensionRegistryLite));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialDelimitedFrom(T t5, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            CodedInputStream newInstance = CodedInputStream.newInstance((InputStream) new AbstractMessageLite.Builder.LimitedInputStream(inputStream, CodedInputStream.readRawVarint32(read, inputStream)));
            T parsePartialFrom = parsePartialFrom(t5, newInstance, extensionRegistryLite);
            try {
                newInstance.checkLastTagWas(0);
                return parsePartialFrom;
            } catch (InvalidProtocolBufferException e5) {
                throw e5.setUnfinishedMessage(parsePartialFrom);
            }
        } catch (InvalidProtocolBufferException e6) {
            e = e6;
            if (e.getThrownFromInputStream()) {
                e = new InvalidProtocolBufferException((IOException) e);
            }
            throw e;
        } catch (IOException e7) {
            throw new InvalidProtocolBufferException(e7);
        }
    }

    static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t5, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T newMutableInstance = t5.newMutableInstance();
        try {
            Schema schemaFor = Protobuf.getInstance().schemaFor(newMutableInstance);
            schemaFor.mergeFrom(newMutableInstance, CodedInputStreamReader.forCodedInput(codedInputStream), extensionRegistryLite);
            schemaFor.makeImmutable(newMutableInstance);
            return newMutableInstance;
        } catch (InvalidProtocolBufferException e5) {
            e = e5;
            if (e.getThrownFromInputStream()) {
                e = new InvalidProtocolBufferException((IOException) e);
            }
            throw e.setUnfinishedMessage(newMutableInstance);
        } catch (UninitializedMessageException e6) {
            throw e6.asInvalidProtocolBufferException().setUnfinishedMessage(newMutableInstance);
        } catch (IOException e7) {
            if (e7.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e7.getCause());
            }
            throw new InvalidProtocolBufferException(e7).setUnfinishedMessage(newMutableInstance);
        } catch (RuntimeException e8) {
            if (e8.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e8.getCause());
            }
            throw e8;
        }
    }

    protected static <T extends GeneratedMessageLite<?, ?>> void registerDefaultInstance(Class<T> cls, T t5) {
        t5.markImmutable();
        defaultInstanceMap.put(cls, t5);
    }

    /* access modifiers changed from: package-private */
    public Object buildMessageInfo() throws Exception {
        return dynamicMethod(MethodToInvoke.BUILD_MESSAGE_INFO);
    }

    /* access modifiers changed from: package-private */
    public void clearMemoizedHashCode() {
        this.memoizedHashCode = 0;
    }

    /* access modifiers changed from: package-private */
    public void clearMemoizedSerializedSize() {
        setMemoizedSerializedSize(Integer.MAX_VALUE);
    }

    /* access modifiers changed from: package-private */
    public int computeHashCode() {
        return Protobuf.getInstance().schemaFor(this).hashCode(this);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> BuilderType createBuilder() {
        return (Builder) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    /* access modifiers changed from: protected */
    @CanIgnoreReturnValue
    public Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj) {
        return dynamicMethod(methodToInvoke, obj, (Object) null);
    }

    /* access modifiers changed from: protected */
    public abstract Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return Protobuf.getInstance().schemaFor(this).equals(this, (GeneratedMessageLite) obj);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int getMemoizedHashCode() {
        return this.memoizedHashCode;
    }

    /* access modifiers changed from: package-private */
    public int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize & Integer.MAX_VALUE;
    }

    public final Parser<MessageType> getParserForType() {
        return (Parser) dynamicMethod(MethodToInvoke.GET_PARSER);
    }

    /* access modifiers changed from: package-private */
    public int getSerializedSize(Schema schema) {
        if (isMutable()) {
            int computeSerializedSize = computeSerializedSize(schema);
            if (computeSerializedSize >= 0) {
                return computeSerializedSize;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + computeSerializedSize);
        } else if (getMemoizedSerializedSize() != Integer.MAX_VALUE) {
            return getMemoizedSerializedSize();
        } else {
            int computeSerializedSize2 = computeSerializedSize(schema);
            setMemoizedSerializedSize(computeSerializedSize2);
            return computeSerializedSize2;
        }
    }

    public int hashCode() {
        if (isMutable()) {
            return computeHashCode();
        }
        if (hashCodeIsNotMemoized()) {
            setMemoizedHashCode(computeHashCode());
        }
        return getMemoizedHashCode();
    }

    /* access modifiers changed from: package-private */
    public boolean hashCodeIsNotMemoized() {
        if (getMemoizedHashCode() == 0) {
            return true;
        }
        return false;
    }

    public final boolean isInitialized() {
        return isInitialized(this, true);
    }

    /* access modifiers changed from: package-private */
    public boolean isMutable() {
        if ((this.memoizedSerializedSize & Integer.MIN_VALUE) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void makeImmutable() {
        Protobuf.getInstance().schemaFor(this).makeImmutable(this);
        markImmutable();
    }

    /* access modifiers changed from: package-private */
    public void markImmutable() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    /* access modifiers changed from: protected */
    public void mergeLengthDelimitedField(int i5, ByteString byteString) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.mergeLengthDelimitedField(i5, byteString);
    }

    /* access modifiers changed from: protected */
    public final void mergeUnknownFields(UnknownFieldSetLite unknownFieldSetLite) {
        this.unknownFields = UnknownFieldSetLite.mutableCopyOf(this.unknownFields, unknownFieldSetLite);
    }

    /* access modifiers changed from: protected */
    public void mergeVarintField(int i5, int i6) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.mergeVarintField(i5, i6);
    }

    /* access modifiers changed from: package-private */
    public MessageType newMutableInstance() {
        return (GeneratedMessageLite) dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
    }

    /* access modifiers changed from: protected */
    public boolean parseUnknownField(int i5, CodedInputStream codedInputStream) throws IOException {
        if (WireFormat.getTagWireType(i5) == 4) {
            return false;
        }
        ensureUnknownFieldsInitialized();
        return this.unknownFields.mergeFieldFrom(i5, codedInputStream);
    }

    /* access modifiers changed from: package-private */
    public void setMemoizedHashCode(int i5) {
        this.memoizedHashCode = i5;
    }

    /* access modifiers changed from: package-private */
    public void setMemoizedSerializedSize(int i5) {
        if (i5 >= 0) {
            this.memoizedSerializedSize = (i5 & Integer.MAX_VALUE) | (this.memoizedSerializedSize & Integer.MIN_VALUE);
            return;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + i5);
    }

    public String toString() {
        return MessageLiteToString.toString(this, super.toString());
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        Protobuf.getInstance().schemaFor(this).writeTo(this, CodedOutputStreamWriter.forCodedOutput(codedOutputStream));
    }

    protected static final <T extends GeneratedMessageLite<T, ?>> boolean isInitialized(T t5, boolean z4) {
        byte byteValue = ((Byte) t5.dynamicMethod(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean isInitialized = Protobuf.getInstance().schemaFor(t5).isInitialized(t5);
        if (z4) {
            t5.dynamicMethod(MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED, isInitialized ? t5 : null);
        }
        return isInitialized;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> BuilderType createBuilder(MessageType messagetype) {
        return createBuilder().mergeFrom(messagetype);
    }

    /* access modifiers changed from: protected */
    public Object dynamicMethod(MethodToInvoke methodToInvoke) {
        return dynamicMethod(methodToInvoke, (Object) null, (Object) null);
    }

    public final MessageType getDefaultInstanceForType() {
        return (GeneratedMessageLite) dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    public final BuilderType newBuilderForType() {
        return (Builder) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    public final BuilderType toBuilder() {
        return ((Builder) dynamicMethod(MethodToInvoke.NEW_BUILDER)).mergeFrom(this);
    }

    protected static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {
        private final T defaultInstance;

        public DefaultInstanceBasedParser(T t5) {
            this.defaultInstance = t5;
        }

        public T parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parsePartialFrom(this.defaultInstance, codedInputStream, extensionRegistryLite);
        }

        public T parsePartialFrom(byte[] bArr, int i5, int i6, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parsePartialFrom(this.defaultInstance, bArr, i5, i6, extensionRegistryLite);
        }
    }

    protected static Internal.LongList mutableCopy(Internal.LongList longList) {
        int size = longList.size();
        return longList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t5, ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return parseFrom(t5, byteBuffer, ExtensionRegistryLite.getEmptyRegistry());
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T t5, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialDelimitedFrom(t5, inputStream, extensionRegistryLite));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t5, ByteString byteString) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parseFrom(t5, byteString, ExtensionRegistryLite.getEmptyRegistry()));
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        protected FieldSet<ExtensionDescriptor> extensions = FieldSet.emptySet();

        protected class ExtensionWriter {
            private final Iterator<Map.Entry<ExtensionDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<ExtensionDescriptor, Object> next;

            /* synthetic */ ExtensionWriter(ExtendableMessage extendableMessage, boolean z4, AnonymousClass1 r32) {
                this(z4);
            }

            public void writeUntil(int i5, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Map.Entry<ExtensionDescriptor, Object> entry = this.next;
                    if (entry != null && entry.getKey().getNumber() < i5) {
                        ExtensionDescriptor key = this.next.getKey();
                        if (!this.messageSetWireFormat || key.getLiteJavaType() != WireFormat.JavaType.MESSAGE || key.isRepeated()) {
                            FieldSet.writeField(key, this.next.getValue(), codedOutputStream);
                        } else {
                            codedOutputStream.writeMessageSetExtension(key.getNumber(), (MessageLite) this.next.getValue());
                        }
                        if (this.iter.hasNext()) {
                            this.next = this.iter.next();
                        } else {
                            this.next = null;
                        }
                    } else {
                        return;
                    }
                }
            }

            private ExtensionWriter(boolean z4) {
                Iterator<Map.Entry<ExtensionDescriptor, Object>> it = ExtendableMessage.this.extensions.iterator();
                this.iter = it;
                if (it.hasNext()) {
                    this.next = it.next();
                }
                this.messageSetWireFormat = z4;
            }
        }

        private void eagerlyMergeMessageSetExtension(CodedInputStream codedInputStream, GeneratedExtension<?, ?> generatedExtension, ExtensionRegistryLite extensionRegistryLite, int i5) throws IOException {
            ExtensionRegistryLite extensionRegistryLite2 = extensionRegistryLite;
            parseExtension(codedInputStream, extensionRegistryLite2, generatedExtension, WireFormat.makeTag(i5, 2), i5);
        }

        private void mergeMessageSetExtensionFromBytes(ByteString byteString, ExtensionRegistryLite extensionRegistryLite, GeneratedExtension<?, ?> generatedExtension) throws IOException {
            MessageLite.Builder builder;
            MessageLite messageLite = (MessageLite) this.extensions.getField(generatedExtension.descriptor);
            if (messageLite != null) {
                builder = messageLite.toBuilder();
            } else {
                builder = null;
            }
            if (builder == null) {
                builder = generatedExtension.getMessageDefaultInstance().newBuilderForType();
            }
            builder.mergeFrom(byteString, extensionRegistryLite);
            ensureExtensionsAreMutable().setField(generatedExtension.descriptor, generatedExtension.singularToFieldSetType(builder.build()));
        }

        private <MessageType extends MessageLite> void mergeMessageSetExtensionFromCodedStream(MessageType messagetype, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i5 = 0;
            ByteString byteString = null;
            GeneratedExtension generatedExtension = null;
            while (true) {
                int readTag = codedInputStream.readTag();
                if (readTag == 0) {
                    break;
                } else if (readTag == WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
                    i5 = codedInputStream.readUInt32();
                    if (i5 != 0) {
                        generatedExtension = extensionRegistryLite.findLiteExtensionByNumber(messagetype, i5);
                    }
                } else if (readTag == WireFormat.MESSAGE_SET_MESSAGE_TAG) {
                    if (i5 == 0 || generatedExtension == null) {
                        byteString = codedInputStream.readBytes();
                    } else {
                        eagerlyMergeMessageSetExtension(codedInputStream, generatedExtension, extensionRegistryLite, i5);
                        byteString = null;
                    }
                } else if (!codedInputStream.skipField(readTag)) {
                    break;
                }
            }
            codedInputStream.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
            if (byteString != null && i5 != 0) {
                if (generatedExtension != null) {
                    mergeMessageSetExtensionFromBytes(byteString, extensionRegistryLite, generatedExtension);
                } else {
                    mergeLengthDelimitedField(i5, byteString);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x003d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean parseExtension(androidx.datastore.preferences.protobuf.CodedInputStream r6, androidx.datastore.preferences.protobuf.ExtensionRegistryLite r7, androidx.datastore.preferences.protobuf.GeneratedMessageLite.GeneratedExtension<?, ?> r8, int r9, int r10) throws java.io.IOException {
            /*
                r5 = this;
                int r0 = androidx.datastore.preferences.protobuf.WireFormat.getTagWireType(r9)
                r1 = 1
                r2 = 0
                if (r8 != 0) goto L_0x000b
            L_0x0008:
                r0 = r1
                r3 = r2
                goto L_0x0036
            L_0x000b:
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r3 = r8.descriptor
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r3 = r3.getLiteType()
                int r3 = androidx.datastore.preferences.protobuf.FieldSet.getWireFormatForFieldType(r3, r2)
                if (r0 != r3) goto L_0x001a
                r0 = r2
                r3 = r0
                goto L_0x0036
            L_0x001a:
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r3 = r8.descriptor
                boolean r4 = r3.isRepeated
                if (r4 == 0) goto L_0x0008
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r3 = r3.type
                boolean r3 = r3.isPackable()
                if (r3 == 0) goto L_0x0008
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r3 = r8.descriptor
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r3 = r3.getLiteType()
                int r3 = androidx.datastore.preferences.protobuf.FieldSet.getWireFormatForFieldType(r3, r1)
                if (r0 != r3) goto L_0x0008
                r3 = r1
                r0 = r2
            L_0x0036:
                if (r0 == 0) goto L_0x003d
                boolean r6 = r5.parseUnknownField(r9, r6)
                return r6
            L_0x003d:
                r5.ensureExtensionsAreMutable()
                if (r3 == 0) goto L_0x0094
                int r7 = r6.readRawVarint32()
                int r7 = r6.pushLimit(r7)
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r8.descriptor
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r9 = r9.getLiteType()
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM
                if (r9 != r10) goto L_0x0077
            L_0x0054:
                int r9 = r6.getBytesUntilLimit()
                if (r9 <= 0) goto L_0x008f
                int r9 = r6.readEnum()
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r8.descriptor
                androidx.datastore.preferences.protobuf.Internal$EnumLiteMap r10 = r10.getEnumType()
                androidx.datastore.preferences.protobuf.Internal$EnumLite r9 = r10.findValueByNumber(r9)
                if (r9 != 0) goto L_0x006b
                return r1
            L_0x006b:
                androidx.datastore.preferences.protobuf.FieldSet<androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor> r10 = r5.extensions
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r0 = r8.descriptor
                java.lang.Object r9 = r8.singularToFieldSetType(r9)
                r10.addRepeatedField(r0, r9)
                goto L_0x0054
            L_0x0077:
                int r9 = r6.getBytesUntilLimit()
                if (r9 <= 0) goto L_0x008f
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r8.descriptor
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r9 = r9.getLiteType()
                java.lang.Object r9 = androidx.datastore.preferences.protobuf.FieldSet.readPrimitiveField(r6, r9, r2)
                androidx.datastore.preferences.protobuf.FieldSet<androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor> r10 = r5.extensions
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r0 = r8.descriptor
                r10.addRepeatedField(r0, r9)
                goto L_0x0077
            L_0x008f:
                r6.popLimit(r7)
                goto L_0x0124
            L_0x0094:
                int[] r9 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r0 = r8.descriptor
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r0 = r0.getLiteJavaType()
                int r0 = r0.ordinal()
                r9 = r9[r0]
                if (r9 == r1) goto L_0x00c8
                r7 = 2
                if (r9 == r7) goto L_0x00b2
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r8.descriptor
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r7 = r7.getLiteType()
                java.lang.Object r6 = androidx.datastore.preferences.protobuf.FieldSet.readPrimitiveField(r6, r7, r2)
                goto L_0x0105
            L_0x00b2:
                int r6 = r6.readEnum()
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r8.descriptor
                androidx.datastore.preferences.protobuf.Internal$EnumLiteMap r7 = r7.getEnumType()
                androidx.datastore.preferences.protobuf.Internal$EnumLite r7 = r7.findValueByNumber(r6)
                if (r7 != 0) goto L_0x00c6
                r5.mergeVarintField(r10, r6)
                return r1
            L_0x00c6:
                r6 = r7
                goto L_0x0105
            L_0x00c8:
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r8.descriptor
                boolean r9 = r9.isRepeated()
                if (r9 != 0) goto L_0x00e1
                androidx.datastore.preferences.protobuf.FieldSet<androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor> r9 = r5.extensions
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r8.descriptor
                java.lang.Object r9 = r9.getField(r10)
                androidx.datastore.preferences.protobuf.MessageLite r9 = (androidx.datastore.preferences.protobuf.MessageLite) r9
                if (r9 == 0) goto L_0x00e1
                androidx.datastore.preferences.protobuf.MessageLite$Builder r9 = r9.toBuilder()
                goto L_0x00e2
            L_0x00e1:
                r9 = 0
            L_0x00e2:
                if (r9 != 0) goto L_0x00ec
                androidx.datastore.preferences.protobuf.MessageLite r9 = r8.getMessageDefaultInstance()
                androidx.datastore.preferences.protobuf.MessageLite$Builder r9 = r9.newBuilderForType()
            L_0x00ec:
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r8.descriptor
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = r10.getLiteType()
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.GROUP
                if (r10 != r0) goto L_0x00fe
                int r10 = r8.getNumber()
                r6.readGroup((int) r10, (androidx.datastore.preferences.protobuf.MessageLite.Builder) r9, (androidx.datastore.preferences.protobuf.ExtensionRegistryLite) r7)
                goto L_0x0101
            L_0x00fe:
                r6.readMessage((androidx.datastore.preferences.protobuf.MessageLite.Builder) r9, (androidx.datastore.preferences.protobuf.ExtensionRegistryLite) r7)
            L_0x0101:
                androidx.datastore.preferences.protobuf.MessageLite r6 = r9.build()
            L_0x0105:
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r8.descriptor
                boolean r7 = r7.isRepeated()
                if (r7 == 0) goto L_0x0119
                androidx.datastore.preferences.protobuf.FieldSet<androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor> r7 = r5.extensions
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r8.descriptor
                java.lang.Object r6 = r8.singularToFieldSetType(r6)
                r7.addRepeatedField(r9, r6)
                goto L_0x0124
            L_0x0119:
                androidx.datastore.preferences.protobuf.FieldSet<androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor> r7 = r5.extensions
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r8.descriptor
                java.lang.Object r6 = r8.singularToFieldSetType(r6)
                r7.setField(r9, r6)
            L_0x0124:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessage.parseExtension(androidx.datastore.preferences.protobuf.CodedInputStream, androidx.datastore.preferences.protobuf.ExtensionRegistryLite, androidx.datastore.preferences.protobuf.GeneratedMessageLite$GeneratedExtension, int, int):boolean");
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public FieldSet<ExtensionDescriptor> ensureExtensionsAreMutable() {
            if (this.extensions.isImmutable()) {
                this.extensions = this.extensions.clone();
            }
            return this.extensions;
        }

        /* access modifiers changed from: protected */
        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        /* access modifiers changed from: protected */
        public int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        /* access modifiers changed from: protected */
        public int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.getMessageSetSerializedSize();
        }

        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return GeneratedMessageLite.super.getDefaultInstanceForType();
        }

        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite) {
            GeneratedExtension access$000 = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(access$000);
            Object field = this.extensions.getField(access$000.descriptor);
            if (field == null) {
                return access$000.defaultValue;
            }
            return access$000.fromFieldSetType(field);
        }

        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite) {
            GeneratedExtension access$000 = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(access$000);
            return this.extensions.getRepeatedFieldCount(access$000.descriptor);
        }

        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite) {
            GeneratedExtension access$000 = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(access$000);
            return this.extensions.hasField(access$000.descriptor);
        }

        /* access modifiers changed from: protected */
        public final void mergeExtensionFields(MessageType messagetype) {
            if (this.extensions.isImmutable()) {
                this.extensions = this.extensions.clone();
            }
            this.extensions.mergeFrom(messagetype.extensions);
        }

        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return GeneratedMessageLite.super.newBuilderForType();
        }

        /* access modifiers changed from: protected */
        public ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(this, false, (AnonymousClass1) null);
        }

        /* access modifiers changed from: protected */
        public ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(this, true, (AnonymousClass1) null);
        }

        /* access modifiers changed from: protected */
        public <MessageType extends MessageLite> boolean parseUnknownField(MessageType messagetype, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i5) throws IOException {
            int tagFieldNumber = WireFormat.getTagFieldNumber(i5);
            return parseExtension(codedInputStream, extensionRegistryLite, extensionRegistryLite.findLiteExtensionByNumber(messagetype, tagFieldNumber), i5, tagFieldNumber);
        }

        /* access modifiers changed from: protected */
        public <MessageType extends MessageLite> boolean parseUnknownFieldAsMessageSet(MessageType messagetype, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i5) throws IOException {
            if (i5 == WireFormat.MESSAGE_SET_ITEM_TAG) {
                mergeMessageSetExtensionFromCodedStream(messagetype, codedInputStream, extensionRegistryLite);
                return true;
            } else if (WireFormat.getTagWireType(i5) == 2) {
                return parseUnknownField(messagetype, codedInputStream, extensionRegistryLite, i5);
            } else {
                return codedInputStream.skipField(i5);
            }
        }

        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return GeneratedMessageLite.super.toBuilder();
        }

        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i5) {
            GeneratedExtension access$000 = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(access$000);
            return access$000.singularFromFieldSetType(this.extensions.getRepeatedField(access$000.descriptor, i5));
        }
    }

    protected static Internal.FloatList mutableCopy(Internal.FloatList floatList) {
        int size = floatList.size();
        return floatList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t5, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t5, byteString, extensionRegistryLite));
    }

    protected static Internal.DoubleList mutableCopy(Internal.DoubleList doubleList) {
        int size = doubleList.size();
        return doubleList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t5, byte[] bArr) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t5, bArr, 0, bArr.length, ExtensionRegistryLite.getEmptyRegistry()));
    }

    public int getSerializedSize() {
        return getSerializedSize((Schema) null);
    }

    protected static Internal.BooleanList mutableCopy(Internal.BooleanList booleanList) {
        int size = booleanList.size();
        return booleanList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t5, byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t5, bArr, 0, bArr.length, extensionRegistryLite));
    }

    protected static <E> Internal.ProtobufList<E> mutableCopy(Internal.ProtobufList<E> protobufList) {
        int size = protobufList.size();
        return protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t5, InputStream inputStream) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t5, CodedInputStream.newInstance(inputStream), ExtensionRegistryLite.getEmptyRegistry()));
    }

    /* access modifiers changed from: private */
    public static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t5, byte[] bArr, int i5, int i6, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        if (i6 == 0) {
            return t5;
        }
        T newMutableInstance = t5.newMutableInstance();
        try {
            Schema schemaFor = Protobuf.getInstance().schemaFor(newMutableInstance);
            schemaFor.mergeFrom(newMutableInstance, bArr, i5, i5 + i6, new ArrayDecoders.Registers(extensionRegistryLite));
            schemaFor.makeImmutable(newMutableInstance);
            return newMutableInstance;
        } catch (InvalidProtocolBufferException e5) {
            InvalidProtocolBufferException invalidProtocolBufferException = e5;
            if (invalidProtocolBufferException.getThrownFromInputStream()) {
                invalidProtocolBufferException = new InvalidProtocolBufferException((IOException) invalidProtocolBufferException);
            }
            throw invalidProtocolBufferException.setUnfinishedMessage(newMutableInstance);
        } catch (UninitializedMessageException e6) {
            throw e6.asInvalidProtocolBufferException().setUnfinishedMessage(newMutableInstance);
        } catch (IOException e7) {
            IOException iOException = e7;
            if (iOException.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) iOException.getCause());
            }
            throw new InvalidProtocolBufferException(iOException).setUnfinishedMessage(newMutableInstance);
        } catch (IndexOutOfBoundsException unused) {
            throw InvalidProtocolBufferException.truncatedMessage().setUnfinishedMessage(newMutableInstance);
        }
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t5, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t5, CodedInputStream.newInstance(inputStream), extensionRegistryLite));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t5, CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return parseFrom(t5, codedInputStream, ExtensionRegistryLite.getEmptyRegistry());
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t5, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t5, codedInputStream, extensionRegistryLite));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t5, CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return parsePartialFrom(t5, codedInputStream, ExtensionRegistryLite.getEmptyRegistry());
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t5, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        CodedInputStream newCodedInput = byteString.newCodedInput();
        T parsePartialFrom = parsePartialFrom(t5, newCodedInput, extensionRegistryLite);
        try {
            newCodedInput.checkLastTagWas(0);
            return parsePartialFrom;
        } catch (InvalidProtocolBufferException e5) {
            throw e5.setUnfinishedMessage(parsePartialFrom);
        }
    }
}
