# Virtual Schema for Document Data in Files on Azure Blob Storage 1.3.0, released 2023-04-28

Code name: Auto-inference for CSV

## Summary

This release adds more mapping types for CSV files. Before you could only use mapping `toVarcharMapping`, but now you can also use `toDecimalMapping`, `toDoubleMapping`, `toDateMapping` and `toTimestampMapping`.

The release also adds automatic schema inference for CSV files. This means that you don't need to specify a `mapping` element in the EDML definition. Instead the virtual schema will automatically detect the mapping from the CSV file as well as the presence of a header line.

See the [EDML user guide](https://github.com/exasol/virtual-schema-common-document/blob/main/doc/user_guide/edml_user_guide.md#automatic-mapping-inference) for details.

## Features

* #29: Added automatic schema inference for CSV files

## Dependency Updates

### Compile Dependency Updates

* Updated `com.azure:azure-storage-blob:12.21.1` to `12.22.0`
* Updated `com.exasol:virtual-schema-common-document-files:7.2.0` to `7.3.0`

### Test Dependency Updates

* Updated `com.exasol:exasol-test-setup-abstraction-java:2.0.0` to `2.0.1`
* Removed `com.exasol:exasol-testcontainers:6.5.1`
* Updated `com.exasol:hamcrest-resultset-matcher:1.5.2` to `1.6.0`
* Updated `com.exasol:virtual-schema-common-document-files:7.2.0` to `7.3.0`
* Updated `org.jacoco:org.jacoco.agent:0.8.8` to `0.8.9`
* Removed `org.junit.jupiter:junit-jupiter-engine:5.9.2`
* Updated `org.junit.jupiter:junit-jupiter-params:5.9.2` to `5.9.3`
* Updated `org.mockito:mockito-core:5.2.0` to `5.3.1`
* Updated `org.testcontainers:junit-jupiter:1.17.6` to `1.18.0`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:1.2.2` to `1.2.3`
* Updated `com.exasol:project-keeper-maven-plugin:2.9.6` to `2.9.7`
* Updated `org.apache.maven.plugins:maven-compiler-plugin:3.10.1` to `3.11.0`
* Updated `org.apache.maven.plugins:maven-enforcer-plugin:3.2.1` to `3.3.0`
* Updated `org.apache.maven.plugins:maven-failsafe-plugin:3.0.0-M8` to `3.0.0`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M8` to `3.0.0`
* Added `org.basepom.maven:duplicate-finder-maven-plugin:1.5.1`
* Updated `org.codehaus.mojo:flatten-maven-plugin:1.3.0` to `1.4.1`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.14.2` to `2.15.0`
* Updated `org.jacoco:jacoco-maven-plugin:0.8.8` to `0.8.9`
