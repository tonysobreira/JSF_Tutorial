package com.jsf.bean;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "mobilemap")
@SessionScoped
public class MobileMap {

	private String[] mname;

	private static Map<String, Object> mobnames;

	static {
		mobnames = new LinkedHashMap<String, Object>();
		mobnames.put("MotoE", "MotoE"); // label, value
		mobnames.put("GalaxyNote", "GalaxyNote");
		mobnames.put("AppleIPhone", "AppleIPhone");
	}

	public String[] getMname() {
		return mname;
	}

	public void setMname(String[] mname) {
		this.mname = mname;
	}

	public Map<String, Object> getMobnames() {
		return mobnames;
	}

	public static void setMobnames(Map<String, Object> mobnames) {
		MobileMap.mobnames = mobnames;
	}

}
