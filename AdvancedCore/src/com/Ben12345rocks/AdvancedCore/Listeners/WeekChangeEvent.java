package com.Ben12345rocks.AdvancedCore.Listeners;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerRewardEvent.
 */
public class WeekChangeEvent extends Event {

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

	public WeekChangeEvent() {
		super();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.bukkit.event.Event#getHandlers()
	 */
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

}
