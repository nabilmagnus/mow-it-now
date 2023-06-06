package fr.publicis.sapient.mowitnow.tools.logging

import org.apache.log4j.Logger

/**
 * Implement Logger
 */
trait Logging {
  val LOGGER: Logger = Logger.getLogger(this.getClass.getName)
}
