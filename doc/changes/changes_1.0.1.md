# Virtual Schema for document data in files on Azure Blob Storage 1.0.1, released 2022-06-10

Code name: 1.0.1: Upgrade dependencies on 1.0.0

## Summary

This release upgrades dependencies and adapts the collection of regression tests results.

## Refactoring

* #9: Adapted to new regression test result database

## Dependency Updates

### Compile Dependency Updates

* Updated `com.azure:azure-storage-blob:12.14.3` to `12.17.1`
* Updated `com.exasol:virtual-schema-common-document-files:6.0.1` to `7.0.2`
* Updated `com.fasterxml.jackson.core:jackson-annotations:2.13.1` to `2.13.3`
* Updated `com.fasterxml.jackson.core:jackson-core:2.13.1` to `2.13.3`

### Test Dependency Updates

* Updated `com.exasol:exasol-test-setup-abstraction-java:0.2.2` to `0.3.2`
* Added `com.exasol:performance-test-recorder-java:0.1.0`
* Updated `com.exasol:test-db-builder-java:3.2.2` to `3.3.2`
* Updated `com.exasol:udf-debugging-java:0.5.0` to `0.6.1`
* Updated `com.exasol:virtual-schema-common-document-files:6.0.1` to `7.0.2`
* Removed `junit:junit:4.13.2`
* Updated `org.jacoco:org.jacoco.agent:0.8.5` to `0.8.8`
* Removed `org.jacoco:org.jacoco.core:0.8.7`
* Updated `org.mockito:mockito-core:4.1.0` to `4.6.1`
* Updated `org.testcontainers:junit-jupiter:1.16.2` to `1.17.2`
* Updated `org.testcontainers:localstack:1.16.2` to `1.17.2`
* Updated `org.yaml:snakeyaml:1.29` to `1.30`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:0.7.1` to `1.1.1`
* Updated `com.exasol:project-keeper-maven-plugin:2.0.0` to `2.4.6`
* Updated `org.apache.maven.plugins:maven-compiler-plugin:3.8.1` to `3.10.1`
* Updated `org.apache.maven.plugins:maven-dependency-plugin:3.2.0` to `3.3.0`
* Updated `org.apache.maven.plugins:maven-jar-plugin:3.2.0` to `3.2.2`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.8.1` to `2.10.0`
* Updated `org.jacoco:jacoco-maven-plugin:0.8.7` to `0.8.8`
* Added `org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.1.2184`
* Updated `org.sonatype.ossindex.maven:ossindex-maven-plugin:3.1.0` to `3.2.0`
