package androidx.constraintlayout.core.state;

public interface RegistryCallback {
    String currentLayoutInformation();

    String currentMotionScene();

    long getLastModified();

    void onDimensions(int i5, int i6);

    void onNewMotionScene(String str);

    void onProgress(float f5);

    void setDrawDebug(int i5);

    void setLayoutInformationMode(int i5);
}
