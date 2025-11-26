package androidx.datastore.preferences.protobuf;

import java.util.List;

public interface TypeOrBuilder extends MessageLiteOrBuilder {
    String getEdition();

    ByteString getEditionBytes();

    Field getFields(int i5);

    int getFieldsCount();

    List<Field> getFieldsList();

    String getName();

    ByteString getNameBytes();

    String getOneofs(int i5);

    ByteString getOneofsBytes(int i5);

    int getOneofsCount();

    List<String> getOneofsList();

    Option getOptions(int i5);

    int getOptionsCount();

    List<Option> getOptionsList();

    SourceContext getSourceContext();

    Syntax getSyntax();

    int getSyntaxValue();

    boolean hasSourceContext();
}
