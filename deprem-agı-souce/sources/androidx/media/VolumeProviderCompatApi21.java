package androidx.media;

import android.media.VolumeProvider;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
class VolumeProviderCompatApi21 {

    public interface Delegate {
        void onAdjustVolume(int i5);

        void onSetVolumeTo(int i5);
    }

    private VolumeProviderCompatApi21() {
    }

    public static Object createVolumeProvider(int i5, int i6, int i7, final Delegate delegate) {
        return new VolumeProvider(i5, i6, i7) {
            public void onAdjustVolume(int i5) {
                delegate.onAdjustVolume(i5);
            }

            public void onSetVolumeTo(int i5) {
                delegate.onSetVolumeTo(i5);
            }
        };
    }

    public static void setCurrentVolume(Object obj, int i5) {
        ((VolumeProvider) obj).setCurrentVolume(i5);
    }
}
