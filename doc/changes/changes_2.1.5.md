# Virtual Schema for Document Data in Files on Azure Blob Storage 2.1.5, released 2025-08-01

Code name: Fixes for CVE-2025-22227, CVE-2025-48924 

## Summary

This release fixes the following vulnerabilities:

### CVE-2025-22227 (CWE-200) in dependency `io.projectreactor.netty:reactor-netty-http:jar:1.0.48:compile`

In some specific scenarios with chained redirects, Reactor Netty HTTP client leaks credentials. In order for this to happen, the HTTP client must have been explicitly configured to follow redirects.

CVE: CVE-2025-22227
CWE: CWE-200

#### References

- https://ossindex.sonatype.org/vulnerability/CVE-2025-22227?component-type=maven&component-name=io.projectreactor.netty%2Freactor-netty-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
- http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2025-22227
- https://github.com/advisories/GHSA-4q2v-9p7v-3v22

### CVE-2025-48924 (CWE-674) in dependency `org.apache.commons:commons-lang3:jar:3.16.0:test`

Uncontrolled Recursion vulnerability in Apache Commons Lang.

This issue affects Apache Commons Lang: Starting with commons-lang:commons-lang 2.0 to 2.6, and, from org.apache.commons:commons-lang3 3.0 before 3.18.0.

The methods ClassUtils.getClass(...) can throw StackOverflowError on very long inputs. Because an Error is usually not handled by applications and libraries, a 
StackOverflowError could cause an application to stop.

Users are recommended to upgrade to version 3.18.0, which fixes the issue.

CVE: CVE-2025-48924
CWE: CWE-674

#### References

- https://ossindex.sonatype.org/vulnerability/CVE-2025-48924?component-type=maven&component-name=org.apache.commons%2Fcommons-lang3&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
- http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2025-48924
- https://github.com/advisories/GHSA-j288-q9x7-2f5v

## Security

* #80: Fixed vulnerability CVE-2025-22227 in dependency `io.projectreactor.netty:reactor-netty-http:jar:1.0.48:compile`
* #79: Fixed vulnerability CVE-2025-48924 in dependency `org.apache.commons:commons-lang3:jar:3.16.0:test`

## Dependency Updates

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:2.0.3` to `2.0.4`
* Updated `com.exasol:project-keeper-maven-plugin:5.1.0` to `5.2.3`
