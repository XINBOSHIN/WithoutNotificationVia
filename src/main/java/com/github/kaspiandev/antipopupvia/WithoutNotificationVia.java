package com.github.xinboshin.withoutnotificationvia;

import net.md_5.bungee.api.plugin.Plugin;

public final class WithoutNotificationVia extends Plugin {

    @Override
    public void onEnable() {

        Plugin plugin = this;

        if (getProxy().getPluginManager().getPlugin("ViaVersion") != null) {
            try {
                Class<com.github.xinboshin.withoutnotificationvia.ViaHook> hookClass = com.github.xinboshin.withoutnotificationvia.ViaHook.class;
                hookClass.getConstructor().newInstance();
                getLogger().info("Enabled ViaVersion Hook.");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else {
            getLogger().severe("ViaVersion is not installed. Disabling...");
            plugin.onDisable();
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled.");
    }
}
