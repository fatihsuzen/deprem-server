package androidx.datastore.preferences.protobuf;

import java.util.List;

public interface EnumValueOrBuilder extends MessageLiteOrBuilder {
    String getName();

    ByteString getNameBytes();

    int getNumber();

    Option getOptions(int i5);

    int getOptionsCount();

    List<Option> getOptionsList();
}
