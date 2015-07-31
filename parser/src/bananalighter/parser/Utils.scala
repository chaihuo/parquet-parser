package bananalighter.parser

import java.io._

/**
 * Created by root on 15-7-30.
 */
object Utils {
//  private val LOG: Log = Log.getLog(classOf[Utils])

  def closeQuietly(res: Closeable) {
    try {
      if (res != null) {
        res.close
      }
    }
    catch {
      case ioe: IOException => {
//        LOG.warn("Exception closing reader " + res + ": " + ioe.getMessage)
      }
    }
  }
//
//  @throws(classOf[IOException])
//  def writePerfResult(module: String, millis: Long) {
//    var writer: PrintWriter = null
//    try {
//      val outputFile: File = new File("target/test/perftime." + module + ".txt")
//      outputFile.delete
//      writer = new PrintWriter(outputFile)
//      writer.write(String.valueOf(millis))
//    } finally {
//      closeQuietly(writer)
//    }
//  }
//
//  @throws(classOf[IOException])
//  def readPerfResult(version: String, module: String): Long = {
//    var reader: BufferedReader = null
//    try {
//      val inFile: File = new File("../" + version + "/target/test/perftime." + module + ".txt")
//      reader = new BufferedReader(new FileReader(inFile))
//      return Long.parseLong(reader.readLine)
//    } finally {
//      closeQuietly(reader)
//    }
//  }
//
//  @throws(classOf[IOException])
//  def createTestFile(largerThanMB: Long): File = {
//    val outputFile: File = new File("target/test/csv/perftest.csv")
//    if (outputFile.exists) {
//      return outputFile
//    }
//    val toCopy: File = new File("../parquet-testdata/tpch/customer.csv")
//    FileUtils.copyFile(new File("../parquet-testdata/tpch/customer.schema"), new File("target/test/csv/perftest.schema"))
//    var output: OutputStream = null
//    var input: InputStream = null
//    try {
//      output = new BufferedOutputStream(new FileOutputStream(outputFile, true))
//      input = new BufferedInputStream(new FileInputStream(toCopy))
//      input.mark(Integer.MAX_VALUE)
//      while (outputFile.length <= largerThanMB * 1024 * 1024) {
//        IOUtils.copy(input, output)
//        input.reset
//      }
//    } finally {
//      closeQuietly(input)
//      closeQuietly(output)
//    }
//    return outputFile
//  }
//
//  def getAllOriginalCSVFiles: Array[File] = {
//    val baseDir: File = new File("/root/IdeaProjects/parquet-compatibility/parquet-testdata/tpch")
//    val csvFiles: Array[File] = baseDir.listFiles(new FilenameFilter() {
//      def accept(dir: File, name: String): Boolean = {
//        return name.endsWith(".csv")
//      }
//    })
//    return csvFiles
//  }
//
//  @throws(classOf[IOException])
//  def getAllPreviousVersionDirs: Array[String] = {
//    val baseDir: File = new File("..")
//    val currentVersion: String = getCurrentVersion
//    val versions: Array[String] = baseDir.list(new FilenameFilter() {
//      def accept(dir: File, name: String): Boolean = {
//        return name.startsWith("parquet-compat-") && new Utils.Version(name.replace("parquet-compat-", "")).compareTo(new Utils.Version(currentVersion)) < 0
//      }
//    })
//    return versions
//  }
//
//  private[parser] object Version {
//
//    private object ComparisonChain {
//      private[parser] def start: Utils.Version#ComparisonChain = {
//        return new Utils.Version#ComparisonChain(0)
//      }
//    }
//
//    private class ComparisonChain {
//      private[parser] var result: Int = 0
//
//      private def this(result: Int) {
//        this()
//        this.result = result
//      }
//
//      private[parser] def compare(a: String, b: String): Utils.Version#ComparisonChain = {
//        if (result != 0) {
//          return this
//        }
//        if (b == null) {
//          if (a != null) result = 1
//          else result = 0
//        }
//        else if (a == null) {
//          result = 1
//        }
//        else if (result == 0) {
//          result = a.compareTo(b)
//        }
//        return this
//      }
//
//      private[parser] def compare(a: Int, b: Int): Utils.Version#ComparisonChain = {
//        if (result == 0) {
//          result = Integer.compare(a, b)
//        }
//        return this
//      }
//
//      private[parser] def result: Int = {
//        return result
//      }
//    }
//
//  }
//
//  private[parser] class Version extends Comparable[Utils.Version] {
//    private[parser] var major: Int = 0
//    private[parser] var minor: Int = 0
//    private[parser] var minorminor: Int = 0
//    private[parser] var tag: String = null
//
//    private[parser] def this(versionStr: String) {
//      this()
//      val versions: Array[String] = versionStr.split("\\.")
//      val size: Int = versions.length
//      if (size > 0) {
//        this.major = versions(0).toInt
//      }
//      if (size > 1) {
//        this.minor = versions(1).toInt
//      }
//      if (size > 2) {
//        if (versions(2).contains("-")) {
//          val minorMin: Array[String] = versions(2).split("-")
//          this.minorminor = minorMin(0).toInt
//          this.tag = minorMin(1)
//        }
//        else {
//          this.minorminor = versions(2).toInt
//        }
//      }
//      if (size == 4) {
//        this.tag = versions(3)
//      }
//      if (size > 4) {
//        throw new RuntimeException("Illegal version number " + versionStr)
//      }
//    }
//
//    def compareMajorMinor(o: Utils.Version): Int = {
//      return Version.ComparisonChain.start.compare(major, o.major).compare(minor, o.minor).result
//    }
//
//    def compareTo(o: Utils.Version): Int = {
//      return Version.ComparisonChain.start.compare(major, o.major).compare(minor, o.minor).compare(minorminor, o.minorminor).compare(tag, o.tag).result
//    }
//  }
//
//  def getParquetOutputFile(name: String, module: String, deleteIfExists: Boolean): File = {
//    val outputFile: File = new File("target/parquet/", getParquetFileName(name, module))
//    outputFile.getParentFile.mkdirs
//    if (deleteIfExists) {
//      outputFile.delete
//    }
//    return outputFile
//  }
//
//  private def getParquetFileName(name: String, module: String): String = {
//    return name + (if (module != null) "." + module else "") + ".parquet"
//  }
//
//  @throws(classOf[IOException])
//  def getParquetFile(name: String, version: String, module: String, failIfNotExist: Boolean): File = {
//    val parquetFile: File = new File("../" + version + "/target/parquet/", getParquetFileName(name, module))
//    parquetFile.getParentFile.mkdirs
//    if (!parquetFile.exists) {
//      val msg: String = "File " + parquetFile.getAbsolutePath + " does not exist"
//      if (failIfNotExist) {
//        throw new IOException(msg)
//      }
//      LOG.warn(msg)
//    }
//    return parquetFile
//  }
//
//  @throws(classOf[IOException])
//  private def getCurrentVersion: String = {
//    return new File(".").getCanonicalFile.getName.replace("parquet-compat-", "")
//  }
//
//  @throws(classOf[IOException])
//  def getImpalaDirectories: Array[String] = {
//    val baseDir: File = new File("../parquet-testdata/impala")
//    val currentVersion: String = getCurrentVersion
//    val impalaVersions: Array[String] = baseDir.list(new FilenameFilter() {
//      def accept(dir: File, name: String): Boolean = {
//        if (name.startsWith(".")) {
//          return false
//        }
//        if (name.contains("-")) {
//          name = name.split("-")(0)
//        }
//        return new Utils.Version(name).compareMajorMinor(new Utils.Version(currentVersion)) == 0
//      }
//    })
//    return impalaVersions
//  }
//
//  @throws(classOf[IOException])
//  def getParquetImpalaFile(name: String, impalaVersion: String): File = {
//    val fileName: String = name + ".impala.parquet"
//    val parquetFile: File = new File("../parquet-testdata/impala/" + impalaVersion, fileName)
//    if (!parquetFile.exists) {
//      throw new IOException("File " + fileName + " does not exist")
//    }
//    return parquetFile
//  }
//
//  def getFileNamePrefix(file: File): String = {
//    return file.getName.substring(0, file.getName.indexOf("."))
//  }
//
//  def getCsvTestFile(name: String, module: String, deleteIfExists: Boolean): File = {
//    val outputFile: File = new File("target/test/csv/", name + (if (module != null) "." + module else "") + ".csv")
//    outputFile.getParentFile.mkdirs
//    if (deleteIfExists) {
//      outputFile.delete
//    }
//    return outputFile
//  }
//
//  def getParquetTestFile(name: String, module: String, deleteIfExists: Boolean): File = {
//    val outputFile: File = new File("target/test/parquet/", name + (if (module != null) "." + module else "") + ".csv")
//    outputFile.getParentFile.mkdirs
//    if (deleteIfExists) {
//      outputFile.delete
//    }
//    return outputFile
//  }
//
//  @throws(classOf[IOException])
//  def verify(expectedCsvFile: File, outputCsvFile: File) {
//    var expected: BufferedReader = null
//    var out: BufferedReader = null
//    try {
//      expected = new BufferedReader(new FileReader(expectedCsvFile))
//      out = new BufferedReader(new FileReader(outputCsvFile))
//      var lineIn: String = null
//      var lineOut: String = null
//      var lineNumber: Int = 0
//      while ((({
//        lineIn = expected.readLine; lineIn
//      })) != null && (({
//        lineOut = out.readLine; lineOut
//      })) != null) {
//        lineNumber += 1
//        lineOut = lineOut.substring(lineOut.indexOf("\t") + 1)
//        assertEquals("line " + lineNumber, lineIn, lineOut)
//      }
//      assertNull("line " + lineNumber, lineIn)
//      assertNull("line " + lineNumber, out.readLine)
//    } finally {
//      Utils.closeQuietly(expected)
//      Utils.closeQuietly(out)
//    }
//  }
//
//  @throws(classOf[IOException])
//  def verify(expectedCsvFile: File, outputCsvFile: File, orderMatters: Boolean) {
//    if (!orderMatters) {
//      verify(sortFile(expectedCsvFile), sortFile(outputCsvFile))
//    }
//    else verify(expectedCsvFile, outputCsvFile)
//  }
//
//  @throws(classOf[IOException])
//  private def sortFile(inFile: File): File = {
//    val sortedFile: File = new File(inFile.getAbsolutePath.concat(".sorted"))
//    val reader: BufferedReader = new BufferedReader(new FileReader(inFile))
//    val out: PrintWriter = new PrintWriter(new FileWriter(sortedFile))
//    try {
//      var inputLine: String = null
//      val lineList: List[String] = new util.ArrayList[String]
//      while ((({
//        inputLine = reader.readLine; inputLine
//      })) != null) {
//        lineList.add(inputLine)
//      }
//      Collections.sort(lineList)
//      import scala.collection.JavaConversions._
//      for (outputLine <- lineList) {
//        out.println(outputLine)
//      }
//      out.flush
//    } finally {
//      closeQuietly(reader)
//      closeQuietly(out)
//    }
//    return sortedFile
//  }
}
