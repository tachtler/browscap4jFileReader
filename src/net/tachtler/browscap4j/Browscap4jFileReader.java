package net.tachtler.browscap4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.CharUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*******************************************************************************
 * Browscap4jFileReader read the User-Agent-String capabilities from
 * http://browscap.org - browscap.csv file.
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
public class Browscap4jFileReader {

	private static Logger log = LogManager.getLogger();

	/**
	 * Constructor.
	 */
	public Browscap4jFileReader() {
		super();
	}

	/**
	 * Initialize the Browscap4jDataBean.
	 * 
	 * @param csvFile
	 * @return Browscap4jDataBean
	 * @throws IllegalStateException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static Browscap4jDataBean initBrowscap4jData(File csvFile)
			throws IllegalStateException, FileNotFoundException, IOException {

		log.debug("*csvFile                                : " + csvFile);

		/**
		 * Browscap4jDataBean with the LinkedHashMap<Pattern,
		 * Browscap4jPositionBean> browscap4jMap and the String browscap4jString
		 * as data.
		 */
		Browscap4jDataBean browscap4jDataBean = new Browscap4jDataBean();

		/**
		 * LinkedHashMap with regular expression pattern as key from the
		 * original userAgentString and Browscap4jPositionBean integer variables
		 * as value object by determining the offset and the length for each
		 * line.
		 */
		LinkedHashMap<Pattern, Browscap4jPositionBean> browscap4jMap = new LinkedHashMap<Pattern, Browscap4jPositionBean>();

		/**
		 * Generate browscap4jString with all fields filled up with data from
		 * browscap.csv to a single String.
		 */
		String browscap4jString = null;

		/**
		 * StringBuilder for fast concatenation.
		 */
		StringBuilder stringBuilder = new StringBuilder();

		/*
		 * Check if csvFile is null.
		 */
		if (null == csvFile) {
			throw new IllegalStateException("Argument csvFile is null (NOT set).");
		}

		/*
		 * Iterate over the csvFile - browscap.csv with all the data and
		 * generate a string with all the lines concatenated. Generate a regular
		 * expression pattern from the first column of the csvFile -
		 * browscap.csv as key and calculate the offset and the length for every
		 * single line inside the concatenated string as Browscap4jPositionBean
		 * as value.
		 */
		LineIterator lineIterator = FileUtils.lineIterator(csvFile, "UTF-8");

		try {
			int offset = 0;
			String[] col = null;

			while (lineIterator.hasNext()) {
				String line = lineIterator.nextLine();

				Browscap4jPositionBean browscap4jPositionBean = new Browscap4jPositionBean(offset,
						offset + line.length());

				offset += line.length();

				col = line.split("\",\"");

				browscap4jMap.put(Pattern.compile(convertToRegex(col[0].substring(1))), browscap4jPositionBean);

				stringBuilder.append(line);
			}
		} finally {
			LineIterator.closeQuietly(lineIterator);
		}

		/*
		 * Generate the String browscap4jString from StringBuilder
		 * stringBuilder.
		 */
		browscap4jString = stringBuilder.toString();

		/*
		 * Debug NOT the Map and the String, because of too much entry's, only
		 * the class should be printed out in debug mode, to see if the
		 * browscap4jMap and the browscap4jString are NOT null.
		 */
		log.debug("*browscap4jMap                          : " + browscap4jMap.getClass());
		log.debug("*browscap4jString                       : " + browscap4jString.getClass());

		browscap4jDataBean.setBrowscap4jMap(browscap4jMap);
		browscap4jDataBean.setBrowscap4jString(browscap4jString);

		return browscap4jDataBean;
	}

	/**
	 * Determining the Browscap4jCapabilities with the userAgentString from
	 * Browscap4jDataBean and return the result in a browscap4jBean.
	 * 
	 * @param browscap4jDataBean
	 * @param userAgentString
	 * @return Browscap4jBean
	 */
	public static Browscap4jBean determineBrowscap4jCapabilities(Browscap4jDataBean browscap4jDataBean,
			String userAgentString) {

		/*
		 * Debug NOT the browscap4jDataBean, because of too much entry's, only
		 * the class should be printed out in debug mode, to see if the
		 * browscap4jDataBean is NOT null.
		 */
		log.debug("*browscap4jDataBean                     : " + browscap4jDataBean.getClass());

		/*
		 * Debug NOT the Map and the String, because of too much entry's, only
		 * the class should be printed out in debug mode, to see if the
		 * browscap4jMap and the browscap4jString are NOT null.
		 */
		log.debug("*browscap4jDataBean.getBrowscap4jMap()  : " + browscap4jDataBean.getBrowscap4jMap().getClass());
		log.debug("*browscap4jString                       : " + browscap4jDataBean.getBrowscap4jString().getClass());

		log.debug("*userAgentString                        : " + userAgentString);

		/**
		 * Initialize target Browscap4jBean for the result.
		 */
		Browscap4jBean browscap4jBean = null;

		/**
		 * Instance browscap4jBean and initialize all values to "" (empty)
		 * strings.
		 */
		browscap4jBean = new Browscap4jBean();
		browscap4jBean.init();

		log.debug("*browscap4jBean                         : " + browscap4jBean);

		/*
		 * If one ore more results where determined, than take the first one. If
		 * nothing was found fill up the browscap4jBean with empty values. This
		 * search was done by using the stream capabilities of a parallel search
		 * by Java 8 (1.8).
		 */
		String userAgentStringRegEx = userAgentString.toLowerCase();

		log.debug("*userAgentStringRegEx                   : " + userAgentStringRegEx);

		/*
		 * Compare all the pattern entry's inside browsecap4jMapEntry with the
		 * Java 8 (1.8) parallel stream possibilities while using the stream and
		 * the userAgentStringRegEx.
		 */
		final Optional<Entry<Pattern, Browscap4jPositionBean>> browsecap4jMapEntry = browscap4jDataBean
				.getBrowscap4jMap().entrySet().stream().parallel().filter(entry -> {
					final Matcher matcher = entry.getKey().matcher(userAgentStringRegEx);
					return matcher.matches();
				}).findFirst();

		/*
		 * Return the search result browsecap4jMapEntry if one was present. If
		 * true, generate a browscap4jBean from the browscap4jString using the
		 * Browscap4jPositionBean position values from browscap4jMap . If false
		 * generate a browscap4jBean with empty values and the search fields
		 * userAgentString and userAgentStringRegEx.
		 */
		if (browsecap4jMapEntry.isPresent()) {

			String[] result = browscap4jDataBean.getBrowscap4jString()
					.substring(browsecap4jMapEntry.get().getValue().getOffset(),
							browsecap4jMapEntry.get().getValue().getLength())
					.split("\",\"");

			/*
			 * Fill up the former generated browscap4jBean with the fields from
			 * csvFile - browscap.csv.
			 */
			browscap4jBean.setPropertyName(result[0].substring(1));
			browscap4jBean.setMasterParent(result[1]);
			browscap4jBean.setLiteMode(result[2]);
			browscap4jBean.setParent(result[3]);
			browscap4jBean.setComment(result[4]);
			browscap4jBean.setBrowser(result[5]);
			browscap4jBean.setBrowserType(result[6]);
			browscap4jBean.setBrowserBits(result[7]);
			browscap4jBean.setBrowserMaker(result[8]);
			browscap4jBean.setBrowserModus(result[9]);
			browscap4jBean.setVersion(result[10]);
			browscap4jBean.setMajorVersion(result[11]);
			browscap4jBean.setMinorVersion(result[12]);
			browscap4jBean.setPlatform(result[13]);
			browscap4jBean.setPlatformVersion(result[14]);
			browscap4jBean.setPlatformDescription(result[15]);
			browscap4jBean.setPlatformBits(result[16]);
			browscap4jBean.setPlatformMaker(result[17]);
			browscap4jBean.setAlpha(result[18]);
			browscap4jBean.setBeta(result[19]);
			browscap4jBean.setWin16(result[20]);
			browscap4jBean.setWin32(result[21]);
			browscap4jBean.setWin64(result[22]);
			browscap4jBean.setFrames(result[23]);
			browscap4jBean.setiFrames(result[24]);
			browscap4jBean.setTables(result[25]);
			browscap4jBean.setCookies(result[26]);
			browscap4jBean.setBackgroundSounds(result[27]);
			browscap4jBean.setJavaScript(result[28]);
			browscap4jBean.setVbScript(result[29]);
			browscap4jBean.setJavaApplets(result[30]);
			browscap4jBean.setActiveXControls(result[31]);
			browscap4jBean.setIsMobileDevice(result[32]);
			browscap4jBean.setIsTablet(result[33]);
			browscap4jBean.setIsSyndicationReader(result[34]);
			browscap4jBean.setCrawler(result[35]);
			browscap4jBean.setIsFake(result[36]);
			browscap4jBean.setIsAnonymized(result[37]);
			browscap4jBean.setIsModified(result[38]);
			browscap4jBean.setCssVersion(result[39]);
			browscap4jBean.setAolVersion(result[40]);
			browscap4jBean.setDeviceName(result[41]);
			browscap4jBean.setDeviceMaker(result[42]);
			browscap4jBean.setDeviceType(result[43]);
			browscap4jBean.setDevicePointingMethod(result[44]);
			browscap4jBean.setDeviceCodeName(result[45]);
			browscap4jBean.setDeviceBrandName(result[46]);
			browscap4jBean.setRenderingEngineName(result[47]);
			browscap4jBean.setRenderingEngineVersion(result[48]);
			browscap4jBean.setRenderingEngineDescription(result[49]);
			browscap4jBean.setRenderingEngineMaker(result[50].substring(0, result[50].length() - 1));

			log.debug("Browsercapabilities were found for      : " + userAgentString);
			log.debug("*browsecap4jMapEntry.get().getKey()     : " + browsecap4jMapEntry.get().getKey());
			log.debug("*browsecap4jMapEntry.get()...getOffset(): " + browsecap4jMapEntry.get().getValue().getOffset());
			log.debug("*browsecap4jMapEntry.get()...getLength(): " + browsecap4jMapEntry.get().getValue().getLength());

		} else {
			browscap4jBean.init();

			log.debug("Browsercapabilities were NOT found for  : " + userAgentString);
		}

		/*
		 * Set userAgentString from request and the userAgentStringRegEx to the
		 * browscap4jBean in every case, to know which search string was used.
		 */
		browscap4jBean.setUserAgentString(userAgentString);
		browscap4jBean.setUserAgentStringRegEx(userAgentStringRegEx);

		return browscap4jBean;
	}

	/**
	 * Format the given String to a Java regular expression formatted String.
	 * 
	 * @param regexPattern
	 * @return regexPattern formatted String
	 */
	private static String convertToRegex(String regexPattern) {

		StringBuffer stringBuffer = new StringBuffer();

		/*
		 * Add the regular expression anchor at the beginning of the line.
		 */
		stringBuffer.append("^");

		/*
		 * Convert char by char by following rule set.
		 */
		for (final char c : regexPattern.toCharArray()) {
			switch (c) {
			case '*':
				stringBuffer.append(".*?");
				break;
			case '?':
				stringBuffer.append(".");
				break;
			default:
				if (CharUtils.isAsciiAlphanumeric(c) || c == ' ') {
					stringBuffer.append(c);
				} else {
					stringBuffer.append("\\").append(c);
				}
			}
		}

		/*
		 * Add the regular expression anchor at the end of the line.
		 */
		stringBuffer.append("$");

		return stringBuffer.toString().toLowerCase();
	}

}
