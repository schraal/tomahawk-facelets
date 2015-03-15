# tomahawk-facelets
Facelets support for Apache MyFaces Tomahawk

*NOTE:* Facelets support has been integrated into Tomahawk as of version 1.1.7. We advise you to upgrade to at least this version of Tomahawk. This library will no longer be actively maintained. However if someone is still using it and finds a bug we will fix it, when a patch is submitted.

*NEW:* Maven repository available, see the HowToUse section.

This library is meant to provide Facelets support for the MyFaces Tomahawk components (core and sandbox), so you can use the great Tomahawk components with Facelets right now!

This project has been created gathering information from the MyFaces wiki and other sources from the Internet.

Check the HowToUse section, which contains the simple instructions to use this compatibility library in your projects.

Feel free to help to expand the support! If you want to help to maintain the project, don't hesitate to ask for membership and you will be added.

## How to Use

Using this library is the simplest way to provide Facelets support to the MyFaces Tomahawk component library.

To use it, just put the tomahawk-facelets.jar into the classpath (e.g. yourApp/WEB-INF/lib) 

## Maven

This library is available via a maven repository. If you want to use it in your maven builds, add the following repository to your pom.xml:

  <repositories>
    <repository>
      <releases>
        <enabled>true</enabled>
        <updatePolicy>always</updatePolicy>
        <checksumPolicy>warn</checksumPolicy>
      </releases>
      <snapshots>
        <enabled>false</enabled>
        <updatePolicy>never</updatePolicy>
        <checksumPolicy>fail</checksumPolicy>
      </snapshots>
      <id>Tomahawk-Facelets</id>
      <name>Tomahawk-Facelets releases</name>
      <url>http://tomahawk-facelets.googlecode.com/svn/maven2/repository</url>
      <layout>default</layout>
    </repository>
  </repositories>

Then, to use it in your builds, just include this dependency in your POMs:

<dependency>
    <groupId>com.google.code.tomahawk</groupId>
    <artifactId>tomahawk-facelets</artifactId>
    <version>1.1.6.3</version>
</dependency>
