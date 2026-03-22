package net.ice.restoredsss;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

import net.neoforged.fml.loading.FMLPaths;
import org.slf4j.Logger;

import java.nio.file.Path;

@Mod(RestoredSSS.MODID)
public class RestoredSSS {
    public static final String MODID = "sss";
    public static final Logger LOGGER = LogUtils.getLogger();

    public RestoredSSS(IEventBus modEventBus, ModContainer modContainer) {

    }

    public static Path getEffectsDirectory() {
        return FMLPaths.GAMEDIR.get().resolve("ssseffects");
    }

}
