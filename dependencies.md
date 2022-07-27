<!-- @formatter:off -->
# Dependencies

## Compile Dependencies

| Dependency                                           | License                                       |
| ---------------------------------------------------- | --------------------------------------------- |
| [Jackson-core][0]                                    | [The Apache Software License, Version 2.0][1] |
| [Jackson-annotations][2]                             | [The Apache Software License, Version 2.0][1] |
| [Virtual Schema for document data in files][4]       | [MIT License][5]                              |
| [error-reporting-java][6]                            | [MIT][7]                                      |
| [Microsoft Azure client library for Blob Storage][8] | [The MIT License (MIT)][9]                    |
| [Project Lombok][10]                                 | [The MIT License][11]                         |

## Test Dependencies

| Dependency                                      | License                           |
| ----------------------------------------------- | --------------------------------- |
| [Hamcrest][12]                                  | [BSD License 3][13]               |
| [Virtual Schema for document data in files][4]  | [MIT License][5]                  |
| [JUnit Jupiter Engine][16]                      | [Eclipse Public License v2.0][17] |
| [JUnit Jupiter Params][16]                      | [Eclipse Public License v2.0][17] |
| [mockito-core][20]                              | [The MIT License][21]             |
| [Testcontainers :: JUnit Jupiter Extension][22] | [MIT][9]                          |
| [Test Database Builder for Java][24]            | [MIT License][25]                 |
| [udf-debugging-java][26]                        | [MIT][7]                          |
| [Matcher for SQL Result Sets][28]               | [MIT][7]                          |
| [exasol-test-setup-abstraction-java][30]        | [MIT License][31]                 |
| [SnakeYAML][32]                                 | [Apache License, Version 2.0][1]  |
| [Performance Test Recorder Java][34]            | [MIT][7]                          |
| [JaCoCo :: Agent][36]                           | [Eclipse Public License 2.0][37]  |

## Plugin Dependencies

| Dependency                                              | License                                       |
| ------------------------------------------------------- | --------------------------------------------- |
| [SonarQube Scanner for Maven][38]                       | [GNU LGPL 3][39]                              |
| [Apache Maven Compiler Plugin][40]                      | [Apache License, Version 2.0][41]             |
| [Apache Maven Enforcer Plugin][42]                      | [Apache License, Version 2.0][41]             |
| [Maven Flatten Plugin][44]                              | [Apache Software Licenese][1]                 |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][46] | [ASL2][1]                                     |
| [Reproducible Build Maven Plugin][48]                   | [Apache 2.0][1]                               |
| [Maven Surefire Plugin][50]                             | [Apache License, Version 2.0][41]             |
| [Versions Maven Plugin][52]                             | [Apache License, Version 2.0][41]             |
| [Project keeper maven plugin][54]                       | [The MIT License][55]                         |
| [Apache Maven Assembly Plugin][56]                      | [Apache License, Version 2.0][41]             |
| [Apache Maven JAR Plugin][58]                           | [Apache License, Version 2.0][41]             |
| [Artifact reference checker and unifier][60]            | [MIT][7]                                      |
| [Apache Maven Dependency Plugin][62]                    | [Apache License, Version 2.0][41]             |
| [Lombok Maven Plugin][64]                               | [The MIT License][7]                          |
| [Maven Failsafe Plugin][66]                             | [Apache License, Version 2.0][41]             |
| [JaCoCo :: Maven Plugin][68]                            | [Eclipse Public License 2.0][37]              |
| [error-code-crawler-maven-plugin][70]                   | [MIT][7]                                      |
| [Maven Clean Plugin][72]                                | [The Apache Software License, Version 2.0][1] |
| [Maven Resources Plugin][74]                            | [The Apache Software License, Version 2.0][1] |
| [Maven Install Plugin][76]                              | [The Apache Software License, Version 2.0][1] |
| [Maven Deploy Plugin][78]                               | [The Apache Software License, Version 2.0][1] |
| [Maven Site Plugin 3][80]                               | [The Apache Software License, Version 2.0][1] |

[36]: https://www.eclemma.org/jacoco/index.html
[6]: https://github.com/exasol/error-reporting-java
[1]: http://www.apache.org/licenses/LICENSE-2.0.txt
[10]: https://projectlombok.org
[50]: https://maven.apache.org/surefire/maven-surefire-plugin/
[72]: http://maven.apache.org/plugins/maven-clean-plugin/
[7]: https://opensource.org/licenses/MIT
[20]: https://github.com/mockito/mockito
[44]: https://www.mojohaus.org/flatten-maven-plugin/
[52]: http://www.mojohaus.org/versions-maven-plugin/
[54]: https://github.com/exasol/project-keeper/
[13]: http://opensource.org/licenses/BSD-3-Clause
[40]: https://maven.apache.org/plugins/maven-compiler-plugin/
[25]: https://github.com/exasol/test-db-builder-java/blob/main/LICENSE
[30]: https://github.com/exasol/exasol-test-setup-abstraction-java/
[37]: https://www.eclipse.org/legal/epl-2.0/
[2]: http://github.com/FasterXML/jackson
[39]: http://www.gnu.org/licenses/lgpl.txt
[68]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[21]: https://github.com/mockito/mockito/blob/main/LICENSE
[11]: https://projectlombok.org/LICENSE
[28]: https://github.com/exasol/hamcrest-resultset-matcher
[48]: http://zlika.github.io/reproducible-build-maven-plugin
[31]: https://github.com/exasol/exasol-test-setup-abstraction-java/blob/main/LICENSE
[38]: http://sonarsource.github.io/sonar-scanner-maven/
[26]: https://github.com/exasol/udf-debugging-java/
[16]: https://junit.org/junit5/
[32]: https://bitbucket.org/snakeyaml/snakeyaml
[4]: https://github.com/exasol/virtual-schema-common-document-files/
[12]: http://hamcrest.org/JavaHamcrest/
[74]: http://maven.apache.org/plugins/maven-resources-plugin/
[60]: https://github.com/exasol/artifact-reference-checker-maven-plugin
[0]: https://github.com/FasterXML/jackson-core
[58]: https://maven.apache.org/plugins/maven-jar-plugin/
[24]: https://github.com/exasol/test-db-builder-java/
[66]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[34]: https://github.com/exasol/performance-test-recorder-java
[9]: http://opensource.org/licenses/MIT
[55]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[62]: https://maven.apache.org/plugins/maven-dependency-plugin/
[41]: https://www.apache.org/licenses/LICENSE-2.0.txt
[42]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[8]: https://github.com/Azure/azure-sdk-for-java
[17]: https://www.eclipse.org/legal/epl-v20.html
[76]: http://maven.apache.org/plugins/maven-install-plugin/
[46]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[5]: https://github.com/exasol/virtual-schema-common-document-files/blob/main/LICENSE
[22]: https://testcontainers.org
[64]: https://anthonywhitford.com/lombok.maven/lombok-maven-plugin/
[78]: http://maven.apache.org/plugins/maven-deploy-plugin/
[80]: http://maven.apache.org/plugins/maven-site-plugin/
[70]: https://github.com/exasol/error-code-crawler-maven-plugin
[56]: https://maven.apache.org/plugins/maven-assembly-plugin/
