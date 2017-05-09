# browscap4jFileReader
A simple to use Java code classes, for embedding into your own projects, using the [Browser Capabilities Project](http://browscap.org/) **browscap.csv** file, which can be download from [here](http://browscap.org/stream?q=BrowsCapCSV)

Which fields from browscap.csv are **actual**, **mostly unmaintained** or **deprecated**, can determined from following link:
[Resource: User Agents Database](https://github.com/browscap/browscap/wiki/Resource%3A-User-Agents-Database)

## Changes to Version 1.0
**Complete redesign of the Browscap4jFileReader.**

Main changes are:
- Reading the file without using opencsv.jar any more using instead Apache commons-io (**faster**)
- Reading the file and generate a Browscap4jDataBean with Browscap4jMap and Browscap4jString instead of Browscap4jMap only (**less memory**)
- Browscap4jMap has the compiled regular expression pattern as key and the only Browscap4jPositionBean as value (**less memory**)
- Browscap4jString contains all the lines read from file as one concatenated string (**less memory**)
- Access to the data are done by sub string against the Browscap4jMap with position from Browscap4jPositionBean (**faster and less memory**)

The access time are 
- 20% faster than on version 1.0 on low memory
- 50% ore more memory consumption ess than on version 1.0 **after initialisation**

## Dependencies
To embed the classes from this project, subsequent dependencies must be embedded too:
- commons-io-2.4.jar (or higher) - download from [here](http://commons.apache.org/proper/commons-io/download_io.cgi)
- commons-lang3-3.4.jar (or higher) - download from [here](https://commons.apache.org/proper/commons-lang/download_lang.cgi)
- log4j-api-2.7.jar (or higher) - download from [here](https://logging.apache.org/log4j/2.0/download.html)
- log4j-core-2.7.jar (or higher) - download from [here](https://logging.apache.org/log4j/2.0/download.html)

Optionally, subsequent dependencies can be imported for testing:
- junit-4.12.jar (or higher) - download from [here](https://github.com/junit-team/junit4/wiki/Download-and-Install)

## Instructions
:exclamation: **Important: Browscap4jFileReader uses Java 8 (1.8)** :exclamation:

The **default** processing mechanism ist **parallel processing**, which uses **Java 8 (1.8) parallel streams**.

In order to get Browser capabilities, you need to first provide Browscap4jFileReader with the path to the csv file **and** finally, to fetch the data for a Browser User-Agent-String, it can be done by using the simple last two lines, like this:

(The result of the Browscap4jFileReader will be returned as a **Bean**.)
```java
Browscap4jDataBean fileReader = null;

try {
	fileReader = Browscap4jFileReader4.initBrowscap4jData(new File("./PATH_TO_BROWSCAP_CSV"));
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
Example for a possible output (2017-05-09):

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
commons-io-2.4.jar
commons-lang3-3.4.jar
log4j-api-2.7.jar
log4j-core-2.7.jar
net/tachtler/browscap4j/Browscap4jBean.java
net/tachtler/browscap4j/Browscap4jDataBean.java
net/tachtler/browscap4j/Browscap4jFileReader.java
net/tachtler/browscap4j/Browscap4jPositionBean.java
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

**Important: On startup, while initializing 1,536 MB are recommended !!! (-Xms512m -Xmx1536m / -Xms1536m -Xmx1536m)**

See the (average) results **COMING SOON**:

Calling the **method** ``net.tachtler.browscap4j.Browscap4jFileReader.initBrowscap4jMap`` **once** at startup:
```
[HH:MM:SS,ms ] : [Name of the method]
[??:??:??,???] : [net.tachtler.browscap4j.Browscap4jFileReader.initBrowscap4jData]
```
Calling the **method** ``net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities`` at runtime:
```
[HH:MM:SS,ms ] : [Name of the method]
[??:??:??,???] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
```
```
[??:??:??,???] : Average results of 50 calls of different User-Agent-Strings.
```

**Version** of the [browscap.csv](http://browscap.org/stream?q=BrowsCapCSV) file:
```
GJK_Browscap_Version: 6022, Tue, 28 Mar 2017 09:22:37 +0000
Lines - browscap.csv: 191,492
File size in Byte(s): 114.805.473 (114 MegaByte) 
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
