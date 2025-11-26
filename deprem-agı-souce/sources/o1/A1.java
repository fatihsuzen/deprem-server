package O1;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.uptodown.activities.MainActivity;

public final /* synthetic */ class A1 implements TabLayoutMediator.TabConfigurationStrategy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MainActivity f3197a;

    public /* synthetic */ A1(MainActivity mainActivity) {
        this.f3197a = mainActivity;
    }

    public final void onConfigureTab(TabLayout.Tab tab, int i5) {
        MainActivity.n7(this.f3197a, tab, i5);
    }
}
