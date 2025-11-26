package androidx.datastore.preferences.protobuf;

import java.util.List;

public interface ApiOrBuilder extends MessageLiteOrBuilder {
    Method getMethods(int i5);

    int getMethodsCount();

    List<Method> getMethodsList();

    Mixin getMixins(int i5);

    int getMixinsCount();

    List<Mixin> getMixinsList();

    String getName();

    ByteString getNameBytes();

    Option getOptions(int i5);

    int getOptionsCount();

    List<Option> getOptionsList();

    SourceContext getSourceContext();

    Syntax getSyntax();

    int getSyntaxValue();

    String getVersion();

    ByteString getVersionBytes();

    boolean hasSourceContext();
}
