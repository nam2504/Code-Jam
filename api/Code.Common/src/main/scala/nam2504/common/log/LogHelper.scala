package nam2504.common.log

import org.apache.log4j.Logger

trait LogHelper {
	val loggerName = this.getClass.getName
	lazy val logger = Logger.getLogger(loggerName)
}