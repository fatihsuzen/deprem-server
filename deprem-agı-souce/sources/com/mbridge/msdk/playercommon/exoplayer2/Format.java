package com.mbridge.msdk.playercommon.exoplayer2;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.Metadata;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import com.mbridge.msdk.playercommon.exoplayer2.video.ColorInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Format implements Parcelable {
    public static final Parcelable.Creator<Format> CREATOR = new Parcelable.Creator<Format>() {
        public final Format createFromParcel(Parcel parcel) {
            return new Format(parcel);
        }

        public final Format[] newArray(int i5) {
            return new Format[i5];
        }
    };
    public static final int NO_VALUE = -1;
    public static final long OFFSET_SAMPLE_RELATIVE = Long.MAX_VALUE;
    public final int accessibilityChannel;
    public final int bitrate;
    public final int channelCount;
    @Nullable
    public final String codecs;
    @Nullable
    public final ColorInfo colorInfo;
    @Nullable
    public final String containerMimeType;
    @Nullable
    public final DrmInitData drmInitData;
    public final int encoderDelay;
    public final int encoderPadding;
    public final float frameRate;
    private int hashCode;
    public final int height;
    @Nullable
    public final String id;
    public final List<byte[]> initializationData;
    @Nullable
    public final String language;
    public final int maxInputSize;
    @Nullable
    public final Metadata metadata;
    public final int pcmEncoding;
    public final float pixelWidthHeightRatio;
    @Nullable
    public final byte[] projectionData;
    public final int rotationDegrees;
    @Nullable
    public final String sampleMimeType;
    public final int sampleRate;
    public final int selectionFlags;
    public final int stereoMode;
    public final long subsampleOffsetUs;
    public final int width;

    Format(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i5, int i6, int i7, int i8, float f5, int i9, float f6, @Nullable byte[] bArr, int i10, @Nullable ColorInfo colorInfo2, int i11, int i12, int i13, int i14, int i15, int i16, @Nullable String str5, int i17, long j5, @Nullable List<byte[]> list, @Nullable DrmInitData drmInitData2, @Nullable Metadata metadata2) {
        this.id = str;
        this.containerMimeType = str2;
        this.sampleMimeType = str3;
        this.codecs = str4;
        this.bitrate = i5;
        this.maxInputSize = i6;
        this.width = i7;
        this.height = i8;
        this.frameRate = f5;
        int i18 = 0;
        this.rotationDegrees = i9 == -1 ? 0 : i9;
        this.pixelWidthHeightRatio = f6 == -1.0f ? 1.0f : f6;
        this.projectionData = bArr;
        this.stereoMode = i10;
        this.colorInfo = colorInfo2;
        this.channelCount = i11;
        this.sampleRate = i12;
        this.pcmEncoding = i13;
        int i19 = i14;
        this.encoderDelay = i19 == -1 ? 0 : i19;
        int i20 = i15;
        this.encoderPadding = i20 != -1 ? i20 : i18;
        this.selectionFlags = i16;
        this.language = str5;
        this.accessibilityChannel = i17;
        this.subsampleOffsetUs = j5;
        this.initializationData = list == null ? Collections.EMPTY_LIST : list;
        this.drmInitData = drmInitData2;
        this.metadata = metadata2;
    }

    public static Format createAudioContainerFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i5, int i6, int i7, List<byte[]> list, int i8, @Nullable String str5) {
        return new Format(str, str2, str3, str4, i5, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, i6, i7, -1, -1, -1, i8, str5, -1, Long.MAX_VALUE, list, (DrmInitData) null, (Metadata) null);
    }

    public static Format createAudioSampleFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, int i5, int i6, int i7, int i8, List<byte[]> list, @Nullable DrmInitData drmInitData2, int i9, @Nullable String str4) {
        return createAudioSampleFormat(str, str2, str3, i5, i6, i7, i8, -1, list, drmInitData2, i9, str4);
    }

    public static Format createContainerFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i5, int i6, @Nullable String str5) {
        return new Format(str, str2, str3, str4, i5, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, i6, str5, -1, Long.MAX_VALUE, (List<byte[]>) null, (DrmInitData) null, (Metadata) null);
    }

    public static Format createImageSampleFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, int i5, int i6, List<byte[]> list, @Nullable String str4, @Nullable DrmInitData drmInitData2) {
        return new Format(str, (String) null, str2, str3, i5, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, i6, str4, -1, Long.MAX_VALUE, list, drmInitData2, (Metadata) null);
    }

    public static Format createSampleFormat(@Nullable String str, @Nullable String str2, long j5) {
        return new Format(str, (String) null, str2, (String) null, -1, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, 0, (String) null, -1, j5, (List<byte[]>) null, (DrmInitData) null, (Metadata) null);
    }

    public static Format createTextContainerFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i5, int i6, @Nullable String str5) {
        return createTextContainerFormat(str, str2, str3, str4, i5, i6, str5, -1);
    }

    public static Format createTextSampleFormat(@Nullable String str, String str2, int i5, @Nullable String str3) {
        return createTextSampleFormat(str, str2, i5, str3, (DrmInitData) null);
    }

    public static Format createVideoContainerFormat(@Nullable String str, @Nullable String str2, String str3, String str4, int i5, int i6, int i7, float f5, List<byte[]> list, int i8) {
        return new Format(str, str2, str3, str4, i5, -1, i6, i7, f5, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, i8, (String) null, -1, Long.MAX_VALUE, list, (DrmInitData) null, (Metadata) null);
    }

    public static Format createVideoSampleFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, int i5, int i6, int i7, int i8, float f5, List<byte[]> list, @Nullable DrmInitData drmInitData2) {
        return createVideoSampleFormat(str, str2, str3, i5, i6, i7, i8, f5, list, -1, -1.0f, drmInitData2);
    }

    public static String toLogString(Format format) {
        if (format == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append(format.id);
        sb.append(", mimeType=");
        sb.append(format.sampleMimeType);
        if (format.bitrate != -1) {
            sb.append(", bitrate=");
            sb.append(format.bitrate);
        }
        if (!(format.width == -1 || format.height == -1)) {
            sb.append(", res=");
            sb.append(format.width);
            sb.append("x");
            sb.append(format.height);
        }
        if (format.frameRate != -1.0f) {
            sb.append(", fps=");
            sb.append(format.frameRate);
        }
        if (format.channelCount != -1) {
            sb.append(", channels=");
            sb.append(format.channelCount);
        }
        if (format.sampleRate != -1) {
            sb.append(", sample_rate=");
            sb.append(format.sampleRate);
        }
        if (format.language != null) {
            sb.append(", language=");
            sb.append(format.language);
        }
        return sb.toString();
    }

    public final Format copyWithContainerInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, int i5, int i6, int i7, int i8, @Nullable String str4) {
        String str5 = this.containerMimeType;
        int i9 = this.maxInputSize;
        float f5 = this.frameRate;
        int i10 = this.rotationDegrees;
        float f6 = this.pixelWidthHeightRatio;
        byte[] bArr = this.projectionData;
        int i11 = this.stereoMode;
        ColorInfo colorInfo2 = this.colorInfo;
        int i12 = this.channelCount;
        int i13 = this.sampleRate;
        int i14 = this.pcmEncoding;
        int i15 = this.encoderDelay;
        int i16 = this.encoderPadding;
        int i17 = this.accessibilityChannel;
        int i18 = i12;
        int i19 = i14;
        int i20 = i15;
        int i21 = i16;
        int i22 = i17;
        int i23 = i18;
        int i24 = i13;
        return new Format(str, str5, str2, str3, i5, i9, i6, i7, f5, i10, f6, bArr, i11, colorInfo2, i23, i24, i19, i20, i21, i8, str4, i22, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
    }

    public final Format copyWithDrmInitData(@Nullable DrmInitData drmInitData2) {
        String str = this.id;
        String str2 = this.containerMimeType;
        String str3 = this.sampleMimeType;
        String str4 = this.codecs;
        int i5 = this.bitrate;
        int i6 = this.maxInputSize;
        int i7 = this.width;
        int i8 = this.height;
        float f5 = this.frameRate;
        int i9 = this.rotationDegrees;
        float f6 = this.pixelWidthHeightRatio;
        byte[] bArr = this.projectionData;
        int i10 = this.stereoMode;
        ColorInfo colorInfo2 = this.colorInfo;
        int i11 = this.channelCount;
        int i12 = this.sampleRate;
        int i13 = this.pcmEncoding;
        int i14 = this.encoderDelay;
        int i15 = this.encoderPadding;
        int i16 = this.selectionFlags;
        String str5 = this.language;
        int i17 = this.accessibilityChannel;
        String str6 = str;
        long j5 = this.subsampleOffsetUs;
        List<byte[]> list = this.initializationData;
        long j6 = j5;
        return new Format(str6, str2, str3, str4, i5, i6, i7, i8, f5, i9, f6, bArr, i10, colorInfo2, i11, i12, i13, i14, i15, i16, str5, i17, j6, list, drmInitData2, this.metadata);
    }

    public final Format copyWithGaplessInfo(int i5, int i6) {
        String str = this.id;
        String str2 = this.containerMimeType;
        String str3 = this.sampleMimeType;
        String str4 = this.codecs;
        int i7 = this.bitrate;
        int i8 = this.maxInputSize;
        int i9 = this.width;
        int i10 = this.height;
        float f5 = this.frameRate;
        int i11 = this.rotationDegrees;
        float f6 = this.pixelWidthHeightRatio;
        byte[] bArr = this.projectionData;
        int i12 = this.stereoMode;
        ColorInfo colorInfo2 = this.colorInfo;
        int i13 = this.channelCount;
        int i14 = this.sampleRate;
        int i15 = this.pcmEncoding;
        String str5 = str;
        return new Format(str5, str2, str3, str4, i7, i8, i9, i10, f5, i11, f6, bArr, i12, colorInfo2, i13, i14, i15, i5, i6, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
    }

    public final Format copyWithManifestFormatInfo(Format format) {
        Format format2 = format;
        if (this == format2) {
            return this;
        }
        String str = format2.id;
        String str2 = this.codecs;
        if (str2 == null) {
            str2 = format2.codecs;
        }
        String str3 = str2;
        int i5 = this.bitrate;
        if (i5 == -1) {
            i5 = format2.bitrate;
        }
        int i6 = i5;
        float f5 = this.frameRate;
        if (f5 == -1.0f) {
            f5 = format2.frameRate;
        }
        float f6 = f5;
        int i7 = this.selectionFlags | format2.selectionFlags;
        String str4 = this.language;
        if (str4 == null) {
            str4 = format2.language;
        }
        String str5 = str4;
        DrmInitData createSessionCreationData = DrmInitData.createSessionCreationData(format2.drmInitData, this.drmInitData);
        return new Format(str, this.containerMimeType, this.sampleMimeType, str3, i6, this.maxInputSize, this.width, this.height, f6, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, i7, str5, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, createSessionCreationData, this.metadata);
    }

    public final Format copyWithMaxInputSize(int i5) {
        String str = this.id;
        String str2 = this.containerMimeType;
        String str3 = this.sampleMimeType;
        String str4 = this.codecs;
        int i6 = this.bitrate;
        int i7 = this.width;
        int i8 = this.height;
        float f5 = this.frameRate;
        int i9 = this.rotationDegrees;
        float f6 = this.pixelWidthHeightRatio;
        byte[] bArr = this.projectionData;
        int i10 = this.stereoMode;
        ColorInfo colorInfo2 = this.colorInfo;
        int i11 = this.channelCount;
        int i12 = this.sampleRate;
        int i13 = this.pcmEncoding;
        int i14 = this.encoderDelay;
        int i15 = this.encoderPadding;
        int i16 = this.selectionFlags;
        String str5 = this.language;
        int i17 = this.accessibilityChannel;
        String str6 = str;
        long j5 = this.subsampleOffsetUs;
        List<byte[]> list = this.initializationData;
        int i18 = i11;
        return new Format(str6, str2, str3, str4, i6, i5, i7, i8, f5, i9, f6, bArr, i10, colorInfo2, i18, i12, i13, i14, i15, i16, str5, i17, j5, list, this.drmInitData, this.metadata);
    }

    public final Format copyWithMetadata(@Nullable Metadata metadata2) {
        String str = this.id;
        String str2 = this.containerMimeType;
        String str3 = this.sampleMimeType;
        String str4 = this.codecs;
        int i5 = this.bitrate;
        int i6 = this.maxInputSize;
        int i7 = this.width;
        int i8 = this.height;
        float f5 = this.frameRate;
        int i9 = this.rotationDegrees;
        float f6 = this.pixelWidthHeightRatio;
        byte[] bArr = this.projectionData;
        int i10 = this.stereoMode;
        ColorInfo colorInfo2 = this.colorInfo;
        int i11 = this.channelCount;
        int i12 = this.sampleRate;
        int i13 = this.pcmEncoding;
        int i14 = this.encoderDelay;
        int i15 = this.encoderPadding;
        int i16 = this.selectionFlags;
        String str5 = this.language;
        int i17 = this.accessibilityChannel;
        long j5 = this.subsampleOffsetUs;
        long j6 = j5;
        return new Format(str, str2, str3, str4, i5, i6, i7, i8, f5, i9, f6, bArr, i10, colorInfo2, i11, i12, i13, i14, i15, i16, str5, i17, j6, this.initializationData, this.drmInitData, metadata2);
    }

    public final Format copyWithRotationDegrees(int i5) {
        String str = this.id;
        String str2 = this.containerMimeType;
        String str3 = this.sampleMimeType;
        String str4 = this.codecs;
        int i6 = this.bitrate;
        int i7 = this.maxInputSize;
        int i8 = this.width;
        int i9 = this.height;
        float f5 = this.frameRate;
        float f6 = this.pixelWidthHeightRatio;
        byte[] bArr = this.projectionData;
        int i10 = this.stereoMode;
        ColorInfo colorInfo2 = this.colorInfo;
        int i11 = this.channelCount;
        int i12 = this.sampleRate;
        int i13 = this.pcmEncoding;
        int i14 = this.encoderDelay;
        int i15 = this.encoderPadding;
        int i16 = this.selectionFlags;
        String str5 = this.language;
        int i17 = this.accessibilityChannel;
        String str6 = str;
        long j5 = this.subsampleOffsetUs;
        List<byte[]> list = this.initializationData;
        int i18 = i11;
        return new Format(str6, str2, str3, str4, i6, i7, i8, i9, f5, i5, f6, bArr, i10, colorInfo2, i18, i12, i13, i14, i15, i16, str5, i17, j5, list, this.drmInitData, this.metadata);
    }

    public final Format copyWithSubsampleOffsetUs(long j5) {
        String str = this.id;
        String str2 = this.containerMimeType;
        String str3 = this.sampleMimeType;
        String str4 = this.codecs;
        int i5 = this.bitrate;
        int i6 = this.maxInputSize;
        int i7 = this.width;
        int i8 = this.height;
        float f5 = this.frameRate;
        int i9 = this.rotationDegrees;
        float f6 = this.pixelWidthHeightRatio;
        byte[] bArr = this.projectionData;
        int i10 = this.stereoMode;
        ColorInfo colorInfo2 = this.colorInfo;
        int i11 = this.channelCount;
        int i12 = this.sampleRate;
        int i13 = this.pcmEncoding;
        int i14 = this.encoderDelay;
        int i15 = this.encoderPadding;
        int i16 = this.selectionFlags;
        String str5 = this.language;
        return new Format(str, str2, str3, str4, i5, i6, i7, i8, f5, i9, f6, bArr, i10, colorInfo2, i11, i12, i13, i14, i15, i16, str5, this.accessibilityChannel, j5, this.initializationData, this.drmInitData, this.metadata);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Format.class == obj.getClass()) {
            Format format = (Format) obj;
            if (this.bitrate == format.bitrate && this.maxInputSize == format.maxInputSize && this.width == format.width && this.height == format.height && this.frameRate == format.frameRate && this.rotationDegrees == format.rotationDegrees && this.pixelWidthHeightRatio == format.pixelWidthHeightRatio && this.stereoMode == format.stereoMode && this.channelCount == format.channelCount && this.sampleRate == format.sampleRate && this.pcmEncoding == format.pcmEncoding && this.encoderDelay == format.encoderDelay && this.encoderPadding == format.encoderPadding && this.subsampleOffsetUs == format.subsampleOffsetUs && this.selectionFlags == format.selectionFlags && Util.areEqual(this.id, format.id) && Util.areEqual(this.language, format.language) && this.accessibilityChannel == format.accessibilityChannel && Util.areEqual(this.containerMimeType, format.containerMimeType) && Util.areEqual(this.sampleMimeType, format.sampleMimeType) && Util.areEqual(this.codecs, format.codecs) && Util.areEqual(this.drmInitData, format.drmInitData) && Util.areEqual(this.metadata, format.metadata) && Util.areEqual(this.colorInfo, format.colorInfo) && Arrays.equals(this.projectionData, format.projectionData) && initializationDataEquals(format)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int getPixelCount() {
        int i5;
        int i6 = this.width;
        if (i6 == -1 || (i5 = this.height) == -1) {
            return -1;
        }
        return i6 * i5;
    }

    public final int hashCode() {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if (this.hashCode == 0) {
            String str = this.id;
            int i11 = 0;
            if (str == null) {
                i5 = 0;
            } else {
                i5 = str.hashCode();
            }
            int i12 = (527 + i5) * 31;
            String str2 = this.containerMimeType;
            if (str2 == null) {
                i6 = 0;
            } else {
                i6 = str2.hashCode();
            }
            int i13 = (i12 + i6) * 31;
            String str3 = this.sampleMimeType;
            if (str3 == null) {
                i7 = 0;
            } else {
                i7 = str3.hashCode();
            }
            int i14 = (i13 + i7) * 31;
            String str4 = this.codecs;
            if (str4 == null) {
                i8 = 0;
            } else {
                i8 = str4.hashCode();
            }
            int i15 = (((((((((((i14 + i8) * 31) + this.bitrate) * 31) + this.width) * 31) + this.height) * 31) + this.channelCount) * 31) + this.sampleRate) * 31;
            String str5 = this.language;
            if (str5 == null) {
                i9 = 0;
            } else {
                i9 = str5.hashCode();
            }
            int i16 = (((i15 + i9) * 31) + this.accessibilityChannel) * 31;
            DrmInitData drmInitData2 = this.drmInitData;
            if (drmInitData2 == null) {
                i10 = 0;
            } else {
                i10 = drmInitData2.hashCode();
            }
            int i17 = (i16 + i10) * 31;
            Metadata metadata2 = this.metadata;
            if (metadata2 != null) {
                i11 = metadata2.hashCode();
            }
            this.hashCode = i17 + i11;
        }
        return this.hashCode;
    }

    public final boolean initializationDataEquals(Format format) {
        if (this.initializationData.size() != format.initializationData.size()) {
            return false;
        }
        for (int i5 = 0; i5 < this.initializationData.size(); i5++) {
            if (!Arrays.equals(this.initializationData.get(i5), format.initializationData.get(i5))) {
                return false;
            }
        }
        return true;
    }

    public final String toString() {
        return "Format(" + this.id + ", " + this.containerMimeType + ", " + this.sampleMimeType + ", " + this.bitrate + ", " + this.language + ", [" + this.width + ", " + this.height + ", " + this.frameRate + "], [" + this.channelCount + ", " + this.sampleRate + "])";
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        boolean z4;
        parcel.writeString(this.id);
        parcel.writeString(this.containerMimeType);
        parcel.writeString(this.sampleMimeType);
        parcel.writeString(this.codecs);
        parcel.writeInt(this.bitrate);
        parcel.writeInt(this.maxInputSize);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.frameRate);
        parcel.writeInt(this.rotationDegrees);
        parcel.writeFloat(this.pixelWidthHeightRatio);
        if (this.projectionData != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Util.writeBoolean(parcel, z4);
        byte[] bArr = this.projectionData;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.stereoMode);
        parcel.writeParcelable(this.colorInfo, i5);
        parcel.writeInt(this.channelCount);
        parcel.writeInt(this.sampleRate);
        parcel.writeInt(this.pcmEncoding);
        parcel.writeInt(this.encoderDelay);
        parcel.writeInt(this.encoderPadding);
        parcel.writeInt(this.selectionFlags);
        parcel.writeString(this.language);
        parcel.writeInt(this.accessibilityChannel);
        parcel.writeLong(this.subsampleOffsetUs);
        int size = this.initializationData.size();
        parcel.writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            parcel.writeByteArray(this.initializationData.get(i6));
        }
        parcel.writeParcelable(this.drmInitData, 0);
        parcel.writeParcelable(this.metadata, 0);
    }

    public static Format createAudioSampleFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, int i5, int i6, int i7, int i8, int i9, List<byte[]> list, @Nullable DrmInitData drmInitData2, int i10, @Nullable String str4) {
        return createAudioSampleFormat(str, str2, str3, i5, i6, i7, i8, i9, -1, -1, list, drmInitData2, i10, str4, (Metadata) null);
    }

    public static Format createSampleFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, int i5, @Nullable DrmInitData drmInitData2) {
        return new Format(str, (String) null, str2, str3, i5, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, 0, (String) null, -1, Long.MAX_VALUE, (List<byte[]>) null, drmInitData2, (Metadata) null);
    }

    public static Format createTextContainerFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i5, int i6, @Nullable String str5, int i7) {
        return new Format(str, str2, str3, str4, i5, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, i6, str5, i7, Long.MAX_VALUE, (List<byte[]>) null, (DrmInitData) null, (Metadata) null);
    }

    public static Format createTextSampleFormat(@Nullable String str, String str2, int i5, @Nullable String str3, @Nullable DrmInitData drmInitData2) {
        return createTextSampleFormat(str, str2, (String) null, -1, i5, str3, -1, drmInitData2, Long.MAX_VALUE, Collections.EMPTY_LIST);
    }

    public static Format createVideoSampleFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, int i5, int i6, int i7, int i8, float f5, List<byte[]> list, int i9, float f6, @Nullable DrmInitData drmInitData2) {
        return createVideoSampleFormat(str, str2, str3, i5, i6, i7, i8, f5, list, i9, f6, (byte[]) null, -1, (ColorInfo) null, drmInitData2);
    }

    public static Format createAudioSampleFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, int i5, int i6, int i7, int i8, int i9, int i10, int i11, List<byte[]> list, @Nullable DrmInitData drmInitData2, int i12, @Nullable String str4, @Nullable Metadata metadata2) {
        return new Format(str, (String) null, str2, str3, i5, i6, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, i7, i8, i9, i10, i11, i12, str4, -1, Long.MAX_VALUE, list, drmInitData2, metadata2);
    }

    public static Format createVideoSampleFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, int i5, int i6, int i7, int i8, float f5, List<byte[]> list, int i9, float f6, byte[] bArr, int i10, @Nullable ColorInfo colorInfo2, @Nullable DrmInitData drmInitData2) {
        return new Format(str, (String) null, str2, str3, i5, i6, i7, i8, f5, i9, f6, bArr, i10, colorInfo2, -1, -1, -1, -1, -1, 0, (String) null, -1, Long.MAX_VALUE, list, drmInitData2, (Metadata) null);
    }

    public static Format createTextSampleFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, int i5, int i6, @Nullable String str4, int i7, @Nullable DrmInitData drmInitData2) {
        return createTextSampleFormat(str, str2, str3, i5, i6, str4, i7, drmInitData2, Long.MAX_VALUE, Collections.EMPTY_LIST);
    }

    public static Format createTextSampleFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, int i5, int i6, @Nullable String str4, @Nullable DrmInitData drmInitData2, long j5) {
        return createTextSampleFormat(str, str2, str3, i5, i6, str4, -1, drmInitData2, j5, Collections.EMPTY_LIST);
    }

    public static Format createTextSampleFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, int i5, int i6, @Nullable String str4, int i7, @Nullable DrmInitData drmInitData2, long j5, List<byte[]> list) {
        return new Format(str, (String) null, str2, str3, i5, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, i6, str4, i7, j5, list, drmInitData2, (Metadata) null);
    }

    Format(Parcel parcel) {
        this.id = parcel.readString();
        this.containerMimeType = parcel.readString();
        this.sampleMimeType = parcel.readString();
        this.codecs = parcel.readString();
        this.bitrate = parcel.readInt();
        this.maxInputSize = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.frameRate = parcel.readFloat();
        this.rotationDegrees = parcel.readInt();
        this.pixelWidthHeightRatio = parcel.readFloat();
        this.projectionData = Util.readBoolean(parcel) ? parcel.createByteArray() : null;
        this.stereoMode = parcel.readInt();
        this.colorInfo = (ColorInfo) parcel.readParcelable(ColorInfo.class.getClassLoader());
        this.channelCount = parcel.readInt();
        this.sampleRate = parcel.readInt();
        this.pcmEncoding = parcel.readInt();
        this.encoderDelay = parcel.readInt();
        this.encoderPadding = parcel.readInt();
        this.selectionFlags = parcel.readInt();
        this.language = parcel.readString();
        this.accessibilityChannel = parcel.readInt();
        this.subsampleOffsetUs = parcel.readLong();
        int readInt = parcel.readInt();
        this.initializationData = new ArrayList(readInt);
        for (int i5 = 0; i5 < readInt; i5++) {
            this.initializationData.add(parcel.createByteArray());
        }
        this.drmInitData = (DrmInitData) parcel.readParcelable(DrmInitData.class.getClassLoader());
        this.metadata = (Metadata) parcel.readParcelable(Metadata.class.getClassLoader());
    }
}
