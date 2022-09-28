<!-- @formatter:off -->
# Dependencies

## Compile Dependencies

| Dependency                                           | License                                       |
| ---------------------------------------------------- | --------------------------------------------- |
| [Jackson-core][0]                                    | [The Apache Software License, Version 2.0][1] |
| [Jackson-annotations][2]                             | [The Apache Software License, Version 2.0][1] |
| [Virtual Schema for document data in files][3]       | [MIT License][4]                              |
| [error-reporting-java][5]                            | [MIT][6]                                      |
| [Microsoft Azure client library for Blob Storage][7] | [The MIT License (MIT)][8]                    |
| [Project Lombok][9]                                  | [The MIT License][10]                         |

## Test Dependencies

| Dependency                                      | License                           |
| ----------------------------------------------- | --------------------------------- |
| [Hamcrest][11]                                  | [BSD License 3][12]               |
| [Virtual Schema for document data in files][3]  | [MIT License][4]                  |
| [JUnit Jupiter Engine][13]                      | [Eclipse Public License v2.0][14] |
| [JUnit Jupiter Params][13]                      | [Eclipse Public License v2.0][14] |
| [mockito-core][15]                              | [The MIT License][16]             |
| [Testcontainers :: JUnit Jupiter Extension][17] | [MIT][8]                          |
| [Test Database Builder for Java][18]            | [MIT License][19]                 |
| [udf-debugging-java][20]                        | [MIT][6]                          |
| [Matcher for SQL Result Sets][21]               | [MIT][6]                          |
| [exasol-test-setup-abstraction-java][22]        | [MIT License][23]                 |
| [SnakeYAML][24]                                 | [Apache License, Version 2.0][1]  |
| [Performance Test Recorder Java][25]            | [MIT][6]                          |
| [JaCoCo :: Agent][26]                           | [Eclipse Public License 2.0][27]  |

## Plugin Dependencies

| Dependency                                              | License                                       |
| ------------------------------------------------------- | --------------------------------------------- |
| [SonarQube Scanner for Maven][28]                       | [GNU LGPL 3][29]                              |
| [Apache Maven Compiler Plugin][30]                      | [Apache License, Version 2.0][31]             |
| [Apache Maven Enforcer Plugin][32]                      | [Apache License, Version 2.0][31]             |
| [Maven Flatten Plugin][33]                              | [Apache Software Licenese][1]                 |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][34] | [ASL2][1]                                     |
| [Maven Surefire Plugin][35]                             | [Apache License, Version 2.0][31]             |
| [Versions Maven Plugin][36]                             | [Apache License, Version 2.0][31]             |
| [Project keeper maven plugin][37]                       | [The MIT License][38]                         |
| [Apache Maven Assembly Plugin][39]                      | [Apache License, Version 2.0][31]             |
| [Apache Maven JAR Plugin][40]                           | [Apache License, Version 2.0][31]             |
| [Artifact reference checker and unifier][41]            | [MIT][6]                                      |
| [Apache Maven Dependency Plugin][42]                    | [Apache License, Version 2.0][31]             |
| [Lombok Maven Plugin][43]                               | [The MIT License][6]                          |
| [Maven Failsafe Plugin][44]                             | [Apache License, Version 2.0][31]             |
| [JaCoCo :: Maven Plugin][45]                            | [Eclipse Public License 2.0][27]              |
| [error-code-crawler-maven-plugin][46]                   | [MIT License][47]                             |
| [Reproducible Build Maven Plugin][48]                   | [Apache 2.0][1]                               |
| [Maven Clean Plugin][49]                                | [The Apache Software License, Version 2.0][1] |
| [Maven Resources Plugin][50]                            | [The Apache Software License, Version 2.0][1] |
| [Maven Install Plugin][51]                              | [The Apache Software License, Version 2.0][1] |
| [Maven Deploy Plugin][52]                               | [The Apache Software License, Version 2.0][1] |
| [Maven Site Plugin 3][53]                               | [The Apache Software License, Version 2.0][1] |

[0]: https://github.com/FasterXML/jackson-core
[1]: http://www.apache.org/licenses/LICENSE-2.0.txt
[2]: http://github.com/FasterXML/jackson
[3]: https://github.com/exasol/virtual-schema-common-document-files/
[4]: https://github.com/exasol/virtual-schema-common-document-files/blob/main/LICENSE
[5]: https://github.com/exasol/error-reporting-java
[6]: https://opensource.org/licenses/MIT
[7]: https://github.com/Azure/azure-sdk-for-java
[8]: http://opensource.org/licenses/MIT
[9]: https://projectlombok.org
[10]: https://projectlombok.org/LICENSE
[11]: http://hamcrest.org/JavaHamcrest/
[12]: http://opensource.org/licenses/BSD-3-Clause
[13]: https://junit.org/junit5/
[14]: https://www.eclipse.org/legal/epl-v20.html
[15]: https://github.com/mockito/mockito
[16]: https://github.com/mockito/mockito/blob/main/LICENSE
[17]: https://testcontainers.org
[18]: https://github.com/exasol/test-db-builder-java/
[19]: https://github.com/exasol/test-db-builder-java/blob/main/LICENSE
[20]: https://github.com/exasol/udf-debugging-java/
[21]: https://github.com/exasol/hamcrest-resultset-matcher
[22]: https://github.com/exasol/exasol-test-setup-abstraction-java/
[23]: https://github.com/exasol/exasol-test-setup-abstraction-java/blob/main/LICENSE
[24]: https://bitbucket.org/snakeyaml/snakeyaml
[25]: https://github.com/exasol/performance-test-recorder-java
[26]: https://www.eclemma.org/jacoco/index.html
[27]: https://www.eclipse.org/legal/epl-2.0/
[28]: http://sonarsource.github.io/sonar-scanner-maven/
[29]: http://www.gnu.org/licenses/lgpl.txt
[30]: https://maven.apache.org/plugins/maven-compiler-plugin/
[31]: https://www.apache.org/licenses/LICENSE-2.0.txt
[32]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[33]: https://www.mojohaus.org/flatten-maven-plugin/
[34]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[35]: https://maven.apache.org/surefire/maven-surefire-plugin/
[36]: http://www.mojohaus.org/versions-maven-plugin/
[37]: https://github.com/exasol/project-keeper/
[38]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[39]: https://maven.apache.org/plugins/maven-assembly-plugin/
[40]: https://maven.apache.org/plugins/maven-jar-plugin/
[41]: https://github.com/exasol/artifact-reference-checker-maven-plugin
[42]: https://maven.apache.org/plugins/maven-dependency-plugin/
[43]: https://anthonywhitford.com/lombok.maven/lombok-maven-plugin/
[44]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[45]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[46]: https://github.com/exasol/error-code-crawler-maven-plugin/
[47]: https://github.com/exasol/error-code-crawler-maven-plugin/blob/main/LICENSE
[48]: http://zlika.github.io/reproducible-build-maven-plugin
[49]: http://maven.apache.org/plugins/maven-clean-plugin/
[50]: http://maven.apache.org/plugins/maven-resources-plugin/
[51]: http://maven.apache.org/plugins/maven-install-plugin/
[52]: http://maven.apache.org/plugins/maven-deploy-plugin/
[53]: http://maven.apache.org/plugins/maven-site-plugin/
