# Virtual Schema for Document Data in Files on Azure Blob Storage 1.3.1, released 2023-05-09

Code name: CSV Performance Regression Tests

## Summary

This release updates performance regression rests for CSV files to use all data types (string, boolean, integer, double, date and timestamp) instead of only string. Please note that this might influence comparability of test results. Additionally the test names in the test report changed. They now use suffix `()` instead of `(TestInfo)`.

## Tests

* #31: Added CSV data type performance regression tests

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:virtual-schema-common-document-files:7.3.0` to `7.3.2`

### Test Dependency Updates

* Updated `com.exasol:virtual-schema-common-document-files:7.3.0` to `7.3.2`
