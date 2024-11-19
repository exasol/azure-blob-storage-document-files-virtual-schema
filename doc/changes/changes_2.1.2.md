# Virtual Schema for Document Data in Files on Azure Blob Storage 2.1.2, released 2024-11-19

Code name: Fixed vulnerabilities CVE-2024-47535 and CVE-2024-47561

## Summary

This release fixes the following vulnerability:

### CVE-2024-47535 (CWE-400) in dependency `io.netty:netty-common:jar:4.1.110.Final:compile`
Netty is an asynchronous event-driven network application framework for rapid development of maintainable high performance protocol servers & clients. An unsafe reading of environment file could potentially cause a denial of service in Netty. When loaded on an Windows application, Netty attempts to load a file that does not exist. If an attacker creates such a large file, the Netty application crashes. This vulnerability is fixed in 4.1.115.
#### References
* https://ossindex.sonatype.org/vulnerability/CVE-2024-47535?component-type=maven&component-name=io.netty%2Fnetty-common&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2024-47535
* https://github.com/advisories/GHSA-xq3w-v528-46rv

### CVE-2024-47561 (CWE-502) in dependency `org.apache.avro:avro:jar:1.11.3:compile`
Schema parsing in the Java SDK of Apache Avro 1.11.3 and previous versions allows bad actors to execute arbitrary code.
Users are recommended to upgrade to version 1.11.4Â  or 1.12.0, which fix this issue.
#### References
* https://ossindex.sonatype.org/vulnerability/CVE-2024-47561?component-type=maven&component-name=org.apache.avro%2Favro&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2024-47561
* https://lists.apache.org/thread/c2v7mhqnmq0jmbwxqq3r5jbj1xg43h5x

## Security

* #65: Fixed vulnerability CVE-2024-47535 in dependency `io.netty:netty-common:jar:4.1.110.Final:compile`
* #63: Fixed vulnerability CVE-2024-47561 in dependency `org.apache.avro:avro:jar:1.11.3:compile`

## Dependency Updates

### Compile Dependency Updates

* Added `com.azure:azure-core-http-netty:1.15.7`
* Updated `com.azure:azure-storage-blob:12.27.0` to `12.29.0`
* Updated `com.exasol:virtual-schema-common-document-files:8.1.2` to `8.1.5`
* Updated `org.slf4j:slf4j-jdk14:2.0.13` to `2.0.16`

### Test Dependency Updates

* Added `com.exasol:bucketfs-java:3.2.1`
* Updated `com.exasol:exasol-test-setup-abstraction-java:2.1.4` to `2.1.6`
* Updated `com.exasol:hamcrest-resultset-matcher:1.6.5` to `1.7.0`
* Updated `com.exasol:test-db-builder-java:3.5.4` to `3.6.0`
* Updated `com.exasol:virtual-schema-common-document-files:8.1.2` to `8.1.5`
* Updated `org.hamcrest:hamcrest:2.2` to `3.0`
* Updated `org.junit.jupiter:junit-jupiter-params:5.10.3` to `5.11.3`
* Updated `org.mockito:mockito-core:5.12.0` to `5.14.2`
* Updated `org.testcontainers:junit-jupiter:1.20.0` to `1.20.3`

### Plugin Dependency Updates

* Updated `com.exasol:project-keeper-maven-plugin:4.3.3` to `4.4.0`
* Added `com.exasol:quality-summarizer-maven-plugin:0.2.0`
* Updated `io.github.zlika:reproducible-build-maven-plugin:0.16` to `0.17`
* Updated `org.apache.maven.plugins:maven-clean-plugin:2.5` to `3.4.0`
* Updated `org.apache.maven.plugins:maven-dependency-plugin:3.6.1` to `3.8.0`
* Updated `org.apache.maven.plugins:maven-failsafe-plugin:3.2.5` to `3.5.1`
* Updated `org.apache.maven.plugins:maven-install-plugin:2.4` to `3.1.3`
* Updated `org.apache.maven.plugins:maven-jar-plugin:3.4.1` to `3.4.2`
* Updated `org.apache.maven.plugins:maven-resources-plugin:2.6` to `3.3.1`
* Updated `org.apache.maven.plugins:maven-site-plugin:3.3` to `3.9.1`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.2.5` to `3.5.1`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.16.2` to `2.17.1`
