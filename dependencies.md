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
| [Test Database Builder for Java][28]            | [MIT License][29]                 |
| [JaCoCo :: Core][30]                            | [Eclipse Public License 2.0][31]  |
| [udf-debugging-java][32]                        | [MIT][5]                          |
| [Matcher for SQL Result Sets][34]               | [MIT][5]                          |
| [exasol-test-setup-abstraction-java][36]        | [MIT][5]                          |
| [SnakeYAML][38]                                 | [Apache License, Version 2.0][1]  |
| [JaCoCo :: Agent][30]                           | [Eclipse Public License 2.0][31]  |

## Plugin Dependencies

| Dependency                                              | License                                       |
| ------------------------------------------------------- | --------------------------------------------- |
| [SonarQube Scanner for Maven][42]                       | [GNU LGPL 3][43]                              |
| [Apache Maven Compiler Plugin][44]                      | [Apache License, Version 2.0][45]             |
| [Apache Maven Enforcer Plugin][46]                      | [Apache License, Version 2.0][45]             |
| [Maven Flatten Plugin][48]                              | [Apache Software Licenese][1]                 |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][50] | [ASL2][1]                                     |
| [Reproducible Build Maven Plugin][52]                   | [Apache 2.0][1]                               |
| [Maven Surefire Plugin][54]                             | [Apache License, Version 2.0][45]             |
| [Versions Maven Plugin][56]                             | [Apache License, Version 2.0][45]             |
| [Project keeper maven plugin][58]                       | [The MIT License][59]                         |
| [Apache Maven Assembly Plugin][60]                      | [Apache License, Version 2.0][45]             |
| [Apache Maven JAR Plugin][62]                           | [Apache License, Version 2.0][45]             |
| [Artifact reference checker and unifier][64]            | [MIT][5]                                      |
| [Apache Maven Dependency Plugin][66]                    | [Apache License, Version 2.0][45]             |
| [Lombok Maven Plugin][68]                               | [The MIT License][5]                          |
| [Maven Failsafe Plugin][70]                             | [Apache License, Version 2.0][45]             |
| [JaCoCo :: Maven Plugin][72]                            | [Eclipse Public License 2.0][31]              |
| [error-code-crawler-maven-plugin][74]                   | [MIT][5]                                      |
| [Maven Clean Plugin][76]                                | [The Apache Software License, Version 2.0][1] |
| [Maven Resources Plugin][78]                            | [The Apache Software License, Version 2.0][1] |
| [Maven Install Plugin][80]                              | [The Apache Software License, Version 2.0][1] |
| [Maven Deploy Plugin][82]                               | [The Apache Software License, Version 2.0][1] |
| [Maven Site Plugin 3][84]                               | [The Apache Software License, Version 2.0][1] |

[30]: https://www.eclemma.org/jacoco/index.html
[6]: https://github.com/exasol/error-reporting-java
[4]: https://github.com/exasol/virtual-schema-common-document-files
[1]: http://www.apache.org/licenses/LICENSE-2.0.txt
[10]: https://projectlombok.org
[54]: https://maven.apache.org/surefire/maven-surefire-plugin/
[76]: http://maven.apache.org/plugins/maven-clean-plugin/
[5]: https://opensource.org/licenses/MIT
[20]: https://github.com/mockito/mockito
[56]: http://www.mojohaus.org/versions-maven-plugin/
[58]: https://github.com/exasol/project-keeper/
[13]: http://opensource.org/licenses/BSD-3-Clause
[44]: https://maven.apache.org/plugins/maven-compiler-plugin/
[29]: https://github.com/exasol/test-db-builder-java/blob/main/LICENSE
[22]: http://junit.org
[31]: https://www.eclipse.org/legal/epl-2.0/
[2]: http://github.com/FasterXML/jackson
[43]: http://www.gnu.org/licenses/lgpl.txt
[72]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[21]: https://github.com/mockito/mockito/blob/main/LICENSE
[11]: https://projectlombok.org/LICENSE
[34]: https://github.com/exasol/hamcrest-resultset-matcher
[52]: http://zlika.github.io/reproducible-build-maven-plugin
[42]: http://sonarsource.github.io/sonar-scanner-maven/
[16]: https://junit.org/junit5/
[48]: https://www.mojohaus.org/flatten-maven-plugin/flatten-maven-plugin
[12]: http://hamcrest.org/JavaHamcrest/
[78]: http://maven.apache.org/plugins/maven-resources-plugin/
[64]: https://github.com/exasol/artifact-reference-checker-maven-plugin
[36]: https://github.com/exasol/exasol-test-setup-abstraction-java
[0]: https://github.com/FasterXML/jackson-core
[62]: https://maven.apache.org/plugins/maven-jar-plugin/
[38]: http://www.snakeyaml.org
[28]: https://github.com/exasol/test-db-builder-java/
[70]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[9]: http://opensource.org/licenses/MIT
[23]: http://www.eclipse.org/legal/epl-v10.html
[59]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[66]: https://maven.apache.org/plugins/maven-dependency-plugin/
[45]: https://www.apache.org/licenses/LICENSE-2.0.txt
[46]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[68]: https://awhitford.github.com/lombok.maven/lombok-maven-plugin/
[8]: https://github.com/Azure/azure-sdk-for-java
[17]: https://www.eclipse.org/legal/epl-v20.html
[80]: http://maven.apache.org/plugins/maven-install-plugin/
[50]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[24]: https://testcontainers.org
[32]: https://github.com/exasol/udf-debugging-java
[82]: http://maven.apache.org/plugins/maven-deploy-plugin/
[84]: http://maven.apache.org/plugins/maven-site-plugin/
[74]: https://github.com/exasol/error-code-crawler-maven-plugin
[60]: https://maven.apache.org/plugins/maven-assembly-plugin/
