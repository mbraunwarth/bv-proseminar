import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

fun main(args: Array<String>) {
    val img = ImageIO.read(File("data/iron-man.jpg"))
    convertToGrayscale(img)
    showImage(img)
}

fun gauss(img: BufferedImage) {
    val mask = arrayOf(
            intArrayOf(1,2,1),
            intArrayOf(2,4,2),
            intArrayOf(1,2,1)
    )
//    for (i in 1 until img.width-1)
//        for (j in 1 until img.height-1)
//            for (m in -1 until 1)
//                for (n in -1 until 1)

}