# Virtual Schema for Document Data in Files on Azure Blob Storage 4.0.0, released 2026-10-29

Code name: Fix vulnerabilities

## Summary

This release upgrades `virtual-schema-common-document-files` to version 10.0.1 and updates Azure SDK, Netty, Reactor, and Jackson dependencies to fix known vulnerabilities. Java 17 is now required to build and run this Virtual Schema.

Exasol 8 is no longer supported.

## Security

* #134, #148, #153, #154, #156, #167–#189: Fixed Netty CVE-2026-59903, CVE-2026-62380, CVE-2026-89044, CVE-2026-100655 through CVE-2026-100664, CVE-2026-100666, CVE-2026-93488, CVE-2026-93491, CVE-2026-93558, CVE-2026-93562, CVE-2026-93565 through CVE-2026-93568, CVE-2026-93573, and CVE-2026-93574 (HTTP request smuggling, cache exposure, null-byte handling, and resource exhaustion) in `io.netty:*:4.2.16.Final`.
* #144, #149, #150: Fixed CVE-2026-75596, CVE-2026-75595, and CVE-2026-62243 (TLS validation and algorithmic-complexity flaws) in `io.netty:netty-handler:4.2.16.Final`.
* #145, #146: Fixed CVE-2026-47857 and CVE-2026-47863 (fair-backpressure stream hangs) in `io.projectreactor:reactor-core:3.7.18`.
* #139–#143: Fixed CVE-2026-47844, CVE-2026-47845, CVE-2026-47848, CVE-2026-47874, and CVE-2026-47843 (routing, authentication, credential, and denial-of-service flaws) in `io.projectreactor.netty:*:1.3.6`.
* #136, #137, #161–#163, #165, #193, #194, #210: Fixed CVE-2026-19032, CVE-2026-68497, CVE-2026-68498, CVE-2026-91776, CVE-2026-91777, CVE-2026-83557, CVE-2026-89407, CVE-2026-89425, and CVE-2026-110879 (Jackson deserialization and parser resource-exhaustion flaws) in `com.fasterxml.jackson.core:*:2.22.1`.
* #152: Fixed CVE-2026-73334 (untrusted KMS URL) in `org.apache.parquet:parquet-hadoop:1.17.1`.
* #155: Fixed CVE-2026-86231 (certificate-revocation bypass) in `com.github.mwiede:jsch:2.28.4`.
* #157, #158, #159: Fixed CVE-2026-87795, CVE-2026-87823, and CVE-2026-89045 (native bounds and loop flaws) in `com.github.luben:zstd-jni:1.5.7-3`.
* #164, #190, #191, #198, #199: Fixed CVE-2026-90559, CVE-2026-93451, CVE-2026-93452, CVE-2026-108104, and CVE-2026-108106 (native buffer and allocation flaws) in `org.xerial.snappy:snappy-java:1.1.10.7`.
* #196: Fixed CVE-2026-104880 (CSV interpretation conflict) in `de.siegmar:fastcsv:3.7.0`.
* #201, #202: Fixed CVE-2026-110262 and CVE-2026-110270 (bytecode memory exhaustion) in `org.ow2.asm:asm-commons:9.10.1`.
* #203, #204, #205, #206, #207, #208: Fixed CVE-2026-110257, CVE-2026-110258, CVE-2026-110259, CVE-2026-110260, CVE-2026-110261, and CVE-2026-110263 (crafted-bytecode denial of service) in `org.ow2.asm:asm:9.10.1`.
* #192: Fixed CVE-2026-100665 (QUIC hostname validation) in `io.netty:netty-codec-classes-quic:4.2.16.Final`.

## Dependency Updates

### Compile Dependency Updates

* Updated `com.azure:azure-storage-blob:12.35.0` to `12.36.0`
* Updated `com.exasol:virtual-schema-common-document-files:9.1.0` to `10.0.1`
* Updated `org.slf4j:slf4j-jdk14:2.0.18` to `2.0.20`

### Test Dependency Updates

* Updated `com.exasol:exasol-test-setup-abstraction-java:3.0.0` to `3.0.1`
* Updated `com.exasol:hamcrest-resultset-matcher:1.7.3` to `1.7.4`
* Updated `com.exasol:test-db-builder-java:4.0.2` to `4.0.3`
* Updated `com.exasol:udf-debugging-java:0.6.20` to `0.6.22`
* Updated `com.exasol:virtual-schema-common-document-files:9.1.0` to `10.0.1`
* Updated `org.junit.jupiter:junit-jupiter-params:5.14.4` to `6.1.3`
* Updated `org.mockito:mockito-core:5.23.0` to `5.24.0`
* Added `org.objenesis:objenesis:3.6`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:2.1.0` to `2.1.2`
* Updated `com.exasol:project-keeper-maven-plugin:5.7.4` to `5.8.1`
* Updated `io.github.git-commit-id:git-commit-id-maven-plugin:10.0.0` to `10.0.1`
* Updated `org.apache.maven.plugins:maven-artifact-plugin:3.6.1` to `3.7.0`
* Updated `org.apache.maven.plugins:maven-compiler-plugin:3.15.0` to `3.16.0`
* Updated `org.apache.maven.plugins:maven-failsafe-plugin:3.5.6` to `3.6.0`
* Updated `org.apache.maven.plugins:maven-install-plugin:3.1.4` to `3.2.0`
* Updated `org.apache.maven.plugins:maven-jar-plugin:3.5.0` to `3.5.1`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.5.6` to `3.6.0`
* Updated `org.apache.maven.plugins:maven-toolchains-plugin:3.2.0` to `3.3.0`
* Updated `org.codehaus.mojo:flatten-maven-plugin:1.7.3` to `1.8.0`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.21.0` to `2.23.0`
* Updated `org.sonarsource.scanner.maven:sonar-maven-plugin:5.7.0.6970` to `5.8.0.7211`
