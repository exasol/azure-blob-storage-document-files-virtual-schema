# Virtual Schema for Document Data in Files on Azure Blob Storage 2.1.4, released 2025-??-??

Code name: Fixed vulnerability CVE-2025-4949 in org.eclipse.jgit:org.eclipse.jgit:jar:6.7.0.202309050840-r:test

## Summary

This release fixes the following vulnerability:

### CVE-2025-4949 (CWE-611) in dependency `org.eclipse.jgit:org.eclipse.jgit:jar:6.7.0.202309050840-r:test`
Eclipse JGit - Improper Restriction of XML External Entity Reference
#### References
* https://ossindex.sonatype.org/vulnerability/CVE-2025-4949?component-type=maven&component-name=org.eclipse.jgit%2Forg.eclipse.jgit&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2025-4949
* https://gitlab.eclipse.org/security/cve-assignement/-/issues/64
* https://gitlab.eclipse.org/security/vulnerability-reports/-/issues/281

## Security

* #74: Fixed vulnerability CVE-2025-4949 in dependency `org.eclipse.jgit:org.eclipse.jgit:jar:6.7.0.202309050840-r:test`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.azure:azure-storage-blob:12.29.0` to `12.30.0`
* Updated `com.exasol:virtual-schema-common-document-files:8.1.5` to `8.1.6`
* Updated `org.slf4j:slf4j-jdk14:2.0.16` to `2.0.17`

### Test Dependency Updates

* Updated `com.exasol:test-db-builder-java:3.6.0` to `3.6.1`
* Updated `com.exasol:udf-debugging-java:0.6.14` to `0.6.15`
* Updated `com.exasol:virtual-schema-common-document-files:8.1.5` to `8.1.6`
* Updated `org.junit.jupiter:junit-jupiter-params:5.11.4` to `5.12.2`
* Updated `org.mockito:mockito-core:5.15.2` to `5.18.0`
* Updated `org.testcontainers:junit-jupiter:1.20.4` to `1.21.0`

### Plugin Dependency Updates

* Updated `com.exasol:project-keeper-maven-plugin:4.5.0` to `5.1.0`
