package us.rcs.app.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.wasmer.Instance;
import org.wasmer.Module;
import org.wasmer.Store;
import org.wasmer.exports.Function;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);

		try {
			byte[] wasmBytes = Files.readAllBytes(Paths.get("src/main/webassembly/sample.wasm"));
			Store store = new Store();
			Module module = new Module(store, wasmBytes);
			Instance instance = new Instance(module);
			Function function = instance.exports.getFunction("sampleFunction");
			int result = function.call(5, 3);
			System.out.println("Result from WebAssembly: " + result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
