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

import com.android.settings.ButtonSettings;
import com.android.settings.ChooseLockGeneric;
import com.android.settings.DataUsageSummary;
import com.android.settings.DateTimeSettings;
import com.android.settings.DevelopmentSettings;
import com.android.settings.DeviceInfoSettings;
import com.android.settings.DisplaySettings;
import com.android.settings.HomeSettings;
import com.android.settings.LegalSettings;
import com.android.settings.bluros.MainSettings;
import com.android.settings.PrivacySettings;
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
import com.android.settings.notification.ZenModeAutomationSettings;
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

import java.util.HashMap;

/**
 * Utility class for dealing with Search Ranking.
 */
public final class Ranking {

    public static final int RANK_WIFI = 1;
    public static final int RANK_BT = 2;
    public static final int RANK_SIM = 3;
    public static final int RANK_DATA_USAGE = 4;
    public static final int RANK_WIRELESS = 5;
    public static final int RANK_HOME = 6;
    public static final int RANK_DISPLAY = 7;
    public static final int RANK_WALLPAPER = 8;
    public static final int RANK_NOTIFICATIONS = 9;
    public static final int RANK_APPS = 10;
    public static final int RANK_STORAGE = 11;
    public static final int RANK_POWER_USAGE = 12;
    public static final int RANK_USERS = 13;
    public static final int RANK_LOCATION = 14;
    public static final int RANK_SECURITY = 15;
    public static final int RANK_IME = 16;
    public static final int RANK_PRIVACY = 17;
    public static final int RANK_DATE_TIME = 18;
    public static final int RANK_ACCESSIBILITY = 19;
    public static final int RANK_PRINTING = 20;
    public static final int RANK_DEVELOPEMENT = 21;
    public static final int RANK_DEVICE_INFO = 22;
    public static final int RANK_RR = 23;
    public static final int RANK_BUTTONS = 24;
    public static final int RANK_STATUSBAR = 25;
    public static final int RANK_RR_LOCKSCREEN = 26;
    public static final int RANK_RR_MISC = 27;
    public static final int RANK_RR_ANIMATION = 28;
    public static final int RANK_RR_RECENTS = 29;
    public static final int RANK_RR_CLOCK = 30;
    public static final int RANK_RR_NF = 31;
    public static final int RANK_RR_CUSTOM_HEADER = 32;
    public static final int RANK_RR_FLING = 33;
    public static final int RANK_RR_HEADER = 34;
    public static final int RANK_RR_HEADERCOLORS = 35;
    public static final int RANK_RR_HEADER_FONTS = 36;
    public static final int RANK_RR_LSGESTURES = 37;
    public static final int RANK_RR_LSMEDIA= 38;
    public static final int RANK_RR_LSUI = 39;
    public static final int RANK_RR_NAVBAR = 40;
    public static final int RANK_RR_NCOLORS = 41;
    public static final int RANK_RR_PULSE = 42;
    public static final int RANK_RR_QSCOLORS= 43;
    public static final int RANK_RR_RECENTSSTYLES = 44;
    public static final int RANK_RR_SMARTBAR = 45;
    public static final int RANK_RR_SBCOLOR = 46;
    public static final int RANK_RR_QSPANEL= 47;
    public static final int RANK_UNDEFINED = -1;
    public static final int RANK_OTHERS = 1024;
    public static final int BASE_RANK_DEFAULT = 2048;

    public static int sCurrentBaseRank = BASE_RANK_DEFAULT;

    private static HashMap<String, Integer> sRankMap = new HashMap<String, Integer>();
    private static HashMap<String, Integer> sBaseRankMap = new HashMap<String, Integer>();

    static {
        // Wi-Fi
        sRankMap.put(WifiSettings.class.getName(), RANK_WIFI);
        sRankMap.put(AdvancedWifiSettings.class.getName(), RANK_WIFI);
        sRankMap.put(SavedAccessPointsWifiSettings.class.getName(), RANK_WIFI);

        // BT
        sRankMap.put(BluetoothSettings.class.getName(), RANK_BT);

        // SIM Cards
        sRankMap.put(SimSettings.class.getName(), RANK_SIM);

        // DataUsage
        sRankMap.put(DataUsageSummary.class.getName(), RANK_DATA_USAGE);
        sRankMap.put(DataUsageMeteredSettings.class.getName(), RANK_DATA_USAGE);

        // Other wireless settinfs
        sRankMap.put(WirelessSettings.class.getName(), RANK_WIRELESS);
        sRankMap.put(WifiCallingSettings.class.getName(), RANK_WIRELESS);

        // Home
        sRankMap.put(HomeSettings.class.getName(), RANK_HOME);
        
        // BlurOS
        sRankMap.put(MainSettings.class.getName(), RANK_RR);
        
        // Display
        sRankMap.put(DisplaySettings.class.getName(), RANK_DISPLAY);

        // Wallpapers
        sRankMap.put(WallpaperTypeSettings.class.getName(), RANK_WALLPAPER);

        // Notifications
        sRankMap.put(SoundSettings.class.getName(), RANK_NOTIFICATIONS);
        sRankMap.put(NotificationManagerSettings.class.getName(), RANK_NOTIFICATIONS);
        sRankMap.put(OtherSoundSettings.class.getName(), RANK_NOTIFICATIONS);
        sRankMap.put(ZenModeSettings.class.getName(), RANK_NOTIFICATIONS);
        sRankMap.put(ZenModePrioritySettings.class.getName(), RANK_NOTIFICATIONS);
        sRankMap.put(ZenModeAutomationSettings.class.getName(), RANK_NOTIFICATIONS);

        // Storage
        sRankMap.put(StorageSettings.class.getName(), RANK_STORAGE);

        // Battery
        sRankMap.put(PowerUsageSummary.class.getName(), RANK_POWER_USAGE);

        // Advanced app settings
        sRankMap.put(AdvancedAppSettings.class.getName(), RANK_APPS);
        sRankMap.put(ManageDefaultApps.class.getName(), RANK_APPS);

        // Users
        sRankMap.put(UserSettings.class.getName(), RANK_USERS);

        // Location
        sRankMap.put(LocationSettings.class.getName(), RANK_LOCATION);
        sRankMap.put(ScanningSettings.class.getName(), RANK_LOCATION);

        // Security
        sRankMap.put(SecuritySettings.class.getName(), RANK_SECURITY);
        sRankMap.put(ChooseLockGeneric.ChooseLockGenericFragment.class.getName(), RANK_SECURITY);
        sRankMap.put(ScreenPinningSettings.class.getName(), RANK_SECURITY);

        // IMEs
        sRankMap.put(InputMethodAndLanguageSettings.class.getName(), RANK_IME);

        // Privacy
        sRankMap.put(PrivacySettings.class.getName(), RANK_PRIVACY);

        // Date / Time
        sRankMap.put(DateTimeSettings.class.getName(), RANK_DATE_TIME);

        // Accessibility
        sRankMap.put(AccessibilitySettings.class.getName(), RANK_ACCESSIBILITY);

        // Print
        sRankMap.put(PrintSettingsFragment.class.getName(), RANK_PRINTING);

        // Development
        sRankMap.put(DevelopmentSettings.class.getName(), RANK_DEVELOPEMENT);

        // Device infos
        sRankMap.put(DeviceInfoSettings.class.getName(), RANK_DEVICE_INFO);
        sRankMap.put(LegalSettings.class.getName(), RANK_DEVICE_INFO);

        // Button settings
        sRankMap.put(ButtonSettings.class.getName(), RANK_BUTTONS);

        // Statusbar settings
        sRankMap.put(StatusBarSettings.class.getName(), RANK_STATUSBAR);
	

        // RR Lockscreen Settings
        sRankMap.put(LockScreenSettings.class.getName(), RANK_RR_LOCKSCREEN);

        // Misc Settings
        sRankMap.put(MiscSettings.class.getName(), RANK_RR_MISC);
	
        // Animation Settings
        sRankMap.put(AnimationSettings.class.getName(), RANK_RR_ANIMATION);

        // Recent settings
        sRankMap.put(RecentsSettings.class.getName(), RANK_RR_RECENTS);
	
        // Clock settings
        sRankMap.put(ClockSettings.class.getName(), RANK_RR_CLOCK);

	
        sRankMap.put(CustomHeader.class.getName(), RANK_RR_CUSTOM_HEADER);
        
        sRankMap.put(FlingSettings.class.getName(), RANK_RR_FLING);
        	       
        sRankMap.put(Header.class.getName(), RANK_RR_HEADER);
        	
        sRankMap.put(HeaderColors.class.getName(), RANK_RR_HEADERCOLORS);
        
        sRankMap.put(HeaderFonts.class.getName(), RANK_RR_HEADER_FONTS);

        sRankMap.put(LockScreenGestures.class.getName(), RANK_RR_LSGESTURES);

        sRankMap.put(LockScreenMedia.class.getName(),  RANK_RR_LSMEDIA);

        sRankMap.put(LockscreenUI.class.getName(), RANK_RR_LSUI);

        sRankMap.put(Navbar.class.getName(), RANK_RR_NAVBAR);

        sRankMap.put(NotificationColorSettings.class.getName(), RANK_RR_NCOLORS);
  
        sRankMap.put(PulseSettings.class.getName(), RANK_RR_PULSE);

        sRankMap.put(QsColors.class.getName(), RANK_RR_QSCOLORS);

        sRankMap.put(RecentsStyles.class.getName(), RANK_RR_RECENTSSTYLES);

        sRankMap.put(SmartbarSettings.class.getName(), RANK_RR_SMARTBAR);

        sRankMap.put(StatusBarColors.class.getName(), RANK_RR_SBCOLOR);   
        
        sRankMap.put(QsPanel.class.getName(), RANK_RR_QSPANEL);   
	
        sBaseRankMap.put("com.android.settings", 0);
    }

    public static int getRankForClassName(String className) {
        Integer rank = sRankMap.get(className);
        return (rank != null) ? (int) rank: RANK_OTHERS;
    }

    public static int getBaseRankForAuthority(String authority) {
        synchronized (sBaseRankMap) {
            Integer base = sBaseRankMap.get(authority);
            if (base != null) {
                return base;
            }
            sCurrentBaseRank++;
            sBaseRankMap.put(authority, sCurrentBaseRank);
            return sCurrentBaseRank;
        }
    }
}
