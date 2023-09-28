# Virtual Schema for Document Data in Files on Azure Blob Storage 1.3.3, released 2023-09-28

Code name: Fix vulnerabilities in dependencies

## Summary

This release fixes the following vulnerabilities in dependencies:

* `org.apache.commons:commons-compress:compile`: CVE-2023-42503 CWE-20: Improper Input Validation (5.5)
* `org.xerial.snappy:snappy-java:compile`: CVE-2023-43642 CWE-770: Allocation of Resources Without Limits or Throttling (7.5)
* `org.eclipse.jgit:org.eclipse.jgit:test`: CVE-2023-4759: CWE-178: Improper Handling of Case Sensitivity (8.8)

**Known issue:** Transitive dependency `io.netty:netty-handler` of `com.azure:azure-storage-blob` contains vulnerability CVE-2023-4586 (CWE-300: Channel Accessible by Non-Endpoint ('Man-in-the-Middle') (6.5)). We assume that the Azure client's usage of `netty-handler` is not affected by the vulnerability.

## Security

* #36: Fix vulnerabilities in dependencies

## Dependency Updates

### Compile Dependency Updates

* Updated `com.azure:azure-storage-blob:12.22.3` to `12.24.0`
* Updated `com.exasol:virtual-schema-common-document-files:7.3.3` to `7.3.4`
* Updated `org.slf4j:slf4j-jdk14:2.0.7` to `2.0.9`

### Test Dependency Updates

* Updated `com.exasol:exasol-test-setup-abstraction-java:2.0.2` to `2.0.4`
* Updated `com.exasol:hamcrest-resultset-matcher:1.6.0` to `1.6.1`
* Updated `com.exasol:performance-test-recorder-java:0.1.2` to `0.1.3`
* Updated `com.exasol:test-db-builder-java:3.4.2` to `3.5.1`
* Updated `com.exasol:udf-debugging-java:0.6.8` to `0.6.11`
* Updated `com.exasol:virtual-schema-common-document-files:7.3.3` to `7.3.4`
* Updated `org.jacoco:org.jacoco.agent:0.8.9` to `0.8.10`
* Updated `org.junit.jupiter:junit-jupiter-params:5.9.3` to `5.10.0`
* Updated `org.mockito:mockito-core:5.4.0` to `5.5.0`
* Updated `org.testcontainers:junit-jupiter:1.18.3` to `1.19.0`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:1.2.3` to `1.3.0`
* Updated `com.exasol:project-keeper-maven-plugin:2.9.7` to `2.9.12`
* Updated `org.apache.maven.plugins:maven-assembly-plugin:3.5.0` to `3.6.0`
* Updated `org.apache.maven.plugins:maven-dependency-plugin:3.5.0` to `3.6.0`
* Updated `org.apache.maven.plugins:maven-enforcer-plugin:3.3.0` to `3.4.0`
* Updated `org.apache.maven.plugins:maven-failsafe-plugin:3.0.0` to `3.1.2`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.0.0` to `3.1.2`
* Updated `org.basepom.maven:duplicate-finder-maven-plugin:1.5.1` to `2.0.1`
* Updated `org.codehaus.mojo:flatten-maven-plugin:1.4.1` to `1.5.0`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.15.0` to `2.16.0`
* Updated `org.jacoco:jacoco-maven-plugin:0.8.9` to `0.8.10`
