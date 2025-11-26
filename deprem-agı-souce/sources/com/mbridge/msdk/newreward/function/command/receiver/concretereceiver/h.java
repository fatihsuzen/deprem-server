package com.mbridge.msdk.newreward.function.command.receiver.concretereceiver;

import android.content.Intent;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.c;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.c.c.n;
import com.mbridge.msdk.newreward.function.c.c.x;
import com.mbridge.msdk.newreward.function.command.receiver.b;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.reward.player.MBRewardVideoActivity;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class h implements b {

    /* renamed from: a  reason: collision with root package name */
    e f10818a;

    private static class a extends com.mbridge.msdk.video.bt.module.b.b {

        /* renamed from: a  reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.c.a.b f10819a;

        /* renamed from: d  reason: collision with root package name */
        private final e f10820d;

        public a(com.mbridge.msdk.newreward.function.c.a.b bVar, e eVar) {
            this.f10819a = bVar;
            this.f10820d = eVar;
            this.f12013b = false;
            this.f12014c = false;
        }

        public final void a(int i5, String str, String str2) {
        }

        public final void b(String str, String str2) {
            RewardVideoListener rewardVideoListener;
            try {
                com.mbridge.msdk.foundation.d.b a5 = com.mbridge.msdk.foundation.d.b.a();
                a5.a(str2 + "_" + 2, 2);
                e eVar = this.f10820d;
                if (eVar != null) {
                    rewardVideoListener = eVar.K();
                } else {
                    rewardVideoListener = null;
                }
                if (rewardVideoListener != null) {
                    rewardVideoListener.onEndcardShow(new MBridgeIds(this.f10820d.C(), this.f10820d.H()));
                }
            } catch (Exception e5) {
                af.b("DefaultShowRewardListener", "onEndcardShow", e5);
            }
        }

        public final void a(c cVar) {
            RewardVideoListener rewardVideoListener;
            int i5;
            int i6;
            try {
                this.f12013b = true;
                com.mbridge.msdk.newreward.function.d.c.a().b().a(this.f10819a.c(), this.f10819a.d(), this.f10819a.e(), this.f10819a.g(), 6);
                e eVar = this.f10820d;
                if (eVar != null) {
                    rewardVideoListener = eVar.K();
                    com.mbridge.msdk.foundation.same.report.d.e eVar2 = new com.mbridge.msdk.foundation.same.report.d.e();
                    int i7 = 0;
                    if (this.f10820d.D() == null || this.f10820d.D().b() == null) {
                        i6 = 0;
                        i5 = 0;
                    } else {
                        com.mbridge.msdk.newreward.function.c.a.b b5 = this.f10820d.D().b();
                        i6 = b5.a();
                        i5 = b5.b();
                        if (b5.E() != null && !b5.E().isEmpty()) {
                            i7 = b5.E().get(0).getFilterCallBackState();
                        }
                    }
                    eVar2.a(CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(i7));
                    eVar2.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, Integer.valueOf(i6));
                    eVar2.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, Integer.valueOf(i5));
                    cVar.a("2000130", eVar2);
                } else {
                    rewardVideoListener = null;
                }
                d.a().a("2000130", cVar);
                if (rewardVideoListener != null) {
                    rewardVideoListener.onAdShow(new MBridgeIds(this.f10820d.C(), this.f10820d.H()));
                }
            } catch (Exception e5) {
                af.b("DefaultShowRewardListener", "onAdShow", e5);
            }
        }

        public final void a(c cVar, boolean z4, com.mbridge.msdk.videocommon.b.c cVar2) {
            try {
                d.a().a("2000152", cVar);
                e eVar = this.f10820d;
                RewardVideoListener K4 = eVar != null ? eVar.K() : null;
                if (K4 != null) {
                    K4.onAdClose(new MBridgeIds(this.f10820d.C(), this.f10820d.H()), new RewardInfo(z4, cVar2.a(), String.valueOf(cVar2.b())));
                }
            } catch (Exception e5) {
                af.b("DefaultShowRewardListener", "onAdClose", e5);
            }
        }

        public final void a(c cVar, String str) {
            int i5;
            int i6;
            try {
                this.f12014c = true;
                com.mbridge.msdk.newreward.function.d.c.a().b().a(this.f10819a.c(), this.f10819a.d(), this.f10819a.e(), this.f10819a.g(), 7);
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar.a("reason", str);
                e eVar2 = this.f10820d;
                if (eVar2 != null) {
                    int i7 = 0;
                    if (eVar2.D() == null || this.f10820d.D().b() == null) {
                        i6 = 0;
                        i5 = 0;
                    } else {
                        com.mbridge.msdk.newreward.function.c.a.b b5 = this.f10820d.D().b();
                        i6 = b5.a();
                        i5 = b5.b();
                        if (b5.E() != null && !b5.E().isEmpty()) {
                            i7 = b5.E().get(0).getFilterCallBackState();
                        }
                    }
                    eVar.a(CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(i7));
                    eVar.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, Integer.valueOf(i6));
                    eVar.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, Integer.valueOf(i5));
                }
                cVar.a("2000131", eVar);
                d.a().a("2000131", cVar);
                e eVar3 = this.f10820d;
                RewardVideoListener K4 = eVar3 != null ? eVar3.K() : null;
                if (K4 != null) {
                    K4.onShowFail(new MBridgeIds(this.f10820d.C(), this.f10820d.H()), str);
                }
            } catch (Exception e5) {
                af.b("DefaultShowRewardListener", "onShowFail", e5);
            }
        }

        public final void a(boolean z4, String str, String str2) {
            try {
                e eVar = this.f10820d;
                RewardVideoListener K4 = eVar != null ? eVar.K() : null;
                if (K4 != null) {
                    K4.onVideoAdClicked(new MBridgeIds(this.f10820d.C(), this.f10820d.H()));
                }
            } catch (Exception e5) {
                af.b("DefaultShowRewardListener", "onVideoAdClicked", e5);
            }
        }

        public final void a(String str, String str2) {
            try {
                e eVar = this.f10820d;
                RewardVideoListener K4 = eVar != null ? eVar.K() : null;
                if (K4 != null) {
                    K4.onVideoComplete(new MBridgeIds(this.f10820d.C(), this.f10820d.H()));
                }
            } catch (Exception e5) {
                af.b("DefaultShowRewardListener", "onVideoComplete", e5);
            }
        }

        public final void a(boolean z4, int i5) {
            try {
                e eVar = this.f10820d;
                RewardVideoListener K4 = eVar != null ? eVar.K() : null;
                if (K4 != null) {
                    K4.onAdCloseWithIVReward(new MBridgeIds(this.f10820d.C(), this.f10820d.H()), z4, i5);
                }
            } catch (Exception e5) {
                af.b("DefaultShowRewardListener", "onAdCloseWithIVReward", e5);
            }
        }
    }

    public final void a(Object obj) {
        boolean z4;
        e eVar = (e) ((com.mbridge.msdk.newreward.function.command.b) obj).b();
        this.f10818a = eVar;
        if (eVar != null) {
            try {
                com.mbridge.msdk.newreward.function.c.a.b b5 = eVar.D().b();
                a aVar = new a(b5, this.f10818a);
                Class<MBRewardVideoActivity> cls = MBRewardVideoActivity.class;
                try {
                    String str = MBRewardVideoActivity.INTENT_UNITID;
                    Intent intent = new Intent(com.mbridge.msdk.foundation.controller.c.m().c(), cls);
                    intent.putExtra(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.f10818a.H());
                    intent.putExtra(MBridgeConstans.PLACEMENT_ID, this.f10818a.C());
                    intent.putExtra(CampaignEx.JSON_NATIVE_VIDEO_MUTE, this.f10818a.O());
                    if (this.f10818a.h() == 287) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    intent.putExtra("isIV", z4);
                    intent.putExtra("isBid", TextUtils.isEmpty(this.f10818a.J()));
                    if (z4) {
                        intent.putExtra("ivRewardMode", this.f10818a.t());
                        intent.putExtra("ivRewardValueType", this.f10818a.u());
                        intent.putExtra("ivRewardValue", this.f10818a.v());
                    }
                    intent.putExtra("isBigOffer", !TextUtils.isEmpty(b5.B()));
                    intent.putExtra("is_refactor", true);
                    List<com.mbridge.msdk.newreward.function.c.a.a> u5 = b5.u();
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
                    for (com.mbridge.msdk.newreward.function.c.a.a next : u5) {
                        CampaignEx h5 = next.h();
                        h5.setReady_rate(100);
                        copyOnWriteArrayList.add(h5);
                        com.mbridge.msdk.videocommon.download.a aVar2 = new com.mbridge.msdk.videocommon.download.a(com.mbridge.msdk.foundation.controller.c.m().c(), h5, this.f10818a.H(), 1);
                        aVar2.d(this.f10818a.h());
                        aVar2.d(h5.getVideoUrlEncode());
                        n d5 = next.d();
                        if (d5 != null) {
                            aVar2.c(d5.g().getPath());
                        }
                        copyOnWriteArrayList2.add(aVar2);
                        try {
                            n d6 = next.d();
                            if (d6 != null) {
                                d6.l().a(1, (x) null);
                            }
                        } catch (Exception e5) {
                            af.b("ShowReceiver", "downloadVideoForShow", e5);
                        }
                    }
                    com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f10818a.H(), (CopyOnWriteArrayList<CampaignEx>) copyOnWriteArrayList);
                    com.mbridge.msdk.videocommon.download.b.getInstance().b(this.f10818a.H(), (CopyOnWriteArrayList<com.mbridge.msdk.videocommon.download.a>) copyOnWriteArrayList2);
                    intent.addFlags(268435456);
                    MBridgeGlobalCommon.showRewardListenerMap.put(this.f10818a.H(), aVar);
                    com.mbridge.msdk.foundation.controller.c.m().c().startActivity(intent);
                } catch (Exception unused) {
                    aVar.a(new c(), "activity not found");
                }
            } catch (Exception e6) {
                af.b("ShowReceiver", "show", e6);
            }
        }
    }
}
