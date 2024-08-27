# Forge Permission API Example

This repository provides an example of how to use the Forge Permission API in a Minecraft mod for **1.18.1 and higher**. The Forge Permission API allows mod developers to define and manage permissions for players on a Minecraft server.

## Overview

This demonstrates how to:
- Define permission nodes.
- Check player permissions.
- Register permission nodes with the Forge Permission API.

## Usage

1. **Define Permission Nodes**: Permission nodes are defined in the `PermissionNodes` class. Each node specifies a unique identifier, type, and default value.

2. **Check Player Permissions**: The `onPlayerJoin` event handler in the `ForgePermissionApiExample` class demonstrates how to check if a player has a specific permission using the `PermissionAPI.getPermission` method.

3. **Register Permission Nodes**: The `onPermissionNodesRegister` event handler in the `ForgePermissionApiExample` class registers the defined permission nodes with the Forge Permission API.

## Example

How define a permission node:

```java
public class PermissionNodes {
    public static final PermissionNode<Boolean> CAN_DO = new PermissionNode<>(
            new ResourceLocation(Example.MODID, "can_do"),
            PermissionTypes.BOOLEAN,
            (player, playerUUID, context) -> true
    );
}
```

How to register a permission node:

```java
@SubscribeEvent
public void onPermissionNodesRegister(PermissionGatherEvent.Nodes event) {
    event.register(PermissionNodes.CAN_DO);
}
```

Here is an example of how to check if a player has a specific permission when they join the server:

```java
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
```

### NOTE: This is a simple example to demonstrate the usage of the Forge Permission API. You can extend this example to include more complex permission systems and logic in your mod.
### I'm not sure if this is the right way to use the permission API, but it works for me. If you have any suggestions, please let me know.