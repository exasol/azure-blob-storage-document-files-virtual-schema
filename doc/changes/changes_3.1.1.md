# Virtual Schema for Document Data in Files on Azure Blob Storage 3.1.1, released 2026-??-??

Code name: Fixed vulnerability CVE-2026-104880 in de.siegmar:fastcsv:jar:3.7.0:compile

## Summary

This release fixes the following vulnerability:

### CVE-2026-104880 (CWE-436) in dependency `de.siegmar:fastcsv:jar:3.7.0:compile`
de.siegmar:fastcsv - Interpretation Conflict
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-104880?component-type=maven&component-name=de.siegmar%2Ffastcsv&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-104880
* https://github.com/osiegmar/FastCSV/security/advisories/GHSA-64pw-j3v7-xc9q

## Security

* #196: Fixed vulnerability CVE-2026-104880 in dependency `de.siegmar:fastcsv:jar:3.7.0:compile`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.azure:azure-storage-blob:12.35.0` to `12.35.1`
* Updated `com.exasol:virtual-schema-common-document-files:9.1.0` to `9.1.1`
* Updated `org.slf4j:slf4j-jdk14:2.0.18` to `2.0.20`

### Test Dependency Updates

* Updated `com.exasol:exasol-test-setup-abstraction-java:3.0.0` to `3.0.1`
* Updated `com.exasol:hamcrest-resultset-matcher:1.7.3` to `1.7.4`
* Updated `com.exasol:test-db-builder-java:4.0.2` to `4.0.3`
* Updated `com.exasol:virtual-schema-common-document-files:9.1.0` to `9.1.1`
* Updated `org.junit.jupiter:junit-jupiter-params:5.14.4` to `6.1.3`
* Updated `org.mockito:mockito-core:5.23.0` to `5.24.0`

### Plugin Dependency Updates

* Updated `com.exasol:project-keeper-maven-plugin:5.7.4` to `5.7.6`
