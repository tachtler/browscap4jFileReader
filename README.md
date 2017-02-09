# browscap4jFileReader
A basic Java library for the Browscap.org project.

A simple to use Java code classes, for embedding into your own projects, using the [Browser Capabilities Project](http://browscap.org/) **browscap.csv** file, which can be download from [here](http://browscap.org/stream?q=BrowsCapCSV)

## Dependencies
To embed the classes from this project, subsequent dependencies must be embedded too:
- commons-lang3-3.4.jar (or higher) - download from [here](https://commons.apache.org/proper/commons-lang/download_lang.cgi)
- log4j-api-2.7.jar (or higher) - download from [here](https://logging.apache.org/log4j/2.0/download.html)
- log4j-core-2.7.jar (or higher) - download from [here](https://logging.apache.org/log4j/2.0/download.html)
- opencsv-3.9.jar (or higher) - download from [here](https://sourceforge.net/projects/opencsv/files/opencsv/)

## Instructions

:exclamation: **Important: Browscap4jFileReader uses Java 8 (1.8)** :exclamation:

The **default** processing mechanism ist **parallel processing**, which uses **Java 8 (1.8) parallel streams**.

In order to get Browser capabilities, you need to first provide Browscap4jFileReader with the path to the csv file **and** finally, to fetch the data for a Browser User-Agent-String, it can be done by using the simple last two lines, like this:

(The result of the Browscap4jFileReader will be returned as a **Bean**.)
```java
Map<Pattern, Browscap4jBean> fileReader = null;

try {
	fileReader = Browscap4jFileReader.initBrowscap4jMap(new File("./PATH_TO_BROWSCAP_CSV"));
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
    
Browscap4jBean browscap4jBean = null;
browscap4jBean = Browscap4jFileReader.determineBrowscap4jCapabilities(fileReader,
				"Mozilla/5.0 (X11; Linux x86_64; rv:17.0) Gecko/20130917 Firefox/17.0");    

System.out.println(browscap4jBean.getPropertyName());
System.out.println(browscap4jBean.getMasterParent());
System.out.println(browscap4jBean.getLiteMode());
System.out.println(browscap4jBean.getParent());
System.out.println(browscap4jBean.getComment());
System.out.println(browscap4jBean.getBrowser());
System.out.println(browscap4jBean.getBrowserType());
System.out.println(browscap4jBean.getBrowserBits());
System.out.println(browscap4jBean.getBrowserMaker());
System.out.println(browscap4jBean.getBrowserModus());
System.out.println(browscap4jBean.getVersion());
System.out.println(browscap4jBean.getMajorVersion());
System.out.println(browscap4jBean.getMinorVersion());
System.out.println(browscap4jBean.getPlatform());
System.out.println(browscap4jBean.getPlatformVersion());
System.out.println(browscap4jBean.getPlatformDescription());
System.out.println(browscap4jBean.getPlatformBits());
System.out.println(browscap4jBean.getPlatformMaker());
System.out.println(browscap4jBean.getAlpha());
System.out.println(browscap4jBean.getBeta());
System.out.println(browscap4jBean.getWin16());
System.out.println(browscap4jBean.getWin32());
System.out.println(browscap4jBean.getWin64());
System.out.println(browscap4jBean.getFrames());
System.out.println(browscap4jBean.getiFrames());
System.out.println(browscap4jBean.getTables());
System.out.println(browscap4jBean.getCookies());
System.out.println(browscap4jBean.getBackgroundSounds());
System.out.println(browscap4jBean.getJavaScript());
System.out.println(browscap4jBean.getVbScript());
System.out.println(browscap4jBean.getJavaApplets());
System.out.println(browscap4jBean.getActiveXControls());
System.out.println(browscap4jBean.getIsMobileDevice());
System.out.println(browscap4jBean.getIsTablet());
System.out.println(browscap4jBean.getIsSyndicationReader());
System.out.println(browscap4jBean.getCrawler());
System.out.println(browscap4jBean.getIsFake());
System.out.println(browscap4jBean.getIsAnonymized());
System.out.println(browscap4jBean.getIsModified());
System.out.println(browscap4jBean.getCssVersion());
System.out.println(browscap4jBean.getAolVersion());
System.out.println(browscap4jBean.getDeviceName());
System.out.println(browscap4jBean.getDeviceMaker());
System.out.println(browscap4jBean.getDeviceType());
System.out.println(browscap4jBean.getDevicePointingMethod());
System.out.println(browscap4jBean.getDeviceCodeName());
System.out.println(browscap4jBean.getDeviceBrandName());
System.out.println(browscap4jBean.getRenderingEngineName());
System.out.println(browscap4jBean.getRenderingEngineVersion());
System.out.println(browscap4jBean.getRenderingEngineDescription());
System.out.println(browscap4jBean.getRenderingEngineMaker());
```
