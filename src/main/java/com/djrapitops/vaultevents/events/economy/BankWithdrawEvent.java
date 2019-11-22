package com.djrapitops.vaultevents.events.economy;

import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Event that is fired when Economy#bankWithdraw(String, double) is called.
 *
 * @author Rsl1122
 */
public class BankWithdrawEvent extends Event {

    private final String bank;
    private final double amount;
    private final EconomyResponse response;

    public BankWithdrawEvent(String bank, double amount, EconomyResponse response) {
        super(!Bukkit.isPrimaryThread());
        this.bank = bank;
        this.amount = amount;
        this.response = response;
    }

    public String getBankName() {
        return bank;
    }

    public double getAmount() {
        return amount;
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