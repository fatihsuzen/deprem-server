package com.mbridge.msdk.playercommon.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class DrmInitData implements Parcelable, Comparator<SchemeData> {
    public static final Parcelable.Creator<DrmInitData> CREATOR = new Parcelable.Creator<DrmInitData>() {
        public final DrmInitData createFromParcel(Parcel parcel) {
            return new DrmInitData(parcel);
        }

        public final DrmInitData[] newArray(int i5) {
            return new DrmInitData[i5];
        }
    };
    private int hashCode;
    public final int schemeDataCount;
    private final SchemeData[] schemeDatas;
    @Nullable
    public final String schemeType;

    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator<SchemeData> CREATOR = new Parcelable.Creator<SchemeData>() {
            public final SchemeData createFromParcel(Parcel parcel) {
                return new SchemeData(parcel);
            }

            public final SchemeData[] newArray(int i5) {
                return new SchemeData[i5];
            }
        };
        public final byte[] data;
        private int hashCode;
        @Nullable
        public final String licenseServerUrl;
        public final String mimeType;
        public final boolean requiresSecureDecryption;
        /* access modifiers changed from: private */
        public final UUID uuid;

        public SchemeData(UUID uuid2, String str, byte[] bArr) {
            this(uuid2, str, bArr, false);
        }

        public final boolean canReplace(SchemeData schemeData) {
            if (!hasData() || schemeData.hasData() || !matches(schemeData.uuid)) {
                return false;
            }
            return true;
        }

        public final int describeContents() {
            return 0;
        }

        public final boolean equals(@Nullable Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeData schemeData = (SchemeData) obj;
            if (!Util.areEqual(this.licenseServerUrl, schemeData.licenseServerUrl) || !Util.areEqual(this.mimeType, schemeData.mimeType) || !Util.areEqual(this.uuid, schemeData.uuid) || !Arrays.equals(this.data, schemeData.data)) {
                return false;
            }
            return true;
        }

        public final boolean hasData() {
            if (this.data != null) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            int i5;
            if (this.hashCode == 0) {
                int hashCode2 = this.uuid.hashCode() * 31;
                String str = this.licenseServerUrl;
                if (str == null) {
                    i5 = 0;
                } else {
                    i5 = str.hashCode();
                }
                this.hashCode = ((((hashCode2 + i5) * 31) + this.mimeType.hashCode()) * 31) + Arrays.hashCode(this.data);
            }
            return this.hashCode;
        }

        public final boolean matches(UUID uuid2) {
            if (C.UUID_NIL.equals(this.uuid) || uuid2.equals(this.uuid)) {
                return true;
            }
            return false;
        }

        public final void writeToParcel(Parcel parcel, int i5) {
            parcel.writeLong(this.uuid.getMostSignificantBits());
            parcel.writeLong(this.uuid.getLeastSignificantBits());
            parcel.writeString(this.licenseServerUrl);
            parcel.writeString(this.mimeType);
            parcel.writeByteArray(this.data);
            parcel.writeByte(this.requiresSecureDecryption ? (byte) 1 : 0);
        }

        public SchemeData(UUID uuid2, String str, byte[] bArr, boolean z4) {
            this(uuid2, (String) null, str, bArr, z4);
        }

        public SchemeData(UUID uuid2, @Nullable String str, String str2, byte[] bArr, boolean z4) {
            this.uuid = (UUID) Assertions.checkNotNull(uuid2);
            this.licenseServerUrl = str;
            this.mimeType = (String) Assertions.checkNotNull(str2);
            this.data = bArr;
            this.requiresSecureDecryption = z4;
        }

        SchemeData(Parcel parcel) {
            this.uuid = new UUID(parcel.readLong(), parcel.readLong());
            this.licenseServerUrl = parcel.readString();
            this.mimeType = parcel.readString();
            this.data = parcel.createByteArray();
            this.requiresSecureDecryption = parcel.readByte() != 0;
        }
    }

    public DrmInitData(List<SchemeData> list) {
        this((String) null, false, (SchemeData[]) list.toArray(new SchemeData[list.size()]));
    }

    private static boolean containsSchemeDataWithUuid(ArrayList<SchemeData> arrayList, int i5, UUID uuid) {
        for (int i6 = 0; i6 < i5; i6++) {
            if (arrayList.get(i6).uuid.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static DrmInitData createSessionCreationData(@Nullable DrmInitData drmInitData, @Nullable DrmInitData drmInitData2) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (drmInitData != null) {
            str = drmInitData.schemeType;
            for (SchemeData schemeData : drmInitData.schemeDatas) {
                if (schemeData.hasData()) {
                    arrayList.add(schemeData);
                }
            }
        } else {
            str = null;
        }
        if (drmInitData2 != null) {
            if (str == null) {
                str = drmInitData2.schemeType;
            }
            int size = arrayList.size();
            for (SchemeData schemeData2 : drmInitData2.schemeDatas) {
                if (schemeData2.hasData() && !containsSchemeDataWithUuid(arrayList, size, schemeData2.uuid)) {
                    arrayList.add(schemeData2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new DrmInitData(str, (List<SchemeData>) arrayList);
    }

    public final DrmInitData copyWithSchemeType(@Nullable String str) {
        if (Util.areEqual(this.schemeType, str)) {
            return this;
        }
        return new DrmInitData(str, false, this.schemeDatas);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && DrmInitData.class == obj.getClass()) {
            DrmInitData drmInitData = (DrmInitData) obj;
            if (!Util.areEqual(this.schemeType, drmInitData.schemeType) || !Arrays.equals(this.schemeDatas, drmInitData.schemeDatas)) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Deprecated
    public final SchemeData get(UUID uuid) {
        for (SchemeData schemeData : this.schemeDatas) {
            if (schemeData.matches(uuid)) {
                return schemeData;
            }
        }
        return null;
    }

    public final int hashCode() {
        int i5;
        if (this.hashCode == 0) {
            String str = this.schemeType;
            if (str == null) {
                i5 = 0;
            } else {
                i5 = str.hashCode();
            }
            this.hashCode = (i5 * 31) + Arrays.hashCode(this.schemeDatas);
        }
        return this.hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.schemeType);
        parcel.writeTypedArray(this.schemeDatas, 0);
    }

    public DrmInitData(String str, List<SchemeData> list) {
        this(str, false, (SchemeData[]) list.toArray(new SchemeData[list.size()]));
    }

    public final int compare(SchemeData schemeData, SchemeData schemeData2) {
        UUID uuid = C.UUID_NIL;
        if (uuid.equals(schemeData.uuid)) {
            return uuid.equals(schemeData2.uuid) ? 0 : 1;
        }
        return schemeData.uuid.compareTo(schemeData2.uuid);
    }

    public DrmInitData(SchemeData... schemeDataArr) {
        this((String) null, schemeDataArr);
    }

    public final SchemeData get(int i5) {
        return this.schemeDatas[i5];
    }

    public DrmInitData(@Nullable String str, SchemeData... schemeDataArr) {
        this(str, true, schemeDataArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData$SchemeData[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DrmInitData(@androidx.annotation.Nullable java.lang.String r1, boolean r2, com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData.SchemeData... r3) {
        /*
            r0 = this;
            r0.<init>()
            r0.schemeType = r1
            if (r2 == 0) goto L_0x000e
            java.lang.Object r1 = r3.clone()
            r3 = r1
            com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData$SchemeData[] r3 = (com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData.SchemeData[]) r3
        L_0x000e:
            java.util.Arrays.sort(r3, r0)
            r0.schemeDatas = r3
            int r1 = r3.length
            r0.schemeDataCount = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData.<init>(java.lang.String, boolean, com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData$SchemeData[]):void");
    }

    DrmInitData(Parcel parcel) {
        this.schemeType = parcel.readString();
        SchemeData[] schemeDataArr = (SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR);
        this.schemeDatas = schemeDataArr;
        this.schemeDataCount = schemeDataArr.length;
    }
}
