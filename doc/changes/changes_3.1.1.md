# Virtual Schema for Document Data in Files on Azure Blob Storage 3.1.1, released 2026-??-??

Code name: Fixed vulnerabilities CVE-2026-62380, CVE-2026-75595, CVE-2026-62243

## Summary

This release fixes the following 3 vulnerabilities:

### CVE-2026-62380 (CWE-626) in dependency `io.netty:netty-codec-socks:jar:4.2.16.Final:compile`
io.netty:netty-codec-socks - Null Byte Interaction Error (Poison Null Byte)
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-62380?component-type=maven&component-name=io.netty%2Fnetty-codec-socks&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-62380
* https://github.com/netty/netty/security/advisories/GHSA-cc6x-ffm5-83wf

### CVE-2026-75595 (CWE-754) in dependency `io.netty:netty-handler:jar:4.2.16.Final:compile`
Netty is an asynchronous, event-driven network application framework. Prior to 4.1.137.Fina and 4.2.17.Final, io.netty.handler.ssl.SslClientHelloHandler#decode checks the wrong offset before reading the four-byte TLS handshake header, so a ClientHello whose handshake header spans records can cause an IndexOutOfBoundsException and invoke select(ctx, null). This selects the default SslContext instead of the SNI-specific context. In deployments where per-SNI clientAuth=REQUIRE is the sole mutual TLS gate, the default SslContext uses clientAuth=NONE or clientAuth=OPTIONAL, and no application-layer certificate verification exists, an unauthenticated remote attacker can bypass the protected route's mutual TLS requirement. This issue is fixed in versions 4.1.137.Final and 4.2.17.Final.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-75595?component-type=maven&component-name=io.netty%2Fnetty-handler&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-75595
* https://github.com/netty/netty/pull/17213
* https://github.com/netty/netty/pull/17217
* https://github.com/netty/netty/security/advisories/GHSA-c4c3-7fpv-j4q5

### CVE-2026-62243 (CWE-297) in dependency `io.netty:netty-handler:jar:4.2.16.Final:compile`
io.netty:netty-handler - Improper Validation of Certificate with Host Mismatch
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-62243?component-type=maven&component-name=io.netty%2Fnetty-handler&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-62243
* https://github.com/netty/netty/security/advisories/GHSA-p85m-gvr3-788c

## Security

* #148: Fixed vulnerability CVE-2026-62380 in dependency `io.netty:netty-codec-socks:jar:4.2.16.Final:compile`
* #149: Fixed vulnerability CVE-2026-75595 in dependency `io.netty:netty-handler:jar:4.2.16.Final:compile`
* #150: Fixed vulnerability CVE-2026-62243 in dependency `io.netty:netty-handler:jar:4.2.16.Final:compile`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.azure:azure-storage-blob:12.35.0` to `12.35.1`

### Test Dependency Updates

* Updated `org.junit.jupiter:junit-jupiter-params:5.14.4` to `6.1.3`
