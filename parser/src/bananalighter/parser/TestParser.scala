package bananalighter.parser

import java.io.{IOException, File}

/**
 * Created by root on 15-7-31.
 */
object TestParser {
  def main(args: Array[String]) {
    val schema: File = new File("/root/IdeaProjects/parquet-parser/parser/testdata/parquet.schema")
    val output: File = new File("/root/IdeaProjects/parquet-parser/parser/testdata/output.parquet")
    try {
      MysqlConvertUtils.convertSQLToParquet(schema, output)
    }
    catch {
      case e: IOException => {
        e.printStackTrace
      }
    }
  }
}
