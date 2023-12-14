# Virtual Schema for Document Data in Files on Azure Blob Storage 1.3.5, released 2023-11-22

Code name: Fix CVE-2023-34062 in `io.projectreactor.netty:reactor-netty-http`

## Summary

This release fixes CVE-2023-34062 (CWE-22: Improper Limitation of a Pathname to a Restricted Directory ('Path Traversal') (7.5)) in compile dependency `io.projectreactor.netty:reactor-netty-http`.

## Security

* #42: Fix CVE-2023-34062 in `io.projectreactor.netty:reactor-netty-http`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.azure:azure-storage-blob:12.24.0` to `12.25.0`
* Updated `com.exasol:virtual-schema-common-document-files:7.3.5` to `7.3.6`
* Added `io.projectreactor.netty:reactor-netty-http:1.0.39`

### Test Dependency Updates

* Updated `com.exasol:exasol-test-setup-abstraction-java:2.0.4` to `2.1.0`
* Updated `com.exasol:hamcrest-resultset-matcher:1.6.1` to `1.6.3`
* Updated `com.exasol:test-db-builder-java:3.5.1` to `3.5.2`
* Updated `com.exasol:virtual-schema-common-document-files:7.3.5` to `7.3.6`
* Updated `org.junit.jupiter:junit-jupiter-params:5.10.0` to `5.10.1`
* Updated `org.mockito:mockito-core:5.6.0` to `5.7.0`
* Updated `org.testcontainers:junit-jupiter:1.19.1` to `1.19.3`

### Plugin Dependency Updates

* Updated `com.exasol:project-keeper-maven-plugin:2.9.14` to `2.9.16`
* Updated `org.apache.maven.plugins:maven-dependency-plugin:3.6.0` to `3.6.1`
* Updated `org.apache.maven.plugins:maven-failsafe-plugin:3.1.2` to `3.2.2`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.1.2` to `3.2.2`
