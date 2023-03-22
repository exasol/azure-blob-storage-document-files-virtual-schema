# Virtual Schema for Document Data in Files on Azure Blob Storage 1.2.0, released 2023-03-22

Code name: Auto-inference for Parquet

## Summary

This release adds automatic schema inference for Parquet files. This means that you don't need to specify a `mapping` element in the EDML definition. Instead VSBFS will automatically detect the mapping from the Parquet files. See the [EDML user guide](https://github.com/exasol/virtual-schema-common-document/blob/main/doc/user_guide/edml_user_guide.md#automatic-mapping-inference) for details.

The release also refactored class `LocalAbsTestSetup`.

## Features

* #22: Added auto-inference for Parquet files

## Refactoring

* #20: Refactored class `LocalAbsTestSetup`.

