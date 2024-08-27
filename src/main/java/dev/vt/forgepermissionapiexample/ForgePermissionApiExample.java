package dev.vt.forgepermissionapiexample;

import com.mojang.logging.LogUtils;
import dev.vt.forgepermissionapiexample.permissions.PermissionNodes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.permission.PermissionAPI;
import net.minecraftforge.server.permission.events.PermissionGatherEvent;
import org.slf4j.Logger;


@Mod(ForgePermissionApiExample.MODID)
public class ForgePermissionApiExample {

    public static final String MODID = "forgepermissionapiexample";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ForgePermissionApiExample() {
        MinecraftForge.EVENT_BUS.register(this);
    }


    //Example of how to check if a player has a permission node, using the PermissionAPI.getPermission
    @SubscribeEvent
    public void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        if (PermissionAPI.getPermission((ServerPlayer) event.getEntity(), PermissionNodes.CAN_DO)) {
            LOGGER.info("Player can do something");
            Component text = Component.literal(PermissionAPI.getPermission((ServerPlayer) event.getEntity(), PermissionNodes.DO_LIMIT).toString());
            event.getEntity().sendSystemMessage(text);
        } else {
            LOGGER.info("Player can't do something");
        }
    }

    @SubscribeEvent
    public void onPermissionNodesRegister(PermissionGatherEvent.Nodes event) {
        PermissionNodes.init();
        event.addNodes(PermissionNodes.permissionNodesList);
    }
}
