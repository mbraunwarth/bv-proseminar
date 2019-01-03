import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

fun main(args: Array<String>) {
    val img = ImageIO.read(File("data/iron-man.jpg"))
    val mask = arrayOf(
            arrayOf(0,-1,0),
            arrayOf(-1,5,-1),
            arrayOf(0,-1,0)
    )

//    convertToGrayscale(img)
    showImage(conv(img, mask))
//    showImage(img)
}

fun conv(img: BufferedImage, mask: Array<Array<Int>>) : BufferedImage {
    val m_size = mask.size/2
    val out = BufferedImage(img.width, img.height, img.type)

    for (i in m_size until img.width-m_size) {
        for (j in m_size until img.height-m_size) {
            var rgb = 0
            for (m in 0 until mask.size) {
                for (n in 0 until mask.size) {
                    rgb += img.getRGB(i, j) * mask[m][n]
                }
            }
            out.setRGB(i, j, rgb)
        }
    }
    return out
}

fun gauss(img: BufferedImage) {
    val mask = arrayOf(
            intArrayOf(1,2,1),
            intArrayOf(2,4,2),
            intArrayOf(1,2,1)
    )
}