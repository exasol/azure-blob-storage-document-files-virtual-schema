# Virtual Schema for Document Data in Files on Azure Blob Storage 3.1.1, released 2026-??-??

Code name: Fixed vulnerabilities CVE-2026-91776, CVE-2026-91777, CVE-2026-83557, CVE-2026-90559, CVE-2026-68498

## Summary

This release fixes the following 5 vulnerabilities:

### CVE-2026-91776 (CWE-770) in dependency `com.fasterxml.jackson.core:jackson-databind:jar:2.22.1:compile`
Jackson-databind - Unbounded growth of type id cache in TypeDeserializer
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-91776?component-type=maven&component-name=com.fasterxml.jackson.core%2Fjackson-databind&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-91776
* https://github.com/FasterXML/jackson-databind/pull/6203

### CVE-2026-91777 (CWE-407) in dependency `com.fasterxml.jackson.core:jackson-databind:jar:2.22.1:compile`
Jackson-databind - Denial of Service (DoS)
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-91777?component-type=maven&component-name=com.fasterxml.jackson.core%2Fjackson-databind&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-91777
* https://github.com/FasterXML/jackson-databind/pull/6204

### CVE-2026-83557 (CWE-502) in dependency `com.fasterxml.jackson.core:jackson-databind:jar:2.22.1:compile`
jackson-databind - Deserialization of untrusted data [CVE-2026-83557]
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-83557?component-type=maven&component-name=com.fasterxml.jackson.core%2Fjackson-databind&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-83557
* https://github.com/FasterXML/jackson-databind/issues/6156
* https://github.com/FasterXML/jackson-databind/security/advisories/GHSA-gx83-3vf8-gh7j

### CVE-2026-90559 (CWE-787) in dependency `org.xerial.snappy:snappy-java:jar:1.1.10.7:compile`
snappy-java through 1.1.10.8 contains an out-of-bounds write vulnerability in Snappy.uncompress(ByteBuffer, ByteBuffer) because destination buffer capacity is never validated against decompressed size. Attackers can supply valid compressed data that decompresses larger than the destination buffer, causing writes past buffer boundaries and JVM termination.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-90559?component-type=maven&component-name=org.xerial.snappy%2Fsnappy-java&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-90559
* https://github.com/xerial/snappy-java/issues/728

### CVE-2026-68498 (CWE-770) in dependency `com.fasterxml.jackson.core:jackson-core:jar:2.22.1:compile`
jackson-core - Allocation of Resources Without Limits or Throttling

Sonatype's research suggests that this CVE's details differ from those defined at NVD. See https://guide.sonatype.com/vulnerability/CVE-2026-68498 for details
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-68498?component-type=maven&component-name=com.fasterxml.jackson.core%2Fjackson-core&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-68498
* https://github.com/FasterXML/jackson-core/security/advisories/GHSA-649p-m576-vr99

## Security

* #161: Fixed vulnerability CVE-2026-91776 in dependency `com.fasterxml.jackson.core:jackson-databind:jar:2.22.1:compile`
* #162: Fixed vulnerability CVE-2026-91777 in dependency `com.fasterxml.jackson.core:jackson-databind:jar:2.22.1:compile`
* #163: Fixed vulnerability CVE-2026-83557 in dependency `com.fasterxml.jackson.core:jackson-databind:jar:2.22.1:compile`
* #164: Fixed vulnerability CVE-2026-90559 in dependency `org.xerial.snappy:snappy-java:jar:1.1.10.7:compile`
* #165: Fixed vulnerability CVE-2026-68498 in dependency `com.fasterxml.jackson.core:jackson-core:jar:2.22.1:compile`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.azure:azure-storage-blob:12.35.0` to `12.35.1`
* Updated `com.exasol:virtual-schema-common-document-files:9.1.0` to `9.1.1`
* Updated `org.slf4j:slf4j-jdk14:2.0.18` to `2.0.19`

### Test Dependency Updates

* Updated `com.exasol:exasol-test-setup-abstraction-java:3.0.0` to `3.0.1`
* Updated `com.exasol:hamcrest-resultset-matcher:1.7.3` to `1.7.4`
* Updated `com.exasol:test-db-builder-java:4.0.2` to `4.0.3`
* Updated `com.exasol:virtual-schema-common-document-files:9.1.0` to `9.1.1`
* Updated `org.junit.jupiter:junit-jupiter-params:5.14.4` to `6.1.3`

### Plugin Dependency Updates

* Updated `com.exasol:project-keeper-maven-plugin:5.7.4` to `5.7.6`
