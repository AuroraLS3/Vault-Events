package com.djrapitops.vaultevents.events;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Synchronous event that is fired when VaultEventsPlugin wraps the original Economy to start firing events.
 *
 * After this event has fired the other events will start firing.
 *
 * @author Rsl1122
 */
public class VaultEventsAvailableEvent extends Event {

    private final Economy economy;

    public VaultEventsAvailableEvent(Economy economy) {
        super(!Bukkit.isPrimaryThread());
        this.economy = economy;
    }

    public Economy getEconomy() {
        return economy;
    }

    private static final HandlerList HANDLERS = new HandlerList();

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}