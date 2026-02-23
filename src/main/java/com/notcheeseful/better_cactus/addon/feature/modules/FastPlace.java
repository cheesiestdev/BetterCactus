package com.notcheeseful.better_cactus.addon.feature.modules;

import com.dwarslooper.cactus.client.feature.module.Category;
import com.notcheeseful.better_cactus.addon.AddonTemplateMain;
import com.dwarslooper.cactus.client.feature.module.Module;
import com.dwarslooper.cactus.client.systems.config.settings.group.SettingGroup;
import com.dwarslooper.cactus.client.systems.config.settings.impl.BooleanSetting;
import com.dwarslooper.cactus.client.systems.config.settings.impl.Setting;

public class FastPlace extends Module {
    public static volatile FastPlace INSTANCE;

    // Fast place state management
    private boolean fastPlaceActive = false;

    public FastPlace(Category category) {
        super("fastPlace", category, new Module.Options());
        if (INSTANCE == null) {
            synchronized (FastPlace.class) {
                if (INSTANCE == null) {
                    INSTANCE = this;
                }
            }
        }
    }

    @Override
    public void onEnable() {
        // When module is enabled, fast place is active
        this.fastPlaceActive = true;
    }

    @Override
    public void onDisable() {
        // When module is disabled, fast place is disabled
        this.fastPlaceActive = false;
    }
}
