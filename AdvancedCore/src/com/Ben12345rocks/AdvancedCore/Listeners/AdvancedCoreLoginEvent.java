package com.Ben12345rocks.AdvancedCore.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.Ben12345rocks.AdvancedCore.UserManager.UserManager;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerRewardEvent.
 */
public class AdvancedCoreLoginEvent extends Event {

	/** The Constant handlers. */
	private static final HandlerList handlers = new HandlerList();

	/**
	 * Gets the handler list.
	 *
	 * @return the handler list
	 */
	public static HandlerList getHandlerList() {
		return handlers;
	}

	@Getter
	@Setter
	private Player player;

	/** The cancelled. */
	private boolean cancelled;

	public AdvancedCoreLoginEvent(Player player) {
		super(true);
		setPlayer(player);
	}

	/*
	 * (non-Javadoc)
	 * @see org.bukkit.event.Event#getHandlers()
	 */
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	/**
	 * Checks if is cancelled.
	 *
	 * @return true, if is cancelled
	 */
	public boolean isCancelled() {
		return cancelled;
	}

	public boolean isUserInStorage() {
		return UserManager.getInstance().getAllUUIDs().contains(player.getUniqueId().toString());
	}

	/**
	 * Sets the cancelled.
	 *
	 * @param bln
	 *            the new cancelled
	 */
	public void setCancelled(boolean bln) {
		cancelled = bln;
	}

}
