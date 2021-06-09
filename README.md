# maven-study
- project
  - 프로젝트 기본 정보
  - modelVersion
  - groupID
  - artifactId
  - version
  - packaging
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.5.0</version>
    <relativePath/> <!-- lookup parent from repository -->
  </parent>
  <groupId>maven</groupId>
  <artifactId>study</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <name>study</name>
  <description>Demo project for Spring Boot</description>
</project>
```    
- properties
    - maven 내부에서 반복적으로 사용될 상수 값을 정의할 때 사용
```xml
<properties>
    <java-version>1.8</java-version>
</properties>
```    
- Dependencies(의존성 라이브러리 정보)
   - project 태그 바로 하위
   - 의존성 라이브러리 정보를 포함함
   - 최소 groupId, artifactId, version 정보가 필요함
   - dependencies 색션 아래 새부 `dependency'가 기술됨
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```    
- 빌드 정보 
    - project 태그 바로 하위
    - plugins : 빌드에서 사용할 플러그인
    - 디렉토리 구조
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
                <excludes>
                    <exclude>
                        <groupId>org.projectlombok</groupId>
                        <artifactId>lombok</artifactId>
                    </exclude>
                </excludes>
            </configuration>
        </plugin>
    </plugins>
</build>
```
- Repository
    - 의존성을 다운로드 받을 위치의 repository
    - 기술되지 않을 시 기본적인 위치
    - http://repo.maven.apache.org/maven2
    - 다수의 <repository> 기술 가능
    - 회사 내부의 repository를 기술 하기도 한다.
    - nexus
    - artifactory를 이용
```xml
<repositories>
    <repository>
        <id>spring-snapshot</id>
        <name>Spring Snapshot Repository</name>
        <url>https://repo.spring.io/snapshot</url>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
        <releases>
            <enabled>false</enabled>
        </releases>
    </repository>
</repositories>
```  
- Plugin Repository
  - maven plugin을 다운로드 받을수 있는 저장소 위치를 기술
```xml
<pluginRepositories>
    <pluginRepository>
        <id>acme corp</id>
        <name>Acme Internal Corporate Repository</name>
        <url>http://acmecorp.com/plugins</url>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
        <releases>
            <enabled>false</enabled>
        </releases>
    </pluginRepository>
</pluginRepositories>
```
- deploy 배포
  - deploy goal을 실행했을 시 배포되는 위치를 기술함
  - url 항목에는 일반적으로 회사 내부에 설치한 repository url이 기술된다
```xml
<distributionManagement>
    <repository>
        <id>releases-repo</id>
        <name>Releases Repository</name>
        <url>일반적인 회사 내부 repository url</url>
    </repository>
    <snapshotRepository>
        <id>snapshots-repo</id>
        <name>Snapshots Repository</name>
        <url>일반적인 회사 내부 repository url</url>
    </snapshotRepository>
</distributionManagement>
```  