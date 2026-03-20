package net.ice.restoredsss.event;

import net.ice.restoredsss.RestoredSSS;
import net.ice.restoredsss.screen.SuperSecretSettingsScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ScreenEvent;

@EventBusSubscriber(modid = RestoredSSS.MODID, bus = EventBusSubscriber.Bus.GAME)
public class PauseScreenEvent {

    @SubscribeEvent
    public static void onScreenInit(ScreenEvent.Init.Post event) {
        if(event.getScreen() instanceof PauseScreen) {
            Button button = Button.builder(Component.translatable("menu.title"), (button1) -> {
                Minecraft.getInstance().setScreen(new SuperSecretSettingsScreen(event.getScreen()));
            }).bounds(5, 5, 128, 20).build();

            event.addListener(button);
        }
    }

}
