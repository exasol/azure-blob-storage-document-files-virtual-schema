# Virtual Schema for Document Data in Files on Azure Blob Storage 3.1.1, released 2026-??-??

Code name: Fixed vulnerabilities CVE-2026-19032, CVE-2026-68497

## Summary

This release fixes the following 2 vulnerabilities:

### CVE-2026-19032 (CWE-470) in dependency `com.fasterxml.jackson.core:jackson-databind:jar:2.22.1:compile`
com.fasterxml.jackson.core/jackson-databind - Unrestricted URI schemes in Path deserialization
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-19032?component-type=maven&component-name=com.fasterxml.jackson.core%2Fjackson-databind&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-19032
* https://github.com/FasterXML/jackson-databind/pull/6129

### CVE-2026-68497 (CWE-770) in dependency `com.fasterxml.jackson.core:jackson-databind:jar:2.22.1:compile`
jackson-databind - Allocation of Resources Without Limits or Throttling
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-68497?component-type=maven&component-name=com.fasterxml.jackson.core%2Fjackson-databind&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-68497
* https://github.com/FasterXML/jackson-databind/pull/6127

## Security

* #136: Fixed vulnerability CVE-2026-19032 in dependency `com.fasterxml.jackson.core:jackson-databind:jar:2.22.1:compile`
* #137: Fixed vulnerability CVE-2026-68497 in dependency `com.fasterxml.jackson.core:jackson-databind:jar:2.22.1:compile`

## Dependency Updates

### Test Dependency Updates

* Updated `org.junit.jupiter:junit-jupiter-params:5.14.4` to `6.1.3`
