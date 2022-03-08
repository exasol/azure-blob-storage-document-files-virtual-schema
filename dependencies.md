<!-- @formatter:off -->
# Dependencies

## Compile Dependencies

| Dependency                                           | License                                       |
| ---------------------------------------------------- | --------------------------------------------- |
| [Jackson-core][0]                                    | [The Apache Software License, Version 2.0][1] |
| [Jackson-annotations][2]                             | [The Apache Software License, Version 2.0][1] |
| [Virtual Schema for document data in files][4]       | [MIT][5]                                      |
| [error-reporting-java][6]                            | [MIT][5]                                      |
| [Microsoft Azure client library for Blob Storage][8] | [The MIT License (MIT)][9]                    |
| [Project Lombok][10]                                 | [The MIT License][11]                         |

## Test Dependencies

| Dependency                                      | License                           |
| ----------------------------------------------- | --------------------------------- |
| [Hamcrest][12]                                  | [BSD License 3][13]               |
| [Virtual Schema for document data in files][4]  | [MIT][5]                          |
| [JUnit Jupiter Engine][16]                      | [Eclipse Public License v2.0][17] |
| [JUnit Jupiter Params][16]                      | [Eclipse Public License v2.0][17] |
| [mockito-core][20]                              | [The MIT License][21]             |
| [JUnit][22]                                     | [Eclipse Public License 1.0][23]  |
| [Testcontainers :: JUnit Jupiter Extension][24] | [MIT][9]                          |
| [Testcontainers :: Localstack][24]              | [MIT][9]                          |
| [Test Database Builder for Java][28]            | [MIT][5]                          |
| [JaCoCo :: Agent][30]                           | [Eclipse Public License 2.0][31]  |
| [JaCoCo :: Core][30]                            | [Eclipse Public License 2.0][31]  |
| [udf-debugging-java][34]                        | [MIT][5]                          |
| [Matcher for SQL Result Sets][36]               | [MIT][5]                          |
| [exasol-test-setup-abstraction-java][38]        | [MIT][5]                          |
| [SnakeYAML][40]                                 | [Apache License, Version 2.0][1]  |

## Plugin Dependencies

| Dependency                                              | License                                       |
| ------------------------------------------------------- | --------------------------------------------- |
| [Maven Surefire Plugin][42]                             | [Apache License, Version 2.0][43]             |
| [Maven Failsafe Plugin][44]                             | [Apache License, Version 2.0][43]             |
| [JaCoCo :: Maven Plugin][46]                            | [Eclipse Public License 2.0][31]              |
| [Apache Maven Compiler Plugin][48]                      | [Apache License, Version 2.0][43]             |
| [Maven Dependency Plugin][50]                           | [The Apache Software License, Version 2.0][1] |
| [Versions Maven Plugin][52]                             | [Apache License, Version 2.0][43]             |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][54] | [ASL2][1]                                     |
| [Apache Maven Enforcer Plugin][56]                      | [Apache License, Version 2.0][43]             |
| [Artifact reference checker and unifier][58]            | [MIT][5]                                      |
| [Project keeper maven plugin][60]                       | [MIT][5]                                      |
| [error-code-crawler-maven-plugin][62]                   | [MIT][5]                                      |
| [Reproducible Build Maven Plugin][64]                   | [Apache 2.0][1]                               |
| [Apache Maven Assembly Plugin][66]                      | [Apache License, Version 2.0][43]             |
| [Apache Maven JAR Plugin][68]                           | [Apache License, Version 2.0][43]             |
| [Lombok Maven Plugin][70]                               | [The MIT License][5]                          |
| [Maven Clean Plugin][72]                                | [The Apache Software License, Version 2.0][1] |
| [Maven Resources Plugin][74]                            | [The Apache Software License, Version 2.0][1] |
| [Maven Install Plugin][76]                              | [The Apache Software License, Version 2.0][1] |
| [Maven Deploy Plugin][78]                               | [The Apache Software License, Version 2.0][1] |
| [Maven Site Plugin 3][80]                               | [The Apache Software License, Version 2.0][1] |

[30]: https://www.eclemma.org/jacoco/index.html
[60]: https://github.com/exasol/project-keeper-maven-plugin
[40]: http://www.snakeyaml.org
[6]: https://github.com/exasol/error-reporting-java
[4]: https://github.com/exasol/virtual-schema-common-document-files
[1]: http://www.apache.org/licenses/LICENSE-2.0.txt
[10]: https://projectlombok.org
[42]: https://maven.apache.org/surefire/maven-surefire-plugin/
[72]: http://maven.apache.org/plugins/maven-clean-plugin/
[5]: https://opensource.org/licenses/MIT
[20]: https://github.com/mockito/mockito
[44]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[28]: https://github.com/exasol/test-db-builder-java
[50]: http://maven.apache.org/plugins/maven-dependency-plugin/
[52]: http://www.mojohaus.org/versions-maven-plugin/
[70]: http://anthonywhitford.com/lombok.maven/lombok-maven-plugin/
[13]: http://opensource.org/licenses/BSD-3-Clause
[48]: https://maven.apache.org/plugins/maven-compiler-plugin/
[9]: http://opensource.org/licenses/MIT
[22]: http://junit.org
[31]: https://www.eclipse.org/legal/epl-2.0/
[2]: http://github.com/FasterXML/jackson
[23]: http://www.eclipse.org/legal/epl-v10.html
[46]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[21]: https://github.com/mockito/mockito/blob/main/LICENSE
[11]: https://projectlombok.org/LICENSE
[36]: https://github.com/exasol/hamcrest-resultset-matcher
[64]: http://zlika.github.io/reproducible-build-maven-plugin
[43]: https://www.apache.org/licenses/LICENSE-2.0.txt
[56]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[8]: https://github.com/Azure/azure-sdk-for-java
[17]: https://www.eclipse.org/legal/epl-v20.html
[76]: http://maven.apache.org/plugins/maven-install-plugin/
[16]: https://junit.org/junit5/
[54]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[24]: https://testcontainers.org
[34]: https://github.com/exasol/udf-debugging-java
[12]: http://hamcrest.org/JavaHamcrest/
[78]: http://maven.apache.org/plugins/maven-deploy-plugin/
[80]: http://maven.apache.org/plugins/maven-site-plugin/
[74]: http://maven.apache.org/plugins/maven-resources-plugin/
[58]: https://github.com/exasol/artifact-reference-checker-maven-plugin
[62]: https://github.com/exasol/error-code-crawler-maven-plugin
[38]: https://github.com/exasol/exasol-test-setup-abstraction-java
[0]: https://github.com/FasterXML/jackson-core
[68]: https://maven.apache.org/plugins/maven-jar-plugin/
[66]: https://maven.apache.org/plugins/maven-assembly-plugin/
