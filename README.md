# Plham: Platform for large-scale and high-frequency artificial market

Plham is a platform for artificial market simulations, written in the [X10 language](http://x10-lang.org):

* for large-scale parallel computation
* as well as standalone sequential computation

**PlhamJ** is a Java version of Plham. Only a sequential version is currently supported. Work is in progress on multithreaded and distributed versions.

Plham is shipped with reusable examples based on recent artificial market studies on

* Fundamentalist-chartist agents
* Single asset simulations
* Price limit regulation
* Trading halt regulation
* Fat finger error
* Flash Crash shock transfer

## 1. Compilation Instructions

### 1.1 Compiling PlhamJ

We use Maven to compile this project. Use the following three commands to checkout the project and compile it on your system. All the dependencies will be downloaded automatically.

```
~/ $ git clone https://github.com/plham/plhamJ.git
~/ $ cd plhamJ
~/plhamJ $ mvn package
```

This creates a JAR file which contains all the dependencies under directory target:

```
~/plhamJ/ $: ls -l target/*.jar
-rw-rw-r-- 1 group user 9941632  4月  5 10:34 target/plhamj-0.0.1-SNAPSHOT-jar-with-dependencies.jar
```

### 1.2 PlhamJ as a dependency for your source code

To compile your code, add the JAR with all its dependencies to your classpath in your `javac` command. 

```
$ javac -classpath ~/plhamJ/target/plhamj-0.0.1-SNAPSHOT-jar-with-dependencies.jar YourMain.java
```

Alternatively, if you are using Maven to build your own program, you can "install" PlhamJ in your local repository with command `mvn install` and declare it as a dependency into your own project.

```
~/ $ git clone https://github.com/plham/plhamJ.git
~/ $ cd plhamJ
~/plhamJ $ mvn -DskipTests install
```

Then, inside your **pom.xml** file:

```
<dependencies>
  <dependency>
    <groupId>plham</groupId>
    <artifactId>plhamj</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <scope>compile</scope>
  </dependency>
</dependencies>
```

## 2. Running a simulation

### 2.1 Launching example program from the samples

Some example programs are included with this library in the "samples" module. For instance, you can launch the "CI2002" example using the following command.

```
~/plhamJ/ $: java -cp target/plhamj-0.0.1-SNAPSHOT-jar-with-dependencies.jar plham.samples.CI2002.CI2002Main samples/src/main/resources/CI2002/config.json 100
```

For other sequential programs, simply switch the main class and the input JSON file in the command above. More generically, you can use the `SequentialRunner` as the main class and specify the class used to produce the outputs as parameter as shown below:

```
~/plhamJ/ $: java -cp target/plhamj-0.0.1-SNAPSHOT-jar-with-dependencies.jar plham.core.main.SequentialRunner <output class> <JSON configuration> <seed>
````

i.e. for the CI2002 simulation:

```
~/plhamJ/ $: java -cp target/plhamj-0.0.1-SNAPSHOT-jar-with-dependencies.jar plham.core.main.SequentialRunner plham.samples.CI2002.CI2002Main samples/src/main/resources/CI2002/config.json 100
```

Other runner implementations: TODO

### 2.2 Launching your own code manually

Similar to when you want to compile your own program, add the JAR "with all dependencies" to your classpath:
```
$ java -classpath ~/plhamJ/target/plhamj-0.0.1-SNAPSHOT-jar-with-dependencies.jar YourMain <program arguments>
```

## Testing the library

Some tests are included with the library. They consist mainly of checking the output of the sample programs against expected results. To launch these tests, use the following command:

```
~/plhamJ/ $: mvn verify
```

_Note:_ Running the tests for the distributed runner implementations requires the installation of MPI and native MPJ-Express on the running host. 

## License

Currently under [Eclipse Public License 1.0 (read here)](http://choosealicense.com/licenses/epl-1.0/).

## History

* v0.1: March 2019

## Contributors

* Takuma Torii
* Kiyoshi Izumi
* Tomio Kamada
* Hiroto Yonenoh
* Daisuke Fujishima
* Izuru Matsuura
* Masanori Hirano
* Tosiyuki Takahashi
* Patrick Finnerty

