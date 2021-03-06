package org.projectrainbow.util;

import PluginReference.MC_Command;
import PluginReference.MC_Player;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import org.projectrainbow._DiwUtils;

import java.util.List;

public class WrappedMinecraftCommand implements MC_Command {
    public final ICommand delegate;

    public WrappedMinecraftCommand(ICommand delegate) {
        this.delegate = delegate;
    }

    @Override
    public int hashCode() {
        return delegate.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof WrappedMinecraftCommand && delegate.equals(((WrappedMinecraftCommand) obj).delegate);
    }

    @Override
    public String toString() {
        return delegate.toString();
    }

    @Override
    public String getCommandName() {
        return delegate.getName();
    }

    @Override
    public List<String> getAliases() {
        return delegate.getAliases();
    }

    @Override
    public String getHelpLine(MC_Player plr) {
        return delegate.getUsage((ICommandSender) plr);
    }

    @Override
    public void handleCommand(MC_Player plr, String[] args) {
        try {
            delegate.execute(_DiwUtils.getMinecraftServer(), (ICommandSender) plr, args);
        } catch (CommandException e) {
            Util.sneakyThrow(e);
        }
    }

    @Override
    public boolean hasPermissionToUse(MC_Player plr) {
        return delegate.checkPermission(_DiwUtils.getMinecraftServer(), (ICommandSender) plr);
    }

    @Override
    public List<String> getTabCompletionList(MC_Player plr, String[] args) {
        return delegate.getTabCompletions(_DiwUtils.getMinecraftServer(), (ICommandSender) plr, args, null);
    }
}
