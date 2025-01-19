# Spring Boot CRUD Application with WebAssembly

This project demonstrates how to integrate WebAssembly with a Spring Boot CRUD application.

## Prerequisites

- Java 21 or higher
- Maven 3.6.3 or higher

## Building the Project

1. Clone the repository:
   ```sh
   git clone https://github.com/zlovtnik/apps.git
   cd apps
   ```

2. Build the project using Maven:
   ```sh
   ./mvnw clean install
   ```

## Running the Application

1. Run the Spring Boot application:
   ```sh
   ./mvnw spring-boot:run
   ```

2. The application will start and load the WebAssembly file `sample.wasm` located in `src/main/webassembly`.

## WebAssembly Integration

The WebAssembly file `sample.wasm` is loaded and executed in the `AppApplication` class. The result of the WebAssembly function is printed to the console.

## Sample WebAssembly File

The sample WebAssembly file `sample.wasm` contains a simple function that adds two integers. The function is defined as follows:

```wasm
(module
  (type $t0 (func (param i32 i32) (result i32)))
  (func $sampleFunction (export "sampleFunction") (type $t0) (param $p0 i32) (param $p1 i32) (result i32)
    local.get $p0
    local.get $p1
    i32.add)
  (memory $memory (export "memory") 1)
  (global $g0 (mut i32) (i32.const 0))
  (global $g1 i32 (i32.const 0))
  (table $table (export "table") 1 funcref)
  (elem (i32.const 0) $sampleFunction))
```

## Additional Information

For more information on WebAssembly and its integration with Java, refer to the [Wasmer Java documentation](https://github.com/wasmerio/wasmer-java).
