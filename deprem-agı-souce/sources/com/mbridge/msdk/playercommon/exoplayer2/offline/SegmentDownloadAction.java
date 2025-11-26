package com.mbridge.msdk.playercommon.exoplayer2.offline;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadAction;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import j$.util.DesugarCollections;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class SegmentDownloadAction<K extends Comparable<K>> extends DownloadAction {
    public final List<K> keys;

    protected static abstract class SegmentDownloadActionDeserializer<K> extends DownloadAction.Deserializer {
        public SegmentDownloadActionDeserializer(String str, int i5) {
            super(str, i5);
        }

        /* access modifiers changed from: protected */
        public abstract DownloadAction createDownloadAction(Uri uri, boolean z4, byte[] bArr, List<K> list);

        public final DownloadAction readFromStream(int i5, DataInputStream dataInputStream) throws IOException {
            Uri parse = Uri.parse(dataInputStream.readUTF());
            boolean readBoolean = dataInputStream.readBoolean();
            byte[] bArr = new byte[dataInputStream.readInt()];
            dataInputStream.readFully(bArr);
            int readInt = dataInputStream.readInt();
            ArrayList arrayList = new ArrayList();
            for (int i6 = 0; i6 < readInt; i6++) {
                arrayList.add(readKey(dataInputStream));
            }
            return createDownloadAction(parse, readBoolean, bArr, arrayList);
        }

        /* access modifiers changed from: protected */
        public abstract K readKey(DataInputStream dataInputStream) throws IOException;
    }

    protected SegmentDownloadAction(String str, int i5, Uri uri, boolean z4, @Nullable byte[] bArr, List<K> list) {
        super(str, i5, uri, z4, bArr);
        if (z4) {
            Assertions.checkArgument(list.isEmpty());
            this.keys = Collections.EMPTY_LIST;
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        this.keys = DesugarCollections.unmodifiableList(arrayList);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        return this.keys.equals(((SegmentDownloadAction) obj).keys);
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.keys.hashCode();
    }

    /* access modifiers changed from: protected */
    public abstract void writeKey(DataOutputStream dataOutputStream, K k5) throws IOException;

    public final void writeToStream(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeUTF(this.uri.toString());
        dataOutputStream.writeBoolean(this.isRemoveAction);
        dataOutputStream.writeInt(this.data.length);
        dataOutputStream.write(this.data);
        dataOutputStream.writeInt(this.keys.size());
        for (int i5 = 0; i5 < this.keys.size(); i5++) {
            writeKey(dataOutputStream, (Comparable) this.keys.get(i5));
        }
    }
}
