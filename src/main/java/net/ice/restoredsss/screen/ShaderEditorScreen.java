package net.ice.restoredsss.screen;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class ShaderEditorScreen extends Screen {

    private Screen previousScreen;

    public ShaderEditorScreen(Screen previousScreen) {
        super(Component.translatable("menu.editorTitle"));

        this.previousScreen = previousScreen;
    }

}
