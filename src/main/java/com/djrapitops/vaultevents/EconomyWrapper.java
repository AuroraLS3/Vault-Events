package com.djrapitops.vaultevents;

import com.djrapitops.vaultevents.events.economy.*;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.Event;

import java.util.List;

/**
 * Wrapper around Economy implementation to fire events.
 *
 * @author Rsl1122
 */
public class EconomyWrapper implements Economy {

    private final Economy original;

    public EconomyWrapper(Economy original) {
        this.original = original;
    }

    private <T extends Event> void callEvent(T event) {
        Bukkit.getPluginManager().callEvent(event);
    }

    public boolean isEnabled() {
        return original.isEnabled();
    }

    public String getName() {
        return original.getName();
    }

    public boolean hasBankSupport() {
        return original.hasBankSupport();
    }

    public int fractionalDigits() {
        return original.fractionalDigits();
    }

    public String format(double amount) {
        return original.format(amount);
    }

    public String currencyNamePlural() {
        return original.currencyNamePlural();
    }

    public String currencyNameSingular() {
        return original.currencyNameSingular();
    }

    @Deprecated
    public boolean hasAccount(String s) {
        return original.hasAccount(s);
    }

    public boolean hasAccount(OfflinePlayer player) {
        return original.hasAccount(player);
    }

    @Deprecated
    public boolean hasAccount(String s, String s1) {
        return original.hasAccount(s, s1);
    }

    public boolean hasAccount(OfflinePlayer player, String s) {
        return original.hasAccount(player, s);
    }

    @Deprecated
    public double getBalance(String s) {
        return original.getBalance(s);
    }

    public double getBalance(OfflinePlayer player) {
        return original.getBalance(player);
    }

    @Deprecated
    public double getBalance(String s, String s1) {
        return original.getBalance(s, s1);
    }

    public double getBalance(OfflinePlayer player, String s) {
        return original.getBalance(player, s);
    }

    @Deprecated
    public boolean has(String s, double amount) {
        return original.has(s, amount);
    }

    public boolean has(OfflinePlayer player, double amount) {
        return original.has(player, amount);
    }

    @Deprecated
    public boolean has(String s, String s1, double amount) {
        return original.has(s, s1, amount);
    }

    public boolean has(OfflinePlayer player, String s, double amount) {
        return original.has(player, s, amount);
    }

    @Deprecated
    public EconomyResponse withdrawPlayer(String s, double amount) {
        EconomyResponse response = original.withdrawPlayer(Bukkit.getOfflinePlayer(s), amount);
        callEvent(new PlayerWithdrawEvent(Bukkit.getOfflinePlayer(s), amount, response));
        return response;
    }

    public EconomyResponse withdrawPlayer(OfflinePlayer player, double amount) {
        EconomyResponse response = original.withdrawPlayer(player, amount);
        callEvent(new PlayerWithdrawEvent(player, amount, response));
        return response;
    }

    @Deprecated
    public EconomyResponse withdrawPlayer(String s, String s1, double amount) {
        EconomyResponse response = original.withdrawPlayer(Bukkit.getOfflinePlayer(s), s1, amount);
        callEvent(new PlayerWithdrawEvent(Bukkit.getOfflinePlayer(s), amount, s1, response));
        return response;
    }

    public EconomyResponse withdrawPlayer(OfflinePlayer player, String s, double amount) {
        EconomyResponse response = original.withdrawPlayer(player, s, amount);
        callEvent(new PlayerWithdrawEvent(player, amount, s, response));
        return response;
    }

    @Deprecated
    public EconomyResponse depositPlayer(String s, double amount) {
        EconomyResponse response = original.depositPlayer(Bukkit.getOfflinePlayer(s), amount);
        callEvent(new PlayerDepositEvent(Bukkit.getOfflinePlayer(s), amount, response));
        return response;
    }

    public EconomyResponse depositPlayer(OfflinePlayer player, double amount) {
        EconomyResponse response = original.depositPlayer(player, amount);
        callEvent(new PlayerDepositEvent(player, amount, response));
        return response;
    }

    @Deprecated
    public EconomyResponse depositPlayer(String s, String s1, double amount) {
        EconomyResponse response = original.depositPlayer(Bukkit.getOfflinePlayer(s), s1, amount);
        callEvent(new PlayerDepositEvent(Bukkit.getOfflinePlayer(s), amount, s1, response));
        return response;
    }

    public EconomyResponse depositPlayer(OfflinePlayer player, String s, double amount) {
        EconomyResponse response = original.depositPlayer(player, s, amount);
        callEvent(new PlayerDepositEvent(player, amount, s, response));
        return response;
    }

    @Deprecated
    public EconomyResponse createBank(String s, String s1) {
        EconomyResponse response = original.createBank(s, Bukkit.getOfflinePlayer(s1));
        callEvent(new BankCreateEvent(s, Bukkit.getOfflinePlayer(s1), response));
        return response;
    }

    public EconomyResponse createBank(String bankName, OfflinePlayer player) {
        EconomyResponse response = original.createBank(bankName, player);
        callEvent(new BankCreateEvent(bankName, player, response));
        return response;
    }

    public EconomyResponse deleteBank(String s) {
        return original.deleteBank(s);
    }

    public EconomyResponse bankBalance(String s) {
        return original.bankBalance(s);
    }

    public EconomyResponse bankHas(String s, double amount) {
        return original.bankHas(s, amount);
    }

    public EconomyResponse bankWithdraw(String s, double amount) {
        EconomyResponse response = original.bankWithdraw(s, amount);
        callEvent(new BankWithdrawEvent(s, amount, response));
        return response;
    }

    public EconomyResponse bankDeposit(String s, double amount) {
        EconomyResponse response = original.bankDeposit(s, amount);
        callEvent(new BankDepositEvent(s, amount, response));
        return response;
    }

    @Deprecated
    public EconomyResponse isBankOwner(String s, String s1) {
        return original.isBankOwner(s, s1);
    }

    public EconomyResponse isBankOwner(String s, OfflinePlayer player) {
        return original.isBankOwner(s, player);
    }

    @Deprecated
    public EconomyResponse isBankMember(String s, String s1) {
        return original.isBankMember(s, s1);
    }

    public EconomyResponse isBankMember(String s, OfflinePlayer player) {
        return original.isBankMember(s, player);
    }

    public List<String> getBanks() {
        return original.getBanks();
    }

    @Deprecated
    public boolean createPlayerAccount(String s) {
        return original.createPlayerAccount(s);
    }

    public boolean createPlayerAccount(OfflinePlayer player) {
        boolean success = original.createPlayerAccount(player);
        callEvent(success ? new PlayerAccountCreateSuccessEvent(player) : new PlayerAccountCreateFailedEvent(player));
        return success;
    }

    @Deprecated
    public boolean createPlayerAccount(String s, String s1) {
        boolean success = original.createPlayerAccount(Bukkit.getOfflinePlayer(s), s1);
        callEvent(success ? new PlayerAccountCreateSuccessEvent(Bukkit.getOfflinePlayer(s), s1) : new PlayerAccountCreateFailedEvent(Bukkit.getOfflinePlayer(s), s1));
        return success;
    }

    public boolean createPlayerAccount(OfflinePlayer player, String world) {
        boolean success = original.createPlayerAccount(player, world);
        callEvent(success ? new PlayerAccountCreateSuccessEvent(player, world) : new PlayerAccountCreateFailedEvent(player, world));
        return success;
    }
}