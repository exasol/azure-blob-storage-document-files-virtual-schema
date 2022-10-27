# User Guide

This user guide will help you to get started with the Azure Blob Storage (ABS) File Virtual Schema.

### Installation

Upload the latest available [release of this adapter](https://github.com/exasol/azure-blob-storage-document-files-virtual-schema/releases) to BucketFS. See the Exasol documentation for details: [Create a bucket in BucketFS](https://docs.exasol.com/administration/on-premise/bucketfs/create_new_bucket_in_bucketfs_service.htm), [Access Files in BucketFS](https://docs.exasol.com/administration/on-premise/bucketfs/accessfiles.htm).

Then create a schema to hold the adapter script.

```
CREATE SCHEMA ADAPTER;
```

Next create the Adapter Script:

 ```sql
CREATE OR REPLACE JAVA ADAPTER SCRIPT ADAPTER.AZURE_BLOB_STORAGE_FILES_ADAPTER AS
    %scriptclass com.exasol.adapter.RequestDispatcher;
    %jar /buckets/bfsdefault/default/document-files-virtual-schema-dist-7.1.2-azure-blob-storage-1.1.2.jar;
/
```

In addition to the adapter script you need to create a UDF function that will handle the loading of the data:

```sql
CREATE OR REPLACE JAVA SET SCRIPT ADAPTER.IMPORT_FROM_AZURE_BLOB_STORAGE_DOCUMENT_FILES(
  DATA_LOADER VARCHAR(2000000),
  SCHEMA_MAPPING_REQUEST VARCHAR(2000000),
  CONNECTION_NAME VARCHAR(500))
  EMITS(...) AS
    %scriptclass com.exasol.adapter.document.UdfEntryPoint;
    %jar /buckets/bfsdefault/default/document-files-virtual-schema-dist-7.1.2-azure-blob-storage-1.1.2.jar;
/
```

## Creating a Connection

For granting the Virtual Schema access to your Azure Blob Storage container you need a connection string of your Azure Storage Account containing your container and the container name.
 
You can find your storage account's connection strings in the Azure portal. Navigate to `SETTINGS` > `Access keys` in your storage account's menu blade to see connection strings for both primary and secondary access keys. (More info [here](https://docs.microsoft.com/en-us/azure/storage/common/storage-configure-connection-string#:~:text=You%20can%20find%20your%20storage,primary%20and%20secondary%20access%20keys.))

Now you need to define a connection that includes the contents of the key file:

 ```sql
CREATE CONNECTION ABS_CONNECTION
    TO ''
    USER ''
    IDENTIFIED BY '{
        "absStorageAccountConnectionString": "DefaultEndpointsProtocol=https;AccountName=accountName;AccountKey=accountKey;EndpointSuffix=core.windows.net
",
        "absContainerName": "<ABS CONTAINER NAME>" 
    }';
```

Here you can use the connection string as value for `absStorageAccountConnectionString`.

The connection stores all connection details as JSON in the `IDENTIFIED BY` part. There you can use the following keys:

| Key                              | Default                   | Required | Example                          |
|----------------------------------|---------------------------|:--------:|----------------------------------|
| `absStorageAccountConnectionString` |                           |    ✓     | `"DefaultEndpointsProtocol=https;AccountName=..."` |
| `absContainerName`                  |                           |    ✓     | `"my-container"`                 |


## Defining the Schema Mapping

Before creating a Virtual Schema you need to create a mapping definition that defines how the document data is mapped to Exasol tables.

For that we use the Exasol Document Mapping Language (EDML). It is universal over all document Virtual Schemas. To learn how to define such EDML definitions check the [user guide in the common repository for all document Virtual Schemas](https://github.com/exasol/virtual-schema-common-document/blob/main/doc/user_guide/edml_user_guide.md).

In the definitions you have to define the `source` property. Use something like `my-folder/user.json` here. The path is relative to the container's root.

This Virtual Schema adapter automatically detects the type of the document file by the file extension. You can find a list of supported file types and their extensions in the [user guide of the common repository for all file Virtual Schemas](https://github.com/exasol/virtual-schema-common-document-files/blob/main/doc/user_guide/user_guide.md).

### Mapping Multiple Files

For some file type (for example JSON) each source file contains only a single document. That means, that you have one file for each row in the mapped table. To define mappings for such types, you can use the GLOB syntax. That means, you can use `*` and `?` as wildcards, where `*` matches multiple characters and `?` a single one.

## Creating the Virtual Schema

Finally, create the Virtual Schema using:

```sql
CREATE VIRTUAL SCHEMA FILES_VS_TEST USING ADAPTER.AZURE_BLOB_STORAGE_FILES_ADAPTER WITH
    CONNECTION_NAME = 'ABS_CONNECTION'
    MAPPING         = '/bfsdefault/default/path/to/mappings/in/bucketfs';
```

The `CREATE VIRTUAL SCHEMA` command accepts the following properties:

| Property            | Mandatory | Default | Description                                                                    |
|---------------------|-----------|---------|--------------------------------------------------------------------------------|
| `MAPPING`           | Yes       |         | Path to the mapping definition file(s)                                         |
| `MAX_PARALLEL_UDFS` | No        | -1      | Maximum number of UDFs that are executed in parallel. -1 represents unlimited. | 

Now browse the data using your favorite SQL client.

## Known Issues
