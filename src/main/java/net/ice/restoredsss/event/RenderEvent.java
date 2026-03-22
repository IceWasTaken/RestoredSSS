package net.ice.restoredsss.event;

import net.ice.restoredsss.RestoredSSS;
import net.ice.restoredsss.screen.SuperSecretSettingsScreen;
import net.minecraft.client.Minecraft;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;

@EventBusSubscriber(modid = RestoredSSS.MODID, bus = EventBusSubscriber.Bus.GAME)
public class RenderEvent {

    @SubscribeEvent
    public static void onRender(ClientTickEvent.Post event) {
        if(Minecraft.getInstance().gameRenderer.currentEffect() == null && SuperSecretSettingsScreen.shaderLocation != null) {
            Minecraft.getInstance().gameRenderer.loadEffect(SuperSecretSettingsScreen.shaderLocation);
        }


    }

}
