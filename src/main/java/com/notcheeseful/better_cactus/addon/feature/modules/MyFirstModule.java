package com.notcheeseful.better_cactus.addon.feature.modules;

import com.notcheeseful.better_cactus.addon.AddonTemplateMain;
import com.dwarslooper.cactus.client.event.EventHandler;
import com.dwarslooper.cactus.client.event.impl.ClientTickEvent;
import com.dwarslooper.cactus.client.feature.module.Module;
import com.dwarslooper.cactus.client.systems.config.settings.group.SettingGroup;
import com.dwarslooper.cactus.client.systems.config.settings.impl.BooleanSetting;
import com.dwarslooper.cactus.client.systems.config.settings.impl.Setting;
import com.dwarslooper.cactus.client.util.game.ChatUtils;

public class MyFirstModule extends Module {

    public MyFirstModule() {
        super("CactusLookBetter");
    }

}