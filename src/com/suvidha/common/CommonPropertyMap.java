package com.suvidha.common;

import java.util.HashMap;
import java.util.Map;

public class CommonPropertyMap {

	private String key;
	public Map<String, String> valueMap;

	public Map<String, String> dailySales = null;
	public Map<String, Map<String, String>> commonMap = null;

	{
		commonMap = new HashMap<String, Map<String, String>>();
		/*
		 * Daily Sales Download Param
		 */
		dailySales = new HashMap<String, String>();
		dailySales.put("recieptNo", "Reciept No");
		dailySales.put("cardNo", "Card No");
		dailySales.put("clientName", "Client Name");
		dailySales.put("accountType", "Account Type");
		dailySales.put("agentCode", "Agent Name");
		dailySales.put("ammount", "Submit Ammount");
		dailySales.put("bankCash", "Cash/Cheque");
		dailySales.put("chequeNo", "Cheque No");
		dailySales.put("collectionDate", "Collection Date");
		dailySales.put("entryDate", "Entry Date");
		commonMap.put("dailySales", dailySales);

		/*
		 * Daily Sales Download Param
		 */

	}

	public CommonPropertyMap() {
		// TODO Auto-generated constructor stub
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Map<String, String> getValueMap() {
		return commonMap.get(key);
	}

	public Map<String, String> getTitles(String key) {
		return commonMap.get(key);
	}

}
