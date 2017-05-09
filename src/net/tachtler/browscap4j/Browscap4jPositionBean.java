package net.tachtler.browscap4j;

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

public class Browscap4jPositionBean {

	/**
	 * Offset for the browscap4jString.
	 */
	private int offset = 0;

	/**
	 * Length for the browscap4jString.
	 */
	private int length = 0;

	/**
	 * Constructor.
	 */
	public Browscap4jPositionBean() {
		super();
		this.init();
	}

	/**
	 * Constructor.
	 */
	public Browscap4jPositionBean(int offset, int length) {
		this.offset = offset;
		this.length = length;
	}

	/**
	 * Initialize all variables to default or unseeded values.
	 */
	public final void init() {
		this.offset = 0;
		this.length = 0;
	}

	/**
	 * @return the offset
	 */
	public int getOffset() {
		return offset;
	}

	/**
	 * @param offset
	 *            the offset to set
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length
	 *            the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

}
