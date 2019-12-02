# My project's README

# Project name : OLA Android application automation


### Running tests on Web Browser


## Pre-Requisites

- Download basic required dependencies from (https://mvnrepository.com )
- Dependencies as per the implementation in project :

# Selenium
# appium
# android-sdk
# Testng
# Extent Report
# org.apache.poi
# log4j
# surefire plugin




 Example to download the jar

- Download Selenium jar  from  (https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)

#Drivers Used :
     chrome driver for mac



## Pre-Requisites

### Running tests on Android Phones


#### Setting up Android Debug Bridge (ADB) tools


- Download Android SDK from [here](https://dl.google.com/android/android-sdk_r24.4.1-macosx.zip) for Mac

- Extract the archive
From terminal, run the following command

   ```
     $ cd <extracted-folder>
     $ tools/android
   ```

- Click on - Android SDK Tools, Android SDK Platform-tools, Android Build-tool → Install Packages


- Create soft link (to maintain unanimity)

```$ sudo ln -s <extracted-folder> /opt/android-sdk```


#### Setting up Appium


Run the following commands on terminal

```
$ xcode-select --install

$ /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"

$ brew update && brew upgrade

$ brew install node

$ npm -g install appium

$ npm -g install wd
```

##### Create soft link (optional: to maintain unanimity)

```
$ sudo ln -s /usr/local/bin /opt/homebrew

$ sudo ln -s `/usr/libexec/java_home` /opt/java
```
```

### Versions of my local installation

* selenium - 3.141.59
* java - 1.8.0_152
* testng - 7.0.0
* Apache Maven 3.5.4



