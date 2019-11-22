package com.djrapitops.vaultevents.events.economy;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.Optional;

/**
 * Event that is fired when Economy#createPlayerAccount(OfflinePlayer, double) fails.
 *
 * @author Rsl1122
 */
public class PlayerAccountCreateFailedEvent extends Event {

    private final OfflinePlayer player;
    private final String world;

    public PlayerAccountCreateFailedEvent(OfflinePlayer player) {
        this(player, null);
    }

    public PlayerAccountCreateFailedEvent(OfflinePlayer player, String world) {
        super(!Bukkit.isPrimaryThread());
        this.player = player;
        this.world = world;
    }

    public OfflinePlayer getOfflinePlayer() {
        return player;
    }

    public Optional<String> getWorldName() {
        return Optional.ofNullable(world);
    }

    private static final HandlerList HANDLERS = new HandlerList();

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}