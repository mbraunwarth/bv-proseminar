import javax.imageio.ImageIO
import javax.swing.*
import java.awt.*
import java.awt.image.BufferedImage
import java.io.File
import java.io.IOException

const val IMAGE: String = "data/iron-man.jpg"

private fun applyPixelWise(img: BufferedImage, func: (Int) -> Int) {
    for (i in 1 until img.width - 1) {
        for (j in 1 until img.height - 1) {
            img.setRGB(i, j, func(img.getRGB(i, j)))
        }
    }
}

fun main(args: Array<String>) {
    println("-- Image Processing --")
    println("Running")

    createNewImages()



    println("Done")
}

private fun createNewImages() {
    try {
        val img = ImageIO.read(File(IMAGE))
        ImageIO.write(img, "jpg", File("data/copy.png"))
        val bright = img.copy()
        val dark = img.copy()

        // create brighter image
        applyPixelWise(bright) {
            Color(it).brighter().rgb
        }
        ImageIO.write(bright, "jpg", File("data/brighter.png"))

        // create darker image
        applyPixelWise(dark) {
            Color(it).darker().rgb
        }
        ImageIO.write(dark, "jpg", File("data/darker.png"))


//        showImage(img)
    } catch (e: IOException) {
        e.printStackTrace()
    }
}

fun BufferedImage.copy() = this.getSubimage(0, 0, this.width, this.height)