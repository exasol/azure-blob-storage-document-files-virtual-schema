# Virtual Schema for Document Data in Files on Azure Blob Storage 2.1.8, released 2026-??-??

Code name: Fixed vulnerabilities CVE-2026-33870, CVE-2026-33871

## Summary

This release fixes the following 2 vulnerabilities:

### CVE-2026-33870 (CWE-444) in dependency `io.netty:netty-codec-http:jar:4.1.131.Final:compile`
netty-codec-http - Inconsistent Interpretation of HTTP Requests ('HTTP Request/Response Smuggling')
#### References
* https://ossindex.sonatype.org/vulnerability/CVE-2026-33870?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-33870
* https://github.com/advisories/GHSA-pwqr-wmgm-9rr8
* https://gitlab.com/gitlab-org/advisories-community/-/blob/main/maven/io.netty/netty-codec-http/CVE-2026-33870.yml
* https://osv-vulnerabilities.storage.googleapis.com/Maven/GHSA-pwqr-wmgm-9rr8.json
* https://www.sonatype.com/products/sonatype-guide/oss-index-users

### CVE-2026-33871 (CWE-770) in dependency `io.netty:netty-codec-http2:jar:4.1.131.Final:compile`
io.netty:netty-codec-http2 - Allocation of Resources Without Limits or Throttling
#### References
* https://ossindex.sonatype.org/vulnerability/CVE-2026-33871?component-type=maven&component-name=io.netty%2Fnetty-codec-http2&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-33871
* https://github.com/advisories/GHSA-w9fj-cfpg-grvv
* https://www.sonatype.com/products/sonatype-guide/oss-index-users

## Security

* #92: Fixed vulnerability CVE-2026-33870 in dependency `io.netty:netty-codec-http:jar:4.1.131.Final:compile`
* #93: Fixed vulnerability CVE-2026-33871 in dependency `io.netty:netty-codec-http2:jar:4.1.131.Final:compile`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.azure:azure-storage-blob:12.29.0` to `12.33.2`
* Updated `com.exasol:error-reporting-java:1.0.1` to `1.0.2`
* Updated `org.slf4j:slf4j-jdk14:2.0.16` to `2.0.17`

### Test Dependency Updates

* Updated `com.exasol:hamcrest-resultset-matcher:1.7.0` to `1.7.2`
* Updated `com.exasol:performance-test-recorder-java:0.1.4` to `0.1.5`
* Updated `com.exasol:test-db-builder-java:3.6.0` to `3.6.4`
* Updated `com.exasol:udf-debugging-java:0.6.17` to `0.6.18`
* Updated `org.junit.jupiter:junit-jupiter-params:5.11.4` to `6.0.3`
* Updated `org.mockito:mockito-core:5.15.2` to `5.23.0`
* Updated `org.testcontainers:junit-jupiter:1.20.4` to `1.21.4`
