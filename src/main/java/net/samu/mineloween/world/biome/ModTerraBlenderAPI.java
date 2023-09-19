package net.samu.mineloween.world.biome;

import net.minecraft.util.Identifier;
import net.samu.mineloween.MineloweenMod;
import net.samu.mineloween.world.biome.surface.ModMaterialRules;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerraBlenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverwolrdRegion(new Identifier(MineloweenMod.MOD_ID, "overworld"), 5)); // Più alto è il peso e più biomi vanilla vengono rimpiazzati dai custom

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MineloweenMod.MOD_ID, ModMaterialRules.makeRules());
    }
}
