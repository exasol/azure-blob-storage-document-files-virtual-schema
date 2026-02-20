# Virtual Schema for Document Data in Files on Azure Blob Storage 2.1.7, released 2026-02-20

Code name: Fixes for vulnerabilities CVE-2025-58056 and CVE-2025-58057

## Summary

This release fixes the following vulnerabilities:

### CVE-2025-58056 (CWE-444) in dependency `io.netty:netty-codec-http:jar:4.1.124.Final:compile`

Netty is an asynchronous event-driven network application framework for development of maintainable high performance protocol servers and clients. In versions 4.1.124.Final, and 4.2.0.Alpha3 through 4.2.4.Final, Netty incorrectly accepts standalone newline characters (LF) as a chunk-size line terminator, regardless of a preceding carriage return (CR), instead of requiring CRLF per HTTP/1.1 standards. When combined with reverse proxies that parse LF differently (treating it as part of the chunk extension), attackers can craft requests that the proxy sees as one request but Netty processes as two, enabling request smuggling attacks. This is fixed in versions 4.1.125.Final and 4.2.5.Final.

CVE: CVE-2025-58056
CWE: CWE-444

#### References

- https://ossindex.sonatype.org/vulnerability/CVE-2025-58056?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
- http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2025-58056
- https://github.com/netty/netty/security/advisories/GHSA-fghv-69vj-qj49

### CVE-2025-58057 (CWE-409) in dependency `io.netty:netty-codec:jar:4.1.124.Final:compile`

netty-codec - Improper Handling of Highly Compressed Data (Data Amplification)

CVE: CVE-2025-58057
CWE: CWE-409

#### References

- https://ossindex.sonatype.org/vulnerability/CVE-2025-58057?component-type=maven&component-name=io.netty%2Fnetty-codec&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
- http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2025-58057
- https://github.com/netty/netty/security/advisories/GHSA-3p8m-j85q-pgmj

## Security

* #87: Fixed vulnerability CVE-2025-58056 in dependency `io.netty:netty-codec-http:jar:4.1.124.Final:compile`
* #85: Fixed vulnerability CVE-2025-58057 in dependency `io.netty:netty-codec:jar:4.1.124.Final:compile`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:virtual-schema-common-document-files:8.1.7` to `8.1.14`

### Test Dependency Updates

* Updated `com.exasol:exasol-test-setup-abstraction-java:2.1.7` to `2.1.11`
* Updated `com.exasol:virtual-schema-common-document-files:8.1.7` to `8.1.14`
* Updated `org.jacoco:org.jacoco.agent:0.8.13` to `0.8.14`

### Plugin Dependency Updates

* Updated `com.exasol:artifact-reference-checker-maven-plugin:0.4.3` to `0.4.4`
* Updated `com.exasol:error-code-crawler-maven-plugin:2.0.4` to `2.0.6`
* Updated `com.exasol:project-keeper-maven-plugin:5.2.3` to `5.4.6`
* Updated `com.exasol:quality-summarizer-maven-plugin:0.2.0` to `0.2.1`
* Updated `io.github.git-commit-id:git-commit-id-maven-plugin:9.0.1` to `9.0.2`
* Updated `org.apache.maven.plugins:maven-artifact-plugin:3.6.0` to `3.6.1`
* Updated `org.apache.maven.plugins:maven-assembly-plugin:3.7.1` to `3.8.0`
* Updated `org.apache.maven.plugins:maven-clean-plugin:3.4.1` to `3.5.0`
* Updated `org.apache.maven.plugins:maven-compiler-plugin:3.14.0` to `3.15.0`
* Updated `org.apache.maven.plugins:maven-dependency-plugin:3.8.1` to `3.10.0`
* Updated `org.apache.maven.plugins:maven-enforcer-plugin:3.5.0` to `3.6.2`
* Updated `org.apache.maven.plugins:maven-failsafe-plugin:3.5.3` to `3.5.4`
* Updated `org.apache.maven.plugins:maven-jar-plugin:3.4.2` to `3.5.0`
* Updated `org.apache.maven.plugins:maven-resources-plugin:3.3.1` to `3.4.0`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.5.3` to `3.5.4`
* Updated `org.codehaus.mojo:flatten-maven-plugin:1.7.0` to `1.7.3`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.18.0` to `2.21.0`
* Updated `org.jacoco:jacoco-maven-plugin:0.8.13` to `0.8.14`
* Updated `org.sonarsource.scanner.maven:sonar-maven-plugin:5.1.0.4751` to `5.5.0.6356`
