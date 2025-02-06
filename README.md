# DAPI
[![](https://jitpack.io/v/desaxxx/DAPI.svg)](https://jitpack.io/#desaxxx/DAPI)

> HexUtil -> Using hex colors with patterns <#rrggbb>.\
Util -> Console log.\
ItemCreator -> Creating itemstack easily.\
GUIManager -> Creating GUI easily.

This is a shade api only.
## Adding to Maven
### Add repository and dependency first
```
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>

<dependency>
  <groupId>com.github.desaxxx</groupId>
  <artifactId>DAPI</artifactId>
  <version>LATEST.VERSION.HERE</version>
</dependency>
```

### Then relocate the shade
```
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
          <!-- Shade DAPI -->
          <relocation>
            <pattern>com.github.desaxxx.dapi</pattern>
            <shadedPattern>YOUR.UNIQUE.PACKAGE.PATH.HERE</shadedPattern>
          </relocation>
        </relocations>
      </configuration>
    </execution>
  </executions>
</plugin>
```
