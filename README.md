# browscap4jFileReader
A simple to use Java code classes, for embedding into your own projects, using the [Browser Capabilities Project](http://browscap.org/) **browscap.csv** file, which can be download from [here](http://browscap.org/stream?q=BrowsCapCSV)

Which fields from browscap.csv are **actual**, **mostly unmaintained** or **deprecated**, can determined from following link:
[Resource: User Agents Database](https://github.com/browscap/browscap/wiki/Resource%3A-User-Agents-Database)

## Changes to Version 1.1
**2018-09-21** - **BugFix** - The result related to the UserAgentString was not determined correctly.

Main changes are:
- Extension of the data determination based on the UserAgentString. It is **no longer the first hit** from the file ```browscap.csv``` that is determined, but the **best hit is now determined from a list of RegEx hits**, from which **the hit with the longest key field length** is then **used as the best hit**.

The access time are 
- 10% slower than on version 1.1 (But what is a timing value, if the result is wrong?)

## Changes to Version 1.0
**Complete redesign of the Browscap4jFileReader.**

Main changes are:
- Reading the file without using opencsv.jar any more. Using instead Apache commons-io (**faster and less memory**)
- Reading the file and generate a Browscap4jDataBean with Browscap4jMap and Browscap4jString instead of Browscap4jMap only (**less memory**)
- Browscap4jMap has the compiled regular expression pattern as key and only the Browscap4jPositionBean as value (**less memory**)
- Browscap4jString contains all the lines read from file as one concatenated string (**less memory**)
- Access to the data are done by "substring" against the Browscap4jMap with position from Browscap4jPositionBean (**faster and less memory**)

The access time are 
- 10%-20% faster than on version 1.0 on **low memory**
- 50% or more memory consumption less than on version 1.0 **after initialisation**

## Dependencies
To embed the classes from this project, subsequent dependencies must be embedded too:
- commons-io-2.5.jar (or higher) - download from [here](http://commons.apache.org/proper/commons-io/download_io.cgi)
- commons-lang3-3.6.jar (or higher) - download from [here](https://commons.apache.org/proper/commons-lang/download_lang.cgi)
- log4j-api-2.10.0.jar (or higher) - download from [here](https://logging.apache.org/log4j/2.0/download.html)
- log4j-core-2.10.0.jar (or higher) - download from [here](https://logging.apache.org/log4j/2.0/download.html)

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
	fileReader = Browscap4jFileReader.initBrowscap4jData(new File("./PATH_TO_BROWSCAP_CSV"));
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
commons-io-2.5.jar
commons-lang3-3.6.jar
log4j-api-2.10.0.jar
log4j-core-2.10.0.jar
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
- Special JAVA start paramater: **-Xms512m -Xmx1536m**

:point_right: **Important: On startup 1,536 MB are recommended !!! (-Xms512m -Xmx1536m or -Xms1536m -Xmx1536m)**

![Browscap4jFileReader-JUnit-Test](https://github.com/tachtler/browscap4jFileReader/blob/master/doc/Browscap4jFileReader-2017-05-09-Eclipse-JUnit-Test.png)

See the (average) results:

Calling the **method** ``net.tachtler.browscap4j.Browscap4jFileReader.initBrowscap4jMap`` **once** at startup:
```
[HH:MM:SS,ms ] : [Name of the method]
[00:00:06,113] : [net.tachtler.browscap4j.Browscap4jFileReader.initBrowscap4jData]
```
Calling the **method** ``net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities`` at runtime:
```
[HH:MM:SS,ms ] : [Name of the method]
[00:00:00,103] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,094] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,108] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,098] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,141] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,157] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,065] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,545] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,058] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,142] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,006] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,107] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,073] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,044] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,037] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,063] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,073] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,063] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,080] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,086] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,019] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,083] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,004] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,012] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,001] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,002] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,002] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,044] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,001] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,057] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,130] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,147] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,120] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,083] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,013] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,064] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,016] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,015] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,006] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,076] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,069] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,001] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,079] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,081] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,002] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,081] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,033] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,000] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,040] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
[00:00:00,035] : [net.tachtler.browscap4j.Browscap4jFileReader.determineBrowscap4jCapabilities]
```
```
[00:00:00,063] : Average results of 50 calls of different User-Agent-Strings.
```

## Apache benchmark Tomcat 
Performance benchmark was also on **very old PC** using the **development environment** [Eclipse](http://www.eclipse.org/) **with** [Tomcat 7.0.69](http://tomcat.apache.org/) **server**:
- Processor: 1 (x64) Intel(R) Core(TM)2 Quad CPU Q6600 @ 2.40GHz, 3195 MHz, 4 Core(s), 4 logical Processor(s)
- Installed physical RAM: 4 GByte (1066 MHz)
- HDD: WesternDigital WDC WD1500ADFD (10.000 rpm)
- Start under **development environment** [Eclipse](http://www.eclipse.org/) using [Tomcat 7.0.69](http://tomcat.apache.org/)
- Special JAVA start paramater: **-Xms512m -Xmx1536m**

![Browscap4jFileReader-Tomcat-Benchmark](https://github.com/tachtler/browscap4jFileReader/blob/master/doc/Browscap4jFileReader-2017-05-10-Eclipse-Tomcat-7.0.69-Benchmark.png)

#### Apache bechmark Time: **06:44:00** (50 requests |  1 concurrent):
```
ab -n 50 -c 1 http://127.0.0.1:8000/browscap4jFileReader.action
This is ApacheBench, Version 2.3 <$Revision: 1757674 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking 127.0.0.1 (be patient).....done


Server Software:        Apache-Coyote/1.1
Server Hostname:        127.0.0.1
Server Port:            8000

Document Path:          /browscap4jFileReader.action
Document Length:        13929 bytes

Concurrency Level:      1
Time taken for tests:   1.591 seconds
Complete requests:      50
Failed requests:        0
Total transferred:      707250 bytes
HTML transferred:       696450 bytes
Requests per second:    31.42 [#/sec] (mean)
Time per request:       31.822 [ms] (mean)
Time per request:       31.822 [ms] (mean, across all concurrent requests)
Transfer rate:          434.09 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.4      0       1
Processing:    24   31   8.3     29      67
Waiting:       23   31   8.2     28      66
Total:         24   32   8.3     30      67

Percentage of the requests served within a certain time (ms)
  50%     30
  66%     31
  75%     33
  80%     37
  90%     44
  95%     48
  98%     67
  99%     67
 100%     67 (longest request)
```
#### Apache bechmark Time: **06:44:15** (50 requests | 10 concurrent):
```
ab -n 50 -c 10 http://127.0.0.1:8000/browscap4jFileReader.action
This is ApacheBench, Version 2.3 <$Revision: 1757674 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking 127.0.0.1 (be patient).....done


Server Software:        Apache-Coyote/1.1
Server Hostname:        127.0.0.1
Server Port:            8000

Document Path:          /browscap4jFileReader.action
Document Length:        13929 bytes

Concurrency Level:      10
Time taken for tests:   0.822 seconds
Complete requests:      50
Failed requests:        0
Total transferred:      707250 bytes
HTML transferred:       696450 bytes
Requests per second:    60.82 [#/sec] (mean)
Time per request:       164.410 [ms] (mean)
Time per request:       16.441 [ms] (mean, across all concurrent requests)
Transfer rate:          840.19 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.4      0       1
Processing:    26  157  95.2    129     446
Waiting:       25  152  95.7    124     446
Total:         26  157  95.3    129     446

Percentage of the requests served within a certain time (ms)
  50%    129
  66%    207
  75%    221
  80%    244
  90%    273
  95%    327
  98%    446
  99%    446
 100%    446 (longest request)
```
#### Apache bechmark Time: **06:44:30** (50 requests | 50 concurrent):
```
ab -n 50 -c 50 http://127.0.0.1:8000/browscap4jFileReader.action
This is ApacheBench, Version 2.3 <$Revision: 1757674 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking 127.0.0.1 (be patient).....done


Server Software:        Apache-Coyote/1.1
Server Hostname:        127.0.0.1
Server Port:            8000

Document Path:          /browscap4jFileReader.action
Document Length:        13929 bytes

Concurrency Level:      50
Time taken for tests:   0.735 seconds
Complete requests:      50
Failed requests:        0
Total transferred:      707250 bytes
HTML transferred:       696450 bytes
Requests per second:    68.02 [#/sec] (mean)
Time per request:       735.044 [ms] (mean)
Time per request:       14.701 [ms] (mean, across all concurrent requests)
Transfer rate:          939.64 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    1   1.5      0      10
Processing:    81  384 166.4    386     629
Waiting:       81  372 177.6    384     628
Total:         81  385 165.8    386     629

Percentage of the requests served within a certain time (ms)
  50%    386
  66%    460
  75%    557
  80%    584
  90%    606
  95%    617
  98%    629
  99%    629
 100%    629 (longest request)
```

## Used browscap.csv file for the tests above
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
