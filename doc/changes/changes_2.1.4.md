# Virtual Schema for Document Data in Files on Azure Blob Storage 2.1.4, released 2025-06-03
Code name: Fixed vulnerabilities CVE-2025-48734, CVE-2025-4949 and CVE-2024-55551 in test dependencies

## Summary

This release is a security update. We updated the dependencies of the project to fix transitive security issues.

We also added an exception for the OSSIndex for CVE-2024-55551, which is a false positive in Exasol's JDBC driver.
This issue has been fixed quite a while back now, but the OSSIndex unfortunately does not contain the fix version of 24.2.1 (2024-12-10) set.

## Security

* #76: Fixed CVE-2025-48734 in `commons-beanutils:commons-beanutils:jar:1.9.4:test`
* #74: Fixed CVE-2025-4949 in `org.eclipse.jgit:org.eclipse.jgit:jar:6.7.0.202309050840-r:test`
* #72: Fixed CVE-2024-55551 in `com.exasol:exasol-jdbc:jar:24.2.1:test`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:virtual-schema-common-document-files:8.1.5` to `8.1.7`

### Test Dependency Updates

* Updated `com.exasol:performance-test-recorder-java:0.1.3` to `0.1.4`
* Updated `com.exasol:virtual-schema-common-document-files:8.1.5` to `8.1.7`
* Updated `org.jacoco:org.jacoco.agent:0.8.12` to `0.8.13`

### Plugin Dependency Updates

* Updated `com.exasol:artifact-reference-checker-maven-plugin:0.4.2` to `0.4.3`
* Updated `com.exasol:project-keeper-maven-plugin:4.5.0` to `5.1.0`
* Added `io.github.git-commit-id:git-commit-id-maven-plugin:9.0.1`
* Removed `io.github.zlika:reproducible-build-maven-plugin:0.17`
* Added `org.apache.maven.plugins:maven-artifact-plugin:3.6.0`
* Updated `org.apache.maven.plugins:maven-clean-plugin:3.4.0` to `3.4.1`
* Updated `org.apache.maven.plugins:maven-compiler-plugin:3.13.0` to `3.14.0`
* Updated `org.apache.maven.plugins:maven-failsafe-plugin:3.5.2` to `3.5.3`
* Updated `org.apache.maven.plugins:maven-install-plugin:3.1.3` to `3.1.4`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.5.2` to `3.5.3`
* Updated `org.codehaus.mojo:flatten-maven-plugin:1.6.0` to `1.7.0`
* Updated `org.jacoco:jacoco-maven-plugin:0.8.12` to `0.8.13`
* Updated `org.sonarsource.scanner.maven:sonar-maven-plugin:5.0.0.4389` to `5.1.0.4751`
