# Virtual Schema for Document Data in Files on Azure Blob Storage 1.3.2, released 2023-07-03

Code name: Update dependencies on top of 1.3.1

## Summary

This release fixes vulnerabilities in the following compile time dependencies:
* `org.xerial.snappy:snappy-java`
  * CVE-2023-34453, severity CWE-190: Integer Overflow or Wraparound (7.5)
  * CVE-2023-34454, severity CWE-190: Integer Overflow or Wraparound (7.5)
  * CVE-2023-34455, severity CWE-770: Allocation of Resources Without Limits or Throttling (7.5)
* `io.netty:netty-handler`
  * CVE-2023-34462, severity CWE-770: Allocation of Resources Without Limits or Throttling (6.5)
  

## Security

* #33: Updated dependencies

## Dependency Updates

### Compile Dependency Updates

* Updated `com.azure:azure-storage-blob:12.22.0` to `12.22.3`
* Updated `com.exasol:virtual-schema-common-document-files:7.3.2` to `7.3.3`

### Test Dependency Updates

* Updated `com.exasol:exasol-test-setup-abstraction-java:2.0.1` to `2.0.2`
* Updated `com.exasol:virtual-schema-common-document-files:7.3.2` to `7.3.3`
* Updated `org.mockito:mockito-core:5.3.1` to `5.4.0`
* Updated `org.testcontainers:junit-jupiter:1.18.0` to `1.18.3`
