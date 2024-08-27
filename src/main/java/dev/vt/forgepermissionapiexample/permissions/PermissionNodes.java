package dev.vt.forgepermissionapiexample.permissions;

import dev.vt.forgepermissionapiexample.ForgePermissionApiExample;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.server.permission.nodes.PermissionNode;
import net.minecraftforge.server.permission.nodes.PermissionTypes;

import java.util.List;

public class PermissionNodes {

    public static final PermissionNode<Boolean> CAN_DO = new PermissionNode<>(
            new ResourceLocation(ForgePermissionApiExample.MODID, "can_do"),
            PermissionTypes.BOOLEAN,
            (player, playerUUID, context) -> true
    );

    public static final PermissionNode<Integer> DO_LIMIT = new PermissionNode<>(
            new ResourceLocation(ForgePermissionApiExample.MODID, "do_limit"),
            PermissionTypes.INTEGER,
            (player, playerUUID, context) -> 5
    );

    public static List<PermissionNode<?>> permissionNodesList = List.of(CAN_DO, DO_LIMIT);

    public static void init() {
        CAN_DO.setInformation(Component.literal("Can Do"), Component.literal("Can do something"));
        DO_LIMIT.setInformation(Component.literal("Do Limit"), Component.literal("The maximum number of do somthing a player can have"));
    }
}