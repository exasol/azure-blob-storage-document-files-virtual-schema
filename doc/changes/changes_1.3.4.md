# Virtual Schema for Document Data in Files on Azure Blob Storage 1.3.4, released 2023-10-25

Code name: Fix CVE-2023-39410 in `org.apache.avro:avro`

## Summary

This release fixes CVE-2023-39410 in compile dependency `org.apache.avro:avro`.

The release also upgrades to [virtual-schema-common-document-files 7.3.6](https://github.com/exasol/virtual-schema-common-document-files/releases/tag/7.3.6). This new version validates that the given EDML mapping uses unique values for each `destinationTable` entry as duplicate values led to unexpected behavior.

## Security

* #38: Fixed CVE-2023-39410 in `org.apache.avro:avro`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:virtual-schema-common-document-files:7.3.4` to `7.3.5`

### Test Dependency Updates

* Updated `com.exasol:virtual-schema-common-document-files:7.3.4` to `7.3.5`
* Updated `org.jacoco:org.jacoco.agent:0.8.10` to `0.8.11`
* Updated `org.mockito:mockito-core:5.5.0` to `5.6.0`
* Updated `org.testcontainers:junit-jupiter:1.19.0` to `1.19.1`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:1.3.0` to `1.3.1`
* Updated `com.exasol:project-keeper-maven-plugin:2.9.12` to `2.9.14`
* Updated `org.apache.maven.plugins:maven-enforcer-plugin:3.4.0` to `3.4.1`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.16.0` to `2.16.1`
* Updated `org.jacoco:jacoco-maven-plugin:0.8.10` to `0.8.11`
* Updated `org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.1.2184` to `3.10.0.2594`
