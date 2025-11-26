package androidx.datastore.preferences.protobuf;

@CheckReturnValue
final class ManifestSchemaFactory implements SchemaFactory {
    private static final MessageInfoFactory EMPTY_FACTORY = new MessageInfoFactory() {
        public boolean isSupported(Class<?> cls) {
            return false;
        }

        public MessageInfo messageInfoFor(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }
    };
    private final MessageInfoFactory messageInfoFactory;

    /* renamed from: androidx.datastore.preferences.protobuf.ManifestSchemaFactory$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$ProtoSyntax;

        static {
            int[] iArr = new int[ProtoSyntax.values().length];
            $SwitchMap$com$google$protobuf$ProtoSyntax = iArr;
            try {
                iArr[ProtoSyntax.PROTO3.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private static class CompositeMessageInfoFactory implements MessageInfoFactory {
        private MessageInfoFactory[] factories;

        CompositeMessageInfoFactory(MessageInfoFactory... messageInfoFactoryArr) {
            this.factories = messageInfoFactoryArr;
        }

        public boolean isSupported(Class<?> cls) {
            for (MessageInfoFactory isSupported : this.factories) {
                if (isSupported.isSupported(cls)) {
                    return true;
                }
            }
            return false;
        }

        public MessageInfo messageInfoFor(Class<?> cls) {
            for (MessageInfoFactory messageInfoFactory : this.factories) {
                if (messageInfoFactory.isSupported(cls)) {
                    return messageInfoFactory.messageInfoFor(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }
    }

    public ManifestSchemaFactory() {
        this(getDefaultMessageInfoFactory());
    }

    private static boolean allowExtensions(MessageInfo messageInfo) {
        if (AnonymousClass2.$SwitchMap$com$google$protobuf$ProtoSyntax[messageInfo.getSyntax().ordinal()] != 1) {
            return true;
        }
        return false;
    }

    private static MessageInfoFactory getDefaultMessageInfoFactory() {
        return new CompositeMessageInfoFactory(GeneratedMessageInfoFactory.getInstance(), getDescriptorMessageInfoFactory());
    }

    private static MessageInfoFactory getDescriptorMessageInfoFactory() {
        if (Protobuf.assumeLiteRuntime) {
            return EMPTY_FACTORY;
        }
        try {
            return (MessageInfoFactory) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (Exception unused) {
            return EMPTY_FACTORY;
        }
    }

    private static <T> Schema<T> newSchema(Class<T> cls, MessageInfo messageInfo) {
        ExtensionSchema<?> extensionSchema = null;
        if (useLiteRuntime(cls)) {
            NewInstanceSchema lite = NewInstanceSchemas.lite();
            ListFieldSchema lite2 = ListFieldSchemas.lite();
            UnknownFieldSchema<?, ?> unknownFieldSetLiteSchema = SchemaUtil.unknownFieldSetLiteSchema();
            if (allowExtensions(messageInfo)) {
                extensionSchema = ExtensionSchemas.lite();
            }
            return MessageSchema.newSchema(cls, messageInfo, lite, lite2, unknownFieldSetLiteSchema, extensionSchema, MapFieldSchemas.lite());
        }
        Class<T> cls2 = cls;
        NewInstanceSchema full = NewInstanceSchemas.full();
        ExtensionSchema<?> extensionSchema2 = null;
        MessageInfo messageInfo2 = messageInfo;
        ListFieldSchema full2 = ListFieldSchemas.full();
        UnknownFieldSchema<?, ?> unknownFieldSetFullSchema = SchemaUtil.unknownFieldSetFullSchema();
        if (allowExtensions(messageInfo2)) {
            extensionSchema2 = ExtensionSchemas.full();
        }
        return MessageSchema.newSchema(cls2, messageInfo2, full, full2, unknownFieldSetFullSchema, extensionSchema2, MapFieldSchemas.full());
    }

    private static boolean useLiteRuntime(Class<?> cls) {
        if (Protobuf.assumeLiteRuntime || GeneratedMessageLite.class.isAssignableFrom(cls)) {
            return true;
        }
        return false;
    }

    public <T> Schema<T> createSchema(Class<T> cls) {
        SchemaUtil.requireGeneratedMessage(cls);
        MessageInfo messageInfoFor = this.messageInfoFactory.messageInfoFor(cls);
        if (!messageInfoFor.isMessageSetWireFormat()) {
            return newSchema(cls, messageInfoFor);
        }
        if (useLiteRuntime(cls)) {
            return MessageSetSchema.newSchema(SchemaUtil.unknownFieldSetLiteSchema(), ExtensionSchemas.lite(), messageInfoFor.getDefaultInstance());
        }
        return MessageSetSchema.newSchema(SchemaUtil.unknownFieldSetFullSchema(), ExtensionSchemas.full(), messageInfoFor.getDefaultInstance());
    }

    private ManifestSchemaFactory(MessageInfoFactory messageInfoFactory2) {
        this.messageInfoFactory = (MessageInfoFactory) Internal.checkNotNull(messageInfoFactory2, "messageInfoFactory");
    }
}
