# Virtual Schema for Document Data in Files on Azure Blob Storage 3.1.1, released 2026-??-??

Code name: Fixed vulnerabilities CVE-2026-100655, CVE-2026-100656, CVE-2026-100658, CVE-2026-100666, CVE-2026-93488, CVE-2026-93491, CVE-2026-93558, CVE-2026-93562, CVE-2026-93565, CVE-2026-93574, CVE-2026-93566, CVE-2026-93573, CVE-2026-93492, CVE-2026-93567, CVE-2026-93568, CVE-2026-93579, CVE-2026-100659, CVE-2026-100660, CVE-2026-100661, CVE-2026-100662, CVE-2026-100663, CVE-2026-100664, CVE-2026-93568, CVE-2026-93451, CVE-2026-93452, CVE-2026-100665, CVE-2026-89407, CVE-2026-89425

## Summary

This release fixes the following 28 vulnerabilities:

### CVE-2026-100655 (CWE-770) in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:compile`
Netty (io.netty:netty-codec-http) versions up to and including 4.1.137.Final and from 4.2.0.Final through 4.2.17.Final accept an unlimited number of concurrent remote-initiated SPDY streams: SpdySessionHandler defaults localConcurrentStreams to Integer.MAX_VALUE and exposes no API to change it. A remote peer that opens a SPDY connection and sends millions of SYN_STREAM frames with FLAG_FIN=0 causes the server to allocate unbounded heap and direct memory, eventually triggering a JVM OutOfMemoryError and crashing the service. Fixed in 4.1.138.Final and 4.2.18.Final.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-100655?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-100655
* https://github.com/CVEProject/cvelistV5/blob/main/cves/2026/100xxx/CVE-2026-100655.json

### CVE-2026-100656 (CWE-770) in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:compile`
Netty (io.netty:netty-codec-http) contains an unbounded per-connection queue growth flaw in HttpServerCodec. The codec tracks the HTTP method of each still-unanswered pipelined request; the first 32 entries are bit-packed into a single long, but every additional entry is appended to methodOverflowQueue, an ArrayDeque with no size limit and no rejection path. A remote, unauthenticated attacker who pipelines HTTP/1.1 requests on a single connection while withholding reads on their own end (preventing responses from being flushed) can grow this queue without bound, causing unbounded heap growth and denial of service. Affected versions are 4.2.0.Final through 4.2.17.Final and all releases up to and including 4.1.137.Final; the issue is fixed in 4.2.18.Final and 4.1.138.Final.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-100656?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-100656
* https://github.com/CVEProject/cvelistV5/blob/main/cves/2026/100xxx/CVE-2026-100656.json

### CVE-2026-100658 (CWE-770) in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:compile`
Netty (io.netty:netty-codec-http) contains an unbounded per-connection queue in WebSocketServerExtensionHandler. The handler offers an entry to its per-channel validExtensions queue for every inbound HttpRequest, but polls an entry only when the application writes an HttpResponse, and the queue size is never bounded. A remote, unauthenticated peer can use HTTP/1.1 pipelining to send requests faster than the application produces responses â including plain non-upgrade HTTP requests to any path â causing the queue to grow without limit until the JVM exhausts heap memory and terminates with OutOfMemoryError. Because the affected handler is the base class of WebSocketServerCompressionHandler, any server that enables permessage-deflate is exposed on its plain HTTP port before any WebSocket upgrade completes and before any application-level authentication. Affected versions are 4.1.88.Final through 4.1.137.Final and 4.2.0.Final through 4.2.17.Final; the issue is fixed in 4.1.138.Final and 4.2.18.Final.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-100658?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-100658
* https://github.com/CVEProject/cvelistV5/blob/main/cves/2026/100xxx/CVE-2026-100658.json

### CVE-2026-100666 (CWE-444) in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:compile`
Netty's HttpServerCodec (io.netty:netty-codec-http) in versions 4.2.0.Final through 4.2.16.Final and in versions up to and including 4.1.136.Final pairs each outbound response with an inbound request by calling pollMethod() once per response, including for 1xx informational responses. If a client pipelines an HTTP/1.1 GET carrying an Expect: 100-continue header followed by a HEAD request, the 100 Continue response consumes the queued GET method, so the subsequent 200 OK for the GET is paired with HEAD and its body is dropped, while the following 200 OK for the HEAD request is written with a body. This desynchronizes HTTP parsing on the connection: the GET entity is never delivered and the HEAD response body is interpreted as the GET body, resulting in response splitting and unsafe connection reuse. Fixed in 4.2.17.Final and 4.1.137.Final.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-100666?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-100666
* https://github.com/CVEProject/cvelistV5/blob/main/cves/2026/100xxx/CVE-2026-100666.json

### CVE-2026-93488 (CWE-770) in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:compile`
A flaw was found in Netty. SpdySessionHandler accepts an unlimited number of concurrent remote-initiated streams because localConcurrentStreams defaults to Integer.MAX_VALUE and the handler provides no API to change it. A remote peer can open a SPDY connection and send a large number of SYN_STREAM frames with FLAG_FIN=0, causing unbounded heap and direct memory allocation that can lead to JVM OutOfMemoryError and a denial of service.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-93488?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-93488
* https://github.com/netty/netty/security/advisories/GHSA-rmcw-9fcq-wjq7
* https://bugzilla.redhat.com/show_bug.cgi?id=2536887

### CVE-2026-93491 (CWE-770) in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:compile`
A flaw was found in Netty's HttpServerCodec. A remote, unauthenticated attacker can exploit this vulnerability by pipelining HTTP/1.1 requests on a single connection and withholding reads. This action causes the methodOverflowQueue to grow without limit, leading to unbounded heap memory consumption and a denial of service due to memory exhaustion.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-93491?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-93491
* https://bugzilla.redhat.com/show_bug.cgi?id=2536891
* https://github.com/netty/netty/releases/tag/netty-4.1.138.Final
* https://github.com/netty/netty/releases/tag/netty-4.2.18.Final

### CVE-2026-93558 (CWE-1035) in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:compile`
A flaw was found in Netty's WebSocketServerExtensionHandler. A remote, unauthenticated attacker can exploit this vulnerability by using HTTP/1.1 pipelining to send requests faster than the application can respond. This leads to an unbounded growth of a per-connection queue, consuming excessive memory. Eventually, this can cause the Java Virtual Machine (JVM) to exhaust its heap, resulting in a Denial of Service (DoS) for the affected server.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-93558?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-93558
* https://github.com/netty/netty/security/advisories/GHSA-2g37-3h88-55hc

### CVE-2026-93562 (CWE-1035) in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:compile`
A flaw was found in Netty's HTTP/1 decoder. Incomplete validation of malformed Transfer-Encoding headers allows a remote attacker to perform HTTP request smuggling. By sending specially crafted HTTP requests, an attacker can inject arbitrary HTTP requests, potentially bypassing security controls or accessing unauthorized resources.

Sonatype's research suggests that this CVE's details differ from those defined at NVD. See https://guide.sonatype.com/vulnerability/CVE-2026-93562 for details
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-93562?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-93562
* https://github.com/netty/netty/security/advisories/GHSA-hcvj-94mj-jp5c
* https://bugzilla.redhat.com/show_bug.cgi?id=2536951

### CVE-2026-93565 (CWE-1035) in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:compile`
A flaw was found in Netty RtspDecoder. The `RtspMethods.valueOf()` function incorrectly strips trailing control bytes from method tokens in Real-Time Streaming Protocol (RTSP) requests. A remote attacker can exploit this by sending a specially crafted RTSP request, leading to method-token smuggling. This vulnerability allows an attacker to bypass method-based access controls and can also be used to launder malicious requests through Netty-based RTSP proxies, making them appear legitimate to backend systems.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-93565?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-93565
* https://github.com/netty/netty/security/advisories/GHSA-h75q-xqrh-59rf
* https://bugzilla.redhat.com/show_bug.cgi?id=2536952

### CVE-2026-93574 (CWE-444) in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:compile`
A flaw was found in Netty's `netty-codec-http` component. A remote attacker could exploit this vulnerability by sending a specially crafted HTTP/1.1 chunk-size token that includes post-digit whitespace. This incorrect parsing of the chunk size can lead to HTTP request smuggling. This allows an attacker to bypass security controls or access unauthorized resources in proxy/backend deployments.

Sonatype's research suggests that this CVE's details differ from those defined at NVD. See https://guide.sonatype.com/vulnerability/CVE-2026-93574 for details
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-93574?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-93574
* https://github.com/netty/netty/security/advisories/GHSA-j4mg-hqgv-34qc

### CVE-2026-93566 (CWE-444) in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:compile`
io.netty:netty-codec-http - HTTP Request/Response Smuggling
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-93566?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-93566
* https://github.com/netty/netty/security/advisories/GHSA-rq4j-fc47-9698

### CVE-2026-93573 (CWE-436) in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:compile`
io.netty:netty-codec-http - Interpretation Conflict [CVE-2026-93573]
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-93573?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-93573
* https://github.com/netty/netty/security/advisories/GHSA-3jrc-fchc-59pw

### CVE-2026-93492 (CWE-1035) in dependency `io.netty:netty-codec-http2:jar:4.2.16.Final:compile`
A flaw was found in Netty's HTTP/2 HpackEncoder. A remote attacker can exploit this by sending HTTP/2 SETTINGS frames with a very large MAX_HEADER_TABLE_SIZE. This causes the HpackEncoder to store an excessive number of unique headers, leading to increased CPU usage and memory consumption, ultimately resulting in a Denial of Service (DoS).
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-93492?component-type=maven&component-name=io.netty%2Fnetty-codec-http2&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-93492
* https://github.com/netty/netty/security/advisories/GHSA-8352-h356-c9qh
* https://access.redhat.com/security/cve/CVE-2026-93492
* https://bugzilla.redhat.com/show_bug.cgi?id=2536895

### CVE-2026-93567 (CWE-20) in dependency `io.netty:netty-codec-http2:jar:4.2.16.Final:compile`
A flaw was found in Netty's HTTP/2 codec. When converting HTTP/1 CONNECT requests to HTTP/2, the component incorrectly uses the Host header instead of the CONNECT authority-form request-target for the tunnel authority. A remote attacker can exploit this by supplying a different Host header, leading to a malformed HTTP/2 CONNECT request. This can bypass security controls such as tunnel allow-lists or egress policies, resulting in integrity loss.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-93567?component-type=maven&component-name=io.netty%2Fnetty-codec-http2&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-93567
* https://access.redhat.com/security/cve/CVE-2026-93567
* https://bugzilla.redhat.com/show_bug.cgi?id=2536955

### CVE-2026-93568 (CWE-20) in dependency `io.netty:netty-codec-http2:jar:4.2.16.Final:compile`
A flaw was found in Netty. A remote attacker could exploit this vulnerability by sending specially crafted HTTP/2 or HTTP/3 Extended CONNECT requests. Netty's HTTP-object conversion path incorrectly processes these requests as regular HTTP/1.1 CONNECT requests, leading to a loss of critical protocol and path information. This misinterpretation can allow attackers to bypass security policies, such as routing or authorization logic, in applications that rely on Netty for HTTP/2 or HTTP/3 communication, resulting in integrity loss.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-93568?component-type=maven&component-name=io.netty%2Fnetty-codec-http2&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-93568
* https://github.com/netty/netty/security/advisories/GHSA-w6j8-x45j-w75f
* https://bugzilla.redhat.com/show_bug.cgi?id=2536961

### CVE-2026-93579 (CWE-1035) in dependency `io.netty:netty-codec-http2:jar:4.2.16.Final:compile`
A flaw was found in Netty's HTTP/2 stack. This vulnerability allows a remote attacker to inject prohibited characters, such as NUL, Line Feed, and Carriage Return, into HTTP/2 header field values due to insufficient validation. When these values cross an HTTP/2 to HTTP/1.1 translation boundary, they can be exploited for request smuggling, header injection, or response splitting. This could lead to unauthorized access, data manipulation, or other security bypasses.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-93579?component-type=maven&component-name=io.netty%2Fnetty-codec-http2&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-93579
* https://bugzilla.redhat.com/show_bug.cgi?id=2536970
* https://github.com/netty/netty/security/advisories/GHSA-8whp-c7w8-2m72

### CVE-2026-100659 (CWE-444) in dependency `io.netty:netty-codec-http3:jar:4.2.16.Final:compile`
Netty's HTTP/3 codec (io.netty:netty-codec-http3) in versions 4.2.0.Final through 4.2.17.Final does not enforce the RFC 9114 requirement that the :authority pseudo-header field and a literal host header field, when both present, carry the same value. A remote unauthenticated peer can send a single HEADERS frame containing both fields with differing, attacker-controlled values; the request is accepted and delivered to the application with two conflicting authorities, allowing routing, virtual-host, and access-control decisions to be bypassed when different components in the request path consult different fields. This issue is fixed in 4.2.18.Final.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-100659?component-type=maven&component-name=io.netty%2Fnetty-codec-http3&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-100659
* https://github.com/CVEProject/cvelistV5/blob/main/cves/2026/100xxx/CVE-2026-100659.json

### CVE-2026-100660 (CWE-770) in dependency `io.netty:netty-codec-http3:jar:4.2.16.Final:compile`
Netty's HTTP/3 codec (io.netty:netty-codec-http3) from 4.2.0.Final through 4.2.17.Final retains unbounded per-stream QPACK encoder state. QpackEncoder stores a queue and a dynamic-table index tracker for every encoded field section that references the QPACK dynamic table, keyed by the peer-controlled QUIC stream ID, and these entries are released only when the remote decoder sends a Section Acknowledgment or Stream Cancellation instruction â not when the HTTP/3 stream completes. There is no limit on the number of tracked streams, field sections, or retained bytes. A remote, unauthenticated HTTP/3 client can advertise a non-zero QPACK dynamic-table capacity, acknowledge the table insertion so the server reuses a dynamically indexed response header, and then omit all mandatory Section Acknowledgments while issuing sequential requests over a single QUIC connection, bypassing concurrent-stream limits and causing unbounded heap growth until the server exhausts memory (denial of service). Fixed in 4.2.18.Final.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-100660?component-type=maven&component-name=io.netty%2Fnetty-codec-http3&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-100660
* https://github.com/CVEProject/cvelistV5/blob/main/cves/2026/100xxx/CVE-2026-100660.json

### CVE-2026-100661 (CWE-400) in dependency `io.netty:netty-codec-http3:jar:4.2.16.Final:compile`
Netty's HTTP/3 codec (io.netty:netty-codec-http3) versions 4.2.0.Final through 4.2.17.Final contain a denial-of-service vulnerability in the QPACK prefixed-integer decoder (QpackUtil.decodePrefixedInteger), which does not bound the number of continuation bytes it will process. A remote, unauthenticated peer can open a QPACK unidirectional stream (type 0x02 encoder or 0x03 decoder) and send a first byte with all prefix bits set (e.g. 0xFF for a 7-bit prefix or 0x3F for a 5-bit prefix) followed by an endless run of 0x80 continuation bytes. The decoder returns -1 ('need more bytes'), so callers never consume the input, the ByteToMessageDecoder cumulator grows without bound, and each decode() invocation re-scans the whole accumulated buffer, yielding O(N^2) CPU cost. The result is unbounded per-connection heap growth (OutOfMemoryError) and event-loop CPU starvation, reachable in every configuration. Fixed in 4.2.18.Final.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-100661?component-type=maven&component-name=io.netty%2Fnetty-codec-http3&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-100661
* https://github.com/CVEProject/cvelistV5/blob/main/cves/2026/100xxx/CVE-2026-100661.json

### CVE-2026-100662 (CWE-400) in dependency `io.netty:netty-codec-http3:jar:4.2.16.Final:compile`
Netty's HTTP/3 codec (io.netty:netty-codec-http3) versions 4.2.0.Final through 4.2.17.Final contain an uncontrolled resource consumption vulnerability in the QPACK encoder-stream instruction decoder (QpackEncoderHandler, installed on the peer-initiated unidirectional QPACK encoder stream, type 0x02). The handler accepts an attacker-declared string-literal length of up to Integer.MAX_VALUE (~2 GiB) for the Name Length and Value Length fields of the "Insert With Literal Name" instruction (RFC 9204 Â§4.3.3), with no per-instruction or per-literal length cap and no cumulation-size limit; the existing HTTP/3 limits (maxHeaderListSize, maxUnknownFramePayloadLength, DEFAULT_MAX_FIELD_SECTION_SIZE) are not applied to this handler. A remote, unauthenticated peer with an established HTTP/3 connection to a default Netty HTTP/3 server can declare a very large literal length and then trickle fewer bytes than declared, causing the ByteToMessageDecoder MERGE cumulator to retain and grow the per-connection buffer, and ultimately triggering a large byte-array allocation. This leads to unbounded per-connection heap growth and OutOfMemoryError, resulting in denial of service. Fixed in 4.2.18.Final.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-100662?component-type=maven&component-name=io.netty%2Fnetty-codec-http3&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-100662
* https://github.com/CVEProject/cvelistV5/blob/main/cves/2026/100xxx/CVE-2026-100662.json

### CVE-2026-100663 (CWE-20) in dependency `io.netty:netty-codec-http3:jar:4.2.16.Final:compile`
Netty's HTTP/3 codec (io.netty:netty-codec-http3) from 4.2.2.Final through 4.2.17.Final does not special-case HTTP/1 CONNECT authority-form request-targets when converting HTTP/1 messages to HTTP/3 in HttpConversionUtil.toHttp3Headers. The authority-form target (e.g., "CONNECT trusted.example:443") is parsed as a URI, so its host is emitted as :scheme, :path is set to "/", and the HTTP/1 Host header is used as :authority; if no Host header is present the CONNECT target is dropped. In a Netty-based HTTP/1-to-HTTP/3 proxy or gateway, a remote client can send a CONNECT request whose Host header names a different authority than the request-target, producing a malformed HTTP/3 CONNECT whose tunnel :authority is attacker-controlled. This can bypass tunnel allow-lists, egress policy, backend selection, or audit controls that validate the HTTP/1 CONNECT request-target before forwarding over HTTP/3. The issue is fixed in 4.2.18.Final.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-100663?component-type=maven&component-name=io.netty%2Fnetty-codec-http3&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-100663
* https://github.com/CVEProject/cvelistV5/blob/main/cves/2026/100xxx/CVE-2026-100663.json

### CVE-2026-100664 (CWE-20) in dependency `io.netty:netty-codec-http3:jar:4.2.16.Final:compile`
Netty's HTTP/3 codec (io.netty:netty-codec-http3) versions 4.2.2.Final through 4.2.17.Final builds the HTTP/3 :authority pseudo-header from the HTTP/1 Host header before considering the authority of an absolute-form HTTP/1 request-target. In HttpConversionUtil.toHttp3Headers(HttpMessage, boolean) â reached via Http3FrameToHttpObjectCodec(false) â a non-empty Host header takes precedence over the request-target authority, contrary to the HTTP/1.1 rule that a server receiving an absolute-form request-target must ignore the Host header. In a Netty-based HTTP/1-to-HTTP/3 gateway, proxy, or protocol bridge, a remote client can send a request such as "GET https://trusted.example/admin HTTP/1.1" with "Host: attacker.example", causing components that validate, authorize, or route on the RFC-defined request-target authority to reach a different decision than the upstream HTTP/3 peer, which receives :authority derived from the conflicting Host header. This authority confusion can affect virtual-host routing, allow-list checks, backend selection, cache keys, and URL generation. The advisory reports integrity impact only (no code execution, memory corruption, or availability impact). Fixed in 4.2.18.Final.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-100664?component-type=maven&component-name=io.netty%2Fnetty-codec-http3&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-100664
* https://github.com/CVEProject/cvelistV5/blob/main/cves/2026/100xxx/CVE-2026-100664.json

### CVE-2026-93568 (CWE-20) in dependency `io.netty:netty-codec-http3:jar:4.2.16.Final:compile`
A flaw was found in Netty. A remote attacker could exploit this vulnerability by sending specially crafted HTTP/2 or HTTP/3 Extended CONNECT requests. Netty's HTTP-object conversion path incorrectly processes these requests as regular HTTP/1.1 CONNECT requests, leading to a loss of critical protocol and path information. This misinterpretation can allow attackers to bypass security policies, such as routing or authorization logic, in applications that rely on Netty for HTTP/2 or HTTP/3 communication, resulting in integrity loss.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-93568?component-type=maven&component-name=io.netty%2Fnetty-codec-http3&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-93568
* https://github.com/netty/netty/security/advisories/GHSA-w6j8-x45j-w75f
* https://bugzilla.redhat.com/show_bug.cgi?id=2536961

### CVE-2026-93451 (CWE-787) in dependency `org.xerial.snappy:snappy-java:jar:1.1.10.7:compile`
snappy-java through 1.1.10.8 contains a buffer overflow vulnerability in typed Snappy.uncompress*Array methods that allocate output arrays by dividing uncompressed length by element size but pass the undivided length to native code. Attackers controlling compressed input can cause misaligned length values to write past array bounds with attacker-controlled bytes, corrupting heap memory.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-93451?component-type=maven&component-name=org.xerial.snappy%2Fsnappy-java&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-93451
* https://github.com/xerial/snappy-java/issues/729

### CVE-2026-93452 (CWE-787) in dependency `org.xerial.snappy:snappy-java:jar:1.1.10.7:compile`
snappy-java through 1.1.10.8 contains a buffer overflow vulnerability in Snappy.compress(ByteBuffer, ByteBuffer) that writes past the end of the destination buffer. Attackers can supply incompressible data that exceeds the destination buffer's remaining capacity, corrupting off-heap memory and causing JVM termination.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-93452?component-type=maven&component-name=org.xerial.snappy%2Fsnappy-java&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-93452
* https://github.com/xerial/snappy-java/issues/732

### CVE-2026-100665 (CWE-295) in dependency `io.netty:netty-codec-classes-quic:jar:4.2.16.Final:compile`
Netty versions from 4.2.11.Final before 4.2.18.Final contain an incomplete hostname verification fix in the QUIC certificate verification path when using a plain X509TrustManager. The BoringSSLCertificateVerifyCallback discards the SSLEngine for plain trust managers, preventing endpoint identification from running even when HTTPS verification is configured. Attackers on the network path can present a certificate chain for the wrong hostname that the plain trust manager accepts, bypassing hostname authentication for QUIC clients.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-100665?component-type=maven&component-name=io.netty%2Fnetty-codec-classes-quic&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-100665
* https://github.com/CVEProject/cvelistV5/blob/main/cves/2026/100xxx/CVE-2026-100665.json

### CVE-2026-89407 (CWE-1333) in dependency `com.fasterxml.jackson.core:jackson-core:jar:2.22.1:compile`
NumberInput.looksLikeValidNumber() in FasterXML jackson-core pre-validates "stringified numbers" with two regular expressions: PATTERN_FLOAT ([+-]?[0-9]*[\.]?[0-9]+([eE][+-]?[0-9]+)?), present since 2.17.0, and PATTERN_FLOAT_TRAILING_DOT, added in 2.17.2. PATTERN_FLOAT places adjacent quantifiers over the same character class -- an optional [0-9]* run, an optional dot, then a required [0-9]+ run -- so input that ultimately fails to match forces Java's backtracking engine to retry every possible split point of the digit run.Â 

Matching cost therefore grows with the square of the input length.Â 

An attacker who can supply JSON that an application deserializes into a numeric target type reaches this method through jackson-databind's default String-to-number coercion (StdDeserializer and NumberDeserializers for BigDecimal, BigInteger, Double and Float).Â 

Because StreamReadConstraints.maxStringLength defaults to 20,000,000 characters, no constraint bounds the input before it reaches the regex.Â 

Testing by the reporter confirmed O(n^2) growth across five consecutive input-size doublings, with a single 160,000-character string consuming roughly 74 seconds in one call; a small number of concurrent requests of ordinary body size can therefore exhaust a server's request-handling thread pool.Â 

The affected method does not exist before 2.17.0, so 2.16.x and earlier releases are not affected.Â 

The fix replaces both regular expressions with a hand-rolled single-pass scan.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-89407?component-type=maven&component-name=com.fasterxml.jackson.core%2Fjackson-core&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-89407
* https://github.com/FasterXML/jackson-core/security/advisories/GHSA-p6pp-m3f8-5c89

### CVE-2026-89425 (CWE-400) in dependency `com.fasterxml.jackson.core:jackson-core:jar:2.22.1:compile`
UTF8DataInputJsonParser._reportInvalidToken() in FasterXML jackson-core builds the offending-token text for its error message by appending Java identifier characters to a StringBuilder in a loop that has no upper bound. Unlike the three sibling parser implementations, including UTF8StreamJsonParser, it never consults ErrorReportConfiguration.getMaxErrorTokenLength() (default 256). A malformed token supplied to a parser created through JsonFactory.createParser(DataInput) is therefore accumulated in full. No StreamReadConstraints setting mitigates this: maxDocumentLength cannot be applied to DataInput sources at all, and maxStringLength does not cover this path because the accumulation bypasses ReadConstrainedTextBuffer. The reporter measured a 20,000,109-character exception message from a 20-million-character malformed token on the DataInput path, against 367 characters for identical input on the InputStream path. Scaling the payload drives the StringBuilder, which also incurs byte-to-char expansion and internal array doubling, to many times the raw payload size and can trigger OutOfMemoryError for the whole JVM. UTF8DataInputJsonParser was introduced in 2.8.0 together with createParser(DataInput); releases before 2.8.0 do not contain the affected class.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-89425?component-type=maven&component-name=com.fasterxml.jackson.core%2Fjackson-core&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-89425
* https://github.com/FasterXML/jackson-core/security/advisories/GHSA-7hhh-6rmp-j9qf

## Security

* #167: Fixed vulnerability CVE-2026-100655 in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:compile`
* #168: Fixed vulnerability CVE-2026-100656 in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:compile`
* #169: Fixed vulnerability CVE-2026-100658 in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:compile`
* #170: Fixed vulnerability CVE-2026-100666 in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:compile`
* #171: Fixed vulnerability CVE-2026-93488 in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:compile`
* #172: Fixed vulnerability CVE-2026-93491 in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:compile`
* #173: Fixed vulnerability CVE-2026-93558 in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:compile`
* #174: Fixed vulnerability CVE-2026-93562 in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:compile`
* #175: Fixed vulnerability CVE-2026-93565 in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:compile`
* #176: Fixed vulnerability CVE-2026-93574 in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:compile`
* #177: Fixed vulnerability CVE-2026-93566 in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:compile`
* #178: Fixed vulnerability CVE-2026-93573 in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:compile`
* #179: Fixed vulnerability CVE-2026-93492 in dependency `io.netty:netty-codec-http2:jar:4.2.16.Final:compile`
* #180: Fixed vulnerability CVE-2026-93567 in dependency `io.netty:netty-codec-http2:jar:4.2.16.Final:compile`
* #181: Fixed vulnerability CVE-2026-93568 in dependency `io.netty:netty-codec-http2:jar:4.2.16.Final:compile`
* #182: Fixed vulnerability CVE-2026-93579 in dependency `io.netty:netty-codec-http2:jar:4.2.16.Final:compile`
* #183: Fixed vulnerability CVE-2026-100659 in dependency `io.netty:netty-codec-http3:jar:4.2.16.Final:compile`
* #184: Fixed vulnerability CVE-2026-100660 in dependency `io.netty:netty-codec-http3:jar:4.2.16.Final:compile`
* #185: Fixed vulnerability CVE-2026-100661 in dependency `io.netty:netty-codec-http3:jar:4.2.16.Final:compile`
* #186: Fixed vulnerability CVE-2026-100662 in dependency `io.netty:netty-codec-http3:jar:4.2.16.Final:compile`
* #187: Fixed vulnerability CVE-2026-100663 in dependency `io.netty:netty-codec-http3:jar:4.2.16.Final:compile`
* #188: Fixed vulnerability CVE-2026-100664 in dependency `io.netty:netty-codec-http3:jar:4.2.16.Final:compile`
* #189: Fixed vulnerability CVE-2026-93568 in dependency `io.netty:netty-codec-http3:jar:4.2.16.Final:compile`
* #190: Fixed vulnerability CVE-2026-93451 in dependency `org.xerial.snappy:snappy-java:jar:1.1.10.7:compile`
* #191: Fixed vulnerability CVE-2026-93452 in dependency `org.xerial.snappy:snappy-java:jar:1.1.10.7:compile`
* #192: Fixed vulnerability CVE-2026-100665 in dependency `io.netty:netty-codec-classes-quic:jar:4.2.16.Final:compile`
* #193: Fixed vulnerability CVE-2026-89407 in dependency `com.fasterxml.jackson.core:jackson-core:jar:2.22.1:compile`
* #194: Fixed vulnerability CVE-2026-89425 in dependency `com.fasterxml.jackson.core:jackson-core:jar:2.22.1:compile`

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
