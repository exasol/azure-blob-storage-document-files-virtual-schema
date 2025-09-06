# Virtual Schema for Document Data in Files on Azure Blob Storage 2.1.7, released 2025-??-??

Code name: Fixed vulnerability CVE-2025-58056 in io.netty:netty-codec-http:jar:4.1.124.Final:compile

## Summary

This release fixes the following vulnerability:

### CVE-2025-58056 (CWE-444) in dependency `io.netty:netty-codec-http:jar:4.1.124.Final:compile`
Netty is an asynchronous event-driven network application framework for development of maintainable high performance protocol servers and clients. In versions 4.1.124.Final, and 4.2.0.Alpha3 through 4.2.4.Final, Netty incorrectly accepts standalone newline characters (LF) as a chunk-size line terminator, regardless of a preceding carriage return (CR), instead of requiring CRLF per HTTP/1.1 standards. When combined with reverse proxies that parse LF differently (treating it as part of the chunk extension), attackers can craft requests that the proxy sees as one request but Netty processes as two, enabling request smuggling attacks. This is fixed in versions 4.1.125.Final and 4.2.5.Final.
#### References
* https://ossindex.sonatype.org/vulnerability/CVE-2025-58056?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2025-58056
* https://github.com/netty/netty/security/advisories/GHSA-fghv-69vj-qj49

## Security

* #87: Fixed vulnerability CVE-2025-58056 in dependency `io.netty:netty-codec-http:jar:4.1.124.Final:compile`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.azure:azure-storage-blob:12.29.0` to `12.31.2`
* Updated `com.exasol:virtual-schema-common-document-files:8.1.7` to `8.1.12`
* Updated `org.slf4j:slf4j-jdk14:2.0.16` to `2.0.17`

### Test Dependency Updates

* Updated `com.exasol:exasol-test-setup-abstraction-java:2.1.7` to `2.1.9`
* Updated `com.exasol:hamcrest-resultset-matcher:1.7.0` to `1.7.2`
* Updated `com.exasol:performance-test-recorder-java:0.1.4` to `0.1.5`
* Updated `com.exasol:test-db-builder-java:3.6.0` to `3.6.3`
* Updated `com.exasol:virtual-schema-common-document-files:8.1.7` to `8.1.12`
* Updated `org.junit.jupiter:junit-jupiter-params:5.11.4` to `5.13.4`
* Updated `org.mockito:mockito-core:5.15.2` to `5.19.0`
* Updated `org.testcontainers:junit-jupiter:1.20.4` to `1.21.3`
