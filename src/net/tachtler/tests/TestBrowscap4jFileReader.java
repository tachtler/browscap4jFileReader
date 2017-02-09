package net.tachtler.tests;

import net.tachtler.browscap4j.Browscap4jBean;
import net.tachtler.browscap4j.Browscap4jFileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/*******************************************************************************
 * Create Test for Browscap4jFileReader.
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
public class TestBrowscap4jFileReader {

	private static Logger log = LogManager.getLogger();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		log.info("Start: TestBrowscap4jFileReader ------- : ");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		log.info("Ended: TestBrowscap4jFileReader ------- : ");
	}

	/**
	 * Test method for
	 * {@link net.tachtler.browscap4j.Browsecap4jFileReader(java.io.File)}
	 * IOException.
	 */
	@Test
	public void testBrowsecap4jFileReaderIOException() {

		ExpectedException exception = ExpectedException.none();

		Map<Pattern, Browscap4jBean> fileReader = null;

		try {
			fileReader = Browscap4jFileReader.initBrowscap4jMap(new File("./src/net/tachtler/tests/FileNotExists.csv"));
		} catch (IllegalStateException e) {
			log.error("IllegalStateException : " + e);
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			log.error("FileNotFoundException : " + e);
			e.printStackTrace();
		} catch (IOException e) {
			log.error("IOException : " + e);
			e.printStackTrace();
		}

		log.debug("*fileReader : " + fileReader);

		exception.expect(FileNotFoundException.class);
	}

	/**
	 * Test method for
	 * {@link net.tachtler.browscap4j.Browsecap4jFileReader(java.io.File)}.
	 */
	@Test
	public void testBrowsecap4jFileReaderEcecute() {

		Map<Pattern, Browscap4jBean> fileReader = null;

		try {
			fileReader = Browscap4jFileReader.initBrowscap4jMap(new File("./src/net/tachtler/browscap4j/browscap.csv"));
		} catch (IllegalStateException e) {
			log.error("IllegalStateException                 : " + e);
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			log.error("FileNotFoundException                 : " + e);
			e.printStackTrace();
		} catch (IOException e) {
			log.error("IOException                           : " + e);
			e.printStackTrace();
		}

		log.debug("*fileReader                             : " + fileReader.getClass());

		Browscap4jBean browscap4jBean = null;

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (X11; Linux x86_64; rv:17.0) Gecko/20130917 Firefox/17.0");

		log.debug("*browscap4jBean                         : " + browscap4jBean);

		log.debug("*browscap4jBean.getUserAgentString()    : " + browscap4jBean.getUserAgentString());
		log.debug("*browscap4jBean.getUserAgentStringReg...: " + browscap4jBean.getUserAgentStringRegEx());

		log.debug("*browscap4jBean.getPropertyName()       : " + browscap4jBean.getPropertyName());
		log.debug("*browscap4jBean.getMasterParent()       : " + browscap4jBean.getMasterParent());
		log.debug("*browscap4jBean.getLiteMode()           : " + browscap4jBean.getLiteMode());
		log.debug("*browscap4jBean.getParent()             : " + browscap4jBean.getParent());
		log.debug("*browscap4jBean.getComment()            : " + browscap4jBean.getComment());
		log.debug("*browscap4jBean.getBrowser()            : " + browscap4jBean.getBrowser());
		log.debug("*browscap4jBean.getBrowserType()        : " + browscap4jBean.getBrowserType());
		log.debug("*browscap4jBean.getBrowserBits()        : " + browscap4jBean.getBrowserBits());
		log.debug("*browscap4jBean.getBrowserMaker()       : " + browscap4jBean.getBrowserMaker());
		log.debug("*browscap4jBean.getBrowserModus()       : " + browscap4jBean.getBrowserModus());
		log.debug("*browscap4jBean.getVersion()            : " + browscap4jBean.getVersion());
		log.debug("*browscap4jBean.getMajorVersion()       : " + browscap4jBean.getMajorVersion());
		log.debug("*browscap4jBean.getMinorVersion()       : " + browscap4jBean.getMinorVersion());
		log.debug("*browscap4jBean.getPlatform()           : " + browscap4jBean.getPlatform());
		log.debug("*browscap4jBean.getPlatformVersion()    : " + browscap4jBean.getPlatformVersion());
		log.debug("*browscap4jBean.getPlatformDescription(): " + browscap4jBean.getPlatformDescription());
		log.debug("*browscap4jBean.getPlatformBits()       : " + browscap4jBean.getPlatformBits());
		log.debug("*browscap4jBean.getPlatformMaker()      : " + browscap4jBean.getPlatformMaker());
		log.debug("*browscap4jBean.getAlpha()              : " + browscap4jBean.getAlpha());
		log.debug("*browscap4jBean.getBeta()               : " + browscap4jBean.getBeta());
		log.debug("*browscap4jBean.getWin16()              : " + browscap4jBean.getWin16());
		log.debug("*browscap4jBean.getWin32()              : " + browscap4jBean.getWin32());
		log.debug("*browscap4jBean.getWin64()              : " + browscap4jBean.getWin64());
		log.debug("*browscap4jBean.getFrames()             : " + browscap4jBean.getFrames());
		log.debug("*browscap4jBean.getiFrames()            : " + browscap4jBean.getiFrames());
		log.debug("*browscap4jBean.getTables()             : " + browscap4jBean.getTables());
		log.debug("*browscap4jBean.getCookies()            : " + browscap4jBean.getCookies());
		log.debug("*browscap4jBean.getBackgroundSounds()   : " + browscap4jBean.getBackgroundSounds());
		log.debug("*browscap4jBean.getJavaScript()         : " + browscap4jBean.getJavaScript());
		log.debug("*browscap4jBean.getVbScript()           : " + browscap4jBean.getVbScript());
		log.debug("*browscap4jBean.getJavaApplets()        : " + browscap4jBean.getJavaApplets());
		log.debug("*browscap4jBean.getActiveXControls()    : " + browscap4jBean.getActiveXControls());
		log.debug("*browscap4jBean.getIsMobileDevice()     : " + browscap4jBean.getIsMobileDevice());
		log.debug("*browscap4jBean.getIsTablet()           : " + browscap4jBean.getIsTablet());
		log.debug("*browscap4jBean.getIsSyndicationReader(): " + browscap4jBean.getIsSyndicationReader());
		log.debug("*browscap4jBean.getCrawler()            : " + browscap4jBean.getCrawler());
		log.debug("*browscap4jBean.getIsFake()             : " + browscap4jBean.getIsFake());
		log.debug("*browscap4jBean.getIsAnonymized()       : " + browscap4jBean.getIsAnonymized());
		log.debug("*browscap4jBean.getIsModified()         : " + browscap4jBean.getIsModified());
		log.debug("*browscap4jBean.getCssVersion()         : " + browscap4jBean.getCssVersion());
		log.debug("*browscap4jBean.getAolVersion()         : " + browscap4jBean.getAolVersion());
		log.debug("*browscap4jBean.getDeviceName()         : " + browscap4jBean.getDeviceName());
		log.debug("*browscap4jBean.getDeviceMaker()        : " + browscap4jBean.getDeviceMaker());
		log.debug("*browscap4jBean.getDeviceType()         : " + browscap4jBean.getDeviceType());
		log.debug("*browscap4jBean.getDevicePointingMeth...: " + browscap4jBean.getDevicePointingMethod());
		log.debug("*browscap4jBean.getDeviceCodeName()     : " + browscap4jBean.getDeviceCodeName());
		log.debug("*browscap4jBean.getDeviceBrandName()    : " + browscap4jBean.getDeviceBrandName());
		log.debug("*browscap4jBean.getRenderingEngineName(): " + browscap4jBean.getRenderingEngineName());
		log.debug("*browscap4jBean.getRenderingEngineVer...: " + browscap4jBean.getRenderingEngineVersion());
		log.debug("*browscap4jBean.getRenderingEngineDes...: " + browscap4jBean.getRenderingEngineDescription());
		log.debug("*browscap4jBean.getRenderingEngineMak...: " + browscap4jBean.getRenderingEngineMaker());

		// ----------------------------------------------------------------------

		assertTrue("Mozilla/5.0 (X11; Linux x86_64; rv:17.0) Gecko/20130917 Firefox/17.0"
				.equals(browscap4jBean.getUserAgentString()));
		assertTrue("mozilla/5.0 (x11; linux x86_64; rv:17.0) gecko/20130917 firefox/17.0"
				.equals(browscap4jBean.getUserAgentStringRegEx()));
		assertTrue("Mozilla/5.0 (*Linux*x86_64*) Gecko* Firefox/17.0*".equals(browscap4jBean.getPropertyName()));
		assertTrue("false".equals(browscap4jBean.getMasterParent()));
		assertTrue("false".equals(browscap4jBean.getLiteMode()));
		assertTrue("Firefox 17.0".equals(browscap4jBean.getParent()));
		assertTrue("Firefox 17.0".equals(browscap4jBean.getComment()));
		assertTrue("Firefox".equals(browscap4jBean.getBrowser()));
		assertTrue("Browser".equals(browscap4jBean.getBrowserType()));
		assertTrue("64".equals(browscap4jBean.getBrowserBits()));
		assertTrue("Mozilla Foundation".equals(browscap4jBean.getBrowserMaker()));
		assertTrue("".equals(browscap4jBean.getBrowserModus()));
		assertTrue("17.0".equals(browscap4jBean.getVersion()));
		assertTrue("17".equals(browscap4jBean.getMajorVersion()));
		assertTrue("0".equals(browscap4jBean.getMinorVersion()));
		assertTrue("Linux".equals(browscap4jBean.getPlatform()));
		assertTrue("".equals(browscap4jBean.getPlatformVersion()));
		assertTrue("Linux".equals(browscap4jBean.getPlatformDescription()));
		assertTrue("64".equals(browscap4jBean.getPlatformBits()));
		assertTrue("Linux Foundation".equals(browscap4jBean.getPlatformMaker()));
		assertTrue("false".equals(browscap4jBean.getAlpha()));
		assertTrue("false".equals(browscap4jBean.getBeta()));
		assertTrue("false".equals(browscap4jBean.getWin16()));
		assertTrue("false".equals(browscap4jBean.getWin32()));
		assertTrue("false".equals(browscap4jBean.getWin64()));
		assertTrue("true".equals(browscap4jBean.getFrames()));
		assertTrue("true".equals(browscap4jBean.getiFrames()));
		assertTrue("true".equals(browscap4jBean.getTables()));
		assertTrue("true".equals(browscap4jBean.getCookies()));
		assertTrue("false".equals(browscap4jBean.getBackgroundSounds()));
		assertTrue("true".equals(browscap4jBean.getJavaScript()));
		assertTrue("false".equals(browscap4jBean.getVbScript()));
		assertTrue("true".equals(browscap4jBean.getJavaApplets()));
		assertTrue("false".equals(browscap4jBean.getActiveXControls()));
		assertTrue("false".equals(browscap4jBean.getIsMobileDevice()));
		assertTrue("false".equals(browscap4jBean.getIsTablet()));
		assertTrue("false".equals(browscap4jBean.getIsSyndicationReader()));
		assertTrue("false".equals(browscap4jBean.getCrawler()));
		assertTrue("false".equals(browscap4jBean.getIsFake()));
		assertTrue("false".equals(browscap4jBean.getIsAnonymized()));
		assertTrue("false".equals(browscap4jBean.getIsModified()));
		assertTrue("3".equals(browscap4jBean.getCssVersion()));
		assertTrue("0".equals(browscap4jBean.getAolVersion()));
		assertTrue("Linux Desktop".equals(browscap4jBean.getDeviceName()));
		assertTrue("".equals(browscap4jBean.getDeviceMaker()));
		assertTrue("Desktop".equals(browscap4jBean.getDeviceType()));
		assertTrue("mouse".equals(browscap4jBean.getDevicePointingMethod()));
		assertTrue("Linux Desktop".equals(browscap4jBean.getDeviceCodeName()));
		assertTrue("".equals(browscap4jBean.getDeviceBrandName()));
		assertTrue("Gecko".equals(browscap4jBean.getRenderingEngineName()));
		assertTrue("17.0".equals(browscap4jBean.getRenderingEngineVersion()));
		assertTrue("For Firefox, Camino, K-Meleon, SeaMonkey, Netscape, and other Gecko-based browsers."
				.equals(browscap4jBean.getRenderingEngineDescription()));
		assertTrue("Mozilla Foundation".equals(browscap4jBean.getRenderingEngineMaker()));
	}

}
