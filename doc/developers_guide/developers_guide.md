# Developers Guide

This guide contains information for developers.

## Running Integration Tests

Some integration tests require access to an Azure Blob Storage account. For local test runs against Azure, create a file
named `abs-cs.json` in the project root. Despite the file extension, the file must contain only the plain Azure Storage
connection string, not a JSON object.

To get the connection string from the Azure portal:

1. Open the storage account.
2. In the resource menu, select **Security + networking** → **Access keys**.
3. Select **Show keys**.
4. Copy one of the **Connection string** values.
5. Paste the copied value into `abs-cs.json`.

The file content should look like this:

```text
DefaultEndpointsProtocol=https;AccountName=<account-name>;AccountKey=<account-key>;EndpointSuffix=core.windows.net
```

Use a regular Blob Storage account without Data Lake Gen2 / hierarchical namespace enabled.

## Running Regression Test

This project contains some regression tests to monitor the performance cross releases. To run them locally use:

```shell
mvn verify -PregressionTests
```

However, a local run won't give you reliable numbers, since it's dependent on your local hardware configuration.

## Getting Debug Output

In order to get the log output from inside the database set the system property`test.udf-logs=true` (by adding it with `-D` as jvm option in your IDE's test config) and check the files in `target/udf-logs/`.

## Debugging & Profiling

You can use a remote debugger and profiler for this project's integration tests. To do so, use the system properties from [UDF debugging Java](https://github.com/exasol/udf-debugging-java/).

When you enable debugging or profiling, this project's test will set the UDF concurrency to 1. Debugging concurrent UDFs is currently not possible due to reverse connection.
