# Virtual Schema for document data in files on Azure Blob Storage 1.1.3, released 2023-02-07

Code name: Reviewed and fixed vulnerabilities, updated dependencies and refactored integration test setup class.

## Summary

Reviewed and fixed vulnerabilities. 
Refactored IntegrationTestSetup to use system properties.
## Bugfixes / Vulnerabilities


* Fixed vulnerabilities
    * [CVE-2021-37533](https://ossindex.sonatype.org/component/pkg:maven/commons-net/commons-net@3.6?utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1) - Overrode transitive test dependency to fix vulnerability.
* Ignored vulnerabilities
    * [sonatype-2022-6438](https://ossindex.sonatype.org/vulnerability/sonatype-2022-6438) - Exploit requires write access to the source code repository and attempts to inject malicious code will be detected during regular code reviews.
    * [CVE-2020-36641](https://nvd.nist.gov/vuln/detail/CVE-2020-36641) - Vulnerability is rated as a false positive since CVE-2020-36641 is reported to be fixed in aXMLRPC 1.12.1, while ETAJ uses version 1.13.0.
    * [CVE-2022-1471](https://ossindex.sonatype.org/vulnerability/CVE-2022-38750) - Dependency is used by the test framework
    * [CVE-2020-36641](https://ossindex.sonatype.org/vulnerability/CVE-2022-45688) - Exploit requires access to manipulate hosted JSON files.

## Refactoring

*#15 : Use system properties to set DEBUG_ADDRESS and LOG_LEVEL.

## Dependency Updates

### Compile Dependency Updates

* Updated `com.azure:azure-storage-blob:12.20.0` to `12.20.2`
* Updated `com.exasol:virtual-schema-common-document-files:7.1.2` to `7.1.4`
* Updated `com.fasterxml.jackson.core:jackson-annotations:2.13.4` to `2.14.2`
* Updated `com.fasterxml.jackson.core:jackson-core:2.13.4` to `2.14.2`
* Updated `com.fasterxml.jackson.core:jackson-databind:2.13.4.2` to `2.14.2`

### Test Dependency Updates

* Updated `com.exasol:exasol-test-setup-abstraction-java:0.3.2` to `2.0.0`
* Updated `com.exasol:test-db-builder-java:3.4.1` to `3.4.2`
* Updated `com.exasol:udf-debugging-java:0.6.4` to `0.6.7`
* Updated `com.exasol:virtual-schema-common-document-files:7.1.2` to `7.1.4`
* Added `commons-net:commons-net:3.9.0`
* Updated `org.junit.jupiter:junit-jupiter-engine:5.9.1` to `5.9.2`
* Updated `org.junit.jupiter:junit-jupiter-params:5.9.1` to `5.9.2`
* Updated `org.mockito:mockito-core:4.8.1` to `5.1.1`
* Updated `org.testcontainers:junit-jupiter:1.17.5` to `1.17.6`

### Plugin Dependency Updates

* Updated `com.exasol:artifact-reference-checker-maven-plugin:0.4.0` to `0.4.2`
* Updated `com.exasol:error-code-crawler-maven-plugin:1.1.2` to `1.2.2`
* Updated `com.exasol:project-keeper-maven-plugin:2.8.0` to `2.9.3`
* Updated `io.github.zlika:reproducible-build-maven-plugin:0.15` to `0.16`
* Updated `org.apache.maven.plugins:maven-assembly-plugin:3.3.0` to `3.4.2`
* Updated `org.apache.maven.plugins:maven-dependency-plugin:3.3.0` to `3.5.0`
* Updated `org.apache.maven.plugins:maven-failsafe-plugin:3.0.0-M5` to `3.0.0-M8`
* Updated `org.apache.maven.plugins:maven-jar-plugin:3.2.2` to `3.3.0`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M5` to `3.0.0-M8`
* Updated `org.codehaus.mojo:flatten-maven-plugin:1.2.7` to `1.3.0`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.10.0` to `2.14.2`
