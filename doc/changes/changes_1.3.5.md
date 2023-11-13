# Virtual Schema for Document Data in Files on Azure Blob Storage 1.3.5, released 2023-??-??

Code name: Test with Exasol v8

## Summary

This release adds integration tests with Exasol DB version 8.

## Features

* #40: Add tests with Exasol v8

## Dependency Updates

### Compile Dependency Updates

* Updated `com.azure:azure-storage-blob:12.24.0` to `12.25.0`
* Updated `com.exasol:virtual-schema-common-document-files:7.3.5` to `7.3.6`

### Test Dependency Updates

* Updated `com.exasol:exasol-test-setup-abstraction-java:2.0.4` to `2.1.0`
* Updated `com.exasol:hamcrest-resultset-matcher:1.6.1` to `1.6.2`
* Updated `com.exasol:virtual-schema-common-document-files:7.3.5` to `7.3.6`
* Updated `org.junit.jupiter:junit-jupiter-params:5.10.0` to `5.10.1`
* Updated `org.mockito:mockito-core:5.6.0` to `5.7.0`

### Plugin Dependency Updates

* Updated `com.exasol:project-keeper-maven-plugin:2.9.14` to `2.9.16`
* Updated `org.apache.maven.plugins:maven-dependency-plugin:3.6.0` to `3.6.1`
* Updated `org.apache.maven.plugins:maven-failsafe-plugin:3.1.2` to `3.2.2`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.1.2` to `3.2.2`
