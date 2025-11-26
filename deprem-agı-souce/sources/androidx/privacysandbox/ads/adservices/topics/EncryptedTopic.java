package androidx.privacysandbox.ads.adservices.topics;

import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import j$.util.Objects;
import java.util.Arrays;
import kotlin.jvm.internal.t;
import t3.s;

@ExperimentalFeatures.Ext11OptIn
public final class EncryptedTopic {
    private final byte[] encapsulatedKey;
    private final byte[] encryptedTopic;
    private final String keyIdentifier;

    public EncryptedTopic(byte[] bArr, String str, byte[] bArr2) {
        t.e(bArr, "encryptedTopic");
        t.e(str, "keyIdentifier");
        t.e(bArr2, "encapsulatedKey");
        this.encryptedTopic = bArr;
        this.keyIdentifier = str;
        this.encapsulatedKey = bArr2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EncryptedTopic)) {
            return false;
        }
        EncryptedTopic encryptedTopic2 = (EncryptedTopic) obj;
        if (!Arrays.equals(this.encryptedTopic, encryptedTopic2.encryptedTopic) || !this.keyIdentifier.contentEquals(encryptedTopic2.keyIdentifier) || !Arrays.equals(this.encapsulatedKey, encryptedTopic2.encapsulatedKey)) {
            return false;
        }
        return true;
    }

    public final byte[] getEncapsulatedKey() {
        return this.encapsulatedKey;
    }

    public final byte[] getEncryptedTopic() {
        return this.encryptedTopic;
    }

    public final String getKeyIdentifier() {
        return this.keyIdentifier;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(Arrays.hashCode(this.encryptedTopic)), this.keyIdentifier, Integer.valueOf(Arrays.hashCode(this.encapsulatedKey)));
    }

    public String toString() {
        return "EncryptedTopic { " + ("EncryptedTopic=" + s.A(this.encryptedTopic) + ", KeyIdentifier=" + this.keyIdentifier + ", EncapsulatedKey=" + s.A(this.encapsulatedKey) + " }");
    }
}
