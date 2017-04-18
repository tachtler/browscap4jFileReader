# browscap4jFileReader
A simple to use Java code classes, for embedding into your own projects, using the [Browser Capabilities Project](http://browscap.org/) **browscap.csv** file, which can be download from [here](http://browscap.org/stream?q=BrowsCapCSV)

Which fields from browscap.csv are **actual**, **mostly unmaintained** or **deprecated**, can determined from following link:
[Resource: User Agents Database](https://github.com/browscap/browscap/wiki/Resource%3A-User-Agents-Database)

## Dependencies
To embed the classes from this project, subsequent dependencies must be embedded too:
- commons-lang3-3.4.jar (or higher) - download from [here](https://commons.apache.org/proper/commons-lang/download_lang.cgi)
- log4j-api-2.7.jar (or higher) - download from [here](https://logging.apache.org/log4j/2.0/download.html)
- log4j-core-2.7.jar (or higher) - download from [here](https://logging.apache.org/log4j/2.0/download.html)
- opencsv-3.9.jar (or higher) - download from [here](https://sourceforge.net/projects/opencsv/files/opencsv/)

Optionally, subsequent dependencies can be imported for testing:
- junit-4.12.jar (or higher) - download from [here](https://github.com/junit-team/junit4/wiki/Download-and-Install)

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
```
Example for a possible output (2017-03-21):

**Actual Properties**:
```java
System.out.println(browscap4jBean.getUserAgentString());
System.out.println(browscap4jBean.getUserAgentStringRegEx());
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
System.out.println(browscap4jBean.getIsSyndicationReader());
System.out.println(browscap4jBean.getIsFake());
System.out.println(browscap4jBean.getIsAnonymized());
System.out.println(browscap4jBean.getIsModified());
System.out.println(browscap4jBean.getCssVersion());
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
**Mostly unmaintained Properties**:

Theses properties are not actively maintained. Except the first two ones it should be possible to detect these properties with Javascript better.
```java
System.out.println(browscap4jBean.getAlpha());
System.out.println(browscap4jBean.getBeta());
System.out.println(browscap4jBean.getFrames());
System.out.println(browscap4jBean.getiFrames());
System.out.println(browscap4jBean.getTables());
System.out.println(browscap4jBean.getCookies());
System.out.println(browscap4jBean.getBackgroundSounds());
System.out.println(browscap4jBean.getJavaScript());
System.out.println(browscap4jBean.getVbScript());
System.out.println(browscap4jBean.getJavaApplets());
System.out.println(browscap4jBean.getActiveXControls());
```
**Deprecated Properties**:

Theses properties are maintained, but deprecated. Replacement properties have been added some time ago.
```java
System.out.println(browscap4jBean.getWin16());
System.out.println(browscap4jBean.getWin32());
System.out.println(browscap4jBean.getWin64());
System.out.println(browscap4jBean.getIsMobileDevice());
System.out.println(browscap4jBean.getIsTablet());
System.out.println(browscap4jBean.getCrawler());
System.out.println(browscap4jBean.getAolVersion());
```

## Result example
The output of the parent code for the used User-Agent-String looks like this:

```java
 *browscap4jBean.getUserAgentString()    	 Mozilla/5.0 (X11; Linux x86_64; rv:17.0) Gecko/20130917 Firefox/17.0
 *browscap4jBean.getUserAgentStringRegEx()	 mozilla/5.0 (x11; linux x86_64; rv:17.0) gecko/20130917 firefox/17.0
 *browscap4jBean.getPropertyName()       	 Mozilla/5.0 (*Linux*x86_64*) Gecko* Firefox/17.0*
 *browscap4jBean.getMasterParent()       	 false
 *browscap4jBean.getLiteMode()           	 false
 *browscap4jBean.getParent()             	 Firefox 17.0
 *browscap4jBean.getComment()            	 Firefox 17.0
 *browscap4jBean.getBrowser()            	 Firefox
 *browscap4jBean.getBrowserType()        	 Browser
 *browscap4jBean.getBrowserBits()        	 64
 *browscap4jBean.getBrowserMaker()       	 Mozilla Foundation
 *browscap4jBean.getBrowserModus()       	 
 *browscap4jBean.getVersion()            	 17.0
 *browscap4jBean.getMajorVersion()       	 17
 *browscap4jBean.getMinorVersion()       	 0
 *browscap4jBean.getPlatform()           	 Linux
 *browscap4jBean.getPlatformVersion()    	 
 *browscap4jBean.getPlatformDescription()	 Linux
 *browscap4jBean.getPlatformBits()       	 64
 *browscap4jBean.getPlatformMaker()      	 Linux Foundation
 *browscap4jBean.getIsSyndicationReader()	 false
 *browscap4jBean.getIsFake()             	 false
 *browscap4jBean.getIsAnonymized()       	 false
 *browscap4jBean.getIsModified()         	 false
 *browscap4jBean.getCssVersion()         	 3
 *browscap4jBean.getDeviceName()         	 Linux Desktop
 *browscap4jBean.getDeviceMaker()        	 
 *browscap4jBean.getDeviceType()         	 Desktop
 *browscap4jBean.getDevicePointingMethod()	 mouse
 *browscap4jBean.getDeviceCodeName()     	 Linux Desktop
 *browscap4jBean.getDeviceBrandName()    	 
 *browscap4jBean.getRenderingEngineName()	 Gecko
 *browscap4jBean.getRenderingEngineVersion() 17.0
 *browscap4jBean.getRenderingEngineDescription() For Firefox, Camino, K-Meleon, SeaMonkey, Netscape, and other Gecko-based browsers.
 *browscap4jBean.getRenderingEngineMaker()	 Mozilla Foundation
 
 *browscap4jBean.getAlpha()              	 false
 *browscap4jBean.getBeta()               	 false
 *browscap4jBean.getFrames()             	 true
 *browscap4jBean.getiFrames()            	 true
 *browscap4jBean.getTables()             	 true
 *browscap4jBean.getCookies()            	 true
 *browscap4jBean.getBackgroundSounds()   	 false
 *browscap4jBean.getJavaScript()         	 true
 *browscap4jBean.getVbScript()           	 false
 *browscap4jBean.getJavaApplets()        	 true
 *browscap4jBean.getActiveXControls()    	 false
 
 *browscap4jBean.getWin16()              	 false
 *browscap4jBean.getWin32()              	 false
 *browscap4jBean.getWin64()              	 false
 *browscap4jBean.getIsMobileDevice()     	 false
 *browscap4jBean.getIsTablet()           	 false
 *browscap4jBean.getCrawler()            	 false
 *browscap4jBean.getAolVersion()         	 0
```

## JAR-File
The creation of the **browscap4jFileReader.jar** was done with following directory structure:
```
commons-lang3-3.4.jar
log4j-api-2.7.jar
log4j-core-2.7.jar
net/tachtler/browscap4j/Browscap4jBean.java
net/tachtler/browscap4j/Browscap4jFileReader.java
opencsv-3.9.jar
```

The uploaded **browscap4jFileReader.jar** was created with follwing commands:

Command for the \*.class compilation:)

(**Linux**):
```
javac -g:none -target 1.8 -cp .:*  net/tachtler/browscap4j/*.java
```
(**Windows**):
```
"<PATH-TO-JDK>\bin\javac.exe" -g:none -target 1.8 -cp *  net\tachtler\browscap4j\*.java
```

Command for the JAR file creation:

(**Linux**):
```
jar cvf browscap4jFileReader.jar net/tachtler/browscap4j/*.class
```
(**Windows**):
```
<PATH-TO-JDK>\bin\jar.exe" cvf browscap4jFileReader.jar net\tachtler\browscap4j\*.class
```

## Performance
Performance testing was done on **very old PC** using the **development environment** [Eclipse](http://www.eclipse.org/) **with** [Tomcat 7.0.69](http://tomcat.apache.org/) **server**:
- Processor: 1 (x64) Intel(R) Core(TM)2 Quad CPU Q6600 @ 2.40GHz, 3195 MHz, 4 Core(s), 4 logical Processor(s)
- Installed physical RAM: 4 GByte (1066 MHz)
- HDD: WesternDigital WDC WD1500ADFD (10.000 rpm)
- Start under **development environment** [Eclipse](http://www.eclipse.org/) using [Tomcat 7.0.69](http://tomcat.apache.org/)

See the (average) results:

Calling the **method** ``net.tachtler.browscap4j.Browscap4jFileReader.initBrowscap4jMap`` **once** at startup:
```
[HH:MM:SS,ms ] : [Name of the method]
[00:00:05,575] : [net.tachtler.browscap4j.Browscap4jFileReader.initBrowscap4jMap]
```
Calling the **method** ``net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities`` at runtime:
```
[HH:MM:SS,ms ] : [Name of the method]
[00:00:00,076] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,078] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,069] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,322] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,276] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,108] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,080] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,110] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,116] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,065] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,061] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,053] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,107] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,005] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,088] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,077] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,043] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,040] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,080] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,079] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,338] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,057] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,081] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,012] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,082] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,004] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,012] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,001] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,001] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,002] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,033] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,001] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,062] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,147] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,151] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,121] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,090] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,013] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,043] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,023] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,012] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,003] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,071] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,072] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,001] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,056] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,073] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,002] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,078] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,031] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,004] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,333] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
[00:00:00,040] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities
```
```
--------------
[00.00:00,075] : Average results of 50 calls of different User-Agent-Strings.
```

**Version** of the [browscap.csv](http://browscap.org/stream?q=BrowsCapCSV) file:
```
GJK_Browscap_Version: 6021, Tue, 31 Jan 2017 15:21:58 +0000
Lines - browscap.csv: 184,013
File size in Byte(s): 110,026,752 (110 MegaByte) 
```
:point_right: **Please note, that all 51 fields are determined from browscap.csv file!**

## TODO:
A list of possible changes for the future:

- Think about, NOT to determine mostly unmaintained or deprecated fields.
- Change some return values (Getter/Setter) inside the Browscap4jBean from String to Boolean.

## Thanks to
Thanks for the inspiration to me to realize this project:

- [Browser Capabilities Project](http://browscap.org/)
- [Ankush Sharma](https://github.com/ankushs92/Browscap4j)
