package kaukau.model;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A CoinBox is a pickupable item which can be carry by player. This CoinBox
 * object can be stored in Player's inventory and CoinBox can used to store Coin
 * object only.
 *
 * @author Vivienne Yapp, 300339524
 *
 */
@XmlRootElement
public class CoinBox extends PickupableItem implements Serializable {

	private Container storage;
	private Player player;
	private int totalCoinAmount;

	public CoinBox(Player player) {
		super("Coin Box");
		this.player = player;
		// this.storage = new Container("Coin Box", player.getLocation());
		this.storage = new Container("Coin Box");
		storage.setAmount(20);
		totalCoinAmount = 0;
	}

	@SuppressWarnings("unused")
	public CoinBox() {
		this(null);
	}

	/**
	 * Add coin to the coinbox.
	 *
	 * @param item
	 *            the item to add
	 * @return true if the item is a coin and the coinBox is not full, otherwise
	 *         false
	 */
	public boolean addCoin(Item item) {

		if (item instanceof Coin) {
			Coin coin = (Coin) item;
			if (storage.addItem(item) && !storage.isStorageFull()) {
				totalCoinAmount += coin.getAmount();
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the list of coin in the coin box.
	 *
	 * @return return all the coin objects
	 */
	@XmlElement(name = "coins")
	public ArrayList<PickupableItem> getStorage() {
		return this.storage.getStorage();
	}

	/**
	 * Return the total coins in this coinBox.
	 *
	 * @return
	 */
	public int totalCoins() {
		int total = 0;
		for (PickupableItem p : getStorage()) {
			Coin c = (Coin) p;
			total += c.getAmount();
		}
		return total;
	}

	/**
	 * Check if this coin box is full or not.
	 *
	 * @return
	 */
	@XmlElement(name = "isFull")
	public boolean isStorageFull() {
		return storage.isStorageFull();
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
