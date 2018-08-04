package nam2504.QualificationRound

import nam2504.common.utils.FileUtils

/***
  * Link : https://code.google.com/codejam/contest/3264486/dashboard
  *
  * Problem
  * Last year, the Infinite House of Pancakes introduced a new kind of pancake. It has a happy face made of chocolate chips on one side (the "happy side"), and nothing on the other side (the "blank side").
  * You are the head cook on duty. The pancakes are cooked in a single row over a hot surface. As part of its infinite efforts to maximize efficiency, the House has recently given you an oversized pancake flipper that flips exactly K consecutive pancakes. That is, in that range of K pancakes, it changes every happy-side pancake to a blank-side pancake, and vice versa; it does not change the left-to-right order of those pancakes.
  * You cannot flip fewer than K pancakes at a time with the flipper, even at the ends of the row (since there are raised borders on both sides of the cooking surface). For example, you can flip the first K pancakes, but not the first K - 1 pancakes.
  * Your apprentice cook, who is still learning the job, just used the old-fashioned single-pancake flipper to flip some individual pancakes and then ran to the restroom with it, right before the time when customers come to visit the kitchen. You only have the oversized pancake flipper left, and you need to use it quickly to leave all the cooking pancakes happy side up, so that the customers leave feeling happy with their visit.
  * Given the current state of the pancakes, calculate the minimum number of uses of the oversized pancake flipper needed to leave all pancakes happy side up, or state that there is no way to do it.
  *
  * Input
  * The first line of the input gives the number of test cases, T. T test cases follow. Each consists of one line with a string S and an integer K. S represents the row of pancakes: each of its characters is either + (which represents a pancake that is initially happy side up) or - (which represents a pancake that is initially blank side up).
  *
  * Output
  * For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is either IMPOSSIBLE if there is no way to get all the pancakes happy side up, or an integer representing the the minimum number of times you will need to use the oversized pancake flipper to do it.
  */
class OversizedPancakeFlipper {
	val IMPOSSIBLE: Int = -1
	def flip(data : Array[Boolean], k : Int) : Int = {
		println(data.mkString(","))
		var index = 0
		var flip = 0
		
		def flipAt(index : Int) = {
			// flip at index :
			flip += 1
			for ( i <- index until index + k) {
				data(i) = !data(i)
			}
//			println(data.mkString(","))
		}
		
		while (index < data.length) {
			if (!data(index)) {
				// if can flip :
				if ( index + k > data.length) {
					if (index != data.length) return IMPOSSIBLE
					else return flip
				} else {
					flipAt(index)
				}
			}
			index += 1
		}
		flip
	}
	
	/***
	  * Convert String to list boolean ang flip
	  * @param line : Ex: -+-- 3 =+ false,true,false,false ; 3
	  * @return Count of flip to all happy (+)
	  */
	def flip(line : String) : Int = {
		val Array(str_data, str_k) = line.split(" ")
		val data = str_data.toCharArray.map(c => c.equals('+'))
//		println(data)
		val k = str_k.toInt
		flip(data, k)
	}
	
	def excute(file : String) = {
		val reader = FileUtils.getReader(file)
		val n = reader.readLine().toInt
		for (i <- 1 to n) {
			val line = reader.readLine()
			val result = flip(line)
			println(s"Case #$i : $result")
		}
		reader.close()
	}
}

object OversizedPancakeFlipperTest {
	val service = new OversizedPancakeFlipper()
	def main(args: Array[String]): Unit = {
//		val result = service.flip(Array(true,false,false,true,false), 6)
//		val result = service.flip("---+-++- 3")
//		println(result)
		val path = 
		service.excute()
	}
}