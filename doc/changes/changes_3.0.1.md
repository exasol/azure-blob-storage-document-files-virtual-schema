# Virtual Schema for document data in files on Azure Blob Storage 3.0.1, released 2026-06-11

Code name: Fixed vulnerabilities CVE-2026-47244, CVE-2026-44249, CVE-2026-45416, CVE-2026-47691, CVE-2026-45674, CVE-2026-45673, CVE-2026-45536, CVE-2026-45536, CVE-2026-42587, CVE-2026-48043, CVE-2026-50560, CVE-2026-41715

## Summary

This release fixes the following 12 vulnerabilities:

### CVE-2026-47244 (CWE-400) in dependency `io.netty:netty-codec-http2:jar:4.2.13.Final:compile`
Netty HTTP/2: Advertised MAX_CONCURRENT_STREAMS are not enforced
#### References
* https://github.com/netty/netty/security/advisories/GHSA-5x3r-wrvg-rp6q
* https://github.com/netty/netty
* https://github.com/netty/netty/releases/tag/netty-4.1.135.Final
* https://github.com/netty/netty/releases/tag/netty-4.2.15.Final

### CVE-2026-44249 (CWE-284, CWE-697) in dependency `io.netty:netty-handler:jar:4.2.13.Final:compile`
Netty has an IPv6 Subnet Filter Bypass via Incorrect Comparator Masking
#### References
* https://github.com/netty/netty/security/advisories/GHSA-3qp7-7mw8-wx86
* https://github.com/netty/netty
* https://github.com/netty/netty/releases/tag/netty-4.1.135.Final
* https://github.com/netty/netty/releases/tag/netty-4.2.15.Final

### CVE-2026-45416 (CWE-770) in dependency `io.netty:netty-handler:jar:4.2.13.Final:compile`
Netty: SNI handler pre-allocates up to 16 MiB from nine attacker bytes
#### References
* https://github.com/netty/netty/security/advisories/GHSA-x4gw-5cx5-pgmh
* https://github.com/netty/netty
* https://github.com/netty/netty/releases/tag/netty-4.1.135.Final
* https://github.com/netty/netty/releases/tag/netty-4.2.15.Final

### CVE-2026-47691 (CWE-345) in dependency `io.netty:netty-resolver-dns:jar:4.2.13.Final:compile`
Netty has Insufficient Bailiwick Validation for NS Records
#### References
* https://github.com/netty/netty/security/advisories/GHSA-5pvg-856g-cp85
* https://github.com/netty/netty
* https://github.com/netty/netty/releases/tag/netty-4.1.135.Final
* https://github.com/netty/netty/releases/tag/netty-4.2.15.Final

### CVE-2026-45674 (CWE-345) in dependency `io.netty:netty-resolver-dns:jar:4.2.13.Final:compile`
Netty Vulnerable to DNS Cache Poisoning via Missing Bailiwick Checks in CNAME Records
#### References
* https://github.com/netty/netty/security/advisories/GHSA-676x-f7gg-47vc
* https://github.com/netty/netty
* https://github.com/netty/netty/releases/tag/netty-4.1.135.Final
* https://github.com/netty/netty/releases/tag/netty-4.2.15.Final

### CVE-2026-45673 (CWE-330, CWE-340) in dependency `io.netty:netty-resolver-dns:jar:4.2.13.Final:compile`
Netty: DNS Cache Poisoning due to Predictable PRNG and Default Static Source Port
#### References
* https://github.com/netty/netty/security/advisories/GHSA-xmv7-r254-6q78
* https://github.com/netty/netty
* https://github.com/netty/netty/releases/tag/netty-4.1.135.Final
* https://github.com/netty/netty/releases/tag/netty-4.2.15.Final

### CVE-2026-45536 (CWE-200, CWE-772) in dependency `io.netty:netty-transport-native-epoll:jar:4.2.13.Final:compile`
Netty: Unix-socket fd receive leaks descriptors when peer sends two at once
#### References
* https://github.com/netty/netty/security/advisories/GHSA-w573-9ffj-6ff9
* https://github.com/netty/netty
* https://github.com/netty/netty/releases/tag/netty-4.1.135.Final
* https://github.com/netty/netty/releases/tag/netty-4.2.15.Final

### CVE-2026-45536 (CWE-200, CWE-772) in dependency `io.netty:netty-transport-native-kqueue:jar:4.2.13.Final:compile`
Netty: Unix-socket fd receive leaks descriptors when peer sends two at once
#### References
* https://github.com/netty/netty/security/advisories/GHSA-w573-9ffj-6ff9
* https://github.com/netty/netty
* https://github.com/netty/netty/releases/tag/netty-4.1.135.Final
* https://github.com/netty/netty/releases/tag/netty-4.2.15.Final

### CVE-2026-42587 (CWE-400) in dependency `io.netty:netty-codec-http:jar:4.2.13.Final:compile`
Netty is an asynchronous, event-driven network application framework. Prior to 4.2.13.Final and 4.1.133.Final, HttpContentDecompressor accepts a maxAllocation parameter to limit decompression buffer size and prevent decompression bomb attacks. This limit is correctly enforced for gzip and deflate encodings via ZlibDecoder, but is silently ignored when the content encoding is br (Brotli), zstd, or snappy. An attacker can bypass the configured decompression limit by sending a compressed payload with Content-Encoding: br instead of Content-Encoding: gzip, causing unbounded memory allocation and out-of-memory denial of service. The same vulnerability exists in DelegatingDecompressorFrameListener for HTTP/2 connections. This vulnerability is fixed in 4.2.13.Final and 4.1.133.Final.

Sonatype's research suggests that this CVE's details differ from those defined at NVD. See https://guide.sonatype.com/vulnerability/CVE-2026-42587 for details
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-42587?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-42587
* https://github.com/advisories/GHSA-f6hv-jmp6-3vwv

### CVE-2026-48043 (CWE-400) in dependency `io.netty:netty-codec-http2:jar:4.2.13.Final:compile`
io.netty : netty-codec-http2 - Denial of Service (DoS)
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-48043?component-type=maven&component-name=io.netty%2Fnetty-codec-http2&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-48043
* https://github.com/netty/netty/security/advisories/GHSA-c2gf-v879-257j

### CVE-2026-50560 (CWE-770) in dependency `io.netty:netty-codec-http2:jar:4.2.13.Final:compile`
Netty - HTTP/2 SETTINGS_MAX_HEADER_LIST_SIZE Handling Denial of Service
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-50560?component-type=maven&component-name=io.netty%2Fnetty-codec-http2&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-50560
* https://github.com/netty/netty/security/advisories/GHSA-563q-j3cm-6jxm

### CVE-2026-41715 (CWE-522) in dependency `io.projectreactor.netty:reactor-netty-http:jar:1.2.16:compile`
In specific scenarios involving HTTP redirects from a secure to an insecure endpoint, the Reactor Netty HTTP client may leak credentials. In order for this to happen, the HTTP client must have been explicitly configured to follow redirects.

Affected versions:
Reactor Netty 1.0.0 through 1.0.51; 1.1.0 through 1.1.35; 1.2.0 through 1.2.17; 1.3.0 through 1.3.5.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-41715?component-type=maven&component-name=io.projectreactor.netty%2Freactor-netty-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-41715
* https://spring.io/security/cve-2026-41715

## Security

* #99: Fixed vulnerability CVE-2026-47244 in dependency `io.netty:netty-codec-http2:jar:4.2.13.Final:compile`
* #100: Fixed vulnerability CVE-2026-44249 in dependency `io.netty:netty-handler:jar:4.2.13.Final:compile`
* #101: Fixed vulnerability CVE-2026-45416 in dependency `io.netty:netty-handler:jar:4.2.13.Final:compile`
* #102: Fixed vulnerability CVE-2026-47691 in dependency `io.netty:netty-resolver-dns:jar:4.2.13.Final:compile`
* #103: Fixed vulnerability CVE-2026-45674 in dependency `io.netty:netty-resolver-dns:jar:4.2.13.Final:compile`
* #104: Fixed vulnerability CVE-2026-45673 in dependency `io.netty:netty-resolver-dns:jar:4.2.13.Final:compile`
* #105: Fixed vulnerability CVE-2026-45536 in dependency `io.netty:netty-transport-native-epoll:jar:4.2.13.Final:compile`
* #105: Fixed vulnerability CVE-2026-45536 in dependency `io.netty:netty-transport-native-kqueue:jar:4.2.13.Final:compile`
* #97: Fixed vulnerability CVE-2026-42587 in dependency `io.netty:netty-codec-http:jar:4.2.13.Final:compile`
* #106: Fixed vulnerability CVE-2026-48043 in dependency `io.netty:netty-codec-http2:jar:4.2.13.Final:compile`
* #107: Fixed vulnerability CVE-2026-50560 in dependency `io.netty:netty-codec-http2:jar:4.2.13.Final:compile`
* #108: Fixed vulnerability CVE-2026-41715 in dependency `io.projectreactor.netty:reactor-netty-http:jar:1.2.16:compile`
