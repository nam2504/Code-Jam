package nam2504.common.utils

import java.io._

import nam2504.common.log.LogHelper

object FileUtils extends LogHelper{
	def getReader(path: String): BufferedReader = {
		try {
			new BufferedReader(new FileReader(path))
		} catch {
			case ex: Exception =>
				logger.error(ex)
				null
		}
	}
	
	def getWriter(path: String, isOverwrite: Boolean = true): PrintWriter = {
		try {
			val file = new File(path)
			if (file.exists && isOverwrite) file.delete
			new File(path).getParentFile.mkdirs
			new PrintWriter(new BufferedWriter(new FileWriter(path, true)))
		} catch {
			case ex: Exception =>
				logger.error(ex)
				null
		}
	}
}
