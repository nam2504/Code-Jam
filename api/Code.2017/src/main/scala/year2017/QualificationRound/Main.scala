package year2017.QualificationRound

object Main {
	val service = new OversizedPancakeFlipper()
	def main(args: Array[String]): Unit = {
		val result = service.flip(Array(true,false,false,true,false), 6)
		//		val result = service.flip("---+-++- 3")
		//		println(result)
		val pathSmall = "..\\Code.2017\\DataTest\\Oversized Pancake Flipper\\A-small-practice.in"
		service.excute(pathSmall)
		val pathLarge = "..\\Code.2017\\DataTest\\Oversized Pancake Flipper\\A-large-practice.in"
		service.excute(pathLarge)
	}
}
