<!-- @formatter:off -->
# Dependencies

## Compile Dependencies

| Dependency                                           | License                                       |
| ---------------------------------------------------- | --------------------------------------------- |
| [Jackson-core][0]                                    | [The Apache Software License, Version 2.0][1] |
| [Jackson-annotations][2]                             | [The Apache Software License, Version 2.0][1] |
| [Virtual Schema for document data in files][3]       | [MIT License][4]                              |
| [error-reporting-java][5]                            | [MIT License][6]                              |
| [Microsoft Azure client library for Blob Storage][7] | [The MIT License (MIT)][8]                    |
| [jackson-databind][2]                                | [The Apache Software License, Version 2.0][1] |
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
| [udf-debugging-java][20]                        | [MIT][21]                         |
| [Matcher for SQL Result Sets][22]               | [MIT License][23]                 |
| [exasol-test-setup-abstraction-java][24]        | [MIT License][25]                 |
| [SnakeYAML][26]                                 | [Apache License, Version 2.0][1]  |
| [Performance Test Recorder Java][27]            | [MIT License][28]                 |
| [JaCoCo :: Agent][29]                           | [Eclipse Public License 2.0][30]  |

## Plugin Dependencies

| Dependency                                              | License                                       |
| ------------------------------------------------------- | --------------------------------------------- |
| [SonarQube Scanner for Maven][31]                       | [GNU LGPL 3][32]                              |
| [Apache Maven Compiler Plugin][33]                      | [Apache License, Version 2.0][34]             |
| [Apache Maven Enforcer Plugin][35]                      | [Apache License, Version 2.0][34]             |
| [Maven Flatten Plugin][36]                              | [Apache Software Licenese][1]                 |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][37] | [ASL2][1]                                     |
| [Maven Surefire Plugin][38]                             | [Apache License, Version 2.0][34]             |
| [Versions Maven Plugin][39]                             | [Apache License, Version 2.0][34]             |
| [Project keeper maven plugin][40]                       | [The MIT License][41]                         |
| [Apache Maven Assembly Plugin][42]                      | [Apache License, Version 2.0][34]             |
| [Apache Maven JAR Plugin][43]                           | [Apache License, Version 2.0][34]             |
| [Artifact reference checker and unifier][44]            | [MIT][21]                                     |
| [Apache Maven Dependency Plugin][45]                    | [Apache License, Version 2.0][34]             |
| [Lombok Maven Plugin][46]                               | [The MIT License][21]                         |
| [Maven Failsafe Plugin][47]                             | [Apache License, Version 2.0][34]             |
| [JaCoCo :: Maven Plugin][48]                            | [Eclipse Public License 2.0][30]              |
| [error-code-crawler-maven-plugin][49]                   | [MIT License][50]                             |
| [Reproducible Build Maven Plugin][51]                   | [Apache 2.0][1]                               |
| [Maven Clean Plugin][52]                                | [The Apache Software License, Version 2.0][1] |
| [Maven Resources Plugin][53]                            | [The Apache Software License, Version 2.0][1] |
| [Maven Install Plugin][54]                              | [The Apache Software License, Version 2.0][1] |
| [Maven Deploy Plugin][55]                               | [The Apache Software License, Version 2.0][1] |
| [Maven Site Plugin 3][56]                               | [The Apache Software License, Version 2.0][1] |

[0]: https://github.com/FasterXML/jackson-core
[1]: http://www.apache.org/licenses/LICENSE-2.0.txt
[2]: http://github.com/FasterXML/jackson
[3]: https://github.com/exasol/virtual-schema-common-document-files/
[4]: https://github.com/exasol/virtual-schema-common-document-files/blob/main/LICENSE
[5]: https://github.com/exasol/error-reporting-java/
[6]: https://github.com/exasol/error-reporting-java/blob/main/LICENSE
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
[21]: https://opensource.org/licenses/MIT
[22]: https://github.com/exasol/hamcrest-resultset-matcher/
[23]: https://github.com/exasol/hamcrest-resultset-matcher/blob/main/LICENSE
[24]: https://github.com/exasol/exasol-test-setup-abstraction-java/
[25]: https://github.com/exasol/exasol-test-setup-abstraction-java/blob/main/LICENSE
[26]: https://bitbucket.org/snakeyaml/snakeyaml
[27]: https://github.com/exasol/performance-test-recorder-java/
[28]: https://github.com/exasol/performance-test-recorder-java/blob/main/LICENSE
[29]: https://www.eclemma.org/jacoco/index.html
[30]: https://www.eclipse.org/legal/epl-2.0/
[31]: http://sonarsource.github.io/sonar-scanner-maven/
[32]: http://www.gnu.org/licenses/lgpl.txt
[33]: https://maven.apache.org/plugins/maven-compiler-plugin/
[34]: https://www.apache.org/licenses/LICENSE-2.0.txt
[35]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[36]: https://www.mojohaus.org/flatten-maven-plugin/
[37]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[38]: https://maven.apache.org/surefire/maven-surefire-plugin/
[39]: http://www.mojohaus.org/versions-maven-plugin/
[40]: https://github.com/exasol/project-keeper/
[41]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[42]: https://maven.apache.org/plugins/maven-assembly-plugin/
[43]: https://maven.apache.org/plugins/maven-jar-plugin/
[44]: https://github.com/exasol/artifact-reference-checker-maven-plugin
[45]: https://maven.apache.org/plugins/maven-dependency-plugin/
[46]: https://anthonywhitford.com/lombok.maven/lombok-maven-plugin/
[47]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[48]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[49]: https://github.com/exasol/error-code-crawler-maven-plugin/
[50]: https://github.com/exasol/error-code-crawler-maven-plugin/blob/main/LICENSE
[51]: http://zlika.github.io/reproducible-build-maven-plugin
[52]: http://maven.apache.org/plugins/maven-clean-plugin/
[53]: http://maven.apache.org/plugins/maven-resources-plugin/
[54]: http://maven.apache.org/plugins/maven-install-plugin/
[55]: http://maven.apache.org/plugins/maven-deploy-plugin/
[56]: http://maven.apache.org/plugins/maven-site-plugin/
