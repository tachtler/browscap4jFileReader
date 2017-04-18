package net.tachtler.browscap4j;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.CharUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

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
	 * Map with regular expression pattern as key from the original
	 * userAgentString and a browscap4jBean as value object.
	 */
	private static Map<Pattern, Browscap4jBean> browscap4jMap = null;

	private static Browscap4jBean browscap4jBean = null;

	/**
	 * Constructor.
	 */
	public Browscap4jFileReader() {
		super();
	}

	/**
	 * Initialize the browsecap4jMap with regular expression pattern as key from
	 * the original userAgentString and a browscap4jBean from csvFile as value
	 * object.
	 * 
	 * @param csvFile
	 * @return browsecap4jMap<Pattern, Browscap4jBean>
	 * @throws IllegalStateException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static Map<Pattern, Browscap4jBean> initBrowscap4jMap(File csvFile)
			throws IllegalStateException, FileNotFoundException, IOException {

		log.debug("*csvFile                                : " + csvFile);

		/*
		 * Check if csvFile is null.
		 */
		if (null == csvFile) {
			throw new IllegalStateException("Argument csvFile is null (NOT set).");
		}

		/*
		 * Generate List<Browscap4jBean> listOfBrowscap4jBeans with all fields
		 * filled up with data from browscap.csv to a list of Browscap4jBeans
		 * using the OpenCSV from http://opencsv.sourceforge.net/
		 */
		List<Browscap4jBean> listOfBrowscap4jBeans = new ArrayList<Browscap4jBean>();

		try {
			/*
			 * Use comma as separator, quote as quotechar and skip the first
			 * three lines from csvFile - browscap.csv.
			 */
			final CSVReader csvReader = new CSVReaderBuilder(new FileReader(csvFile)).withSkipLines(3)
					.withCSVParser(new CSVParserBuilder().withSeparator(',').withQuoteChar('\"').build()).build();

			String[] col;
			while ((col = csvReader.readNext()) != null) {

				/*
				 * Generate for every entry a new Browscap4jBean.
				 */
				Browscap4jBean browscap4jBean = new Browscap4jBean();

				/*
				 * Fill up the former generated browscap4jBean with the fields
				 * from csvFile - browscap.csv.
				 */
				browscap4jBean.setPropertyName(col[0]);
				browscap4jBean.setMasterParent(col[1]);
				browscap4jBean.setLiteMode(col[2]);
				browscap4jBean.setParent(col[3]);
				browscap4jBean.setComment(col[4]);
				browscap4jBean.setBrowser(col[5]);
				browscap4jBean.setBrowserType(col[6]);
				browscap4jBean.setBrowserBits(col[7]);
				browscap4jBean.setBrowserMaker(col[8]);
				browscap4jBean.setBrowserModus(col[9]);
				browscap4jBean.setVersion(col[10]);
				browscap4jBean.setMajorVersion(col[11]);
				browscap4jBean.setMinorVersion(col[12]);
				browscap4jBean.setPlatform(col[13]);
				browscap4jBean.setPlatformVersion(col[14]);
				browscap4jBean.setPlatformDescription(col[15]);
				browscap4jBean.setPlatformBits(col[16]);
				browscap4jBean.setPlatformMaker(col[17]);
				browscap4jBean.setAlpha(col[18]);
				browscap4jBean.setBeta(col[19]);
				browscap4jBean.setWin16(col[20]);
				browscap4jBean.setWin32(col[21]);
				browscap4jBean.setWin64(col[22]);
				browscap4jBean.setFrames(col[23]);
				browscap4jBean.setiFrames(col[24]);
				browscap4jBean.setTables(col[25]);
				browscap4jBean.setCookies(col[26]);
				browscap4jBean.setBackgroundSounds(col[27]);
				browscap4jBean.setJavaScript(col[28]);
				browscap4jBean.setVbScript(col[29]);
				browscap4jBean.setJavaApplets(col[30]);
				browscap4jBean.setActiveXControls(col[31]);
				browscap4jBean.setIsMobileDevice(col[32]);
				browscap4jBean.setIsTablet(col[33]);
				browscap4jBean.setIsSyndicationReader(col[34]);
				browscap4jBean.setCrawler(col[35]);
				browscap4jBean.setIsFake(col[36]);
				browscap4jBean.setIsAnonymized(col[37]);
				browscap4jBean.setIsModified(col[38]);
				browscap4jBean.setCssVersion(col[39]);
				browscap4jBean.setAolVersion(col[40]);
				browscap4jBean.setDeviceName(col[41]);
				browscap4jBean.setDeviceMaker(col[42]);
				browscap4jBean.setDeviceType(col[43]);
				browscap4jBean.setDevicePointingMethod(col[44]);
				browscap4jBean.setDeviceCodeName(col[45]);
				browscap4jBean.setDeviceBrandName(col[46]);
				browscap4jBean.setRenderingEngineName(col[47]);
				browscap4jBean.setRenderingEngineVersion(col[48]);
				browscap4jBean.setRenderingEngineDescription(col[49]);
				browscap4jBean.setRenderingEngineMaker(col[50]);

				/*
				 * Add the former generated Browscap4jBean to the
				 * listOfBrowscap4jBeans.
				 */
				listOfBrowscap4jBeans.add(browscap4jBean);
			}
		} catch (IOException e) {
			log.error("IOException                           : " + e);
			e.printStackTrace();
		}

		/*
		 * Convert the List<Browscap4jBean> listOfBrowscap4jBeans with all the
		 * fields filled up from csvFile - browscap.csv to a list of
		 * Browscap4jBeans into a LinkedHashMap using the Java 8 (1.8) stream
		 * capabilities.
		 * 
		 * Maybe:
		 * 
		 * .sorted(Comparator.comparing(Browscap4jBean::getPropertyName).
		 * reversed())
		 * 
		 */
		browscap4jMap = listOfBrowscap4jBeans.stream().parallel()
				.collect(Collectors.toMap(
						browscap4jBean -> Pattern.compile(convertToRegex(browscap4jBean.getPropertyName()),
								Pattern.CASE_INSENSITIVE),
						browscap4jBean -> browscap4jBean, (p1, p2) -> p1, LinkedHashMap::new));

		/*
		 * Debug NOT the Map, because of too much entry's, only the class should
		 * be printed out in debug mode, to see if the browscap4jMap is NOT
		 * null.
		 */
		log.debug("*browscap4jMap                          : " + browscap4jMap.getClass());

		return browscap4jMap;
	}

	/**
	 * Determining the Browscap4jCapabilities with the userAgentString from
	 * browsecap4jMap and return the result in a browscap4jBean.
	 * 
	 * @param browsecap4jMap<Pattern,
	 *            Browscap4jBean>
	 * @param userAgentString
	 * @return browscap4jBean
	 */
	public static Browscap4jBean determineBrowscap4jCapabilities(Map<Pattern, Browscap4jBean> browsecap4jMap,
			String userAgentString) {

		/*
		 * Debug NOT the Map, because of too much entry's, only the class should
		 * be printed out in debug mode, to see if the browscap4jMap is NOT
		 * null.
		 */
		log.debug("*browsecap4jMap                         : " + browsecap4jMap.getClass());

		log.debug("*userAgentString                        : " + userAgentString);

		/*
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
		final Optional<Entry<Pattern, Browscap4jBean>> browsecap4jMapEntry = browsecap4jMap.entrySet().stream()
				.parallel().filter(entry -> {
					final Matcher matcher = entry.getKey().matcher(userAgentStringRegEx);
					return matcher.matches();
				}).findFirst();

		/*
		 * Return the search result browsecap4jMapEntry if one was present. If
		 * true, return the browscap4jBean value from browscap4jMap. If false
		 * return browscap4jBean with empty values and the search field's
		 * userAgentString and userAgentStringRegEx.
		 */
		if (browsecap4jMapEntry.isPresent()) {
			browscap4jBean = browsecap4jMapEntry.get().getValue();

			log.debug("Browsercapabilities were found for      : " + userAgentString);
			log.debug("*browsecap4jMapEntry.get().getKey()     : " + browsecap4jMapEntry.get().getKey());
			log.debug("*browsecap4jMapEntry.get().getValue()   : " + browsecap4jMapEntry.get().getValue());
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
