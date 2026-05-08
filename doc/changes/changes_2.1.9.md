# Virtual Schema for Document Data in Files on Azure Blob Storage 2.1.9, released 2026-??-??

Code name: Fixed vulnerability CVE-2026-41417 in io.netty:netty-codec-http:jar:4.2.12.Final:compile

## Summary

This release fixes the following vulnerability:

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

### Test Dependency Updates

* Updated `com.exasol:test-db-builder-java:3.6.4` to `4.0.0`
* Updated `org.junit.jupiter:junit-jupiter-params:5.14.3` to `6.0.3`
* Updated `org.testcontainers:testcontainers-junit-jupiter:2.0.4` to `2.0.5`

### Plugin Dependency Updates

* Updated `com.exasol:project-keeper-maven-plugin:5.4.6` to `5.6.1`
