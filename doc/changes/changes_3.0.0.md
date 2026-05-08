# Virtual Schema for Document Data in Files on Azure Blob Storage 3.0.0, released 2026-05-08

Code name: Anonymous telemetry & fixed vulnerability CVE-2026-41417

## Summary

This release adds anonymous feature-usage telemetry via `telemetry-java`. See the [documentation](https://github.com/exasol/telemetry-java/blob/main/doc/app-user-guide.md) for details on collected data and opt-out behavior.

## Breaking Change

Starting with this release, the Oracle Virtual Schema does not support Exasol versions 7.1 anymore. Only LTS version 2025.1.x and the current version are supported.

This release also fixes the following vulnerability:

### CVE-2026-41417 (CWE-93) in dependency `io.netty:netty-codec-http:jar:4.2.12.Final:compile`

io.netty:netty-codec-http - CRLF Injection

#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-41417?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-41417
* https://github.com/advisories/GHSA-v8h7-rr48-vmmv

## Security

* #95: Fixed vulnerability CVE-2026-41417 in dependency `io.netty:netty-codec-http:jar:4.2.12.Final:compile`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.azure:azure-storage-blob:12.29.1` to `12.33.4`
* Updated `com.exasol:virtual-schema-common-document-files:8.1.14` to `9.0.0`

### Test Dependency Updates

* Updated `com.exasol:test-db-builder-java:3.6.4` to `4.0.0`
* Updated `com.exasol:virtual-schema-common-document-files:8.1.14` to `9.0.0`
* Updated `org.junit.jupiter:junit-jupiter-params:5.14.3` to `5.14.4`
* Updated `org.testcontainers:testcontainers-junit-jupiter:2.0.4` to `2.0.5`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:2.0.6` to `2.0.7`
* Updated `com.exasol:project-keeper-maven-plugin:5.4.6` to `5.6.2`
* Updated `io.github.git-commit-id:git-commit-id-maven-plugin:9.0.2` to `10.0.0`
* Updated `org.apache.maven.plugins:maven-failsafe-plugin:3.5.4` to `3.5.5`
* Updated `org.apache.maven.plugins:maven-resources-plugin:3.4.0` to `3.5.0`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.5.4` to `3.5.5`
