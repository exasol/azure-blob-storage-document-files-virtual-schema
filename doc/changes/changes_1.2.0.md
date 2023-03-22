# Virtual Schema for Document Data in Files on Azure Blob Storage 1.2.0, released 2023-03-22

Code name: Auto-inference for Parquet

## Summary

This release adds automatic schema inference for Parquet files. This means that you don't need to specify a `mapping` element in the EDML definition. Instead VSBFS will automatically detect the mapping from the Parquet files. See the [EDML user guide](https://github.com/exasol/virtual-schema-common-document/blob/main/doc/user_guide/edml_user_guide.md#automatic-mapping-inference) for details.

The release also refactored class `LocalAbsTestSetup`.

## Features

* #22: Added auto-inference for Parquet files

## Refactoring

* #20: Refactored class `LocalAbsTestSetup`.

## Dependency Updates

### Compile Dependency Updates

* Updated `com.azure:azure-storage-blob:12.20.2` to `12.21.1`
* Updated `com.exasol:error-reporting-java:1.0.0` to `1.0.1`
* Updated `com.exasol:virtual-schema-common-document-files:7.1.4` to `7.2.0`
* Removed `com.fasterxml.jackson.core:jackson-annotations:2.14.2`
* Removed `com.fasterxml.jackson.core:jackson-core:2.14.2`
* Removed `com.fasterxml.jackson.core:jackson-databind:2.14.2`

### Test Dependency Updates

* Added `com.exasol:exasol-testcontainers:6.5.1`
* Updated `com.exasol:udf-debugging-java:0.6.7` to `0.6.8`
* Updated `com.exasol:virtual-schema-common-document-files:7.1.4` to `7.2.0`
* Updated `org.mockito:mockito-core:5.1.1` to `5.2.0`
* Removed `org.yaml:snakeyaml:1.33`

### Plugin Dependency Updates

* Updated `com.exasol:project-keeper-maven-plugin:2.9.3` to `2.9.6`
* Updated `org.apache.maven.plugins:maven-assembly-plugin:3.4.2` to `3.5.0`
* Updated `org.apache.maven.plugins:maven-enforcer-plugin:3.1.0` to `3.2.1`
* Removed `org.projectlombok:lombok-maven-plugin:1.18.20.0`
