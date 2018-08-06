package year2017.QualificationRound

import nam2504.common.utils.FileUtils

class BathroomStalls {
	def findMax(n : Long, k : Long, step : Long = 0, l : Long = 0, r : Long = 0) : (Long, Long) = {
		if (k < 0) {
			return (l, r)
		}else {
			val new_k = (k - Math.pow(2, step)).toInt
			var l, r : Long = 0
			if ( n % 2 == 0) {
				l =  n / 2
				r = l - 1
			}
			else {
				l = n / 2
				r = l
			}
			if (k == 1) {
				return (l, r)
			} else {
				findMax(Math.max(l , r), new_k, step + 1,  l, r)
			}
		}
		
	}
	
	def findMax(line : String) : (Long, Long) = {
		val Array(n, k) = line.split(" ")
		findMax(n.toLong, k.toLong)
	}
	
	def test: Unit = {
		val (l1, r1) = findMax(1000,1)
		println(s"Case #1: $l1, $r1")
	}
	
	def excute(file : String) = {
		val reader = FileUtils.getReader(file)
		val writer = FileUtils.getWriter(file.replace("in","out"))
		val n = reader.readLine().toInt
		for (i <- 1 to n) {
			val line = reader.readLine()
			val result = findMax(line)
			writer.println(s"Case #$i: ${ result._1} ${result._2}")
		}
		reader.close()
		writer.close()
	}
}

object BathroomStallsTest {
	val service = new BathroomStalls()
	def main(args: Array[String]): Unit = {
		service.test
		
		val pathSmall1 = "D:\\Source\\api\\Code-Jam\\api\\DataTest\\BathroomStallsTest\\C-small-practice-1.in"
		service.excute(pathSmall1)
		val pathSmall2 = "D:\\Source\\api\\Code-Jam\\api\\DataTest\\BathroomStallsTest\\C-small-practice-2.in"
		service.excute(pathSmall2)
		val pathLarge = "D:\\Source\\api\\Code-Jam\\api\\DataTest\\BathroomStallsTest\\C-large-practice.in"
		service.excute(pathLarge)
	}
}