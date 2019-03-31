package com.wegift.util;

import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @author Laxmikanth
 *
 *         Singleton Class for storing the merchant unique details, while
 *         sending the mail.
 *
 *         once merchant updates the information then his/her details will be
 *         discarded.
 * 
 *         this is temporary data
 */
public class MerchantRegUniqueForUpdate implements Serializable {

	private static final long serialVersionUID = -8417399691253158733L;

	static Map<String, Integer> uniqueMap = null;
	private static MerchantRegUniqueForUpdate instance = null;

	private MerchantRegUniqueForUpdate() {
		uniqueMap = new ConcurrentHashMap<String, Integer>();
	}

	/*
	 * static factory method for getting the one single object
	 */
	public static MerchantRegUniqueForUpdate getInstance() {
		if (instance == null) {
			synchronized (MerchantRegUniqueForUpdate.class) {
				if (instance == null) {
					instance = new MerchantRegUniqueForUpdate();
				}
			}
		}
		return instance;
	}

	/*
	 * to store the data into the map
	 */
	public void keepIntoMap(String uniqueId, int merchantId) {
		if (uniqueMap.containsKey(uniqueId) == false) {
			uniqueMap.put(uniqueId, merchantId);
			System.out.println("data has been stored in the map :key " + uniqueId + ",value : " + merchantId);
		}
	}

	/*
	 * to fetch the data from the map, if it exists
	 */
	public int getMerchantId(String uniqueId) {
		int merchantId = 0;
		if (uniqueMap.containsKey(uniqueId) == true) {
			merchantId = uniqueMap.get(uniqueId);
		}
		return merchantId;
	}

	/*
	 * to remove the data from the map
	 */
	public boolean discard(String uniqueId) {
		boolean flag = false;
		
		if (uniqueMap.containsKey(uniqueId) == true) {
			uniqueMap.remove(uniqueId);
			flag = true;
		} else {
			throw new RuntimeException("Seems like already data has been discarded or no data found");
		}
		return flag;
	}

	public <T, E> String getKeyByValue(E value) {
		for (Entry<String, Integer> entry : uniqueMap.entrySet()) {
			if (Objects.equals(value, entry.getValue())) {
				return entry.getKey();
			}
		}
		return null;
	}

	public boolean conatinsKey(String merchantId) {
		return uniqueMap.containsKey(merchantId);
	}
}
