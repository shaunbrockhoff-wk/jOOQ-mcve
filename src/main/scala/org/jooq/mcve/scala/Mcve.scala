/*
 * This file is generated by jOOQ.
 */
package org.jooq.mcve.scala


import java.util.Arrays
import java.util.List

import org.jooq.Catalog
import org.jooq.Table
import org.jooq.impl.SchemaImpl
import org.jooq.mcve.scala.tables.Test


object Mcve {

  /**
   * The reference instance of <code>MCVE</code>
   */
  val MCVE = new Mcve
}

/**
 * This class is generated by jOOQ.
 */
class Mcve extends SchemaImpl("MCVE", DefaultCatalog.DEFAULT_CATALOG) {

  /**
   * The table <code>MCVE.TEST</code>.
   */
  lazy val TEST = Test.TEST

  override def getCatalog: Catalog = DefaultCatalog.DEFAULT_CATALOG

  override def getTables: List[Table[_]] = {
    return Arrays.asList[Table[_]](
      Test.TEST)
  }
}
