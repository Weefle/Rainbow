package org.projectrainbow.commands;

import PluginReference.MC_Command;
import PluginReference.MC_Location;
import PluginReference.MC_Player;
import joebkt._SerializableLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import org.projectrainbow._ColorHelper;
import org.projectrainbow._HomeUtils;
import org.projectrainbow.interfaces.IMixinICommandSender;

import java.util.Collections;
import java.util.List;

public class _CmdHome implements MC_Command {
    @Override
    public String getCommandName() {
        return "home";
    }

    @Override
    public List<String> getAliases() {
        return Collections.emptyList();
    }

    @Override
    public boolean hasPermissionToUse(MC_Player player) {
        return player == null || player.hasPermission("rainbow.home");
    }

    @Override
    public List<String> getTabCompletionList(MC_Player plr, String[] args) {
        return Collections.emptyList();
    }

    @Override
    public String getHelpLine(MC_Player player) {
        return String.valueOf(_ColorHelper.AQUA) + "/home" + _ColorHelper.WHITE + " --- Travel home";
    }

    @Override
    public void handleCommand(MC_Player player, String[] args) {
        if (player == null) {
            System.out.println("Only for players.");
            return;
        }
        final EntityPlayerMP p = (EntityPlayerMP) player;
        _SerializableLocation sloc = _HomeUtils.getHome(p.getUniqueID());
        if (sloc == null) {
            ((IMixinICommandSender) p).sendMessage(String.valueOf(_ColorHelper.RED) + "You don't have a home set. Try first: " + _ColorHelper.GOLD + "/sethome");
            return;
        }
        try {
            p.dismountRidingEntity();
            for (Entity entity : p.getPassengers()) {
                entity.dismountRidingEntity();
            }
        } catch (Exception exc) {
            System.out.println("Home Step 1 SetVehicle EXC: " + exc.getMessage());
        }
        ((MC_Player) p).teleport(new MC_Location(sloc.x, sloc.y, sloc.z, sloc.dimension, sloc.yaw, sloc.pitch));
        ((IMixinICommandSender) p).sendMessage(String.valueOf(_ColorHelper.GREEN) + "You teleport home to " + _ColorHelper.WHITE + sloc.toString());
    }
}
