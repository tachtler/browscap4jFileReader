package net.tachtler.browscap4j;

import java.util.LinkedHashMap;
import java.util.regex.Pattern;

/*******************************************************************************
 * Bean to store the data from http://browscap.org - browscap.csv.
 * 
 * @author Klaus Tachtler. <klaus@tachtler.net>
 * 
 *         Homepage : http://www.tachtler.net
 * 
 *         This program is free software; you can redistribute it and/or modify
 *         it under the terms of the GNU General Public License as published by
 *         the Free Software Foundation; either version 2 of the License, or (at
 *         your option) any later version.
 * 
 *         Copyright (c) 2017 by Klaus Tachtler.
 ******************************************************************************/

public class Browscap4jDataBean {

	/**
	 * LinekedHashMap with Browscap4jMap.
	 */
	private LinkedHashMap<Pattern, Browscap4jPositionBean> browscap4jMap = null;

	/**
	 * String with browscap4jString.
	 */
	private String browscap4jString = null;

	/**
	 * Constructor.
	 */
	public Browscap4jDataBean() {
		super();
		this.init();
	}

	/**
	 * Initialize all variables to default or unseeded values.
	 */
	public final void init() {
		this.browscap4jMap = null;
		this.browscap4jString = null;
	}

	/**
	 * @return the browscap4jMap
	 */
	public LinkedHashMap<Pattern, Browscap4jPositionBean> getBrowscap4jMap() {
		return browscap4jMap;
	}

	/**
	 * @param browscap4jMap
	 *            the browscap4jMap to set
	 */
	public void setBrowscap4jMap(LinkedHashMap<Pattern, Browscap4jPositionBean> browscap4jMap) {
		this.browscap4jMap = browscap4jMap;
	}

	/**
	 * @return the browscap4jString
	 */
	public String getBrowscap4jString() {
		return browscap4jString;
	}

	/**
	 * @param browscap4jString
	 *            the browscap4jString to set
	 */
	public void setBrowscap4jString(String browscap4jString) {
		this.browscap4jString = browscap4jString;
	}

}
