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

public class Browscap4jBean {

	/**
	 * User-Agent-String.
	 */
	private String userAgentString = "";
	private String userAgentStringRegEx = "";

	/**
	 * Fields from browscap.csv.
	 */
	private String propertyName = "";
	private String masterParent = "";
	private String liteMode = "";
	private String parent = "";
	private String comment = "";
	private String browser = "";
	private String browserType = "";
	private String browserBits = "";
	private String browserMaker = "";
	private String browserModus = "";
	private String version = "";
	private String majorVersion = "";
	private String minorVersion = "";
	private String platform = "";
	private String platformVersion = "";
	private String platformDescription = "";
	private String platformBits = "";
	private String platformMaker = "";
	private String alpha = "";
	private String beta = "";
	private String win16 = "";
	private String win32 = "";
	private String win64 = "";
	private String frames = "";
	private String iFrames = "";
	private String tables = "";
	private String cookies = "";
	private String backgroundSounds = "";
	private String javaScript = "";
	private String vbScript = "";
	private String javaApplets = "";
	private String activeXControls = "";
	private String isMobileDevice = "";
	private String isTablet = "";
	private String isSyndicationReader = "";
	private String crawler = "";
	private String isFake = "";
	private String isAnonymized = "";
	private String isModified = "";
	private String cssVersion = "";
	private String aolVersion = "";
	private String deviceName = "";
	private String deviceMaker = "";
	private String deviceType = "";
	private String devicePointingMethod = "";
	private String deviceCodeName = "";
	private String deviceBrandName = "";
	private String renderingEngineName = "";
	private String renderingEngineVersion = "";
	private String renderingEngineDescription = "";
	private String renderingEngineMaker = "";

	/**
	 * Constructor.
	 */
	public Browscap4jBean() {
		super();
		this.init();
	}

	/**
	 * Initialize all variables to default or unseeded values.
	 */
	public final void init() {
		this.userAgentString = "";
		this.userAgentStringRegEx = "";
		this.propertyName = "";
		this.masterParent = "";
		this.liteMode = "";
		this.parent = "";
		this.comment = "";
		this.browser = "";
		this.browserType = "";
		this.browserBits = "";
		this.browserMaker = "";
		this.browserModus = "";
		this.version = "";
		this.majorVersion = "";
		this.minorVersion = "";
		this.platform = "";
		this.platformVersion = "";
		this.platformDescription = "";
		this.platformBits = "";
		this.platformMaker = "";
		this.alpha = "";
		this.beta = "";
		this.win16 = "";
		this.win32 = "";
		this.win64 = "";
		this.frames = "";
		this.iFrames = "";
		this.tables = "";
		this.cookies = "";
		this.backgroundSounds = "";
		this.javaScript = "";
		this.vbScript = "";
		this.javaApplets = "";
		this.activeXControls = "";
		this.isMobileDevice = "";
		this.isTablet = "";
		this.isSyndicationReader = "";
		this.crawler = "";
		this.isFake = "";
		this.isAnonymized = "";
		this.isModified = "";
		this.cssVersion = "";
		this.aolVersion = "";
		this.deviceName = "";
		this.deviceMaker = "";
		this.deviceType = "";
		this.devicePointingMethod = "";
		this.deviceCodeName = "";
		this.deviceBrandName = "";
		this.renderingEngineName = "";
		this.renderingEngineVersion = "";
		this.renderingEngineDescription = "";
		this.renderingEngineMaker = "";
	}

	/**
	 * @return the userAgentString
	 */
	public String getUserAgentString() {
		return userAgentString;
	}

	/**
	 * @param userAgentString
	 *            the userAgentString to set
	 */
	public void setUserAgentString(String userAgentString) {
		this.userAgentString = userAgentString;
	}

	/**
	 * @return the userAgentStringRegEx
	 */
	public String getUserAgentStringRegEx() {
		return userAgentStringRegEx;
	}

	/**
	 * @param userAgentStringRegEx
	 *            the userAgentStringRegEx to set
	 */
	public void setUserAgentStringRegEx(String userAgentStringRegEx) {
		this.userAgentStringRegEx = userAgentStringRegEx;
	}

	/**
	 * @return the propertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * @param propertyName
	 *            the propertyName to set
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	/**
	 * @return the masterParent
	 */
	public String getMasterParent() {
		return masterParent;
	}

	/**
	 * @param masterParent
	 *            the masterParent to set
	 */
	public void setMasterParent(String masterParent) {
		this.masterParent = masterParent;
	}

	/**
	 * @return the liteMode
	 */
	public String getLiteMode() {
		return liteMode;
	}

	/**
	 * @param liteMode
	 *            the liteMode to set
	 */
	public void setLiteMode(String liteMode) {
		this.liteMode = liteMode;
	}

	/**
	 * @return the parent
	 */
	public String getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(String parent) {
		this.parent = parent;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the browser
	 */
	public String getBrowser() {
		return browser;
	}

	/**
	 * @param browser
	 *            the browser to set
	 */
	public void setBrowser(String browser) {
		this.browser = browser;
	}

	/**
	 * @return the browserType
	 */
	public String getBrowserType() {
		return browserType;
	}

	/**
	 * @param browserType
	 *            the browserType to set
	 */
	public void setBrowserType(String browserType) {
		this.browserType = browserType;
	}

	/**
	 * @return the browserBits
	 */
	public String getBrowserBits() {
		return browserBits;
	}

	/**
	 * @param browserBits
	 *            the browserBits to set
	 */
	public void setBrowserBits(String browserBits) {
		this.browserBits = browserBits;
	}

	/**
	 * @return the browserMaker
	 */
	public String getBrowserMaker() {
		return browserMaker;
	}

	/**
	 * @param browserMaker
	 *            the browserMaker to set
	 */
	public void setBrowserMaker(String browserMaker) {
		this.browserMaker = browserMaker;
	}

	/**
	 * @return the browserModus
	 */
	public String getBrowserModus() {
		return browserModus;
	}

	/**
	 * @param browserModus
	 *            the browserModus to set
	 */
	public void setBrowserModus(String browserModus) {
		this.browserModus = browserModus;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the majorVersion
	 */
	public String getMajorVersion() {
		return majorVersion;
	}

	/**
	 * @param majorVersion
	 *            the majorVersion to set
	 */
	public void setMajorVersion(String majorVersion) {
		this.majorVersion = majorVersion;
	}

	/**
	 * @return the minorVersion
	 */
	public String getMinorVersion() {
		return minorVersion;
	}

	/**
	 * @param minorVersion
	 *            the minorVersion to set
	 */
	public void setMinorVersion(String minorVersion) {
		this.minorVersion = minorVersion;
	}

	/**
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * @param platform
	 *            the platform to set
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	/**
	 * @return the platformVersion
	 */
	public String getPlatformVersion() {
		return platformVersion;
	}

	/**
	 * @param platformVersion
	 *            the platformVersion to set
	 */
	public void setPlatformVersion(String platformVersion) {
		this.platformVersion = platformVersion;
	}

	/**
	 * @return the platformDescription
	 */
	public String getPlatformDescription() {
		return platformDescription;
	}

	/**
	 * @param platformDescription
	 *            the platformDescription to set
	 */
	public void setPlatformDescription(String platformDescription) {
		this.platformDescription = platformDescription;
	}

	/**
	 * @return the platformBits
	 */
	public String getPlatformBits() {
		return platformBits;
	}

	/**
	 * @param platformBits
	 *            the platformBits to set
	 */
	public void setPlatformBits(String platformBits) {
		this.platformBits = platformBits;
	}

	/**
	 * @return the platformMaker
	 */
	public String getPlatformMaker() {
		return platformMaker;
	}

	/**
	 * @param platformMaker
	 *            the platformMaker to set
	 */
	public void setPlatformMaker(String platformMaker) {
		this.platformMaker = platformMaker;
	}

	/**
	 * @return the alpha
	 */
	public String getAlpha() {
		return alpha;
	}

	/**
	 * @param alpha
	 *            the alpha to set
	 */
	public void setAlpha(String alpha) {
		this.alpha = alpha;
	}

	/**
	 * @return the beta
	 */
	public String getBeta() {
		return beta;
	}

	/**
	 * @param beta
	 *            the beta to set
	 */
	public void setBeta(String beta) {
		this.beta = beta;
	}

	/**
	 * @return the win16
	 */
	public String getWin16() {
		return win16;
	}

	/**
	 * @param win16
	 *            the win16 to set
	 */
	public void setWin16(String win16) {
		this.win16 = win16;
	}

	/**
	 * @return the win32
	 */
	public String getWin32() {
		return win32;
	}

	/**
	 * @param win32
	 *            the win32 to set
	 */
	public void setWin32(String win32) {
		this.win32 = win32;
	}

	/**
	 * @return the win64
	 */
	public String getWin64() {
		return win64;
	}

	/**
	 * @param win64
	 *            the win64 to set
	 */
	public void setWin64(String win64) {
		this.win64 = win64;
	}

	/**
	 * @return the frames
	 */
	public String getFrames() {
		return frames;
	}

	/**
	 * @param frames
	 *            the frames to set
	 */
	public void setFrames(String frames) {
		this.frames = frames;
	}

	/**
	 * @return the iFrames
	 */
	public String getiFrames() {
		return iFrames;
	}

	/**
	 * @param iFrames
	 *            the iFrames to set
	 */
	public void setiFrames(String iFrames) {
		this.iFrames = iFrames;
	}

	/**
	 * @return the tables
	 */
	public String getTables() {
		return tables;
	}

	/**
	 * @param tables
	 *            the tables to set
	 */
	public void setTables(String tables) {
		this.tables = tables;
	}

	/**
	 * @return the cookies
	 */
	public String getCookies() {
		return cookies;
	}

	/**
	 * @param cookies
	 *            the cookies to set
	 */
	public void setCookies(String cookies) {
		this.cookies = cookies;
	}

	/**
	 * @return the backgroundSounds
	 */
	public String getBackgroundSounds() {
		return backgroundSounds;
	}

	/**
	 * @param backgroundSounds
	 *            the backgroundSounds to set
	 */
	public void setBackgroundSounds(String backgroundSounds) {
		this.backgroundSounds = backgroundSounds;
	}

	/**
	 * @return the javaScript
	 */
	public String getJavaScript() {
		return javaScript;
	}

	/**
	 * @param javaScript
	 *            the javaScript to set
	 */
	public void setJavaScript(String javaScript) {
		this.javaScript = javaScript;
	}

	/**
	 * @return the vbScript
	 */
	public String getVbScript() {
		return vbScript;
	}

	/**
	 * @param vbScript
	 *            the vbScript to set
	 */
	public void setVbScript(String vbScript) {
		this.vbScript = vbScript;
	}

	/**
	 * @return the javaApplets
	 */
	public String getJavaApplets() {
		return javaApplets;
	}

	/**
	 * @param javaApplets
	 *            the javaApplets to set
	 */
	public void setJavaApplets(String javaApplets) {
		this.javaApplets = javaApplets;
	}

	/**
	 * @return the activeXControls
	 */
	public String getActiveXControls() {
		return activeXControls;
	}

	/**
	 * @param activeXControls
	 *            the activeXControls to set
	 */
	public void setActiveXControls(String activeXControls) {
		this.activeXControls = activeXControls;
	}

	/**
	 * @return the isMobileDevice
	 */
	public String getIsMobileDevice() {
		return isMobileDevice;
	}

	/**
	 * @param isMobileDevice
	 *            the isMobileDevice to set
	 */
	public void setIsMobileDevice(String isMobileDevice) {
		this.isMobileDevice = isMobileDevice;
	}

	/**
	 * @return the isTablet
	 */
	public String getIsTablet() {
		return isTablet;
	}

	/**
	 * @param isTablet
	 *            the isTablet to set
	 */
	public void setIsTablet(String isTablet) {
		this.isTablet = isTablet;
	}

	/**
	 * @return the isSyndicationReader
	 */
	public String getIsSyndicationReader() {
		return isSyndicationReader;
	}

	/**
	 * @param isSyndicationReader
	 *            the isSyndicationReader to set
	 */
	public void setIsSyndicationReader(String isSyndicationReader) {
		this.isSyndicationReader = isSyndicationReader;
	}

	/**
	 * @return the crawler
	 */
	public String getCrawler() {
		return crawler;
	}

	/**
	 * @param crawler
	 *            the crawler to set
	 */
	public void setCrawler(String crawler) {
		this.crawler = crawler;
	}

	/**
	 * @return the isFake
	 */
	public String getIsFake() {
		return isFake;
	}

	/**
	 * @param isFake
	 *            the isFake to set
	 */
	public void setIsFake(String isFake) {
		this.isFake = isFake;
	}

	/**
	 * @return the isAnonymized
	 */
	public String getIsAnonymized() {
		return isAnonymized;
	}

	/**
	 * @param isAnonymized
	 *            the isAnonymized to set
	 */
	public void setIsAnonymized(String isAnonymized) {
		this.isAnonymized = isAnonymized;
	}

	/**
	 * @return the isModified
	 */
	public String getIsModified() {
		return isModified;
	}

	/**
	 * @param isModified
	 *            the isModified to set
	 */
	public void setIsModified(String isModified) {
		this.isModified = isModified;
	}

	/**
	 * @return the cssVersion
	 */
	public String getCssVersion() {
		return cssVersion;
	}

	/**
	 * @param cssVersion
	 *            the cssVersion to set
	 */
	public void setCssVersion(String cssVersion) {
		this.cssVersion = cssVersion;
	}

	/**
	 * @return the aolVersion
	 */
	public String getAolVersion() {
		return aolVersion;
	}

	/**
	 * @param aolVersion
	 *            the aolVersion to set
	 */
	public void setAolVersion(String aolVersion) {
		this.aolVersion = aolVersion;
	}

	/**
	 * @return the deviceName
	 */
	public String getDeviceName() {
		return deviceName;
	}

	/**
	 * @param deviceName
	 *            the deviceName to set
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	/**
	 * @return the deviceMaker
	 */
	public String getDeviceMaker() {
		return deviceMaker;
	}

	/**
	 * @param deviceMaker
	 *            the deviceMaker to set
	 */
	public void setDeviceMaker(String deviceMaker) {
		this.deviceMaker = deviceMaker;
	}

	/**
	 * @return the deviceType
	 */
	public String getDeviceType() {
		return deviceType;
	}

	/**
	 * @param deviceType
	 *            the deviceType to set
	 */
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 * @return the devicePointingMethod
	 */
	public String getDevicePointingMethod() {
		return devicePointingMethod;
	}

	/**
	 * @param devicePointingMethod
	 *            the devicePointingMethod to set
	 */
	public void setDevicePointingMethod(String devicePointingMethod) {
		this.devicePointingMethod = devicePointingMethod;
	}

	/**
	 * @return the deviceCodeName
	 */
	public String getDeviceCodeName() {
		return deviceCodeName;
	}

	/**
	 * @param deviceCodeName
	 *            the deviceCodeName to set
	 */
	public void setDeviceCodeName(String deviceCodeName) {
		this.deviceCodeName = deviceCodeName;
	}

	/**
	 * @return the deviceBrandName
	 */
	public String getDeviceBrandName() {
		return deviceBrandName;
	}

	/**
	 * @param deviceBrandName
	 *            the deviceBrandName to set
	 */
	public void setDeviceBrandName(String deviceBrandName) {
		this.deviceBrandName = deviceBrandName;
	}

	/**
	 * @return the renderingEngineName
	 */
	public String getRenderingEngineName() {
		return renderingEngineName;
	}

	/**
	 * @param renderingEngineName
	 *            the renderingEngineName to set
	 */
	public void setRenderingEngineName(String renderingEngineName) {
		this.renderingEngineName = renderingEngineName;
	}

	/**
	 * @return the renderingEngineVersion
	 */
	public String getRenderingEngineVersion() {
		return renderingEngineVersion;
	}

	/**
	 * @param renderingEngineVersion
	 *            the renderingEngineVersion to set
	 */
	public void setRenderingEngineVersion(String renderingEngineVersion) {
		this.renderingEngineVersion = renderingEngineVersion;
	}

	/**
	 * @return the renderingEngineDescription
	 */
	public String getRenderingEngineDescription() {
		return renderingEngineDescription;
	}

	/**
	 * @param renderingEngineDescription
	 *            the renderingEngineDescription to set
	 */
	public void setRenderingEngineDescription(String renderingEngineDescription) {
		this.renderingEngineDescription = renderingEngineDescription;
	}

	/**
	 * @return the renderingEngineMaker
	 */
	public String getRenderingEngineMaker() {
		return renderingEngineMaker;
	}

	/**
	 * @param renderingEngineMaker
	 *            the renderingEngineMaker to set
	 */
	public void setRenderingEngineMaker(String renderingEngineMaker) {
		this.renderingEngineMaker = renderingEngineMaker;
	}

}
