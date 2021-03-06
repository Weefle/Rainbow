package PluginExample.commands;

import PluginExample.CmdBase;
import PluginReference.ChatColor;
import PluginReference.MC_ArmorStand;
import PluginReference.MC_Entity;
import PluginReference.MC_Player;

public class CmdAsArmsOnly extends CmdBase {
    public CmdAsArmsOnly() {
        super("asarmsonly", "Kill ArmorStands with no arms!");
    }

    @Override
    protected void execute(MC_Player plr, String[] args) {
        int nStands = 0;
        for (MC_Entity ent : plr.getWorld().getEntities()) {
            if (!(ent instanceof MC_ArmorStand)) continue;
            MC_ArmorStand stand = (MC_ArmorStand) ent;
            if (stand.hasArms()) continue;
            stand.kill();
            nStands++;
        }
        plr.sendMessage(ChatColor.GREEN + "Killed " + nStands + " Armor Stands with no arms!");
    }
}
