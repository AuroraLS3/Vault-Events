package com.djrapitops.vaultevents.events.economy;

import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Event that is fired when Economy#createBank(String, OfflinePlayer) is called.
 *
 * @author Rsl1122
 */
public class BankCreateEvent extends Event {

    private final String bank;
    private final OfflinePlayer player;
    private final EconomyResponse response;

    public BankCreateEvent(String bank, OfflinePlayer player, EconomyResponse response) {
        super(!Bukkit.isPrimaryThread());
        this.bank = bank;
        this.player = player;
        this.response = response;
    }

    public String getBankName() {
        return bank;
    }

    public OfflinePlayer getOfflinePlayer() {
        return player;
    }

    public EconomyResponse getResponse() {
        return response;
    }

    private static final HandlerList HANDLERS = new HandlerList();

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}