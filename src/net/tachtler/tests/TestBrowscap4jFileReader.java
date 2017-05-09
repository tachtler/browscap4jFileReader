package net.tachtler.tests;

import net.tachtler.browscap4j.Browscap4jBean;
import net.tachtler.browscap4j.Browscap4jDataBean;
import net.tachtler.browscap4j.Browscap4jFileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

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

		Browscap4jDataBean fileReader = null;

		try {
			fileReader = Browscap4jFileReader.initBrowscap4jData(new File("./src/net/tachtler/tests/FileNotExists.csv"));
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

		Browscap4jBean browscap4jBean = null;
		Browscap4jDataBean fileReader = null;

		try {
			fileReader = Browscap4jFileReader.initBrowscap4jData(new File("./src/net/tachtler/tests/browscap.csv"));
		} catch (IllegalStateException e) {
			log.error("IllegalStateException                   : " + e);
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			log.error("FileNotFoundException                   : " + e1);
			e1.printStackTrace();
		} catch (IOException e2) {
			log.error("IOException                             : " + e2);
			e2.printStackTrace();
		}

		log.debug("*fileReader                             : " + fileReader.getClass());

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.80 Safari/537.36");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (Linux; U; en-us; KFAPWI Build/JDQ39) AppleWebKit/535.19 (KHTML, like Gecko) Silk/3.13 Safari/535.19 Silk-Accelerated=true");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (iPad; CPU OS 7_0 like Mac OS X) AppleWebKit/537.51.1 (KHTML, like Gecko) Version/7.0 Mobile/11A465 Safari/9537.53");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (iPhone; CPU iPhone OS 7_0 like Mac OS X; en-us) AppleWebKit/537.51.1 (KHTML, like Gecko) Version/7.0 Mobile/11A465 Safari/9537.53");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (Linux; Android 4.2.2; GT-I9505 Build/JDQ39) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.59 Mobile Safari/537.36");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (Linux; U; Android 4.1; en-us; GT-N7100 Build/JRO03C) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (MeeGo; NokiaN9) AppleWebKit/534.13 (KHTML, like Gecko) NokiaBrowser/8.5.0 Mobile Safari/534.13");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (compatible; MSIE 10.0; Windows Phone 8.0; Trident/6.0; IEMobile/10.0; ARM; Touch; NOKIA; Lumia 520)");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (Linux; U; Android 4.4.2; en-us; LGMS323 Build/KOT49I.MS32310c) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.1599.103 Mobile Safari/537.36");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (Linux; Android 4.3; Nexus 10 Build/JSS15Q) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2307.2 Safari/537.36");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; Acoo Browser; GTB5; Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1) ; InfoPath.1; .NET CLR 3.5.30729; .NET CLR 3.0.30618)");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (X11; U; Linux amd64) Iron/21.0.1200.0 Chrome/21.0.1200.0 Safari/537.1");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (Windows NT 5.1) AppleWebKit/534.25 (KHTML, like Gecko) Chrome/12.0.704.0 Safari/534.25");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/4.0 (compatible; MSIE 6.0; America Online Browser 1.1; Windows NT 5.0)");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader, "w3m/0.1.9");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.1pre) Gecko/20090629 Vonkeror/1.0");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (Macintosh; PPC Mac OS X 10.5; rv:10.0.2) Gecko/20120216 Firefox/10.0.2 TenFourFox/7450");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0; Trident/4.0; TencentTraveler 4.0; Trident/4.0; SLCC1; Media Center PC 5.0; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30618)");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.6) Gecko/20070809 Sylera/3.0.18 SeaMonkey/1.1.4");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (Windows; U; Windows NT 6.1; x64; fr; rv:1.9.1.1) Gecko/20090722 Firefox/3.5.1 Orca/1.2 build 2");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Opera/4.02 (Windows 98; U) [en]");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.0.2) Gecko/20021120 Netscape/7.01");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; MyIE2; SLCC1; .NET CLR 2.0.50727; Media Center PC 5.0)");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Lynx/2.8.6dev.11 libwww-FM/2.14");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader, "HotJava/1.1.2 FCS");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/4.0 (compatible; MSIE 5.01; Windows NT 5.0; YComp 5.0.2.6; MSIECrawler)");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"AmigaVoyager/3.2 (AmigaOS/MC680x0)");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"yacybot (x86 Windows XP 5.1; java 1.6.0_12; Europe/de) http://yacy.net/bot.html");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (compatible; Yahoo! Slurp; http://help.yahoo.com/help/us/ysearch/slurp)");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (Linux; U; Android 4.3; en-us; HM 1SW Build/JLS36C) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30 XiaoMi/MiuiBrowser/1.0");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (Linux; Android 4.3; C6903 Build/14.2.A.1.136) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.59 Mobile Safari/537.36");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (Linux; U; Android 4.2.2; de-de; Lenovo B8000-H/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.2.2 Mobile Safari/534.30");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (iPhone; CPU iPhone OS 6_0 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Version/6.0 Mobile/10A5376e Safari/8536.25");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.89 Safari/537.1 QIHU 360SE");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (Nintendo 3DS; U; ; en) Version/1.7552.EU");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (compatible; ABrowse 0.4; Syllable)");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader, "amaya/11.1 libwww/5.4.0");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; JyxoToolbar1.0; Embedded Web Browser from: http://bsalsa.com/; Avant Browser; .NET CLR 2.0.50727; .NET CLR 3.0.04506.648; .NET CLR 3.5.21022; .NET CLR 1.1.4322)");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (Windows; U; WinNT; en; rv:1.0.2) Gecko/20030311 Beonex/0.8.2-stable");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (X11; 78; CentOS; US-en) AppleWebKit/527+ (KHTML, like Gecko) Bolt/0.862 Version/3.0 Safari/523.15");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/4.61 [en] (X11; U; ) - BrowseX (2.0.0 Windows)");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (Macintosh; PPC Mac OS X 10.5; rv:2.0.1) Gecko/20100101 Firefox/4.0.1 Camino/2.2.1");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (Macintosh; U; PPC; en-US; mimic; rv:9.3.0) Clecko/20120101 Classilla/CFM");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"YOURLS v1.5.1 +http://yourls.org/ (running on http://drms.be)");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (compatible; Yahoo Link Preview; https://help.yahoo.com/kb/mail/yahoo-link-preview-SLN23615.html)");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader, "Nokia SyncML HTTP Client");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader, "gvfs/0.2.3");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Reeder/1.0.1 CFNetwork/467.12 Darwin/10.3.1");

		browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (iPad; CPU OS 6_0_1 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Mobile/10A523 [FBAN/FBIOS;FBAV/6.0.1;FBBV/180945;FBDV/iPad2,1;FBMD/iPad;FBSN/iPhone OS;FBSV/6.0.1;FBSS/1; FBCR/;FBID/tablet;FBLC/en_US;FBOP/1]");

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
