/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.search;

import android.provider.SearchIndexableResource;

import com.android.settings.ButtonSettings;
import com.android.settings.DataUsageSummary;
import com.android.settings.DateTimeSettings;
import com.android.settings.DevelopmentSettings;
import com.android.settings.DeviceInfoSettings;
import com.android.settings.DisplaySettings;
import com.android.settings.HomeSettings;
import com.android.settings.LegalSettings;
import com.android.settings.PrivacySettings;
import com.android.settings.bluros.MainSettings;
import com.android.settings.R;
import com.android.settings.ScreenPinningSettings;
import com.android.settings.SecuritySettings;
import com.android.settings.WallpaperTypeSettings;
import com.android.settings.WifiCallingSettings;
import com.android.settings.WirelessSettings;
import com.android.settings.accessibility.AccessibilitySettings;
import com.android.settings.applications.AdvancedAppSettings;
import com.android.settings.applications.ManageDefaultApps;
import com.android.settings.bluetooth.BluetoothSettings;
import com.android.settings.bluros.StatusBarSettings;
import com.android.settings.deviceinfo.StorageSettings;
import com.android.settings.fuelgauge.PowerUsageSummary;
import com.android.settings.inputmethod.InputMethodAndLanguageSettings;
import com.android.settings.location.LocationSettings;
import com.android.settings.location.ScanningSettings;
import com.android.settings.net.DataUsageMeteredSettings;
import com.android.settings.notification.NotificationManagerSettings;
import com.android.settings.notification.OtherSoundSettings;
import com.android.settings.notification.SoundSettings;
import com.android.settings.notification.ZenModePrioritySettings;
import com.android.settings.notification.ZenModeSettings;
import com.android.settings.print.PrintSettingsFragment;
import com.android.settings.bluros.LockScreenSettings;
import com.android.settings.bluros.MiscSettings;
import com.android.settings.bluros.animation.AnimationSettings;
import com.android.settings.bluros.RecentsSettings;
import com.android.settings.bluros.ClockSettings;
import com.android.settings.bluros.NotificationDrawerSettings;
import com.android.settings.bluros.CustomHeader;
import com.android.settings.bluros.FlingSettings;
import com.android.settings.bluros.Header;
import com.android.settings.bluros.HeaderColors;
import com.android.settings.bluros.HeaderFonts;
import com.android.settings.bluros.LockScreenGestures;
import com.android.settings.bluros.LockScreenMedia;
import com.android.settings.bluros.LockscreenUI;
import com.android.settings.bluros.Navbar;
import com.android.settings.bluros.NotificationColorSettings;
import com.android.settings.bluros.PulseSettings;
import com.android.settings.bluros.QsColors;
import com.android.settings.bluros.QsPanel;
import com.android.settings.bluros.RecentsStyles;
import com.android.settings.bluros.SmartbarSettings;
import com.android.settings.bluros.StatusBarColors;
import com.android.settings.sim.SimSettings;
import com.android.settings.users.UserSettings;
import com.android.settings.wifi.AdvancedWifiSettings;
import com.android.settings.wifi.SavedAccessPointsWifiSettings;
import com.android.settings.wifi.WifiSettings;

import java.util.Collection;
import java.util.HashMap;

public final class SearchIndexableResources {

    public static int NO_DATA_RES_ID = 0;

    private static HashMap<String, SearchIndexableResource> sResMap =
            new HashMap<String, SearchIndexableResource>();

    static {
        sResMap.put(WifiSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(WifiSettings.class.getName()),
                        NO_DATA_RES_ID,
                        WifiSettings.class.getName(),
                        R.drawable.ic_settings_wireless));

        sResMap.put(AdvancedWifiSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(AdvancedWifiSettings.class.getName()),
                        R.xml.wifi_advanced_settings,
                        AdvancedWifiSettings.class.getName(),
                        R.drawable.ic_settings_wireless));

        sResMap.put(SavedAccessPointsWifiSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(SavedAccessPointsWifiSettings.class.getName()),
                        NO_DATA_RES_ID,
                        SavedAccessPointsWifiSettings.class.getName(),
                        R.drawable.ic_settings_wireless));

        sResMap.put(BluetoothSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(BluetoothSettings.class.getName()),
                        NO_DATA_RES_ID,
                        BluetoothSettings.class.getName(),
                        R.drawable.ic_settings_bluetooth));
        sResMap.put(MainSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(MainSettings.class.getName()),
                        NO_DATA_RES_ID,
                        MainSettings.class.getName(),
                        R.drawable.ic_bluros_tools_tint));
        sResMap.put(SimSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(SimSettings.class.getName()),
                        NO_DATA_RES_ID,
                        SimSettings.class.getName(),
                        R.drawable.ic_settings_sim));

        sResMap.put(DataUsageSummary.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(DataUsageSummary.class.getName()),
                        NO_DATA_RES_ID,
                        DataUsageSummary.class.getName(),
                        R.drawable.ic_settings_data_usage));

        sResMap.put(DataUsageMeteredSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(DataUsageMeteredSettings.class.getName()),
                        NO_DATA_RES_ID,
                        DataUsageMeteredSettings.class.getName(),
                        R.drawable.ic_settings_data_usage));

        sResMap.put(WirelessSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(WirelessSettings.class.getName()),
                        NO_DATA_RES_ID,
                        WirelessSettings.class.getName(),
                        R.drawable.ic_settings_more));

        sResMap.put(SecuritySettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(SecuritySettings.class.getName()),
                        NO_DATA_RES_ID,
                        SecuritySettings.class.getName(),
                        R.drawable.ic_settings_security));

        sResMap.put(HomeSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(HomeSettings.class.getName()),
                        NO_DATA_RES_ID,
                        HomeSettings.class.getName(),
                        R.drawable.ic_settings_home));

        sResMap.put(DisplaySettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(DisplaySettings.class.getName()),
                        NO_DATA_RES_ID,
                        DisplaySettings.class.getName(),
                        R.drawable.ic_settings_display));

        sResMap.put(WallpaperTypeSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(WallpaperTypeSettings.class.getName()),
                        NO_DATA_RES_ID,
                        WallpaperTypeSettings.class.getName(),
                        R.drawable.ic_settings_display));

        sResMap.put(SoundSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(SoundSettings.class.getName()),
                        NO_DATA_RES_ID,
                        SoundSettings.class.getName(),
                        R.drawable.ic_settings_notifications));

        sResMap.put(NotificationManagerSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(NotificationManagerSettings.class.getName()),
                        NO_DATA_RES_ID,
                        NotificationManagerSettings.class.getName(),
                        R.drawable.ic_settings_notifications));

        sResMap.put(OtherSoundSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(OtherSoundSettings.class.getName()),
                        NO_DATA_RES_ID,
                        OtherSoundSettings.class.getName(),
                        R.drawable.ic_settings_notifications));

        sResMap.put(ZenModeSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(ZenModeSettings.class.getName()),
                        NO_DATA_RES_ID,
                        ZenModeSettings.class.getName(),
                        R.drawable.ic_settings_notifications));

        sResMap.put(ZenModePrioritySettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(ZenModePrioritySettings.class.getName()),
                        R.xml.zen_mode_priority_settings,
                        ZenModePrioritySettings.class.getName(),
                        R.drawable.ic_settings_notifications));

        sResMap.put(StorageSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(StorageSettings.class.getName()),
                        NO_DATA_RES_ID,
                        StorageSettings.class.getName(),
                        R.drawable.ic_settings_storage));

        sResMap.put(PowerUsageSummary.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(PowerUsageSummary.class.getName()),
                        R.xml.power_usage_summary,
                        PowerUsageSummary.class.getName(),
                        R.drawable.ic_settings_battery));

        sResMap.put(AdvancedAppSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(AdvancedAppSettings.class.getName()),
                        R.xml.advanced_apps,
                        AdvancedAppSettings.class.getName(),
                        R.drawable.ic_settings_applications));

        sResMap.put(ManageDefaultApps.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(ManageDefaultApps.class.getName()),
                        NO_DATA_RES_ID,
                        ManageDefaultApps.class.getName(),
                        R.drawable.ic_settings_applications));

        sResMap.put(UserSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(UserSettings.class.getName()),
                        NO_DATA_RES_ID,
                        UserSettings.class.getName(),
                        R.drawable.ic_settings_multiuser));

        sResMap.put(LocationSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(LocationSettings.class.getName()),
                        R.xml.location_settings,
                        LocationSettings.class.getName(),
                        R.drawable.ic_settings_location));

        sResMap.put(ScanningSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(ScanningSettings.class.getName()),
                        R.xml.location_scanning,
                        ScanningSettings.class.getName(),
                        R.drawable.ic_settings_location));

        sResMap.put(SecuritySettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(SecuritySettings.class.getName()),
                        NO_DATA_RES_ID,
                        SecuritySettings.class.getName(),
                        R.drawable.ic_settings_security));

        sResMap.put(ScreenPinningSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(ScreenPinningSettings.class.getName()),
                        NO_DATA_RES_ID,
                        ScreenPinningSettings.class.getName(),
                        R.drawable.ic_settings_security));

        sResMap.put(InputMethodAndLanguageSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(InputMethodAndLanguageSettings.class.getName()),
                        NO_DATA_RES_ID,
                        InputMethodAndLanguageSettings.class.getName(),
                        R.drawable.ic_settings_language));

        sResMap.put(PrivacySettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(PrivacySettings.class.getName()),
                        NO_DATA_RES_ID,
                        PrivacySettings.class.getName(),
                        R.drawable.ic_settings_backup));

        sResMap.put(DateTimeSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(DateTimeSettings.class.getName()),
                        R.xml.date_time_prefs,
                        DateTimeSettings.class.getName(),
                        R.drawable.ic_settings_date_time));

        sResMap.put(AccessibilitySettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(AccessibilitySettings.class.getName()),
                        NO_DATA_RES_ID,
                        AccessibilitySettings.class.getName(),
                        R.drawable.ic_settings_accessibility));

        sResMap.put(PrintSettingsFragment.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(PrintSettingsFragment.class.getName()),
                        NO_DATA_RES_ID,
                        PrintSettingsFragment.class.getName(),
                        R.drawable.ic_settings_print));

        sResMap.put(DevelopmentSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(DevelopmentSettings.class.getName()),
                        NO_DATA_RES_ID,
                        DevelopmentSettings.class.getName(),
                        R.drawable.ic_settings_development));

        sResMap.put(DeviceInfoSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(DeviceInfoSettings.class.getName()),
                        NO_DATA_RES_ID,
                        DeviceInfoSettings.class.getName(),
                        R.drawable.ic_settings_about));

        sResMap.put(LegalSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(LegalSettings.class.getName()),
                        NO_DATA_RES_ID,
                        LegalSettings.class.getName(),
                        R.drawable.ic_settings_about));

        sResMap.put(WifiCallingSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(WifiCallingSettings.class.getName()),
                        R.xml.wifi_calling_settings,
                        WifiCallingSettings.class.getName(),
                        R.drawable.ic_settings_wireless));

        sResMap.put(ButtonSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(ButtonSettings.class.getName()),
                        NO_DATA_RES_ID,
                        ButtonSettings.class.getName(),
                        R.drawable.bluros_buttons_icon));

        sResMap.put(StatusBarSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(StatusBarSettings.class.getName()),
                        NO_DATA_RES_ID,
                        StatusBarSettings.class.getName(),
                        R.drawable.bluros_statusbar_icon));

        sResMap.put(LockScreenSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(LockScreenSettings.class.getName()),
                        NO_DATA_RES_ID,
                        LockScreenSettings.class.getName(),
                        R.drawable.bluros_lock_icon));

        sResMap.put(MiscSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(MiscSettings.class.getName()),
                        NO_DATA_RES_ID,
                        MiscSettings.class.getName(),
                        R.drawable.bluros_misc_icon));

        sResMap.put(AnimationSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(AnimationSettings.class.getName()),
                        NO_DATA_RES_ID,
                        AnimationSettings.class.getName(),
                        R.drawable.bluros_animations_icon));

        sResMap.put(RecentsSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(RecentsSettings.class.getName()),
                        NO_DATA_RES_ID,
                        RecentsSettings.class.getName(),
                        R.drawable.bluros_recents_icon));

       sResMap.put(ClockSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(ClockSettings.class.getName()),
                        NO_DATA_RES_ID,
                        ClockSettings.class.getName(),
                        R.drawable.ic_settings_date_time_alpha));

       sResMap.put(NotificationDrawerSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(NotificationDrawerSettings.class.getName()),
                        NO_DATA_RES_ID,
                        NotificationDrawerSettings.class.getName(),
                        R.drawable.bluros_notification_drawer_icon));
                        
                        
       sResMap.put(CustomHeader.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(CustomHeader.class.getName()),
                        NO_DATA_RES_ID,
                        CustomHeader.class.getName(),
                        R.drawable.bluros_notification_drawer_icon));
                        
       sResMap.put(FlingSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(FlingSettings.class.getName()),
                        NO_DATA_RES_ID,
                        FlingSettings.class.getName(),
                        R.drawable.bluros_navbar_icon));
      
      sResMap.put(Header.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(Header.class.getName()),
                        NO_DATA_RES_ID,
                        Header.class.getName(),
                        R.drawable.bluros_notification_drawer_icon));                                                                        
                        
       sResMap.put(HeaderColors.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(HeaderColors.class.getName()),
                        NO_DATA_RES_ID,
                        HeaderColors.class.getName(),
                        R.drawable.bluros_notification_drawer_icon));
                        
       sResMap.put(HeaderFonts.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(HeaderFonts.class.getName()),
                        NO_DATA_RES_ID,
                        HeaderFonts.class.getName(),
                        R.drawable.bluros_notification_drawer_icon));
      
      sResMap.put(LockScreenGestures.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(LockScreenGestures.class.getName()),
                        NO_DATA_RES_ID,
                        LockScreenGestures.class.getName(),
                        R.drawable.bluros_lock_icon));
                                                
                        
       sResMap.put(LockScreenMedia.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(LockScreenMedia.class.getName()),
                        NO_DATA_RES_ID,
                        LockScreenMedia.class.getName(),
                        R.drawable.bluros_lock_icon));
                        
       sResMap.put(LockscreenUI.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(LockscreenUI.class.getName()),
                        NO_DATA_RES_ID,
                        LockscreenUI.class.getName(),
                        R.drawable.bluros_lock_icon));
      
      sResMap.put(Navbar.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(Navbar.class.getName()),
                        NO_DATA_RES_ID,
                        Navbar.class.getName(),
                        R.drawable.bluros_navbar_icon));
                        
                              
      sResMap.put(NotificationColorSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(NotificationColorSettings.class.getName()),
                        NO_DATA_RES_ID,
                        NotificationColorSettings.class.getName(),
                        R.drawable.bluros_notification_drawer_icon));
                        
                              
      sResMap.put(PulseSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(PulseSettings.class.getName()),
                        NO_DATA_RES_ID,
                        PulseSettings.class.getName(),
                         R.drawable.bluros_navbar_icon));
                         
    sResMap.put(QsColors.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(QsColors.class.getName()),
                        NO_DATA_RES_ID,
                        QsColors.class.getName(),
                        R.drawable.bluros_quick_settings_icon));
                        
                              
    sResMap.put(QsPanel.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(QsPanel.class.getName()),
                        NO_DATA_RES_ID,
                        QsPanel.class.getName(),
                        R.drawable.bluros_quick_settings_icon));
                        
                              
      sResMap.put(RecentsStyles.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(RecentsStyles.class.getName()),
                        NO_DATA_RES_ID,
                        RecentsStyles.class.getName(),
                         R.drawable.bluros_recents_icon));
    
        sResMap.put(SmartbarSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(SmartbarSettings.class.getName()),
                        NO_DATA_RES_ID,
                        SmartbarSettings.class.getName(),
                         R.drawable.bluros_navbar_icon));
                        
                              
     sResMap.put(StatusBarColors.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(StatusBarColors.class.getName()),
                        NO_DATA_RES_ID,
                        StatusBarColors.class.getName(),
                        R.drawable.bluros_quick_settings_icon));
    }

    private SearchIndexableResources() {
    }

    public static int size() {
        return sResMap.size();
    }

    public static SearchIndexableResource getResourceByName(String className) {
        return sResMap.get(className);
    }

    public static Collection<SearchIndexableResource> values() {
        return sResMap.values();
    }
}
