# DAPI (Desa API)
This API is being designed by me and for my plugins. Still, you can also use it on your plugins.

## Features
- **Menu Manager**: Easily create and manage your Minecraft GUIs with this class. (Chest menus, and soon Anvil menu)
> [!IMPORTANT]
> In order to register menu events. You need to use `DAPI.registerMenuListener()` on your plugin start.
- **HexUtil**: Translate RGB colors on your string with pattern <#RRGGBB> (Planning to add other patterns)
- **ItemCreator**: Easily create ItemStack with this builder, it has multiple methods to apply data to your created itemstack.
- **ChannelType & ChannelMessages**: Easily send messages to player/console on which channel you want — CHAT, ACTION_BAR, TITLE, BOSS_BAR...
- **DObjects**, such as DMaterial, DSound, DEntityType to support version compatibility between 1.16.1 - 1.21.x. (Not all Minecraft objects are present, see [them](https://github.com/desaxxx/DAPI/tree/main/api/src/main/java/org/nandayo/dapi/object))
- **Util**: Offers many methods such as log() to log any message to console, tell() to send basic message to players, PREFIX to set up prefix for the DAPI to use on log() and tell() methods, generateRandomString() to do what is literally says.
- *And other small classes needs you to figure out?*

## Adding it to your project

*Latest release tag*: [![](https://jitpack.io/v/desaxxx/DAPI.svg)](https://jitpack.io/#desaxxx/DAPI)

### Maven
```
<repository>
  <id>jitpack.io</id>
  <url>https://jitpack.io</url>
</repository>

<dependency>
  <groupId>com.github.desaxxx</groupId>
  <artifactId>DAPI</artifactId>
  <version>LATEST.RELEASE.TAG</version>
</dependency>
 ```
### Gradle
```
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
  }
}

dependencies {
  implementation 'com.github.desaxxx:DAPI:LATEST.RELEASE.TAG'
}
```
### Shading (Necessary)
```
<build>
  <defaultGoal>clean install</defaultGoal>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-shade-plugin</artifactId>
      <version>3.6.0</version>
      <executions>
        <execution>
          <phase>package</phase>
          <goals>
            <goal>shade</goal>
          </goals>
          <configuration>
            <relocations>
              <relocation>
                <pattern>com.github.desaxxx.DAPI</pattern>
                <shadedPattern>PATH.TO.YOUR.PACKAGE</shadedPattern>
              </relocation>
            </relocations>
          </configuration>
        </execution>
      </executions>
    </plugin>
  </plugins>
</build>
```
