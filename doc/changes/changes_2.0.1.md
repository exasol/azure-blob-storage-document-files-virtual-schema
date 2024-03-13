# Virtual Schema for Document Data in Files on Azure Blob Storage 2.0.1, released 2024-03-13

Code name: Fix vulnerabilities CVE-2023-52428, CVE-2024-26308 and CVE-2024-25710 in compile dependencies

## Summary

This release vulnerabilities in the following compile dependencies:
* `com.nimbusds:nimbus-jose-jwt:jar:9.8.1:compile`:
  * CVE-2023-52428
* `org.apache.commons:commons-compress:jar:1.24.0:compile`:
  * CVE-2024-26308
  * CVE-2024-25710

**Excluded Vulnerability** We accept vulnerability CVE-2017-10355 (CWE-833: Deadlock) in test dependency `xerces:xercesImpl:jar:2.12.2` as we assume that we only connect to the known endpoint ExaOperations.

## Security

* #45: Fixed CVE-2023-52428 in `com.nimbusds:nimbus-jose-jwt:jar:9.8.1:compile`
* #46: Fixed CVE-2024-25710 in `org.apache.commons:commons-compress:jar:1.24.0:compile`
* #47: Fixed CVE-2024-26308 in `org.apache.commons:commons-compress:jar:1.24.0:compile`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.azure:azure-storage-blob:12.25.1` to `12.25.2`
* Updated `com.exasol:virtual-schema-common-document-files:8.0.0` to `8.0.2`
* Updated `org.slf4j:slf4j-jdk14:2.0.9` to `2.0.12`

### Test Dependency Updates

* Updated `com.exasol:exasol-test-setup-abstraction-java:2.1.0` to `2.1.1`
* Updated `com.exasol:hamcrest-resultset-matcher:1.6.3` to `1.6.5`
* Updated `com.exasol:test-db-builder-java:3.5.3` to `3.5.4`
* Updated `com.exasol:udf-debugging-java:0.6.11` to `0.6.12`
* Updated `com.exasol:virtual-schema-common-document-files:8.0.0` to `8.0.2`
* Updated `org.junit.jupiter:junit-jupiter-params:5.10.1` to `5.10.2`
* Updated `org.mockito:mockito-core:5.8.0` to `5.11.0`
* Updated `org.testcontainers:junit-jupiter:1.19.3` to `1.19.7`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:1.3.1` to `2.0.1`
* Updated `com.exasol:project-keeper-maven-plugin:2.9.17` to `4.2.0`
* Updated `org.apache.maven.plugins:maven-compiler-plugin:3.11.0` to `3.12.1`
* Updated `org.apache.maven.plugins:maven-failsafe-plugin:3.2.2` to `3.2.5`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.2.2` to `3.2.5`
* Added `org.apache.maven.plugins:maven-toolchains-plugin:3.1.0`
* Updated `org.codehaus.mojo:flatten-maven-plugin:1.5.0` to `1.6.0`
