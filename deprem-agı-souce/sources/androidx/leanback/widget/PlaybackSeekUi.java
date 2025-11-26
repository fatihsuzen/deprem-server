package androidx.leanback.widget;

public interface PlaybackSeekUi {

    public static class Client {
        public PlaybackSeekDataProvider getPlaybackSeekDataProvider() {
            return null;
        }

        public boolean isSeekEnabled() {
            return false;
        }

        public void onSeekFinished(boolean z4) {
        }

        public void onSeekPositionChanged(long j5) {
        }

        public void onSeekStarted() {
        }
    }

    void setPlaybackSeekUiClient(Client client);
}
