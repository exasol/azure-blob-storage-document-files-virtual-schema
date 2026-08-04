# Virtual Schema for Document Data in Files on Azure Blob Storage 3.1.0, released 2026-08-04

Code name: `TIMESTAMP` Precision Support

## Summary

This release adds support for `TIMESTAMP` precision. This means you can use `TIMESTAMP(0)` to `TIMESTAMP(9)` in your EDML mapping for all supported data types CSV, JSON and Parquet.

Please note that JSON files only support timestamps for number fields, interpreting the number as milliseconds since epoch. To enable this conversion, you need to set `notTimestampBehavior=CONVERT_OR_ABORT` for that column in the EDML definition file.

## Features

* #55: Added `TIMESTAMP` precision support

## Dependency Updates

### Compile Dependency Updates

* Updated `com.azure:azure-storage-blob:12.33.4` to `12.35.0`
* Updated `com.exasol:virtual-schema-common-document-files:9.0.0` to `9.1.0`
* Updated `org.slf4j:slf4j-jdk14:2.0.17` to `2.0.18`

### Test Dependency Updates

* Updated `com.exasol:exasol-test-setup-abstraction-java:2.1.11` to `3.0.0`
* Updated `com.exasol:hamcrest-resultset-matcher:1.7.2` to `1.7.3`
* Updated `com.exasol:performance-test-recorder-java:0.1.5` to `0.1.6`
* Updated `com.exasol:test-db-builder-java:4.0.0` to `4.0.2`
* Updated `com.exasol:udf-debugging-java:0.6.18` to `0.6.20`
* Updated `com.exasol:virtual-schema-common-document-files:9.0.0` to `9.1.0`
* Updated `org.jacoco:org.jacoco.agent:0.8.14` to `0.8.15`

### Plugin Dependency Updates

* Updated `com.exasol:artifact-reference-checker-maven-plugin:0.4.4` to `1.0.1`
* Updated `com.exasol:error-code-crawler-maven-plugin:2.0.7` to `2.1.0`
* Updated `com.exasol:project-keeper-maven-plugin:5.6.2` to `5.7.4`
* Removed `com.exasol:quality-summarizer-maven-plugin:0.2.1`
* Updated `org.apache.maven.plugins:maven-dependency-plugin:3.10.0` to `3.11.0`
* Updated `org.apache.maven.plugins:maven-enforcer-plugin:3.6.2` to `3.6.3`
* Updated `org.apache.maven.plugins:maven-failsafe-plugin:3.5.5` to `3.5.6`
* Updated `org.apache.maven.plugins:maven-site-plugin:3.21.0` to `3.22.0`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.5.5` to `3.5.6`
* Updated `org.jacoco:jacoco-maven-plugin:0.8.14` to `0.8.15`
* Updated `org.sonarsource.scanner.maven:sonar-maven-plugin:5.5.0.6356` to `5.7.0.6970`
* Added `org.spdx:spdx-maven-plugin:1.0.4`
