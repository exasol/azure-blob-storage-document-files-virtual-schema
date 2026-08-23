# Virtual Schema for Document Data in Files on Azure Blob Storage 3.1.1, released 2026-??-??

Code name: Fixed vulnerabilities CVE-2026-47844, CVE-2026-47845, CVE-2026-47848, CVE-2026-47874, CVE-2026-47843, CVE-2026-75596, CVE-2026-47857, CVE-2026-47863

## Summary

This release fixes the following 8 vulnerabilities:

### CVE-2026-47844 (CWE-488) in dependency `io.projectreactor.netty:reactor-netty-http:jar:1.3.6:compile`
Reactor Netty HTTP Server - Exposure of Data Element to Wrong Session
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-47844?component-type=maven&component-name=io.projectreactor.netty%2Freactor-netty-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-47844
* https://spring.io/security/cve-2026-47844

### CVE-2026-47845 (CWE-290) in dependency `io.projectreactor.netty:reactor-netty-http:jar:1.3.6:compile`
Reactor Netty HTTP Server - Authentication Bypass by Spoofing
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-47845?component-type=maven&component-name=io.projectreactor.netty%2Freactor-netty-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-47845
* https://spring.io/security/cve-2026-47845

### CVE-2026-47848 (CWE-200) in dependency `io.projectreactor.netty:reactor-netty-http:jar:1.3.6:compile`
Reactor Netty - WebSocket Client Leaks Credentials On Redirect
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-47848?component-type=maven&component-name=io.projectreactor.netty%2Freactor-netty-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-47848
* https://spring.io/security/cve-2026-47848

### CVE-2026-47874 (CWE-770) in dependency `io.projectreactor.netty:reactor-netty-http:jar:1.3.6:compile`
Reactor Netty - HTTP Server Denial of Service With Pipelined Requests
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-47874?component-type=maven&component-name=io.projectreactor.netty%2Freactor-netty-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-47874
* https://spring.io/security/cve-2026-47874

### CVE-2026-47843 (CWE-668) in dependency `io.projectreactor.netty:reactor-netty-core:jar:1.3.6:compile`
Reactor Netty - Incorrectly Route Traffic due to DNS Resolver Reuse
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-47843?component-type=maven&component-name=io.projectreactor.netty%2Freactor-netty-core&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-47843
* https://spring.io/security/cve-2026-47843

### CVE-2026-75596 (CWE-407) in dependency `io.netty:netty-handler:jar:4.2.16.Final:compile`
io.netty:netty-handler - Inefficient Algorithmic Complexity
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-75596?component-type=maven&component-name=io.netty%2Fnetty-handler&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-75596
* https://github.com/netty/netty/security/advisories/GHSA-fccg-mwvh-qqg4

### CVE-2026-47857 (CWE-190) in dependency `io.projectreactor:reactor-core:jar:3.7.18:compile`
Reactor Core - windowTimeout fair-backpressure stream hang due to 20-bit index wrap-around
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-47857?component-type=maven&component-name=io.projectreactor%2Freactor-core&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-47857
* https://spring.io/security/cve-2026-47857

### CVE-2026-47863 (CWE-833) in dependency `io.projectreactor:reactor-core:jar:3.7.18:compile`
Reactor Core - bufferTimeout fair-backpressure pipeline permanently hangs when upstream delivers items during an active flush
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-47863?component-type=maven&component-name=io.projectreactor%2Freactor-core&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-47863
* https://spring.io/security/cve-2026-47863

## Security

* #139: Fixed vulnerability CVE-2026-47844 in dependency `io.projectreactor.netty:reactor-netty-http:jar:1.3.6:compile`
* #140: Fixed vulnerability CVE-2026-47845 in dependency `io.projectreactor.netty:reactor-netty-http:jar:1.3.6:compile`
* #141: Fixed vulnerability CVE-2026-47848 in dependency `io.projectreactor.netty:reactor-netty-http:jar:1.3.6:compile`
* #142: Fixed vulnerability CVE-2026-47874 in dependency `io.projectreactor.netty:reactor-netty-http:jar:1.3.6:compile`
* #143: Fixed vulnerability CVE-2026-47843 in dependency `io.projectreactor.netty:reactor-netty-core:jar:1.3.6:compile`
* #144: Fixed vulnerability CVE-2026-75596 in dependency `io.netty:netty-handler:jar:4.2.16.Final:compile`
* #145: Fixed vulnerability CVE-2026-47857 in dependency `io.projectreactor:reactor-core:jar:3.7.18:compile`
* #146: Fixed vulnerability CVE-2026-47863 in dependency `io.projectreactor:reactor-core:jar:3.7.18:compile`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.azure:azure-storage-blob:12.35.0` to `12.35.1`

### Test Dependency Updates

* Updated `org.junit.jupiter:junit-jupiter-params:5.14.4` to `6.1.3`
