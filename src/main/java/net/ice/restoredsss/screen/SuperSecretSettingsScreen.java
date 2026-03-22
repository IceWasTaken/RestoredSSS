package net.ice.restoredsss.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.StringWidget;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.layouts.FrameLayout;
import net.minecraft.client.gui.layouts.GridLayout;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

//There's got to be a better way to do this without so many magic numbers, but for now I'm not changing it.
public class SuperSecretSettingsScreen extends Screen {

    private static final int COLUMNS = 3;

    public static ResourceLocation shaderLocation = null;

    private final Screen previousScreen;

    public SuperSecretSettingsScreen(Screen previousScreen) {
        super(Component.translatable("menu.ssstitle"));

        this.previousScreen = previousScreen;
    }

    @Override
    protected void init() {
        super.init();
        this.createScreen();

        this.addRenderableWidget(new StringWidget(0, 10, this.width, 9, this.title, this.font));

//        this.addRenderableWidget(new Button.Builder(Component.translatable("menu.editorTitle"), (button -> {
//            getMinecraft().setScreen(new ShaderEditorScreen(this));
//        })).bounds(width - 133, 5, 128, 20).build());

        this.addRenderableWidget(new Button.Builder(Component.translatable("menu.back"), (button -> {
            this.minecraft.setScreen(previousScreen);
        })).bounds(width - 197, height - 25, 192, 20).build());

        this.addRenderableWidget(new Button.Builder(Component.translatable("menu.shutdownEffects"), (button -> {
            this.minecraft.gameRenderer.shutdownEffect();
            this.minecraft.gameRenderer.checkEntityPostEffect(this.minecraft.cameraEntity);
            shaderLocation = null;
        })).bounds(width - 197, height - 50, 192, 20).build());
    }

    @Override
    protected void renderMenuBackground(GuiGraphics guiGraphics, int x, int y, int width, int height) {}

    @Override
    protected void renderBlurredBackground(float p_330683_) {}

    ///Based on {@link PauseScreen#createPauseMenu()}
    private void createScreen() {
        GridLayout gridLayout = new GridLayout();
        gridLayout.defaultCellSetting().padding(4, 4, 4, 0);
        GridLayout.RowHelper rowHelper = gridLayout.createRowHelper(3);

        createShaderEntry(rowHelper, "antialias");
        createShaderEntry(rowHelper, "art");
        createShaderEntry(rowHelper, "bits");
        createShaderEntry(rowHelper, "blobs");
        createShaderEntry(rowHelper, "blobs2");
        createShaderEntry(rowHelper, "blur");
        createShaderEntry(rowHelper, "bumpy");
        createShaderEntry(rowHelper, "color_convolve");
        createShaderEntry(rowHelper, "creeper");
        createShaderEntry(rowHelper, "deconverge");
        createShaderEntry(rowHelper, "desaturate");
        createShaderEntry(rowHelper, "flip");
        createShaderEntry(rowHelper, "fxaa");
        createShaderEntry(rowHelper, "green");
        createShaderEntry(rowHelper, "invert");
        createShaderEntry(rowHelper, "notch");
        createShaderEntry(rowHelper, "ntsc");
        createShaderEntry(rowHelper, "outline", Component.translatable("effect.outline.issue"));
        createShaderEntry(rowHelper, "pencil");
        createShaderEntry(rowHelper, "phosphor");
        createShaderEntry(rowHelper, "scan_pincushion");
        createShaderEntry(rowHelper, "sobel");
        createShaderEntry(rowHelper, "spider");
        createShaderEntry(rowHelper, "wobble");

        gridLayout.arrangeElements();
        FrameLayout.alignInRectangle(gridLayout, 0, 0, this.width, this.height, 0.5F, 0.25F);
        gridLayout.visitWidgets(this::addRenderableWidget);
    }

    private void createShaderEntry(GridLayout.RowHelper rowHelper, String key) {
        rowHelper.addChild(Button.builder(Component.translatable("shader." + key), (button) -> {
            this.minecraft.gameRenderer.shutdownEffect();
            shaderLocation = ResourceLocation.fromNamespaceAndPath("sss", "shaders/" + key + ".json");
        }).build());
    }

    private void createShaderEntry(GridLayout.RowHelper rowHelper, String key, Component tooltip) {
        rowHelper.addChild(Button.builder(Component.translatable("shader." + key), (button) -> {
            this.minecraft.gameRenderer.shutdownEffect();
            shaderLocation = ResourceLocation.fromNamespaceAndPath("sss", "shaders/" + key + ".json");
        }).tooltip(Tooltip.create(tooltip)).build());
    }
}
