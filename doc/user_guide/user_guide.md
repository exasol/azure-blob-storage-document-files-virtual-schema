# User Guide

This user guide helps you with getting started with the Azure Blob Storage (abs) Files Virtual Schemas.

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
    %jar /buckets/bfsdefault/default/document-files-virtual-schema-dist-6.0.0-azure-blob-storage-1.0.0.jar;
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
    %jar /buckets/bfsdefault/default/document-files-virtual-schema-dist-6.0.0-azure-blob-storage-1.0.0.jar;
/
```

## Creating a Connection

For granting the Virtual Schema access to your abs bucket you need a Service Role. Please follow the [following tutorial](https://cloud.google.com/docs/authentication/production#create_service_account) on how to create it. The account needs permissions to read and list files on the bucket. We recommend the `Storage Object Viewer` role. After creating the role please download a key file as a JSON formatted file. Open the file and copy the contents.

Now you need to define a connection that includes the contents of the key file:

 ```sql
CREATE CONNECTION ABS_CONNECTION
    TO ''
    USER ''
    IDENTIFIED BY '{
        "gcKey":  {
            "type": "service_account",
            "project_id": "",
            ...
        }  
        "absBucket": "<ABS BUCKET NAME>" 
    }';
```

Here you can use the content of the key file as value for `gcKey`.

The connection stores all connection details as JSON in the `IDENTIFIED BY` part. There you can use the following keys:

| Key                 | Default                   | Required | Example                          |
|---------------------|---------------------------|:--------:|----------------------------------|
| `gcKey`             |                           |    ✓     | {"type": "service_account", ...} |
| `absBucket`         |                           |    ✓     | `"my-bucket"`                    |
| `gcHost`            | _Default google endpoint_ |    ✘     | `"my.custom.storarge.de"`        |
| `useSsl`            | `true`                    |    ✘     | `false`                          |

## Defining the Schema Mapping

Before creating a Virtual Schema you need to create a mapping definition that defines how the document data is mapped to Exasol tables.

For that we use the Exasol Document Mapping Language (EDML). It is universal over all document Virtual Schemas. To learn how to define such EDML definitions check the [user guide in the common repository for all document Virtual Schemas](https://github.com/exasol/virtual-schema-common-document/blob/main/doc/user_guide/edml_user_guide.md).

In the definitions you have to define the `source` property. Use something like `my-folder/user.json` here. The path is relative to the bucket's root.

This Virtual Schema adapter automatically detects the type of the document file by the file extension. You can find a list of supported file types and their extensions in the [user guide of the common repository for all file Virtual Schemas](https://github.com/exasol/virtual-schema-common-document-files/blob/main/doc/user_guide/user_guide.md).

### Mapping Multiple Files

For some file type (for example JSON) each source file contains only a single document. That means, that you have one file for each row in the mapped table. To define mappings for such types, you can use the GLOB syntax. That means, you can use `*` and `?` as wildcards, where `*` matches multiple characters and `?` a single one.

## Creating the Virtual Schema

Finally, create the Virtual Schema using:

```sql
CREATE VIRTUAL SCHEMA FILES_VS_TEST USING ADAPTER.S3_FILES_ADAPTER WITH
    CONNECTION_NAME = 'S3_CONNECTION'
    MAPPING         = '/bfsdefault/default/path/to/mappings/in/bucketfs';
```

The `CREATE VIRTUAL SCHEMA` command accepts the following properties:

| Property            | Mandatory | Default | Description                                                                    |
|---------------------|-----------|---------|--------------------------------------------------------------------------------|
| `MAPPING`           | Yes       |         | Path to the mapping definition file(s)                                         |
| `MAX_PARALLEL_UDFS` | No        | -1      | Maximum number of UDFs that are executed in parallel. -1 represents unlimited. | 

Now browse the data using your favorite SQL client.

## Known Issues:

* Certain Virtual Schema queries can cause a database crash. For details see [#41](https://github.com/exasol/virtual-schema-common-document-files/issues/41).
