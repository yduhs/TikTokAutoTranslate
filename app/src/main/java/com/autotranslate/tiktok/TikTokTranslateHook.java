package com.autotranslate.tiktok;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Starter hook. This intentionally only logs when TikTok loads.
 * TikTok 45.5.3's view/data pipeline must be inspected before safe,
 * reliable auto-translation hooks can be implemented.
 */
public final class TikTokTranslateHook implements IXposedHookLoadPackage {
    private static final String TARGET_PACKAGE = "com.zhiliaoapp.musically";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {
        if (!TARGET_PACKAGE.equals(lpparam.packageName)) return;
        XposedBridge.log("TikTokAutoTranslate: loaded in TikTok "
                + lpparam.packageName + " / " + lpparam.processName);
    }
}
