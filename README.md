# DAPI
[![](https://jitpack.io/v/desaxxx/DAPI.svg)](https://jitpack.io/#desaxxx/DAPI)

> DMaterial — Materials from 1.16.1 to 1.21.4 (**version compatibility**)\
> DParticle — Particles from 1.16.1 to 1.21.4 (**version compatibility**)\
> DPotionEffectType — PotionEffectTypes from 1.16.1 to 1.21.4 (**version compatibility**)\
> DEntityType — EntityTypes from 1.16.1 to 1.21.4 (**version compatibility**)\
> HexUtil -> Hex colors with patterns <#rrggbb>.\
> Util -> Console log with prefix.\
> ItemCreator -> Building itemstack easily.\
> GUIManager -> Creating GUI easily.

## Adding GUIManager Listener
If you are going to use GUIManager, you have to register api events at **onEnable()**
```
DAPI dapi = new DAPI(this);
dapi.registerMenuListener();
```
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
