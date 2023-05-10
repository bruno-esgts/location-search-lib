# Location Search API
**Library that searches for locations on OpenStreetMap**

## Getting started

### Importing the library
In order to use this library you first need to add the maven dependency
on your project.

You can do it by adding this in your projects `pom.xml`
```xml
<dependency>
  <groupId>pt.brunojesus</groupId>
  <artifactId>location-search-api</artifactId>
  <version>1.0</version>
</dependency>
```

The dependency listed above is not on maven central, so you need to make
sure you add the repository to your project's `pom.xml` as well.
```xml
    <repositories>
        <repository>
            <id>mvn-brunojesus</id>
            <name>Bruno Jesus MVN Repo</name>
            <url>https://mvn.brunojesus.pt/releases</url>
        </repository>
    </repositories>
```

### Code example
The following example searches for a place called **CNEMA, Santarém**.

```java
package pt.app;

import pt.brunojesus.locationsearch.api.OpenStreetMap;
import pt.brunojesus.locationsearch.exception.LocationSearchException;

public class App {

    public static void main(String[] args) throws LocationSearchException {
        OpenStreetMap openStreetMap = new OpenStreetMap();
        openStreetMap.search("CNEMA, Santarém")
                .forEach(System.out::println);
    }
}
```

It will print the string representation of the `OpenStreetMap` location object, which you can consult by dowloading
the JavaDoc on the **Releases** page.

```text
OpenStreetMapLocation(placeId=142156326, licence=Data © OpenStreetMap contributors, ODbL 1.0. https://osm.org/copyright, osmType=way, osmId=157265885, boundingBox=[39.2155391, 39.2210727, -8.702667, -8.6913489], latitute=39.2182939, longitude=-8.696628110447445, displayName=Centro Nacional de Exposições e Mercados Agrícolas, Rua O, Marvila, Cidade de Santarém, Santarém, 2000-205, Portugal, placeRank=30, category=amenity, type=exhibition_centre, importance=0.11010000000000002, icon=null)
```